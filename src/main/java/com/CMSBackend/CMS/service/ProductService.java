package com.CMSBackend.CMS.service;

import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.model.Product;
import com.CMSBackend.CMS.respository.CategoryRepository;
import com.CMSBackend.CMS.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ResultDto getAllProduct(){
        Iterable<Product> products = productRepository.findAll();
        if(products.iterator().hasNext()){
            return new ResultDto(products,200,"Success");
        }
        return new ResultDto(null,500,"Something went wrong...");
    }

    public ResultDto createProduct(Product product,Long categoryId) {
        if(product==null){
            return new ResultDto(null,400,"Please check all fields.");
        }
        try {
            Category category = categoryRepository.findById(categoryId).get();
            Product prod = new Product();
            prod.setName(product.getName());
            prod.setDescription(product.getDescription());
            prod.setPrice(product.getPrice());
            prod.setEnabled(true);
            prod.setCategory(category);
            prod.setImageUrl(product.getImageUrl());

            productRepository.save(prod);
            return new ResultDto(prod,200,"Success");
        }
        catch(Exception e){
            return new ResultDto(null,500,"Something went wrong");
        }
    }
}
