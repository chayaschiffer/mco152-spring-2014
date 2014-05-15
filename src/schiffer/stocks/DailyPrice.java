package schiffer.stocks;

import java.io.IOException;
import java.util.Date;

public class DailyPrice {
	private String exchange;
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private double volume;
	private double adjustedClosePrice;
	
	public DailyPrice(String exchange, String symbol, Date date,
			double openPrice, double highPrice, double lowPrice,
			double closePrice, double volume, double adjustedClosePrice)
			throws IOException {
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;

	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public double getVolume() {
		return volume;
	}

	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

	@Override
	public String toString() {
		return "DailyPrice [exchange=" + exchange + ", symbol=" + symbol
				+ ", date=" + date + ", openPrice=" + openPrice
				+ ", highPrice=" + highPrice + ", lowPrice=" + lowPrice
				+ ", closePrice=" + closePrice + ", volume=" + volume
				+ ", adjustedClosePrice=" + adjustedClosePrice + "]";
	}

}
