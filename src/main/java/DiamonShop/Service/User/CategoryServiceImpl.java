package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	ProductsDao productsDao;
	public List<ProductsDto> GetAllProductsByID(int id) {
		List<ProductsDto> products = productsDao.GetAllProductsByID(id);
		return products;
	}
	public List<ProductsDto> GetDataProductsPaginate(int id,int start, int totalPage) {
		List<ProductsDto> products = productsDao.GetDataProductsPaginates(id,start, totalPage);
		return products;
	}

	
	
}
