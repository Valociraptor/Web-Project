function flatten(arr) {
    var arr2 = []

    for (i=0; i < arr.length; i++){
        if (typeof(arr[i]) == 'object'){
            for(z = 0; z < arr[i].length; z++){

                if(arr[i][z] != null){

                arr2.push(Number([arr[i][z]]));

                }

            }

        }
        else{   
   
            arr2.push(arr[i]);
        }

    }

    arr =arr2
    
    return arr;
}


console.log(flatten([1,2,3, [], [4, 5] ]));


// function removeDup(arr){

//     return arr;
// }


// console.log(removeDup([1,2,3,4,5,5,6,6]));