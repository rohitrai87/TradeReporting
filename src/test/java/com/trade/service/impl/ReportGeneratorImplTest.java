package com.trade.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ReportGeneratorImplTest {
	private ReportGeneratorImpl objRepGenImplTest;
	private Map<String, BigDecimal> hmIncomingStlmntAmnt;
	private Map<String, BigDecimal> hmOutgoingStlmntAmnt;
	private Map<String, BigDecimal> hmIncomingEntityRank;
	private Map<String, BigDecimal> hmOutgoingEntityRank;
	
	@Before
	public void before() {
		objRepGenImplTest = new ReportGeneratorImpl();
		hmIncomingStlmntAmnt = new HashMap<String, BigDecimal>();
		hmOutgoingStlmntAmnt = new HashMap<String, BigDecimal>();
		hmIncomingEntityRank = new HashMap<String, BigDecimal>();
		hmOutgoingEntityRank = new HashMap<String, BigDecimal>();
		
		hmIncomingStlmntAmnt.put("30/07/2018", BigDecimal.valueOf(435345.5));
		hmIncomingStlmntAmnt.put("29/07/2018", BigDecimal.valueOf(7636367.54));
		hmIncomingStlmntAmnt.put("31/07/2018", BigDecimal.valueOf(854968458.5));
		hmIncomingStlmntAmnt.put("28/07/2018", BigDecimal.valueOf(2376.5));
		
		hmOutgoingStlmntAmnt.put("30/07/2018", BigDecimal.valueOf(3423423.99));
		hmOutgoingStlmntAmnt.put("29/07/2018", BigDecimal.valueOf(35454.99));
		hmOutgoingStlmntAmnt.put("31/07/2018", BigDecimal.valueOf(234555.99));
		hmOutgoingStlmntAmnt.put("28/07/2018", BigDecimal.valueOf(9879665.99));
		
		hmIncomingEntityRank.put("foo", BigDecimal.valueOf(3423423432.56));
		hmIncomingEntityRank.put("bar", BigDecimal.valueOf(3423423432.55));
		hmIncomingEntityRank.put("moo", BigDecimal.valueOf(45345343.56767));
		hmIncomingEntityRank.put("noo", BigDecimal.valueOf(54645646456.45645));
		hmIncomingEntityRank.put("zoo", BigDecimal.valueOf(657657567565.6756));
		hmIncomingEntityRank.put("hoo", BigDecimal.valueOf(4234343545.60));
		
		hmOutgoingEntityRank.put("foo", BigDecimal.valueOf(213123.56));
		hmOutgoingEntityRank.put("bar", BigDecimal.valueOf(213123.57));
		hmOutgoingEntityRank.put("moo", BigDecimal.valueOf(7654322.56767));
		hmOutgoingEntityRank.put("noo", BigDecimal.valueOf(5464567.45645));
		hmOutgoingEntityRank.put("zoo", BigDecimal.valueOf(456587674.6756));
		hmOutgoingEntityRank.put("hoo", BigDecimal.valueOf(12132423.60));
		
	}//End of before method
	
	@Test
	public void testIncomingGenerateTradeSalesReport() {
		objRepGenImplTest.generateIncomingTradeSalesReport("28/07/2018", hmIncomingStlmntAmnt);
		objRepGenImplTest.generateIncomingTradeSalesReport("29/07/2018", hmIncomingStlmntAmnt);
		objRepGenImplTest.generateIncomingTradeSalesReport("30/07/2018", hmIncomingStlmntAmnt);
		objRepGenImplTest.generateIncomingTradeSalesReport("31/07/2018", hmIncomingStlmntAmnt);
		
	}//End of testIncomingGenerateTradeSalesReport method
	
	@Test
	public void testOutgoingGenerateTradeSalesReport() {
		objRepGenImplTest.generateOutgoingTradeSalesReport("28/07/2018", hmOutgoingStlmntAmnt);
		objRepGenImplTest.generateOutgoingTradeSalesReport("29/07/2018", hmOutgoingStlmntAmnt);
		objRepGenImplTest.generateOutgoingTradeSalesReport("30/07/2018", hmOutgoingStlmntAmnt);
		objRepGenImplTest.generateOutgoingTradeSalesReport("31/07/2018", hmOutgoingStlmntAmnt);
		
	}//End of testOutgoingGenerateTradeSalesReport method
	
	@Test
	public void testGenerateIncomingEntityRankingReport() {
		objRepGenImplTest.generateIncomingEntityRankingReport(hmIncomingEntityRank);
		
	}//End of testGenerateIncomingEntityRankingReport method
	
	@Test
	public void testGenerateOutgoingEntityRankingReport() {
		objRepGenImplTest.generateOutgoingEntityRankingReport(hmOutgoingEntityRank);
		
	}//End of testGenerateOutgoingEntityRankingReport method

}//End of ReportGeneratorImplTest class
