package com.example.tddmonopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameController {
    public Text diceResult;
    private final Dice dice = new Dice(new Random());
    private final List<Street> gameBoard;
    private final List<Street> playerProperties = new ArrayList<>();
    public TextArea propertyInformation;
    public TextArea playerInformation;
    public Button diceButton;

    {
        try {
            gameBoard = Board.setupBoard();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Player player = new Player("You", 5000, 0, playerProperties);
    private final Pattern pattern = Pattern.compile("(utilities|corner)", Pattern.CASE_INSENSITIVE);

    @FXML
    protected void onDiceButtonClick() {
        int[] diceRoll = dice.roll();

        int playerNewPosition = calculateBoardPosition();


        player.setPosition(playerNewPosition);

        String changeText = "You rolled a " + diceRoll[0] + " and a " + diceRoll[1];
        diceResult.setText(changeText);

        String propertyText = "Currently on: \n" + gameBoard.get(player.getPosition()-1).toString();
        propertyInformation.setText(propertyText);

        String playerText = generatePlayerInfo();
        playerInformation.setText(playerText);

        System.out.println(gameBoard.get(dice.getDiceTotal()-1).toString());
    }

    private int calculateBoardPosition() {
        int playerPos;

        if (player.getPosition() + dice.getDiceTotal() > 40){
            playerPos = player.getPosition() + dice.getDiceTotal() - 39;
            player.setMoneyBalance(player.getMoneyBalance()+200);
        }
        else{
            playerPos = player.getPosition() + dice.getDiceTotal();
        }

        return playerPos;
    }

    @FXML
    protected void onBuyPropertyButtonClick(){
        Street tmpStreet = gameBoard.get(player.getPosition()-1);

        Matcher matcher = pattern.matcher(tmpStreet.colourGroup);
        boolean matchFound = matcher.find();

        if(tmpStreet.getOwner().isEmpty()){
            diceResult.setText("You can't buy this, someone already owns this!");
        }
        else if (player.getMoneyBalance() < tmpStreet.price){
            diceResult.setText("You can't buy this, you have insufficient balance!");
        }
        else if (matchFound){
            diceResult.setText("You can't buy this, this isn't for sale!");
        }
        else{
            tmpStreet.setOwner(player.getName());
            gameBoard.set(tmpStreet.id-1, tmpStreet);
            playerProperties.add(tmpStreet);

            player.setMoneyBalance(player.getMoneyBalance()- tmpStreet.price);

        }
    }

    private String generatePlayerInfo() {
        String playerInfo = "You have: " + player.getMoneyBalance() + "\n";
        if(player.getPropertiesOwned().isEmpty()){
            playerInfo += "No properties owned yet!";
        }
        else{
            for(int i = 0; i < player.getPropertiesOwned().size(); i++){
                Street tmpStreet = player.getPropertiesOwned().get(i);

                playerInfo += tmpStreet.getStreetName() + "\n";
            }
        }

        return playerInfo;
    }
}