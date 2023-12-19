const jwt = require("jsonwebtoken");
const config = require("../config/authConfig");
const db = require("../models");
const HealthEducation = db.health_education;

// Retrieve all Health Education
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

    // Retrieve Health Education associated with the user's ID
    HealthEducation.findAll({
    })
      .then((healthEducation) => {
        if (!healthEducation || healthEducation.length === 0) {
          return res.status(404).send({ 
            status: 404,
            message: "No Health Education found"
           });
        }
        const responseData = healthEducation.map(healthEducation => ({
          judulArtikel: healthEducation.judulArtikel,
          tanggal: healthEducation.tanggal,
          penerbit: healthEducation.penerbit,
          fotoArtikel: healthEducation.fotoArtikel
        }));

        res.status(200).send({
          status: 200,
          data: responseData
        });
      })
      .catch((err) => {
        res.status(500).send({ 
          status: 500,
          message: err.message || "Some error occurred while retrieving Health Education"
         });
      });
  });
};


// Retrieve Health Education
exports.findOne = (req, res) => {
  // Extract the token and verify it to get the user's ID
  const token = req.headers["x-access-token"];
  const { id } = req.params; 
  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({ 
        status: 401,
        message: "Unauthorized"
       });
    }
    //const userId = decoded.id;

    // Retrieve Health Education associated with the user's ID
    HealthEducation.findOne({
      where: { id: id }
    })
      .then((healthEducation) => {
        if (!healthEducation || healthEducation.length === 0) {
          return res.status(404).send({ 
            status: 404,
            message: "No Health Education found"
           });
        }
        res.status(200).send({
          status: 200,
          data: healthEducation
        });
      })
      .catch((err) => {
        res.status(500).send({ 
          status: 500,
          message: err.message || "Some error occurred while retrieving Health Education"
         });
      });
  });
};


// Create a new Health Education
exports.create = (req, res) => {
  const token = req.headers["x-access-token"];

  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({
        status: 401,
        message: "Unauthorized!"
      });
    }

    const userId = decoded.id;

  // Create a Health Education object
  const healthEducationData = {
    idUsers: userId,
    judulArtikel: req.body.judulArtikel,
    isiArtikel: req.body.isiArtikel,
    tanggal: req.body.tanggal,
    penerbit: req.body.penerbit,
    penulis: req.body.penulis,
    fotoArtikel: req.body.fotoArtikel
  };

  // Save Health Education in the database
  HealthEducation.create(healthEducationData)
  .then(data => {
    res.status(201).send({
      status: 200,
      message: "HealthEducation created successfully",
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



// Delete a Health Education by ID
exports.delete = (req, res) => {
  const token = req.headers["x-access-token"];


  jwt.verify(token, config.secret, (err, decoded) => {
    if (err) {
      return res.status(401).send({
        status: 401,
        message: "Unauthorized!"
      });
    }

    const id = req.params.id;

    HealthEducation.findOne({
      where: { id: id }
    })
      .then(healthEducation => {
        if (!healthEducation) {
          return res.status(404).send({
            status: 404,
            message: `Cannot delete Health Education with id=${id}. Maybe Health Education was not found!`,
          });
        }

      HealthEducation.destroy({
      where: { id: id }
    })
      .then(num => {
        if (num == 1) {
          res.status(200).send({
            status: 200,
            message: "Health Education was deleted successfully!",
            id: healthEducation.id,
          });
        } else {
          res.status(404).send({
            status: 404,
            message: `Cannot delete Health Education with id=${id}. Maybe Health Education was not found!`,
          });
        }
      })
      .catch(err => {
        res.status(500).send({
          status: 500,
          message: "Could not delete Health Education with id=" + id
        });
      });
  });
});
};

