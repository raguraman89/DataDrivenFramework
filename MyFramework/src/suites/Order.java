package suites;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testUtils.TestUtils;

@RunWith(Parameterized.class)
public class Order {
	
	String product;
	String Quantity;
	String CustomerName;
	String Street;
	String City;
	String Zip;
	String CardNo;
	String ExpireDate;
	
	public Order(String product,String Quantity,String CustomerName,String Street,String City,String Zip,String CardNo,String ExpireDate){
		this.product=product;
		this.Quantity=Quantity;
		this.CustomerName=CustomerName;
		this.Street=Street;
		this.City=City;
		this.Zip=Zip;
		this.CardNo=CardNo;
		this.ExpireDate=ExpireDate;
		
	}
@Before
	public void isSkip(){
		if(TestUtils.isSkip("Suites", "Fn_Order_Proceed")){
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void order() throws InterruptedException{
		Thread.sleep(3000);
		TestUtils.getOrder(product, Quantity, CustomerName, Street, City, Zip, CardNo, ExpireDate);
		
	}
@Parameters
public static Collection<String[]>getorder(){
	String orders[][]=TestUtils.getData("Dt_Order_Proceed");
	return Arrays.asList(orders);
}
	
}
