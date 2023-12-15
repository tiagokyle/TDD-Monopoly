package com.example.tddmonopoly;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Board {
    static List<Street> streetList = new ArrayList<>();

    public static List<Street> setupBoard() throws IOException {

        String example = FileUtils
                .readFileToString(new File("src/main/resources/com/example/tddmonopoly/properties.json")
                        , StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(example);
        JsonNode properties = jsonNode.path("properties");
        JsonNode streets = properties.get(0);
        JsonNode utilities = properties.get(1);
        JsonNode corners = properties.get(2);

        setupStreetProperties(streets);
        setupStationProperties(streets);
        setupUtilityProperties(utilities);
        setupCorners(corners);

        streetList.sort(Street.StreetID);
        return streetList;
    }

    public static void setupStreetProperties(JsonNode indexedStreet){
        String[] streetSearchList = {"brown", "lightBlue", "pink", "orange", "red", "yellow", "green", "blue"};

        for (String colourName : streetSearchList) {
            JsonNode colourSearch = indexedStreet.findValue(colourName);
            for (JsonNode street : colourSearch) {
                JsonNode findRent = street.findValue("rent");
                int position = street.path("id").asInt();

                Rent newRent = new Rent(
                        findRent.path("zero").asInt(),
                        findRent.path("one").asInt(),
                        findRent.path("two").asInt(),
                        findRent.path("three").asInt(),
                        findRent.path("four").asInt(),
                        findRent.path("hotel").asInt()
                );

                Street newStreet = new Street(
                        position,
                        colourName,
                        street.path("streetName").asText(),
                        street.path("price").asInt(),
                        newRent,
                        street.path("mortgage").asInt(),
                        street.path("upgradeCost").asInt()

                );
                streetList.add(newStreet);

            }
        }
    }

    public static void setupStationProperties(JsonNode indexedStations){
        for (JsonNode station : indexedStations.findValue("stations")) {
            int position = station.path("id").asInt();
            JsonNode stationRentList = station.findValue("rent");

            Rent stationRent = new Rent(
                    stationRentList.path("zero").asInt(),
                    stationRentList.path("one").asInt(),
                    stationRentList.path("two").asInt(),
                    stationRentList.path("three").asInt(),
                    stationRentList.path("four").asInt(),
                    stationRentList.path("hotel").asInt()
            );

            Street newStreet = new Street(
                    position,
                    "station",
                    station.path("streetName").asText(),
                    station.path("price").asInt(),
                    stationRent,
                    station.path("mortgage").asInt(),
                    0
            );

            streetList.add(newStreet);
        }
    }

    public static void setupUtilityProperties(JsonNode indexedUtils){
        for (JsonNode util : indexedUtils.findValue("utilities")){
            Street newUtil = new Street(
                    util.path("id").asInt(),
                    "utilities",
                    util.path("streetName").asText(),
                    util.path("price").asInt(),
                    null,
                    0,
                    0
            );

            streetList.add(newUtil);
        }
    }

    public static void setupCorners(JsonNode indexedCorners) {
        for (JsonNode corner : indexedCorners.findValue("corners")){
            Street newCorner = new Street(
                    corner.path("id").asInt(),
                    "corners",
                    corner.path("streetName").asText(),
                    0,
                    null,
                    0,
                    0
            );

            streetList.add(newCorner);
        }
    }


}
