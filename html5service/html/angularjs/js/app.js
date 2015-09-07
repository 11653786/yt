var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);
//����ֻдÿһ��ҳ���·��ӳ��,��������divӳ��֮���������һ��js�ļ�д
//http://rensanning.iteye.com/blog/2149056
//urlֻ����ʾ·����
//����1state1 �Ǵ���Ĳ���
//temlateUrL��ʵ·��
//views,һ��ҳ��������ж��ui-viewʹ��,��������:state��@ui-view��
myapp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/hello");
    //ƥ��ui-sref=state1������,������·��Ϊ/hello,��ʵ��ַ��html/hello.html
    //$apply()����������angular���֮��ִ��angular JS�ı��ʽ�����磺DOM�¼���setTimeout��XHR�������������Ŀ⡣������Ǹ���ʼ��ˮ���к����ӭ���һ����deep dive��
    $stateProvider.state('state1',{
            //ƥ��·��
            url: "/hello",
            templateUrl: "html/hello.html",
            controller:'divcontroller',
        })

});


myapp.controller('divcontroller',function($scope,myfactory,myservice,myprovider){
    $scope.hello=myfactory.getList();
    $scope.servicehello=myservice.pages;
    var str=myprovider.save();
});


//����service�ļ��ַ���,service �ĵ�һ��ʹ�÷���,
// 1.����һ��factory����
// 2.����������������,
// 3.���뵽controller��ȥ
// 4.��������Ӧ���Ǻ�controllerͬʱ����
//5.�Ұ���������dao
//6.�����Ѿ�д����һ��
myapp.factory('myfactory',function($http){
    var list=[1,2,3,4,5];
    var service={};
    service.getList=function(){
        return list;
    }
    return service;
});
//�ڶ��ַ���service,
// ���������е�controller��ʹ��
//�������ںܳ�
//new �����ö�Ҫ��this
//�������myfctory�㵱����dao������
myapp.service("myservice",function(myfactory){
   this.obj={name1:"name11",name2:"name22",name3:"name33",name4:"name44"};
    this.list=myfactory.getList();
    this.pageSize=this.list.length;
    this.pages={obj:this.obj,list:this.list,pageSize:this.pageSize};
});
//�����ַ���
//�ײ�ʵ�ֿ�
//����this.$get����
//Ϊʲô����������أ�
//���Է�װ�ɷ����˰�...
myapp.provider('myprovider', function() {
        this.backendUrl = "http://localhost:8080/api/user/datagrid.html";
        this.$get = function($http) { // injectables go here
            var self = this;
            var service = {
                user: {},
                //setName: function(newName) {
                //    service.user['name'] = newName;
                //},
                //setEmail: function(newEmail) {
                //    service.user['email'] = newEmail;
                //},
                save: function() {return $http.post(self.backendUrl,{user: service.user})}
            };
            return service;
        }
    });


