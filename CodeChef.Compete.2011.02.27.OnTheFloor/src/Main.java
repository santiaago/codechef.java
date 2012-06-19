import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/ENCODED/problems/ENCODE01/ for instructions
public class Main {
	//---On the Floor  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        int sum=0;
        int tmp=0;
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	tmp=Integer.parseInt(in.readLine());
        	sum=(int) (Math.floor(tmp/2)*Math.floor((tmp+1)/2));
        	o.append(sum).append("\n");
    	}
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
}
