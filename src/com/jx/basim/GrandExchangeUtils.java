package com.jx.basim;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

public class GrandExchangeUtils {

    public GrandExchangeUtils() {}

    public Integer FetchValue(Integer itemID) {
        return parseValue(fetchJSON(itemID),itemID);
    }

    private String fetchJSON(Integer itemID) {
        try {
            URL grandExchangeAPIURL = new URL("http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=" + itemID);
            URLConnection connection = grandExchangeAPIURL.openConnection();
            connection.setConnectTimeout(30000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String grandExchangeJSON = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                grandExchangeJSON = grandExchangeJSON + line;
            }
            System.out.println(itemID + " returned " + grandExchangeJSON);
            bufferedReader.close();
            Thread.sleep(5000);
            return grandExchangeJSON.toString();
        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.toString() + " ID: " + itemID);
            return null;
        }
    }

    private Integer parseValue(String jsonString, Integer itemID) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString).getJSONObject("item").getJSONObject("current");
            String priceString = jsonObject.get("price").toString().replace(",","");
            return ParseValue(priceString);
        } catch (Exception ex) {
            System.out.println(ex.toString() + " ID: " + itemID);
            return 0;
        }
    }

    public Integer ParseValue(String value) {
        return Integer.parseInt(value
                .replace(".","")
                .replace(",","")
                .replace("b","00000000")
                .replace("m","00000")
                .replace("k","00"));
    }

    public String ShortenValue(Integer value) {
        if (value < 1000) return "" + value;
        int exp = (int) (Math.log(value) / Math.log(1000));
        DecimalFormat format = new DecimalFormat("0.#");
        String v = format.format(value / Math.pow(1000, exp));
        return String.format("%s%c", v, "kMBTPE".charAt(exp - 1)); // yoinked off stackoverflow
    }
}
