//AT Beginning of every code//
function Node(val) {
    this.val = val;
    this.next = null;
}

function SLL(head=null) {
    //attributes of SLL class
    this.head = head;

    this.insert = function (value) {
        if (!this.head) { //Adds to beginning if nothing in list
            this.head = new Node(value);
            return this;
        }
        //Traversal
        var current = this.head;
        while (current.next) {
            current = current.next;
        }//loops to last node is current
        current.next = new Node(value);
        return this;
    }
    this.printAll = function () {
        console.log("Linked List");
        if (!this.head) {
            console.log("Empty List")
            return this
        }//empty list ends

        var current = this.head;
        var count = 1;
        // console.log(count, ": ", current.val);
        while (current) {
            console.log(count, ": ", current.val);
            current = current.next;
            count++;
        }
        return this;
//END START ALL code

//Rudy the bastard who cuts the line

function SL1(){
    this.head = null;
    this.rudy = function(name);
    if(!this.head){
        this.head = new Node(name);
        return this.head;
    }
    var current = new Node(name);
    current.next = this.head;
    this.head = current;
    return this.head;
}

// check if SLL contains something
this.contains = function(val){
    var current=this.head;
    while(current){
        if (current.val === val){
            return true;
        }
        current = current.next;
    }
    return false;
}
}

//display the vals of each node, count how many nodes are in a list

function SLL(){
    this.head = null
    this.display = function(){
        if (!this.head) {
            return "";
        }
        var current = this.head;
        var newlist = "";
        var count = 0;
        while (current){
            newlist += current.val;
            count +=1;
            current = current.next
        }
    }
    console.log(newlist, count);
}

//find sum, min, max of a SLL

function sLL(){
this.head = null
    this.maxminavg = function(){
        if (!this.head) {
            return "";
        }
        var current = this.head;
        var sum = 0;
        var count = 0;
        var min = null;
        var max = null;
        while (current){
            if (current.val > max){
                max = current.val;
            }
            if (current.val < min){
                min = current.val;
            }
            sum += current.val;
            count +=1;
            current = current.next;
        }
    }
    var avg = sum/count;
    console.log(max, min, avg)
}

//move min to front

function SLL(){
    this.mintofront = function(){
        this.head=null;
        if (!this.head){
            return "";
        }
        var min = this.head;
        var current = this.head;
        var p-min = null;
        while (current.next){
            if(current.next.val < min.val){
                p-min = current;
                min = current.next;
            }
            current = current.next;
        }
        p-min.next = min.next
        min.next = this.head
    }

}

//partition: locate first node with inputted value, move all nodes with values less than that value to the front, all nodes with values greater than after that node with the value.

function Node(val){
    this.val = val;
    this.next = null;
}
function SLL(){
  this.head = null;

  this.insert = function(val){
      if(!this.head){
          this.head = new Node(val);
          return this.head;
      }
      var current = this.head;
      while (current.next){
        current = current.next;
      }
      current.next = new Node(cal);
      return this;
  }
  this.PrintAll = function(){
  console.log("Linked List");
      if (!this.head) {
          console.log("Empty List")
          return this
      }//empty list ends
      var current = this.head;
      var count = 1;
      console.log(count, ": ", current.val);
      while (current.next) {
      current = current.next;
      count++;
      console.log(count, ": ", current.val);
  }
  return this;
}
  this.partition = function (value) {
    if (!this.head || !this.head.next) {
        console.log("Empty List or too short")
        return this
    }//empty or 1 node list: do nothing
    var current = this.head;
    var found;
    if (this.head.val != value) {
        while (current.next) {
            if (current.next.val == value) {
                found = true;
                let valNode = current.next;
                current.next = valNode.next;
                valNode.next = this.head;
                this.head = valNode;
                break;
            }
            else {current = current.next;}
        }
        if(!found){
            console.log("Value not in the list");
            return this;
        }
        current = this.head;
    }
    while (current.next) {
        if (current.next.val < value) {
            let lesser = current.next;
            current.next = lesser.next;
            lesser.next = this.head;
            this.head = lesser;
        }
        else { current = current.next; }
    }
    return this;
  }//partition method
  }

var sl1 = new SLL();
sl1.insert(-1).insert(2).insert(-3).insert(6).insert(-2).insert(10).insert(5);
sl1.partition(5);
sl1.printAll();

/// Second to last find the value of the node that is second to last
this.secondtolast = function(){
  if(!this.head || !this.head.next){
  console.log("The list is not long enough");
  return null;
}
  var current = this.head;
  while(current.next.next){
    current=current.next;
}
  return current.val;
}
var sl1 = new SLL();
sl1.insert(-1).insert(2).insert(-3).insert(6).insert(-2).insert(10).insert(5);
console.log(sl1.secondtolast())

//Create a new list as a copy of a given list
function SLL(){
  this.head = null;
  this.copylist = function(){
    var newSLL = new SLL();
    newSLL.head = new Node(this.head.val);
    if(!this.head.next){
      return newSLL
    }
    else{
      var current = this.head.next;
      var newNode = newSLLhead;
      while (current) {
        newNode.next = new Node(current.val);
        current = current.next;
        newNode = newNode.next;
      }
      return newSLL;
    }
  }
}

//Filter and create a new list with values lower than "hi" and higher than "low"

function SLL(){
  this.head= null;
  this.filter = function (low, hi){
    if(!this.head){
      return null;
    }
    var current = this.head;
    var newSLL = new SLL();
    while (current){
      if(current.val < hi && current.val > low){
        if(!newSLL.head){
          newSLL.head = new Node(current.val);
          var lastNode = newSLL.head;
        }
        else {
          lastNode.next = new Node(current.val);
          lastNode = lastNode.next;
        }
      }
      current = current.next;
    }
    return newSLL;
  }
}
