package com.stanfieldsystems.service.impl;
import com.stanfieldsystems.service.api.ProductService;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.repository.ProductRepository;
import com.stanfieldsystems.service.api.OrderProductService;
import io.springlets.data.domain.GlobalSearch;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ProductServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private ProductRepository productRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productRepository
     * @param orderProductService
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, @Lazy OrderProductService orderProductService) {
        this.productRepository = productRepository;
        this.orderProductService = orderProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProductsToAdd
     * @return Product
     */
    @Transactional
    public Product addToOrderProducts(Product product, Iterable<Long> orderProductsToAdd) {
        List<OrderProduct> orderProducts = orderProductService.findAll(orderProductsToAdd);
        product.addToOrderProducts(orderProducts);
        return productRepository.save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProductsToRemove
     * @return Product
     */
    @Transactional
    public Product removeFromOrderProducts(Product product, Iterable<Long> orderProductsToRemove) {
        List<OrderProduct> orderProducts = orderProductService.findAll(orderProductsToRemove);
        product.removeFromOrderProducts(orderProducts);
        return productRepository.save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProducts
     * @return Product
     */
    @Transactional
    public Product setOrderProducts(Product product, Iterable<Long> orderProducts) {
        List<OrderProduct> items = orderProductService.findAll(orderProducts);
        Set<OrderProduct> currents = product.getOrderProducts();
        Set<OrderProduct> toRemove = new HashSet<OrderProduct>();
        for (Iterator<OrderProduct> iterator = currents.iterator(); iterator.hasNext(); ) {
            OrderProduct nextOrderProduct = iterator.next();
            if (items.contains(nextOrderProduct)) {
                items.remove(nextOrderProduct);
            } else {
                toRemove.add(nextOrderProduct);
            }
        }
        product.removeFromOrderProducts(toRemove);
        product.addToOrderProducts(items);
        return productRepository.save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    @Transactional
    public void delete(Product product) {
        // Clear bidirectional many-to-one child relationship with Category
        if (product.getCategory() != null) {
            product.getCategory().getProducts().remove(product);
        }
        // Clear bidirectional one-to-many parent relationship with OrderProduct
        for (OrderProduct item : product.getOrderProducts()) {
            item.setProduct(null);
        }
        productRepository.delete(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Product> save(Iterable<Product> entities) {
        return productRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Product> toDelete = productRepository.findAll(ids);
        productRepository.deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Product
     */
    @Transactional
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Product> findAll(Iterable<Long> ids) {
        return productRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return productRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return productRepository.findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable) {
        return productRepository.findByCategory(category, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return Long
     */
    public long countByCategory(Category category) {
        return productRepository.countByCategory(category);
    }
}
