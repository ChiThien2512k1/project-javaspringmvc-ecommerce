package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProduct = productsDao.GetProductByID(id);
		return listProduct.get(0);
	}

	@Override
	public List<ProductsDto> GetProductByIDCategory(int id) {
		
		return productsDao.GetAllProductsByID(id);
	}
	

}
