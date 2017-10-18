// function GetDigits(str1){
//     str2 = [];
//     final = "";

//     for(var i = 0; i < str1.length; i++){
//         if(typeof(str1[i]) == "number"){
//         str2[i].push(str1[i]);
//         final = final+(str2[i]);
    
//         }
//     }
//         return final;

// }

// GetDigits("s78dhs7shs&*jhsdj3");
// console.log(final);
var numbersOnly = function(items) {
    final = "";
        for(var i = 0; i < items.length; i++) {
    
          if (typeof items[i] == "number"){
         final = final+items[i];
       
        }
      }
        return final;
    }
   var tests = numbersOnly("6522redfour100");

    
   console.log(typeof tests);

