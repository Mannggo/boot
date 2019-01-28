package realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 谢仲东
 * @description
 * @since 23:36 星期一 2019/1/28
 */
public class MyRealm extends AuthorizingRealm {


    /**
     * 获取权限
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = "Zoom";
        String password = "Boom";
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 模拟用户不存在
        if (!username.equals(token.getUsername())) {
            return null;
        }

        // 模拟密码验证
        return new SimpleAuthenticationInfo(token.getUsername(), password, "");
    }
}
