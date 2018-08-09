/**
 *
 * File Name             :TradeDAO.java
 *
 * Package Name          :com.trade.DAO
 *
 * Class Name            :TradeDAO.java
 *
 * Class Type            :Public
 *
 * Description           :This class is for Trade Data Access
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

package com.trade.DAO;

import java.text.ParseException;
import java.util.List;
import com.trade.beans.Trade;
import com.trade.executor.TradeSalesSimulator;

/**
 * Normally this class would be used to fetch trade details from the database. But,
 * in this exercise it is being fetched from in memory and stored into an ArrayList
 */
public class TradeDAO {
	private static List<Trade> alTrades;
	public List<Trade> getTrades() throws ParseException {
		TradeSalesSimulator objSim = new TradeSalesSimulator();
		alTrades = objSim.getTradeDetails();
		return alTrades;
	}//End of getTrades method
}//End of TradeDAO class
