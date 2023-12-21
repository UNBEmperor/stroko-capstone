const foodRecommendationController = require("../controllers/foodRecommendationController.js");

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  // Generate Stroke Assessments
  app.get("/api/food-recommendation/:strokeAssessmentId", foodRecommendationController.generate);
  
  // Generate Stroke Assessments
  app.get("/api/food-recommendation-history/:strokeAssessmentId", foodRecommendationController.findAll);

  // Delete a Stroke Assessment by id
  app.delete("/api/food-recommendation/:id", foodRecommendationController.delete);
};

