package java_base;

/**
 * Created by hzqiuxm on 2016/3/12 0012.
 */
public class HashTest {
    private String name = "hzqiuxm";
    private short age = 30;

    public HashTest(String name, short age) {
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

    public int hashCode(){
        final int balanaceFactor = 17;
        int result = balanaceFactor;
        result = result * balanaceFactor + age;
        return result*balanaceFactor + name.hashCode();
    }

    public boolean equals(Object obj){
        if(obj instanceof HashTest){
            String tempName = ((HashTest)obj).name;
            short tempAge = ((HashTest)obj).age;
            return this.name.equals(tempName)&&this.age == tempAge;
        }else {
            return false;
        }
    }

}
