package suites;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testUtils.TestUtils;

public class ViewProduct {

	
	@Before
	public void isSkip(){
		if(TestUtils.isSkip("Suites", "Fn_View_Product")){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void viewpoduct(){
		TestUtils.getTable();
	}
}
