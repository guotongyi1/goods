package com.goods.business.service.imp;

import com.github.pagehelper.PageInfo;
import com.goods.business.converter.ProductCategoryConverter;
import com.goods.business.mapper.CategoryMapper;
import com.goods.business.service.CategoriesService;
import com.goods.common.model.business.ProductCategory;
import com.goods.common.utils.CategoryTreeBuilder;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.business.ProductCategoryVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        List<ProductCategory> productCategorieList = categorie1Mapper.selectAll();

        // 转为 ProductCategoryTreeNodeVo
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS =
                ProductCategoryConverter.converterToProductCategoryTreeNodeVO(productCategorieList);

        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOSBuild =
                CategoryTreeBuilder.build(productCategoryTreeNodeVOS);

        PageInfo<ProductCategoryTreeNodeVO> info = new PageInfo<>(productCategoryTreeNodeVOSBuild);
        return new PageVO<>(info.getTotal(), productCategoryTreeNodeVOSBuild);
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

    /**
     * 添加分类数据
     * @param
     * @return
     */
    @Override
    public void addCategory(ProductCategory productCategory) {
        productCategory.setCreateTime(new Date());
        productCategory.setModifiedTime(new Date());
        categorie1Mapper.insert(productCategory);
    }

    /**
     * 回显修改数据
     * @param
     * @return
     */
    @Override
    public ProductCategoryVO findCategoryById(Long id) {
        ProductCategory productCategory = categorie1Mapper.selectByPrimaryKey(id);

        ProductCategoryVO productCategoryVO = new ProductCategoryVO();
        BeanUtils.copyProperties(productCategory,productCategory);

        return  productCategoryVO;

    }

    /**
     * 保存修改数据
     * @param
     * @return
     */
    @Override
    public void updateCategoryById(Long id, ProductCategory productCategory) {
        productCategory.setModifiedTime(new Date());
        categorie1Mapper.updateByPrimaryKeySelective(productCategory);

    }


}
