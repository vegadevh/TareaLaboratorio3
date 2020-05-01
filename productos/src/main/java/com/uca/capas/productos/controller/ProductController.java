package com.uca.capas.productos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.productos.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productsList = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProdcuto() {
		ModelAndView mav = new ModelAndView();
		
		productsList.add(new Product(0, "Minecraft", 30));
		productsList.add(new Product(1, "Minecraft Dungeons", 10));
		productsList.add(new Product(2, "Call of Duty", 25));
		productsList.add(new Product(3, "Cup Head", 33));
		productsList.add(new Product(4, "League of Lengends", 30));
		
		mav.setViewName("select");
		mav.addObject("product", new Product()); //Producto vacio
		mav.addObject("productList", productsList);
		
		return mav;
	}
	
	
	@PostMapping("/validar")
	public ModelAndView validar(HttpServletRequest request,Product product) {
		ModelAndView mav = new ModelAndView();
		String quantity = request.getParameter("quantity");
		
		if(Integer.parseInt(quantity)>productsList.get(product.getId()).getQuantity()) {
			mav.setViewName("error");
			mav.addObject("response", "El producto " + productsList.get(product.getId()).getName() + " no se puede adquirir.");
			
			return mav;
		}else {
			mav.setViewName("compra");
			mav.addObject("response", "El producto " + productsList.get(product.getId()).getName() + " se adquirió.");
			
			return mav;
		}
	}

}
