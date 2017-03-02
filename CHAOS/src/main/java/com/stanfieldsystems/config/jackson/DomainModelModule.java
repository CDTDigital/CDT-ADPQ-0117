package com.stanfieldsystems.config.jackson;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.web.CategoryJsonMixin;
import com.stanfieldsystems.web.CustomerOrderJsonMixin;
import com.stanfieldsystems.web.OrderProductJsonMixin;
import com.stanfieldsystems.web.ProductJsonMixin;
import com.stanfieldsystems.web.StatusJsonMixin;
import com.stanfieldsystems.web.UserInfoJsonMixin;
import com.stanfieldsystems.web.UserRoleJsonMixin;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Category.class, CategoryJsonMixin.class);
        setMixInAnnotation(CustomerOrder.class, CustomerOrderJsonMixin.class);
        setMixInAnnotation(OrderProduct.class, OrderProductJsonMixin.class);
        setMixInAnnotation(Product.class, ProductJsonMixin.class);
        setMixInAnnotation(Status.class, StatusJsonMixin.class);
        setMixInAnnotation(UserInfo.class, UserInfoJsonMixin.class);
        setMixInAnnotation(UserRole.class, UserRoleJsonMixin.class);
    }
}
