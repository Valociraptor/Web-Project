function BTNode (val){
    this.value = val;
    this.left = null;
    this.right = null;
}

function BST(){
    this.root = null;


    this.add = function(val) {



        current = this.root;

        if (current == null){
            current.value = val;
            current.left = null;
            current.right = null;
        }

        while(current){
            if (val > current.value && current.right == null){
                current.right = new BTNode(val);
                return "Done!";
            }

            else if (val < current.value && current.left == null){
                current.left = new BTNode(val);
                return "Done!";
            }

            else if (val > current.value){
                current = current.right
            }

            else if (val < current.value){
                current = current.left
            }

            else {
                return "Val is in the tree.";
            }

        }

    }

    this.max = function(){
        current = this.root;
        while (current.right != null){
            current= current.right;
        }

        
        return current.value;
    }

    this.min = function(){
        current = this.root;

        while (current.left != null){
            current = current.left;
        }

        return current.value;
    }

    this.isEmpty = function(){
        current = this.root;
        if (current){
            return false;
        }

        return true;
    }

    this.contains = function(Val){
        current = this.root;


        while(current){

            if (current.value == Val){
                return true;
            }
             else if (Val < current.value){
                current = current.left;
            }

            else {
                current = current.right;
            }

        
        }
        return false;
    }



    



    this.heights = function(node=this.root){
        if (!node){ 
            return 0; 
        }
        var left = this.heights(node.left);
        var right = this.heights(node.right);
        if (left >= right) { 
            return 1 + left; 
        }
        return 1 + right;
    }


    

}



myTree = new BST();

var a = new BTNode(0);

var b = new BTNode(1);
var c = new BTNode(2);
var x = new BTNode(3);
var d = new BTNode(-1);
var e = new BTNode(-2);
var y = new BTNode(-3);
var z = new BTNode(-4);





myTree.root = a;
a.right = b;
b.right = c;
a.left = d;
d.left = e;
e.left = y;
y.left = z;
c.right = x;



console.log(myTree.heights());






