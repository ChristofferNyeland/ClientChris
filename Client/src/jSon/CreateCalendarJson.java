package jSon;

public class CreateCalendarJson implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createCalendar";
	private String calendarName;
	private String userName;
	private int publicOrPrivate;
	
	//Getters and setters for everything
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalenderName() {
		return calendarName;
	}
	public void setCalenderName(String calenderName) {
		this.calendarName = calenderName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}
	public void setPublicOrPrivate(int publicPrivate) {
		this.publicOrPrivate = publicPrivate;
	}

}
