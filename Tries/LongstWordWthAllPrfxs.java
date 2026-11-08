
import java.util.*;
public class LongstWordWthAllPrfxs {
    static class node {
        node[] children = new node[26];
        boolean eow;

        public node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static node root = new node();
    public static void insert(String word){
        int level = 0;
        int len = word.length();
        int idx = 0;
        node curr = root;
        for(; level<len; level++){
            idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String key){
        int level = 0;
        int len = key.length();
        int idx = 0;
        node curr = root;
        for(; level<len; level++){
            idx = key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static String ans = "";
    public static void longestWord(node root, StringBuilder temp){

        if(root==null) return;
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null && root.children[i].eow==true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(String word: words){
            insert(word);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}