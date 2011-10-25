// # 15 Set Intersection
// ## Description:
// You are given two sorted list of numbers(ascending order).
// The lists themselves are comma delimited and the two lists are semicolon
// delimited. Print out the intersection of these two sets.
//
// ## Input sample:
// File containing two lists of ascending order sorted integers,
// comma delimited, one per line. e.g. 
//
//      1,2,3,4;4,5,6
//      7,8,9;8,9,10,11,12
//
// ## Output sample:
// Print out the ascending order sorted intersection of the two lists, one per line
//
//      4
//      8,9

// JavaScript sort
//
//     [103, 11].sort()   // 103, 11
//
// I need a comparator so numbers are sorted properly
//
//      [9, 18, 3].sort(function(x, y){ return x - y; });  // 3, 9, 18


// Basic loop over the items of an array
var each = function(arr, f){
  for(var i = 0, l = arr.length; i < l; i++){
    f(arr[i]);
  }
};

var map = function(arr, f){
  var ret = [];
  each(arr, function(item){
    ret.push( f(item) );
  });
  return ret;
};

// returns a set with the unique elements repeated in a two lists
var intersection = function(arra, arrb){
  var la,
      sa,
      ret = {};
  // determine which array is the largest one and which is the smallest
  if(arra.length > arrb.length){
    la = arra;
    sa = arrb;
  }else{
    la = arrb;
    sa = arra;
  }
  each(la, function(a){
    each(sa, function(b){
      if( a === b ){
        if(ret.hasOwnProperty(a)){
          ret[a] += 1;
        }else{
          ret[a] = 1;
        }
      }
    });
  });
  return ret;
};

// returns keys of an object
var keys = function(obj) {
  var ret = [];
  for(var i in obj){
    ret.push( i );
  }
  return ret;
};

var process_line = function(line){
  var lists = line.split(';'),
      parser = function(i){ return parseInt(i, 10);},
      a = map(lists[0].split(','), parser),
      b = map(lists[1].split(','), parser),
      set = intersection(a, b);
  // getting sorted keys from intersection
  return keys(set).sort(function(x, y){ return x - y; }).join(',');
};

var codeEvalExecute = process_line;

process_line('1,2,3,4;4,5,6');                  // '4'
process_line('7,8,9;8,9,10,11,12');             // '8,9'

process_line('1,2,3,4;3,4,5,6');                // '3,4'
process_line('20,25,36,45,89;25,36,77,88,98');  // '25,36'
process_line('9,10,11;11,12,13');               // '11'
process_line('9,10,11;33,34,35');               // ''
