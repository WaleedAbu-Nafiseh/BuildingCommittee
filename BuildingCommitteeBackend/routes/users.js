var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  let user=[{
    username:"Waleed",
    password:"password",
    id:"23535"
  }];

  
  res.send([]);
});

module.exports = router;
