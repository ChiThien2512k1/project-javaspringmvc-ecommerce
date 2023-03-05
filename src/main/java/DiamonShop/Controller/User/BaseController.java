package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeServiceImpl;
	
	public ModelAndView _mvShare=  new ModelAndView();
	public ModelAndView Init() {
		_mvShare.addObject("menus",_homeServiceImpl.GetDataMenu());
		return _mvShare;
	}
	
	
}
