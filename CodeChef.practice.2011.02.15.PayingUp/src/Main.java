import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/problems/MARCHA1/ for instructions
public class Main {
	//---Paying Up  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	/*long start, end, total;
		start =0;*/
        String[] cline;
        StringBuffer o = new StringBuffer("");
        int tmp =0;
        int nbBankNotes=0;
        int muggersMoney=0;
        int nbCases= Integer.parseInt(in.readLine());
        //start = System.currentTimeMillis();
        int[] iTab;
        while((nbCases--)>0){
        	//-1 Read couple nbBankNotes and MuggersMoney
        	cline = in.readLine().split(" ");
        	nbBankNotes=Integer.parseInt(cline[0]);
        	muggersMoney = Integer.parseInt(cline[1]);
        	iTab= new int[nbBankNotes];
        	if(muggersMoney>(nbBankNotes*1000))
        		o.append("No").append("\n");
        	if(muggersMoney>20000)
        		o.append("No").append("\n");
        	//-2 Read Bank Notes
    		for(int i=0;i<nbBankNotes;i++){
    			iTab[i]=Integer.parseInt(in.readLine());
    			tmp=tmp+iTab[i];
    		}
    		if(tmp<muggersMoney)
    			o.append("No").append("\n");
    		//System.out.println("Call Solve:");
    		if(solve(iTab, nbBankNotes,muggersMoney )) 
    			o.append("Yes").append("\n");
    		else 
    			o.append("No").append("\n");
    		
    	}
        System.out.print(o);
        /*end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);*/
		System.exit(0);
    }
    private static void  printTab(int[]tab){
    	System.out.print("\tTab:[");
    	for(int i=0;i<tab.length;i++)System.out.print(tab[i]+",");
    	System.out.println("]");
    }

	private static boolean solve(int[] tab, int nbBankNotes, int m) {
		/*System.out.print("\tSolve: ");
		printTab(tab);
		System.out.println("\tnbBankNotes:"+nbBankNotes);
		System.out.println("\tm:"+m);*/
		int[] tmptab = new int [nbBankNotes];
		//Copy Array
		for(int i=0;i<nbBankNotes;i++){
			tmptab[i]=tab[i];
		}
		boolean issolved=false;
		if(m==0) return true;
		if(m<0)return false;
		for(int i=0;i<nbBankNotes;i++)
		{
			if((m-tab[i])==0)
			{
				issolved=true;
				break;
			}
		}
		if(!issolved)
		{
			for(int i=0;i<nbBankNotes;i++)
			{
				if(tab[i]!=0)
				{
					tmptab[i]=0;
					//System.out.print("tab[i]="+tab[i]);
					//System.out.print("m-tab[i]="+(m-tab[i]));
					if(solve(tmptab,nbBankNotes,(m-tab[i]))) 
					{
						return true;
					}
					tmptab[i]=tab[i];
				}
			}
		}
		return issolved;
	}
}