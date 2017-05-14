package x_gen.genconf.implmentors;

import x_gen.genconf.vo.ExtendConfModel;
import x_gen.genconf.vo.GenConfModel;
import x_gen.genconf.vo.ModuleConfModel;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/12 0012 10:15
 * 获取用户需要生成模块配置数据的接口，桥接模式中的实现层次
 */
public interface ModuleGenConfImplmentor {

    /**
     * 根据核心框架里面注册的需要生成模块的配置参数，来获取相应的需要生成模块的配置数据的model,基本数据
     * @param params 根据核心框架里面注册的需要生成模块的配置参数
     * @return
     */
    public ModuleConfModel getBaseModuleConfModel(Map<String,String> params);


    /**
     * 根据核心框架里面注册的需要生成模块的配置参数，来获取需要生成模块中配置的需要生成的功能类型
     * @param params  ModuleConfModel.mapNeedGenTypes mapExtends
     * @return
     */
    public Map<String,List<String>> getNeedGenTypes(Map<String,String> params);


    /**
     *
     * @param genConfModel 可用用来这里面的常量值和本身的参数做关联（先不写）
     * @param params  ModuleConfModel.mapExtends
     * @return
     */
    public Map<String,ExtendConfModel> getExtends(Map<String, String> params);




}
