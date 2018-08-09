/**
 *
 * File Name             :TradeSalesSimulator.java
 *
 * Package Name          :com.trade.executor
 *
 * Class Name            :TradeSalesSimulator.java
 *
 * Class Type            :Public
 *
 * Description           :This class is to Simulate incoming/outgoing trades
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

package com.trade.executor;

import java.util.List;
import com.trade.beans.Trade;
import com.trade.factory.TradeInstanceFactory;
import java.text.ParseException;

public class TradeSalesSimulator {
	//Instance Variables declarations
	private List<Trade> alTrades;

	/**
	 * This method will fetch trades from the trade factory
	 */
	public List<Trade> getTradeDetails() throws ParseException {
		alTrades = TradeInstanceFactory.getTradeInstance();
		return alTrades;
	}//End of getTradeDetails method

}//End of TradeSalesSimulator class
