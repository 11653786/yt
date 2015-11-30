var express = require('express');
var router = express.Router();


router.get('/', function (req, res, next) {
    //index,views下的index.ejs
    res.render('index', {title: 'Express'});
});

module.exports = router;
