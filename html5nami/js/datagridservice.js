//注入一个service
myapp.factory('userDao', function ($http) {
    var list = [1, 2, 3, 4, 5];
    var dao = {};
    dao.getList = function () {
        return list;
    }
    return dao;
});

myapp.service("userService", function ($q, $http, userDao) {
        var service = {};
        service.getListByDao = function () {
            return userDao.getList();
        }
        service.hello = function () {
            return "hello,world!";
        }
        //获取
        service.getUserList = function () {
            var data = {};
            var msg = [1, 2];
            //提交表单
            $http({method:'get',url:'http://m.test.zhai.me/customer/api/v3/districts/cities'}).
                success(function(response) {
                    alert(response);
                });
            return msg;
        }
        return service;
    }
)
;