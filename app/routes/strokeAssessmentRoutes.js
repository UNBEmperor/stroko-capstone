const strokeAssessmentController = require("../controllers/strokeAssessmentController");

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  // Create a new Stroke Assessment
  app.post("/api/stroke-assessment", strokeAssessmentController.create);

  // Retrieve all Stroke Assessments
  app.get("/api/stroke-assessment", strokeAssessmentController.findAll);

  // Retrieve a single Stroke Assessment by id
  app.get("/api/stroke-assessment/:id", strokeAssessmentController.findOne);

  // Update a Stroke Assessment by id
  app.put("/api/stroke-assessment/:id", strokeAssessmentController.update);

  // Delete a Stroke Assessment by id
  app.delete("/api/stroke-assessment/:id", strokeAssessmentController.delete);
};
