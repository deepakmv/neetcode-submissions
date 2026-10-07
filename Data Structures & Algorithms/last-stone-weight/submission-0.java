class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones) {
            maxHeap.offer(i);
        }

        while(maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            int diff = largest-secondLargest;
            if(diff > 0) {
                maxHeap.offer(diff);
            }
        }

        int remaining = (maxHeap.size() == 1) ? maxHeap.peek() : 0;
        return remaining;
    }
}
