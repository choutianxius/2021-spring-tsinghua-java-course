package com.octopusthu.javaengineering.samples.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 使用随机数生成案例讲解 SOLID 设计原则中的第二条: Open-Closed Principle
 *
 * @author octopusthu@gmail.com
 */
public class OpenClosedPrincipleSamples {

    static class InextensibleRandomGenerator {
        public List<Integer> generate() {
            int upperBound = 100;
            Random random = new Random();
            List<Integer> list = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                list.add(random.nextInt(upperBound));
            }
            return list;
        }
    }

    static class ExtensibleRandomGenerator {
        public List<Integer> generate() {
            List<Integer> list = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                list.add(generateOne());
            }
            return list;
        }

        public Integer generateOne() {
            int upperBound = 100;
            Random random = new Random();
            return random.nextInt(upperBound);
        }
    }

    static class ModifiableRandomGenerator {
        public static int upperBound = 100;

        public List<Integer> generate() {
            List<Integer> list = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                list.add(generateOne());
            }
            return list;
        }

        public Integer generateOne() {
            Random random = new Random();
            return random.nextInt(upperBound);
        }
    }

    static class LargeRandomGenerator extends ExtensibleRandomGenerator {
        @Override
        public Integer generateOne() {
            int upperBound = 10000;
            Random random = new Random();
            return random.nextInt(upperBound);
        }
    }

    public static void main(String[] args) {
        executeInextensibleRandomGenerator();
        executeExtensibleRandomGenerator();
        executeModifiableRandomGenerator();
    }

    static void executeInextensibleRandomGenerator() {
        InextensibleRandomGenerator smallRandomGenerator = new InextensibleRandomGenerator();
        System.out.println("Small random numbers: " + smallRandomGenerator.generate());
    }

    static void executeExtensibleRandomGenerator() {
        ExtensibleRandomGenerator smallRandomGenerator = new ExtensibleRandomGenerator();
        LargeRandomGenerator largeRandomGenerator = new LargeRandomGenerator();
        System.out.println("Small random numbers: " + smallRandomGenerator.generate());
        System.out.println("Large random numbers: " + largeRandomGenerator.generate());
    }

    static void executeModifiableRandomGenerator() {
        ModifiableRandomGenerator smallRandomGenerator = new ModifiableRandomGenerator();
        ModifiableRandomGenerator.upperBound = 10000;
        ModifiableRandomGenerator largeRandomGenerator = new ModifiableRandomGenerator();
        System.out.println("Small random numbers: " + smallRandomGenerator.generate());
        System.out.println("Large random numbers: " + largeRandomGenerator.generate());
    }

}
