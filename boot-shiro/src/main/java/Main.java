import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author 谢仲东
 * @description
 * @since 23:45 星期一 2019/1/28
 */
public class Main {

    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager manager = factory.getInstance();

        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken("Zoom", "Boom"));
            System.out.println("认证通过 =>\t" + subject.getPrincipal());;
            System.out.println("是否有ceo角色 =>\t" + subject.hasRole("ceo"));;
            System.out.println("是否有cto角色 =>\t" + subject.hasRole("cto"));;
            System.out.println("是否有裁员权限 =>\t" + subject.isPermitted("staff:fire"));;
            System.out.println("是否有招聘权限 =>\t" + subject.isPermitted("staff:hire"));;
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
        }

    }
}
