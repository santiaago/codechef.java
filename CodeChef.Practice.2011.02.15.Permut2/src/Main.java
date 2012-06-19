import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//GoTo: http://www.codechef.com/problems/PERMUT2/ for instructions
public class Main {
	//---Permut 2  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nbChar;
        String[] cline;
        StringBuffer o = new StringBuffer("");
        boolean ambiguous=true;
        while(true){
        	nbChar= Integer.parseInt(in.readLine());
        	if (nbChar==0) break;
        	cline = in.readLine().split(" ");
    		for(int i=0;i<nbChar;i++){
    			if(Integer.parseInt(cline[Integer.parseInt(cline[i])-1])!=(i+1)) {
    				ambiguous=false;break;
    			}
    		}
    		if(ambiguous) o.append("ambiguous");
    		else o.append("not ambiguous");
    		o.append('\n');
    		ambiguous=true;
        }
        System.out.println(o);
		System.exit(0);
    }
}