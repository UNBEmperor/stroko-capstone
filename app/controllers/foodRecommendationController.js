const jwt = require("jsonwebtoken");
const axios = require("axios");
const config = require("../config/authConfig");
const db = require("../models");
const FoodRecommendation = db.food_recommendation;
const StrokeAssessment = db.stroke_assessment;

// Create a new Food Recommendation
exports.create = (req, res) => {
  const token = req.headers["x-access-token"];
  const idStrokeAssessment = req.body.idStrokeAssessment;


  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({
        status: 401,
        message: "Unauthorized!"
      });
    }

    const userId = decoded.id;

    StrokeAssessment.findOne({
      where: { id: req.params.id, idUsers: userId }
    })
      .then(strokeAssessment => {
        if (!strokeAssessment) {
          return res.status(403).send({
            status: 403,
            message: "Unauthorized! Stroke assessment does not belong to the user."
          });
        }

  // Create a Stroke Assessment object
  const foodData = {
    idStrokeAssessment: req.body.idStrokeAssessment,
    namaMakanan: req.body.namaMakanan,
    kandungan1: req.body.kandungan1,
    kandunganN: req.body.kandunganN,
    keterangan: req.body.keterangan,
    fotoMakanan: req.body.fotoMakanan,
  };

  // Save Stroke Assessment in the database
  FoodRecommendation.create(foodData)
  .then(data => {
    res.status(201).send({
      status: 200,
      message: "FoodRecommendation created successfully",
      data: data
    });
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

