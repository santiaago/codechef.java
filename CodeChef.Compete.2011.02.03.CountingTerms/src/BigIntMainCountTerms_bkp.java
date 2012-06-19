import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

//GoTo: http://www.codechef.com/FEB11/problems/TERM/ for instructions
public class BigIntMainCountTerms_bkp {
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
		//BigInteger nbTermsModuloP=BigInteger.ZERO;
		BigInteger nbTerms=BigInteger.ZERO;
		BigInteger nbTermsTotal=BigInteger.ZERO;
		BigInteger sumNbTermsModuloP = BigInteger.ZERO;
		BigInteger sumNbTermsModuloPTotal = BigInteger.ZERO;
		int icptCases = 0;
		//-------------------
		BigInteger temp = numberofTerms(BigInteger.valueOf(3), BigInteger.valueOf(3));
		System.out.println("TEMP: "+temp);
		//BigInteger temp = numberofTermsModuloP(BigInteger.valueOf(3),BigInteger.valueOf(3), 3);
		//System.out.println("-----");
		//System.out.println("-----");
		//temp = numberofTermsModuloP(BigInteger.valueOf(2),BigInteger.valueOf(2), 2);
		//------------
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Read Input
		int nbCases = Integer.parseInt(in.readLine());
		start = System.currentTimeMillis();
		String[] stemp = null;
		while(icptCases<nbCases)
		{
			//sumNbTermsModuloP =BigInteger.ZERO;
			stemp = in.readLine().split(" ");
			n=BigInteger.valueOf(Long.valueOf((stemp[0])));
			k=BigInteger.valueOf(Long.valueOf((stemp[1])));
			p=Integer.parseInt(stemp[2]);
			for(BigInteger i=BigInteger.ZERO;(i.compareTo(n)<0)||(i.compareTo(n)==0);i=i.add(BigInteger.ONE)){
				nbTerms = numberofTerms(i,k);
				nbTermsTotal = nbTermsTotal.add(nbTerms);
				sumNbTermsModuloP = numberofTermsModuloP(i, k, p);
				sumNbTermsModuloPTotal = sumNbTermsModuloPTotal.add(sumNbTermsModuloP);
				System.out.println(">>NumberOfTerms("+i+","+k+")="+nbTerms);
				System.out.println(">>NumberOfTermsModuloP("+i+","+k+","+p+")="+sumNbTermsModuloP);
			}
			System.out.println("NumberOfTermsTotal("+n+","+k+")="+nbTermsTotal);
			System.out.println("NumberOfTermsModuloPTotal("+n+","+k+")="+sumNbTermsModuloPTotal);
			System.out.println("Difference="+nbTermsTotal.add(sumNbTermsModuloPTotal.negate()));
			
			System.out.println("_________________________________________");
			icptCases ++;
			//Clear vars
			nbTerms = BigInteger.ZERO;
			nbTermsTotal=  BigInteger.ZERO;
			sumNbTermsModuloP = BigInteger.ZERO;
			sumNbTermsModuloPTotal =  BigInteger.ZERO;
			
		}
		end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);
		//in.close();
		//converter.close();
    }
	
	//Counts the number of ModuloP ==0
	public static BigInteger numberofTermsModuloP(BigInteger n,BigInteger k,int p)
	{
		//System.out.print("----------numberofTermsModuloP("+n+","+k+","+p+")------------------\n");
		BigInteger nbItems=BigInteger.ZERO;
		BigInteger[] PascalVector; 
		if(k.compareTo(BigInteger.ONE)==0)//K
		{
			if(p!=1)
			nbItems= BigInteger.ZERO;
			else
				nbItems=BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ONE)==0)//N
		{
			if(p!=1)
				nbItems=BigInteger.ZERO;
			else
				nbItems = BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ZERO)==0)//N
		{
			if(p!=1)
				nbItems = BigInteger.ZERO;
			else
				nbItems= BigInteger.ONE;
		}
		else if(k.compareTo(BigInteger.valueOf(2))==0)//K
		{
			nbItems =  CountItemsInPascalTriangleModuloP(n, p);
		}
		else
		{
			System.out.print("Else\n");
			PascalVector = new BigInteger[n.add(BigInteger.ONE).intValue()];
			PascalVector = ItemsInPascalTriangle(n);
			
			for(BigInteger i = BigInteger.ZERO;i.compareTo(n)<0 || i.compareTo(n)==0;i= i.add(BigInteger.ONE))
			{
				//Here code from pascal vector
				if(PascalVector[i.intValue()].mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO)==0)
				{	
						//System.out.println("CurrentVal: "+PascalVector[i.intValue()]);
						//System.out.println("Current K: "+k.add(BigInteger.ONE.negate()));
						
					nbItems =nbItems.add(numberofTerms(n.add(i.negate()),k.add(BigInteger.ONE.negate())));
						//System.out.println("IFnbItems: "+nbItems);
				}
				else
				{
					nbItems = nbItems.add(numberofTermsModuloP(n.add(i.negate()),k.add(BigInteger.ONE.negate()),p));
						//System.out.println("ELSEnbItems: "+nbItems);
				}
			}
				//System.out.print("#"+i+"\n");
				//System.out.print("nbItemsModP: n="+n+"k="+k+" result: "+nbItems+"\n");
				//nbItems = nbItems.add(numberofTermsModuloP(n.add(BigInteger.ONE.negate()),k.add(BigInteger.ONE.negate()),p));
				//if(k.mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO)==0)
				//	nbItems = nbItems.add(numberofTermsModuloP(i,k.add(BigInteger.ONE.negate()),p)).multiply(k);
				//else
					//nbItems = nbItems.add(numberofTermsModuloP(i,k.add(BigInteger.ONE.negate()),p));
		}
		//System.out.print("----------END=numberofTermsModuloP("+n+","+k+","+p+") = "+nbItems+"------------------\n");
		return nbItems;
	}
	
	public static BigInteger[] ItemsInPascalTriangle(BigInteger n)
	{
		
		BigInteger[] currentRow = new BigInteger[] { BigInteger.ONE }; //First row is 1

		for (BigInteger row = BigInteger.ONE; row.compareTo(n)<0 || row.compareTo(n)==0; row=row.add(BigInteger.ONE))
		{
			BigInteger[] nextRow = new BigInteger[currentRow.length + 1];
			nextRow[0] = BigInteger.ONE;
			for (BigInteger col=BigInteger.ONE; col.compareTo(BigInteger.valueOf(currentRow.length))<0; col=col.add(BigInteger.ONE))
			{
				nextRow[col.intValue()] = currentRow[col.intValue() - 1].add(currentRow[col.intValue()]);
			}
			nextRow[currentRow.length] = BigInteger.ONE; //Last element
			currentRow = nextRow; //Next time around currentRow is what we calced
		}
		
		return  currentRow;
	}
	
	
	
	public static BigInteger CountItemsInPascalTriangleModuloP(BigInteger n, int p)
	{
		BigInteger nbItems=BigInteger.ZERO;
		BigInteger nbItemsMinusModulo =BigInteger.ZERO;
		
		BigInteger[] currentRow = new BigInteger[] { BigInteger.ONE }; //First row is 1

		for (BigInteger row = BigInteger.ONE; row.compareTo(n)<0 || row.compareTo(n)==0; row=row.add(BigInteger.ONE))
		{
			BigInteger[] nextRow = new BigInteger[currentRow.length + 1];
			nextRow[0] = BigInteger.ONE;
			for (BigInteger col=BigInteger.ONE; col.compareTo(BigInteger.valueOf(currentRow.length))<0; col=col.add(BigInteger.ONE))
			{
				nextRow[col.intValue()] = currentRow[col.intValue() - 1].add(currentRow[col.intValue()]);
			}
			nextRow[currentRow.length] = BigInteger.ONE; //Last element
			currentRow = nextRow; //Next time around currentRow is what we calced
		}
		//System.out.println("");
		nbItems = BigInteger.valueOf(currentRow.length);
		for(BigInteger i=BigInteger.ZERO;i.compareTo(BigInteger.valueOf(currentRow.length))<0;i=i.add(BigInteger.ONE))
		{
			//System.out.print(currentRow[i.intValue()]+"|");
		}
		//System.out.println("");
		for(BigInteger i=BigInteger.ZERO;i.compareTo(BigInteger.valueOf(currentRow.length))<0;i=i.add(BigInteger.ONE))
		{
			if((currentRow[i.intValue()].mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO))==0) 
				nbItemsMinusModulo = nbItemsMinusModulo.add(BigInteger.ONE);
		}
		//System.out.print("\nnbItemsMinusModulo:"+nbItemsMinusModulo);
		/*
		while(!isFinish)
		{
			next[0]= BigInteger.ONE;
		}
		
		for(BigInteger i = BigInteger.ZERO;i.compareTo(n)<0 || i.compareTo(n)==0;i=i.add(BigInteger.ONE))
		{
			
		}*/
		
		return  nbItemsMinusModulo;
	}

	public static BigInteger numberofTerms(BigInteger n,BigInteger k)
	{
		BigInteger nbItems=BigInteger.ZERO;
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
			for(BigInteger i = BigInteger.ZERO;i.compareTo(n)<0 || i.compareTo(n)==0;i= i.add(BigInteger.ONE))
			{
				//if(k.compareTo(BigInteger.valueOf(2))==0)
				//	System.out.println("NumberOfTermsTriangle("+i+","+k+")="+CountItemsInPascalTriangleModuloP(i,p));
				nbItems = nbItems.add(numberofTerms(n.add(i.negate()),k.add(BigInteger.ONE.negate())));
			}
				
		}
		
		return nbItems;
	}
	
	
	
}















