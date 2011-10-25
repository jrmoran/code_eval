// # 09 Fibonacci Series
// ## Description:
// The Fibonacci series is defined as:
//
//      F(0) = 0;
//      F(1) = 1;
//      F(n) = F(n-1) + F(n-2) when n>1;
//
// Given a positive integer `n`, print out the `F(n)`.
//
// ## Input sample:
// The first argument will be a text file containing a positive integer,
// one per line. e.g. 
//
//      5
//      12
//
// ## Output sample:
// Print to stdout, the fibonacci number, F(n). e.g.
//
//      5
//      144

// using the golden ration to compute the next fibonacci number
var next_fib = function(n){ return Math.round( n * 1.618033989 ); };

var fibonacci = function(str) {
  var golden_ratio = 1.618033989,
      n = parseInt(str, 10),
      ret = 1;
  if(n <= 1){ return n; }                // this covers the first two
  if(n == 2){ return 1; }                // this covers the third
  for(var i = 1; i < n - 1; i++){
    ret = next_fib(ret);
  }
  return ret;
};

console.info('----------------> 0');
console.log(fibonacci('0'));

console.info('----------------> 1');
console.log(fibonacci('1'));

console.info('----------------> 2');
console.log(fibonacci('2'));

console.info('----------------> 3');
console.log(fibonacci('3'));

console.info('----------------> 4');
console.log(fibonacci('4'));

console.info('----------------> 5');
console.log(fibonacci('5'));

console.info('----------------> 12');
console.log(fibonacci('12'));

console.info('----------------> 20');
console.log(fibonacci('20'));

