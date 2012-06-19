import java.io.*;

//GoTo: http://www.codechef.com/problems/ONP/ for instructions
public class Main {
	
    //---Transform the Expression  by Santiaago :--- 
	public static void main(String[] args) {
		
		int icptCases = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Read Input
		int nbCases=0;
		try {
			nbCases = Integer.parseInt(in.readLine());
		}catch (IOException e) {
		}
		String stemp = "";
		String sRPN = "";
		PrintWriter pw = new PrintWriter(System.out, true); 

		while(icptCases<nbCases)
		{
			try {
				stemp = in.readLine();
			} catch (IOException e) {}
			sRPN = reverseNotation(stemp);
			pw.println(sRPN);
			icptCases++;
		}
		try {
			in.close();
		} catch (IOException e) {}
		pw.close();
		System.exit(0);
    }
	
	private static String reverseNotation(String stemp) {
		String sRPN="";
		boolean isLastCharSymbol=false;
		String sSymbol="";
		String sgetInbrackets="";
		for(int i=0; i<stemp.length();i++)
		{
			if(isBracketOpen(stemp.charAt(i))|| isBracketClose(stemp.charAt(i)))
			{
				if(isLastCharSymbol){
					//stemp=
					sgetInbrackets = getInBrackets(stemp,i);
					sRPN= sRPN+reverseNotation(sgetInbrackets)+sSymbol;
					isLastCharSymbol=false;
					if(i+sgetInbrackets.length()+1<stemp.length())
						i=i+sgetInbrackets.length()+1;
					else
						i=stemp.length();
				}
			}
			else if(isSymbol(stemp.charAt(i))){
				sSymbol = stemp.charAt(i)+"";
				isLastCharSymbol = true;
			}
			else{
				String sop = stemp.charAt(i)+"";
				if(isLastCharSymbol){
					sRPN = sRPN+sop+sSymbol;
					isLastCharSymbol=false;
				} 
				else{
					sRPN = sRPN + sop;
				}
			}
			//System.out.println("sRPN:	"+sRPN);
		}
		return sRPN;
	}
	private static String getInBrackets(String stemp, int i) {
		//find closing bracket for open bracket in index:i
		int endIndex = 0;
		int nbOpen = 1;
		for(int j=i+1;j<stemp.length();j++){
			if(isBracketClose(stemp.charAt(j))){
				nbOpen--;
				if(nbOpen==0){
					endIndex=j;
					break;
				}
			}
			if(isBracketOpen(stemp.charAt(j))){
				nbOpen++;
			}
		}
		if(endIndex!=0)
			stemp=stemp.substring(i+1, endIndex);
		else stemp ="";
		return stemp;
	}

	public static boolean isBracketClose(char c)
	{
		boolean isSymbol = false;
		switch (c) {
		case ')':
			isSymbol = true;
			break;
		default:
			isSymbol=false;
			break;
		}
		return isSymbol;
	}
	
	public static boolean isBracketOpen(char c)
	{
		boolean isSymbol = false;
		switch (c) {
		case '(':
			isSymbol = true;
			break;
		default:
			isSymbol=false;
			break;
		}
		return isSymbol;
	}
	
	public static boolean isSymbol(char c)
	{
		boolean isSymbol = false;
		switch (c) {
		case '+':
			isSymbol = true;
			break;
		case '-': isSymbol = true;break;
		case '*': isSymbol = true; break;
		case '^': isSymbol = true; break;
		case '/': isSymbol = true; break;
		default:
			isSymbol=false;
			break;
		}
		return isSymbol;
	}
}