# # File Size
# ## Description:
# Print the size of a file in bytes.
#
# ## Input sample:
# Path to a filename. e.g. 
#
#     foo.txt
#
# ## Output sample:
# Print the size of the file in bytes. e.g.
#
#     55

file = File.open ARGV[0], 'rb'
puts file.size
