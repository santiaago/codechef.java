import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/problems/RESN04/ for instructions
public class Main {
	//---Stone Game  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	/*long start, end, total;
		start =0;*/
        String[] line;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        int nbPiles = 0;
        int res=0;
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	nbPiles = Integer.parseInt(in.readLine());
        	line = in.readLine().split(" ");
        	for(int i=0;i<nbPiles;i++)
        	{
        		res=res+Integer.parseInt(line[i])/(i+1);
        	}
        	if(res%2==0)
        		o.append("BOB").append("\n");
        	else
        		o.append("ALICE").append("\n");
        	res=0;
    	}
        System.out.println(o);
        /*end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);*/
		System.exit(0);
    }
}