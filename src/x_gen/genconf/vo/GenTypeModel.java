package x_gen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 18:23
 */
public class GenTypeModel {

    private String id;
    private String genTypeClass;

    private Map<String,String> mapParams = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenTypeClass() {
        return genTypeClass;
    }

    public void setGenTypeClass(String genTypeClass) {
        this.genTypeClass = genTypeClass;
    }

    public Map<String, String> getMapParams() {
        return mapParams;
    }

    public void setMapParams(Map<String, String> mapParams) {
        this.mapParams = mapParams;
    }
}
