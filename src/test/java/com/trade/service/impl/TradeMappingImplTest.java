package com.trade.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.service.TradeMapping;

public class TradeMappingImplTest {
	//Object under testing
	private TradeMapping objTradeMap;
	private List<Trade> alTrades;
	private Map<String, Map<String, BigDecimal>> hmMap;
	
	@Mock
	private Trade objTrade;
	
	@Before
	public void before() throws ParseException {
		MockitoAnnotations.initMocks(this);
		objTradeMap = new TradeMappingImpl();
		alTrades = new ArrayList<Trade>();
		Date revStlmntDate = TradeConstants.sdf.parse("30/07/2018");
		
		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),800,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(800)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("foo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),1000,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(1000)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("bar", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),900,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(900)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("bar", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),1200,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(1200)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),2000,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2000)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),4500,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(4500)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("moo", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),2300,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2300)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("noo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),400,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(revStlmntDate);
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(400)));
		alTrades.add(objTrade);
	}//End of before method
	
	@Test
	public void getTradeMapTest() {
		hmMap = objTradeMap.getTradeMap(alTrades);
		assertNotNull(hmMap);
		assertTrue((hmMap.size() != 0));
		assertEquals(4, hmMap.size());
		assertEquals(1, hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).size());
		assertEquals(1, hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).size());
		assertEquals(4, hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).size());
		assertEquals(4, hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).size());
	}//End of getTradeMapTest method
	
}//End of TradeMappingImplTest class
