// # 04 Reverse words
//
// ## Description:
// Write a program to reverse the words of an input sentence.
//
// ## Input sample:
// The first argument will be a text file containing multiple sentences,
// one per line. Possibly empty lines too. e.g. 
//
//     Hello World
//     Hello CodeEval
//
// ## Output sample:
//
// Print to stdout, each line with its words reversed, one per line.
// Empty lines in the input should be ignored. Ensure that there are no
// trailing empty spaces on each line you print. 
//
//     World Hello
//     CodeEval Hello

var reverse_line = function(line){
  var words = line.split(' '),
      ret   = [];
  for(var i = words.length - 1; i >= 0; i--){
    ret.push( words[i] );
  }
  return ret.join(' ');
};


console.log(reverse_line("Hello CodeEval"));
var codeEvalExecute = reverse_line;
