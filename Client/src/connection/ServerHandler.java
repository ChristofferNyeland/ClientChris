package connection;

import test.Client;
import jSon.AuthUserJson;
import jSon.CreateCalendarJson;
import jSon.EventsJson;
import jSon.QuoteJson;
import jSon.WeatherJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerHandler {
	
	Client CL = new Client();
	
	public String userCheck(String email, String password){
		String userIsActive = "";
		Gson gson = new GsonBuilder().create();
		AuthUserJson AUJ = new AuthUserJson();
		AUJ.setAuthUserEmail(email);
		AUJ.setAuthUserPassword(password);
		String gsonString = gson.toJson(AUJ);
		try{
			userIsActive = CL.sentToServer(gsonString);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return userIsActive;		
	}
	
	public String weatherCheck(){
	String currentWeather = "";
	Gson gson = new GsonBuilder().create();
	WeatherJson WJ = new WeatherJson();
	String gsonString = gson.toJson(WJ);
	try{
		currentWeather = CL.sentToServer(gsonString);
	}
	catch (Exception e){
		e.printStackTrace();
	}
	
	WeatherJson WJ1 = gson.fromJson(currentWeather, WeatherJson.class);

	String weatherOutput = WJ1.getDegrees() +" "+ WJ1.getDesc() +" "+ WJ1.getWeather();

	return weatherOutput;
	
	
	
	}
	
	public String quoteCheck(){
		String currentQuote = "";
		Gson gson = new GsonBuilder().create();
		QuoteJson QJ = new QuoteJson();
		String gsonString = gson.toJson(QJ);
		try{
			currentQuote = CL.sentToServer(gsonString);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(currentQuote);
		QuoteJson QJ1 = gson.fromJson(currentQuote, QuoteJson.class);
		
		String quoteOutput = QJ1.getAuthor() + " " + QJ1.getQuote();
 		
		return quoteOutput;
	}
	
	public String createEvent(String eventName, String eventLocation, String eventInfo, String eventTypeCombo, String startYear, String startMonth, String startDay, String startHour, String startMinute, String endYear, String endMonth, String endDay, String endHour, String endMinute, String Calendar){
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
		
		try{
			stringToBeReturned = CL.sentToServer(gsonString);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(stringToBeReturned);
		//EventsJson EJ2 = gson.fromJson(stringToBeReturned, EventsJson.class);

		//String eventOutput = EJ2.getCalendarID() /*+ " " + EJ2.getLocation() */+ " " + EJ2.getLocationName() + " " + EJ2.getName() + " " + EJ2.getText() + " " + EJ2.getType() + " " + EJ2.getStartYear() + " " + EJ2.getStartMonth() + " " + EJ2.getStartDay() + " " + EJ2.getStartHour() + " " + EJ2.getStartMinute() + " " + EJ2.getEndYear() + " " + EJ2.getEndMonth() + " " + EJ2.getEndDay() + " " + EJ2.getEndHour() + " " + EJ2.getEndMinute() + " " + EJ2.getCalendarID();
		return stringToBeReturned;
	}

}


