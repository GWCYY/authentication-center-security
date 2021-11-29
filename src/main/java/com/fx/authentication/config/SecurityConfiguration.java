package com.fx.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //认证服务器 配置用户认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //注意roles authorities 在后面的才会生效。
                //.roles("r1","r2").authorities("r3","r4")  roles无效 authorities有效
                //两种选一种
                //一般我们简单系统只需根据authorities权限配置就行
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("r1", "r2").authorities("r3", "r4")
                .and()
                .withUser("user").password(passwordEncoder().encode("123456")).authorities("r3", "r4").roles("r1", "r2")
        ;
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable() //打开的csrf保护
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//禁用session 默认授权页面将失效
        ;

    }
}
