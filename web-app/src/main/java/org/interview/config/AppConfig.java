package org.interview.config;

import org.interview.knight.CsvReader;
import org.interview.knight.DayCoinPaymentProcessor;
import org.interview.knight.GoldPayment;
import org.interview.random.generator.RandomNumGenerator;
import org.interview.random.generator.impl.RandomNumGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

	@Bean
	public CsvReader createCvsReader(){
		return new CsvReader();
	}

	@Bean
	public GoldPayment createGoldPayment() {
		return new GoldPayment();
	}

	@Bean
	public DayCoinPaymentProcessor createDayCoinPaymentProcessor(CsvReader cvsReader, GoldPayment goldPayment){
		return new DayCoinPaymentProcessor(cvsReader, goldPayment);
	}
	@Bean
	public RandomNumGenerator createRandomNumGenerator() {
		int[] randomNums =      {-1, 0, 1, 2, 3};
		float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
		return new RandomNumGeneratorImpl(randomNums, probabilities);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("org.interview.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}
	  
	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Api registration")
				.description("Api registration for interview")
				.contact(new Contact("Ryan", "https://linkedin.com", "hamacha.ryan@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
}
