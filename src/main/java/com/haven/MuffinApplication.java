package com.haven;

import com.haven.model.MutualFund;
import com.haven.repository.MutualFundRepository;
import com.haven.service.MutualFundService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.haven.repository")
public class MuffinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuffinApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(MutualFundRepository mutualFundRepository) {
//		return args -> {
////			List<MutualFund> mutualFundList =  mutualFundRepository.getAllFunds();
//			System.out.println(mutualFundList.size());
//		};
//	}

}
