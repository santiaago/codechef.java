import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/problems/TLG/ for instructions
public class Main {
	//---The Lead Game  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	/*long start, end, total;
		start =0;*/
        String[] line;
        StringBuffer o = new StringBuffer("");
        int maxLead =0;
        int p1=0;
        int p2=0;
        boolean p1leads=false;
        int nbCases= Integer.parseInt(in.readLine());
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	line = in.readLine().split(" ");
        	p1=p1+Integer.parseInt(line[0]);
        	p2 = p2+ Integer.parseInt(line[1]);
        	
        	if(p1<p2)
        	{
        		if((p2-p1)>maxLead)
        		{
        			maxLead=(p2-p1);
        			p1leads=false;
        		}
        	}
        	else
        	{
        		if((p1-p2)>maxLead)
        		{
        			maxLead=(p1-p2);
        			p1leads=true;
        		}
        	}
    	}
        if(p1leads)o.append(1+" ");
        else o.append(2+" ");
        o.append(maxLead);
        System.out.println(o);
        /*end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);*/
		System.exit(0);
    }
}