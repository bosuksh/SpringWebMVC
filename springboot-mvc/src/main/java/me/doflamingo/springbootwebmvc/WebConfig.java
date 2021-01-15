package me.doflamingo.springbootwebmvc;

import me.doflamingo.springbootwebmvc.person.AnotherInterceptor;
import me.doflamingo.springbootwebmvc.person.GreetingInterceptor;
import me.doflamingo.springbootwebmvc.person.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public Jaxb2Marshaller jaxb2Marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan(Person.class.getPackageName());
    return marshaller;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new GreetingInterceptor()).order(1);
    registry.addInterceptor(new AnotherInterceptor())
      .order(0)
      .addPathPatterns("/hello/*");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/mobile/**")
      .addResourceLocations("classpath:/mobileResource/")
      .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES))
      .setCachePeriod(100)
      .resourceChain(true);

  }
}
