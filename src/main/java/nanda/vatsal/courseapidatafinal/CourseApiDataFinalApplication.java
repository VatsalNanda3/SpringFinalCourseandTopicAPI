package nanda.vatsal.courseapidatafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan("nanda.vatsal.topics")
//@ComponentScan("nanda.vatsal.courseapidatafinal")

@SpringBootApplication(scanBasePackages={
"nanda.vatsal.topics", "nanda.vatsal.courseapidatafinal","nanda.vatsal.course"})

public class CourseApiDataFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataFinalApplication.class, args);
	}

}
