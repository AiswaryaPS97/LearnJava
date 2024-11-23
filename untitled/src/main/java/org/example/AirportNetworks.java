package org.example;

import java.util.ArrayList;
import java.util.List;

public class AirportNetworks {
    public static int getCount(boolean[][] matrix) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();

        // Step 1: Find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(matrix, visited, component, i);
                components.add(component);
            }
        }

        // Step 2: Calculate the minimum new connections needed
        int componentCount = components.size();
        return componentCount - 1; // Minimum connections required to connect all components
    }

    private static void dfs(boolean[][] matrix, boolean[] visited, List<Integer> component, int airport) {
        visited[airport] = true;
        component.add(airport);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[airport][i] && !visited[i]) {
                dfs(matrix, visited, component, i);
            }
        }
    }

        public static void main(String[] args) {
            boolean[][] matrix = {
                    {false, true, false, false, false},
                    {true, false, false, false, false},
                    {false, false, false, true, false},
                    {false, false, true, false, false},
                    {false, false, false, false, false}
            };
            System.out.println(getCount(matrix)); // should print 6
        }
    }