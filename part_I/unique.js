// # 14 Unique Elements
// ## Description:
// You are given a sorted list of numbers with duplicates. Print out the sorted list with duplicates removed.
//
// ## Input sample:
// File containing a list of sorted integers, comma delimited, one per line. e.g. 
//
//      1,1,1,2,2,3,3,4,4
//      2,3,4,5,5
//
// ## Output sample:
// Print out the sorted list with duplicates removed, one per line e.g.
//
//      1,2,3,4
//      2,3,4,5

var unique = function(line) {
  var nums = line.split(','),
      list = {};
  for(var i = 0, l = nums.length; i < l; i++){
    var prop = nums[i];
    if(list.hasOwnProperty(prop) === false){
      list[prop] = true;
    }
  }
  var ret = [];
  for(var p in list){
    ret.push( p );
  }
  return ret.join(',');
};

unique('1,1,1,2,2,3,3,4,4');
unique('2,3,4,5,5');
