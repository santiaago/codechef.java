import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/problems/NUMGAME for instructions
public class Main {
	//---NumGamme  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        int n=0;
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	n=Integer.parseInt(in.readLine());
        	if(n%2==0)
				o.append("ALICE").append("\n");
			else
				o.append("BOB").append("\n");
    	}
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
}