package x_gen.genconf;

import x_gen.genconf.confmanager.ConfManager;
import x_gen.genconf.implmentors.GenConfImplmentor;
import x_gen.genconf.vo.GenConfModel;
import x_gen.genconf.vo.ModuleConfModel;

import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 18:36
 * 单例模式 造成了职责不单一，所以新建一个ConfManager类把获取对象部分逻辑移出去
 */
//负责完成配置管理模块的业务功能
public class GenConfEbo implements GenConfEbi {

    private static GenConfEbo instance = null;

    private GenConfEbo(GenConfImplmentor provider) {
        this.provider = provider;
    }

    public static GenConfEbo getInstance(GenConfImplmentor provider){
        if(instance == null){
            instance = new GenConfEbo(provider);
        }

        return instance;
    }

    /**
     * 获取框架配置数据的具体实现接口对象
     */
    private GenConfImplmentor provider = null;

    @Override
    public GenConfModel getGenConf() {
        //获取相应的配置数据并保存到内存
        return ConfManager.getInstace(provider).getGenConfModel();
    }

    @Override
    public Map<String, ModuleConfModel> getMapModuleConf() {
        //获取相应的配置数据并保存到内存
        return ConfManager.getInstace(provider).getMapModuleConf();
    }
}
