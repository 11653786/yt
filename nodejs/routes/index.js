var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
    //index,views下的index.ejs
    res.render('controller/index', {title: 'Express'});
})

module.exports = router;
