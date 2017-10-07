package hr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import hr.domain.Notice;
import hr.domain.User;
import hr.service.HrService;
import hr.util.common.HrmConstants;
import hr.util.tag.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("hrService")
	private HrService hrService;
	@RequestMapping(value="notice/selectNotice")
	public String selectNotice(Model model,Integer pageIndex,
			@ModelAttribute Notice notice){
		PageModel pageModel=new PageModel();
		if (pageIndex!=null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Notice> notices=hrService.findNotice(notice, pageModel);
		model.addAttribute("notices", notices);
		model.addAttribute("pageModel", pageModel);
		return "notice/notice";
	}
	
	@RequestMapping(value="notice/addNotice")
	public ModelAndView addNotice(String flag,@ModelAttribute Notice notice,
			ModelAndView mv,HttpSession session){
		if (flag.equals("1")) {
			mv.setViewName("notice/showAddNotice");
		}else {
			User user=(User) session.getAttribute(HrmConstants.USER_SESSION);
			notice.setUser(user);
			hrService.addNotice(notice);
			mv.setViewName("redirect:/notice/selectNotice");
		}
		return mv;
	}
	@RequestMapping(value="notice/removeNotice")
	public ModelAndView removeNotice(String ids,ModelAndView mv){
		String idsArray[]=ids.split(",");
		for (String string : idsArray) {
			hrService.removeNoticeById(Integer.parseInt(string));
		}
		mv.setViewName("redirect:/notice/selectNotice");
		return mv;
	}
	@RequestMapping(value="notice/updateNotice")
	public ModelAndView updateNotice(String flag,@ModelAttribute Notice notice,
			ModelAndView mv,HttpSession session){
		if(flag.equals("1")){
			Notice target=hrService.findNoticeById(notice.getId());
			mv.addObject("notice", target);
			mv.setViewName("notice/showUpdateNotice");
		}else {
			hrService.modifyNotice(notice);
			mv.setViewName("redirect:/notice/selectNotice");
		}
		return mv;
	}
	@RequestMapping(value="notice/previewNotice")
	public String previewNotice(Integer id,Model model){
		Notice notice=hrService.findNoticeById(id);
		model.addAttribute("notice", notice);
		return "notice/previewNotice";
	}
	
}
