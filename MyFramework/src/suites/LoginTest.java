package suites;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import testBase.TestBase;
import testUtils.TestUtils;

@RunWith(Parameterized.class)
public class LoginTest extends TestBase {
	String username;
	String password;
	
	public LoginTest(String User,String pass){
		this.username=User;
		this.password=pass;
	}
	
	@BeforeClass
	public static void doInitial(){
		doInitialize();
		driver.get(pro.getProperty("Web.Url"));
	}
	
	@Before
	public void isSkip(){
		if(TestUtils.isSkip("Suites", "Fn_General_Login")){
			System.out.println(TestUtils.isSkip("Suites", "Fn_General_Login"));
			Assert.assertTrue(false);
		}
	}
	@Test
	public void doLogin(){
		TestUtils.doLogin(username, password);
	}
	@Parameters
	public static Collection<String[]> getData(){
		String data[][]=TestUtils.getData("Dt_General_Login");
		return Arrays.asList(data);
	}
}
