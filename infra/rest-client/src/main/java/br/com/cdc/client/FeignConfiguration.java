package br.com.cdc.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@ComponentScan(basePackageClasses = FeignConfiguration.class)
public class FeignConfiguration {
}
