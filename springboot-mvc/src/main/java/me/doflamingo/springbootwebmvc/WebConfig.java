package me.doflamingo.springbootwebmvc;

import me.doflamingo.springbootwebmvc.event.VisitTimeInterceptor;
import me.doflamingo.springbootwebmvc.person.AnotherInterceptor;
import me.doflamingo.springbootwebmvc.person.GreetingInterceptor;
import me.doflamingo.springbootwebmvc.person.Person;
import org.apache.tika.Tika;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {


  @Bean
  public Jaxb2Marshaller jaxb2Marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan(Person.class.getPackageName());
    return marshaller;
  }

  @Bean
  public Tika tika() {
    return new Tika();
  }

  /**
   * GetMapping 없이 view와 viewController를 연결해주는 효과가 있다.
   * @param registry
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/hi").setViewName("index.html");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new GreetingInterceptor()).order(1);
    registry.addInterceptor(new AnotherInterceptor())
      .order(0)
      .addPathPatterns("/hello/*");
    registry.addInterceptor(new VisitTimeInterceptor());
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

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }
}
