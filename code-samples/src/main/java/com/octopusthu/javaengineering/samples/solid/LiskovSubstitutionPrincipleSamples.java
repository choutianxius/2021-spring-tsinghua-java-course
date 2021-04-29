package com.octopusthu.javaengineering.samples.solid;

import org.springframework.util.Assert;

/**
 * 使用长方形/正方形案例讲解 SOLID 设计原则中的第三条: Liskov Substitution Principle
 *
 * @author octopusthu@gmail.com
 */
public class LiskovSubstitutionPrincipleSamples {

    static class Rectangle {
        private int height;
        private int width;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int area() {
            return height * width;
        }
    }

    static class Square extends Rectangle {
        private int side;

        public Square(int height, int width) {
            super(height, width);
            Assert.isTrue(getHeight() == getWidth(),
                "A square's height and width must be equal!");
        }

        public int getSide() {
            return side;
        }

        public void setSide(int side) {
            setHeight(side);
            setWidth(side);
        }

        @Override
        public void setHeight(int height) {
            Assert.isTrue(height == getWidth(),
                "A square's height must be equal to its width!");
        }

        @Override
        public void setWidth(int width) {
            Assert.isTrue(width == getHeight(),
                "A square's width must be equal to its height!");
        }
    }

    public static void main(String[] args) {
        calculateRectangleArea();
        calculateSquareArea();
        enlargeRectangle();
        enlargeSquare();
    }

    public static void calculateRectangleArea() {
        int height = 2, width = 2;
        Rectangle rectangle = new Rectangle(height, width);
        int area = rectangle.area();
        System.out.println("The rectangle's area is: " + area);
        Assert.isTrue(area == 4, "The calculated area is wrong!");
    }

    public static void calculateSquareArea() {
        int height = 2, width = 2;
        Square square = new Square(height, width);
        int area = square.area();
        System.out.println("The square's area is: " + area);
        Assert.isTrue(area == 4, "The calculated area is wrong!");
    }

    public static void enlargeRectangle() {
        int height = 2, width = 2;
        Rectangle rectangle = new Rectangle(height, width);
        int area = rectangle.area();
        rectangle.setHeight(rectangle.getHeight() + 2);
        System.out.println("The rectangle's height increases by 2.");
        int enlargedArea = rectangle.area();
        Assert.isTrue(enlargedArea > area, "Error occurred!");
    }

    public static void enlargeSquare() {
        int height = 2, width = 2;
        Square square = new Square(height, width);
        int area = square.area();
        square.setHeight(square.getHeight() + 2);
        System.out.println("The square's height increases by 2.");
        int enlargedArea = square.area();
        Assert.isTrue(enlargedArea > area, "Error occurred!");
    }

}
