function compare(slq1, slq2){
    current1 = slq1.head;
    current2 = slq2.head;

    if(slq1.Size() != slq2.Size()){
        return false;
    }

    while (current1 && current2){
        if(current1.value == current2.value){
            current1 = current1.next;
            current2 = current2.next;
        }

        else{
            return false;
        }

        
    }
    return true;
}

function removeMin(slq){
    current = slq.head;
    temp = slq.head.value;

    while (current){  
        if (current.value < temp){
            temp = current.value;
            current = current.next;
        }
    }
    current = slq.head;
    while (current){
        if (current.next.value = temp){
            current.next = current.next.next;
        }
    }

    current = slq.head;
    while (current){
        if (current.value = temp){
            slq.head = slq.head.next;
        }
    }
return temp;
}





function SLQueue(){
    this.head = null;
    this.tail = null;


    this.enQ = function(val){

        var node = new Node(val);

        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            this.tail = node;
        }
        return this;
    }



    this.deQ = function(val){
        this.head.value = temp;
        this.head = this.head.next;
        return temp;
    }

    this.front = function(val){
        return this.head.value;
    }

    this.contains = function(val){
        var current = this.head;
        while (current) {
            if (current.value == val) {
                return true;
            }
            current = current.next;
            
        }
        return false;
    }

    this.isEmpty = function(){ 
        return !this.head;
    }

    this.Size = function(val){
        var counter = 0;
        var current = this.head;
        while (current){
            counter++;
            current = current.next;
        }
        return counter;
    }



}

function Node(value){
    this.value = value;
    this.next = null;
}



var myQ = new SLQueue();
myQ.enQ("Dojo");
myQ.enQ("Amazon");
myQ.enQ("Weeeeee");

var myQ2 = new SLQueue();
myQ2.enQ("Dojo");
myQ2.enQ("Amazon");
myQ2.enQ("sadasd");

var myQ3 = new SLQueue();
myQ3.enQ(1);
myQ3.enQ(2);
myQ3.enQ(3);
myQ3.enQ(1);



// console.log(compare(myQ, myQ2));
// console.log(myQ3);

// console.log(removeMin(myQ3));



