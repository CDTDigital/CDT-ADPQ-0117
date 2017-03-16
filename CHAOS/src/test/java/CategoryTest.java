import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.stanfield.model.Category;
import com.chaos.stanfield.model.Product;
import com.chaos.stanfield.utils.JPAInitEMF;

@Transactional
public class CategoryTest {

	Category category;
	JPAInitEMF jpa;
	private final static Logger LOGGER = Logger.getLogger(CategoryTest.class.getName());
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("TEST BEGIN :: CategoryTest");
	}
	
	@Before
	public void setup(){
		category=new Category();
		category.setName("Category NAME");
		category.setDescription("Category Description");
		jpa=new JPAInitEMF();
	}
	
	@After
	public void clean(){

	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("TEST END :: CategoryTest");
	}
	
	public Category addCategory(Category category){
		jpa.InsertEntity(category);
		return category;
	}
	
	public Category updateCategory(Category category){
		jpa.updateEntity(category);
		return category;
	}
	
	public void deleteCategory(Category category){
		jpa.deleteEntity(category);
	}
	
	public Category searchCategoryById(Long id){
		category=category.categoryById(id);
		return category;
	}
	
	public List<Category> listAllCategory(){
		List<Category> listCategories=new Category().allCategories();
		return listCategories;
	}
	 
	@Test(expected=IllegalArgumentException.class) 
	public void addCategoryNull(){
		Category category=null;
		addCategory(category);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateCategoryNull(){
		Category category=null;
		updateCategory(category);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void showAllCategoryNull(){
		Category newcategory=null;
		List<Category> listCategories= newcategory.allCategories();
		System.out.println(">>>>>"+listCategories.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void searchCategoryById(){
		Category newCategory;
		newCategory=searchCategoryById((long) 12323);
		System.out.println(newCategory.getId());
	}
	
	@Test
	public void findAllProducts(){
		Set<Product> setProduct=category.getProducts();
		assertEquals(0, setProduct.size());
	}
	
	
	@Test
	public void CategoryOperations(){
		try{
		
		jpa.rollbackToBeginTEST();
		
		System.out.println("Insert");
		category=addCategory(category);
		
		System.out.println("Update");
		category.setName("Category Name UPDATED");
		category.setDescription("Category Description UPDATED");
		category=updateCategory(category);
		
		System.out.println("Query");
		category=searchCategoryById(category.getId());
				
		System.out.println("Show All > Size :" +listAllCategory().size());
		
		System.out.println("Delete Entity");
		deleteCategory(category);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
