import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

//GoTo: http://www.codechef.com/problems/POINTS/ for instructions
public class Main {
	//---Points  by Santiaago :---

    public static void main(String[] args) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	//long start, end, total;
		//start =0;
        StringBuffer o = new StringBuffer("");
        int nbCases= Integer.parseInt(in.readLine());
        Comparator<Point> comp = new ComparePoints();
        int nbPoints=0;
        Point[] points;
        double distance =0;
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        String stmp="";
        //start = System.currentTimeMillis();
        while((nbCases--)>0){
        	in.readLine();
        	nbPoints=Integer.parseInt(in.readLine());
        	//Read nbPoints
        	points = new Point[nbPoints];
        	for(int i=0;i<nbPoints;i++){
        		stmp=in.readLine();
        		points[i]= new Point(Integer.parseInt((stmp.split(" ")[0])),Integer.parseInt((stmp.split(" ")[1])));
        	}
        	//Sort the Array
        	Arrays.sort(points, comp);
        	//Calculate the Distance
        	for(int i=0;i<nbPoints-1;i++){
        		distance= (distance +Math.sqrt(Math.pow((points[i+1].x-points[i].x),2)+Math.pow((points[i+1].y-points[i].y),2)));
        	}
        	o.append(twoPlaces.format(Math.round(distance*100)/100.0)).append("\n");
    		distance=0;
    	}
        System.out.println(o);
        //end = System.currentTimeMillis();
		//total = end - start;
		//System.out.println("Time:"+total);
		System.exit(0);
    }
    
}
 class Point{
	int x,y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
 class ComparePoints implements Comparator<Point>{

	public int compare(Point p1, Point p2) {
		if(p1.x<p2.x){ 
			return -1;
		}
		else if(p1.x>p2.x){ 
			return 1;
		}
		else {
			if(p1.y>p2.y)
			return -1;
			else if(p1.y<p2.y) return 1;
			else return 0;
		}
	}
	
}
