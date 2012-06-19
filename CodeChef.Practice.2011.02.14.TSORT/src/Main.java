import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//GoTo: http://www.codechef.com/problems/TSORT/ for instructions
public class Main {
	//---Turbo Sort  by Santiaago :---
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int nbCases= Integer.parseInt(in.readLine());
         int[] iTab=new int[nbCases];
		while((nbCases--)>0)
		{
			iTab[nbCases]=Integer.parseInt(in.readLine());
		}
		Arrays.sort(iTab);
		StringBuffer o = new StringBuffer("");
		int i;
		for(i=0;i<iTab.length-1;i++){o.append(iTab[i]).append('\n');}
		o.append(iTab[i]);
		System.out.println(o);
		System.exit(0);
    }
}