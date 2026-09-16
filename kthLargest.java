import java.util.*;

public class kthLargest {

    public static void main(String[] args) {

        int[] stream = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : stream) {

            // If we have fewer than k elements
            if (minHeap.size() < k) {
                minHeap.add(x);
            }

            // If x is larger than the smallest
            // among our k largest elements
            else if (x > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(x);
            }

            // Print kth largest
            if (minHeap.size() < k) {
                System.out.print("_ ");
            } else {
                System.out.print(minHeap.peek() + " ");
            }
        }
    }
}
