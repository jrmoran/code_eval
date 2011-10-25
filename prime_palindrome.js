// # 02 Prime Palindrome
// Write a program to determine the biggest prime palindrome under 1000.
//
// Your program should print the largest palindrome on stdout. i.e.
//
//      929

// Primality test using Sieve of Eratosthenes algo
var is_prime = function(n){
 var ret = true;
 for(var i=2, sq = Math.sqrt(n); i<= sq; i++){
   if(( n% i) === 0 ) ret = false;
 }
 return ret;
};

// Checks if a number > 0, but < 1000 is palindrome
var is_palindrome = function(n){
  var str = n.toString(),
      rev = '';
  for(var i = str.length - 1; i >= 0; i--){
    rev += str[i];
  }
  return str === rev;
};

var is_palprime = function(n){
  if(is_prime(n)){
    if(is_palindrome(n)){
      return true;
    }
  }
  return false;
};

// start from 1000 and stop when a palprime is found
var countdown = function(){
  var n = 1000;
  while(n > 1){
    if(is_palprime(n)){ return n; }
    n--;
  }
};

countdown();
