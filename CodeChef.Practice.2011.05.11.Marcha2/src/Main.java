import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.math.*;

//GoTo: http://www.codechef.com/problems/MARCHA2/ for instructions
public class Main {
	//---Marcha2  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	long start, end, total;
		start =0;
        StringBuffer o = new StringBuffer("");
        int nbCases = Integer.parseInt(in.readLine());
        start = System.currentTimeMillis();
        int N = nbCases;
        int currentLvls =0;
        int tmp = 0;
        int calc1 = 0;
        int calc2 = 0;
        String[] str;
        //Read Lines
        while((N--)>0){
        	//Work here
        	System.out.println("Case N#"+N);
        	currentLvls=Integer.parseInt(in.readLine().trim());
        	System.out.println("Current Levels: "+currentLvls);
        	str = new String[currentLvls];
        	 str = in.readLine().split(" ");
        	 for(int i=0;i<currentLvls-1;i++){
        		 tmp = Integer.parseInt(str[i]);
        		 //calc1 = (int) (tmp*2 + Math.pow(2, Integer.parseInt(str[i+1])));
        		 calc1 = (int) (Math.pow(2, Integer.parseInt(str[i])));
        		 System.out.println("Calc1: "+calc1);
        		 calc2 = (int) Math.pow(2, i+1);
        		 System.out.println("Calc2: "+calc2);
        		 if(calc1==calc2){
        			 o.append("Yes\n");
        		 }
        		 else{
        			 o.append("No\n");
        		 }
        	 }
        	 currentLvls = 0;
        	 str = null;
    	}
        System.out.println(o);
        end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);
		System.exit(0);
    }
}
