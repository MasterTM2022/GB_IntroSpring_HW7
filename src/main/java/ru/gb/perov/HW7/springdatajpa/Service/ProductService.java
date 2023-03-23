package ru.gb.perov.HW7.springdatajpa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.perov.HW7.springdatajpa.Data.Product;
import ru.gb.perov.HW7.springdatajpa.Repositiry.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProduct(String title, Double cost) {
        Product product = new Product();
        product.setProductName(title);
        product.setProductCost(cost);
        productRepository.saveAndFlush(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllMin(Double minParam) {
        return productRepository.findAllMin(minParam);
    }

    public List<Product> findAllMax(Double maxParam) {
        return productRepository.findAllMax(maxParam);
    }

    public List<Product> findAllBetween(Double minParam, Double maxParam){
        return productRepository.findAllBetween(Math.min(minParam, maxParam), Math.max(minParam, maxParam));
    }
}
