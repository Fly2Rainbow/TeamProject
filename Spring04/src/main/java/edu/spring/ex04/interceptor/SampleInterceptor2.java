package edu.spring.ex04.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor2 extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(SampleInterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("----- preHandle() -----");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		log.info("bean: {}", handlerMethod.getBean());
		log.info("method: {}", method);
		log.info("method ret type: {}", method.getReturnType());
		log.info("method param type: {}", Arrays.toString(method.getParameterTypes()));
		log.info("method params type: {}", Arrays.toString(method.getParameters()));
		
		return true;
		//return false;
		// preHandle() 메소드의 리턴값:
		// 1) true: 콘트로러 메소드를 실행함
		// 2) false: 콘트롤러 메소드를 실행하지 않고, DispatcherServlet으로 돌아감
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		log.info("----- postHandle() -----");
		Map<String, Object> model = mav.getModel();
		Set<String> keys = model.keySet();
		for (String k : keys) {
			log.info("{} : {}", k, model.get(k));
		}
		
		super.postHandle(request, response, handler, mav);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("----- afterCompletion() -----");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
} // end class SampleInterceptor2
