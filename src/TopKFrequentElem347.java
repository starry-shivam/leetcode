import utils.ExecDuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElem347 {

    static class Pair implements Comparable<Pair> {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair other) {
            return this.freq - other.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        var priorityQueue = new PriorityQueue<Pair>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            priorityQueue.add(new Pair(key, freqMap.get(key)));
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            var freq = priorityQueue.remove();
            ans[i] = freq.num;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElem347 obj = new TopKFrequentElem347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
        ExecDuration.measure(() -> obj.topKFrequent(nums, k));
    }
}
