package x_gen.genconf;

import x_gen.genconf.vo.GenConfModel;
import x_gen.genconf.vo.ModuleConfModel;

import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 15:56
 */
public interface GenConfEbi {

    /**
     * 获取x-gen核心框架运行所需要的配置数据
     * @return
     */
    public GenConfModel getGenConf();


    /**
     * 获取需要生成的所有模块的设置
     * @return 包含所有需要生成的模块的配置数据map
     * key 模块的id
     * value 相应配置模块的model
     */
    public Map<String,ModuleConfModel> getMapModuleConf();




}
