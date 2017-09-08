function SLStack(){
    var top = null; //push and pop to the top variable
    var counter = 0;
    //printAll
    this.print = function () {
        if (!top) {
            console.log("Empty Stack");
            return this;
        }
        console.log("Singly Linked Stack");
        var current = top;
        var count = 1;
        while (current) {
            console.log(count + ": " + current.val);
            count++;
            current = current.next;
        }
        return this;
    }
    //push
    this.push = function (val) {
        if(!top){
            top = new Node(val);
            counter++;
            return this;
        }
        var newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        counter++;
        return this;
    }
    //pop
    this.pop = function () {
        if (!top) {
            return null;
        }
        var temp = top.val;
        top = top.next;
        counter--;
        return temp;
    }
    //top
    this.top = function () {
        return top.val;
    }

    //isEmpty
    this.isEmpty = function () {
        if (!top) { return true; }
        else { return false; }
    }
    //contains
    this.contains = function (val) {
        if (!top) {return false;}
        var current = top;
        while(current){
            if(current.val === val){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    //size
    this.size = function () {
        return counter;
    }
}

//You have two stacks, and want to be able to manipulate them like a queue. See photo taken for illustration. Considering this, create enqueue, dequeue operations. You can call on the methods you created above to complete these operations.

//non-optimized version
function SLQueueStack(){
  var first = new SLStack();
  var second = new
  this.enqueue = function(val){
    first.push(val);
    return this;
  }
  this.dequeue = function(){
    for(let i=0; i < first.size(); i++){
      second.push(first.pop());
    }
    var temp=second.pop();
    for(let i =0; i <second.sioze(); i++){
      first.push(second.pop());
    }
    return temp;
  }
}

//optimized version
function SLQueueStack(){
  var first = new SLStack();
  var second = new
  var isPushable = true;
  this.makeEnqueuable = function(){
    var size = second.size();
    if (!isPushable){
      for(let i =0; i < size; i++){
        first.push(second.pop());
      }
    }
  }
  this.makeDequeuable = function(){
    var size= first.size();
    if(Pushable){
      for(let i =0; i <size; i++){
        second.push(first.pop());
      }
      isPushable == true;
    }
  }
  this.enqueue = function(){
    this.makeEnqueuable();
    first.push(val);
    return this;
  }
  this.dequeue = function(){
    this.makeDequeuable();
    return second.pop();
  }
}

var q1 = new SLQueueStack();
q1.enqueue("A").enqueue("B").enqueue("C").enqueue("D").print();
q1.dequeue();
