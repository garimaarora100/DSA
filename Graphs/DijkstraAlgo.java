import java.util.*;

public class DijkstraAlgo {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s, int d, int w){
            this.src = s;
            this.dest= d;
            this.wt =w;
        }
    }
    static void createGraph(ArrayList<edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));

        graph[2].add(new edge(2,4,3));
        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,2));
        graph[4].add(new edge(4,5,5));
    }
    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n, int path){
            this.n = n;
            this.path=path;
        }
        @Override 
        public int compareTo(pair p2){
            return this.path-p2.path;//path based sorting for my pairs
        }
    }
    public static void dijkstra(ArrayList<edge> graph[], int src){
        int dist[] = new int[graph.length]; //dist[i] -> src to i
        for(int i=0; i<graph.length; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE; //+infinity

            }
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src,0));

        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0; i<graph[curr.n].size();i++){
                    edge e=graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt= e.wt;

                    if(dist[u]+wt <dist[v]){ //update distance of src to v
                        dist[v] = dist[u]+wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }
        //print all src to vertices shortest distance
        for(int i=0; i<dist.length; i++){
            System.out.println(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src=0;
        dijkstra(graph, src);
    }
}
