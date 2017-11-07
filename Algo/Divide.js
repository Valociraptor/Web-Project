function divideConquer(val, arr){

    var mid = Math.floor(arr.length/2);
    var counter = 0;


    while (arr[mid] != val){
       
        if (arr[mid] > val){
            mid = Math.floor(mid/2);
            counter++;

        }

        else if (counter == arr.length+2){
            return "These are not the droids you're looking for";
        }


        else  { 
            mid = Math.floor(mid*1.5);
            counter++;
        }
             
            
        
    }

    return mid;
}

array = [1,2,3,4,5,6,7,8,9];

console.log(divideConquer(5, array));