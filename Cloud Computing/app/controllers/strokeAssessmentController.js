const jwt = require("jsonwebtoken");
const axios = require("axios");
const config = require("../config/authConfig");
const db = require("../models");
const StrokeAssessment = db.stroke_assessment;

// Create a new Stroke Assessment
exports.create = (req, res) => {
  const token = req.headers["x-access-token"];

  jwt.verify(token, config.secret, async (err, decoded) => {
    if (err) {
      return res.status(401).send({
        status: 401,
        message: "Unauthorized!"
      });
    }

    const userId = decoded.id;

  // Create a Stroke Assessment object
  const strokeData = {
    idUsers: userId,
    nama: req.body.nama,
    usia: req.body.usia,
    gender: req.body.gender,
    levelBMI: req.body.levelBMI,
    hipertensi: req.body.hipertensi,
    diabetes: req.body.diabetes,
    penyakitJantung: req.body.penyakitJantung,
    riwayatStrokePribadi: req.body.riwayatStrokePribadi,
    riwayatStrokeKeluarga: req.body.riwayatStrokeKeluarga,
    merokok: req.body.merokok,
    konsumsiAlkohol: req.body.konsumsiAlkohol,
    aktivitasFisik: req.body.aktivitasFisik,
    prediksiStroke: req.body.prediksiStroke
  };

  const response = await axios.post('https://backend-ml-qeg7ziwx4q-et.a.run.app/prediction/stroke-detection', {
    "Umur":strokeData.usia,
    "Jenis Kelamin":strokeData.gender,
    "Hipertensi":strokeData.hipertensi,
    "Penyakit Jantung":strokeData.penyakitJantung,
    "Diabetes":strokeData.diabetes,
    "BMI":strokeData.levelBMI,
    "Status Merokok":parseInt(strokeData.merokok),
    "Konsumsi Alkohol":parseInt(strokeData.konsumsiAlkohol),
    "Aktivitas Fisik":parseInt(strokeData.aktivitasFisik),
    "Riwayat Resiko Tinggi":strokeData.riwayatStrokePribadi,
    "Riwayat Resiko Tinggi Keluarga":strokeData.riwayatStrokeKeluarga
  })
  console.log(response.data.data.Diagnosis);

  // Save Stroke Assessment in the database
  StrokeAssessment.create({...strokeData, prediksiStroke:response.data.data.Diagnosis==="Resiko Rendah" ? false:true})
  .then(data => {
    res.status(201).send({
      status: 200,
      message: "StrokeAssessment created successfully",
      data: data

    });
    
  })
  .catch(err => {
    res.status(500).send({
      status: 500,
      message: err.message || "internal server error"
    });
  });
});
};

