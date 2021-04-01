import java.util.*;
// python: https://www.nowcoder.com/discuss/628280?type=all&order=time&pos=&page=0&channel=-1&source_id=search_all_nctrack
// here is the java solution
public class Main{
    public static void main(String[] args){
        Solution s = new Solution();
        s.execute();
    }
}

class Solution{
    int x;
    int t;
    boolean[] vis;
    int minWeightSum = 999999;
    int[][] graph; 
    int maxWeight = 0;

    public void execute() {
        Scanner sc = new Scanner(System.in);
        // int n, m, s, t, x = sc.nextInt();
        int n = sc.nextInt();   // a n*n graph
        int m = sc.nextInt();   // m directed edges
        int s = sc.nextInt();   // start
         t = sc.nextInt();   // end
         x = sc.nextInt();   // only x steps is permitted
        sc.nextLine();
        graph = new int[n+1][n+1];  // graph[i][j] is the weight from i to j
        for(int i=0; i<m; i++){
            
            int from=sc.nextInt();
            int to=sc.nextInt();
            int w=sc.nextInt();
            // String[] str = sc.nextLine().split("\\s+");
            graph[from][to] = w;
            sc.nextLine();
        }

        // one dimension array record the visited list
        // has the node been visited or not?
        vis = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            vis[i] = false;
        }

        dfs(s, 0, 0, 0);
        System.out.println(this.maxWeight);
    }

    private void dfs(int i, int depth, int maxWeight, int weightSum){
        if(i==t){   // find
            if(weightSum < minWeightSum){
                minWeightSum = weightSum;
                this.maxWeight = maxWeight;
            }
        }
        if(depth>=x){
            return;
        }
        for(int j=0; j<graph[i].length; j++){
            if(!vis[j] && graph[i][j] > 0){
                vis[j] = true;
                int tmp = maxWeight;
                if(graph[i][j]>maxWeight) maxWeight=graph[i][j];
                dfs(j, depth+1, maxWeight, weightSum + graph[i][j]);
                // backtracking
                maxWeight = tmp;
                vis[j] = false;
            }
        }
    }
}
