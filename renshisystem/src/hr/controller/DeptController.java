package hr.controller;

import java.util.List;

import hr.domain.Dept;
import hr.service.HrService;
import hr.util.tag.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeptController {
	@Autowired
	@Qualifier("hrService")
	private HrService hrService;
	@RequestMapping(value="dept/selectDept")
	public String selectDept(Model model,Integer pageIndex,
			@ModelAttribute Dept dept){
		System.out.println("select ---->>");
		System.out.println("pageIndex="+pageIndex);
		System.out.println("dept"+dept);
		PageModel pageModel=new PageModel();
		System.out.println("getPageIndex"+pageModel.getPageIndex());
		System.out.println("getPageSize"+pageModel.getPageSize());
		System.out.println("getRecordCount="+pageModel.getRecordCount());
		if(pageIndex !=null){
			pageModel.setPageIndex(pageIndex);

			
		}
		List<Dept> depts=hrService.findDept(dept, pageModel) ;
		model.addAttribute("depts",depts);
		model.addAttribute("pageModel", pageModel);
		return "dept/dept";
	}
	
	//删除部门
	@RequestMapping(value="dept/removeDept")
	public ModelAndView String(String ids,ModelAndView mv){
		String []idsArray=ids.split(",");
		for (String string : idsArray) {
			hrService.removeDeptById(Integer.parseInt(string));
		}
		mv.setViewName("redirect:/dept/selectDept");
		return mv;
	}
	@RequestMapping(value="/dept/addDept")
	public ModelAndView addDept(String flag,
			@ModelAttribute Dept dept,ModelAndView mv){
		//flag标记， 1表示跳转到添加页面，2表示执行添加操作
		if (flag.equals("1")) {
			mv.setViewName("dept/showAddDept");
		}else {
			hrService.addDept(dept);
			mv.setViewName("redirect:/dept/selectDept");
		}
		return mv;
	}
	@RequestMapping(value="/dept/updateDept")
	public ModelAndView updateDept(String flag,
			@ModelAttribute Dept dept,ModelAndView mv){
		//flag 标记，1表示跳转到修改页面，2表示执行修改
		if(flag.equals("1")){
			Dept target=hrService.finDeptById(dept.getId());
			mv.addObject("dept", target);
			mv.setViewName("dept/showUpdateDept");
		}else {
			hrService.modifyDept(dept);
			mv.setViewName("redirect:/dept/selectDept");
		}
		return mv;
	}
	
	
	
	
	
	
	
	
	
}
