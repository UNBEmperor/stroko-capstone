const strokeAssessmentHistoryController = require("../controllers/strokeAssessmentHistoryController");

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  // Retrieve all Stroke Assessments
  app.get("/api/stroke-assessment-history", strokeAssessmentHistoryController.findAll);

  // Delete a Stroke Assessment by id
  app.delete("/api/stroke-assessment-history/:id", strokeAssessmentHistoryController.delete);
};

