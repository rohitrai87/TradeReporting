/**
 *
 * File Name             :TradeReportingMainApp.java
 *
 * Package Name          :com.trade.executor
 *
 * Class Name            :TradeReportingMainApp.java
 *
 * Class Type            :Public
 *
 * Description           :This class is for executing Trade Reports
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

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import com.trade.DAO.TradeDAO;
import com.trade.service.ReportGenerator;
import com.trade.service.TradeMapping;
import com.trade.service.impl.ReportGeneratorImpl;
import com.trade.service.impl.TradeMappingImpl;
import com.trade.util.TradeUtility;
import com.trade.constants.TradeConstants;
import com.trade.exceptions.IncorrectDateFormatException;

public class TradeReportingMainApp {
	public static void main(String[] args) throws IncorrectDateFormatException {
		TradeMapping objTrdProc = new TradeMappingImpl();
		ReportGenerator objRepGen = new ReportGeneratorImpl();
		Map<String, Map<String, BigDecimal>> hmMap;
		TradeDAO objTrdDAO = new TradeDAO();
		Map<String, BigDecimal> hmIncomingStlmntAmnt;
		Map<String, BigDecimal> hmOutgoingStlmntAmnt;
		Map<String, BigDecimal> hmIncomingEntityRank;
		Map<String, BigDecimal> hmOutgoingEntityRank;
		
		try {
			hmMap = objTrdProc.getTradeMap(objTrdDAO.getTrades());
			//Read Reporting Date from the console
			System.out.print("Enter a date for reporting in dd/MM/yyyy format: ");
			Scanner scanner = new Scanner(System.in);
			String strDate = scanner.nextLine();
			Date repDate = TradeConstants.sdf.parse(strDate);
			String strReportDate = TradeConstants.sdf.format(repDate);
			scanner.close();
			//Validate Date Format
			if(!TradeUtility.isValidFormat(strDate)) {
				throw new IncorrectDateFormatException("Date format is incorrect!!!");
			}
			
			System.out.println("Reporting date: " + strReportDate);
			
			//Incoming Trade Settlement Block
			if(hmMap.containsKey(TradeConstants.INCOMING_SETTLEMENT_AMNT)) {
				hmIncomingStlmntAmnt = hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT);
				objRepGen.generateIncomingTradeSalesReport(strReportDate, hmIncomingStlmntAmnt);
			} else {
				System.out.println("There are no incoming trades settled on the reporting day " + strReportDate + "!!!");
			}
			
			//Outgoing Trade Settlement Block
			if(hmMap.containsKey(TradeConstants.OUTGOING_SETTLEMENT_AMNT)) {
				hmOutgoingStlmntAmnt = hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT);
				objRepGen.generateOutgoingTradeSalesReport(strReportDate, hmOutgoingStlmntAmnt);
			} else {
				System.out.println("There are no outgoing trades settled on the reporting day " + strReportDate + "!!!");
			}
			
			//Incoming Entity Ranking Block
			if(hmMap.containsKey(TradeConstants.INCOMING_ENTITY_RANK)) {
				hmIncomingEntityRank = hmMap.get(TradeConstants.INCOMING_ENTITY_RANK);
				objRepGen.generateIncomingEntityRankingReport(hmIncomingEntityRank);
			} else {
				System.out.println("There are no incoming trades in the system!!!");
			}
			
			//Outgoing Entity Ranking Block
			if(hmMap.containsKey(TradeConstants.OUTGOING_ENTITY_RANK)) {
				hmOutgoingEntityRank = hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK);
				objRepGen.generateOutgoingEntityRankingReport(hmOutgoingEntityRank);
			} else {
				System.out.println("There are no outgoing trades in the system!!!");
			}
			
		} catch(ParseException dateFormatExcp) {
			System.out.println("Date format should be in dd/MM/yyyy format!!!!");
			dateFormatExcp.printStackTrace();
		}//End of catch block
	}//End of main method
}//End of TradeReportingMainApp class
