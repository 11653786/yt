//只有第一个controller需要写myapp其他的都不需要写

//写法1,这个userdao是从datagrid中引入的
var datagrid = myapp.controller('usercontroller', function ($scope, $interval,$timeout,userDao) {
    $scope.name = userDao.getList();
    $interval(function () {
        console.log("每隔三秒就执行"+new Date());
    }, 3000);
    $timeout(function(){
        console.log("定时器3秒后执行："+new Date());
    },3000);
});

//写法2
//function usercontroller($scope){
//        $scope.name="写法2";
//}



