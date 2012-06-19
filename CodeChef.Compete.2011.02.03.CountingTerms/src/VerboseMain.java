import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

//GoTo: http://www.codechef.com/FEB11/problems/TERM/ for instructions
public class VerboseMain {
	//Verbose modes
	public static boolean verboseTime = true;
	public static long constantModulo = 1000003;
	
	public static BigInteger factorial(BigInteger n){
		BigInteger res = BigInteger.ONE;
		for(int i=1;i<=Integer.parseInt(n.toString());i++){
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException{
		long start, end, total;
		start =0;
		long n;
		long p;
		long k;
		long nbTermsModuloP=0;
		long sumNbTermsModuloP;
		if(verboseTime){
			start = System.currentTimeMillis();
		}
        //---TERM  by Santiaago :--- 

		String sNbcases ="";
		String stemp = "";
		int icptCases = 0;
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		//Read Input
		sNbcases = in.readLine();
		while(icptCases<Integer.parseInt(sNbcases))
		{
			sumNbTermsModuloP =0;
			//System.out.println("--------------------------");
			//System.out.println("Case #"+icptCases+":");
			stemp = in.readLine();
			n=Long.parseLong(stemp.split(" ")[0]);
			k=Long.parseLong(stemp.split(" ")[1]);
			p=Long.parseLong(stemp.split(" ")[2]);
			for(int i=0;i<=n;i++){
				//System.out.println("i#"+i+":");
				//nbterms =CountTerms(i,k);
				nbTermsModuloP = CalculateNumberOfVectorsModuloP(i,k,p);
				sumNbTermsModuloP = sumNbTermsModuloP+ nbTermsModuloP;
				//System.out.println("NbTerms: "+nbterms);
				//System.out.println("nbTermsModuloP: "+nbTermsModuloP+":");
				//System.out.println("sumNbTermsModuloP #"+sumNbTermsModuloP+":");
			}
			sumNbTermsModuloP = sumNbTermsModuloP%constantModulo;
			//System.out.println("TotalSumNbTermsModuloP: "+sumNbTermsModuloP);
			System.out.println(sumNbTermsModuloP);
			icptCases ++;
		}
		in.close();
		converter.close();
		if(verboseTime){
			end = System.currentTimeMillis();
			total = end - start;
			System.out.println("Time:"+total);
		}
    }


	private static long CalculateNumberOfVectorsModuloP(long n, long k,long p) {
		
		ArrayList<Long> VectorPossible;
		VectorPossible = new ArrayList<Long>();
		Boolean isnumberCalculated = false;
		long allpossiblevectors = (long) Math.pow(n+1, k);
		long toDiv = 0;
		long base = n+1;
		long resultdiv = 0;
		long normeVecteur =0;
		long nbVectors=0;
		long coef = 1;
		
		String strTemp ="";
		//System.out.println("AllPossibleVectors:"+allpossiblevectors);
		for(long i =0; i<allpossiblevectors;i++)
		{
			//System.out.println("-------------------------------------------");
			//System.out.println("	possible vector #"+i);
			//System.out.println("Base#"+base);
			
			toDiv = i;
			normeVecteur = 0;
			isnumberCalculated = false;
			while(!isnumberCalculated)
			{
				//array de longs
				resultdiv = toDiv/base;
				//System.out.println("resultdiv = toDiv/base:");
				//System.out.println(""+resultdiv+" = "+toDiv+"/"+base+"");
				if(resultdiv==0) isnumberCalculated = true;
				//System.out.println("VectorPossible:"+(toDiv-(resultdiv*base)));
				VectorPossible.add(Long.valueOf(toDiv-(resultdiv*base)));
				toDiv=resultdiv;
			}
			for(int j=VectorPossible.size()-1;j>=0;j--){
				normeVecteur = normeVecteur + VectorPossible.get(j);
				strTemp = strTemp + Long.toString(VectorPossible.get(j));
			}
			//System.out.println("	strVector:"+strTemp);
			//System.out.println("	NormeVector:"+normeVecteur);
			coef=1;
			if(normeVecteur==n)
			{
				for(int j=VectorPossible.size()-1;j>=0;j--){
					coef  = coef* Long.parseLong(factorial(BigInteger.valueOf(VectorPossible.get(j))).toString());
				}
				coef = Long.parseLong(factorial(BigInteger.valueOf(Long.valueOf(n))).toString())/coef;
				if(coef%p!=0){nbVectors= nbVectors+1;}
			}
			//System.out.println("			NbVector:"+nbVectors);
			VectorPossible.clear();
			strTemp="";
		}
		//System.out.println("			NbVector:"+nbVectors);
		return nbVectors;
	}
}















