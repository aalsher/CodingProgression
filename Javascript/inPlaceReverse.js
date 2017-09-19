function inPlaceReverse(SLList){
  if(!SLList){
    return false;
  }
  var head = SLList.head;
  var anchor = head.next;
  var last = head.next;
  var current = head;
  while(current.next.next){
    current = current.next;
    anchor = anchor.next.next;
    last = last.next.next;
  }
  while(head != anchor){
    while(current.next.next != anchor){
      current = current.next;
    }
    last.next = current.next;
    current.next = anchor;
    last = last.next;
    current = head;
    head = head.next;
  }
  return SLList;
}
