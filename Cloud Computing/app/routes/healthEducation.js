const healthEducationController = require("../controllers/healthEducationController");

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  // Retrieve all Health Education
  app.get("/api/health-education", healthEducationController.findAll);

  // Retrieve Health Education  by id
  app.get("/api/health-education/:id", healthEducationController.findOne);

  // Create a new health Education
  app.post("/api/health-education", healthEducationController.create);

  // Delete a Health Education by id
  app.delete("/api/health-education/:id", healthEducationController.delete);
};

