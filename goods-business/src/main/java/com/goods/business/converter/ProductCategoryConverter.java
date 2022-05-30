package com.goods.business.converter;

import com.goods.common.model.business.ProductCategory;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


public class ProductCategoryConverter {

    public static List<ProductCategoryTreeNodeVO> converterToProductCategoryTreeNodeVO(List<ProductCategory> productCategories){

        List<ProductCategoryTreeNodeVO> ProductCategoryTreeNodeVOS=new ArrayList<>();
        if(!CollectionUtils.isEmpty(productCategories)){
            for (ProductCategory productCategory : productCategories) {
                ProductCategoryTreeNodeVO productCategoryTreeNodeVO = new ProductCategoryTreeNodeVO();
                BeanUtils.copyProperties(productCategory,productCategoryTreeNodeVO);

                ProductCategoryTreeNodeVOS.add(productCategoryTreeNodeVO);
            }

        }
        return ProductCategoryTreeNodeVOS;
    }


}
