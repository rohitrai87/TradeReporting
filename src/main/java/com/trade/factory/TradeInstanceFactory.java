/**
 *
 * File Name             :TradeInstanceFactory.java
 *
 * Package Name          :com.trade.factory
 *
 * Class Name            :TradeInstanceFactory.java
 *
 * Class Type            :Public
 *
 * Description           :This class is to instantiate Trade Factory
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:None
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :08-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.factory;

import java.util.ArrayList;
import java.util.List;
import com.trade.beans.Trade;

import java.math.BigDecimal;
import java.text.ParseException;
import com.trade.service.TradeProcessor;
import com.trade.service.impl.TradeProcessorImpl;
import com.trade.constants.TradeConstants;

public class TradeInstanceFactory {
	//ArrayList to store in memory Trades
	private static List<Trade> alTrades;

	/**
	 * This method will return only one instance of the ArrayList containing all the trades
	 */
	public static List<Trade> getTradeInstance() throws ParseException {
		if (alTrades == null) {
			alTrades = new ArrayList<Trade>();
			populateTrades();
		}
		return alTrades;
	}//End of getTradeInstance method

	/**
	 * This method will populate trades when this class is loaded for the first time
	 */
	private static void populateTrades() throws ParseException {
		Trade objTrade;
		TradeProcessor objTrdProc = new TradeProcessorImpl();
		
		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),200,BigDecimal.valueOf(100.25));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "S",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("29/07/2018"),300,BigDecimal.valueOf(100.15));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "S",BigDecimal.valueOf(0.22),"AED",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("27/07/2018"),350,BigDecimal.valueOf(101.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.22),"AED",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),450,BigDecimal.valueOf(150.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "S",BigDecimal.valueOf(0.22),"SAR",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("27/07/2018"),200,BigDecimal.valueOf(140.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.40),"SAR",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),800,BigDecimal.valueOf(10.25));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",BigDecimal.valueOf(0.70),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),4500,BigDecimal.valueOf(90.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",BigDecimal.valueOf(1.70),"GBP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("29/07/2018"),600,BigDecimal.valueOf(90.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("30/07/2018"),5420,BigDecimal.valueOf(100.25));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("hoo", "S",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("27/07/2018"),654,BigDecimal.valueOf(100.15));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("hoo", "S",BigDecimal.valueOf(0.22),"AED",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("29/07/2018"),599,BigDecimal.valueOf(101.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("moo", "B",BigDecimal.valueOf(0.22),"AED",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),9879,BigDecimal.valueOf(150.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("boo", "S",BigDecimal.valueOf(0.22),"SAR",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("27/07/2018"),8798,BigDecimal.valueOf(140.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.40),"SAR",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("29/07/2018"),3978,BigDecimal.valueOf(10.25));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",BigDecimal.valueOf(0.70),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("28/07/2018"),654,BigDecimal.valueOf(90.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("noo", "B",BigDecimal.valueOf(1.70),"GBP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("30/07/2018"),789,BigDecimal.valueOf(90.5));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);

		objTrade = new Trade("zoo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("22/07/2016"),TradeConstants.sdf.parse("29/07/2018"),6578,BigDecimal.valueOf(100.25));
		objTrade = objTrdProc.processTrade(objTrade);
		alTrades.add(objTrade);
	}//End of populateTrades method

}//End of TradeInstanceFactory class
