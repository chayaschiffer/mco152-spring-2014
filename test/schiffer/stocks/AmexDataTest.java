package schiffer.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void test() throws IOException, ParseException {
		new AmexData();
	}

	@Test
	public void testContainsTrue() throws IOException, ParseException {
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("AIP"));
	}

	@Test
	public void testContainsNotTrue() throws IOException, ParseException {
		AmexData data = new AmexData();
		Assert.assertFalse(data.contains("AAAA"));
	}
	@Test
	public void testGetPrice()throws IOException, ParseException{
		AmexData data = new AmexData();
		List<DailyPrice> prices = new ArrayList<DailyPrice>();
		prices = data.getPrices("AIP");
		Assert.assertFalse(prices.isEmpty());
		Assert.assertTrue(prices.get(0).getSymbol().equals("AIP"));
	}
	
	@Test
	public void testGetPricesWithDate()throws IOException, ParseException{
		String symbol = "AIP";
		String startDate = new String("2009-12-28");
		String endDate = new String("2010-1-26");
		AmexData data = new AmexData();
		List<DailyPrice> prices = new ArrayList<DailyPrice>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date start = (Date)formatter.parse(startDate);
		Date end = (Date)formatter.parse(endDate);
		prices = data.getPrices("AIP", start,end );
		Assert.assertFalse(prices.isEmpty());
		Assert.assertTrue(prices.get(0).getOpenPrice()==69.54);
	}
}
