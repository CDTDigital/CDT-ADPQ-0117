// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems;

import com.stanfieldsystems.Product;

privileged aspect Product_Roo_ToString {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String Product.toString() {
        return "Product {" + 
                "name='" + name + '\'' + 
                ", description='" + description + '\'' + 
                ", quantity='" + quantity + '\'' + 
                ", MSRP='" + MSRP + '\'' + 
                ", price='" + price + '\'' + 
                ", discount='" + discount + '\'' + 
                ", CLIN='" + CLIN + '\'' + 
                ", OEM='" + OEM + '\'' + 
                ", OEM_name='" + OEM_name + '\'' + 
                ", SKU='" + SKU + '\'' + 
                ", unitMeasure='" + unitMeasure + '\'' + 
                ", UNSPSC='" + UNSPSC + '\'' + 
                ", id='" + id + '\'' + 
                ", version='" + version + '\'' + 
                ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + 
                ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }
    
}
