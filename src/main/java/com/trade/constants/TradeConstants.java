/**
 *
 * File Name             :TradeConstants.java
 *
 * Package Name          :com.trade.constants
 *
 * Class Name            :TradeConstants.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Constants class
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

package com.trade.constants;

import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class TradeConstants {
	public static final String INCOMING_SETTLEMENT_AMNT = "INCOMING_SETTLEMENT_AMNT";
	public static final String OUTGOING_SETTLEMENT_AMNT = "OUTGOING_SETTLEMENT_AMNT";
	public static final String INCOMING_ENTITY_RANK = "INCOMING_ENTITY_RANK";
	public static final String OUTGOING_ENTITY_RANK = "OUTGOING_ENTITY_RANK";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat day = new SimpleDateFormat("EEEE");
	public static final DecimalFormat df = new DecimalFormat("####0.00");
}//End of TradeConstants class