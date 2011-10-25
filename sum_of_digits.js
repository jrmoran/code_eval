// # 08 Sum of Digits
// ## Description:
// Given a positive integer, find the sum of its constituent digits.
//
// ## Input sample:
// The first argument will be a text file containing positive integers,
// one per line. e.g. 
//
//     23
//     496
//
// ## Output sample:
// Print to stdout, the sum of the numbers that make up the integer, one per line.
// e.g.
//
//      5
//      19

var sum_digits = function(str) {
  var sum = 0;
  for(var i=0, l=str.length; i < l; i++){
    sum += parseInt(str[i], 10);
  }
  return sum;
};

sum_digits('23');
sum_digits('496');
