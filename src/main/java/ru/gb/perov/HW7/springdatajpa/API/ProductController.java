package ru.gb.perov.HW7.springdatajpa.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.perov.HW7.springdatajpa.Data.Product;
import ru.gb.perov.HW7.springdatajpa.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @PostMapping("/add")            // check only in Postman, for example... Not browser!!!
    public void addProduct(@RequestParam(name = "title") String title, @RequestParam(name = "cost") Double cost) {
        productService.addProduct(title, cost);
    }

    @DeleteMapping("delete/{id}")           // check only in Postman, for example... Not browser!!!
    public void deleteById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/min/{minParam}")
    public List<Product> findAllMin(@PathVariable Double minParam) {
        return productService.findAllMin(minParam);
    }

    @GetMapping("/max/{maxParam}")
    public List<Product> findAllMax(@PathVariable Double maxParam) {
        return productService.findAllMax(maxParam);
    }

    @GetMapping("/between")     //for example http://localhost:8180/products/between?minParam=35&maxParam=75
    public List<Product> findAllBetween(@RequestParam Double minParam, @RequestParam Double maxParam) {
        return productService.findAllBetween(minParam, maxParam);
    }
}
