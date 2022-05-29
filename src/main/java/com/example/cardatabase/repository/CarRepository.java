package com.example.cardatabase.repository;

import com.example.cardatabase.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "vehicles")
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByColor(String color);

    List<Car> findByYear(String year);

    @Query("select brand from Car")
    Iterable<Car> findAllBrands();

}
