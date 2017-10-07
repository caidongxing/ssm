package hr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hr.domain.User;
import hr.service.HrService;
import hr.util.common.HrmConstants;
import hr.util.tag.PageModel;
@Controller
public class UserController {
	@Autowired
	@Qualifier("hrService")
	
	private HrService hrService;
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,HttpSession session,
			ModelAndView mv){
		User user=hrService.login(loginname, password);
		if(user!=null){
			session.setAttribute(HrmConstants.USER_SESSION, user);
			mv.setViewName("redirect:/main");
		}
		else {
			mv.addObject("message","用户名或密码错误！请重新登录！");
			mv.setViewName("forward:loginForm");
		}
		return mv;
}
	//点击了用户查询这个按钮，执行这个
	@RequestMapping(value="/user/selectUser")
	public String selectUser(Integer pageIndex,
			@ModelAttribute User user,
			Model model){
		System.out.println("user"+user);
		PageModel pageModel=new PageModel();
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<User> users=hrService.findUser(user, pageModel);
		model.addAttribute("users", users);
		model.addAttribute("pageModel", pageModel);
		return "user/user";
	}
			
	
	@RequestMapping(value="/user/removeUser")
	public ModelAndView removeUser(String ids,ModelAndView mv){
		String []isdArray=ids.split(",");
		for (String string : isdArray) {
			hrService.removeUserById(Integer.parseInt(string));
		}
		mv.setViewName("redirect:/user/selectUser");
		return mv;
}
	
	@RequestMapping(value="/user/updateUser")
	public ModelAndView updateUser(
			String flag,
			@ModelAttribute User user,
			ModelAndView mv){
	//	String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
		if(flag.equals("1")){
			User target=hrService.findUserById(user.getId());
			mv.addObject("user", target);
			mv.setViewName("user/showUpdateUser");
		}
		else {
			hrService.modifyUser(user);
			mv.setViewName("redirect:/user/selectUser");
		}
		return mv;
	}
	//用户点击了添加用户这个按钮，跳转到user/showAddUser.jsp,在页面点击添加后，将把信息发送到addUser()
	//
	@RequestMapping(value="/user/addUser")
	public ModelAndView addUser(
			String flag,
			@ModelAttribute User user,
			ModelAndView mv){
		System.out.println("添加用户");
		if(flag.equals("1")){
			mv.setViewName("user/showAddUser");
		}
		else {
			System.out.println("用户添加，在Usercontroller.addUser");
			hrService.addUser(user);
			mv.setViewName("redirect:/user/selectUser");
		}
		return mv;
	}
	
	
	
	
	
	
	
}
