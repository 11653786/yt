//只有第一个controller需要写myapp其他的都不需要写

//写法1,这个userdao是从datagrid中引入的
var datagrid = myapp.controller('usercontroller', function ($scope, $interval, $timeout, userDao,userDao1) {
    $scope.name = userDao.getList();
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
            }else if(oldAge!=null && newAge!=null){
                $scope.name="两次输入的年龄相同";
            }

    });
});

//写法2
//function usercontroller($scope){
//        $scope.name="写法2";
//}



