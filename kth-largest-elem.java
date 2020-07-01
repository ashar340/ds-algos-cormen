import java.util.Arrays;
import java.util.PriorityQueue;

/* Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. */

class Solution {
    public int findKthLargest_sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /*
     * Add elems of the [] to the heap Maintain the heap-size >= k (heap.poll() to
     * eliminate) After traversal, poll the head
     */

    public int findKthLargest_minHeap(int[] nums, int k) {
        // Smallest first
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((num1, num2) -> num1 - num2);

        // Maintaining the k
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();

    }
}