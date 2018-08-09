package com.trade.util;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.Date;
import org.junit.Test;
import com.trade.constants.TradeConstants;

public class TradeUtilityTest {
	private Date date;
	
	@Test
	public void testAddDays() throws ParseException {
		date = TradeUtility.addDays(TradeConstants.sdf.parse("29/07/2018"), 5);
		assertNotNull(date);
		assertEquals(date, TradeConstants.sdf.parse("03/08/2018"));
		assertTrue(TradeUtility.isValidFormat("29/07/2018"));
		assertTrue(!TradeUtility.isValidFormat("32/07/2018"));
		assertTrue(!TradeUtility.isValidFormat("29/13/2018"));
		assertTrue(!TradeUtility.isValidFormat("29/02/2018"));
		assertTrue(!TradeUtility.isValidFormat("29/07/2018 12:20:00"));
		
	}//End of testAddDays method
	
	@Test(expected = ParseException.class)
	public void handleEvent_ok() throws Throwable {
		assertTrue(!TradeUtility.isValidFormat("29072018"));
		fail("should have thrown excepton!!");
		assertTrue(!TradeUtility.isValidFormat("20180729"));
		fail("should have thrown excepton!!!!");
	}//End of handleEvent_ok method
	
}//End of TradeUtilityTest class
