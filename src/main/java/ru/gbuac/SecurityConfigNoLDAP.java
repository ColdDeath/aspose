package ru.gbuac;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Profile("dev")
public class SecurityConfigNoLDAP extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/rest/admin/**").hasRole("ADMIN").and().httpBasic().and().
                authorizeRequests()
                .antMatchers("/rest/documents/**").permitAll().and().
                authorizeRequests()
                .antMatchers("/rest/profile/**").hasAnyRole("ADMIN", "USER").and().httpBasic().and().
                authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").authenticated()
                .and().csrf().ignoringAntMatchers("/rest/**").and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/index")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("user1").password("{noop}user1")
                .roles("USER","Отраслевое управление", "Дата повестки")
                .and()
                .withUser("user2").password("{noop}user2")
                .roles("USER","Отраслевое управление", "Дата повестки")
                .and()
                .withUser("EvdokimovaON").password("{noop}root")
                .roles("USER","Отраслевое управление", "Дата повестки")
                .and()
                .withUser("HvastochenkoON").password("{noop}root")
                .roles("USER","Отраслевое управление", "Дата повестки")
                .and()
                .withUser("VolkovaON").password("{noop}root")
                .roles("USER", "Отраслевое управление", "Дата повестки")
                .and()
                .withUser("ZhegalinaLI").password("{noop}root")
                .roles("USER", "Отраслевое управление", "Дата повестки")
                .and()
                .withUser("LebedevaIA").password("{noop}root")
                .roles("USER", "Отраслевое управление", "Дата повестки")
                .and()
                .withUser("NosikMV").password("{noop}root")
                .roles("USER", "Руководство отраслевого управления")
                .and()
                .withUser("GladkikhMV").password("{noop}root")
                .roles("USER", "Руководство отраслевого управления")
                .and()
                .withUser("ShirokovaEY").password("{noop}root")
                .roles("USER", "Руководство юридического управления")
                .and()
                .withUser("SaprykinaAA").password("{noop}root")
                .roles("USER", "Секретарь Правления", "Дата повестки")
                .and()
                .withUser("FedorovPD").password("{noop}root")
                .roles("USER", "Заместитель Руководителя Федоров П.Д.");
    }




}
