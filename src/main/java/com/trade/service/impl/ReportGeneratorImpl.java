/**
 *
 * File Name             :ReportGeneratorImpl.java
 *
 * Package Name          :com.trade.service.impl
 *
 * Class Name            :ReportGeneratorImpl.java
 *
 * Class Type            :Public
 *
 * Description           :This class implements ReportGenerator Interface
 * 
 * Super Class           :None
 *
 * Interfaces Implemented:ReportGenerator
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

import java.util.Map;
import java.util.Map.Entry;
import com.trade.constants.TradeConstants;
import com.trade.service.ReportGenerator;
import com.trade.util.TradeUtility;
import java.math.BigDecimal;

public class ReportGeneratorImpl implements ReportGenerator {
	
	/**
	 * This method is used to generate incoming trade sales report
	 * @param strReportDate for Reporting Date
	 * @param hmIncomingStlmntAmnt for HashMap containing incoming trade details
	 */
	public void generateIncomingTradeSalesReport(String strReportDate, Map<String, BigDecimal> hmIncomingStlmntAmnt) {
		//Printing the reporting output
		System.out.println("****** Amount in incoming USD settled for settlement day " + strReportDate + " *******");
		if(hmIncomingStlmntAmnt.containsKey(strReportDate)) {
			System.out.println(hmIncomingStlmntAmnt.get(strReportDate));
		} else {
			System.out.println("There are no incoming trades for the settlement day " + strReportDate + "!!!");
		}
		System.out.println("***************************************************************************");
		
	}//End of generateIncomingTradeSalesReport method
	
	/**
	 * This method is used to generate outgoing trade sales report
	 * @param strReportDate for Reporting Date
	 * @param hmOutgoingStlmntAmnt for HashMap containing outgoing trade details
	 */
	public void generateOutgoingTradeSalesReport(String strReportDate, Map<String, BigDecimal> hmOutgoingStlmntAmnt) {
		//Printing the reporting output
		System.out.println("****** Amount in outgoing USD settled for settlement day " + strReportDate + " *******");
		if(hmOutgoingStlmntAmnt.containsKey(strReportDate)) {
			System.out.println(hmOutgoingStlmntAmnt.get(strReportDate));
		} else {
			System.out.println("There are no outgoing trades for the settlement day " + strReportDate + "!!!");
		}
		System.out.println("***************************************************************************");

	}//End of generateOutgoingTradeSalesReport method

	/**
	 * This method is used to generate incoming entity ranking report
	 * @param hmIncomingEntityRank for HashMap containing incoming entity trade mapping details
	 */
	public void generateIncomingEntityRankingReport(Map<String, BigDecimal> hmIncomingEntityRank) {
		//Printing the reporting output
		System.out.println("***************** Ranking of Incmoing Entities: ***************************");
		System.out.println(printRankReport(TradeUtility.sortMapByEntities(hmIncomingEntityRank)));
		System.out.println("***************************************************************************");

	}//End of generateIncomingEntityRankingReport method
	
	/**
	 * This method is used to generate outgoing entity ranking report
	 * @param hmOutgoingEntityRank for HashMap containing outgoing entity trade mapping details
	 */
	public void generateOutgoingEntityRankingReport(Map<String, BigDecimal> hmOutgoingEntityRank) {
		//Printing the reporting output
		System.out.println("***************** Ranking of Outgoing Entities: ***************************");
		System.out.println(printRankReport(TradeUtility.sortMapByEntities(hmOutgoingEntityRank)));
		System.out.println("***************************************************************************");

	}//End of generateOutgoingEntityRankingReport method

	
	/**
	 * This method is used to print trade sales report
	 * @param hmSortedMap for Sorted Ranking Map
	 */
	private String printRankReport(Map<String, BigDecimal> hmSortedMap) {
		//Printing values after sorting the map
		int iRank = 0;
		StringBuffer sbOutput = new StringBuffer();
		sbOutput.append("---------------------------------------------------------------------------").append("\n")
		.append("Entity			Rank			Trading Amount" + "\n");
		for(Entry<String, BigDecimal> entry : hmSortedMap.entrySet()) {
			iRank ++;
			sbOutput.append(entry.getKey() + "\t\t\t" + iRank + "\t\t\t $" + TradeConstants.df.format(entry.getValue()) + "\n");
		}
		sbOutput.append("---------------------------------------------------------------------------");
		return sbOutput.toString();
	}//End of printRankReport method
	
}//End of ReportGeneratorImpl class
