import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.model.UserRole;
import com.chaos.stanfield.utils.JPAInitEMF;


public class UserRoleTest {
	UserRole userRole;
	JPAInitEMF jpa;
	
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: UserRoleTest");
	}
	
	@Before
	public void setup(){
		userRole=new UserRole();
		userRole.setName("UserRole NAME");
		userRole.setDescription("UserRole Description");
		jpa=new JPAInitEMF();
	}
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: UserRoleTest");
	}
	
	public UserRole addUserRole(UserRole userRole){
		jpa.InsertEntity(userRole);
		return userRole;
	}
	
	public UserRole updateUserRole(UserRole userRole){
		jpa.updateEntity(userRole);
		return userRole;
	}
	
	public void deleteUserRole(UserRole userRole){
		jpa.deleteEntity(userRole);
	}
	
	public UserRole searchUserRoleById(Long id){
		userRole=userRole.userRoleById(id);
		return userRole;
	}
	
	public List<UserRole> listAllCategory(){
		List<UserRole> listuserRoles=new UserRole().allUsersRoles();
		return listuserRoles;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addUserRoleNull(){
		UserRole userrole=null;
		addUserRole(userrole);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateUserRoleNull(){
		UserRole userRole=null;
		updateUserRole(userRole);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllUserRoleNull(){
		UserRole newUserRoles=null;
		List<UserRole> listUserRoles= newUserRoles.allUsersRoles();
		System.out.println(">>>>>"+listUserRoles.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchUserRoleById(){
		UserRole newUserRole;
		newUserRole=searchUserRoleById((long) 12323);
		System.out.println(newUserRole.getId());
	}
	
	@Test
	public void findAllUserInfoes(){
		Set<UserInfo> setUserInfoes=userRole.getUserInfos();
		assertEquals(0, setUserInfoes.size());
	}
	
	
	@Test
	public void UserRoleOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		
		System.out.println("Insert");
		userRole=addUserRole(userRole);
		
		System.out.println("Update");
		userRole.setName("UserRole Name UPDATED");
		userRole.setDescription("UserRole Description UPDATED");
		userRole=updateUserRole(userRole);
		
		System.out.println("Query");
		userRole=searchUserRoleById(userRole.getId());
				
		System.out.println("Show All > Size :" +listAllCategory().size());
		
		System.out.println("Delete Entity");
		deleteUserRole(userRole);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
}


}
