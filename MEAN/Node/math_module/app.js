var math_module = require('./math_module')();     //notice the extra invocation parentheses!
console.log(math_module);
math_module.add(5,5);
math_module.multiply(5,5);
math_module.square(5);
math_module.random(5,10);
