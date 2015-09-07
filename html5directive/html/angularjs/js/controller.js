myapp.controller('hellocontroller',function($scope){
    $scope.hello="hello,youmeiyou?";
});
//directive.html页面
myapp.controller('directivecontroller',function($scope,$element){
        $scope.loadData=function(){
            alert('加载数据中...');
        };
});


