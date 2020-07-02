// Given a non-empty array of integers, return the k most frequent elements.

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent_heap(int[] nums, int k) {
        if(k == nums.length) {
            return nums;
        }

        //Building the map(recorded freq inclusive) --> O(n)
        Map<Integer, Integer> freqMap = new HashMap();
        for(int i: nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        //Building the heap of the least freq elem
        Queue<Integer> minHeap = new PriorityQueue<>((num1, num2) -> freqMap.get(num1) - freqMap.get(num2));

        //Maintain the top K in the heap
        for(int i: freqMap.keySet()) {
            minHeap.add(i);
                if(minHeap.size() > k) {
                    minHeap.poll();
                }
        }

        //Building the out array
        int[] out_frequent = new int[k];
        for(int i = k-1; i>=0; --i){
            out_frequent[i] = minHeap.poll();
        }
        return out_frequent;
    }
}