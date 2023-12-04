import express from 'express';
import db_connection from './database/db_connection.js';
import routes from './routes/routes.js';
const app = express();
const port = process.env.PORT || 8080;

// Middleware to parse JSON requests
app.use(express.json());

app.get('/', (req, res) => {
    res.send('Hello World!');
});
app.use('/api', routes);
app.use((err, req, res, next) => {
    err.statusCode = err.statusCode || 500;
    err.message = err.message || 'Internal Server Error';
    res.status(err.statusCode).json({
        message: err.message,
    });
});



// If database is connected successfully, then run the server
// db_connection
//     .getConnection()
//     .then(() => {
//         app.listen(port, () => {
//             console.log(`Server is running on port ${port}`);
//         });
//     })
//     .catch((err) => {
//         console.log(`Failed to connect to the database: ${err.message}`);
//     });


app.listen(port, () =>
  console.log(`Listening on port ${port}`)
);

db_connection
.getConnection()

