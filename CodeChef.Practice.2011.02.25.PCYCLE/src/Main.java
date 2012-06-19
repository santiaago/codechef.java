import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//GoTo: http://www.codechef.com/problems/PCYCLE/ for instructions
public class Main {
	 //---Permutation Cycle  by Santiaago :---
	public static void main(String[] args) throws IOException{
    	//long start, end, total;
		//start =0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer o = new StringBuffer("");
    
        int nbNs= Integer.parseInt(in.readLine());
        int tmpposition=0;
        String[] tabN= new String[nbNs];
        int[] cycle= new int[nbNs];
        int currCycleIndex=0;
        //int[] history = new int[nbNs];
        int[] itemUsed = new int[nbNs];
        int currHistoryIndex=0;
        //start = System.currentTimeMillis();
        tabN = in.readLine().split(" ");
        //Start at poss 1.
        int position=0;
        int tmp=0;
        int cpt=0;
        boolean bend = false;
        
        while(!bend){
        	tmp=Integer.parseInt(tabN[position]);
        	//End of Cycle
        	if(cycle[0]!=tmp)
        	{
        		o.append(position+1).append(" ");
        		cycle[currCycleIndex]=tmp;
        		currCycleIndex++;
        		
        		//history[currHistoryIndex]=tmp-1;
        		currHistoryIndex++;
        		itemUsed[position]=1;
        		position = tmp-1;
        		
        	}
        	else
        	{
        		o.append(position+1).append("\n");//.append();
        		//Find Next Position
        		//Collections.sort(history);
        		//position=getNextPosition(history);;
        		tmpposition = position;
        		for(int i=0;i<nbNs;i++){
        			if(itemUsed[i]==0){
        				position=i;
        				break;
        			}
        		}
        		if(tmpposition==position) bend = true;
        		cycle= new int[nbNs];
        		currCycleIndex=0;
        		cpt++;
        	}
        }
        //End when poss = nbNs
        System.out.println(cpt);
        System.out.print(o);
        
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
        System.exit(0);
    }
    /*public static int getNextPosition(ArrayList<Integer> a){
    	int nextposition=0;
    	if(a.size()>=2){
	    	for(int i=0;i<a.size()-1;i++){
	    		if((a.get(i)+1)!=a.get(i+1)){
	    			nextposition=i+1;
	    		}
	    	}
	    	if(nextposition==0){
	    		nextposition=a.get(a.size()-1)+1;
	    	}
    	}
    	else{
    		nextposition=1;
    	}
    	return nextposition;
    }*/
    
}


