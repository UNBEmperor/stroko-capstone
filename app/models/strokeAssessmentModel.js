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
      hipertensi: {
        type: Sequelize.BOOLEAN
      },
      diabetes: {
        type: Sequelize.BOOLEAN
      },
      penyakitJantung: {
        type: Sequelize.BOOLEAN
      },
      merokok: {
        type: Sequelize.BOOLEAN
      },
      levelBMI: {
        type: Sequelize.INTEGER
      },
      konsumsiAlkohol: {
        type: Sequelize.ENUM('Tidak Pernah', 'Jarang Sekali', 'Jarang', 'Sering')
      },
      aktivitasFisik: {
        type: Sequelize.ENUM('Rendah', 'Sedang', 'Tinggi')
      },
      riwayatStrokePribadi: {
        type: Sequelize.BOOLEAN
      },
      riwayatStrokeKeluarga: {
        type: Sequelize.BOOLEAN
      },
      prediksiStroke: {
        type: Sequelize.BOOLEAN
      }
    });
  
    return StrokeAssessment;
  };
  