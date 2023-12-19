# Documentation

## **Stroke Detection**
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
- Conclusion
   >> Stroke Detection performs early detection of stroke based on user input and provides 2 outputs: Low Risk or High Risk.
## **Food Recommendation**
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
- Conclusion
   >>Food Recommendation provides food recommendations based on a patient's medical history input. The model searches for similarities in features between the input medical history and the dataset's features to provide relevant food recommendations.
