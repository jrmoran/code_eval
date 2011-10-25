// # Stack Implementation  Share on LinkedIn
// 
// ## Description:
// Write a program implementing a stack inteface for integers.
// The interface should have 'push' and 'pop' functions. 
// You will be asked to 'push' a series of integers and then 'pop' 
// and print out every alternate integer.
//
// ## Input sample:
// The first argument will be a text file containing a series of 
// space delimited integers, one per line. e.g. 
// 
//      1 2 3 4
//      10 -2 3 4
//
// ## Output sample:
// Print to stdout, every alternate integer(space delimited), one per line.
// 
//      4 2
//      4 -2

var MakeStack = function (){
  // internal data and index
  var data = [],
      i    = 0;
  return {
    push: function (item){ data[i++] = item; },
    // only decrease index when there's at least one item left
    pop: function () { return i >= 1 ? data[--i] : undefined; },
    count: function() {return i; }
  };
};

// my helper functions
var each = function(arr, f){
  for(var i = 0, l = arr.length; i < l; i++){
    f(arr[i], i);
  }
};

var map = function(arr, f){
  var ret = [];
  each(arr, function(item, i){
    ret.push( f(item, i) );
  });
  return ret;
};

// main
var process_line = function(line) {
  var nums = map(line.split(" "), function(s){ return parseInt(s, 10); });
  //
  // add each number to the stack
  var myStack = MakeStack();
  each( nums, function (n) { myStack.push( n ); });
  //
  // print every alternate items
  var ret = [],
      i = myStack.count();
  while( i > 0 ){
    ret.push( myStack.pop() );
    myStack.pop();
    i -= 2;
  }
  return ret.join(' ');
};


process_line('1 2 3 4');

process_line('10 -2 3 4');

// testing
var myStack = MakeStack();
myStack.push( 1 );
myStack.push( 2 );
myStack.push( 3 );
console.log(myStack.count());

console.log( myStack.pop() === 3 ? 'OK' : 'NOPE');
console.log( myStack.pop() === 2 ? 'OK' : 'NOPE');
console.log( myStack.pop() === 1 ? 'OK' : 'NOPE');
console.log( myStack.pop() === undefined ? 'OK' : 'NOPE');

