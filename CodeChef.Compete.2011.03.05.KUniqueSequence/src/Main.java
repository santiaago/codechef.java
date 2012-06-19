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
    	ArrayList <ArrayList<Integer>> ALGroups = new ArrayList<ArrayList<Integer>>();
    	boolean findPlace=false;
    	boolean solution = false;
    	boolean kunique=true;
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	int N,K,nbGrps,index,current;
        int nbCases= Integer.parseInt(in.readLine());
        int[] A;
    	//long start, end, total;
    	StringBuffer o = new StringBuffer("");
    	String[] strtmp;
    	StringTokenizer stTocken;
        //start =0;
        N=K=index=nbGrps=current=0;
        //start = System.currentTimeMillis();
        
        while((nbCases--)>0)
        {
        	kunique=true;
        	//1-Read N and K
        	strtmp= in.readLine().split(" ");
        	N = Integer.parseInt(strtmp[0]);
            K = Integer.parseInt(strtmp[1]);
            //System.out.println("Case: N: "+N+" K: "+K);
            //2-Set number of Groups
            nbGrps = N/K;
            //System.out.println("NB Groups: "+nbGrps);
            //3-Read Vector A[] and Sort it
            A = new int[N];
            stTocken = new StringTokenizer(in.readLine()," ");
            while(stTocken.hasMoreElements()){
            	//quality[index]=Integer.parseInt(stTocken.nextToken());
            	A[index]=intValueOf(stTocken.nextToken());
            	index++;
            }
            index=0;
            //verify if K unique
            for(int g=1;g<=nbGrps;g++){
            	for(int i=(g-1)*K;i<g*K;i++){
            		for(int j=i+1;j<g*K;j++){
            			//System.out.println("A["+i+"]="+A[i]);
            			//System.out.println("A["+j+"]="+A[j]);
            			if(A[i]==A[j]){
            				kunique=false;
            				break;
            			}
            		}
            		if(!kunique)break;
            	}
            	if(!kunique)break;
            }
            if(kunique){
	            Arrays.sort(A);
	            //4-Create Groups
	            for(int i=0;i<nbGrps;i++){
	            	ALGroups.add(new ArrayList<Integer>());
	            }
	            //5-Fill Groups[] and append result
	            for(int i=0;i<N;i++){
	            	//System.out.println("Searching Place for A["+i+"]="+A[i]);
	            	findPlace=false;
	            	for(int j=0;j<nbGrps;j++){
	            		if(ALGroups.get(j).size()<K)
	            		{
		            		if(!ALGroups.get(j).contains(A[i]))
		            		{
		            			//System.out.println("Place Found for A["+i+"]="+A[i]+" in group:"+j);
		            			findPlace=true;
		            			//Add A[i] to Group
		            			ALGroups.get(j).add(A[i]);
		            			break;
		            		}
	            		}
	            	}
	            	if(!findPlace){
	            		//System.out.println("Did not found a place A["+i+"]="+A[i]);
	            		break;
	            	}
	            }
            }
            else{
            	findPlace=false;
            }
            //Append Result
            if(!findPlace)	//Append -1
            {
            	o.append(-1);
            }
            else			//Append Vector
            {
	            	for(int i=0;i<nbGrps-1;i++){
	            		for(int k=0;k<K;k++){
	    					o.append(ALGroups.get(i).get(k)).append(" ");
	    				}
	            	}
	            	for(int k=0;k<K-1;k++){
						o.append(ALGroups.get(nbGrps-1).get(k)).append(" ");
					}
	            	o.append(ALGroups.get(nbGrps-1).get(K-1));
            }
            o.append("\n");
        	//o.append(sum).append("\n");
            ALGroups.clear();
    	}
        System.out.print(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
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
