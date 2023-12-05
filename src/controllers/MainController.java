/*
* File: MainController.java
* Author: Nagy József
* Refactor: Paulusz Zsombor
* Github: https://github.com/PZsombor
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
*
*/

package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {
    MainWindow mainWindow;
    Round round;

    enum Round  {
        PREFLOP,
        FLOP,
        TURN,
        RIVER
    }
    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }
    private String getCard() {
        String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"♣", "♦", "♥", "♠" };
        Random random = new Random();

        String cardSuit = suits[random.nextInt(4)];
        String cardValue = value[random.nextInt(13)];

        String card = cardSuit + cardValue;

        return card;
    }
    private void defaultValues(){
                this.round = Round.PREFLOP;
                
                this.mainWindow.humanCard1Button.setVisible(false);
                this.mainWindow.humanCard2Button.setVisible(false);
                this.mainWindow.computerCard1Button.setVisible(false);
                this.mainWindow.computerCard2Button.setVisible(false);
                this.mainWindow.flop1Button.setVisible(false);
                this.mainWindow.flop2Button.setVisible(false);
                this.mainWindow.flop3Button.setVisible(false);
                this.mainWindow.turnButton.setVisible(false);
                this.mainWindow.riverButton.setVisible(false);
                this.mainWindow.nextButton.setEnabled(false);
                this.mainWindow.startButton.setEnabled(true);
    }
    public void initEvent() {
        this.defaultValues();
        this.mainWindow.startButton.addActionListener(
            event -> {
                String humanCard1 = getCard();
                String humanCard2 = getCard();
                String computerCard1 = getCard();
                String computerCard2 = getCard();


                this.mainWindow.humanCard1Button.setText(humanCard1);
                this.mainWindow.humanCard2Button.setText(humanCard2);
                this.mainWindow.humanCard1Button.setVisible(true);
                this.mainWindow.humanCard2Button.setVisible(true);
                this.mainWindow.computerCard1Button.setText(computerCard1);
                this.mainWindow.computerCard2Button.setText(computerCard2);
                this.mainWindow.startButton.setEnabled(false);
                this.mainWindow.nextButton.setEnabled(true);

                System.out.printf("%d %d\n", humanCard1, humanCard2);
                }
            );
        this.mainWindow.stopButton.addActionListener (
            event -> {          
                this.defaultValues();
                System.out.println("Stop");
            });
        this.mainWindow.nextButton.addActionListener(
            event -> {
                if (this.round == Round.PREFLOP) {    
                    String flop1 = getCard();
                    String flop2 = getCard();
                    String flop3 = getCard();

                    this.mainWindow.flop1Button.setText(flop1);
                    this.mainWindow.flop2Button.setText(flop2);
                    this.mainWindow.flop3Button.setText(flop3);
                    this.mainWindow.flop1Button.setVisible(true);
                    this.mainWindow.flop2Button.setVisible(true);
                    this.mainWindow.flop3Button.setVisible(true);
                    this.round = Round.FLOP;
                    return;
                }
                if (this.round == Round.FLOP) {
                    String turn = getCard();

                    this.mainWindow.turnButton.setText(turn);
                    this.mainWindow.turnButton.setVisible(true);
                    this.round=Round.TURN;
                    return;
                }
                if (this.round == Round.TURN) {
                    String river=getCard();

                    this.mainWindow.riverButton.setText(river);
                    this.mainWindow.riverButton.setVisible(true);
                    this.round = Round.RIVER;
                    return;
                }
                if(this.round == Round.RIVER) {
                    this.mainWindow.computerCard1Button.setVisible(true);
                    this.mainWindow.computerCard2Button.setVisible(true);
                    this.mainWindow.nextButton.setEnabled(false);
                    return;
                }
            }
        );
    }
}
