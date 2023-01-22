import java.util.ArrayList;

public class Main {

    public static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,4));
        graph[1].add(new Edge(1,2));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[5].add(new Edge(5,4));
    }

    public static boolean cycle_detect_undirected_graph(ArrayList<Edge> graph[], boolean visite[], int currt, int part){
        visite[currt] = true;
        for(int i=0;i<graph[currt].size();i++){
            Edge e = graph[currt].get(i);
            if(visite[e.dest]&&e.dest!=part){
                return true;
            } else if (!visite[e.dest]) {
                if(cycle_detect_undirected_graph(graph, visite, e.dest, currt)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(cycle_detect_undirected_graph(graph, new boolean[v], 0, -1));


    }
}