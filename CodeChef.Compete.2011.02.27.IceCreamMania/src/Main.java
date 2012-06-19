import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//GoTo: http://www.codechef.com/ENCODED/problems/ENCODE04/ for instructions
public class Main {
	 //---Dev or Test  by Santiaago :---

	//static int[][] memRegion = new int[100000][100000];
    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        //String[] squality;
        int[] quality;
        int Xi=0;
        int Yi=0;
        //String[] strtmp = new String[2];
        String strRegion = "";
        String[] strtmp;
        int max1=0;
        int max2=0;
        int max=0;
        int maxD=0;
        int nbIceParlors= Integer.parseInt(in.readLine());
        quality = new int[nbIceParlors];
        int[] MaxIncrement = new int[nbIceParlors];
        int[] MaxDecrement= new int[nbIceParlors];
        StringTokenizer stTocken = new StringTokenizer(in.readLine()," ");
        int index=0;
        while(stTocken.hasMoreElements()){
        	//quality[index]=Integer.parseInt(stTocken.nextToken());
        	quality[index]=intValueOf(stTocken.nextToken());
        	if(quality[index]>max)
        		max=quality[index];
        	MaxIncrement[index]=max;
        	index++;
        }
        //squality = in.readLine().split(" ");
        for(int i=0;i<nbIceParlors;i++){
        	if(maxD<quality[(nbIceParlors-1)-i])
        		maxD=quality[(nbIceParlors-1)-i];
        	MaxDecrement[(nbIceParlors-1)-i]=maxD;
        }
        int nbDays= intValueOf(in.readLine());
        //HashMap<String, Integer> hmRegions = new HashMap<String, Integer>(nbDays);
       //start = System.currentTimeMillis();
        while((nbDays--)>0){
        	//get Region Values
        	strRegion=in.readLine();
        	//StringTokenizer ST = new StringTokenizer(in.readLine()," ");
        	//Memoization
        	/*if(hmRegions.containsKey(strRegion)){
        		o.append(hmRegions.get(strRegion)).append("\n");
        	}*/
        	//else{
        		//StringTokenizer ST = new StringTokenizer(strRegion," ");
        		strtmp=strRegion.split(" ");
            	//Xi=Integer.parseInt(strtmp[0]);
        		//Xi=Integer.parseInt(ST.nextToken());
        		//Xi=intValueOf(ST.nextToken());
        		Xi=intValueOf(strtmp[0]);
            	//Yi=Integer.parseInt(strtmp[1]);
        		//Yi=intValueOf(ST.nextToken());
        		//Yi=Integer.parseInt(ST.nextToken());
        		Yi=intValueOf(strtmp[1]);
            	if(Xi-2>=0)
            		max1= MaxIncrement[Xi-2];
            	else
            		max1=0;
            	if(Yi<nbIceParlors)
            		max2=MaxDecrement[Yi];
            	else{
            		max2=0;
            	}
            	if(max1<max2)max=max2;
            	else max=max1;
	        	//print quality
            	//hmRegions.put(strRegion, new Integer(max));
	        	o.append(max).append("\n");
        	//}
    	}
        System.out.println(o.toString());
       //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
    public static int intValueOf( String str )
    {
        int ival = 0, idx = 0, end;
        boolean sign = false;
        char ch;

        if( str == null || ( end = str.length() ) == 0 ||
           ( ( ch = str.charAt( 0 ) ) < '0' || ch > '9' )
              && ( !( sign = ch == '-' ) || ++idx == end || ( ( ch = str.charAt( idx ) ) < '0' || ch > '9' ) ) )
            throw new NumberFormatException( str );

        for(;; ival *= 10 )
        {
            ival += '0'- ch;
            if( ++idx == end )
                return sign ? ival : -ival;
            if( ( ch = str.charAt( idx ) ) < '0' || ch > '9' )
                throw new NumberFormatException( str );
        }
    }
    
}
