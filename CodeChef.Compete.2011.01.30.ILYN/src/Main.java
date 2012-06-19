import java.io.*;
import java.lang.Math;
import java.util.ArrayList;

//GoTo: http://www.codechef.com/CODEJAM/problems/QUARK3/ for instructions
public class Main {
	//Verbose modes
	public static boolean verbose= false;
	public static boolean verboseTime = false;
	public static long constantModulo = 1000003;
	
	
	public static long func(long n,long c){
		long res = 0;
		if(n==0 || n==1) res = 1;
		else{
			res = 2*func(n-1,c)+func(n-2,c)+c;
		}
		return res;
	}
	public static long gunc(long n, long c)
	{
		long res;
		if(n==0)
			res=1;
		//if(n==1)
		//	res = 1;
		else{
			res= gunc(n-1,c)+ func(n,c);
		}
		return res;
	}
	public static void main(String[] args) throws IOException{
		long start, end, total;
		start =0;
		if(verboseTime){
			start = System.currentTimeMillis();
		}
        //---ILYN  by Santiaago :--- 
		//Vars
		String sNbcases ="";
		int icptCases = 0;
		long n;
		long c;
		ArrayList<String> lCases = null;
		lCases = new ArrayList<String>();
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		//Read Input
		sNbcases = in.readLine();
		while(icptCases<Integer.parseInt(sNbcases))
		{
			lCases.add(in.readLine());
			icptCases ++;
		}
		for(int i=0;i<lCases.size();i++)
		{
			//Get Params
			n=Long.parseLong(lCases.get(i).split(" ")[0]);
			c=Long.parseLong(lCases.get(i).split(" ")[1]);
			//Get Functions:
			if(verbose){
			System.out.println("Case#"+i+":F:"+func(n,c));
			System.out.println("Case#"+i+":G:"+gunc(n,c));
			System.out.println("Case#"+i+":Mod 1000003:"+gunc(n,c)%constantModulo);
			}
			System.out.println(gunc(n,c)%constantModulo);
		}
		lCases.clear();
		in.close();
		converter.close();
		if(verboseTime){
			end = System.currentTimeMillis();
			total = end - start;
			System.out.println("Time:"+total);
		}
    }
}