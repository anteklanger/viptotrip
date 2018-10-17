package com.ollogicalsolutions.viptotrip.config;

//import com.ollogicalsolutions.viptotrip.services.SpringDataUserDetailsService;
import com.ollogicalsolutions.viptotrip.services.SpringDataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Autowired
    DataSource dataSource;


//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/tweeter");
//        dataSource.setUsername("root");
//        dataSource.setPassword("coderslab");
//        return dataSource;
//    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**").antMatchers("/test/**");//.antMatchers("/**");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery("SELECT username, pin FROM users WHERE username = ?")
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
////                .authoritiesByUsernameQuery("select username, role from user_role where username")
//                .authoritiesByUsernameQuery("select u.username, r.role from users u inner join user_role ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.username= ?")
//                .passwordEncoder(passwordEncoder());
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.jsp").permitAll()
                .antMatchers("/api/*").permitAll()
                .antMatchers("/register").anonymous()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/event/**").hasAnyAuthority("EDITOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
//                .httpBasic()
                .formLogin()//.loginPage("/login.jsp")
                .and()
                .csrf().disable()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login.jsp");
    }
}
