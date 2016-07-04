/**
 * Created by dell on 2016/7/2.
 */
"use strict"

var nums = [];
for(var i=0; i<10; i++ ){
    nums[i] = i + 1;
}
//light copy
var samenumsOne = nums;
nums[0] = 1024;
console.log(samenumsOne[0]);
console.log(samenumsOne[1]);

//deep copy
var samenumsTwo = [];
copy(nums,samenumsTwo);
nums[1] = 1024;
console.log(samenumsTwo[1]);//


//copy funcation
function copy(arr1,arr2) {
    for(var i=0; i<arr1.length; i++){
        arr2[i] = arr1[i];
        // console.log("arr2 = " + arr2[i]);
    }
}