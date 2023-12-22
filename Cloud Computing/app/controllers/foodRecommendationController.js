const jwt = require("jsonwebtoken");
const config = require("../config/authConfig");
const db = require("../models");
const axios = require("axios");
const FoodRecommendation = db.food_recommendation;


// Generate Food Recommendation
exports.generate = (req, res) => {
  // Extract the token and verify it to get the user's ID
  const token = req.headers["x-access-token"];
  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({ 
        status: 401,
        message: "Unauthorized"
       });
    }
    const strokeAssessmentId = req.params.strokeAssessmentId;
    const userId = decoded.id;
  // Check if the user making the request owns the stroke assessment
  db.stroke_assessment.findOne({
    where: { id: strokeAssessmentId, idUsers: userId }
  }).then(strokeAssessment => {
    if (!strokeAssessment) {
      return res.status(403).send({ 
        status: 403,
        message: "Forbidden"
      });
    }
    console.log(typeof strokeAssessment.dataValues.levelBMI, typeof 21);
    
    axios.post('https://backend-ml-qeg7ziwx4q-et.a.run.app/prediction/food-recommendation', {
      "hypertension":strokeAssessment.dataValues.hipertensi,
      "heart_disease":strokeAssessment.dataValues.penyakitJantung,
      "avg_glucose_level":strokeAssessment.dataValues.diabetes,
      "bmi":strokeAssessment.dataValues.levelBMI
    }) .then((foodRecommendations) => {
        if (!foodRecommendations || foodRecommendations.length === 0) {
          return res.status(404).send({ 
            status: 404,
            message: "No Food Recommendation found"
           });
        }
        FoodRecommendation.create({
          idStrokeAssessment: strokeAssessmentId,
          namaMakanan: foodRecommendations.data.data['Nama Makanan'],
          lemak: foodRecommendations.data.data.Lemak,
          karbohidrat: foodRecommendations.data.data.Karbohidrat,
          natrium: foodRecommendations.data.data.Natrium,
          kalium: foodRecommendations.data.data.Kalium,
          serat: foodRecommendations.data.data.Serat,
          keterangan: foodRecommendations.data.data.Keterangan,
          link: foodRecommendations.data.data.Link
        })
        console.log(foodRecommendations.data);
        res.status(200).send({
          status: 200,
          data: foodRecommendations.data.data
        });

      })
      .catch((err) => {
        console.log(err);
        res.status(500).send({ 
          status: 500,
          message: err.message || "Some error occurred while retrieving food recommendation"
         });
      });
    });
  });
};


// Retrieve all Food Recommendation
exports.findAll = (req, res) => {
  // Extract the token and verify it to get the user's ID
  const token = req.headers["x-access-token"];
  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({ 
        status: 401,
        message: "Unauthorized"
       });
    }
    const strokeAssessmentId = req.params.strokeAssessmentId;
    const userId = decoded.id;

  // Check if the user making the request owns the stroke assessment
  db.stroke_assessment.findOne({
    where: { id: strokeAssessmentId, idUsers: userId }
  }).then(strokeAssessment => {
    if (!strokeAssessment) {
      return res.status(403).send({ 
        status: 403,
        message: "Forbidden"
      });
    }

    // Retrieve Food Recommendation associated with the user's ID
    FoodRecommendation.findAll({
      where: { idStrokeAssessment: strokeAssessmentId },
    })
      .then((foodRecommendations) => {
        if (!foodRecommendations || foodRecommendations.length === 0) {
          return res.status(404).send({ 
            status: 404,
            message: "No Food Recommendation found"
           });
        }
        res.status(200).send({
          status: 200,
          data: foodRecommendations
        });
      })
      .catch((err) => {
        res.status(500).send({ 
          status: 500,
          message: err.message || "Some error occurred while retrieving food recommendation"
         });
      });
    });
  });
};


// Delete a Food Recommendation by ID
exports.delete = (req, res) => {
  const token = req.headers["x-access-token"];

  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({
        status: 401,
        message: "Unauthorized!"
      });
    }

    const userId = decoded.id;
    const id = req.params.id;

    // Find the associated stroke assessment for the food recommendation
    FoodRecommendation.findOne({
      where: { id: id }
    }).then(foodRecommendation => {
      if (!foodRecommendation) {
        return res.status(404).send({
          status: 404,
          message: `Cannot find Food Recommendation with id=${id}`
        });
      }

      const strokeAssessmentId = foodRecommendation.idStrokeAssessment;

      // Check if the stroke assessment belongs to the user making the request
      db.stroke_assessment.findOne({
        where: { id: strokeAssessmentId, idUsers: userId }
      }).then(strokeAssessment => {
        if (!strokeAssessment) {
          return res.status(403).send({
            status: 403,
            message: "Forbidden"
          });
        }

    FoodRecommendation.destroy({
      where: { id: id }
    })
      .then(num => {
        if (num == 1) {
          res.status(200).send({
            status: 200,
            message: "Food Recommendation was deleted successfully!",
            id: foodRecommendation.id,
          });
        } else {
          res.status(404).send({
            status: 404,
            message: `Cannot delete Food Recommendation with id=${id}. Maybe Food Recommendation was not found!`,
          });
        }
      })
      .catch(err => {
        res.status(500).send({
          status: 500,
          message: "Could not delete Food Recommendation with id=" + id
        });
      });
  });
});
});
};