module.exports = (sequelize, Sequelize) => {
    const FoodRecomendation = sequelize.define("food_recomendation", {
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
  
    return FoodRecomendation;
  };
  
// nama makanan
// kandungan1
// kandunganN
// keterangan
// foto
