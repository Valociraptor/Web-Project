function bubble(arr){

    for (j = 0; j < arr.length; j++){

        for (i = 0; i < arr.length; i++){
            
                if (arr[i] > arr[i + 1]){
                    var temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    console.log(arr);
                }
                
        }

    }

    return arr;


}

function insertion(arr){
    var index = 0;
    var temp = 0;
    var min = arr[0];


    for (x = 0; x < arr.length; x++){
        if (arr[x] < min){
            min = arr[x];
            index = x;
        }
    }
    temp = arr[0];
    arr[0] = min;
    arr[index] = temp;


    for (i=0; i < arr.length; i++){

        index = [i];
        if( arr[i] > arr[i+1]){
        
            for (j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j] && arr[j] < arr[index]){
                    index = j;
                    
                }
  
            }

            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

            console.log(arr);

        }       

    } 
    return arr;
}


function partition(arr, start, end){
    var partIdx = start;
    var num = arr[start];
    for (var i = start; i < end; i++){
        if (arr[i] < num){
            partIdx++;
            var temp = arr[i];
            arr[i] = arr[partIdx];
            arr[partIdx] = temp;
        }
    }
    arr[start] = arr[partIdx];
    arr[partIdx] = num;
    return partIdx;
}

var arr1 = [5,2,6,7,1,3,9,11,10,8,12, -4, 20, -5];


function quickSort(arr, start=0, end=arr.length){

        
    if((end - start) > 0){
        console.log(arr);
        var pivot = partition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot+1, end);
    }

}


console.log(arr1);










