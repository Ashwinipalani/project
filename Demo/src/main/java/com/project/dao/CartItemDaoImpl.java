package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
import com.project.model.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
			Session session=sessionFactory.openSession();
			   session.saveOrUpdate(cartItem);
			   session.flush();
			   session.close();	
			}
	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.flush();
		session.close();
		return cartItem;
		}

		public void removeCartItem(CartItem cartItem) {
		Session session=sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
		session.close();

		}

		public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems=cart.getCartItems();
		//JDK 1.5 feature - for each loop
		for(CartItem cartItem:cartItems){
		removeCartItem(cartItem);
		}
		}
		}
