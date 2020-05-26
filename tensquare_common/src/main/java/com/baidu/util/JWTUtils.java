package com.baidu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@ConfigurationProperties("jwt.config")
@Data
@Component
public class JWTUtils {

    private String key; //配置文件中key为key的属性
    private String ttl; //配置文件中key为ttl的属性

    /**
     * 创建token
     * @param id    id
     * @param subject   主体
     * @param role  角色名
     * @return  token字符串
     */
    public String createToke(String id,String subject,String role){
        //1.得到系统的当前时间
        long millis = System.currentTimeMillis();
        //2.定义过期的date对象
        Date date = new Date(millis+Long.valueOf(ttl));
        return Jwts.builder().
                setId(id).
                setSubject(subject).
                claim("roles", role).
                setExpiration(date).
                signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims parseToken(String token){
        //解析传入的token
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }




}
