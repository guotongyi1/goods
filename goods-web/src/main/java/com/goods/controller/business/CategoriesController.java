package com.goods.controller.business;

import com.goods.business.service.CategoriesService;
import com.goods.common.response.ResponseBean;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.system.PageVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "物资类别接口")
@RequestMapping("/business/productCategory")
@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;


    @GetMapping("/categoryTree")
    public ResponseBean<Map<String,Object>> getCategoryTree() {
        PageVO<ProductCategoryTreeNodeVO>  productCategoryTreeNodeVOPageVOS = categoriesService.getCategoryTree();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",productCategoryTreeNodeVOPageVOS.getRows());
        map.put("total",productCategoryTreeNodeVOPageVOS.getTotal());
        return  ResponseBean.success(map);
    }
    @GetMapping("/getParentCategoryTree")
    public ResponseBean<List<ProductCategoryTreeNodeVO>>  getParentCategoryTree(){
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOList = categoriesService.getParentCategoryTree();
        return  ResponseBean.success(productCategoryTreeNodeVOList);
    }
 }

