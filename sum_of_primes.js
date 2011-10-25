// # 03 Sum of Primes
//
// Write a program to determine the sum of the first 1000 prime numbers.
//
// Your program should print the sum on stdout.i.e.
//
//     3682913

var is_prime = function(n){
 var ret = true;
 for(var i=2, sq = Math.sqrt(n); i<= sq; i++){
   if(( n% i) === 0 ) ret = false;
 }
 return ret;
};

var sum_1k_primes = function(){
  var n = 2,
      sum = 0,
      i = 0;

  while(i<1000){
    if(is_prime(n)){
      sum += n;
      i++;
    }
    n++;
  }
  return sum;
};


console.log(sum_1k_primes());

//var codeEvalExecute = sum_1k_primes;
