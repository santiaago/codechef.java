import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/COOK07/problems/COMM3/ for instructions
public class Main2 {
	//---Tree way comm  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
    	int x1,x2,x3,y1,y2,y3;
		//start =0;
        String[] line;
        int rayon=0;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        //start = System.currentTimeMillis();
        double d1,d2,d3;
        while((nbCases--)>0){
        	rayon=Integer.parseInt(in.readLine());
        	line = in.readLine().split(" ");
        	x1=Integer.parseInt(line[0]);
        	y1=Integer.parseInt(line[1]);
        	line = in.readLine().split(" ");
        	x2=Integer.parseInt(line[0]);
        	y2=Integer.parseInt(line[1]);
        	line = in.readLine().split(" ");
        	x3=Integer.parseInt(line[0]);
        	y3=Integer.parseInt(line[1]);
        	d1=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    		d2=Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3),2));
    		d3=Math.sqrt(Math.pow((x1-x3),2)+Math.pow((y1-y3),2));
    		//System.out.println("d1:"+d1);
    		//System.out.println("d2:"+d2);
    		//System.out.println("d3:"+d3);
    		if((d1<=rayon && d2<=rayon) || (d1<=rayon && d3<=rayon) || (d2<=rayon && d3<=rayon))
				o.append("yes").append("\n");
			else
				o.append("no").append("\n");
    	}
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
}