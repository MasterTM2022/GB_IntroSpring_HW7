package ru.gb.perov.HW7.springdatajpa.Repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.perov.HW7.springdatajpa.Data.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.productCost < :minParam")
    List<Product> findAllMin(@Param("minParam") Double minParam);

    @Query("select p from Product p where p.productCost > :maxParam")
    List<Product> findAllMax(@Param("maxParam") Double maxParam);

    @Query("select p from Product p where p.productCost between :minParam AND :maxParam")
    List<Product> findAllBetween(@Param("minParam") Double minParam, @Param("maxParam") Double maxParam);
}
