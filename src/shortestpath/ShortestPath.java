package shortestpath;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShortestPath {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int totalPointNums = Integer.parseInt(sc.nextLine());
//		List<String> arguments = new ArrayList<String>();
//		
//		for (int i = 0; i < totalPointNums; i++) {
//		      arguments.add(sc.nextLine());
//	    }
//		
//		sc.close();
		
		List<String> arguments = new ArrayList<String>();
		
		
//		arguments.add("New York:2:Rio De Janero:7758:Paris:5839");
//		arguments.add("Rio De Janero:2:Paris:9194:New York:7758");
//		arguments.add("Paris:3:Rio De Janero:9194:New York:5839");
		
		
		
//		arguments.add("New York:2:Rio De Janero:7758:Paris:5839");
//		arguments.add("Rio De Janero:2:Paris:9194:New York:7758");
//		arguments.add("Paris:3:Rio De Janero:9194:Sydney:16960:Beijing:8226");
//		arguments.add("Beijing:2:Paris:8226:Sydney:12013");
//		arguments.add("Sydney:3:Rio De Janero:13520:Paris:16960:Beijing:12013");

		
		arguments.add("A|2|B|1|C|10");
		arguments.add("B|2|A|1|C|3");
		arguments.add("C|2|A|10|B|3");
  
		
		Dikstra dik = new Dikstra(arguments);
		
//		dik.search("New York", "Sydney");
		
		dik.search("A", "C");
	}


}
