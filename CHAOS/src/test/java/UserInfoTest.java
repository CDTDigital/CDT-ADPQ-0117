import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.model.UserRole;
import com.chaos.stanfield.utils.JPAInitEMF;

public class UserInfoTest {
	UserInfo userInfo;
	JPAInitEMF jpa;
	
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: UserInfoTest");
	}
	
	@Before
	public void setup(){
		userInfo=new UserInfo();
		userInfo.setUsername("username");
		userInfo.setDisplayName("displayName");
		userInfo.setEmail("email");
		userInfo.setPassword("password");
		userInfo.setPhone("phone");
		userInfo.setAddress("address");
		jpa=new JPAInitEMF();
	}
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: UserInfoTest");
	}
	
	public UserInfo addUserInfo(UserInfo userInfo){
		jpa.InsertEntity(userInfo);
		return userInfo;
	}
	
	public UserInfo updateUserInfo(UserInfo userInfo){
		jpa.updateEntity(userInfo);
		return userInfo;
	}
	
	public void deleteUserInfo(UserInfo product){
		jpa.deleteEntity(product);
	}
	
	public UserInfo searcUserInfoById(Long id){
		userInfo=userInfo.userInfoById(id);
		return userInfo;
	}
	
	public List<UserInfo> listAllUserInfo(){
		List<UserInfo> listProducts=new UserInfo().allUserInfoes();
		return listProducts;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addUserInfoNull(){
		UserInfo product=null;
		addUserInfo(product);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateUserInfoNull(){
		UserInfo product=null;
		updateUserInfo(product);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllUserInfoNull(){
		UserInfo userInfo=null;
		List<UserInfo> listUserInfo= userInfo.allUserInfoes();
		System.out.println(">>>>>"+listUserInfo.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchUserInfoById(){
		UserInfo newProduct;
		newProduct=searcUserInfoById((long) 12323);
		System.out.println(newProduct.getId());
	}
	
	
	@Test
	public void findAllCustomerOrder(){
		Set<CustomerOrder> setProduct=userInfo.getCustomerOrders();
		assertEquals(0, setProduct.size());
	}
	
	
	@Test
	public void UserInfoOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		
		System.out.println("Insert");
		userInfo=addUserInfo(userInfo);
		
		System.out.println("Update");
		userInfo.setDisplayName("displayName UPDATED");
		userInfo.setEmail("email UPDATED");
		userInfo.setPassword("password UPDATED");
		userInfo=updateUserInfo(userInfo);
		
		System.out.println("Query");
		userInfo=searcUserInfoById(userInfo.getId());
				
		System.out.println("Show All > Size :" +listAllUserInfo().size());
		
		System.out.println("Delete Entity");
		deleteUserInfo(userInfo);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}
