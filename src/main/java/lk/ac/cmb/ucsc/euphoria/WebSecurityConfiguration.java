package lk.ac.cmb.ucsc.euphoria;

import lk.ac.cmb.ucsc.euphoria.filter.JwtRequestFilter;
import lk.ac.cmb.ucsc.euphoria.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;

    @Autowired
    LoginService loginService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username,password,enabled from login_credentials where username=?"
//                )
//                .authoritiesByUsernameQuery(
//                        "select username,"+
//                        "(select 'ROLE_COUNSELOR' from counselor C where L.id = C.login_credentials_id)"+
//                        "as authority from login_credentials L where username = ?"
//                );
//        auth.inMemoryAuthentication()
//                .withUser("sysadmin")
//                .password("sysadmin")
//                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("*/**").cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("api/user/**").permitAll()
                .antMatchers("authenticate").permitAll()
                .antMatchers("api/counselor/sign-up").permitAll()
//                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
