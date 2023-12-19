import os
import tensorflow as tf
from flask import Flask, jsonify, request
from werkzeug.utils import secure_filename
from tensorflow.keras.models import load_model
from keras.layers import Dropout
import numpy as np
from PIL import Image
import pandas as pd

with tf.keras.utils.custom_object_scope({'FixedDropout': Dropout}):
    model = tf.keras.models.load_model("Model_Rekomendasi.h5")

app = Flask(__name__)
app.config["ALLOWED_EXTENSIONS"] = set(['png', 'jpg', 'jpeg'])
app.config["UPLOAD_FOLDER"] = "static/uploads/"

def allowed_file(filename):
    return "." in filename and \
        filename.split(".", 1)[1] in app.config["ALLOWED_EXTENSIONS"]


label = ['CP015','AP027','ER004','ER004','ER004','ER003','ER003','AP028','BP017','BP003','DP002','DP002','DP002','DP001','DP001','DP001','DP001','DP001','DP001','DP001','BP004','AP035','ER007','ER007','AP037','AP038','AP038','ER013','ER016','ER017','ER017','ER017','DP003','DP003','DP003','DP003','GP003','DP005','DP007','DP008','DP008','DP009','DP009','DP009','DP010','AP043','ER022','ER022','BP006','FP005','GP005','GP012','GP017','GP017','GP020','GP021','GP021','GP021','GP029','GP049','GP040','AP010','AP052','AP052','ER030','ER030','ER031','ER035','ER035','ER038','ER038','ER038','ER039','ER040','ER040','CP031','CP003','CP004','CP004','CP004','CP009','CP009','CP009','DP011','DP011','CP011','CP011','CP011','CP035','CP011','CP014','DP013','DP013','DP013','CP038','CP038','BP037','BP037','BP037','BP037','AP070','AP070','BP047','BP047','DP040','ER052','ER057','ER058','ER058','ER063','ER064','AP085','AP085','AP085','AP085','AP085','BP050','AP005','AP005','AP005','AP009','AP009','AP009','AP009','BP053','DP015','AP096','AP096','AP096','AP096','AP096','GP086','ER052','ER052','ER052','GP047','AP024','GP088','GP089','FP011','DP048','DP048','DP049','DP049','CP058','CP058','CP058','CP058','CP058','CP058','CP058','DP051','DP055','DP016','DP016','DP016','CP061','CP061','CP061','CP061','DP018','MP016','MP016','MP017','MP018','MP018','MP018','MP018','HP003','CP072','CP076','DP019','GP094','GP094','BP076','AP111','DP021','DP021','DP020','DP020','DP020','DP020','AP114']



@app.route("/")
def index():
    return jsonify({
        "status": {
            "code": 200,
            "message": "Success fetching the API",
        },
        "data": None
    }), 200

@app.route("/prediction", methods=["GET", "POST"])
def prediction():
    if request.method == "POST":
        image = request.files["image"]
        if image and allowed_file(image.filename):
            # filename = secure_filename(image.filename)
            # image.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
            # image_path = os.path.join(app.config["UPLOAD_FOLDER"], filename)
            
            X_input = np.array([[InputUserArray]])
            prediction = model.predict(X_input)
            index = np.argmax(prediction)
            Kode_Pangan = label[index]
            Data_Makanan = pd.read_csv('Data Makanan Indonesia.csv')
            DataFrameHasil = Data_Makanan[Data_Makanan['Kode Pangan'] == Kode_Pangan]
            DataFrameHasil = DataFrameHasil.iloc[0]
            Output_Array = DataFrameHasil.values
            print(Output_Array)

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
        else:
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
    app.run()