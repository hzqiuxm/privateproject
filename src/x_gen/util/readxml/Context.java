package x_gen.util.readxml;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/12 0012 21:50
 * 上下文,存放解释器需要的一些全局信息
 */
public class Context {

    /**
     * 上一次被处理的多个父节点的元素
     */
    private List<Element> preEles = new ArrayList<Element>();

    public List<Element> getPreEles() {
        return this.preEles;
    }
}
