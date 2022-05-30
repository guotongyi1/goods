package com.goods.business.converter;


import com.goods.common.model.business.ProductCategory;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoTongYi
 * @createDate 2022/5/30 0:10
 */
public class ProductCategoryConverter {

    public static List<ProductCategoryTreeNodeVO> converterToProductCategoryTreeNodeVO(List<ProductCategory> productCategories)  {
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(productCategories)){
            for (ProductCategory productCategory : productCategories) {
                ProductCategoryTreeNodeVO productCategoryTreeNodeVO = new ProductCategoryTreeNodeVO();
                BeanUtils.copyProperties(productCategory,productCategoryTreeNodeVOS);

                productCategoryTreeNodeVOS.add(productCategoryTreeNodeVO);
            }
        }
        return  productCategoryTreeNodeVOS;
    }


}
