package schiffer.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	private final Map<String, List<DailyPrice>> map;

	
	public AmexData() throws IOException, ParseException {
		map = new HashMap<String, List<DailyPrice>>();
		
		String[] fileNames = { "./resources/amex/AMEX_daily_prices_A.csv",
				"./resources/amex/AMEX_daily_prices_B.csv",
				"./resources/amex/AMEX_daily_prices_C.csv",
				"./resources/amex/AMEX_daily_prices_D.csv" };

		for (int i = 0; i < fileNames.length; i++) {
			CSVReader reader = new CSVReader(new FileReader(fileNames[i]));
			reader.readNext();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String exchange = nextLine[0];
				String symbol = nextLine[1];
				String theDate = nextLine[2];
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = (Date)formatter.parse(theDate);
				double openPrice = Double.parseDouble(nextLine[3]);
				double highPrice = Double.parseDouble(nextLine[4]);
				double lowPrice = Double.parseDouble(nextLine[5]);
				double closePrice = Double.parseDouble(nextLine[6]);
				double volume = Double.parseDouble(nextLine[7]);
				double adjustedClosePrice = Double
						.parseDouble(nextLine[8]);
				DailyPrice price = new DailyPrice(exchange, symbol,
						date, openPrice, highPrice, lowPrice,
						closePrice, volume, adjustedClosePrice);
				this.add(price);
				
			}
		}
	}

	public boolean contains(String symbol) {
		String theSymbol = symbol.trim().toUpperCase();
		return map.containsKey(theSymbol);
	}

	/*
	 * Create a method getPrices(symbol) which returns List<DailyPrice>. Stocks
	 * should be ordered by ascending date. Return an empty list if the symbol
	 * does not exist
	 */
	public List<DailyPrice> getPrices(String symbol) {
		String theSymbol = symbol.trim().toUpperCase();

		List<DailyPrice> prices = map.get(theSymbol);

		if (prices.isEmpty()) {
			return new ArrayList<DailyPrice>();
		} else {
			return prices;

		}
	}

	/*
	 * Create a method getPrices(symbol, startDate, endDate) which returns
	 * List<DailyPrice> based on the date range (inclusive). Stocks should be
	 * ordered by ascending date. Return an empty list if the symbol does not
	 * exist or if there are no DailyPrice objects in the date range.
	 */

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> prices = map.get(symbol);
		List<DailyPrice> priceWithinDate = new ArrayList<DailyPrice>();
		for (DailyPrice aPrice : prices) {
			if (aPrice.getDate().after(startDate)
					&& aPrice.getDate().before(endDate)) {
				priceWithinDate.add(aPrice);
			}
		}
		if (priceWithinDate.isEmpty()) {
			return new ArrayList<DailyPrice>();
		} else {
			return priceWithinDate;
		}
	}
	
	
	public void add(DailyPrice price) {
		String symbol = price.getSymbol();
		if(map.get(symbol)!=null){
			map.get(symbol).add(price);
		}
		else{
			List<DailyPrice> list = new ArrayList<DailyPrice>();
			list.add(price);
			map.put(symbol, list);
		}
	}
	

}