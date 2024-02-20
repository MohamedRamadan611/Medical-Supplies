package com.MedicalSuppliesSystem.MedicalSupplies.utils;

public class QuantityUtils {

    public static Double convertToPallets(Double plt, Integer packets, Double packetPlt) {
        return (plt + (packets / packetPlt));
    }

    public static Double remainingPalletsFromPackets(int packets, Double pltPerCrt, Double packetPlt) {
        return ((packets / packetPlt) % pltPerCrt);
    }


    public static int totalPlts(int totalPackets, Double packetPlt) {
        return (int) (totalPackets / packetPlt);
    }

    public static int remainingPackets(int totalPackets, Double packetPlt) {
        return (int) (totalPackets % packetPlt);
    }

    public static int remainingPallets(int totalPackets, Double pltPerCrt, Double packetPlt) {
        return (int) (totalPlts(totalPackets, packetPlt) % pltPerCrt);
    }

    public static int remainingPallets(int totalPallets, Double pltPerCrt) {
        return (int) (totalPallets % pltPerCrt);
    }

    public static int remainingCartons(int totalPackets, Double pltPerCrt, Double packetPlt) {
        return (int) (totalPlts(totalPackets, packetPlt) / pltPerCrt);
    }

    public static int remainingCartons(int totalPallets, Double pltPerCrt) {
        return (int) (totalPallets / pltPerCrt);
    }

}
