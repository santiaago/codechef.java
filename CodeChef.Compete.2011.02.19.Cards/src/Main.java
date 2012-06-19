import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/SYNAPSE/problems/ALG01/ for instructions
public class Main {
	//---Cards  by Santiaago :---
	public static int[] memDecTab;
	public static int[] memIncTab;
	public static int[] memTabFind;
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	long start, end, total;
		start =0;
        String[] line;
        int[] tab;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        int nbCards = 0;
        start = System.currentTimeMillis();
        while((nbCases--)>0){
        	nbCards = Integer.parseInt(in.readLine());
        	tab=new int[nbCards];
        	memDecTab= new int[nbCards];
        	memIncTab= new int[nbCards];
        	memTabFind=new int[nbCards+1];
        	line = in.readLine().split(" ");
        	for(int i=0;i<line.length;i++)
        		tab[i]=Integer.parseInt(line[i]);
        	//System.out.println("Case:"+nbCases+":"+solve(tab));
        	o.append(solve(tab)).append("\n");
        	//tab=null;
    	}
        System.out.println(o);
        end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);
		System.exit(0);
    }

	private static int solve(int[] tab) {
		//Get Max Decreasing
		//Get Max Increasing
		int maxD =0;
		int tmpmaxD =0;
		int maxI = 0;
		int tmpmaxI=0;
		int max=1;
		int tmpmax=0;
		for(int i=0;i<tab.length;i++){
			/*tmpmaxD=getMaxDec(tab,i);
			tmpmaxI=getMaxInc(tab,i);
			if(tmpmaxD>maxD)
				maxD=tmpmaxD;
			if(tmpmaxI>maxI)
				maxI=tmpmaxI;*/
			tmpmax=getMaxDecInc(tab,i);
			if(tmpmax>max)max=tmpmax;
		}
		//if(maxD>maxI) return maxD;
		//else return maxI;
		return max;
	}
	
	private static int getMaxDecInc(int[] tab, int current){
		int maxD=0;
		int maxI=0;
		boolean decSolved=false;
		boolean incSolved = false;
		if(memDecTab[current]!=0) maxD= memDecTab[current];
		if(tab[current]==1){
			memDecTab[current]=1;
			maxD= 1;
		}
		if(memIncTab[current]!=0) maxI= memIncTab[current];
		if(tab[current]==tab.length){
			memIncTab[current]=1;
			maxI= 1;
		}
		//Loop
		if(maxI>0)incSolved=true;
		if(maxD>0)decSolved=true;
		int maxtmpD=0;
		int maxtmpI=0;
		int cpt=1;
		int j=0;
		if(!incSolved || !decSolved){
			for(int i=current;i<tab.length;i++){
				if(!decSolved){
					if((tab[current]-cpt)>0){
						j=find(tab,tab[current]-cpt,current);
						if(j!=-1)
						{
							maxtmpD= 1+getMaxDec(tab,j);
							if(maxtmpD>maxD)
								maxD=maxtmpD;
						}
						maxtmpD=0;
					}
				}
				if(!incSolved){
					if((tab[current]+cpt)<=tab.length){
						j=find(tab,tab[current]+cpt,current);
						if(j!=-1)
						{
							maxtmpI= 1+getMaxInc(tab,j);
							if(maxtmpI>maxI)
								maxI=maxtmpI;
						}
						maxtmpI=0;
					}
				}
				cpt++;
			}
		}
		memDecTab[current]=maxD;
		memIncTab[current]=maxI;
		if(maxD>maxI) {
			return maxD;
		}
		else{
			return maxI;
		}
	}
	
	
	private static int getMaxDec(int[] tab, int current) {
		if(memDecTab[current]!=0) return memDecTab[current];
		if(tab[current]==1){
			memDecTab[current]=1;
			return 1;
		}
		int max=1;
		int maxtmp=0;
		int cpt=1;
		int j=0;
		for(int i=current;i<tab.length;i++){
			if((tab[current]-cpt)>0){
				j=find(tab,tab[current]-cpt,current);
				if(j!=-1)
				{
					maxtmp= 1+getMaxDec(tab,j);
					if(maxtmp>max)
						max=maxtmp;
				}
				maxtmp=0;
			}
			cpt++;
		}
		memDecTab[current]=max;
		return max;
	}

	private static int getMaxInc(int[] tab, int current) {
		if(memIncTab[current]!=0) return memIncTab[current];
		if(tab[current]==tab.length){
			memIncTab[current]=1;
			return 1;
		}
		int max=1;
		int maxtmp=0;
		int cpt=1;
		int j=0;
		for(int i=current;i<tab.length;i++){
				if((tab[current]+cpt)<=tab.length){
					j=find(tab,tab[current]+cpt,current);
					if(j!=-1)
					{
						maxtmp= 1+getMaxInc(tab,j);
						if(maxtmp>max)
							max=maxtmp;
					}
					maxtmp=0;
				}
			cpt++;
		}
		memIncTab[current]=max;
		return max;
	}

	private static int find(int[] tab, int tofind, int current) {
		if(tofind<=tab.length){
			if(memTabFind[tofind]!=0){
				if(memTabFind[tofind]>=current) 
					return memTabFind[tofind];
				else
					return -1;
			}
				
			for(int i=current;i<tab.length;i++){
				if(tab[i]==tofind){
					memTabFind[tofind]=i;
					return i;
				}
			}
		}
		return -1;
	}
}