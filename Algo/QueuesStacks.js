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

console.log(myQ);
console.log(myQ.Size());
console.log(myQ.isEmpty());
console.log(myQ.contains("Dojo"));
console.log(myQ.front());

