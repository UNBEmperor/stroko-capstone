const foodRecommendationController = require("../controllers/foodRecommendationController");

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  // Create a new food recomendation
  app.post("/api/food-recommendation/", foodRecommendationController.create);

};

