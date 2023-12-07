const db = require("../models");
const StrokeAssessment = db.stroke_assessment;

// Create a new Stroke Assessment
exports.create = (req, res) => {
  // Validate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
    return;
  }

  // Create a Stroke Assessment object
  const strokeData = {
    idUsers: req.body.idUsers,
    nama: req.body.nama,
    usia: req.body.usia,
    gender: req.body.gender,
    hipertensi: req.body.hipertensi,
    diabetes: req.body.diabetes,
    penyakitJantung: req.body.penyakitJantung,
    merokok: req.body.merokok,
    levelBMI: req.body.levelBMI,
    konsumsiAlkohol: req.body.konsumsiAlkohol,
    aktivitasFisik: req.body.aktivitasFisik,
    riwayatStrokePribadi: req.body.riwayatStrokePribadi,
    riwayatStrokeKeluarga: req.body.riwayatStrokeKeluarga,
    prediksiStroke: req.body.prediksiStroke
  };

  // Save Stroke Assessment in the database
  StrokeAssessment.create(strokeData)
    .then(data => {
      res.send(data);
    })
    .catch(err => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Stroke Assessment."
      });
    });
};

// Retrieve all Stroke Assessments
exports.findAll = (req, res) => {
  StrokeAssessment.findAll()
    .then(data => {
      res.send(data);
    })
    .catch(err => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving Stroke Assessments."
      });
    });
};

// Find a single Stroke Assessment by ID
exports.findOne = (req, res) => {
  const id = req.params.id;

  StrokeAssessment.findByPk(id)
    .then(data => {
      res.send(data);
    })
    .catch(err => {
      res.status(500).send({
        message: "Error retrieving Stroke Assessment with id=" + id
      });
    });
};

// Update a Stroke Assessment by ID
exports.update = (req, res) => {
  const id = req.params.id;

  StrokeAssessment.update(req.body, {
    where: { id: id }
  })
    .then(num => {
      if (num == 1) {
        res.send({
          message: "Stroke Assessment was updated successfully."
        });
      } else {
        res.send({
          message: `Cannot update Stroke Assessment with id=${id}. Maybe Stroke Assessment was not found or req.body is empty!`
        });
      }
    })
    .catch(err => {
      res.status(500).send({
        message: "Error updating Stroke Assessment with id=" + id
      });
    });
};

// Delete a Stroke Assessment by ID
exports.delete = (req, res) => {
  const id = req.params.id;

  StrokeAssessment.destroy({
    where: { id: id }
  })
    .then(num => {
      if (num == 1) {
        res.send({
          message: "Stroke Assessment was deleted successfully!"
        });
      } else {
        res.send({
          message: `Cannot delete Stroke Assessment with id=${id}. Maybe Stroke Assessment was not found!`
        });
      }
    })
    .catch(err => {
      res.status(500).send({
        message: "Could not delete Stroke Assessment with id=" + id
      });
    });
};
