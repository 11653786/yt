//注入一个service
myapp.factory('userDao', function ($http) {
    var list = [1, 2, 3, 4, 5];
    var dao = {};
    dao.getList = function () {
        return list;
    }
    return dao;
});

var userService = myapp.service("userService", function ($q, $http, userDao) {
        var service = {};
        service.getListByDao = function (userDao) {
            return userDao.getList();
        }
        service.hello = function () {
            return "hello,world!";
        }
        return service;
    }
);