package pay;

import model.Payment;
import com.Payments;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;


//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 



@Path("/Payments") 
public class PaymentService 
{ 
	Payment payObj = new Payment(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readPayments() 
	{ 
		return payObj.readPayments(); 
	} 
	
	


	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertUser(@FormParam("accountno") int accountno, 
	 @FormParam("paymenttype") String paymenttype, 
	 @FormParam("cardtype") String cardtype, 
	 @FormParam("amount") String amount)
	
	{ 
		String output = payObj.insertPayment(accountno, paymenttype, cardtype, amount); 
	 	return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatePayment(String userData) 
	{ 
		 //Convert the input string to a JSON object 
		 JsonObject payObject = new JsonParser().parse(userData).getAsJsonObject(); 
		
		 //Read the values from the JSON object
		 String transactionid = payObject.get("transactionid").getAsString(); 
		 String accountno = payObject.get("accountno").getAsString(); 
		 String paymenttype = payObject.get("paymenttype").getAsString(); 
		 String cardtype = payObject.get("cardtype").getAsString(); 
		 String amount = payObject.get("amount").getAsString();
		 
		 String output = payObj.updatePayment(transactionid, accountno, paymenttype, cardtype, amount); 
		
		 return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletePayment(String userData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		 String transactionid = doc.select("transactionid").text(); 
		 String output = payObj.deletePayment(transactionid); 
		
		 return output; 
	}
	
	@GET
	@Path("/getpaymentbyid/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Payments getUsersById(@PathParam("id") int id) {

		return payObj.getPaymentById(id);
	}
	
	
	
	}
