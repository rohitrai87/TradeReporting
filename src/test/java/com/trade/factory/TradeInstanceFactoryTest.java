package com.trade.factory;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;
import org.junit.Test;
import com.trade.beans.Trade;

public class TradeInstanceFactoryTest {
	private List<Trade> alTrades;
	
	@Test
	public void testGetTradeInstance() throws ParseException {
		alTrades = TradeInstanceFactory.getTradeInstance();
		assertNotNull(alTrades);
		assertTrue(!alTrades.isEmpty());
		assertEquals(17, alTrades.size());	
	}//End of testGetTradeInstance method

}//End of TradeInstanceFactoryTest class 
