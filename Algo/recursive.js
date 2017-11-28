// function rSigma(num) {
//     if (num <= 1){
//     return num;
//     }

//     return num +rSigma(num-1)

//     }



// function fibby(fib){
//     if (fib <= 1){
//         return fib;
//     }
//    console.log(fib);
//     return fibby(fib-1) + fibby(fib-2);

// }

// console.log(fibby(3));

// function factorial(fact){
//     if (fact <= 1){
//         return fact;
//     }
//     //console.log(fact);
//     return fact * factorial(fact-1);
// }

// console.log(factorial(6));


function subsets(str, arr){

    if (str.length == 1){
        return arr;
    }


      
    arr.push(str);
    str.length -= 1;



    return subsets(str[str.length]);
}

console.log(subsets("abc", []));


