module.exports = (sequelize, Sequelize) => {
    const StrokeAssessment = sequelize.define("stroke_assessment", {
      idUsers: {
        type: Sequelize.INTEGER
      },
      nama: {
        type: Sequelize.STRING
      },
      usia: {
        type: Sequelize.INTEGER
      },
      gender: {
        type: Sequelize.BOOLEAN
      },
      levelBMI: {
        type: Sequelize.FLOAT
      },
      hipertensi: {
        type: Sequelize.BOOLEAN
      },
      diabetes: {
        type: Sequelize.BOOLEAN
      },
      penyakitJantung: {
        type: Sequelize.BOOLEAN
      },
      riwayatStrokePribadi: {
        type: Sequelize.BOOLEAN
      },
      riwayatStrokeKeluarga: {
        type: Sequelize.BOOLEAN
      },
      merokok: {
        type: Sequelize.ENUM('0', '1', '2')
      },
      konsumsiAlkohol: {
        type: Sequelize.ENUM('0', '1', '2', '3')
      },
      aktivitasFisik: {
        type: Sequelize.ENUM('0', '1', '2')
      },
      prediksiStroke: {
        type: Sequelize.BOOLEAN
      }
    });
  
    return StrokeAssessment;
  };
  