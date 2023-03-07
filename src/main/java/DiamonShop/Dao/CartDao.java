package DiamonShop.Dao;

import java.util.HashMap;

import DiamonShop.Dto.CartDto;

public class CartDao extends BaseDao{
	
	
	public CartDto AddCart(long id, HashMap<Long,CartDto> cart) {
		CartDto itemCart = new CartDto();
		return itemCart;
	}
}
