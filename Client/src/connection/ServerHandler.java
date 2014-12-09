package connection;

import test.Client;
import jSon.AuthUserJson;
import jSon.CreateCalendarJson;
import jSon.EventsJson;
import jSon.GetAllCalendar;
import jSon.QuoteJson;
import jSon.WeatherJson;
import jSon.DeleteCalendarJson;
import jSon.EventsWeekJson;
import jSon.userToCalendar;
import jSon.AddNoteJson;
import jSon.NoteJson;
import jSon.subscribeUserJson;
import jSon.EventsDayJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerHandler {

	Client CL = new Client(); // new object of Client class
	Gson gson = new GsonBuilder().create(); // new object of Gson

	public String userCheck(String email, String password) { // method to check
																// if user is
																// active
																// already
		String userIsActive = "";
		AuthUserJson AUJ = new AuthUserJson();
		AUJ.setAuthUserEmail(email);
		AUJ.setAuthUserPassword(password);
		String gsonString = gson.toJson(AUJ);
		try {
			userIsActive = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userIsActive;
	}

	public String useToCalendar(String username, String Calendarname) { // sets
																		// the
																		// given
																		// users
																		// information
																		// in to
																		// a
																		// calendar
		String stringToBeReturned = "";
		userToCalendar UTC = new userToCalendar();
		UTC.setCalendarName(Calendarname);
		UTC.setEmail(username);
		String gsonString = gson.toJson(UTC);
		try {
			stringToBeReturned = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringToBeReturned;
	}

	public String[][] getCalendarsFromAll() {
		String[][] stringArrayToBeReturned = null;
		GetAllCalendar GAC = new GetAllCalendar();
		String gsonString = gson.toJson(GAC);
		try {
			stringArrayToBeReturned = gson.fromJson(
					CL.sentToServer(gsonString), String[][].class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringArrayToBeReturned;
	}
	
	public String[][] getEventsFromUSerDay(String allKnowingUsername) {
		String[][] stringArrayToBeReturned = null;
		EventsDayJson EDJ = new EventsDayJson();
		EDJ.setCreatedby(allKnowingUsername);
		String gsonString = gson.toJson(EDJ);
		try
		{ 
			stringArrayToBeReturned = gson.fromJson(CL.sentToServer(gsonString), String[][].class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stringArrayToBeReturned;
	}

	public void deleteCalendar(String calendarName, String allKnowingUsername) { // delete
																					// a
																					// calendar
		String stringToBeReturned = "";
		DeleteCalendarJson DCJ = new DeleteCalendarJson();
		DCJ.setCalenderName(calendarName);
		DCJ.setUserName(allKnowingUsername);
		String gsonString = gson.toJson(DCJ);
		try {
			stringToBeReturned = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCalendar(String calendarName, int pP, // create a calendar
			String allKnowingUsername) {
		String stringToBeReturned = "";
		CreateCalendarJson CCJ = new CreateCalendarJson();
		CCJ.setCalenderName(calendarName);
		CCJ.setPublicOrPrivate(pP);
		CCJ.setUserName(allKnowingUsername);
		String gsonString = gson.toJson(CCJ);
		try {
			stringToBeReturned = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getEventsFromUSerWeek(String allKnowingUsername) {
		System.out.println(allKnowingUsername);
		String[][] stringArrayToBeReturned = null;
		EventsWeekJson EWJ = new EventsWeekJson();
		EWJ.setCreatedby(allKnowingUsername);
		String gsonString = gson.toJson(EWJ);
		try {
			stringArrayToBeReturned = gson.fromJson(
					CL.sentToServer(gsonString), String[][].class);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringArrayToBeReturned;
	}

	public String weatherCheck() { // checks the weather by requesting it from
									// server
		String currentWeather = "";
		Gson gson = new GsonBuilder().create();
		WeatherJson WJ = new WeatherJson();
		String gsonString = gson.toJson(WJ);
		try {
			currentWeather = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WeatherJson WJ1 = gson.fromJson(currentWeather, WeatherJson.class);

		String weatherOutput = WJ1.getDegrees() + " " + WJ1.getDesc() + " "
				+ WJ1.getWeather();

		return weatherOutput;

	}

	public String getWeather() {
		String stringToBeReturned = "";
		String currentWeather = "";
		Gson gson = new GsonBuilder().create();
		WeatherJson WJ = new WeatherJson();
		String gsonString = gson.toJson(WJ);
		try {
			currentWeather = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WeatherJson WJ1 = gson.fromJson(currentWeather, WeatherJson.class);

		stringToBeReturned = "Hi! Welcome back. Today's temprature is: "
				+ WJ1.getDegrees() + " degrees, and the weather right now is: "
				+ WJ1.getDesc() + ".";
		return stringToBeReturned;

	}

	public String quoteCheck() { // request todays quote from server
		String currentQuote = "";
		Gson gson = new GsonBuilder().create();
		QuoteJson QJ = new QuoteJson();
		String gsonString = gson.toJson(QJ);
		try {
			currentQuote = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(currentQuote);
		QuoteJson QJ1 = gson.fromJson(currentQuote, QuoteJson.class);

		String quoteOutput = QJ1.getAuthor() + " " + QJ1.getQuote();

		return quoteOutput;
	}

	public String updateNote(String eventID, String noteText,
			String allKnowingUsername) {
		String stringToBeReturned = "";
		AddNoteJson ANJ = new AddNoteJson();
		ANJ.setCreatedBy(allKnowingUsername);
		ANJ.setEventID(eventID);
		ANJ.setNote(noteText);
		String gsonString = gson.toJson(ANJ);
		try {
			stringToBeReturned = CL.sentToServer(gsonString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringToBeReturned;
	}

	public String getNote(String eventID) {
		String stringToBeReturned = "";
		String stringFromServer = "";
		NoteJson NJ = new NoteJson();
		NJ.setEventID(eventID);
		String gsonString = gson.toJson(NJ);
		try {
			stringFromServer = CL.sentToServer(gsonString);
			try {
				NoteJson NJR = gson.fromJson(stringFromServer, NoteJson.class);
				stringToBeReturned = "Note for event " + NJR.getEventID()
						+ "\n" + NJR.getNote() + "\n" + "Created by: "
						+ NJR.getCreatedBy() + " " + NJR.getDateTime();
			} catch (Exception e) {
				stringToBeReturned = stringFromServer;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringToBeReturned;
	}

	public String getNoteText(String eventID) {
		String stringToBeReturned = "";
		String stringFromServer = "";
		NoteJson NJ = new NoteJson();
		NJ.setEventID(eventID);
		String gsonString = gson.toJson(NJ);
		try {
			stringFromServer = CL.sentToServer(gsonString);
			try {
				NoteJson NJR = gson.fromJson(stringFromServer, NoteJson.class);
				stringToBeReturned = NJR.getNote();
			} catch (Exception e) {
				stringToBeReturned = stringFromServer;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringToBeReturned;
	}

	public String subscribeOtherUser(String subscriber, String userName,
			String calendarName) {
		String stringToBeReturned = "";
		subscribeUserJson SUJ = new subscribeUserJson();
		SUJ.setCalendarName(calendarName);
		SUJ.setUsername(userName);
		SUJ.setSubscriber(subscriber);
		String gsonString = gson.toJson(SUJ);
		try {
			stringToBeReturned = CL.sentToServer(gsonString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringToBeReturned;

	}

	public String createEvent(String eventName, String eventLocation,
			String eventInfo, String eventTypeCombo, String startYear,
			String startMonth, String startDay, String startHour,
			String startMinute, String endYear, String endMonth, String endDay,
			String endHour, String endMinute, String Calendar) {
		String stringToBeReturned = "";
		EventsJson EJ1 = new EventsJson();
		EJ1.setName(eventName);
		EJ1.setLocationName(eventLocation);
		EJ1.setText(eventInfo);
		EJ1.setType(eventTypeCombo);
		EJ1.setStartYear(startYear);
		EJ1.setStartMonth(startMonth);
		EJ1.setStartDay(startDay);
		EJ1.setStartHour(startHour);
		EJ1.setStartMinute(startMinute);
		EJ1.setEndYear(endYear);
		EJ1.setEndMonth(endMonth);
		EJ1.setEndDay(endDay);
		EJ1.setEndHour(endHour);
		EJ1.setEndMinute(endMinute);
		EJ1.setCalendarID(Calendar);

		Gson gson = new GsonBuilder().create();
		String gsonString = gson.toJson(EJ1);

		try {
			stringToBeReturned = CL.sentToServer(gsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stringToBeReturned);

		return stringToBeReturned;
	}

}
