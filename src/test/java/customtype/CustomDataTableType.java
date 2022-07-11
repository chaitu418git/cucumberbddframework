package customtype;

import java.util.Map;

import domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

public class CustomDataTableType {

	@DataTableType
	public BillingDetails billingDetailsEntry(Map<String,String> entry)
	{
		return new BillingDetails(entry.get("firstname"), 
				entry.get("lastname"), 
				entry.get("address_line1"), 
				entry.get("city"), 
				entry.get("state"), 
				entry.get("zip"), 
				entry.get("email"));
	}
}
