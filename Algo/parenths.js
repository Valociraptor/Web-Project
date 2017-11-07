function parenthsValid(str){
    var a = ""; 
    var b = "";
    var c = "";



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
            b += 5;
        }

        if ( str[i] == ']'){
            b -= 5;
        }

        if ( b < 0) {
            return false;
       }

        if ( str[i] == '{'){
            c += 15;
        }

        if ( str[i] == '}'){
            c -= 15;
        }

        if ( c < 0) {
             return false;
        }
        

    }


    if( a == 0 && b == 0 && c == 0){

    return true;
    }

        else {
            return false;
        }


    

}


 var result = parenthsValid("[[[]}]])fd(sd)dfs[]3sd{}(");
 console.log(result);




var balancedParens = function(str) {
    var stack = [];
    var open = { '{': '}', '[': ']', '(': ')' };
    var closed = { '}': true, ']': true, ')': true };
    
    for (var i = 0; i < str.length; i ++) {
      var chr = str[i];
      if (open[chr]) {
        stack.push(chr);
      } else if (closed[chr]) {
        if (open[stack.pop()] !== chr) return false;
      }
    }
    
    return stack.length === 0;
  };

  var result2 = balancedParens("fd(sd)df}s[]3sd{}");
  console.log(result2);