import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.Order;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chaos.stanfield.model.CustomerOrder;
import com.chaos.stanfield.model.OrderProduct;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.Status;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.utils.DateFormatConvertor;
import com.chaos.stanfield.utils.JPAInitEMF;

public class OrderProductTest {
	OrderProduct orderProduct;
	JPAInitEMF jpa;

	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: OrderProductTest");
	}
	
	@Before
	public void setup(){
		jpa=new JPAInitEMF();
		orderProduct=new OrderProduct();
		orderProduct.setPrice(new BigDecimal(45));
		orderProduct.setQuantity(new BigDecimal(4));
	}
	

	public Product newProduct(){
	
		Product product=new Product();
		product.setName("UserRole NAME");
		product.setDescription("UserRole Description");
		product.setCLIN("CLIN");
		product.setDiscount(new BigDecimal(123));
		product.setMSRP(new BigDecimal(123));
		product.setOEM("OEM");
		product.setOEM_NAME("oEM_NAME");
		product.setQuantity(new BigDecimal(789));
		product.setPrice(new BigDecimal(654));
		product.setDiscount(new BigDecimal(6));
		product.setSKU("SKU");
		product.setUnitMeasure("unitMeasure");
		product.setUNSPSC("UNSPSC");
		return product;
	}
	
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: CustomerOrderTest");
	}
	
	public OrderProduct addOrderProduct(OrderProduct orderProduct){
		jpa.InsertEntity(orderProduct);
		return orderProduct;
	}
	
	public OrderProduct updateOrderProduct(OrderProduct orderProduct){
		jpa.updateEntity(orderProduct);
		return orderProduct;
	}
	
	public void deleteOrderProduct(OrderProduct orderProduct){
		jpa.deleteEntity(orderProduct);
	}
	
	public OrderProduct searchOrderProductById(Long id){
		orderProduct=orderProduct.orderProductById(id);
		return orderProduct;
	}
	
	
	public List<OrderProduct> listAllOrderProduct(){
		List<OrderProduct> listOrderProduct=new OrderProduct().allOrderProducts();
		return listOrderProduct;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addOrderProductNull(){
		OrderProduct orderProduct=null;
		addOrderProduct(orderProduct);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateOrderProductNull(){
		OrderProduct orderProduct=null;
		updateOrderProduct(orderProduct);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllOrderProductNull(){
		OrderProduct orderProduct=null;
		List<OrderProduct> listorderProduct= orderProduct.allOrderProducts();
		System.out.println(">>>>>"+listorderProduct.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchOrderProductById(){
		OrderProduct orderProduct;
		orderProduct=searchOrderProductById((long) 12323);
		System.out.println(orderProduct.getId());
	}
	
	
	@Test
	public void orderProductOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		Product product=newProduct();
		jpa.InsertEntity(product);
		orderProduct.setProduct(product);
		System.out.println("Insert");
		orderProduct=addOrderProduct(orderProduct);
		
		System.out.println("Update");
		orderProduct.setPrice(new BigDecimal(789));
		orderProduct=updateOrderProduct(orderProduct);
		
		System.out.println("Query");
		orderProduct=searchOrderProductById(orderProduct.getId());
				
		System.out.println("Show All > Size :" +listAllOrderProduct().size());
		
		System.out.println("Delete Entity");
		deleteOrderProduct(orderProduct);
		
		product=orderProduct.getProduct();
		jpa.deleteEntity(product);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
}
	
	
	
}
