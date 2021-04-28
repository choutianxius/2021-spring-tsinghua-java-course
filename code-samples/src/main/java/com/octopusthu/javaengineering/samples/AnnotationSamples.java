package com.octopusthu.javaengineering.samples;

import lombok.Getter;
import lombok.Setter;

/**
 * @author octopusthu@gmail.com
 */
public class AnnotationSamples {

    static class Point {
        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    @Getter
    @Setter
    static
    class PointWithLombok {
        private double x;
        private double y;
    }

}
