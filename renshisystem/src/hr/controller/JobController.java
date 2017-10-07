package hr.controller;

import java.util.List;

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


@Controller
public class JobController {
	@Autowired
	@Qualifier("hrService")
	private HrService hrService;
	@RequestMapping(value="/job/selectJob")
	public String selectJob(Model model,Integer pageIndex,
			@ModelAttribute Job job){
		System.out.println("select job------>>>>"+job);
		PageModel pageModel=new PageModel();
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<Job> jobs=hrService.findJob(job, pageModel);
		model.addAttribute("jobs", jobs);
		model.addAttribute("pageModel", pageModel);
		return "job/job";
	}
	
	@RequestMapping(value="/job/removeJob")
	public ModelAndView removeJob(String ids,ModelAndView mv){
		String []idsArray=ids.split(",");
		for (String id : idsArray) {
			hrService.removeJobById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/job/selectJob");
		return mv;
	}
	
	@RequestMapping(value="/job/addJob")
	public ModelAndView addJob(String flag,@ModelAttribute Job job,ModelAndView mv){
		if(flag.equals("1")){
			mv.setViewName("job/showAddJob");
		}else {
			hrService.addJob(job);
			mv.setViewName("redirect:/job/selectJob");
		}
		return mv;
	}
	
	@RequestMapping(value="/job/updateJob")
	public ModelAndView updateJob(String flag,@ModelAttribute Job job,ModelAndView mv){
		if(flag.equals("1")){
			Job target=hrService.findJobById(job.getId());
			mv.addObject("job", target);
			mv.setViewName("job/showUpdateJob");
		}else {
			hrService.modifyJob(job);
			mv.setViewName("redirect:/job/selectJob");
		}
		return mv;
	}
	
}
