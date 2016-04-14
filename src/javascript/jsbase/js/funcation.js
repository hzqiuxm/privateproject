/**
 * Created by hzqiuxm on 2016/4/6 0006.
 */
//arguments 测试
function myFunc(value){
    arguments[0] = 100;
    alert(value);
}

myFunc('abc');

function format(string) {
    var args = arguments;
    console.log(args.length);
    var pattern = new RegExp("%([1-" + arguments.length + "])", "g");
    var times = 0;
    return String(string).replace(pattern, function(match, index,ads) {
        times++;
        console.log(arguments);
        console.log("match="+match);
        console.log("index="+index);
        console.log("times="+times);
        console.log("ads="+ads);
        return args[index];
    });
};
 var result = format("And the %1 want to know whose %2 you %3", "papers", "shirt", "wear");
console.log(result);

 console.log((/\w+\b Byron/).test('Hi Byron'));

function logArgument(){
    console.log(arguments);
    return "返回值";
}
console.log('hzqiuxm@163.com'.replace(/(.+)(@)(.*)/g,logArgument));