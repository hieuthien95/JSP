/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CategoryService;
import service.ProductService;

/**
 *
 * @author hieut
 */

@Controller
public class HomepageController {
    
    @Autowired
    CategoryService categoryService = new CategoryService();
    @Autowired
    ProductService productService = new ProductService();
    
    @RequestMapping(value = "/index")
    public String index(ModelMap mm){
        mm.put("listCategory", categoryService.getAllCategory());
        mm.put("listProduct", productService.getAllProduct());
        return "pages/index";
    }
    
    @RequestMapping(value = "/login")
    public String login(ModelMap mm){
        return "pages/login";
    }
    
    @RequestMapping(value = "/register")
    public String register(ModelMap mm){
        return "pages/login";
    }
    
    @RequestMapping(value = "/update")
    public String update(ModelMap mm){
        return "pages/update-account";
    }
}
