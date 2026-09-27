import java.util.*;
public class operations {

    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

     //Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println(hm);

        //Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        //ContainsKey - O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        //Remove
        System.out.println(hm.remove("USA"));
        System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //Is empty
        hm.clear();
        System.out.println(hm.isEmpty());

    }
}