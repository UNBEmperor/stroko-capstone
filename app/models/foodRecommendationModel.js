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
      keterangan: {
        type: Sequelize.STRING
      },
      link: {
        type: Sequelize.STRING,
        defaultValue: "https://picsum.photos/200"
      }
    });
  
    return FoodRecommendation;
  };
  
