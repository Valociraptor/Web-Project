function parenthsValid(str){
    var a = ""; 



    for ( var i = 0; i < str.length; i++) {


        if ( str[i] === "(" ) {
            a += 1;
        }

        if ( str[i] == ')'){
            a -= 1;
        }

        if ( a < 0) {
            return false;
       }

        if ( str[i] == '['){
            a += 5;
        }

        if ( str[i] == ']'){
            a -= 5;
        }

        if ( a < 0) {
            return false;
       }

        if ( str[i] == '{'){
            a += 15;
        }

        if ( str[i] == '}'){
            a -= 15;
        }

        if ( a < 0) {
             return false;
        }
        

    }


    if( a == 0){

    return true;
    }

        else {
            return false;
        }


    

}


var result = parenthsValid("fd(sd)dfs[]3sd{}");
console.log(result);