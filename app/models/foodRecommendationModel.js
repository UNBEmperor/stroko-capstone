module.exports = (sequelize, Sequelize) => {
    const FoodRecommendation = sequelize.define("food_recommendation", {
      idStrokeAssessment: {
        type: Sequelize.INTEGER
      },
      namaMakanan: {
        type: Sequelize.STRING
      },
      kandungan1: {
        type: Sequelize.FLOAT
      },
      kandunganN: {
        type: Sequelize.FLOAT
      },
      keterangan: {
        type: Sequelize.STRING
      },
      fotoMakanan: {
        type: Sequelize.STRING
      }
    });
  
    return FoodRecommendation;
  };
  
