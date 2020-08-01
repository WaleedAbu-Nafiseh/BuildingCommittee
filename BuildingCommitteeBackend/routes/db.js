var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "dbuser",
  password: "Start2020!"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});
