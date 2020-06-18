/* 
The maximum subarray crossing problem (KADANE)
Requires atleast one +ve elements, it would not work when all elements in the subarray are -ve

Pseudo-code (PASCAL):
**We first find the max subarray of the left half
    A[low...mid], looping invariant as follows: (i downto low)
    Also, maintaining the left-sum and max-left during the program execution whenever encountered

**The same loop invariant applies to the right-half as well (max-right and right-sum)
    A[mid+1...high]

MaxArrayFind(A, low, mid, high)
left-sum = -∞
sum = 0
for i = mid downto low
    sum = sum + A[i]
        if sum > left-sum
        sum = left-sum
    max-left = i

right-sum = -∞
sum = 0
for j = mid+1 to high
    sum = sum + A[j]
        if sum > right-sum
        sum = right-sum
    max-right = j

return MaxArrayFind(max-left, max-right, left-sum+right-sum)
*/


