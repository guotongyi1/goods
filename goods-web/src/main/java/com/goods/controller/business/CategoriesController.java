package com.goods.controller.business;

import com.goods.business.service.CategoriesService;
import com.goods.common.model.business.ProductCategory;
import com.goods.common.response.ResponseBean;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.business.ProductCategoryVO;
import com.goods.common.vo.system.PageVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author GuoTongYi
 * @createDate 2022/5/30 13:54
 */
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
    /**
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    public  ResponseBean  add(@RequestBody  ProductCategory productCategory){
       categoriesService.addCategory(productCategory);
       return ResponseBean.success();
    }

    @GetMapping("/edit/{id}")
    public ResponseBean findCategoryById(@PathVariable Long id){
        ProductCategoryVO productCategoryVO = categoriesService.findCategoryById(id);

        return ResponseBean.success();
    }

    @GetMapping("/update/{id}")
    public ResponseBean updateCategoryById(@PathVariable Long id,@RequestBody ProductCategory productCategory){
        categoriesService.updateCategoryById(id,productCategory);
        return ResponseBean.success();
    }
 }

