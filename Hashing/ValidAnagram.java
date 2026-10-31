import java.util.*;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer>  map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

            for(int j=0; j<t.length(); j++){
                char c = t.charAt(j);
                if(map.get(c) == 1){
                    map.remove(c);
                } else{
                    map.put(c, map.get(c)-1);
                }
            // } else {
            //     return false;
            // }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
        System.out.println(isAnagram(s, t));

    }
}
