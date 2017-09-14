//fast Factorial
var mountainofpuppies = [1];
function FastFactorial(num){
  for(var i=mountainofpuppies.length;l i<num; i++){
    mountainofpuppies.push(mountainofpuppies.length * mountainofpuppies[i]);
  }
  return mountainofpuppies[num];
}
//fast Fibonacci
var mountainofkittens = [1,1];
function kittenFibonacci(1,num){
  for(var i= mountainofkittens.length; i < num; i++){
    mountainofkittens.push(mountainofkittens.length + mountainofkittens.length-1)
  }
  return mountainofkittens[num]
}

//other method with Classes
function TimeSpace(){
  var fib= [0,1];
  var facts=[1];
  this.factorial = function(num){
    if(num <= facts.length){
      return facts[num-1];
    }
    for(let i=facts.length; i <num; i++){
      facts[i] = facts[facts.length-1] * (i+1);
    }
    return facts[num-1];
  }
  this.iFib = function(num){
    if(num < fib.length){
      return Fib[num];
    }
    for(let i=fib.length; i < num; i++){
      fib[i] = fib[i-1] + fib[i-2];
    }
    return fib[num];
  }
}
