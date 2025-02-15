package br.com.fiap.tech_challenge.product;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "html:target/reports/api.html"},
    glue = {"br.com.fiap.tech_challenge.product"}
)
@SpringBootTest(
    classes = ProductApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
public class CucumberTest { }
