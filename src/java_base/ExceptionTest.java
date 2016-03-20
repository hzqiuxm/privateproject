package java_base;

import java.util.zip.DataFormatException;

/**
 * Created by hzqiuxm on 2016/3/15 0015.
 */
public class ExceptionTest {

    public static int menthod(int count) throws Exception{
        try {
            if (count < 0) {
                throw new DataFormatException("数据格式错误");
            }else{
                return count;
            }
        }catch (Exception e){
            //异常处理
            return 1;
        }finally {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println(menthod(-3));
    }
}
