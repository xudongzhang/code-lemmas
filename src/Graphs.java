
// Graphs
// Static methods for Graph interface


import java.util.Set;
import java.util.HashSet;
import java.util.Stack;



// This class contains static methods for the Graph interface.
// In Java 8 though you can put static methods into an interface.
// N is for node, E for edge
public class Graphs {

    // Do depth first search on given Graph object, starting
    // with and searching for the given nodes.
    static <N, E> N dfs(Graph<N, E> g, N start, N find) {
        Stack<N> unseen = new Stack<N>();
        Set<N> seen = new HashSet<N>();
        unseen.push(start);
        while (!unseen.empty()) {
            N n = unseen.pop();
            System.out.println("visiting " + n);
            if (n.equals(find)) return n;
            seen.add(n);
            // adding from left to right, so will be searched right to left - change if that's an issue
            for (E e : g.getEdges(n)) {
                N dest = g.getDestination(e);
                if (!seen.contains(dest)) {
                    unseen.push(dest);
                }
            }
        }
//        return new N("NullObject"); // can't do due to type erasure
        return null;
    }


    // Return a string representation of the given graph -
    // a list of nodes and where they exit to
    static <N, E> String asString(Graph<N, E> g) {
        StringBuilder sb = new StringBuilder();
        for (N n : g.getNodes()) {
            sb.append(n + "->" + g.getEdges(n) + "\n");
        }
        return sb.toString();
    }
}




