import java.util.*;
public class Kahn{
	int V;
	List<List<Integer>> adj_list;
	public Kahn(int v){
		V = v;
		adj_list = new ArrayList<List<Integer>>(V+1);
		for(int i = 0;i<=V;i++){
			adj_list.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int start, int end){
		adj_list.get(start).add(end);
	}
	public ArrayList<Integer> topologicalSort(){
		int indegree[] = new int[V+1];
		ArrayList<Integer> topOrder = new ArrayList<Integer>();
		for(List<Integer> temp : adj_list){
			for(int x : temp){
				indegree[x]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;i<=V;i++){
			if(indegree[i]==0){
				q.add(i);
			}
		}
		int cnt = 0;

		while(!q.isEmpty()){
			int u = q.poll();
			topOrder.add(u);

			for(int v:adj_list.get(u)){
				if(--indegree[v]==0){
					q.add(v);
				}
			}
			cnt++;
		}
		if(cnt!=V){
			print("There exists a cycle in the graph!\n");
			return new ArrayList<Integer>();
		}
		else{
			return topOrder;
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);

    	print("Enter number of nodes:\n");
    	int n = sc.nextInt();
    	Kahn G = new Kahn(n);

    	print("Enter number of edges:\n");
    	int m = sc.nextInt();
    	print("Enter edges as:\nStart\tEnd\n");
    	for(int i = 0;i<m;i++){
    		G.addEdge(sc.nextInt(), sc.nextInt());
    	}
    	print("Toplogical Ordering:\n");
    	print(G.topologicalSort().toString()+"\n");
    	
    }   
                             
}