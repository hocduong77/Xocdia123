package org.baeldung.spring;

import java.util.Locale;

import org.baeldung.hashing.HashGenerator;
import org.baeldung.validation.service.EmailValidator;
import org.baeldung.validation.service.FileValidator;
import org.baeldung.validation.service.PasswordMatchesValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = { "org.baeldung.web.controller", "org.baeldung.persistence.service", "org.baeldung.persistence.dao" })
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    public MvcConfig() {
        super();
    }

    // API

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {  	
        super.addViewControllers(registry);     
        registry.addViewController("resetjax.html");
        registry.addViewController("admin-Reset-Server.html");
        registry.addViewController("checktt.html");
        registry.addViewController("admin-huong-dan-nap-xu.html");
        registry.addViewController("huyxudarut.html");
        registry.addViewController("adminhuongdan.html");
        registry.addViewController("forgetpage.html");
        registry.addViewController("roiphong.html");
        registry.addViewController("rutxu.html");
        registry.addViewController("admin-huong-dan-choi-game.html");
        registry.addViewController("ql-hoa-hong.html");
        registry.addViewController("ql-thoi-gian-dem-nguoc.html");
        registry.addViewController("quan-ly-ty-le-cuoc.html");
        registry.addViewController("setstatus.html");
        registry.addViewController("/dat-lenh-rut-tien/rutxuajax.html");
        registry.addViewController("/dat-lenh-rut-tien.html");
        registry.addViewController("/list-thanh-vien-rut-tien.html");
        registry.addViewController("/napxuajax.html");
        registry.addViewController("/timkiem.html");
        registry.addViewController("/napxu.html");
        registry.addViewController("/broweroffnc.html");
        registry.addViewController("/broweroff.html");
        registry.addViewController("/isbancua.html");
        registry.addViewController("/bancua.html");
        registry.addViewController("/phongcho.html");
        registry.addViewController("/isclose.html");
        registry.addViewController("/xunhacaiload.html");
        registry.addViewController("/settime.html");
        registry.addViewController("/getnumber.html");
        registry.addViewController("/gettime.html");
        registry.addViewController("/nhacaiload.html");
        registry.addViewController("/nha-cai.html");
        registry.addViewController("/ajaxhuy.html");
        registry.addViewController("/ajaxxu.html");
        registry.addViewController("/ajaxtestth.html");
        registry.addViewController("/ajaxtest.html");
        registry.addViewController("/tao-phong.html");
        registry.addViewController("/phong.html");
        registry.addViewController("/dang-ky.html");
        registry.addViewController("/ban-choi.html");
        registry.addViewController("/noi-quy.html");
        registry.addViewController("/thong-tin-thanh-vien.html");
        registry.addViewController("/huong-dan-choi-game.html");
        registry.addViewController("/changepass.html");
        registry.addViewController("/forgetpasschange.html");
        registry.addViewController("/forgetpass.html");
        registry.addViewController("/dang-ky.html");
        registry.addViewController("/index.html");
        registry.addViewController("/login.html");
        registry.addViewController("/logout.html");
        registry.addViewController("/homepage.html");
        registry.addViewController("/expiredAccount.html");
        registry.addViewController("/regitrationConfirm.html");
        registry.addViewController("/badUser.html");
        registry.addViewController("/emailError.html");
        registry.addViewController("/home.html");
        registry.addViewController("/invalidSession.html");
        registry.addViewController("/console.html");
        registry.addViewController("/admin.html");
        registry.addViewController("/registration.html");
        registry.addViewController("/successRegister.html");
    }

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/mytheme/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
    
   
    	
    	
    	 @Bean
    	    public FileValidator fileValidator() {
    		 FileValidator file = new FileValidator();
    	        
    	        return file;
    	    }
    	 
    	 @Bean
 	    public CommonsMultipartResolver multipartResolver() {
    		 CommonsMultipartResolver mul = new CommonsMultipartResolver();
 	        
 	        return mul;
 	    } 
    	 
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        return cookieLocaleResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        messageSource.setBasename("validation");
        return messageSource;
    }
    

    @Bean
    public EmailValidator usernameValidator() {
        EmailValidator userNameValidator = new EmailValidator();
        return userNameValidator;
    }

    @Bean
    public PasswordMatchesValidator passwordMatchesValidator() {
        PasswordMatchesValidator passwordMatchesValidator = new PasswordMatchesValidator();
        return passwordMatchesValidator;
    }

    // DIC 7
    @Bean
    public HashGenerator hashGenerator() {
        HashGenerator hashGenerator = new HashGenerator();
        return hashGenerator;
    }

}