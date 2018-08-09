/**
 *
 * File Name             :TradeMapping.java
 *
 * Package Name          :com.trade.service
 *
 * Class Name            :TradeMapping.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Mapping Interface
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

package com.trade.service;

import java.util.List;
import java.util.Map;
import com.trade.beans.Trade;
import java.math.BigDecimal;

public interface TradeMapping {
    public abstract Map<String, Map<String, BigDecimal>> getTradeMap(List<Trade> alTrade);
}//End of TradeProcessor interface
