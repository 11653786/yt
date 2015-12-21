/**
 * user的dao
 */
myapp.factory("userDao1",function(){
    var list=[6,7,8];
    var userDao1={};
    userDao1.getList=function(){
        return list;
    }
    return userDao1;
});