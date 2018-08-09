/**
 *
 * File Name             :TradeMappingImpl.java
 *
 * Package Name          :com.trade.service.impl
 *
 * Class Name            :TradeMappingImpl.java
 *
 * Class Type            :Public
 *
 * Description           :This class implements TradeMapping Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:TradeMapping
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.constants.TradeType;
import com.trade.service.TradeMapping;
import java.math.BigDecimal;

public class TradeMappingImpl implements TradeMapping {
	private Map<String, BigDecimal> hmIncomingStlmntAmnt = new HashMap<String, BigDecimal>();
	private Map<String, BigDecimal> hmOutgoingStlmntAmnt = new HashMap<String, BigDecimal>();
	private Map<String, BigDecimal> hmIncomingEntityRank = new HashMap<String, BigDecimal>();
	private Map<String, BigDecimal> hmOutgoingEntityRank = new HashMap<String, BigDecimal>();
	private Map<String, Map<String, BigDecimal>> hmMap = new HashMap<String, Map<String, BigDecimal>>();

	/**
	 * This method is used to return a map containing all the trade reporting detail maps
	 * @param alTrades for all the list of trades
	 * @return hmMap for HashMap containing final trade details
	 */
	public Map<String, Map<String, BigDecimal>> getTradeMap(List<Trade> alTrades) {
		String strEntity;
		String strStlmntDate;
		BigDecimal bdTotalAmount = BigDecimal.ZERO;
		BigDecimal bdTrdAmount = BigDecimal.ZERO;
		
		//Looping through the trades
		for(Trade objTrade : alTrades) {
			strEntity = objTrade.getStrEntity();
			strStlmntDate = TradeConstants.sdf.format(objTrade.getRevStlmntDate());
			bdTrdAmount = objTrade.getTrdAmount();

			//Populating the Incoming and Outgoing HashMaps for Entities and Reporting dates
			if(objTrade.getStrFlag().equalsIgnoreCase(TradeType.SELL)) {
				//Incoming settlement block
				if(hmIncomingStlmntAmnt.containsKey(strStlmntDate)) {
					bdTotalAmount = hmIncomingStlmntAmnt.get(strStlmntDate);
					bdTotalAmount = bdTotalAmount.add(bdTrdAmount);
					hmIncomingStlmntAmnt.put(strStlmntDate, bdTotalAmount);
				} else {
					hmIncomingStlmntAmnt.put(strStlmntDate, bdTrdAmount);
				}

				//Incoming entity rank block
				if(hmIncomingEntityRank.containsKey(strEntity)) {
					bdTotalAmount = hmIncomingEntityRank.get(strEntity);
					bdTotalAmount = bdTotalAmount.add(bdTrdAmount);
					hmIncomingEntityRank.put(strEntity, bdTotalAmount);
				} else {
					hmIncomingEntityRank.put(strEntity, bdTrdAmount);
				}
			} else if (objTrade.getStrFlag().equalsIgnoreCase(TradeType.BUY)) {
				//Outgoing settlement block
				if(hmOutgoingStlmntAmnt.containsKey(strStlmntDate)) {
					bdTotalAmount = hmOutgoingStlmntAmnt.get(strStlmntDate);
					bdTotalAmount = bdTotalAmount.add(bdTrdAmount);
					hmOutgoingStlmntAmnt.put(strStlmntDate, bdTotalAmount);
				} else {
					hmOutgoingStlmntAmnt.put(strStlmntDate, bdTrdAmount);
				}

				//Outgoing entity rank block
				if(hmOutgoingEntityRank.containsKey(strEntity)) {
					bdTotalAmount = hmOutgoingEntityRank.get(strEntity);
					bdTotalAmount = bdTotalAmount.add(bdTrdAmount);
					hmOutgoingEntityRank.put(strEntity, bdTotalAmount);
				} else {
					hmOutgoingEntityRank.put(strEntity, bdTrdAmount);
				}
			}//End of BUY block
		}//End of trades for loop

		hmMap.put(TradeConstants.INCOMING_SETTLEMENT_AMNT, hmIncomingStlmntAmnt);
		hmMap.put(TradeConstants.OUTGOING_SETTLEMENT_AMNT, hmOutgoingStlmntAmnt);
		hmMap.put(TradeConstants.INCOMING_ENTITY_RANK, hmIncomingEntityRank);
		hmMap.put(TradeConstants.OUTGOING_ENTITY_RANK, hmOutgoingEntityRank);

		return hmMap;
	}//End of getTradeMap method
	
}//End of TradeMappingImpl class
