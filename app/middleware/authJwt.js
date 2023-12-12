const jwt = require("jsonwebtoken");
const config = require("../config/authConfig");
const db = require("../models");
const User = db.user;

verifyToken = (req, res, next) => {
  let token = req.headers["x-access-token"];

  if (!token) {
    return res.status(403).send({
      status: 403,
      message: "No token provided!"
    });
  }

  jwt.verify(token,
            config.secret,
            (err, decoded) => {
              if (err) {
                return res.status(401).send({
                  status: 401,
                  message: "Unauthorized!",
                });
              }
              req.userId = decoded.id;
              next();
            });
};

isUserPremium = (req, res, next) => {
  User.findByPk(req.userId).then(user => {
    user.getRoles().then(roles => {
      for (let i = 0; i < roles.length; i++) {
        if (roles[i].name === "userPremium") {
          next();
          return;
        }
      }

      res.status(403).send({
        status: 403,
        message: "Require Premium Role!"
      });
      return;
    });
  });
};

const authJwt = {
  verifyToken: verifyToken,
  isUserPremium: isUserPremium,
};
module.exports = authJwt;
