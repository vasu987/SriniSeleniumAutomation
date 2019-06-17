	

	
		
package com.servicedesk.com;

import org.testng.annotations.Test;

public class CreatingAndModifyingIncident extends MainServiceDesk{
	static String url="https://waynecounty-uat.saasit.com";
@Test
	public static void CreatingAndModifyingIncident() throws Exception {
	

 setUp("firefox");
//setUp("chrome");
//verifyUrl(url);
ValidateServiceDeskIncident();
tearDown();

	
}

}



