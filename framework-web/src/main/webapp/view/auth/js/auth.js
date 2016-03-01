/**
 * Created by yt on 2016/3/1 0001.
 */
var myapp = angular.module("auth", ['treeControl']);

var names = ['Homer', 'Marge', 'Bart', 'Lisa', 'Mo'];
/**
 * 用来获取数据的方法....
 * @param level
 * @param width
 * @param prefix
 * @returns {Array}
 */
function createSubTree(level, width, prefix) {
    if (level > 0) {
        var res = [];
        for (var i = 1; i <= width; i++){
            res.push({
                "label": names[i % names.length],
                "children": createSubTree(level - 1, width, prefix + i + "."),
                id:i+" ",
                "name": names[i % names.length]
            });
        }
        return res;
    }
    else
        return [];
}
myapp.controller("auth_controller", function ($scope, $http) {
    $scope.treedata = createSubTree(3, 4, "名称");
    $scope.showToggle = function (node, expanded, $parentNode, $index, $first, $middle, $last, $odd, $even) {
        var parent = $parentNode ? ("child of: " + $parentNode.label) : "root node";
        var location = $first ? "first" : ($last ? "last" : ("middle node at index " + $index));
        var oddEven = $odd ? "odd" : "even";
    };
    $scope.showSelected = function (node, selected, $parentNode, $index, $first, $middle, $last, $odd, $even) {
        var parent = $parentNode ? ("child of: " + $parentNode.label) : "root node";
        var location = $first ? "first" : ($last ? "last" : ("middle node at index " + $index));
        var oddEven = $odd ? "odd" : "even";
        alert(node.id);
    };
});

