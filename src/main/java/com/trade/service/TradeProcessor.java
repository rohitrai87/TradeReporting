/**
 *
 * File Name             :TradeProcessor.java
 *
 * Package Name          :com.trade.service
 *
 * Class Name            :TradeProcessor.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Processor Interface
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

import com.trade.beans.Trade;

public interface TradeProcessor {
    public abstract Trade processTrade(Trade objTrade);
}//End of TradeProcessor interface
