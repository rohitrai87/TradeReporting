package com.trade.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.service.TradeProcessor;

public class TradeProcessorImplTest {
	//Object under testing
	private TradeProcessor objTradeProc;
	
	@Mock
	private Trade objTrade1;
	private Trade objTrade2;
	private Trade objTrade3;
	private Trade objTrade4;
	private Trade objTrade5;
	private Trade objTrade6;
	private Trade objTrade7;
	private Trade objTrade8;
	private Trade objTrade9;
	private Trade objTrade10;
	private Trade objTrade11;
	private Trade objTrade12;
	private SimpleDateFormat dateFormat;
	
	@Before
	public void before() throws ParseException {
		MockitoAnnotations.initMocks(this);
		objTradeProc = new TradeProcessorImpl();
		objTrade1 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"AED",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("27/07/2018"),2000,BigDecimal.valueOf(100.25));
		objTrade2 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"AED",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("28/07/2018"),3000,BigDecimal.valueOf(100.25));
		objTrade3 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"AED",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("29/07/2018"),3000,BigDecimal.valueOf(100.25));
		objTrade4 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"SAR",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("27/07/2018"),2000,BigDecimal.valueOf(140.25));
		objTrade5 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"SAR",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("28/07/2018"),2000,BigDecimal.valueOf(140.25));
		objTrade6 = new Trade("foo", "B",BigDecimal.valueOf(0.23),"SAR",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("29/07/2018"),2000,BigDecimal.valueOf(140.25));
		objTrade7 = new Trade("foo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("28/07/2018"),1000,BigDecimal.valueOf(100.25));
		objTrade8 = new Trade("foo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("29/07/2018"),1500,BigDecimal.valueOf(100.25));
		objTrade9 = new Trade("foo", "B",BigDecimal.valueOf(0.50),"SGP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("30/07/2018"),1500,BigDecimal.valueOf(100.25));
		objTrade10 = new Trade("foo", "B",BigDecimal.valueOf(1.70),"GBP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("28/07/2018"),2000,BigDecimal.valueOf(90.5));
		objTrade11 = new Trade("foo", "B",BigDecimal.valueOf(1.70),"GBP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("29/07/2018"),2000,BigDecimal.valueOf(90.5));
		objTrade12 = new Trade("foo", "B",BigDecimal.valueOf(1.70),"GBP",TradeConstants.sdf.parse("26/07/2016"),TradeConstants.sdf.parse("30/07/2018"),2000,BigDecimal.valueOf(90.5));
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}//End of before method
	
	@Test
	public void testProcessTrade() throws ParseException {
		objTrade1 = objTradeProc.processTrade(objTrade1);
		assertNotNull(objTrade1);
		assertTrue((objTrade1.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade2 = objTradeProc.processTrade(objTrade2);
		assertNotNull(objTrade2);
		assertTrue((objTrade2.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade3 = objTradeProc.processTrade(objTrade3);
		assertNotNull(objTrade3);
		assertTrue((objTrade3.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade4 = objTradeProc.processTrade(objTrade4);
		assertNotNull(objTrade4);
		assertTrue((objTrade4.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade5 = objTradeProc.processTrade(objTrade5);
		assertNotNull(objTrade5);
		assertTrue((objTrade5.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade6 = objTradeProc.processTrade(objTrade6);
		assertNotNull(objTrade6);
		assertTrue((objTrade6.getRevStlmntDate()).equals(dateFormat.parse("29/07/2018")));
		
		objTrade7 = objTradeProc.processTrade(objTrade7);
		assertNotNull(objTrade7);
		assertTrue((objTrade7.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
		
		objTrade8 = objTradeProc.processTrade(objTrade8);
		assertNotNull(objTrade8);
		assertTrue((objTrade8.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
		
		objTrade9 = objTradeProc.processTrade(objTrade9);
		assertNotNull(objTrade9);
		assertTrue((objTrade9.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
		
		objTrade10 = objTradeProc.processTrade(objTrade10);
		assertNotNull(objTrade10);
		assertTrue((objTrade10.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
		
		objTrade11 = objTradeProc.processTrade(objTrade11);
		assertNotNull(objTrade11);
		assertTrue((objTrade11.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
		
		objTrade12 = objTradeProc.processTrade(objTrade12);
		assertNotNull(objTrade12);
		assertTrue((objTrade12.getRevStlmntDate()).equals(dateFormat.parse("30/07/2018")));
	}//End of testProcessTrade method
	
}//End of TradeProcessorImplTest class
