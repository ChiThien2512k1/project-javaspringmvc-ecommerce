package DiamonShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;
@Repository
public class CartDao extends BaseDao{
	
	ProductsDao productsDao = new ProductsDao();
	public HashMap<Long,CartDto> AddCart(long id, HashMap<Long,CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsDao.FindProductByID(id);
		if(product!=null) {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long,CartDto> EditCart(long id,int quantity,HashMap<Long,CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if(cart.containsKey(id)){
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity*itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long,CartDto> DeleteCart(long id,HashMap<Long,CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	public int TotalQuanty(HashMap<Long,CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	public double TotalPrice(HashMap<Long,CartDto> cart) {
		double totalPrice = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
