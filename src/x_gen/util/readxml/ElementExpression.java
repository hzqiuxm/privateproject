package x_gen.util.readxml;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/12 0012 22:13
 */
public class ElementExpression extends ReadXmlExpression{


    /**
     * 用来记录组合的子ReadXmlExpression元素
     */
    private List<ReadXmlExpression> eles = new ArrayList<ReadXmlExpression>();

    public List<ReadXmlExpression> getEles() {
        return eles;
    }

    /**
     * 元素的名称
     */
    private String eleName = "";
    /**
     * 判断的条件
     */
    private String condition = "";


    @Override
    public String[] interpret(Context context) {
        return new String[0];
    }
}
