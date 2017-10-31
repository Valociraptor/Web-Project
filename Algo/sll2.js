function SLL() { //class definition of SLL
    this.head = null; //head property set to null initially
    //AddFront function that adds a value, therefore node to the front of the SLL


    //-----------------------------------
    this.contains = function (val) {
        var current = this.head;
        while (current) {
            if (current.value == val) {
                return true;
            }

            current = current.next
        }
        return false;
    }

//---------------------------
    this.RemoveTodd = function (todd) {
        
            if (this.head.value == todd) {
                this.head = this.head.next;
                return "We killed "+todd;
            }
            else{
                var current = this.head;
                while (current) {

                        if (current.next == null){
                            return "NOAH NOAH NOAH";
                        }

                        if (current.next.value == todd){
                            current.next = current.next.next;
                            return "We killed "+todd;
                        }

                        else{
                        current = current.next
                        }
        }
    }
            return "NOAH NOAH NOAH!";
    }

//----------------
    this.Length = function () {   //Slist: length
        var current = this.head;
        var counter = 0;
        while (current) {
            counter += 1;
            current = current.next;
        }

        return counter;
    }
    //-----------------------------------------


    this.Display = function () {   
        var current = this.head;
        var  listy = "";
        while (current) {
            listy += current.value+" => ";
            current = current.next;
        }
        return listy;
    }

    //----------



    this.prepend = function (a,b) {
        var current = this.head;
        if (current == null){
            current.value = a;
        }
            while (current) {
                if (current.next == null){
                    current.next = a;
                }
                else if(current.next.value == b){
                     
                        var temp = current.value;
                        current.value = a;
                        current.next = temp;
                        break;
                }    
                
                else {
                    current = current.next;
                }
      
        
            
            }
        mySLL.Display();
    }
    

    //-----------------------------

    this.removeFront = function () {
        if (this.head != null) {
            var result = this.head.value;
            this.head = this.head.next;
            return result;
        }
        else {
            return "Nothing to see here";
        }
    }
//-----------------------


    this.Front = function () {
        if (this.head != null) {
            return this.head.value;// front fxn
            
        }
        return "Nothing to see here(null)";
    }
    //------------
    this.Avg = function() {
            var current = this.head;
            var min = this.head.value;
            var max = this.head.value;
            while (current){
                if (current.value < min) {
                    min = current.value;
                    current.value = current.next.value;
                }
                else if (current.value >= min && current.value >  max) {
                    max = current.value;
                    current.value = current.next.value;
                }
            current = current.next;
        }

    return (max + min) / 2; //average = Median

    }

    //------------------------------------------
    this.AddFront = function (val) {

        //create the node
        var node = new Node(val);
        // if the head of the SLL is empty, then we can simply set the head to the new node
        if (this.head == null) {
            this.head = node;
        }
        // if the head is occupied, then create a temp to also point to the head so we can manipulate
        // the head to point elsewhere and not lose our previous head node
        // set the head to the new node, then set the new node's .next to the temp (previous head)
        else {
            var temp = this.head;
            this.head = node;
            node.next = temp;
        }
    }
}

function Node(val) { // class definition for Node
    this.value = val; // value is a property and val is the incoming value we want to set this.value to
    this.next = null; // next pointer is null as we don't assume the node have a buddy yet
}

var mySLL = new SLL();
mySLL.AddFront("Dojo");
mySLL.AddFront("Amazon");
mySLL.AddFront("Weeeeee");
//console.log(mySLL.removeFront());

//console.log(mySLL.Length());
console.log(mySLL.Display());
console.log(mySLL.RemoveTodd("Dojo"));
console.log(mySLL.RemoveTodd("Jayme"));
console.log(mySLL.Display());
