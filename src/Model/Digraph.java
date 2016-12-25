package Model;

import java.util.ArrayList;

/**
 * Created by Nathnael on 12/3/2016.
 */
public class Digraph {
    private ArrayList<Integer>[] adjList;
    private final int numVertices;

    public Digraph(int numVertices)
    {
        this.numVertices = numVertices;
        adjList = (ArrayList<Integer>[]) new ArrayList[numVertices];
        for(int i =0; i < numVertices; i++){
            adjList[i] = new ArrayList<>();
        }

    }

    public Integer V(){return adjList.length;}

    public ArrayList<Integer> adj(int vertex){return adjList[vertex];}


    public void addEdge(int source, int destination){
        if(!adjList[source].contains(destination)){
            adjList[source].add(destination);
            adjList[destination].add(source);
        }

    }
}
