package hr.interceptor;

import hr.domain.User;
import hr.util.common.HrmConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class AuthorizedInterceptor implements HandlerInterceptor {
	private static final String[] INGORE_URI={"/loginForm","/login","/404.html"};
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mv) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		boolean flag=false;
		String servletPath=request.getServletPath();
		for (String s : INGORE_URI) {
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		if(!flag){
			User user=(User) request.getSession().getAttribute(HrmConstants.USER_SESSION);
			if(user==null){
				request.setAttribute("message", "请登录再访问网站");
				request.getRequestDispatcher(HrmConstants.LOGIN).forward(request, response);
				return flag;
			}else{
				flag=true;
			}
		}
		return flag;
	}

}
