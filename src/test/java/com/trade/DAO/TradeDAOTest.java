package com.trade.DAO;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.trade.beans.Trade;

public class TradeDAOTest {
	private TradeDAO objTradeDAO;
	private List<Trade> alTradeList;
	
	@Before
	public void before() {
		objTradeDAO = new TradeDAO();
	}//End of before method
	
	@Test
	public void testGetTrades() throws ParseException {
		alTradeList = objTradeDAO.getTrades();
		assertNotNull(alTradeList);
		assertTrue(!alTradeList.isEmpty());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("foo")).count());
		assertEquals(5, alTradeList.stream().filter(event -> event.getStrEntity().equals("bar")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("zoo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("noo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("moo")).count());
		assertEquals(1, alTradeList.stream().filter(event -> event.getStrEntity().equals("boo")).count());
		assertEquals(2, alTradeList.stream().filter(event -> event.getStrEntity().equals("hoo")).count());
	}//End of testGetTrades method

}//End of TradeDAOTest class

