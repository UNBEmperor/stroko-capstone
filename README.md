# **CH2-PS208 STROKO APP**

<div style="text-align:center;"><img src="https://drive.google.com/uc?id=1EChzBCWfsz1ymbe4NXKmgdfiCehnFcC-" alt="STROKO Logo" style="width:200px;height:200px;"></div>

## **Background**
According to the World Health Organization (WHO) in 2019, stroke is the leading cause of death in Indonesia. In an effort to reduce the impact of stroke and increase awareness of prevention and management, we present the STROKO application.

## **Features**
- Stroke Detection
- Food Recommendation
- Articles

# **DOCUMENTATION**
## **STROKO**
### Figma : https://www.figma.com/design/ZbBW2OWsR0YnxEmdcuRFAb/CAPSTONE?node-id=0-1
<img src="https://github.com/UNBEmperor/stroko-capstone/assets/97173485/c46cafe1-224e-4b91-899a-e45cf76c3ce3" width="225"> <img src="https://github.com/UNBEmperor/stroko-capstone/assets/97173485/0568ea28-2a0a-449d-a4af-12ef1d0ac7d7" width="225"> <img src="https://github.com/UNBEmperor/stroko-capstone/assets/97173485/cfddfb57-e5de-4346-8350-459b7d0481d7" width="225"> <img src="https://github.com/UNBEmperor/stroko-capstone/assets/97173485/84ab7f64-e44d-4ed5-8b0d-92400333a664" width="225">

## **Cloud Architecture**
![Nama Gambar](https://github.com/UNBEmperor/stroko-capstone/assets/97173485/ce762e8a-e7ca-40f3-ae32-ce224fb6a5dd)

## **API Reference**
### **SignUp**

- Method: POST
- Endpoint: /api/auth/signup
- Request Body:

  - `"email"`: `'string'`, must be unique and using email format
  - `"username"`: `'string'`
  - `"password"`: `'string'`, must be at least 8 characters

- Response:

```json
{
  "status": 201,
  "message": "User registered successfully"
}
```

### **SignIn**

- Method: POST
- Endpoint: /api/auth/signin
- Request Body:

  - `"email"`: `'string'`
  - `"password"`: `'string'`

- Response:

```json
{
  "status": 200,
  "id": "1",
  "message": "User logged successfully",
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```

### **Stroke Assessment**

- Method: POST
- Endpoint: /api/stroke-assessment
- Header: x-access-token
- Request Body:

  - `"idUsers"`: `'int'` (Auto fill with userId),
  - `"nama"`: `'string'`
  - `"usia"`: `'int'`
  - `"gender"`: `'bool'`
  - `"levelBMI"`: `'bool'`
  - `"hipertensi"`: `'bool'`
  - `"diabetes"`: `'bool'`
  - `"penyakitJantung"`: `'bool'`
  - `"riwayatStrokePribadi"`: `'bool'`
  - `"riwayatStrokeKeluarga"`: `'bool'`
  - `"merokok"`: `'string'` (enum)
  - `"konsumsiAlkohol"`: `'string'` (enum)
  - `"aktivitasFisik"`: `'string'` (enum)

- Response:

```json
{
  "status": 201,
  "message": "StrokeAssessment created successfully",
  "data": {
    "prediksiStroke": false,
    "id": 1,
    "idUsers": 2,
    "nama": "Vlad",
    "usia": 61,
    "gender": false,
    "levelBMI": 23,
    "hipertensi": false,
    "diabetes": false,
    "penyakitJantung": false,
    "riwayatStrokePribadi": false,
    "riwayatStrokeKeluarga": false,
    "merokok": "0",
    "konsumsiAlkohol": "1",
    "aktivitasFisik": "2",
    "updatedAt": "2023-12-13T10:44:17.896Z",
    "createdAt": "2023-12-13T10:44:17.896Z"
  }
}
```

### **Stroke Assessment History**

- Method: GET
- Endpoint: /api/stroke-assessment-history
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "id": 1,
      "idUsers": 2,
      "nama": "Vlad",
      "usia": 61,
      "gender": false,
      "levelBMI": 23,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": false,
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": false,
      "merokok": "0",
      "konsumsiAlkohol": "1",
      "aktivitasFisik": "2",
      "prediksiStroke": false,
      "createdAt": "2023-12-13T10:44:17.000Z",
      "updatedAt": "2023-12-13T10:44:17.000Z"
    },
    {
      "id": 2,
      "idUsers": 2,
      "nama": "Konstantin",
      "usia": 41,
      "gender": false,
      "levelBMI": 21,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": true,
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": true,
      "merokok": "1",
      "konsumsiAlkohol": "3",
      "aktivitasFisik": "2",
      "prediksiStroke": false,
      "createdAt": "2023-12-13T10:46:19.000Z",
      "updatedAt": "2023-12-13T10:46:19.000Z"
    }
  ]
}
```

### **Stroke Assessment History Delete**

- Method: DELETE
- Endpoint: /api/stroke-assessment-history/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "message": "Stroke Assessment was deleted successfully!",
  "id": 13
}
```

### **Generate Food Recommendation**

- Method: GET
- Endpoint: /api/food-recommendation/:strokeAssessmentId
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": {
    "Kalium": 0.14,
    "Karbohidrat": 4.8,
    "Keterangan": "Daun Singkong Rebus adalah sayuran yang dimasak dengan cara direbus.",
    "Lemak": 0.6,
    "Link": "https://www.bantennews.co.id/wp-content/uploads/2019/06/Screenshot_2019-06-16-00-14-40-190_org.detikcom.rss_.jpg",
    "Nama Makanan": "Daun Singkong Rebus",
    "Natrium": 0.13,
    "Serat": 1.6
  }
}
```

### **Food Recommendation History**

- Method: GET
- Endpoint: /api/food-recommendation-history/:strokeAssessmentId
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "id": 1,
      "idStrokeAssessment": 1,
      "namaMakanan": "Daun Singkong Rebus",
      "lemak": 0.6,
      "karbohidrat": 4.8,
      "natrium": 0.13,
      "kalium": 0.14,
      "serat": 1.6,
      "keterangan": "Daun Singkong Rebus adalah sayuran yang dimasak dengan cara direbus.",
      "link": "https://www.bantennews.co.id/wp-content/uploads/2019/06/Screenshot_2019-06-16-00-14-40-190_org.detikcom.rss_.jpg",
      "createdAt": "2023-12-21T09:54:43.000Z",
      "updatedAt": "2023-12-21T09:54:43.000Z"
    }
  ]
}
```

### **Food Recommendation Delete**

- Method: DELETE
- Endpoint: /api/food-recommendation-history/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "message": "Food Recommendation was deleted successfully!",
  "id": 3
}
```

### **Health Education Preview**

- Method: GET
- Endpoint: /api/health-education
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "id": 1,
      "judulArtikel": "Sample Title 1",
      "tanggal": "15-12-2023",
      "penerbit": "Publisher Name 1",
      "fotoArtikel": "https://example.com/image1.jpg"
    },
    {
      "id": 2,
      "judulArtikel": "Sample Title 2",
      "tanggal": "16-12-2023",
      "penerbit": "Publisher Name 2",
      "fotoArtikel": "https://example.com/image2.jpg"
    }
  ]
}
```

### **Health Education Detail**

- Method: GET
- Endpoint: /api/health-education/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": {
    "id": 2,
    "judulArtikel": "Sample Title 2",
    "isiArtikel": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla vel enim faucibus consectetur eu et quam. \n\nMorbi quis vehicula libero. Cras vulputate condimentum eros, eu consectetur tortor.",
    "tanggal": "16-12-2023",
    "penerbit": "Publisher Name 2",
    "penulis": "Author Name 2",
    "fotoArtikel": "https://example.com/image2.jpg",
    "createdAt": "2023-12-17T07:12:05.000Z",
    "updatedAt": "2023-12-17T07:12:05.000Z"
  }
}
```

## **Machine Learning Model**
### **1. Stroke Detection**
Stroke Detection is a feature designed to detect an individual based on user input data. Stroke Detection utilizes a classification method with Artificial Neural Network.
- Libraries
   - Pandas 1.5.3
   - Numpy 1.23.5
   - Tensorflow 2.15.0
   - Matolotlib 3.7.1
   - Scikit Learn 1.2.2
- Dataset Column
   - Umur
   - Jenis Kelamin
   - Hipertensi
   - Penyakit Jantung
   - Average Glucose Level
   - BMI
   - Status Merokok
   - Konsumsi Alkohol
   - Aktivitas Fisik
   - Riwayat Resiko Tinggi
   - Riwayat Resiko Tinggi Keluarga
   - Diagnosis
- Method
   - **Standard Scaler**
      >> Standard Scaler is a data preprocessing method used to standardize numerical features in a dataset. The goal of the Standard Scaler is to ensure that each feature has a mean of 0 and a standard deviation of 1. This is achieved by subtracting the mean of each feature and then dividing it by the standard deviation.
   - **Binary Logistic Regression**.
      >> Binary Logistic Regression is the chosen classification method. Logistic regression is a statistical model used to predict the probability of a binary outcome based on one or more independent variables. It is commonly used for binary classification tasks where the dependent variable has two classes. In this case, it will be used to classify the diagnosis outcome based on the given features.
      The logistic regression model estimates the probability of the positive class (in this case, the diagnosis) using a logistic function. The model learns the coefficients associated with each independent variable, which represent the impact of each variable on the probability of the positive class."
### **2. Food Recommendation**
Food Recommendation is a recommendation system using Content-Based Filtering in accordance with user preferences, specifically the user's medical history data. This recommendation system will provide output in the form of labels, which represent food codes recommended for consumption by the user.
- Libraries
   - Pandas 1.5.3
   - Numpy 1.23.5
   - Tensorflow 2.15.0
   - Matolotlib 3.7.1
   - Scikit Learn 1.2.2
- Dataset Patient
   - id
   - gender
   - age
   - hypertension
   - heart_disease
   - avg_glucose_level
   - bmi
   - food_code
- Dataset Food
   - Kode Pangan
   - Nama Pangan
   - Lemak
   - Karbohidrat
   - Serat
   - Natrium
   - Kalium
   - Keterangan
   - link
- Method
   - **Standard Scaler**
      >> Standard Scaler is a data preprocessing method used to standardize numerical features in a dataset. The goal of the Standard Scaler is to ensure that each feature has a mean of 0 and a standard deviation of 1. This is achieved by subtracting the mean of each feature and then dividing it by the standard deviation.
   - **Content Based Filtering**
      >> Content-Based Filtering is a recommendation system technique that uses the characteristics or attributes of items to make recommendations to users. It involves analyzing the content of the items, such as movies, books, or products, and identifying similarities or patterns among them.

## Authors
- [@Biane3006](https://github.com/Biane3006)
