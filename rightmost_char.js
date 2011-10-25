// # 16 Rightmost Char
// ## Description:
// You are given a string 'S' and a character 't'.
//
// Print out the position of the rightmost occurrence of 't'(case matters)
// in 'S' or -1 if there is none. The position to be printed out is zero based.
//
// ## Input sample:
// The first argument is a file, containing a string and a character,
// comma delimited, one per line. Ignore all empty lines in the input file.e.g. 
//
//      Hello World,r
//      Hello CodeEval,E
//
// ## Output sample:
// Print out the zero based position of the character 't' in string 'S',
// one per line. Do NOT print out empty lines between your output.
//
//      8
//      10

var process_line = function(line){
  var strs = line.split(','),
      word = strs[0],
      chr  = strs[1];
  return word.lastIndexOf(chr);
};

process_line( 'World,r');            // 2
process_line( 'Hello CodeEval,E');   // 20
process_line( 'Hello CodeEval,l');   // 13
process_line( 'Hello CodeEval,k');   // -1
