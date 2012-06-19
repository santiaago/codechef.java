import java.io.*;
import java.math.BigInteger;

//GoTo: http://www.codechef.com/FEB11/problems/TERM/ for instructions
public class Main {
	public static long constantModulo = 1000003;
	
    //---TERMS  by Santiaago :--- 
	public static void main(String[] args){
		BigInteger n;
		int p;
		BigInteger k;
		BigInteger nbTerms=BigInteger.ZERO;
		BigInteger nbTermsTotal=BigInteger.ZERO;
		BigInteger sumNbTermsModuloP = BigInteger.ZERO;
		BigInteger sumNbTermsModuloPTotal = BigInteger.ZERO;
		int icptCases = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out, true); 
		//Read Input
		int nbCases = 0;
		try {
			nbCases = Integer.parseInt(in.readLine());
		}catch (IOException e) {}
		String[] stemp = null;
		while(icptCases<nbCases)
		{
			try {
				stemp = in.readLine().split(" ");
			} catch (IOException e) {}
			n=BigInteger.valueOf(Long.valueOf((stemp[0])));
			k=BigInteger.valueOf(Long.valueOf((stemp[1])));
			p=Integer.parseInt(stemp[2]);
			for(BigInteger i=BigInteger.ZERO;(i.compareTo(n)<0)||(i.compareTo(n)==0);i=i.add(BigInteger.ONE)){
				nbTerms = numberofTerms(i,k);//.mod(BigInteger.valueOf(constantModulo));
				nbTermsTotal = nbTermsTotal.add(nbTerms);
				sumNbTermsModuloP = numberofTermsModuloP(i, k, p);//.mod(BigInteger.valueOf(constantModulo));
				sumNbTermsModuloPTotal = sumNbTermsModuloPTotal.add(sumNbTermsModuloP);
			}
			pw.println(nbTermsTotal.add(sumNbTermsModuloPTotal.negate()));
			icptCases ++;
			//Clear vars
			nbTerms = BigInteger.ZERO;
			nbTermsTotal=  BigInteger.ZERO;
			sumNbTermsModuloP = BigInteger.ZERO;
			sumNbTermsModuloPTotal =  BigInteger.ZERO;
			
		}
		try {
			in.close();
		} catch (IOException e) {}
		System.exit(0);
    }
	
	//Counts the number of ModuloP ==0
	public static BigInteger numberofTermsModuloP(BigInteger n,BigInteger k,int p){
		BigInteger nbItems=BigInteger.ZERO;
		BigInteger[] PascalVector; 
		if(k.compareTo(BigInteger.ONE)==0){//K
			if(p!=1)
				nbItems= BigInteger.ZERO;
			else
				nbItems=BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ONE)==0){//N
			if(p!=1)
				nbItems=BigInteger.ZERO;
			else
				nbItems = BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ZERO)==0){//N
			if(p!=1)
				nbItems = BigInteger.ZERO;
			else
				nbItems= BigInteger.ONE;
		}
		else if(k.compareTo(BigInteger.valueOf(2))==0){//K
			nbItems =  CountItemsInPascalTriangleModuloP(n, p);
		}
		else{
			PascalVector = new BigInteger[n.add(BigInteger.ONE).intValue()];
			PascalVector = ItemsInPascalTriangle(n);
			for(BigInteger i = BigInteger.ZERO;i.compareTo(n)<0 || i.compareTo(n)==0;i= i.add(BigInteger.ONE))
			{
				//Here code from pascal vector
				if(PascalVector[i.intValue()].mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO)==0)
				{	
					nbItems =nbItems.add(numberofTerms(n.add(i.negate()),k.add(BigInteger.ONE.negate())));
					//nbItems =nbItems.add(BigInteger.valueOf(PascalVector.length).add(i.negate()));
				}
				else
				{
					nbItems = nbItems.add(numberofTermsModuloP(n.add(i.negate()),k.add(BigInteger.ONE.negate()),p).mod(BigInteger.valueOf(constantModulo)));
				}
			}
		}
		PascalVector = null;
		return nbItems.mod(BigInteger.valueOf(constantModulo));
	}
	
	public static BigInteger[] ItemsInPascalTriangle(BigInteger n){
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
			currentRow = nextRow;
		}
		return  currentRow;
	}
	
	
	
	public static BigInteger CountItemsInPascalTriangleModuloP(BigInteger n, int p){
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
			currentRow = nextRow;
		}
		
		for(BigInteger i=BigInteger.ZERO;i.compareTo(BigInteger.valueOf(currentRow.length))<0;i=i.add(BigInteger.ONE))
		{
			if((currentRow[i.intValue()].mod(BigInteger.valueOf(p)).compareTo(BigInteger.ZERO))==0) 
				nbItemsMinusModulo = nbItemsMinusModulo.add(BigInteger.ONE);
		}
		currentRow=null;
		return  nbItemsMinusModulo;
	}

	public static BigInteger numberofTerms(BigInteger n,BigInteger k){
		BigInteger nbItems=BigInteger.ZERO;
		if(k.compareTo(BigInteger.ONE)==0){
			nbItems= BigInteger.ONE;
		}
		else if(n.compareTo(BigInteger.ONE)==0){
			nbItems=k;
		}
		else if(n.compareTo(BigInteger.ZERO)==0){
			nbItems = BigInteger.ONE;
		}
		else if(k.compareTo(BigInteger.ONE)==0){
			nbItems=BigInteger.ZERO;
		}
		else{
			for(BigInteger i = BigInteger.ZERO;i.compareTo(n)<0 || i.compareTo(n)==0;i= i.add(BigInteger.ONE))
			{
				nbItems = nbItems.add(numberofTerms(n.add(i.negate()),k.add(BigInteger.ONE.negate())).mod(BigInteger.valueOf(constantModulo)));
			}	
		}
		
		return nbItems.mod(BigInteger.valueOf(constantModulo));
	}
	
	
	
}















