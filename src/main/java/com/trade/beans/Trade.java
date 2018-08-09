/**
 *
 * File Name             :Trade.java
 *
 * Package Name          :com.trade.beans
 *
 * Class Name            :Trade.java
 *
 * Class Type            :Public
 *
 * Description           :This is the Trade Java Bean class
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

package com.trade.beans;

import java.util.Date;
import java.math.BigDecimal;

/**
 * This class is to represent Trades
 */
public class Trade {
	public Trade(String strEntity, String strFlag, BigDecimal bdFxRate, String strCurr, Date instrDate, Date origStlmntDate, long lUnits, BigDecimal bdPrcPerUnit) {
		this.strEntity = strEntity;
		this.strFlag = strFlag;
		this.bdFxRate = bdFxRate;
		this.strCurr = strCurr;
		this.instrDate = instrDate;
		this.origStlmntDate = origStlmntDate;
		this.lUnits = lUnits;
		this.bdPrcPerUnit = bdPrcPerUnit;
	}
	
	private String strEntity;
	private String strFlag;
	private String strCurr;
	private Date instrDate;
	private Date origStlmntDate;
	private Date revStlmntDate;
	private long lUnits;
	private BigDecimal bdFxRate;
	private BigDecimal bdPrcPerUnit;
	private BigDecimal bdTrdAmnt;
	
	public String getStrEntity() {
		return strEntity;
	}
	
	public String getStrFlag() {
		return strFlag;
	}
	
	public BigDecimal getFxRate() {
		return bdFxRate;
	}
	
	public String getStrCurr() {
		return strCurr;
	}
	
	public Date getInstrDate() {
		return instrDate;
	}
	
	public void setRevStlmntDate(Date revStlmntDate) {
		this.revStlmntDate = revStlmntDate;
	}
	
	public Date getRevStlmntDate() {
		return revStlmntDate;
	}
	
	public Date getOrigStlmntDate() {
		return origStlmntDate;
	}
	
	public long getUnits() {
		return lUnits;
	}
	
	public BigDecimal getPricePerUnit() {
		return bdPrcPerUnit;
	}
	
	public void setTrdAmount(BigDecimal bdAmnt) {
		this.bdTrdAmnt = bdAmnt;
	}
	
	public BigDecimal getTrdAmount() {
		return bdTrdAmnt;
	}
	
	@Override
    public String toString() {
        return "Trade {" +
                "Entity = '" + strEntity +
                ", Flag = " + strFlag +
                ", Currency = " + strCurr +
                ", Instruction Date = " + instrDate +
                ", Settlement Date = " + origStlmntDate +
                ", Revised Settlement Date = " + revStlmntDate +
                ", Units = " + lUnits +
                ", fX Rate = " + bdFxRate +
                ", Price Per Unit = " + bdPrcPerUnit +
                ", Total Amount = " + bdTrdAmnt +
                '}';
    }//End of toString method
    
}//End of Trade class
