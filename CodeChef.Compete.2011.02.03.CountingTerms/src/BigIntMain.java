import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

//GoTo: http://www.codechef.com/FEB11/problems/TERM/ for instructions
public class BigIntMain {
	public static long constantModulo = 1000003;
	private static long currentN;
	private static long N;
	
    //---TERM  by Santiaago :--- 
	public static void main(String[] args) throws IOException{
		long start, end, total;
		start =0;
		BigInteger n;
		int p;
		BigInteger k;
		BigInteger nbTermsModuloP=BigInteger.ZERO;
		BigInteger sumNbTermsModuloP;
		int icptCases = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Read Input
		int nbCases = Integer.parseInt(in.readLine());
		start = System.currentTimeMillis();
		String[] stemp = null;
		while(icptCases<nbCases)
		{
			sumNbTermsModuloP =BigInteger.ZERO;
			stemp = in.readLine().split(" ");
			n=BigInteger.valueOf(Long.valueOf((stemp[0])));
			k=BigInteger.valueOf(Long.valueOf((stemp[1])));
			p=Integer.parseInt(stemp[2]);
			//System.out.println("N, K , P:"+n+" "+k+" "+p);
			//System.out.println("Cmp:"+BigInteger.ZERO.compareTo(n));
			//System.out.println("icptCases:"+icptCases);
			for(BigInteger i=BigInteger.ZERO;(i.compareTo(n)<0)||(i.compareTo(n)==0);i=i.add(BigInteger.ONE)){
				nbTermsModuloP = CalculateNumberOfVectorsModuloP(i,k,p);
				//System.out.println("i:"+i);
				//System.out.println("nbTermsModuloP:"+nbTermsModuloP);
				sumNbTermsModuloP = sumNbTermsModuloP.add(nbTermsModuloP);
			}
			System.out.println(sumNbTermsModuloP.mod(BigInteger.valueOf(constantModulo)));
			icptCases ++;
		}
		end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);
		//in.close();
		//converter.close();
    }

	public static BigInteger numberofTerms(BigInteger n,BigInteger k)
	{
		BigInteger nbItems;
		if(k.compareTo(BigInteger.ONE)==0)
		{
			nbItems= BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ONE)==0)
		{
			nbItems=k;
		}
		else if(n.compareTo(BigInteger.ZERO)==0)
		{
			nbItems = BigInteger.ONE;
		}
		else if(k.compareTo(BigInteger.ONE)==0)
		{
			nbItems=BigInteger.ZERO;
		}
		else
		{
			nbItems = numberofTerms(n.add(BigInteger.ONE.negate()),k.add(BigInteger.ONE.negate()));
		}
		
		return nbItems;
	}
	
	private static BigInteger CalculateNumberOfVectorsModuloP(BigInteger n, BigInteger k,int p) {
		ArrayList<BigInteger> VectorPossible;
		//BigInteger[] BIVectorPossible;
		VectorPossible = new ArrayList<BigInteger>();
		Boolean isnumberCalculated = false;
		BigInteger allpossiblevectors = BigInteger.valueOf((long) Math.pow(n.add(BigInteger.ONE).doubleValue(), k.doubleValue()));
		//BIVectorPossible = new BigInteger[allpossiblevectors.intValue()];
		BigInteger toDiv = BigInteger.ZERO;
		BigInteger base = n.add(BigInteger.ONE);
		BigInteger resultdiv = BigInteger.ZERO;
		BigInteger normeVecteur =BigInteger.ZERO;
		BigInteger nbVectors=BigInteger.ZERO;
		BigInteger coef = BigInteger.ONE;
		for(BigInteger i =BigInteger.ZERO; i.compareTo(allpossiblevectors)<0;i = i.add(BigInteger.ONE))
		{
			toDiv = i;
			normeVecteur = BigInteger.ZERO;
			isnumberCalculated = false;
			while(!isnumberCalculated)
			{
				resultdiv = toDiv.divide(base);
				if(resultdiv.equals(BigInteger.ZERO)) isnumberCalculated = true;
				VectorPossible.add(toDiv.add(resultdiv.multiply(base).negate()));
				toDiv=resultdiv;
				
			}
				for(BigInteger j=BigInteger.valueOf(VectorPossible.size()).add(BigInteger.ONE.negate());(j.compareTo(BigInteger.ZERO)>0)||(j.compareTo(BigInteger.ZERO)==0);j=j.add(BigInteger.ONE.negate())){
					normeVecteur = VectorPossible.get(j.intValue()).add(normeVecteur);
				}
				coef=BigInteger.ONE;
				if(normeVecteur.compareTo(n)==0)
				{
					for(BigInteger j=BigInteger.valueOf(VectorPossible.size()).add(BigInteger.ONE.negate());(j.compareTo(BigInteger.ZERO)>0 ||j.compareTo(BigInteger.ZERO)==0 );j=j.add(BigInteger.ONE.negate())){
						coef = coef.multiply(factorial(VectorPossible.get(j.intValue()).intValue()));
					}
					coef = factorial(n.intValue()).divide(coef);
					if(coef.mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO)!=0){nbVectors= nbVectors.add(BigInteger.ONE);}
				}
			VectorPossible.clear();
		}
		return nbVectors;
	}
	
	public static BigInteger factorial(int n)
     {
          if (n < 0)
          {
              throw new ArithmeticException("Factorial: n has to be >= 0, but was " + n);
         }
   
          if (n < 2)
          {
             return BigInteger.ONE;
        }
   
          BigInteger p = BigInteger.ONE;
          BigInteger r = BigInteger.ONE;
         N = 1;
 
          // log2n = floor(log2(n));
          int log2n = 31 - Integer.numberOfLeadingZeros(n);
          int h = 0, shift = 0, high = 1;
  
          while (h != n)
          {
              shift += h;
              h = n >>> log2n--;
             int len = high;
             high = (h & 1) == 1 ? h : h - 1;
             len = (high - len) / 2;
   
              if (len > 0)
              {
                  p = p.multiply(product(len));
                 r = r.multiply(p);
              }
          }
          return r.shiftLeft(shift);
      }
  
	
	private static BigInteger product(int n)
    {
        int m = n / 2;
        if (m == 0) return BigInteger.valueOf(N += 2);
        if (n == 2) return BigInteger.valueOf((N += 2) * (N += 2));
        return product(n - m).multiply(product(m));
    }
	
}















