package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CategorysDao;
import DiamonShop.Dao.SlidesDao;
import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.Slides;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slideDao;
	@Autowired
	private CategorysDao categorysDao;
	public List<Slides> GetDataSlide(){
		
		return slideDao.GetDataSlide();
	}
	public List<Categorys> GetDataCategorys() {
		
		return categorysDao.GetDataCategorys();
	}
	public List<Categorys> GetDataMenu() {
		
		return null;
	}
}
