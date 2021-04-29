package com.octopusthu.javaengineering.samples.solid;

/**
 * 使用手机充电器案例讲解 SOLID 设计原则中的第五条: Dependency Inversion Principle
 *
 * @author octopusthu@gmail.com
 */
public class DependencyInversionPrincipleSamples {

    static class InflexiblePhone {
        private final CableCharger charger;

        public InflexiblePhone() {
            this.charger = new CableCharger();
        }

        void charge() {
            charger.charge();
        }
    }

    static interface Charger {
        void charge();
    }

    static class CableCharger implements Charger {
        @Override
        public void charge() {
            System.out.println("Charging with a cable charger...");
        }
    }

    static class WirelessCharger implements Charger {
        @Override
        public void charge() {
            System.out.println("Charging with a wireless charger...");
        }
    }

    static class FlexiblePhone {
        private Charger charger;

        FlexiblePhone(Charger charger) {
            this.charger = charger;
        }

        void charge() {
            charger.charge();
        }

        public void setCharger(Charger charger) {
            this.charger = charger;
        }

    }

    public static void main(String[] args) {
        chargeAnInflexiblePhone();
        chargeAnFlexiblePhone();
    }

    public static void chargeAnInflexiblePhone() {
        InflexiblePhone phone = new InflexiblePhone();
        phone.charge();
    }

    public static void chargeAnFlexiblePhone() {
        // Charge with CableCharger
        Charger cableCharger = new CableCharger();
        FlexiblePhone phone = new FlexiblePhone(cableCharger);
        phone.charge();

        // Charge with WirelessCharger
        Charger wirelessCharger = new WirelessCharger();
        phone.setCharger(wirelessCharger);
        phone.charge();
    }
}
