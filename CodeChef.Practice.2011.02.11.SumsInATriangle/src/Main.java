import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

//GoTo: http://www.codechef.com/problems/SUMTRIAN/ for instructions
public class Main {
	//---Sums in a Triangle  by Santiaago :--- 
    static int[][] iTab;//=new int[100][100];
    static int[][] iTabCache;
	public static void main(String[] args) {
		
		int icptCases = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Read Input
		int nbCases=0;
		int nbLines = 0;
		int iMaxPath = 0;
		try {nbCases = Integer.parseInt(in.readLine());}catch (IOException e) {}
		PrintWriter pw = new PrintWriter(System.out, true); 
		//long start, end, total;
		//start =0;
		//start = System.currentTimeMillis();
		while(icptCases<nbCases)
		{
			//Read nbLines of Triangle
			try {nbLines = Integer.parseInt(in.readLine().trim());} catch (IOException e) {}
			//-1--ConstructTriangle
			iTab= new int[nbLines][nbLines];
			iTabCache = new int[nbLines][nbLines];
			int cptLines = 0;
			String[] sCurrentLine =null;
			while(cptLines<nbLines){
				//Get Current Line
				try {sCurrentLine = in.readLine().split(" ");} catch (IOException e) {}
				//Construct int Array
				for(int i=0;i<sCurrentLine.length;i++){iTab[cptLines][i]=Integer.parseInt(sCurrentLine[i]);}
				cptLines++;
			}
			//-2--Browse Triangle for Max Path
			iMaxPath = BrowseTriangleMaxPath(nbLines,0,0);
			//-3--Print Max Path Sum
			pw.println(iMaxPath);
			icptCases++;
		}
		try {in.close();} catch (IOException e) {}
		//end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		pw.close();
		System.exit(0);
    }
	
	private static int BrowseTriangleMaxPath(int nbLines,int rowStart,int colStart) {
		int max = 0;
		if(Getcache(rowStart,colStart)!=0)
				return Getcache(rowStart,colStart);
		if(nbLines==1)
		{
			Setcache(rowStart,colStart,max);
			return iTab[rowStart][colStart];
		}
		int a = BrowseTriangleMaxPath(nbLines-1,(rowStart+1),colStart);
		int b = BrowseTriangleMaxPath(nbLines-1,(rowStart+1),colStart+1);
		if(a>b){
			max=a+iTab[rowStart][colStart];
			Setcache(rowStart,colStart,max);
		}
		else{
			max=b+iTab[rowStart][colStart];
			Setcache(rowStart,colStart,max);
		}
		return max;
	}
	
	private static int Getcache(int row, int col){
		try{
		return iTabCache[row][col];
		}
		catch(Exception e)
		{return -1;}	
	}
	private static void Setcache(int row, int col,int max){
		//if(iTabCache[row][col]==-1)
		iTabCache[row][col] = max;
		
	}
}