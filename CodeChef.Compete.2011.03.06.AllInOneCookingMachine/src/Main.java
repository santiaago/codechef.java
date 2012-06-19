import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//GoTo: http://www.codechef.com/MARCH11/problems/KUNIQUE/ for instructions
public class Main {
	//---KUnique  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	//Vars and Init
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	int N,M,K,index,nbNodes,chosenOne;
    	int [] clients;
    	ArrayList<ArrayList<Integer>> ALnodes = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        ArrayList<Integer> distance = new ArrayList<Integer>();
        ArrayList<Integer> time = new ArrayList<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();
    	int nbCases= Integer.parseInt(in.readLine());
    	//long start, end, total;
    	StringBuffer o = new StringBuffer("");
    	String[] strtmp;
    	StringTokenizer stTocken;
    	
        //start =0;
        N=M=K=index=nbNodes=chosenOne=0;
        //start = System.currentTimeMillis();
        
        while((nbCases--)>0)
        {
        	strtmp = in.readLine().split(" ");
        	//Read N, M and K
        	N= Integer.parseInt(strtmp[0]);
        	M= Integer.parseInt(strtmp[1]);
        	K= Integer.parseInt(strtmp[2]);
        	
        	//Read Clients Location
        	clients = new int[K];
        	stTocken = new StringTokenizer(in.readLine()," ");
        	while(stTocken.hasMoreElements()){
            	//quality[index]=Integer.parseInt(stTocken.nextToken());
            	clients[index]=intValueOf(stTocken.nextToken());
            	nodes.add(index);
            	index++;
            }
        	nodes.add(K);
        	index=0;
        	//read Nodes U V and Distance
        	nbNodes=M;
        	for(int i=0;i<M;i++){
        		strtmp = in.readLine().split(" ");
        		ALnodes.add(new ArrayList<Integer>());
        		ALnodes.get(i).add(Integer.parseInt(strtmp[0]));
        		ALnodes.get(i).add(Integer.parseInt(strtmp[1]));
        		ALnodes.get(i).add(Integer.parseInt(strtmp[2]));
        		
        	}
        	chosenOne=0;
        	path.add(chosenOne);
        	while(!nodes.isEmpty()){
        		nodes.remove(chosenOne);
        		distance = Dijkstrat(ALnodes, chosenOne);
        		time = CalculateTime(distance,clients);
        		chosenOne = findNextChosenOne(time);
        		path.add(chosenOne);
        	}
        	//Loop in path to print Clients Orden
        	//Clear
        	ALnodes.clear();
        	nodes.clear();
        	
    	}
        System.out.print(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
    private static int findNextChosenOne(ArrayList<Integer> time) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static ArrayList<Integer> CalculateTime(
			ArrayList<Integer> distance, int[] clients) {
		// do code here
		return null;
	}

	private static ArrayList<Integer> Dijkstrat(
			ArrayList<ArrayList<Integer>> lnodes, int chosenOne) 
	{
		ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> Q = new ArrayList<Integer>();
		for(int i=0;i<lnodes.size();i++){
			distance.add(new ArrayList<Integer>());
			if(lnodes.get(i).get(0)==chosenOne)
			{
				distance.get(lnodes.get(i).get(1)).add(-1);
			}
			else if(lnodes.get(i).get(1)==chosenOne )
			{
				distance.get(lnodes.get(i).get(0)).add(-1);
			}
		}
		distance.get(0).add(0);
		
		
		return null;
	}

	public static int intValueOf( String str )
    {
        int ival = 0, idx = 0, end;
        boolean sign = false;
        char ch;

        if( str == null || ( end = str.length() ) == 0 ||
           ( ( ch = str.charAt( 0 ) ) < '0' || ch > '9' )
              && ( !( sign = ch == '-' ) || ++idx == end || ( ( ch = str.charAt( idx ) ) < '0' || ch > '9' ) ) )
            throw new NumberFormatException( str );

        for(;; ival *= 10 )
        {
            ival += '0'- ch;
            if( ++idx == end )
                return sign ? ival : -ival;
            if( ( ch = str.charAt( idx ) ) < '0' || ch > '9' )
                throw new NumberFormatException( str );
        }
    }
    
}
