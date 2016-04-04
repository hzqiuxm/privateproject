/**
 * Created by hzqiuxm on 2016/4/4 0004.
 */
//改变this的指向
var obj1 = {name : 'qiuxm'};
var obj2 = {name : 'hzqiuxm'};
window.name = 'window';

var getname = function(){
    alert(this.name);
};

getname();
getname.call(obj1);
getname.call(obj2);

//借用其他对象的方法 借用了Array的push方法 注意a必须是个对象类型
var a = {};
Array.prototype.push.call(a,'qiuxm');
alert(a.length);
alert(a[0]);