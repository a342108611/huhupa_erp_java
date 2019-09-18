package com.huhupa.core.license;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import java.util.Date;

@ConfigurationProperties(prefix = "huhupa.jwt")
@Component
public class JwtHelper {
//    private Logger logger = LoggerFactory.getLogger(getClass());
    private String secret;
    private Long expire;
    private String header;

    /**
     *
     * 生成JWT token
     * @param uMember
     * @return
     */
    public String generateToken(License license) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setId(license.getProductName())
                .setSubject(license.getProductName())
                .setIssuedAt(nowDate)
                .setExpiration(license.getExpiry())
                .claim("license", JSON.toJSONString(license))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }

    /**
     *
     * 解析JWT token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        try {

            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("解析token出错");
            return null;
        }
    }

    /**
     *
     * 校验token是否过期
     * @param expiprationTime
     * @return
     */
    public boolean isTokenExpired(Date expiprationTime){
        return expiprationTime.before(new Date());
    }
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
