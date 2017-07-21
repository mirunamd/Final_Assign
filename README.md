# Final_Assign

Given an array say 
1, 2, 0, 3
and an expected output
3, 1, 2, 0

My algorithm uses a HashMap to store the links between the values and their expected indexes:
1 -> 1
2 -> 2
0 -> 3
3 -> 0
And and the input array to iterate through. 

It starts first by checking if the current element is not at the current index. If it's not, it looks for the index at which it belongs and then if that element is not 0, it puts it in the empty slot and places the current element at the right index.

I think this is being done in O(n).
