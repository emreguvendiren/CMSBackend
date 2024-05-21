package com.CMSBackend.CMS.controller;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.Product;
import com.CMSBackend.CMS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public ResultDto getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/createProduct")
    public ResultDto createProduct(@RequestBody Product product,Long categoryId){
    	
        return productService.createProduct(product,categoryId);
    }
}
