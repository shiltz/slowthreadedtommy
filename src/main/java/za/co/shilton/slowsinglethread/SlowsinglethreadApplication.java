package za.co.shilton.slowsinglethread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.shilton"})
public class SlowsinglethreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowsinglethreadApplication.class, args);
	}

	@RestController
	@RequestMapping("/")
	public class HelloController {

		@GetMapping("/hello")
		public String getHello() throws InterruptedException {
			Thread.sleep(1000);
			return "Hello";
		}
	}


	@RestController
	@RequestMapping("/mono/")
	public class HelloFluxController {

		@GetMapping("/hello")
		public Mono<String> getHello() throws InterruptedException {
 				Thread.sleep(1000);

			return Mono.just("Hello");
		}
	}

}
