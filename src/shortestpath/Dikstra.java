package shortestpath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dikstra {
	
	private Map<String, Point> stringToPointMap = new HashMap<>();
	private Map<Point, Integer> cost = new HashMap<Point, Integer>();

	public Dikstra(List<String> arguments) {
		setup(arguments);	
	}
	
	private void setup(List<String> arguments) {

		for(String argument : arguments) {
			
			String[] datas =  argument.split("\\|");
			String name = datas[0];
			
			Point point = new Point(name);
			stringToPointMap.put(name, point);
			cost.put(point, Integer.MAX_VALUE);
			
		};
		
		for(String argument : arguments) {
			
			String[] datas =  argument.split("\\|");
			
			String name = datas[0];
			Point point = stringToPointMap.get(name);
			
			for(int count=2; count < datas.length; count = (count+2)) {
				String connectionPointName = datas[count];
				Integer distance = Integer.parseInt(datas[count+1]);
				
				Point connectionPoint = stringToPointMap.get(connectionPointName);
				Connection conn = new Connection(connectionPoint, distance);
				
				point.addConnections(conn);
			}
			
		}
		
	}

	public void search(String startPointName, String endPointName) {
		
		Point startPoint = stringToPointMap.get(startPointName);
		cost.put(startPoint, 0);
		
		/*
		 * Do search
		 */
		updatePoints(startPoint);
		
		/*
		 * Generate result for ouput
		 */
		Point endPoint = stringToPointMap.get(endPointName);
		Point previousPoint = endPoint;
		Stack<Point> result = new Stack<Point>();
		while(true) {
			
			previousPoint = previousPoint.getPrevious();


			if(previousPoint == null) {
				break;
			} else {

				result.push(previousPoint);
				
			}
			
		}
		
		/*
		 * Output result
		 */
		while(!result.isEmpty()) {
			Point point = result.pop();
			System.out.println("Route : " + point.getName() + " (Distance : " + point.getPreviousCost() + ")");
		}
		
		System.out.println("Route : " + endPoint.getName() + " (Distance : " + endPoint.getPreviousCost() + ")");
		System.out.println("Total distance : " + cost.get(stringToPointMap.get(endPointName)));
		
		/*
		 * Output alternative way
		 */
		System.out.println("---Alternative Ways---");
		outputAlternatives(endPoint.getAlternatives());
		
	}
	
	private void updatePoints(Point point) {
		 
		boolean isAllDone = true;
		List<Connection> connections = point.getConnections();
		for(Connection connection : connections) {
			Point connectTo = connection.getConnectTo();
			
			if(!connectTo.isDone()) {
				
				isAllDone = false;
				if(cost.get(connectTo) > cost.get(point) + connection.getDistance()) {
					
					/*
					 * Add as an alternative way
					 */
					if(cost.get(connectTo) != Integer.MAX_VALUE) {
						connectTo.addtAlternatives(point);
					}
					
					/*
					 * Then update previous
					 */
					cost.put(connectTo, cost.get(point) + connection.getDistance());
					connectTo.setPrevious(point);
					connectTo.setPreviousCost(connection.getDistance());
					
				} else {
					/*
					 * Add as an alternative way
					 */
					if(cost.get(connectTo) != Integer.MAX_VALUE) {
						connectTo.addtAlternatives(point);
					}
				}
				
			}
			
		}
		
		/*
		 * Set as done
		 */
		point.setDone(true); 
		
		if(isAllDone) {
			return;
		}
		
		for(Connection connection : connections) {
			Point connectTo = connection.getConnectTo();

			if(!connectTo.isDone()) {
				updatePoints(connectTo);
			}
			
		}
		
	}
	
	private void outputAlternatives(List<Point> alternatives) {
		 
		for(Point alternative : alternatives) {
			System.out.println(alternative.getName());
			Point previous = alternative.getPrevious();
			System.out.println(previous.getName());
			while(previous!=null) {
				previous = previous.getPrevious();
				if(previous!=null) {
					System.out.println(previous.getName());
				}
				
			}
		}
		
	}
	
	
}
