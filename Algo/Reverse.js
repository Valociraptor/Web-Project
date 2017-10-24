function reverseStr(str1){
    var str2 = "";

    for (var i = str1.length-1; i >= 0; i--){

        str2 = str2+str1[i];

    }

    return str2;
}


var result = reverseStr("abcdef");
console.log(result);
