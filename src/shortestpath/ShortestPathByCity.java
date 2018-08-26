package shortestpath;
import java.util.ArrayList;
import java.util.List;
public class ShortestPathByCity {

	public static void main(String[] args) {
		
		List<String> arguments = new ArrayList<String>();
		
		arguments.add("NEW YORK|2|PARIS|5839|RIO DE JANEIRO|7758");
		arguments.add("RIO DE JANEIRO|3|NEW YORK|7758|PARIS|9194|SIDNEY|13520");
		arguments.add("PARIS|4|NEW YORK|5839|RIO DE JANEIRO|9194|SIDNEY|16960|BEIJING|8226");
		arguments.add("SIDNEY|3|RIO DE JANEIRO|13520|PARIS|16960|BEIJING|12013");
		arguments.add("BEIJING|2|PARIS|8226|SIDNEY|12013");
		
		Dikstra dik = new Dikstra(arguments);
		
//		dik.search("RIO DE JANEIRO", "PARIS");
		
		dik.search("RIO DE JANEIRO", "BEIJING");
	}


}
