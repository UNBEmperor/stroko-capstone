#ifdef ESP32
  #include <WiFi.h>
#else
#include <ESP8266WiFi.h>
#endif

#include <PubSubClient.h>
#include <DHT.h>

#define WIFI_SSID "POCOPHONE"
#define WIFI_PASSWORD "85208520"

#define MQTT_SERVER "203.194.112.215"
#define MQTT_PORT 1883
#define MQTT_USER "myiot"
#define MQTT_PASS "12345678"


#define MQTT_TOPIC_PUBLISH "myiot/temperature"
#define MQTT_TOPIC_SUBCRIBE "myiot/led"
#define LED 4
#define DHTPIN 5
#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);
WiFiClient espClient;
PubSubClient client(espClient);

void connectToWifi()
{
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(350);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
}


void reconnectToMqtt()
{
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    String clientId = "MyIoT";
    clientId += String(random(0xffff), HEX);
    if (client.connect(clientId.c_str(),MQTT_USER,MQTT_PASS)) {
      Serial.println("connected");
      client.publish(MQTT_TOPIC_PUBLISH, "hello world");
      client.subscribe(MQTT_TOPIC_SUBCRIBE);
    }
    else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      delay(5000);
    }
  }
}

void setupLamp(char* topic, byte *payload, unsigned int length)
{

   if (!strcmp(topic, MQTT_TOPIC_SUBCRIBE)) {
        if (!strncmp((char *)payload, "on", length)) {
            digitalWrite(LED, HIGH);
        } else if (!strncmp((char *)payload, "off", length)) {
            digitalWrite(LED, LOW);
        }
    }
    
}

void callback(char* topic, byte *payload, unsigned int length) {
  Serial.println("-------new message from broker-----");
  Serial.print("channel:");
  Serial.println(topic);
  Serial.print("data:");
  Serial.write(payload, length);
  Serial.println();
  setupLamp(topic,payload, length);
}


void publishSerialData(char *serialData){
  if (!client.connected()) {
    reconnectToMqtt();
  }
  client.publish(MQTT_TOPIC_PUBLISH, serialData);
}

void setup() {
  Serial.begin(9600);
  dht.begin();
  connectToWifi();
  client.setServer(MQTT_SERVER, MQTT_PORT);
  client.setCallback(callback);
  reconnectToMqtt();
  pinMode(LED, OUTPUT);
}


void loop() {
  float h = dht.readHumidity();
  float t = dht.readTemperature();
 
  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print("\n");
  Serial.print(F(" Temperature: "));
  Serial.print(t);
  Serial.print(F("°C "));
client.loop();

client.publish(MQTT_TOPIC_PUBLISH,String(t).c_str());

if (Serial.available() > 0) {
  char bfr[101];
  memset(bfr,0, 101);
  Serial.readBytesUntil( '\n',bfr,100);
  publishSerialData(bfr);
  }
}