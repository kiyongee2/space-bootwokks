package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity  //웹 보안기능 활성화
@Configuration  //스프링 Bean 인식(클래스로 등록)
public class SecurityConfig {
	
	private final CustomUserDetailsService userDeatailService;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDeatailService); //email 설정
		authProvider.setPasswordEncoder(encoder); //비밀번호 설정
		return authProvider;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/css/**", "/images/**",
							"/members/join", "/boards/pages").permitAll() //해당 경로 접근 허용
					//USER와 ADMIN 둘 모두 권한 허용
					.requestMatchers("/members/**", "/boards/**").hasAnyRole("USER", "ADMIN") 
					.requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN 권한 허용
					.anyRequest().authenticated() //나머지는 인증 필요
					
			)
			.formLogin(form -> form
				.loginPage("/members/login") //사용자 로그인 페이지 요청
				.loginProcessingUrl("/login") //로그인 POST 액션 URL
				.defaultSuccessUrl("/", true)
				.permitAll()
			)
			.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
			)
			.exceptionHandling(ex -> ex  //접근 권한 오류
					.accessDeniedPage("/access-denied"));
		
		return http.build();
	}//SecurityFilterChain 닫기
	
	//비밀번호 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//사용자 계정 생성
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("guest")
				.password(passwordEncoder().encode("g1234"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("a1234"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
}



