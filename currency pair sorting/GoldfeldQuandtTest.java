package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
/*
тест на выявление гетероскедастичности
 */
public class GoldfeldQuandtTest {

    private static double partOfTest(double[] x, double[] y, int left, int right) {
        double x_merge = 0.0;
        double y_merge = 0.0;
        double xy_merge = 0.0;
        double xsqr_merge = 0.0;
        for (int i = left; i <= right; i++) {
            x_merge += x[i];
            y_merge += y[i];
            xy_merge += x[i] * y[i];
            xsqr_merge += x[i] * x[i];
        }
        x_merge *= 1.0 / right;
        y_merge *= 1.0 / right;
        xy_merge *= 1.0 / right;
        xsqr_merge *= 1.0 / right;
        double b = (double)(xy_merge - x_merge * y_merge) / (xsqr_merge - x_merge * x_merge);
        double a = y_merge - b * x_merge;
        double s = 0.0;
        for (int k = left; k <= right; k++) {
            s += Math.pow(y[k] - a - b * x[k], 2);
        }
        return s;
    }
    private static boolean test(double left_s, double right_s) {
        double f = (double) right_s / left_s;
        if (f > 1) {
            return true;
        } else {
            return false;
        }
    }

}
