package shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Point {

	private String name;
	private int previousCost = 0;
	private List<Connection> connections = new ArrayList<Connection>();
	private Point previous;
	private boolean done = false;
    private List<Point> alternatives = new ArrayList<Point>();
	
	public Point(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Connection> getConnections() {
		return connections;
	}
	public void addConnections(Connection connection) {
		this.connections.add(connection);
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Point getPrevious() {
		return previous;
	}
	public void setPrevious(Point previous) {
		this.previous = previous;
	}
	public int getPreviousCost() {
		return previousCost;
	}
	public void setPreviousCost(int previousCost) {
		this.previousCost = previousCost;
	}
	public List<Point> getAlternatives() {
		return alternatives;
	}
	public void addtAlternatives(Point alternative) {
		this.alternatives.add(alternative);
	}
	
	

}
