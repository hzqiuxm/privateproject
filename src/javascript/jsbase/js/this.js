/**
 * Created by hzqiuxm on 2016/4/4 0004.
 */
//this普通函数调用例子 严格模式下输出undefine 非严格模式下输出全局变量

//"use strict"
window.name = 'globalName';
var myObject = {
    name : 'qiuxm',
    getName : function(){
        return this.name;
    }
};

var getName = myObject.getName;
console.log(getName());

//this 构造器调用例子
var oneClass = function(){
    this.name = 'qiuxm';
    return{
        name : "hzqiuxm"
    }
};
var obj1 = new oneClass();
alert(obj1.name);

var twoClass = function(){
    this.name = "qiuxm";
    return 'hzqiuxm';
};
var obj2 = new twoClass();
alert(obj2.name);

//丢失的this
var disobj = {
    myName : 'qiuxm',
    getName : function (){
        return this.name;
    }
};

console.log(disobj.getName());
var getName2 = disobj.getName;
console.log(getName2());

Math.max.apply(null,[1,2,5,3,4]);