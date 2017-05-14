package x_gen.genconf.vo;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 17:18
 * 模块生成所需要的一些扩展数据
 */
public class ExtendConfModel {

    private String id;
    private String value;//单个值存放
    private String values;//多个值存放
    private boolean isSingle = true;//默认单个值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }
}
