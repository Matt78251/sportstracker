package application.model;

public class GraphEvent {

	long timeOccured;
	String team;
	int pointDiff;
	
	public GraphEvent( long time, String teamFor, int point ) {
		this.timeOccured = time;
		this.team = teamFor;
		this.pointDiff = point;
	}
	
	public long getTimeOccured() {
		return this.timeOccured;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public int getPointDiff() {
		return this.pointDiff;
	}
	
	public void setTime(long t) {
		this.timeOccured = t;
	}
	
	public void setTeam(String a) {
		this.team = a;
	}
	
	public void setPoint(int a) {
		this.pointDiff = a;
	}
	
}
