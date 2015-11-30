var express = require('express');
var router = express.Router();
var app = express();

/* GET home page. */
router.get('/yt', function (req, res, next) {
    //index,views下的index.ejs
    res.render('controller/index', {title: 'Express'});
});

/* GET home page. */
router.get('/yt1', function (req, res, next) {
    //index,views下的index.ejs
    res.send("index1");
});

//三种传参方式
//Checks route params (req.params), ex: /user/:id
//Checks query string params (req.query), ex: ?id=12
//Checks urlencoded body params (req.body), ex: id=
router.post("/yt2", function (req, res) {
    res.send(req.body.name);
});

module.exports = router;
