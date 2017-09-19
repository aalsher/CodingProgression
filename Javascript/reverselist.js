function reverseList(SList){
  if(!Slist){
    return false;
  }
  var count = 0;
  var temp;
  var last;
  var prelast;
  var head = SList.head;
  while(current.next){
    current = current.next;
    count ++;
  }
  last = current;
  postlast = current;
  temp = current;
  for(var i=0; i < count; i++){
    if(current.next == temp){
      var newnode = new Node(current.val);
      postlast.next = newnode.val;
      postlast = newnode;
      current = temp;
    }
    last = this.head;
  }
}
