package x_gen.genconf.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 15:59
 * x-gen核心框架数据对应的配置model
 */
public class GenConfModel {

    /**
     * 描述注册的多个用户需要生成的Model
     */
    private List<NeedGenModel> needGens = new ArrayList<>();

    /**
     * 描述注册的多个外部主题model
     */
    private List<ThemeModel> themes = new ArrayList<>();

    /**
     * 描述通用的常量定义集合
     */
    private Map<String,String> mapContants = new HashMap<>();




    public List<NeedGenModel> getNeedGens() {
        return needGens;
    }

    public void setNeedGens(List<NeedGenModel> needGens) {
        this.needGens = needGens;
    }

    public List<ThemeModel> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeModel> themes) {
        this.themes = themes;
    }

    public Map<String, String> getMapContants() {
        return mapContants;
    }

    public void setMapContants(Map<String, String> mapContants) {
        this.mapContants = mapContants;
    }


    /**
     *
     * @param themeId
     * @return
     */
    public ThemeModel getThemeById(String themeId){

        //老写法
//        for (ThemeModel themeModel : this.themes){
//            if (themeModel.getId().equals(themeId)){
//                return themeModel;
//            }
//        }
//
//        return new ThemeModel();

        //新写法
        ThemeModel tm = this.themes.stream()
                .filter(themeModel -> themeModel.getId().equals(themeId))
                .collect(Collectors.toList()).get(0);

        if (tm==null){
            return new ThemeModel();
        }

        return tm;

    }


    @Override
    public String toString() {
        return "GenConfModel{" +
                "needGens=" + needGens +
                ", themes=" + themes +
                ", mapContants=" + mapContants +
                '}';
    }
}
