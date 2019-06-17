package com.skg.basic;

import org.testng.annotations.Test;

public class BellevilleCompass extends Functionality1 {
	@Test
	public static void test3() throws Exception {
		String url="https://compass.waynecounty.com/";

	setUp("chrome");
	verifyUrl(url);
	testCompassSearch("10915 Belleville Road Belleville, MI 48111","Belleville");
	verifyCompassHomePage(url,"Belleville");
	//tearDown();



}
}
