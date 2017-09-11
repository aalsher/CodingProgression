function FizzBuzz(){
  for( var i=1; i<= 100; i++){
    if(i % 3 ==0 || i % 5 == 0){
      if(i % 3 == 0){
        console.log("Fizz");
      }
      if(i % 5 == 0){
        console.log("Buzz");
      }
    }
    else{
      console.log(i);
    }
  }
}

function FizzBuzz(){
  for( var i=1; i<= 100; i++){
    if(i % 3 ==0 || i % 5 == 0){
      var str = "";
      if(i % 3 == 0){
        str += "Fizz";
      }
      if(i % 5 == 0){
        str += "Buzz";
      }
    }
    else{
      console.log(i);
    }
  }
}
