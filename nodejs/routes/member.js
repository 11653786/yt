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

router.post("/yt2",function(req,res){
    res.send("666");
});

module.exports = router;
