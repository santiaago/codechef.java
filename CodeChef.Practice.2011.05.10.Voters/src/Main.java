import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//GoTo: http://www.codechef.com/problems/VOTERS/ for instructions
public class Main {
	//---Voters  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        String str[] = in.readLine().split(" ");
        int[] array;
        int N1 = Integer.parseInt(str[0]);
        int N2 = Integer.parseInt(str[1]);
        int N3 = Integer.parseInt(str[2]);
        //System.out.println("N1:" + N1+"\n");
        //System.out.println("N2:" + N2+"\n");
        //System.out.println("N3:" + N3+"\n");
        //start = System.currentTimeMillis();
        int N = N1+N2+N3;
        array = new int[N];
        int itmp = 0;
        int i=0;
        int nbVotes=0;
        //Read Lines
        while((N--)>0){
        	array[i]=Integer.parseInt(in.readLine().trim());
    		i++;
    	}
        Arrays.sort(array);
        i=0;
        itmp = array[0];
        i++;
        while(i<array.length)
        {
    		//System.out.println("i:" + i+"\n");
    		//System.out.println("compare " + itmp+" to "+array[i]+"\n");
    		
        	if(itmp==array[i]){
        		o.append(itmp).append("\n");
        		nbVotes++;
        		//System.out.println("Append:" + itmp+"\n");
        		i++;
        		if(i<array.length){
        			if(itmp==array[i])i++;
        		}
        	}
        	if(i<array.length){
        		itmp = array[i];
        	}
        	i++;
        }
        System.out.println(nbVotes);
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
}
