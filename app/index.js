const express = require("express");
const cors = require("cors");
const app = express();

var corsOptions = {
  origin: "http://localhost:8081"
};

app.use(cors(corsOptions));

// parse requests of content-type - application/json
app.use(express.json());

// parse requests of content-type - application/x-www-form-urlencoded
app.use(express.urlencoded({ extended: true }));

// database
const db = require("./models");
const Role = db.role;

db.sequelize.sync();


// simple route
app.get("/", (req, res) => {
  res.json({ message: "Welcome to STROKO." });
});

// routes
require('./routes/authRoutes')(app);
require('./routes/userRoutes')(app);
require('./routes/strokeAssessmentRoutes')(app);
require('./routes/strokeAssessmentHistoryRoutes')(app);
require('./routes/foodRecomendationRoutes')(app);
require('./routes/foodRecomendationHistoryRoutes')(app);
require('./routes/healthEducation')(app);


// set port, listen for requests
const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}.`);
});

