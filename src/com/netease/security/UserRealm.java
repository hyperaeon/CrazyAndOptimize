package com.netease.security;

import java.math.BigInteger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Splitter;
import com.netease.domain.New_User;
import com.netease.domain.User;
import com.netease.service.NewUserService;

/**
 * 
 * @ClassName: UserRealm
 * @Description: shiro安全核心类 ,请不要改动
 * @author:JonneyZhang
 * @date: 2016-5-31 19:16:28
 */
public class UserRealm extends AuthorizingRealm {
    final static Logger logger = LoggerFactory.getLogger(UserRealm.class);
//    @Autowired
//    UserService userService;
    @Autowired
    NewUserService newUserService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        logger.info("Authorization username : {}", username);

        //User user = userService.getByLoginName(username);
        New_User user = newUserService.findUserByMobileNumber(username);
        String roles_str = user.getRoles();
        Iterable<String> roles = Splitter.on(',')
            .trimResults()
            .omitEmptyStrings()
            .split(roles_str);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (String role: roles) {
            authorizationInfo.addRole(role);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
                     throws AuthenticationException {
        String username = (String)token.getPrincipal();
        logger.info("Authentication username: {}", username);
       // User user  = userService.getByLoginName(username);
        New_User user  = newUserService.findUserByMobileNumber(username);
        logger.info("Login username: {}, password: {}", user.getMobileNumber(), user.getPasswordsha());

        AuthenticationInfo ai = new SimpleAuthenticationInfo(user.getMobileNumber(),
        		                                             user.getPasswordsha(),
                                                             ByteSource.Util.bytes(user.getSalt()),
                                                             getName());
        return ai;
    }
}
