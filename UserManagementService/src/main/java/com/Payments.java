package com;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Payments {
	
	private int transactionid;
	private int accountno;
	private String paymenttype;
	private String cardtype;
	private String amount;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid=transactionid;
		
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno=accountno;
	}
	public String getPaymenttype() {
		return paymenttype; 
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype=paymenttype;
	}
	public String getCardtype() {
		return cardtype; 
	}
	public void setCardtype(String cardtype) {
		this.cardtype=cardtype;
	}
	public String getAmount() {
		return amount; 
	}
	public void setAmount(String amount) {
		this.amount=amount;
	}
	public Payments(int transactionid, int accountno, String paymenttype, String cardtype, String amount   ) {
		super();
		this.transactionid=transactionid;
		this.accountno=accountno;
		this.paymenttype=paymenttype;
		this.cardtype=cardtype;
		this.amount=amount;
		
	}
	
	public Payments() {
		super();
	}
	
	
	
	
	

}
