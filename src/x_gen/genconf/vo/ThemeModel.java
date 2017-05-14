package x_gen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 16:53
 */
public class ThemeModel {

    private String id;
    private String location;

    private Map<String,GenTypeModel> mapGenTypes = new HashMap<>();

    private Map<String,String> mapGenOutTypes = new HashMap<>();

    private Map<String,String> mapProvider = new HashMap<>();//ClassName在这里 id-type


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, GenTypeModel> getMapGenTypes() {
        return mapGenTypes;
    }

    public void setMapGenTypes(Map<String, GenTypeModel> mapGenTypes) {
        this.mapGenTypes = mapGenTypes;
    }

    public Map<String, String> getMapGenOutTypes() {
        return mapGenOutTypes;
    }

    public void setMapGenOutTypes(Map<String, String> mapGenOutTypes) {
        this.mapGenOutTypes = mapGenOutTypes;
    }

    public Map<String, String> getMapProvider() {
        return mapProvider;
    }

    public void setMapProvider(Map<String, String> mapProvider) {
        this.mapProvider = mapProvider;
    }
}
