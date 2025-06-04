package springProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer{
	@Autowired
	InteceptorConfig inteceptorConfig;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		List<String> excludeList = new ArrayList<String>();
		// 로그인 하지 않도 사용할 수 있는 주소 추가
		excludeList.add("/help/**/*");
		excludeList.add("/login/**/*");
		excludeList.add("/static/**/*");
		excludeList.add("/register/**/*");
		excludeList.add("/mailling");
		excludeList.add("/lib*");
		excludeList.add("/realStock");
		registry.addInterceptor(inteceptorConfig)
				.addPathPatterns("/**/*")// 모두차단
				.excludePathPatterns(excludeList);// 허용할 주소
	}
}
