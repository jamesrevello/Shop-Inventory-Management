package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PurchaseController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ProductRepository productrepository;

    @GetMapping("/buyproduct")
    public String buyProduct(@RequestParam("productID") long theId) {

        Optional<Product> opProduct = productrepository.findById(theId);
        if (opProduct.isPresent()){
            Product product1 = opProduct.get();
            if (product1.getInv() > 0) {
                product1.setInv(product1.getInv() - 1);
                productrepository.save(product1);
                return "/purchaseConfirm";
            }
        }
        return "/purchaseFailed";
            }
}
