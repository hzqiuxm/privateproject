package x_gen.genconf.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 16:03
 * 用户需要生成模块的配置数据
 */
public class ModuleConfModel {

    /**
     * 用户要生成模块的唯一标识
     */
    private String moduleid ="";

    /**
     * 用户需要生成该模块需要的外部主题的标识
     */
    private String userTheme="";

    /**
     * 用户需要生成的具体功能
     * key ： 需要生成的功能的标识
     * value : 该功能生成后的多种输出类型标识的集合
     */
    private Map<String,List<String>> mapNeedGenTypes = new HashMap<>();

    /**
     * 模块生成所需要的一些扩展数据
     * key 数据id
     * value : 扩展数据model
     */
    private Map<String,ExtendConfModel> mapExtends = new HashMap<>();






    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getUserTheme() {
        return userTheme;
    }

    public void setUserTheme(String userTheme) {
        this.userTheme = userTheme;
    }

    public Map<String, List<String>> getMapNeedGenTypes() {
        return mapNeedGenTypes;
    }

    public void setMapNeedGenTypes(Map<String, List<String>> mapNeedGenTypes) {
        this.mapNeedGenTypes = mapNeedGenTypes;
    }

    public Map<String, ExtendConfModel> getMapExtends() {
        return mapExtends;
    }

    public void setMapExtends(Map<String, ExtendConfModel> mapExtends) {
        this.mapExtends = mapExtends;
    }
}
