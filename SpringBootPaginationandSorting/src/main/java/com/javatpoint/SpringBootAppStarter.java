package com.javatpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.dto.APIResponse;
import com.javatpoint.model.Product;
import com.javatpoint.service.ProductService;

@SpringBootApplication
@RestController
public class SpringBootAppStarter {

	@Autowired
	ProductService productService;

	@GetMapping("/product")
	private APIResponse<List<Product>> getproducts() {
		List<Product> products = productService.findAllProducts();
		return new APIResponse<List<Product>>(products.size(), products);
	}

	@GetMapping("/product/{field}")
	private APIResponse<List<Product>> findAllProductsWithSorting(@PathVariable String field) {
		List<Product> products = productService.findAllProductsWithSorting(field);
		return new APIResponse<List<Product>>(products.size(), products);
	}

	@GetMapping("/product/pagination/{offset}/{size}")
	private APIResponse<Page<Product>> findAllProductsWithPage(@PathVariable int offset, @PathVariable int size) {
		Page<Product> page = productService.findAllProductsWithPage(offset, size);
		return new APIResponse<Page<Product>>(page.getSize(), page);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppStarter.class, args);
	}

}
