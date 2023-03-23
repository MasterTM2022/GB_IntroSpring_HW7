package ru.gb.perov.HW7.springdatajpa.Service;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.perov.HW7.springdatajpa.Data.Product;
import ru.gb.perov.HW7.springdatajpa.Repositiry.ProductRepository;

@Component
public class ProductGenerator {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generatProductsOnStartUp() {
        Faker faker = new Faker();
        for (int i=1; i<= 20; i++) {
            Product p = new Product();

            p.setProductName(faker.food().ingredient());
            p.setProductCost(faker.number().randomDouble(2, 1, 100));

            productRepository.saveAndFlush(p);
        }
    }
}
