function isLoop(SLL){
  if(!this.head || !this.head.next){
    return False;
  }
  var slow = this.head;
  var speedy = this.head.next;
  while(speedy != null){
    if(slow === speedy){
      return true;
    }
    else {
      if(speedy.next){
        speedy = speedy.next.next;
        slow = slow.next;
      } else{
        return False;
      }
  }
  return False;
}
