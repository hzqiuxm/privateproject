package design_example.flyweight.example1;

/**
 * Created by hzqixm on 2015/7/18.
 * 权限实体
 */
public class AuthorizationModel {

    //用户
    private String user;
    //实体
    private String securityEntity;
    //权限
    private String permit;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public void setSecurityEntity(String securityEntity) {
        this.securityEntity = securityEntity;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

//    @Override
//    public String toString() {
//        return "AuthorizationModel{" +
//                "user='" + user + '\'' +
//                ", securityEntity='" + securityEntity + '\'' +
//                ", permit='" + permit + '\'' +
//                '}';
//    }
}
