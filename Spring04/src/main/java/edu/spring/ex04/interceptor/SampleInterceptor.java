package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(SampleInterceptor.class);

	// 지정된 콘트롤러 메소드가 실행되기 전에 요청(request)/응답(response)을
	// 가로채서 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("----- preHandle() 호출 -----");
		
		return super.preHandle(request, response, handler);
	}

	// 콘트롤러 메소드가 리턴한 이후에 View(JSP)에 모델 객체가 전달되기 전에 실행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("----- postHandle() 호출 -----");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	// View(JSP)가 호출되서 화면 처리까지 완료한 이후에 실행되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("----- afterCompletion() 호출 -----");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
	

} // end class SampleInterceptor
