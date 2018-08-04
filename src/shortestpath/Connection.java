package shortestpath;

public class Connection {

	private Point connectTo;
	private int distance = 0;
	
	public Connection(Point connectTo, int distance) {
		this.connectTo = connectTo;
		this.distance = distance;
	}
	public Point getConnectTo() {
		return connectTo;
	}
	public void setConnectTo(Point connectTo) {
		this.connectTo = connectTo;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
}
