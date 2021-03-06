package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.*;
import com.project.model.Cart;

@Service
public class CartServiceImpl implements CartService {
@Autowired
private CartDao cartDao;

	public Cart getCart(int cartId) {
		
		return cartDao.getCart(cartId);
	}

}
