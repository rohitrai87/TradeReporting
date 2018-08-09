package com.trade.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import com.trade.beans.Trade;
import com.trade.constants.TradeConstants;
import com.trade.service.TradeMapping;

public class TradeMappingImplTest {
	//Object under testing
	private TradeMapping objTradeMap;
	private List<Trade> alTrades;
	private Map<String, Map<String, BigDecimal>> hmMap;
	private Trade objTrade;
	
	@Before
	public void before() throws ParseException {
		objTradeMap = new TradeMappingImpl();
		alTrades = new ArrayList<Trade>();
		
		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.23),"AED",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("27/07/2018"),800,BigDecimal.valueOf(100.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("29/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.23).multiply(BigDecimal.valueOf(100.25))).multiply(new BigDecimal(800)));
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "B",BigDecimal.valueOf(0.40),"SAR",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("28/07/2018"),800,BigDecimal.valueOf(140.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("29/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.40).multiply(BigDecimal.valueOf(140.25))).multiply(new BigDecimal(800)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("foo", "S",BigDecimal.valueOf(0.23),"AED",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("27/07/2018"),1000,BigDecimal.valueOf(100.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("29/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.23).multiply(BigDecimal.valueOf(100.25))).multiply(new BigDecimal(1000)));
		alTrades.add(objTrade);

		objTrade = new Trade("foo", "S",BigDecimal.valueOf(0.40),"SAR",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("28/07/2018"),1000,BigDecimal.valueOf(140.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("29/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.40).multiply(BigDecimal.valueOf(140.25))).multiply(new BigDecimal(1000)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("bar", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("29/07/2018"),900,BigDecimal.valueOf(70.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(70.25))).multiply(new BigDecimal(900)));
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "B",BigDecimal.valueOf(0.50),"GBP",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),900,BigDecimal.valueOf(80.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.50).multiply(BigDecimal.valueOf(80.25))).multiply(new BigDecimal(900)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("bar", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),1200,BigDecimal.valueOf(70.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(70.25))).multiply(new BigDecimal(1200)));
		alTrades.add(objTrade);

		objTrade = new Trade("bar", "S",BigDecimal.valueOf(0.50),"GBP",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("28/07/2018"),1200,BigDecimal.valueOf(80.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.50).multiply(BigDecimal.valueOf(80.25))).multiply(new BigDecimal(1200)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "B",BigDecimal.valueOf(0.65),"SGP",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),2000,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.65).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2000)));
		alTrades.add(objTrade);

		objTrade = new Trade("zoo", "B",BigDecimal.valueOf(0.65),"SGP",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("29/07/2018"),2000,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.65).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2000)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("zoo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("31/07/2018"),4500,BigDecimal.valueOf(70.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("31/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(70.25))).multiply(new BigDecimal(4500)));
		alTrades.add(objTrade);

		objTrade = new Trade("zoo", "S",BigDecimal.valueOf(0.50),"GBP",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),4500,BigDecimal.valueOf(80.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.50).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(4500)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("moo", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("31/07/2018"),2300,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("31/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2300)));
		alTrades.add(objTrade);

		objTrade = new Trade("moo", "B",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("28/07/2018"),2300,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(2300)));
		alTrades.add(objTrade);
		
		objTrade = new Trade("noo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("29/07/2018"),400,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(400)));
		alTrades.add(objTrade);

		objTrade = new Trade("noo", "S",BigDecimal.valueOf(0.30),"USD",TradeConstants.sdf.parse("28/07/2016"),TradeConstants.sdf.parse("30/07/2018"),400,BigDecimal.valueOf(60.25));
		objTrade.setRevStlmntDate(TradeConstants.sdf.parse("30/07/2018"));
		objTrade.setTrdAmount((BigDecimal.valueOf(0.30).multiply(BigDecimal.valueOf(60.25))).multiply(new BigDecimal(400)));
		alTrades.add(objTrade);
	}//End of before method
	
	@Test
	public void getTradeMapTest() throws ParseException {
		hmMap = objTradeMap.getTradeMap(alTrades);
		
		//Validating consolidates map
		assertNotNull(hmMap);
		assertTrue((hmMap.size() != 0));
		assertEquals(4, hmMap.size());
		
		//Validating incoming settlement map
		assertNotNull(hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT));
		assertTrue((hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).size() != 0));
		assertEquals(3, hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).size());
		assertEquals(new BigDecimal("79157.5000"), hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).get("29/07/2018"));
		assertEquals(new BigDecimal("223462.500"), hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).get("30/07/2018"));
		assertEquals(new BigDecimal("94837.500"), hmMap.get(TradeConstants.INCOMING_SETTLEMENT_AMNT).get("31/07/2018"));
		
		//Validating outgoing settlement map
		assertNotNull(hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT));
		assertTrue((hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).size() != 0));
		assertEquals(3, hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).size());
		assertEquals(new BigDecimal("63326.0000"), hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).get("29/07/2018"));
		assertEquals(new BigDecimal("253302.5000"), hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).get("30/07/2018"));
		assertEquals(new BigDecimal("41572.500"), hmMap.get(TradeConstants.OUTGOING_SETTLEMENT_AMNT).get("31/07/2018"));
		
		//Validating incoming entity rank map
		assertNotNull(hmMap.get(TradeConstants.INCOMING_ENTITY_RANK));
		assertTrue((hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).size() != 0));
		assertEquals(4, hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).size());
		assertEquals(new BigDecimal("79157.5000"), hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).get("foo"));
		assertEquals(new BigDecimal("73440.000"), hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).get("bar"));
		assertEquals(new BigDecimal("230400.000"), hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).get("zoo"));
		assertEquals(new BigDecimal("14460.000"), hmMap.get(TradeConstants.INCOMING_ENTITY_RANK).get("noo"));
		
		//Validating outgoing entity rank map
		assertNotNull(hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK));
		assertTrue((hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).size() != 0));
		assertEquals(4, hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).size());
		assertEquals(new BigDecimal("63326.0000"), hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).get("foo"));
		assertEquals(new BigDecimal("55080.000"), hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).get("bar"));
		assertEquals(new BigDecimal("156650.0000"), hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).get("zoo"));
		assertEquals(new BigDecimal("83145.000"), hmMap.get(TradeConstants.OUTGOING_ENTITY_RANK).get("moo"));
		
	}//End of getTradeMapTest method
	
}//End of TradeMappingImplTest class
