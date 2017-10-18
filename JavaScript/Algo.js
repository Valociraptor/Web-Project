

function concat(arr1, arr2){
    
    catarr = [];

    for (var i = 0; i < arr1.length; i++){
        catarr.push(arr1[i]);
    }

    for (var x = 0; x < arr2.length; x++){
     catarr.push(arr2[x]);
    }

    return catarr;

}
concat([1,2,3],["a","b","c"]);
console.log(catarr);





