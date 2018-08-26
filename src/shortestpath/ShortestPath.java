package shortestpath;
import java.util.ArrayList;
import java.util.List;
public class ShortestPath {

	public static void main(String[] args) {
		
		List<String> arguments = new ArrayList<String>();
		
		arguments.add("A|2|B|1|C|10");
		arguments.add("B|2|A|1|C|3");
		arguments.add("C|2|A|10|B|3");
  
		
		Dikstra dik = new Dikstra(arguments);
		
		dik.search("B", "A");
	}


}
