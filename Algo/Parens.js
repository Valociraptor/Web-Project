function parens(str) {


str2="";

for (i = 0; i < str.length; i++){

if (str[i] == "(" ||  str[i] == ")" ){
    str2 = str2 + str[i];
}
}




}

parens('d(sdf)(s)dfdfs)');

console.log(str2);