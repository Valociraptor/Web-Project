function SLL(){ //class definition of SLL
    this.head = null; //head property set to null initially
    //AddFront function that adds a value, therefore node to the front of the SLL


//-----------------------------------
    this.contains = function(val){
        var current = this.head;
        while(current){
            if(current.value == val){
                return true;
            }
     
            current = current.next
        }
        return false;
    }

//-----------------------------------------


    this.removeFront = function(){
        if(this.head !=null ){
            var result = this.head.value;
            this.head = this.head.next;
            return result;
         }
         else{
            return "Nothing to see here";
        }
    }

//------------------------------------------
    this.AddFront = function(val){

        //create the node
        var node = new Node(val);
        // if the head of the SLL is empty, then we can simply set the head to the new node
        if (this.head == null){
            this.head = node;
        }
        // if the head is occupied, then create a temp to also point to the head so we can manipulate
        // the head to point elsewhere and not lose our previous head node
        // set the head to the new node, then set the new node's .next to the temp (previous head)
        else{
            var temp = this.head;
            this.head = node;
            node.next = temp;
        }
    }
}

function Node(val){ // class definition for Node
    this.value = val; // value is a property and val is the incoming value we want to set this.value to
    this.next = null; // next pointer is null as we don't assume the node have a buddy yet
}

var mySLL = new SLL();
mySLL.AddFront("Dojo");
mySLL.AddFront("Amazon");
console.log(mySLL.removeFront());


console.log(mySLL);