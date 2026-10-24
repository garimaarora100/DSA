import java.util.*;
public class TreeMapEx{
    public static void main(String args[]){
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 50);
        tm.put("China", 150);
        tm.put("US", 100);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(tm);
    }
}