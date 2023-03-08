package com.bytestrone.employeebytedesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.bytestrone.employeebytedesk.repository.UserRepo;

@Configuration
public class ApplicationConfig {
	private final UserRepo userRepo;

	public ApplicationConfig(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return userName -> userRepo.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

	}

}
