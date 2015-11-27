var express = require('express');
var router = express.Router();

/* GET home page. */
<<<<<<< HEAD
router.get('/', function (req, res, next) {
    //index,views下的index.ejs
    res.render('controller/index', {title: 'Express'});
=======
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
>>>>>>> origin/yt
});

module.exports = router;
