package chonggoubook.one_example.lesson1;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/13 0013 13:58
 * 租赁
 */
public class Rental {

    private Movie movie;
    private int rentalDays;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public Rental(Movie movie, int rentalDays) {
        this.movie = movie;
        this.rentalDays = rentalDays;
    }
}
