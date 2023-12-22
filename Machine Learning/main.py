import tensorflow as tf
import sklearn
from flask import Flask, jsonify, request
from werkzeug.utils import secure_filename
import keras
from keras.models import load_model
from keras.layers import Dropout
import numpy as np
from PIL import Image
import pandas as pd
from sklearn.preprocessing import StandardScaler

with keras.utils.custom_object_scope({'FixedDropout': Dropout}):
    model_food_rec = keras.models.load_model("Model_Rekomendasi.h5")
    model_stroke_det = keras.models.load_model("Model_Klasifikasi.h5")

app = Flask(__name__)


label = ['AP005','AP009','AP010','AP024','AP027','AP028','AP035','AP037','AP038','AP043','AP052','AP070','AP085','AP096','AP111','AP114','BP003','BP004','BP006','BP017','BP037','BP047','BP050','BP053','BP076','CP003','CP004','CP009','CP011','CP014','CP015','CP031','CP035','CP038','CP058','CP061','CP072','CP076','DP001','DP002','DP003','DP005','DP007','DP008','DP009','DP010','DP011','DP013','DP015','DP016','DP018','DP019','DP020','DP021','DP040','DP048','DP049','DP051','DP055','ER003','ER004','ER007','ER013','ER016','ER017','ER022','ER030','ER031','ER035','ER038','ER039','ER040','ER052','ER057','ER058','ER063','ER064','FP005','FP011','GP003','GP005','GP012','GP017','GP020','GP021','GP029','GP040','GP047','GP049','GP086','GP088','GP089','GP094','HP003','MP016','MP017','MP018']



@app.route("/")
def index():
    return jsonify({
        "status": {
            "code": 200,
            "message": "Success fetching the API",
        },
        "data": None
    }), 200

@app.route("/prediction/stroke-detection", methods=["GET", "POST"])
def predict_stroke_detection():
    if request.method == "POST":
        # Get input data from the request (modify as needed)
        input_data = request.json  # Assuming input data is sent as JSON, adjust if needed
    
        scaler = StandardScaler()
        sample_input = np.array(list(input_data.values())).reshape(1, -1)
        scaledDataSample = scaler.fit_transform(sample_input)
        prediction_detection = model_stroke_det.predict(scaledDataSample)
        # # Preprocess the input data to match the model's input shape
        
        # # Assuming the output is a binary classification (0 or 1)
        diagnosis = np.argmax(prediction_detection)
        hasil=0
        if (diagnosis == 0):
            hasil="Resiko Rendah"
        else:
            hasil="Resiko Tinggi"


        return jsonify({
                "status": {"code": 200, "message": "Success predicting"},
                "data": {
                    "Diagnosis": hasil
                }
        }), 200
    else:
        return jsonify({
            "status": {"code": 405, "message": "Method not allowed"},
            "data": None,
        }), 405
    



@app.route("/prediction/food-recommendation", methods=["GET", "POST"])

def prediction():
    if request.method == "POST":
        InputUserArray = request.json
            
        scaler = StandardScaler()
        X_input = np.array(list(InputUserArray.values())).reshape(1, -1)
        InputUserArray = scaler.fit_transform(X_input)
        prediction = model_food_rec.predict(X_input)
        index = np.argmax(prediction)
        print(index)
        Kode_Pangan = label[index]
        Data_Makanan = pd.read_csv('Data Makanan Indonesia.csv')
        DataFrameHasil = Data_Makanan[Data_Makanan['Kode Pangan'] == Kode_Pangan]
        DataFrameHasil = DataFrameHasil.iloc[0]
        Output_Array = DataFrameHasil.values
        print(Output_Array)
        # print(InputUserArray)

        return jsonify({
            "status": {
                "code": 200,
                "message": "Success predicting",
            },
            "data": {
                "Nama Makanan": Output_Array[1],
                "Lemak" : Output_Array[2],
                "Karbohidrat" : Output_Array[3],
                "Serat" : Output_Array[4],
                "Natrium" : Output_Array[5],
                "Kalium" : Output_Array[6],
                "Keterangan" : Output_Array[7],
                "Link" : Output_Array[8],
            }
        }), 200
    elif ():
        return jsonify({
            "status": {
                "code": 400,
                "message": "Client side error"
            },
            "data": None
        }), 400
    else:
        return jsonify({
            "status": {
                "code": 405,
                "message": "Method not allowed"
            },
            "data": None,
        }), 405


    if __name__ == "__main__":
    #    app = create_app()
        print(" Starting app...")
        app.run(host="0.0.0.0", port=8080)




