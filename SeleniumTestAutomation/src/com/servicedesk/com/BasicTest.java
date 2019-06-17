package com.servicedesk.com;

import org.testng.*;
import org.testng.annotations.Test;

public class BasicTest extends Functionality1 {
	static String url="https://www.waynecounty.com";
@Test
	public static void test1() throws Exception {
		
  setUp("firefox");
	verifyUrl(url);
	electedOffices(url);
	tearDown();

	}

}
