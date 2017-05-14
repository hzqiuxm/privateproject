package x_gen.genconf.confmanager;

import x_gen.genconf.implmentors.GenConfImplmentor;
import x_gen.genconf.implmentors.ModuleGenConfImplmentor;
import x_gen.genconf.vo.GenConfModel;
import x_gen.genconf.vo.ModuleConfModel;
import x_gen.genconf.vo.NeedGenModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 20:08
 * 也实现成单例,负责真正去获取配置数据，并缓存
 * 同时也扮演了桥接模式中的功能层次，组合了实现层次的GenConfImplmentor
 */

public class ConfManager {

    private static ConfManager instance = null;

    private ConfManager(GenConfImplmentor provider) {
        readConf(provider);
    }

    public static ConfManager getInstace(GenConfImplmentor provider){

        if(instance == null){
            instance = new ConfManager(provider);
        }
        return instance;
    }

    //定义需要缓存的数据
    private GenConfModel genConf = new GenConfModel();

    private Map<String,ModuleConfModel> mapModuleConf = new HashMap<>();


    //读配置并保存,在构造方法中调用
    private void readConf(GenConfImplmentor provider){

        //数据来源可能是多种：文件，数据库.....
        //把获取到的数据设置到属性上，缓存下来
        readGenConf(provider);
        for (NeedGenModel ngm : genConf.getNeedGens()){
            readOneMoudleGenConf(ngm);
        }

        genConf.getNeedGens().stream();

    }

    private void readGenConf(GenConfImplmentor provider){

        genConf.setNeedGens(provider.getNeedGens());
        genConf.setThemes(provider.getThemes());
        genConf.setMapContants(provider.getMapContants());

    }

    private void readOneMoudleGenConf(NeedGenModel ngm){

        ModuleConfModel moduleConfModel = new ModuleConfModel();

        String providerClassName = this.genConf.getThemeById(ngm.getTheme()).getMapProvider().get(ngm.getProvider());

        ModuleGenConfImplmentor userGenConfImpl = null;

        try {
            userGenConfImpl = (ModuleGenConfImplmentor)Class.forName(providerClassName).newInstance();

        } catch (Exception e) {

        }

        moduleConfModel = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParames());

        moduleConfModel.setUserTheme(ngm.getTheme());
        moduleConfModel.setMapExtends(userGenConfImpl.getExtends(ngm.getMapParames()));
        moduleConfModel.setMapNeedGenTypes(userGenConfImpl.getNeedGenTypes(ngm.getMapParames()));

        //设置到缓存里
        this.mapModuleConf.put(moduleConfModel.getModuleid(),moduleConfModel);

    }



    public GenConfModel getGenConfModel() {
        return genConf;
    }

    public Map<String, ModuleConfModel> getMapModuleConf() {
        return mapModuleConf;
    }
}
