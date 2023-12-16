const jwt = require("jsonwebtoken");
const config = require("../config/authConfig");
const db = require("../models");
const StrokeAssessment = db.stroke_assessment;

// Create a new Stroke Assessment
exports.create = (req, res) => {
  const token = req.headers["x-access-token"];

  if (!token) {
    return res.status(403).send({
      status: 403,
      message: "No token provided!"
    });
  }

  jwt.verify(token, config.secret, (err, decoded) => {
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

  // Save Stroke Assessment in the database
  StrokeAssessment.create(strokeData)
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

