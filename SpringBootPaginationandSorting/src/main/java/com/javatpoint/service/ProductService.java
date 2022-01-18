package com.javatpoint.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Product;
import com.javatpoint.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Product(i, "product " + i, new Random().nextInt(100), new Random().nextInt(50000)))
				.collect(Collectors.toList());
		productRepo.saveAll(products);
	}

	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	public List<Product> findAllProductsWithSorting(String field) {
		return productRepo.findAll(Sort.by(field));
	}

	public Page<Product> findAllProductsWithPage(int offset, int pagesize) {
		Page<Product> page = productRepo.findAll(PageRequest.of(offset, pagesize));
		return page;
	}
}
