package x_gen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 16:52
 */
public class NeedGenModel {

    private String id;
    private String provider;//代表providerId
    private String theme;  //代表的是themeId

    private Map<String,String> mapParames = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Map<String, String> getMapParames() {
        return mapParames;
    }

    public void setMapParames(Map<String, String> mapParames) {
        this.mapParames = mapParames;
    }
}
