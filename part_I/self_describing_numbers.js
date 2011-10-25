// # 18 Self Describing Numbers
//
// ## Description: 
// A number is a self-describing number when (assuming digit positions are
// labeled 0 to N-1), the digit in each position is equal to the number of
// times that that digit appears in the number.
//
// ## Input sample:
// The first argument is the pathname to a file which contains test data,
// one test case per line. Each line contains a positive integer.
// Each line is in the format: N i.e. a positive integer eg.  
//
//      2020
//      22
//      1210
//
// ## Output sample:
// If the number is a self-describing number, print out a 1.
// If not, print out a 0 eg.
//
//      1
//      0
//      1
//
// For the curious, here's how 2020 is a self-describing number:
// * Position '0' has value 2 and there is two 0 in the number.
// * Position '1' has value 0 because there are not 1's in the number.
// * Position '2' has value 2 and there is two 2.
// * And the position '3' has value 0 and there are zero 3's.

// Basic loop over the items of an array
var each = function(arr, f){
  for(var i = 0, l = arr.length; i < l; i++){
    f(arr[i], i);
  }
};
// Map, collects the results of calling a function
var map = function(arr, f){
  var ret = [];
  each(arr, function(item, i){
    ret.push( f(item, i) );
  });
  return ret;
};

// return an object with unique items
var unique = function(arr){
  var obj = {};
  each(arr, function (a) {
    if(!obj.hasOwnProperty(a)){
      obj[a] = 0;
    }
  });
  return obj;
};

var self_describe = function (numstr) {
  // get all digits
  var digits = map(numstr, function(digit){ return parseInt(digit, 10); }),
      uniques = unique(digits),
      // reads from RL, ie {'0': 2} there are two zeroes
      positions = {};
  // go over each digit, store positions and repetitions
  map(digits, function(digit, i){
    if (digit !== 0){ positions[i] = digit; }
    if(uniques.hasOwnProperty(digit)){
      uniques[digit] += 1;
    }
  });
  var ret = 1;
  // now, go over positions and compare with uniques object.
  for(var p in positions){
    if(uniques.hasOwnProperty(p)){
      if(uniques[p] !== positions[p]){
        ret = 0;
      }
    }else{
      ret = 0;
    }
  }
  return ret;
};

self_describe('2020');
self_describe('22');
self_describe('1210');
