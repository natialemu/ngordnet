package Model;
import java.util.TreeSet;
import java.util.Set;
/**
 * Created by Nathnael on 12/3/2016.
 */
public class GraphHelper {
    public static Set<Integer> descendants(Digraph G, Set<Integer> synsetIDs) {
        DirectedDFS dfs = new DirectedDFS(G, synsetIDs);
        TreeSet<Integer> reachableVertices = new TreeSet<Integer>();

        for (int i = 0; i < G.V(); i += 1) {
            if (dfs.marked(i)) {
                reachableVertices.add(i);
            }
        }
        return reachableVertices;
    }
}
