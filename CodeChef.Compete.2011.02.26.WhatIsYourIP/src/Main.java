import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//GoTo: http://www.codechef.com/DSPCXI/problems/DSPCXI01/ for instructions
public class Main {
	 //---IP by Santiaago :---
	public static void main(String[] args) throws IOException{
    	//long start, end, total;
		//start =0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer o = new StringBuffer("");
        //start = System.currentTimeMillis();
        String strIP = "";
        String[] tabIP ;
        boolean isClean=false;
        int[] IPnumbers = new int[4];
        while((strIP=in.readLine())!=null){
        	isClean = strIP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        	//System.out.println("isClean:"+isClean);
        	if(isClean){
        		isClean=false;
	        	tabIP= strIP.split("\\.");
	        	//if(tabIP.length!=4) break;
	        	IPnumbers[0]= Integer.parseInt(tabIP[0]);
	        	IPnumbers[1]= Integer.parseInt(tabIP[1]);
	        	IPnumbers[2]= Integer.parseInt(tabIP[2]);
	        	IPnumbers[3]= Integer.parseInt(tabIP[3]);
	        	//Class A
	        	if(IPnumbers[0]>=1 && IPnumbers[0]<=127)
	        	{
	        		if(IPnumbers[1]>=0 && IPnumbers[1]<=255)
	        		{
	        			if(IPnumbers[2]>=0 && IPnumbers[2]<=255)
	        			{
	        				if(IPnumbers[3]>=0 && IPnumbers[3]<=255){o.append("Class A\n");}
	        	        	else{o.append("Invalid\n");}
	            		}
	                	else{o.append("Invalid\n");}
	        		}
	            	else{
	            		o.append("Invalid\n");
	            	}
	        	}
	        	//Class B
	        	else if(IPnumbers[0]>=128 && IPnumbers[0]<=191)
	        	{
	        		if(IPnumbers[1]>=0 && IPnumbers[1]<=255)
	        		{
	        			if(IPnumbers[2]>=0 && IPnumbers[2]<=255)
	        			{
	        				if(IPnumbers[3]>=0 && IPnumbers[3]<=255){o.append("Class B\n");}
	        	        	else{o.append("Invalid\n");}
	            		}
	                	else
	                	{
	                		o.append("Invalid\n");
	                	}
	        		}
	            	else
	            	{
	            		o.append("Invalid\n");
	            	}
	        	}
	        	//Class C
	        	else if(IPnumbers[0]>=192 && IPnumbers[0]<=223)
	        	{
	        		if(IPnumbers[1]>=0 && IPnumbers[1]<=255)
	        		{
	        			if(IPnumbers[2]>=0 && IPnumbers[2]<=255)
	        			{
	        				if(IPnumbers[3]>=0 && IPnumbers[3]<=255)
	        				{
	        					o.append("Class C\n");
	        				}
	        	        	else
	        	        	{
	        	        		o.append("Invalid\n");
	        	        	}
	            		}
	                	else
	                	{
	                		o.append("Invalid\n");
	                	}
	        		}
	            	else{o.append("Invalid\n");}
	        	}
	        	//Class D
	        	else if(IPnumbers[0]>=224 && IPnumbers[0]<=239)
	        	{
	        		if(IPnumbers[1]>=0 && IPnumbers[1]<=255)
	        		{
	        			if(IPnumbers[2]>=0 && IPnumbers[2]<=255)
	        			{
	        				if(IPnumbers[3]>=0 && IPnumbers[3]<=255)
	        				{
	        					o.append("Class D\n");
	                		}
	        	        	else{
	        	        		o.append("Invalid\n");
	        	        	}
	            		}
	                	else{
	                		o.append("Invalid\n");
	                	}
	        		}
	            	else{
	            		o.append("Invalid\n");
	            	}
	        	}
	        	//Class E
	        	else if(IPnumbers[0]>=240 && IPnumbers[0]<=255)
	        	{
	        		if(IPnumbers[1]>=0 && IPnumbers[1]<=255)
	        		{
	        			if(IPnumbers[2]>=0 && IPnumbers[2]<=255)
	        			{
	        				if(IPnumbers[3]>=0 && IPnumbers[3]<=254)
	        				{
	        					o.append("Class E\n");
	                		}
	        	        	else
	        	        	{
	        	        		o.append("Invalid\n");
	        	        	}
	            		}
	                	else
	                	{
	                		o.append("Invalid\n");
	                	}
	        		}
	            	else
	            	{
	            		o.append("Invalid\n");
	            	}
	        	}
	        	else
	        	{
	        		o.append("Invalid\n");
	        	}
        	}
        	else
        	{
        		o.append("Invalid\n");
        	}
        }
        //if(o!=null)
        System.out.print(o);
        /*
        end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Time:"+total);
		*/
        System.exit(0);
    }
    
}


