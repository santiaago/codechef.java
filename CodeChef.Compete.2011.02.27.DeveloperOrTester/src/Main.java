import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/ENCODED/problems/ENCODE04/ for instructions
public class Main {
	//---Dev or Test  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        int sum=0;
        String strtmp="";
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	strtmp=in.readLine();
        	if(strtmp.length()%2!=0){
        		o.append("NO").append("\n");
        	}
        	else{
        		if((strtmp.charAt(0)!='T') || (strtmp.charAt(strtmp.length()-1)!='D')){
        			o.append("NO").append("\n");
        		}
        		else{
        			for(int i=0;i<strtmp.length();i++){
        				if(strtmp.charAt(i)=='T'){
        					sum++;
        				}
        				else{
        					sum--;
        				}
        				if(sum<0) {
        					break;
        				}
        			}
        			if(sum==0){
        				o.append("YES").append("\n");
        			}
        			else{
        				o.append("NO").append("\n");
        			}
        		}
        	}
        	sum=0;
    	}
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
}
