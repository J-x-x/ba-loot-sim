package com.jx.basimpriceupdater;

import com.jx.basim.GrandExchangeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BaSimulatorPriceUpdater {

    private static ArrayList<Integer> requiredIDs = new ArrayList<Integer>();
    private static HashMap<Integer, Integer> grandExchangePriceHashMap = new HashMap<>();
    private static GrandExchangeUtils grandExchangeUtils = new GrandExchangeUtils();

    public static void main(String[] args) {
        addAllIDs();
        populateHashMap();
        writeFile(generateJson());
    }

    private static void addAllIDs() {
        requiredIDs.add(253);
        requiredIDs.add(1149);
        requiredIDs.add(257);
        requiredIDs.add(3000);
        requiredIDs.add(269);
        requiredIDs.add(5295);
        requiredIDs.add(5300);
        requiredIDs.add(5304);
        requiredIDs.add(5321);
        requiredIDs.add(5289);
        requiredIDs.add(5316);
        requiredIDs.add(3749);
        requiredIDs.add(3751);
        requiredIDs.add(3753);
        requiredIDs.add(3755);
        requiredIDs.add(3122);
        requiredIDs.add(10589);
        requiredIDs.add(1201);
        requiredIDs.add(453);
        requiredIDs.add(451);
        requiredIDs.add(2363);
        requiredIDs.add(536);
        requiredIDs.add(1747);
        requiredIDs.add(1617);
        requiredIDs.add(1513);
        requiredIDs.add(8782);
        requiredIDs.add(892);
        requiredIDs.add(383);
        requiredIDs.add(385);
        requiredIDs.add(563);
        requiredIDs.add(565);
        requiredIDs.add(225);
        requiredIDs.add(237);
        requiredIDs.add(12073);
        requiredIDs.add(12703);
    }

    private static void populateHashMap() {
        for (Integer i : requiredIDs) {
            grandExchangePriceHashMap.put(i, grandExchangeUtils.FetchValue(i));
        }
    }

    private static String generateJson() {
        JSONObject jsonObject = new JSONObject(grandExchangePriceHashMap);
        return jsonObject.toString();
    }

    private static void writeFile(String json) {
        try {
            File destinationFile = new File("./grandExchangePrices.json");
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
                System.out.println("File created successfully.");
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("File already exists, overwrite? Y/N");
                String resp = scanner.nextLine();
                if (!resp.toLowerCase().equals("y")) {
                    System.exit(0);
                }
            }

            FileWriter fileWriter = new FileWriter(destinationFile);
            fileWriter.write(json);
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
