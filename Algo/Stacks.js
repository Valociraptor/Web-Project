function ArrStack(){
    this.Arr = [];


    this.push = function(val){
        for (var i = this.Arr.length; i > -1; i--){
            if (i > 0){
            this.Arr[i] = this.Arr[i-1]
            }
            else{
                this.Arr[i] = val;
            }
        }
    }


    this.pop = function(){
        var temp = 0;
        temp = this.Arr[0];

        for(i=0; i <this.Arr.length; i++){
            this.Arr[i] = this.Arr[i+1];
        }
        this.Arr.length--;
        return temp;
        
    }


    this.Top = function(){
        var tippytop = 0;
        tippytop = this.Arr[0];
        return tippytop;
    }

    this.isEmpty = function(){
        if(this.Arr.length == 0){
            return true;
        }
        else{
            return false;
        }

    }

    this.contains = function(val){
        for(i=0; i <this.Arr.length; i++){
            if (this.Arr[i] == val){
                return true;
            }
   
        }
        return false;
    }

    this.Size = function(){
        return this.Arr.length;
    }

}

var stack1 = new ArrStack();

stack1.push(1);
stack1.push(2);
stack1.push(3);
stack1.push(4);
stack1.push(5);

console.log(stack1);