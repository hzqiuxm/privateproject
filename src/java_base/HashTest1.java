package java_base;

/**
 * Created by hzqiuxm on 2016/3/12 0012.
 */
//被测试类
public class HashTest1 {
    private String name = "hzqiuxm";
    private short age = 30;

    public HashTest1(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public boolean equals(Object obj){
        if(obj instanceof HashTest){
            String tempName = ((HashTest1)obj).name;
            short tempAge = ((HashTest1)obj).age;
            return this.name.equals(tempName)&&this.age == tempAge;
        }else {
            return false;
        }
    }
}
