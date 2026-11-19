import java.util.*;

public class topSortUsngBFS{
    static class edge{
        int src;
        int dest;

        public edge(int s, int d){
            this.src = s;
            this.dest=d;
        }
    }
    static void createGraph(ArrayList<edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new edge(2,3));
        graph[3].add(new edge(3,1));
        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));
        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));
    }
    public static void indegree(ArrayList<edge>[] graph, int indeg[]){
        for(int i=0; i<graph.length; i++){
            int v=i;
            for(int j=0; j<graph[v].size(); j++){
                edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<edge>[] graph){
        int indeg[] = new int[graph.length];
        indegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        //BFS
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++){
                edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<edge> graph[] = new ArrayList[V];

        createGraph(graph);
        topSort(graph);
    }
}