package ir.arcinc.sunbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tahae on 5/26/2016.
 */
@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService service) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.userDetailsService(service);
    }

    @Bean
    @Autowired
    public AuthenticationProvider daoAuthenticationProvider(UserDetailsService service){
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        return provider;
    }

    @Bean
    @Autowired
    public ProviderManager authenticationProviderManager(AuthenticationProvider provider){
        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
        providers.add(provider);
        return new ProviderManager(providers);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**","/account/**","/").permitAll()
                    .antMatchers("/**").permitAll()//.authenticated()
                //TODO should add details for User and Company
                .and().formLogin()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginPage("/account/login")
                    .successForwardUrl("/")
                    .failureForwardUrl("/account/error")
                    .loginProcessingUrl("/account/login-submit")
                .and().logout()
                    .logoutUrl("/account/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);
    }
}
