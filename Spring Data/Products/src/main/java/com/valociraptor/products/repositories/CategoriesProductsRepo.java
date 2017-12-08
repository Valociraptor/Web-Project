package com.valociraptor.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.products.models.CategoriesProducts;

@Repository
public interface CategoriesProductsRepo extends CrudRepository<CategoriesProducts, Long> {

}
