import java.util.*;


public class minTymReqNSlots {
    static class Pair{
    int position, time;
    Pair(int position, int time){
        this.position = position;
        this.time = time;
    }
}
    static int minTym(int N, int arr[]){
        boolean[] visited = new boolean[N+1];
        Queue<Pair> queue = new LinkedList<>();
        for(int x : arr){
            visited[x] = true;
            queue.add(new Pair(x, 0));
        }
        int maxtime = 0;
        while(!queue.isEmpty()){
            Pair current = queue.remove();
            int position = current.position;
            int time = current.time;
            maxtime = Math.max(time, maxtime);

            if(position - 1 >= 1 && !visited[position-1]){
                visited[position-1] = true;
                queue.add(new Pair(position-1, time+1));
            }
            if(position + 1 <= N && !visited[position+1]){
                visited[position+1] = true;
                queue.add(new Pair(position+1, time+1));
            }
        }
        return maxtime;
    }
    public static void main(String[] args) {
        int N=6, arr[]={2,6};
        System.out.println(minTym(N, arr));
    }
}
