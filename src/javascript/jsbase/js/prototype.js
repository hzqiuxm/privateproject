/**
 * Created by hzqiuxm on 2016/4/4 0004.
 */

//原型继承例子1
var A = function(){};
A.prototype = {name : "hello"};

var B = function(){ var name = "world"; return name};
B.prototype = new A();

var b = new B();
var a = new A();
console.log(b.name);
console.log(Object.getPrototypeOf(b));
console.log(Object.getPrototypeOf(a));

//原型继承例子2
var Plane = function(){
    this.blood = 100;
    this.attackLevel = 1;
    this.defenseLevel = 1;
};
var plane = new Plane();
plane.blood = 500;
plane.attackLevel = 2;
plane.defenseLevel = 10;

var clonePlane = Object.create(plane);
console.log(clonePlane);

//变量封装的例子
var myObject = (function(){
    var _name = 'packing';//private变量
    return {
     getName : function(){ //public方法
         return _name;
     }
    }
})();

console.log(myObject.getName());
console.log(myObject._name);