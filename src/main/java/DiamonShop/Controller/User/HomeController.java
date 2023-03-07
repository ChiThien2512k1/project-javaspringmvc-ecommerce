package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = {"/","/trang-chu"})
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeServiceImpl.GetDataSlide());
		_mvShare.addObject("categorys",_homeServiceImpl.GetDataCategorys());
		_mvShare.addObject("products",_homeServiceImpl.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
}