// Create a function boolean startsWith(String prefix) for a trie.
// Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
import java.util.*;
public class startsWith {
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
    public static boolean startWith(String prefix){
        node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String args[]){
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(startWith(prefix1)); // true
        System.out.println(startWith(prefix2)); // false
    }
}
