# # 11 Sum of Integers from File
# ## Description: 
# Print out the sum of integers read from a file.
#
# ## Input sample: 
# The first argument to the program will be a text file containing a
# positive integer, one per line. e.g. 
#
#    5
#    12
#
# ## Output sample:
# Print out the sum of all the integers read from the file. 
#
#    17


file = File.open ARGV[0], 'rb'
puts file.read.split.map{ |str| str.to_i }.inject(:+)
