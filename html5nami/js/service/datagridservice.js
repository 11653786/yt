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
         var userService=this;
        //http://bbs.csdn.net/topics/391545203,angularjs里只要有了http请求就要这么写么
            //获取用户列表
        userService.getListByDao=function () {
                return userDao.getList();
            }
            //获取hello,world!
            userService.hello=function () {
                return "hello,world!";
            }
            //http请求
            userService.getHttpList=function () {
                var url="http://localhost:8080/nami/datagrid.do";
                //如果不存在数据则加载
               return  $http({url:url,method:'post',headers:{"token":"hehe"},params:{id:1,name:"test",age:3}});
            }
    }
)
;