import java.io.*;
import java.lang.Math;
import java.util.ArrayList;

//GoTo: http://www.codechef.com/problems/FCTRL/ for instructions
public class Main {
	//Verbose modes
	public static boolean verbose= false;
	public static boolean verboseTime = false;
	
	public static void main(String[] args) throws IOException{
        //---Factorial  by Santiaago :--- 
		
		//Vars
		long start, end, total;
		start =0;
		if(verboseTime){
			start = System.currentTimeMillis();
		}
		String sNbcases ="";
		int icptCases = 0;
		long ltmpNumber = 0;
		int irest = -1;
		int inbZeros = 0;
		ArrayList<Long> lnbCases = null;
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		lnbCases = new ArrayList<Long>();
		//Read Input
		sNbcases = in.readLine();
		while(icptCases<Integer.parseInt(sNbcases))
		{
			ltmpNumber = Long.parseLong(in.readLine());
			lnbCases.add(ltmpNumber);
			icptCases ++;
		}

		in.close();
		converter.close();
		icptCases = 0;
		//Count thoses Zeros
		while(icptCases<Integer.parseInt(sNbcases))
		{
			irest = (int) Math.floor(lnbCases.get(icptCases)/5);
			if(verbose)System.out.println("1st irest:"+irest);
			while(irest!=0)
			{
				if(verbose)System.out.println(">>> irest:"+irest);
				inbZeros = inbZeros + irest;
				irest = (int) Math.floor(irest/5);
			}
			System.out.println(inbZeros);
			inbZeros = 0;
			irest = -1;
			icptCases++;
		}
		if(verboseTime){
			end = System.currentTimeMillis();
			total = end - start;
			System.out.println("Time:"+total);
		}
    }
}
