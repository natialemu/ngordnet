package Model;

import java.util.Stack;

/**
 * Created by Nathnael on 12/3/2016.
 */
public class DirectedDFS {
    private int source;
    private boolean[] visited;



    public DirectedDFS(Digraph graph, int source){

        this.source = source;
        visited = new boolean[graph.V()];
        dfs(graph,source);

    }
    public DirectedDFS(Digraph graph, Iterable<Integer> sources) {
        visited = new boolean[graph.V()];
        for (int v : sources) {
            if (!visited[v]) dfs(graph, v);
        }
    }
    private void dfs(Digraph graph, int s){


        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!visited[v]){
                visited[v] = true;
                for(int w : graph.adj(v)){
                    if(!visited[w]){
                        stack.push(w);
                    }
                }
            }

        }

    }
    public boolean marked(int verex){
        return visited[verex];

    }

    public boolean pathExists(int target){
        return visited[target];
    }
}
