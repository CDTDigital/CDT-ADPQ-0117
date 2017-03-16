import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.utils.DateFormatConvertor;
import com.chaos.stanfield.utils.JPAInitEMF;

public class CustomerOrderTest {
	CustomerOrder customerOrder;
	JPAInitEMF jpa;
	Status status;
	UserInfo userInfo;
	
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: CustomerOrderTest");
	}
	
	@Before
	public void setup(){
		jpa=new JPAInitEMF();
		customerOrder=new CustomerOrder();
		customerOrder.setTotalPrice(new BigDecimal(45678));
		DateFormatConvertor dfc=new DateFormatConvertor();
		customerOrder.setUserInfo(userInfo);
		customerOrder.setOrderDate(dfc.getTodaysDate());
		
	}
	
	public Status newStatus()
	{
		status=new Status();
		status.setName("name");
		status.setDescription("description");
		jpa.InsertEntity(status);
		return status;
	}
	
	public UserInfo newUserInfo(){
		userInfo=new UserInfo();
		userInfo.setUsername("username");
		userInfo.setDisplayName("displayName");
		userInfo.setEmail("email");
		userInfo.setPassword("password");
		userInfo.setPhone("phone");
		userInfo.setAddress("address");
		jpa.InsertEntity(userInfo);
		return userInfo;
	}
	
	
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: CustomerOrderTest");
	}
	
	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder){
		jpa.InsertEntity(customerOrder);
		return customerOrder;
	}
	
	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder){
		jpa.updateEntity(customerOrder);
		return customerOrder;
	}
	
	public void deleteCustomerOrder(CustomerOrder customerOrder){
		jpa.deleteEntity(customerOrder);
	}
	
	public CustomerOrder searchCustomerOrderById(Long id){
		customerOrder=customerOrder.customerOrderById(id);
		return customerOrder;
	}
	
	
	public List<CustomerOrder> listAllCustomerOrder(){
		List<CustomerOrder> listcustomerOrder=new CustomerOrder().allCustomerOrders();
		return listcustomerOrder;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addCustomerOrderNull(){
		CustomerOrder customerOrder=null;
		addCustomerOrder(customerOrder);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateCustomerOrderNull(){
		CustomerOrder customerOrder=null;
		updateCustomerOrder(customerOrder);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllCustomerOrderNull(){
		CustomerOrder customerOrder=null;
		List<CustomerOrder> listcustomerOrder= customerOrder.allCustomerOrders();
		System.out.println(">>>>>"+listcustomerOrder.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchCustomerOrderById(){
		CustomerOrder customerOrder;
		customerOrder=searchCustomerOrderById((long) 12323);
		System.out.println(customerOrder.getId());
	}
	
	@Test
	public void allCustomerOrderByUserName(){
		String username="user";
		List<CustomerOrder> listCustomerOrder=customerOrder.customerOrderByUsername(username);
		assertEquals(0, listCustomerOrder.size());
	}
	
	
	
	@Test
	public void UserRoleOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		status=newStatus();
		customerOrder.setStatus(status);
		customerOrder.setUserInfo(newUserInfo());
		
		System.out.println("Insert");
		customerOrder=addCustomerOrder(customerOrder);
		
		System.out.println("Update");
		customerOrder.setTotalPrice(new BigDecimal(4568));
		customerOrder=updateCustomerOrder(customerOrder);
		
		System.out.println("Query");
		customerOrder=searchCustomerOrderById(customerOrder.getId());
				
		System.out.println("Show All > Size :" +listAllCustomerOrder().size());
		
		System.out.println("Delete Entity");
		
		deleteCustomerOrder(customerOrder);
		status=customerOrder.getStatus();
		userInfo=customerOrder.getUserInfo();
		jpa.deleteEntity(status);
		jpa.deleteEntity(userInfo);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
}
	
	
}
