package chonggoubook.one_example.lesson1;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/13 0013 13:58
 * 顾客类
 */
public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();


    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Vector<Rental> rentals) {
        this.rentals = rentals;
    }

    public String statement(){

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration retals = rentals.elements();

        String result = "Rental Record for " + getName();

        while (retals.hasMoreElements()){
            double thisMount = 0;

            Rental each = (Rental) retals.nextElement();

            switch (each.getMovie().getPriceCode()){

                case Movie.REGULAT:
                    thisMount +=2;
                    if (each.getRentalDays() > 2){
                        thisMount += (each.getRentalDays() -2) *1.5;
                    }
                    break;

                case Movie.NEW_RELEASE:
                    thisMount += each.getRentalDays()*3;
                    break;

                case Movie.CHILDRENS:
                    thisMount += 1.5;
                    if(each.getRentalDays() >3){
                        thisMount += (each.getRentalDays() -3) * 1.5;
                    }
                    break;

                default: thisMount += 2;

            }
        }

        //再根据促销活动调整一波


        return result;
    }
}
