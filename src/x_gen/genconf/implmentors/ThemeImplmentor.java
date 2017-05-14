package x_gen.genconf.implmentors;

import x_gen.genconf.vo.GenTypeModel;

import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/12 0012 11:31
 * 获取主题类配置数据，桥接模式中的实现层次
 */
public interface ThemeImplmentor {


    /**
     * 根据theme_id 在核心框架里面注册theme时配置的相应参数，来获取theme中定义的生成的功能类型
     * @param themeId
     * @param params
     * @return  ThemeModel.mapGenTypes
     */
    public Map<String,GenTypeModel> getMapGenType(String themeId,Map<String,String> params);


    /**
     *
     * @param themeId
     * @param params
     * @return ThemeModel.mapGenOutTypes
     */
    public Map<String,String> getGenOutTypes(String themeId,Map<String,String> params);


    /**
     *
     * @param themeId
     * @param params
     * @return  ThemeModel.mapProviders
     */
    public Map<String,String> getProviders(String themeId,Map<String,String> params);



}
