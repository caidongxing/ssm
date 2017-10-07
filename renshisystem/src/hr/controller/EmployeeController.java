package hr.controller;

import java.util.List;

import jdk.nashorn.internal.ir.Flags;
import hr.domain.Dept;
import hr.domain.Employee;
import hr.domain.Job;
import hr.service.HrService;
import hr.util.tag.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sun.org.apache.bcel.internal.generic.RETURN;

@Controller
public class EmployeeController {
	@Autowired
	@Qualifier("hrService")
	private HrService hrService;
	@RequestMapping(value="/employee/selectEmployee")
	public String selectEmployee(Integer pageIndex,
			Integer job_id,Integer dept_id,@ModelAttribute Employee employee,Model model){
		this.genericAssociation(job_id,dept_id,employee);
		PageModel pageModel=new PageModel();
		if (pageIndex!=null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Job> jobs=hrService.findAllJob();
		List<Dept> depts=hrService.findAllDept();
		List<Employee> employees=hrService.findEmployee(employee, pageModel);
		model.addAttribute("employees", employees);
		model.addAttribute("jobs", jobs);
		model.addAttribute("depts", depts);
		model.addAttribute("pageModel", pageModel);
		return "employee/employee";
	}
	
	private void genericAssociation(Integer job_id,Integer dept_id,Employee employee){
		if (job_id!=null) {
			Job job=new Job();
			job.setId(job_id);
			employee.setJob(job);;
		}if (dept_id!=null) {
			Dept dept=new Dept();
			dept.setId(dept_id);
			employee.setDept(dept);
		}
	}
	
	@RequestMapping(value="/employee/addEmployee")
	public ModelAndView addEmployee(
			@ModelAttribute Employee employee,
			ModelAndView mv,String flag,Integer job_id,Integer dept_id){
		
		if(flag.equals("1")){
			List<Job> jobs=hrService.findAllJob();
			List<Dept> depts=hrService.findAllDept();
			mv.addObject("jobs",jobs);
			mv.addObject("depts", depts);
			mv.setViewName("employee/showAddEmployee");
		}else {
			this.genericAssociation(job_id, dept_id, employee);
			hrService.addEmployee(employee);
			mv.setViewName("redirect:/employee/selectEmployee");
		}
		return mv;
	}
	@RequestMapping(value="/employee/removeEmployee")
	public ModelAndView removeEmployee(String ids,ModelAndView mv){
		String []idsArray=ids.split(",");
		for (String id : idsArray) {
			hrService.removeEmployee(Integer.parseInt(id));
		}
		mv.setView(new RedirectView("/hr/employy/selectEmployee"));
		mv.setViewName("redirect:/employee/selectEmployee");
		return mv;
	}
	
	@RequestMapping(value="/employee/updateEmployee")
	public ModelAndView updateEmployee(
			String flag,Integer job_id,Integer dept_id,@ModelAttribute Employee employee,
			ModelAndView mv	){
		System.out.println("1");
		if (flag.equals("1")) {
			System.out.println("2");
			Employee target=hrService.findEmployeeById(employee.getId());
			System.out.println("2");
			List<Job> jobs=hrService.findAllJob();
			System.out.println("3");
			List<Dept> depts=hrService.findAllDept();
			System.out.println("4");
			mv.addObject("jobs", jobs);
			mv.addObject("depts", depts);
			mv.addObject("employee", target);
			mv.setViewName("employee/showUpdateEmployee");
		}else {
			this.genericAssociation(job_id, dept_id, employee);
			System.out.println("upateEmployee ---->>>"+employee);
			hrService.modifyEmployee(employee);
			mv.setViewName("redirect:/employee/selectEmployee");
		}
		return mv;
	}
	
	
	
}
