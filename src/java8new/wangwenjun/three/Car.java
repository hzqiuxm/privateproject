package java8new.wangwenjun.three;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/18 0018 10:29
 */
public class Car {

    private Optional<Insuracne>  insuracne;

    public Optional<Insuracne> getInsuracne() {
        return insuracne;
    }

    public void setInsuracne(Optional<Insuracne> insuracne) {
        this.insuracne = insuracne;
    }
}
