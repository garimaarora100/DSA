import java.util.*;
public class insert {
    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Indonesia", 5);
        hm.put("Nepal", 6);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k: keys) {
            System.out.println("key = "+k+", "+"value = "+hm.get(k));
        }
    }
}
