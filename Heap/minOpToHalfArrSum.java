/* We have an array Arr[], the task is to find out the minimum number of operations to make the
sum of array elements lesser or equal to half of its initial value. In one such operation, it is
allowed to half the value of any array element.
Sample Input 1 : [1, 5, 8, 19]
Sample Output 1 : 3 */
import java.util.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class minOpToHalfArrSum {
    static int minOp(int arr[]){
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int x : arr){
            pq.add((double)x);
            sum+=x;
        }
        double target = sum/2;
        int op = 0;
        while(sum>target){
            double largest = pq.poll();
            double half = largest/2;
            sum = sum-largest+half;
            pq.add(half);
            op++;
        }
        return op;
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 19};
        System.out.println(minOp(arr));
    }
}
