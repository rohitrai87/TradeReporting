/**
 *
 * File Name             :TradeUtility.java
 *
 * Package Name          :com.trade.util
 *
 * Class Name            :TradeUtility.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade utility class
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

package com.trade.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.math.BigDecimal;

import com.trade.constants.TradeConstants;

public class TradeUtility {
	/**
	 * This method is to add days to the passed Date parameter
	 * @param date for input Date
	 * @param days for number of days to be added
	 * @return Revised Date
	 */
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}//End of addDays method
	
	/**
	 * This method is to sort the entities based on their incoming/outgoing amounts
	 * @param unsortedMap for Unsorted Ranking Map
	 * @return sortedMap for sorted Ranking Map
	 */
	public static Map<String, BigDecimal> sortMapByEntities(Map<String, BigDecimal> unsortedMap) {
		//Retrieve entities from the unsorted map
		Set<Entry<String, BigDecimal>> mapEntities = unsortedMap.entrySet();

		//Convert mapEntities into a Linked List
		List<Entry<String, BigDecimal>> llEntities = new LinkedList<Entry<String, BigDecimal>>(mapEntities);

		//Sorting the Linked List
		Collections.sort(llEntities, new Comparator<Entry<String, BigDecimal>>() {
			public int compare(Entry<String, BigDecimal> e1,
					Entry<String, BigDecimal> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		//Storing the list into Linked HashMap to preserve the order of insertion.
		Map<String, BigDecimal> sortedMap = new LinkedHashMap<String, BigDecimal>();
		for(Entry<String, BigDecimal> entry: llEntities) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}//End of sortMapByEntities method
	
	/**
	 * This method is to validate date format
	 * @param strValue for entered date
	 * @return boolean
	 */
	public static boolean isValidFormat(String strValue) throws ParseException {
        Date date = TradeConstants.sdf.parse(strValue);
        if (!strValue.equals(TradeConstants.sdf.format(date))) {
            date = null;
        }
        return date != null;
    }//End of isValidFormat method
	
}//End of TradeUtility class
