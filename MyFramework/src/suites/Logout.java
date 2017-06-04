package suites;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testUtils.TestUtils;

public class Logout {

	@Before
	public void isSkip(){
		if(TestUtils.isSkip("Suites", "Fn_General_Logout")){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void doLogin(){
		TestUtils.doLogout();
	}
}
