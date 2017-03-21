package java6new;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/21 0021 11:05
 */
@HelloAnnotation(meta = @MetaAnnotation("word"), value = "hello",arrayAttr = {1,2,3})
public class AnnotationTest {
    public static void main(String[] args) throws Exception{

        if(AnnotationTest.class.isAnnotationPresent(HelloAnnotation.class)){

            HelloAnnotation annotation = AnnotationTest.class.getAnnotation(HelloAnnotation.class);
            System.out.println(annotation.value() + "-" + annotation.color());
            System.out.println(annotation.meta().value());
        }

    }
}
