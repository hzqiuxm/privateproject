package x_gen.genconf.implmentors;

import x_gen.genconf.vo.NeedGenModel;
import x_gen.genconf.vo.ThemeModel;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/12 0012 10:07
 * 获取核心框架配置数据的接口，桥接模式中的实现层次
 */
public interface GenConfImplmentor {

    /**
     * 获取核心框架配置中注册的需要生成的模块的配置数据
     * @return
     */
    public List<NeedGenModel> getNeedGens();

    /**
     * 获取核心框架配置中的外部主题的配置数据
     * @return
     */
    public List<ThemeModel> getThemes();

    /**
     * 获取核心框架配置中注册的定义的公共常量
     * @return
     */
    public Map<String,String> getMapContants();
}
