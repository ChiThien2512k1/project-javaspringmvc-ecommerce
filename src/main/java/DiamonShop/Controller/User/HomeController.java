package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;



@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = {"/","/trang-chu"})
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("user/index");
		mv.addObject("menus",_homeServiceImpl.GetDataMenu());
		mv.addObject("slides",_homeServiceImpl.GetDataSlide());
		mv.addObject("categorys",_homeServiceImpl.GetDataCategorys());
		
		return mv;
	}
	@RequestMapping(value = {"/product"})
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
		
}