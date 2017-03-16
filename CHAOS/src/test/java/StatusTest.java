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
import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.utils.JPAInitEMF;

public class StatusTest {
	Status status;
	JPAInitEMF jpa;
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: StatusTest");
	}
	
	@Before
	public void setup(){
		status=new Status();
		status.setName("status NAME");
		status.setDescription("status Description");
		jpa=new JPAInitEMF();
	}
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: StatusTest");
	}
	
	public Status addStatus(Status status){
		jpa.InsertEntity(status);
		return status;
	}
	
	public Status updateStatus(Status status){
		jpa.updateEntity(status);
		return status;
	}
	
	public void deleteStatus(Status status){
		jpa.deleteEntity(status);
	}
	
	public Status searchStatusById(Long id){
		status=status.statusById(id);
		return status;
	}
	
	public List<Status> listAllStatus(){
		List<Status> liststatus=new Status().allStatus();
		return liststatus;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addStatusyNull(){
		Status status=null;
		addStatus(status);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateStatusNull(){
		Status status=null;
		updateStatus(status);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllStatusNull(){
		Status newstatus=null;
		List<Status> liststatus= newstatus.allStatus();
		System.out.println(">>>>>"+liststatus.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchStatusById(){
		Status newstatus;
		newstatus=searchStatusById((long) 12323);
		System.out.println(newstatus.getId());
	}
	
	@Test
	public void findAllCustomerOrder(){
		Set<CustomerOrder> setProduct=status.getCustomerOrders();
		assertEquals(0, setProduct.size());
	}
	
	
	@Test
	public void CategoryOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		
		System.out.println("Insert");
		status=addStatus(status);
		
		System.out.println("Update");
		status.setName("status Name UPDATED");
		status.setDescription("status Description UPDATED");
		status=updateStatus(status);
		
		System.out.println("Query");
		status=searchStatusById(status.getId());
				
		System.out.println("Show All > Size :" +listAllStatus().size());
		
		System.out.println("Delete Entity");
		deleteStatus(status);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
