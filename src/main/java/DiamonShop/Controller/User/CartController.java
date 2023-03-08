package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.UsersEntity;
import DiamonShop.Service.User.BillsService;
import DiamonShop.Service.User.CartService;

@Controller
public class CartController extends BaseController{

	@Autowired
	private CartService cartService = new CartService();
	@Autowired
	private BillsService billsService = new BillsService();
	
	@RequestMapping(value = {"gio-hang"})
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeServiceImpl.GetDataSlide());
		_mvShare.addObject("categorys",_homeServiceImpl.GetDataCategorys());
		_mvShare.addObject("products",_homeServiceImpl.GetDataProducts());
		_mvShare.setViewName("user/cart/listcart");
		return _mvShare;
	}
	
	@RequestMapping(value = {"AddCart/{id}"})
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		
	}
	@RequestMapping(value = {"EditCart/{id}/{quantity}"})
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id,@PathVariable int  quantity) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Long, CartDto>();
		}
		
		
		cart = cartService.EditCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		
	}
	@RequestMapping(value = {"DeleteCart/{id}"})
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		
	}
	@RequestMapping(value = {"checkout"},method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		UsersEntity loginInfo = (UsersEntity)session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills",new Bills());
		return _mvShare;
		
	}
	@RequestMapping(value = {"checkout"},method = RequestMethod.POST)
	public String CheckOut(HttpServletRequest request,HttpSession session,@ModelAttribute("bills") Bills bills) {
		/*
		 * String quanty = (String) session.getAttribute("TotalQuantityCart"); String
		 * total = (String) session.getAttribute("TotalPriceCart");
		 */
		bills.setQuanty((int) session.getAttribute("TotalQuantityCart"));
		bills.setTotal((double) session.getAttribute("TotalPriceCart"));
		
		if(billsService.AddBills(bills) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:trang-chu";
		
	}
}
