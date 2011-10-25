// # 11 Sum of Integers from File
// ## Description: 
// Print out the sum of integers read from a file.
//
// ## Input sample: 
// The first argument to the program will be a text file containing a
// positive integer, one per line. e.g. 
//
//    5
//    12
//
// ## Output sample:
// Print out the sum of all the integers read from the file. 
//
//    17

// Basic loop over the items of an array
var each = function(arr, f){
  for(var i = 0, l = arr.length; i < l; i++){
    f(arr[i], i);
  }
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

// Map, collects the results of calling a function
var map = function(arr, f){
  var ret = [];
  each(arr, function(item, i){
    ret.push( f(item, i) );
  });
  return ret;
};

var process_file = function(text) {
  var nums = map(text.split('\n'), function(str){ return parseInt(str, 10);});
  return reduce(nums, function(a, b){ return a + b;});
};


process_file('1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15');
