import java.util.*;
public class GraphKruskal{
	static class Edge{
		int s;
		int e;
		int cost;
		Edge(int k,int l,int c){
			s=k;
			e=l;
			cost = c;
		}
		/*public int comapareTo(Edge e){
			return this.cost - e.cost;
		}*/
	} 
	static int parent[];
	public static int find(int x){
		if(x != parent[x]){
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	public static void union(int x, int y){
		int xset = find(x);
		int yset = find(y);
		parent[xset] = yset;
	}
	public static void print_MST(ArrayList<Edge> tree){
		int cost = 0;
		System.out.println("Tree Edges:");
		for(Edge E:tree){
			System.out.print("("+E.s+","+E.e+")\t");
			cost+=E.cost;
		}
		System.out.println();
		System.out.println("Cost: "+cost);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int n = sc.nextInt();
		int i,j;
		parent = new int[n+1];
		System.out.println("Enter no. of edges");
		int m = sc.nextInt();
		System.out.println("Enter edges in the form:\n 'endpoint1' 'endpoint2' 'cost/weight'");
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(i=0;i<m;i++){
			edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		for(i=0;i<=n;i++){
			parent[i] = i;
		}
		Comparator<Edge> compareByCost = (Edge o1, Edge o2) -> o1.cost - o2.cost;
		Collections.sort(edges,compareByCost);
		ArrayList<Edge> tree = new ArrayList<Edge>();
        for(i=0;i<m;i++){
        	if(find(edges.get(i).s)!=find(edges.get(i).e)){
        		tree.add(edges.get(i));
        		union(edges.get(i).s,edges.get(i).e);
        	}
        }
        System.out.println(Arrays.toString(parent));
        print_MST(tree);
	}

}