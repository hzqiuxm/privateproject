package x_gen.genconf;

import x_gen.genconf.implmentors.GenConfImplmentor;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/11 0011 19:49
 * 简单工程模式
 */
public class GenConfFactory {

    private GenConfFactory() {
    }

    public static GenConfEbi createGenConfEbi(GenConfImplmentor provider){

        return GenConfEbo.getInstance(provider);//获得单例对象
    }
}
