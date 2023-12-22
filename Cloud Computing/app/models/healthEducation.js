module.exports = (sequelize, Sequelize) => {
    const StrokeAssessment = sequelize.define("health_education", {
      judulArtikel: {
        type: Sequelize.STRING
      },
      isiArtikel: {
        type: Sequelize.TEXT
      },
      tanggal: {
        type: Sequelize.STRING
      },
      penerbit: {
        type: Sequelize.STRING
      },
      penulis: {
        type: Sequelize.STRING
      },
      fotoArtikel: {
        type: Sequelize.STRING
      },
    });
    return StrokeAssessment;
  };
  