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
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.model.UserInfo;
import com.chaos.stanfield.model.UserRole;
import com.chaos.stanfield.utils.JPAInitEMF;

public class ProductTest {
	Product product;
	JPAInitEMF jpa;
	
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: ProductTest");
	}
	
	@Before
	public void setup(){
		product=new Product();
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
		
		jpa=new JPAInitEMF();
	}
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: ProductTest");
	}
	
	public Product addProduct(Product product){
		jpa.InsertEntity(product);
		return product;
	}
	
	public Product updateProduct(Product product){
		jpa.updateEntity(product);
		return product;
	}
	
	public void deleteProduct(Product product){
		jpa.deleteEntity(product);
	}
	
	public Product searchProductById(Long id){
		product=product.productById(id);
		return product;
	}
	
	public List<Product> listAllCategory(){
		List<Product> listProducts=new Product().allProducts();
		return listProducts;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addProductNull(){
		Product product=null;
		addProduct(product);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateProductNull(){
		Product product=null;
		updateProduct(product);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllProductNull(){
		Product newProduct=null;
		List<Product> listProduct= newProduct.allProducts();
		System.out.println(">>>>>"+listProduct.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchProductById(){
		Product newProduct;
		newProduct=searchProductById((long) 12323);
		System.out.println(newProduct.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void allProductByCategory(){
		Category category=null;
		List<Product> listProduct=product.productsByCategory(category.getName());
		assertEquals(0, listProduct.size());
	}
	
	@Test
	public void UserRoleOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		
		System.out.println("Insert");
		product=addProduct(product);
		
		System.out.println("Update");
		product.setName("Product Name UPDATED");
		product.setDescription("Product Description UPDATED");
		product=updateProduct(product);
		
		System.out.println("Query");
		product=searchProductById(product.getId());
				
		System.out.println("Show All > Size :" +listAllCategory().size());
		
		System.out.println("Delete Entity");
		deleteProduct(product);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}
