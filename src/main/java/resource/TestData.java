package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {
	
	public AddPlace addPlacePayload() {
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("test address");
		addPlace.setLanguage("English,EN");
		addPlace.setName("TEst name");
		addPlace.setPhone_number("9990087766");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		
		List<String> addTypes = new ArrayList<String>();
		addTypes.add("shoe park");
		addTypes.add("shop");
		addPlace.setTypes(addTypes);
		
		Location location = new Location();
		location.setLat(14.166846);
		location.setLng(76.3079116);
		addPlace.setLocation(location);
		return addPlace;
	}

}
