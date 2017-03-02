package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.Product;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.QProduct;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = ProductRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class ProductRepositoryImpl extends QueryDslRepositorySupportExt<Product> implements ProductRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    ProductRepositoryImpl() {
        super(Product.class);
    }

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String MSRP = "MSRP";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String CLIN = "CLIN";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String OEM___NAME = "OEM_name";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String PRICE = "price";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String QUANTITY = "quantity";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String OEM = "OEM";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String UNSPSC = "UNSPSC";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String UNIT_MEASURE = "unitMeasure";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String SKU = "SKU";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String NAME = "name";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String DISCOUNT = "discount";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QProduct product = QProduct.product;
        JPQLQuery<Product> query = from(product);
        Path<?>[] paths = new Path<?>[] { product.name, product.description, product.quantity, product.MSRP, product.price, product.discount, product.CLIN, product.OEM, product.OEM_name, product.SKU, product.unitMeasure, product.UNSPSC };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, product.name).map(DESCRIPTION, product.description).map(QUANTITY, product.quantity).map(MSRP, product.MSRP).map(PRICE, product.price).map(DISCOUNT, product.discount).map(CLIN, product.CLIN).map(OEM, product.OEM).map(OEM___NAME, product.OEM_name).map(SKU, product.SKU).map(UNIT_MEASURE, product.unitMeasure).map(UNSPSC, product.UNSPSC);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, product);
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
        QProduct product = QProduct.product;
        JPQLQuery<Product> query = from(product);
        Assert.notNull(category, "category is required");
        query.where(product.category.eq(category));
        Path<?>[] paths = new Path<?>[] { product.name, product.description, product.quantity, product.MSRP, product.price, product.discount, product.CLIN, product.OEM, product.OEM_name, product.SKU, product.unitMeasure, product.UNSPSC };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, product.name).map(DESCRIPTION, product.description).map(QUANTITY, product.quantity).map(MSRP, product.MSRP).map(PRICE, product.price).map(DISCOUNT, product.discount).map(CLIN, product.CLIN).map(OEM, product.OEM).map(OEM___NAME, product.OEM_name).map(SKU, product.SKU).map(UNIT_MEASURE, product.unitMeasure).map(UNSPSC, product.UNSPSC);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, product);
    }
}
