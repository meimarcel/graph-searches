package com.example.marcel.GraphsAlgorithms.endpoint;

import com.example.marcel.GraphsAlgorithms.algorithms.AST;
import com.example.marcel.GraphsAlgorithms.algorithms.BFS;
import com.example.marcel.GraphsAlgorithms.algorithms.DFS;
import com.example.marcel.GraphsAlgorithms.models.Graph;
import com.example.marcel.GraphsAlgorithms.models.Grid;
import com.example.marcel.GraphsAlgorithms.models.Node;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AlgorithmsEndpoint {

    @PostMapping("/search/bfs")
    public ResponseEntity<?> searchBFS(@RequestBody Grid grid) {
        Node initial = new Node(grid.getInitialX(), grid.getInitialY());
        Node end = new Node(grid.getEndX(), grid.getEndY());
        Graph graph = new Graph();
        BFS algorithm = new BFS(grid.getGrid(), initial, end, graph);
        algorithm.search();
        algorithm.definePath();
        graph = algorithm.getGraph();

        return ResponseEntity.ok(graph);
    }

    @PostMapping("/search/dfs")
    public ResponseEntity<?> searchDFS(@RequestBody Grid grid) {
        Node initial = new Node(grid.getInitialX(), grid.getInitialY());
        Node end = new Node(grid.getEndX(), grid.getEndY());
        Graph graph = new Graph();
        DFS algorithm = new DFS(grid.getGrid(), initial, end, graph);
        algorithm.search();
        algorithm.definePath();
        graph = algorithm.getGraph();

        return ResponseEntity.ok(graph);
    }

    @PostMapping("/search/ast")
    public ResponseEntity<?> searchAST(@RequestBody Grid grid) {
        Node initial = new Node(grid.getInitialX(), grid.getInitialY());
        Node end = new Node(grid.getEndX(), grid.getEndY());
        Graph graph = new Graph();
        AST algorithm = new AST(grid.getGrid(), initial, end, graph);
        algorithm.search();
        algorithm.definePath();
        graph = algorithm.getGraph();

        return ResponseEntity.ok(graph);
    }

}
