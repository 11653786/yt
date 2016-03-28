package com.yt.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.shiro
 * @date 2016/3/28 0028 15:40
 * @descption: 疯狂的王麻子团队!
 */
public class MyRealm extends AuthorizingRealm {
    /**
     * 权限验证,登录完成之后调用这个方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        ShiroUserPasswordToken myUserPassWorkToken = (ShiroUserPasswordToken) authenticationToken;
        //若存在，将此用户存放到登录认证info中
        if(1==1){
        //前台登录
        }else{
        //后台登录
        }
        return new ShiroAuthenticationInfo(null,null,null,null,null,null,null);
    }
}
