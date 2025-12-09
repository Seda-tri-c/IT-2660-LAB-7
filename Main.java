public class Main {
    public static void main(String[] args) {

        // 1. Vertices
        java.util.List<String> vertices = java.util.Arrays.asList(
                "Liberal Arts",                // 0
                "Student Services",            // 1
                "Health Careers & Sciences",   // 2
                "Health Technologies Center",  // 3
                "Recreation Center",           // 4
                "Technology Learning Center",  // 5
                "Business & Technology",       // 6
                "Theatre"                      // 7
        );

        // 2. Edges 
        int[][] edges = {
                {0, 1},   // Liberal Arts – Student Services
                {1, 2},   // Student Services – Health Careers
                {2, 3},   // Health Careers – Health Tech
                {2, 4},   // Health Careers – Recreation
                {4, 5},   // Recreation – TLC
                {5, 6},   // TLC – Business & Tech
                {6, 7},   // Business & Tech – Theatre
                {1, 7}    // Student Services – Theatre
        };

        // 3. Create graph
        UnweightedGraph<String> graph = new UnweightedGraph<>(edges, vertices);

        // 4. DFS starting from Business & Technology (vertex 6)
        AbstractGraph<String>.Tree dfs = graph.dfs(6);

        // 5. Print DFS search order
        System.out.println("DFS Search Order starting from Business & Technology:");
        System.out.println(dfs.getSearchOrder());
        System.out.println();

        // 6. Print parent-child relationships
        System.out.println("Parent-Child Relationships:");
        for (int i = 0; i < vertices.size(); i++) {
            int parent = dfs.getParent(i);
            if (parent != -1) {
                System.out.println(vertices.get(parent) + " -> " + vertices.get(i));
            } else if (i == 6) {
                System.out.println(vertices.get(i) + " is the root");
            }
        }
        System.out.println();

        // 7. Print required paths
        System.out.println("Path from Business & Technology to Health Technologies Center:");
        dfs.printPath(3);
        System.out.println();

        System.out.println("Path from Business & Technology to Student Services:");
        dfs.printPath(1);
        System.out.println();

        System.out.println("Path from Business & Technology to Recreation Center:");
        dfs.printPath(4);
        System.out.println();

        // 8. Print whole DFS tree
        System.out.println("DFS Tree:");
        dfs.printTree();
    }
}
