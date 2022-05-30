package com.goods.business.service;

import com.goods.common.model.business.ProductCategory;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.business.ProductCategoryVO;
import com.goods.common.vo.system.PageVO;

import java.util.List;


public interface CategoriesService {




    PageVO<ProductCategoryTreeNodeVO> getCategoryTree();

    List<ProductCategoryTreeNodeVO> getParentCategoryTree();

    void addCategory(ProductCategory productCategory);

    ProductCategoryVO findCategoryById(Long id);

    void updateCategoryById(Long id, ProductCategory productCategory);
}
