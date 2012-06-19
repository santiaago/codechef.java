import java.io.*;
//GoTo: http://www.codechef.com/problems/INTEST/ for instructions
public class Main {
	public static void main(String[] args) throws IOException{
        //---ENORMOUS INPUT TEST  by Santiaago :--- 
		String sNbcases ="";
		int n;
		int k;
		int nbDivk=0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Read Input
		sNbcases = in.readLine();
		n = Integer.parseInt(sNbcases.split(" ")[0]);
		k = Integer.parseInt(sNbcases.split(" ")[1]);
		for(int i=0;i<n;i++)
		{
			if(Integer.parseInt(in.readLine())%k==0)
				nbDivk++;
		}
		System.out.println(nbDivk);
    }
}