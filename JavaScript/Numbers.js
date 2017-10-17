
newArr =[];
function Numbers(arr){



for (i = 0; i < arr.length; i++)

    if (typeof arr[i] === "number")

    newArr.push(i);

}

Numbers([1,2,3,"apple",4]);
console.log(newArr);