//Given an array of size n, find the majority element. The majority element is the element that appears more than n/3 times. You may assume that the array is non-empty and the majority element always exist in the array.
//input1: {1, 3, 2, 5, 1, 3, 1, 5, 1}
//output1: 1
//input2: {1, 2}
//output2: 1, 2

import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            // if(map.containsKey(arr1[i])){
            //     map.put(arr1[i], map.get(arr1[i]) + 1);
            // } else {
            //     map.put(arr1[i], 1);
            // }
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        // Set<Integer> keySet = map.keySet();
        for(Integer key : map.keySet()){
            if(map.get(key)>arr1.length/3){
                System.out.println(key);
            }
        }
    }
}
