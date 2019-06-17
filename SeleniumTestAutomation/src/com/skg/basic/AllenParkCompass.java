package com.skg.basic;

import org.testng.annotations.Test;

public class AllenParkCompass extends Functionality1 {
	@Test
	public static void test2() throws Exception {
		String url="https://compass.waynecounty.com/";

	setUp("chrome");
	verifyUrl(url);
	testCompassSearch("15240 Southfield Rd, Allen Park, MI 48101","Allen Park");
	verifyCompassHomePage(url,"Allen Park");
	tearDown();



}
}
