package com.goods.business.service.imp;

import com.github.pagehelper.PageInfo;
import com.goods.business.converter.ProductCategoryConverter;
import com.goods.business.mapper.CategoryMapper;
import com.goods.business.service.CategoriesService;
import com.goods.common.model.business.ProductCategory;
import com.goods.common.utils.CategoryTreeBuilder;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoryMapper categorie1Mapper;

    /**
     * 物资分类信息
     * @param
     * @return
     */
    @Override
    public PageVO<ProductCategoryTreeNodeVO> getCategoryTree() {
        List<ProductCategory> productCategoryList = categorie1Mapper.selectAll();
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS =
                ProductCategoryConverter.converterToProductCategoryTreeNodeVO(productCategoryList);
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOSBuild =
                CategoryTreeBuilder.build(productCategoryTreeNodeVOS);

        PageInfo<ProductCategoryTreeNodeVO> info = new PageInfo<>(productCategoryTreeNodeVOSBuild);

        return new PageVO<>(info.getTotal(),productCategoryTreeNodeVOSBuild);
    }

    /**
     * 回显父类数据
     * @param
     * @return
     */
    @Override
    public List<ProductCategoryTreeNodeVO> getParentCategoryTree() {
        List<ProductCategory> productCategoryList = categorie1Mapper.selectAll();


        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS =
                ProductCategoryConverter.converterToProductCategoryTreeNodeVO(productCategoryList);

        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOSBuild =
                CategoryTreeBuilder.build(productCategoryTreeNodeVOS);

        return productCategoryTreeNodeVOSBuild;
    }
}
