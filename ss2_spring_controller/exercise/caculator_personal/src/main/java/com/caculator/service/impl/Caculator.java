package com.caculator.service.impl;

import com.caculator.service.ICalculate;
import org.springframework.stereotype.Service;

@Service
public class Caculator implements ICalculate {


    public Double pheptinh1(double number1, double number2, String pheptinh) {

        double ketqua1 = 0;

        switch (pheptinh) {
            case "cong":
                ketqua1 = summation(number1, number2);
                break;
            case "tru":
                ketqua1 = Subtraction(number1, number2);
                break;
            case "nhan":
                ketqua1 = multiplication(number1, number2);
                break;
            case "chia":
                ketqua1 = division(number1, number2);
                break;
        }
        return ketqua1;
    }


    @Override
    public double summation(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double Subtraction(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double division(double number1, double number2) {
        return number1 / number2;
    }


}
