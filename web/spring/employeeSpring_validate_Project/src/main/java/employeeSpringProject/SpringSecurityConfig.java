package employeeSpringProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	// security에 의한 로그인 화면을 사용하지 않게 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.formLogin().disable().csrf().disable().build();
	}
	// 암호객체 생성
	@Bean
	public PasswordEncoder  passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
}
