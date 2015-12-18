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
        this.getListByDao = function () {
            return userDao.getList();
        }
        this.hello = function () {
            return "hello,world!";
        }
        var userInfo={};
        return {
            getUserInfo:function(){
                // 如果已存在则直接返回
                if(userInfo.name){
                    return $q.when(userInfo);
                }
                //如果不存在数据则加载
                return $http.get('http://localhost:8080/nami/datagrid.do').then(function(res){
                    // 把数据存到server中并返回
                    userInfo=res.data;

                    return res.data;
                })
            }
        }


        return this;
    }
)
;