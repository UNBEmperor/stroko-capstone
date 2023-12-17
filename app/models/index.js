const config = require("../config/dbConfig.js");

const Sequelize = require("sequelize");
const sequelize = new Sequelize(
  config.DB,
  config.USER,
  config.PASSWORD,
  {
    host: config.HOST,
    dialect: config.dialect,
    pool: {
      max: config.pool.max,
      min: config.pool.min,
      acquire: config.pool.acquire,
      idle: config.pool.idle
    }
  }
);

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

db.user = require("../models/userModel.js")(sequelize, Sequelize);
db.role = require("../models/roleModel.js")(sequelize, Sequelize);
db.stroke_assessment = require("../models/strokeAssessmentModel.js")(sequelize, Sequelize);
db.food_recommendation = require("../models/foodRecommendationModel.js")(sequelize, Sequelize);
db.health_education = require("../models/healthEducation.js")(sequelize, Sequelize);

db.user.hasMany(db.stroke_assessment, { foreignKey: 'idUsers' });
db.stroke_assessment.belongsTo(db.user, { foreignKey: 'idUsers' });

db.stroke_assessment.hasMany(db.food_recommendation, { foreignKey: 'idStrokeAssessment' });
db.food_recommendation.belongsTo(db.stroke_assessment, { foreignKey: 'idStrokeAssessment' });

db.role.belongsToMany(db.user, {
  through: "user_roles"
});
db.user.belongsToMany(db.role, {
  through: "user_roles"
});

db.ROLES = ["user", "userPremium"];

module.exports = db;
