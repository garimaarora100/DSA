import java.util.*;

public class mergeKLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node mergeKLists(Node[] lists){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while(!pq.isEmpty()){
            Node smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
    static void printList(Node head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node List1 = new Node(1);
        List1.next = new Node(3);
        List1.next.next = new Node(7);

        Node List2 = new Node(2);
        List2.next = new Node(4);
        List2.next.next = new Node(8);

        Node List3 = new Node(9);
        List3.next = new Node(10);
        List3.next.next = new Node(11);

        Node lists[] = {List1, List2, List3};

        Node result = mergeKLists(lists);
        printList(result);

    }
}
