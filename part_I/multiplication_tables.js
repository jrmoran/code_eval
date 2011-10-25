// # 10 Multiplication Tables
// ## Description:
// Print out the grade school multiplication table upto 12*12.
//
// ## Input sample:
// None
//
// ## Output sample:
// Print out the table in a matrix like fashion, each number formatted to
// a width of 4. The first 3 line will look like: 
//
//      1   2   3   4   5   6   7   8   9  10  11  12
//      2   4   6   8  10  12  14  16  18  20  22  24
//      3   6   9  12  15  18  21  24  27  30  33  36

var print_table = function() {
  var lines = [];
  for(var i = 1; i <= 12; i++){
    var row = [],
        pro = 0,
        spc = '';
    for(var j = 1; j <= 12; j++){
      pro = (i * j).toString();
      spc =  pro.length === 1 ? '   ' : pro.length === 2 ? '  ' : ' ';
      row.push(spc + pro);
    }
    lines.push(row.join(''));
  }
  return lines.join('\n');
};

print_table();
