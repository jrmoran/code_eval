// # 17 Happy Numbers
// ## Description:
// A happy number is defined by the following process. Starting with
// any positive integer, replace the number by the sum of the squares
// of its digits, and repeat the process until the number equals 1 
// (where it will stay), or it loops endlessly in a cycle which does
// not include 1. Those numbers for which this process ends in 1 are
// happy numbers, while those that do not end in 1 are unhappy numbers.
//
// ## Input sample:
// The first argument is the pathname to a file which contains test data,
// one test case per line. Each line contains a positive integer. Each line
// is in the format: N i.e. a positive integer eg.
//
//      1
//      7
//      22
//
// ## Output sample:
// If the number is a happy number, print out a 1. If not, print out a 0 eg.
//
//      1
//      1
//      0
//
// For the curious, here's why 7 is a happy number:
//
//      7->49->97->130->10->1.
//
// Here's why 22 is NOT a happy number:
//
//      22->8->64->52->29->85->89->145->42->18->65->61->37->58->89...

// Basic loop over the items of an array
var each = function(arr, f){
  for(var i = 0, l = arr.length; i < l; i++){
    f(arr[i]);
  }
};
// Map, collects the results of calling a function
var map = function(arr, f){
  var ret = [];
  each(arr, function(item){
    ret.push( f(item) );
  });
  return ret;
};

// Reduce keeps track of the return value of the previous fun call
// * `arr` is an array
// * `f` should evaluate two arguments `item` and `previous return value`
// * `acc` is the accumulator
var reduce = function(arr, f, acc){
  if( typeof acc === 'undefined') acc = 0;
  each(arr, function(item){
    acc = f(item, acc);
  });
  return acc;
};

var happy_numbers = function (numstr) {
  var digitize = function (str) {
    return map(str, function(digit){ return parseInt(digit, 10); });
  };
  // accumulator computes the square sum of a number and... accumulates
  // it. This is used by `reduce`
  var reductor = function(x, acc){ return x * x + acc; },
      ret = numstr,
      counter = 0;
  // the sensitivity is 1000
  while( ret !== '1' && counter < 1000){
    // sum all digits and parse the result back to a string, since I
    // need to digitize the result back for the next evaluation
    ret = reduce( digitize(ret), reductor).toString();
    counter++;
  }
  return ret === '1' ? ret : 0;
};

happy_numbers('1');
happy_numbers('7');
happy_numbers('22');
