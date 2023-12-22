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

};

