package schiffer.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ListSightings {
	public static void main(String[] args) throws JsonIOException,
			JsonSyntaxException, IOException {
		final Gson gson = new Gson();
		final FileReader reader = new FileReader("ufo_awesome.json");
		final SightingList list = gson.fromJson(reader, SightingList.class);
		Map<String, List<Sighting>> map = new HashMap<String, List<Sighting>>();
		
		System.out.println(list.size());
		
		List<Location> locList = readLocations();
		// print out all sightings on "19950115"
		for (Sighting s : list) {
			if ("19950115".equals(s.getSightedAt())) {
				for (Location l : locList) {
					String location = " " + l.getCity() + ", " + l.getState();
					if (location.equals(s.getLocation().toUpperCase())) {
						System.out.println(s.toString() + " zip= " + l.getZip());
					}
				}

			}

		}
	}

	public static List<Location> readLocations() throws IOException {
		ArrayList<Location> locList = new ArrayList<Location>();
		CSVReader reader = new CSVReader(new FileReader("./ZIP_CODES.txt"));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			String zip = nextLine[0];
			
			String city = nextLine[3];
			String state = nextLine[4];
			Location location = new Location(zip, city,
					state);
			locList.add(location);
		}
		return locList;

	}
}