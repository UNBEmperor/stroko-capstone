module.exports = (sequelize, Sequelize) => {
    const FoodRecommendation = sequelize.define("food_recommendation", {
      idStrokeAssessment: {
        type: Sequelize.INTEGER
      },
      namaMakanan: {
        type: Sequelize.STRING
      },
      lemak: {
        type: Sequelize.FLOAT
      },  
      karbohidrat: {
        type: Sequelize.FLOAT
      },
      natrium: {
        type: Sequelize.FLOAT
      },
      kalium: {
        type: Sequelize.FLOAT
      },
      serat: {
        type: Sequelize.FLOAT
      },
      keterangan: {
        type: Sequelize.TEXT
      },
      link: {
        type: Sequelize.STRING,
      }
    });
  
    return FoodRecommendation;
  };
  
