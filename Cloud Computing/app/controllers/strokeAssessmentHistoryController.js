const jwt = require("jsonwebtoken");
const config = require("../config/authConfig");
const db = require("../models");
const StrokeAssessment = db.stroke_assessment;


// Retrieve all Stroke Assessments
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
    const userId = decoded.id;

    // Retrieve stroke assessments associated with the user's ID
    StrokeAssessment.findAll({
      where: { idUsers: userId }
    })
      .then((strokeAssessments) => {
        if (!strokeAssessments || strokeAssessments.length === 0) {
          return res.status(404).send({ 
            status: 404,
            message: "No stroke assessments found"
           });
        }
        res.status(200).send({
          status: 200,
          data: strokeAssessments
        });
      })
      .catch((err) => {
        res.status(500).send({ 
          status: 500,
          message: err.message || "Some error occurred while retrieving stroke assessments"
         });
      });
  });
};

// Delete a Stroke Assessment by ID
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

    StrokeAssessment.findOne({
      where: { id: id, idUsers: userId }
    })
      .then(strokeAssessment => {
        if (!strokeAssessment) {
          return res.status(404).send({
            status: 404,
            message: `Cannot delete Stroke Assessment with id=${id}. Maybe Stroke Assessment was not found!`,
          });
        }

    StrokeAssessment.destroy({
      where: { id: id }
    })
      .then(num => {
        if (num == 1) {
          res.status(200).send({
            status: 200,
            message: "Stroke Assessment was deleted successfully!",
            id: strokeAssessment.id,
          });
        } else {
          res.status(404).send({
            status: 404,
            message: `Cannot delete Stroke Assessment with id=${id}. Maybe Stroke Assessment was not found!`,
          });
        }
      })
      .catch(err => {
        res.status(500).send({
          status: 500,
          message: "Could not delete Stroke Assessment with id=" + id
        });
      });
  });
});
};