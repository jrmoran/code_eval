// # 06 Bit Positions
// ## Description: 
// Given a number n and two integers p1,p2 determine if the bits in position
// p1 and p2 are the same or not. Positions p1,p2 and 1 based.
//
// ## Input sample:
// The first argument will be a text file containing a comma separated list of
// 3 integers, one list per line. e.g. 
//
//      86,2,3
//      125,1,2
//
// ## Output sample:
//
// Print to stdout, 'true'(lowercase) if the bits are the same,
// else 'false'(lowercase). e.g.
//
//      true
//      false

prn = console.log;

// To convert a number to binary
prn( (86).toString(2) );     // 1 0 1 0 1 1 0
                             //           ^   position 2 (1 based index)
                             //         ^     position 3
                             //               they are the same

prn( (125).toString(2) );    // 1 1 1 1 1 0 1
                             //             ^   position 1
                             //           ^     position 2
                             //                 not the same

// shifting to the left by 2, index is 1 based
prn(86 >> (2 - 1));          // dec: 46 or bin: 101011
// check if the position is a 1
prn(( 86 >> (2 - 1) ) & 1);  // 1, this means yes

// shifting to the left by 3, index is 1 based
prn(86 >> (3 - 1));          // dec: 21 or bin:  10101
prn(( 86 >> (3 - 1) ) & 1);  // 1


prn((86 >> (3 - 1)).toString(2));


// # Solution
var process_line = function(line){
  var nums = line.split(','),
      n    = parseInt(nums[0], 10),
      // adjusting positions to 1 based index
      p1   = parseInt(nums[1], 10) - 1,
      p2   = parseInt(nums[2], 10) - 1;
  // shift the number to the left by p1 and p2 and compare bits
  return (((n >> p1) & 1) === ((n >> p2) & 1)).toString();
};



process_line('86,2,3');
process_line('125,1,2');
process_line('22,3,2');

var codeEvalExecute = process_line;
