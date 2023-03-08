package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.UsersEntity;
import DiamonShop.Service.User.AccountService;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountService accountService = new AccountService();
	
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.GET)
	public ModelAndView DangKy() {
		_mvShare.addObject("slides",_homeServiceImpl.GetDataSlide());
		_mvShare.addObject("categorys",_homeServiceImpl.GetDataCategorys());
		_mvShare.addObject("products",_homeServiceImpl.GetDataProducts());
		_mvShare.addObject("user",new UsersEntity());
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") UsersEntity user) {
		int count = accountService.AddAccount(user);
		if(count > 0) {
			_mvShare.addObject("status","Đăng ký tài khoản thành công!");
		}else {
			_mvShare.addObject("status","Đăng ký tài khoản thất bại!");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	@RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") UsersEntity user) {
		
		user = accountService.CheckAccount(user);
		//boolean check = accountService.CheckAccount(user);
		if(user!=null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		}else {
			_mvShare.addObject("statusLogin","Đăng nhập thất bại!");
		}
		return _mvShare;
	}
	@RequestMapping(value = {"/dang-xuat"}, method = RequestMethod.GET)
	public String Login(HttpSession session,HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}
}
