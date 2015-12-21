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
        var userInfo = {};
        //http://bbs.csdn.net/topics/391545203,angularjs里只要有了http请求就要这么写么
        return {
            //获取用户列表
            getListByDao: function () {
                return userDao.getList();
            },
            //获取hello,world!
            hello: function () {
                return "hello,world!";
            },
            //http请求
            getUserInfo: function () {
                // 如果已存在则直接返回
                if (userInfo.length!=undefined && userInfo.length>0) {
                    return $q.when(userInfo);
                }
                var url="http://localhost:8080/nami/datagrid.do";
                //如果不存在数据则加载
                return $http.get(url).success(function (res) {
                    //第一次发送的时候就赋给userInfo
                    userInfo = res.data;
                    return res.data;
                })
            }
        }
    }
)
;