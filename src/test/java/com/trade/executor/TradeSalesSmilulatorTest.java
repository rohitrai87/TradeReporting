package com.trade.executor;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.trade.beans.Trade;

public class TradeSalesSmilulatorTest {
	private TradeSalesSimulator objTradeSalSim;
	private List<Trade> alTradeList;
	
	@Before
	public void before() throws ParseException {
		objTradeSalSim = new TradeSalesSimulator();
	}//End of before method
	
	@Test
	public void testGetTradeDetails() throws ParseException {
		alTradeList = objTradeSalSim.getTradeDetails();
		assertNotNull(alTradeList);
		assertTrue(!alTradeList.isEmpty());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("foo")).count());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("bar")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("zoo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("noo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("moo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("boo")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("hoo")).count());
	}//End of testGetTradeDetails method

}//End of TradeSalesSmilulatorTest class
