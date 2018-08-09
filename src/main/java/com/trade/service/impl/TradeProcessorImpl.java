/**
 *
 * File Name             :TradeProcessorImpl.java
 *
 * Package Name          :com.trade.service.impl
 *
 * Class Name            :TradeProcessorImpl.java
 *
 * Class Type            :Public
 *
 * Description           :This class implements TradeProcessor Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:TradeProcessor
 *
 * Author Name           :Rohit.Rai
 *
 * Date                  :08-Aug-2018
 *
 * Revision History      :1.0.0.0
 *                        Author Name  Date        Change Description  Version	 	
 *
 */

package com.trade.service.impl;

import com.trade.beans.Trade;
import com.trade.constants.TradeCurrency;
import com.trade.constants.TradeWeekends;
import com.trade.service.TradeProcessor;
import com.trade.util.TradeUtility;
import com.trade.constants.TradeConstants;
import java.math.BigDecimal;

public class TradeProcessorImpl implements TradeProcessor {
	/**
	 * This method is used to process the trades and calculate their amounts and revised settlement dates
	 * @param objTrade for trade
	 * @return objTrade for processed trade
	 */
	public Trade processTrade(Trade objTrade) {
		BigDecimal bdTrdAmount;
		BigDecimal bdPrcPerUnit;
		BigDecimal bdFx;
		long lUnits;

		//Calculating Revised settlement date based on Currency
		if((objTrade.getStrCurr().equalsIgnoreCase(TradeCurrency.AED)) 
				|| (objTrade.getStrCurr().equalsIgnoreCase(TradeCurrency.SAR))) {
			if(TradeConstants.day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.FRI)) {
				objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 2));
			} else if(TradeConstants.day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SAT)) {
				objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 1));
			} else {
				objTrade.setRevStlmntDate(objTrade.getOrigStlmntDate());
			}
		} else {
			if(TradeConstants.day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SAT)) {
				objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 2));
			} else if(TradeConstants.day.format(objTrade.getOrigStlmntDate()).equalsIgnoreCase(TradeWeekends.SUN)) {
				objTrade.setRevStlmntDate(TradeUtility.addDays(objTrade.getOrigStlmntDate(), 1));
			} else {
				objTrade.setRevStlmntDate(objTrade.getOrigStlmntDate());
			}
		}//End of currencies other than AED and SAR else block

		//Reading properties from the trade object and setting the trade amount
		bdPrcPerUnit = objTrade.getPricePerUnit();
		lUnits = objTrade.getUnits();
		bdFx = objTrade.getFxRate();
		bdTrdAmount = bdPrcPerUnit.multiply(bdFx).multiply(new BigDecimal(lUnits));
		objTrade.setTrdAmount(bdTrdAmount);

		return objTrade;
	}//End of processTrade method
	
}//End of TradeProcessorImpl class
