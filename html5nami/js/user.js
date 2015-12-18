//只有第一个controller需要写myapp其他的都不需要写

//写法1,这个userdao是从datagrid中引入的
var datagrid = myapp.controller('usercontroller', function ($scope, $interval, $timeout,$interpolate,userDao,userDao1,userService) {
    $scope.userDao1List = userDao1.getList();
    $interval(function () {
        console.log("每隔三秒就执行" + new Date());
    }, 3000);
    $timeout(function () {
        console.log("定时器3秒后执行：" + new Date());
    }, 3000);

    //监控
    $scope.$watch("age", function (oldAge, newAge,$scope) {
            if(oldAge>newAge){
                console.log("年龄越来越小了..");
            }else if(oldAge<newAge){
                console.log("年龄越来越大");
            }


        var tmp = $interpolate('Publish by {{name}} to {{date}}');
        var data1 = {name: 'Mike',date: '2014-1-1'};
        var data2 = {name: 'Karen',date: '2014-1-2'};
        //interpolate的作用就是把上面表达式中的name替换成data中的name
        var str1 = tmp(data1);
        var str2 = tmp(data2);
        //获取http请求的信息
        userService.getUserInfo().then(function(response){$scope.name=response;});
        alert(userService.getListByDao());

    });
});

//写法2
//function usercontroller($scope){
//        $scope.name="写法2";
//}



