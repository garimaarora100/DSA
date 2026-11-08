// Given a string of length n of lowercase alphabet characters, find the number of unique substrings that can be formed from the given string.
import java.util.*;
public class CUnqSubs {
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
    public static int countNodes(node root){
        if(root==null) return 0;
        int count = 0;
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);}}
        return count+1;
    }
    public static void main(String[] args) {
        String str = "ababa";

        //suffix:- insert in trie
        for(int i=0; i<str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println("Count of unique substrings: "+countNodes(root));
    }
}