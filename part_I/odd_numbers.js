// # 12 Odd Numbers
// ## Description:
// Print the odd numbers from 1 to 99.
// ## Output sample:
// Print the odd numbers from 1 to 99, one number per line.

var odd_nums = function(){
  var i = -1,
      ret = [];
  while(i < 99){
    ret.push(i+=2);
  }
  return ret.join('\n');
};

odd_nums();
