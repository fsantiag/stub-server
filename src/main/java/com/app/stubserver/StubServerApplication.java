package com.app.stubserver;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Bean;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@SpringBootApplication
@AutoConfigureWireMock(stubs="classpath:/stubs")
public class StubServerApplication {

	@Bean
	public void stubUsingWiremockApi() {
		WireMock.stubFor(get(urlEqualTo("/resource"))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")
						.withBody("{\"id\": 1}")));
	}

	public static void main(String[] args) {
		SpringApplication.run(StubServerApplication.class, args);
	}

}
