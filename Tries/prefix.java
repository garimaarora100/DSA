// Find shortest unique prefix for every word in a given list.
// Assume no word is prefix of another.
import java.util.*;
public class prefix {
    static class node {
        node[] children = new node[26];
        boolean eow = false;
        int freq;
        public node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;}
            freq = 1;}}
    public static node root = new node();
    public static void insert(String word){
        node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new node();} else{
                curr.children[idx].freq++;}
            curr = curr.children[idx];}
        curr.eow = true;}
    public static void findPrefix(node root, String ans){
        if(root==null) return;
        if(root.freq ==1){
            System.out.println(ans);
            return;}
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char)(i+'a')); }}} 
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(String word : arr){
            insert(word); }
        root.freq =  -1;
        findPrefix(root, "");}}
