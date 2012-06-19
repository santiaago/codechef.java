import java.io.*;
import java.math.BigInteger;

//GoTo: http://www.codechef.com/problems/FCTRL2/ for instructions
public class Main {
	public static BigInteger factorial(BigInteger n){
		BigInteger res = BigInteger.ONE;
		for(int i=1;i<=Integer.parseInt(n.toString());i++){
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}
	public static void main(String[] args) throws IOException{
        //---Factorial 2 by Santiaago :--- 
		String sNbcases ="";
		int icptCases = 0;
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		//Read Input
		sNbcases = in.readLine();
		while(icptCases<Integer.parseInt(sNbcases)){
			System.out.println(factorial(BigInteger.valueOf(Integer.parseInt(in.readLine()))));
			icptCases ++;
		}
    }
}
