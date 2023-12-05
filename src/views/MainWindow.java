/*
* File: MainWindow.java
* Author: Nagy József
* Refactor: Paulusz Zsombor
* Github: https://github.com/PZsombor
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
*
*/

package views;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public JButton startButton;
    public JButton stopButton;
    public JButton nextButton;
    public JButton humanCard1Button;
    public JButton humanCard2Button;
    public JButton computerCard1Button;
    public JButton computerCard2Button;
    public JButton flop1Button;
    public JButton flop2Button;
    public JButton flop3Button;
    public JButton turnButton;
    public JButton riverButton;
    public JPanel buttonPanel;
    public JPanel tablePanel;
    public JPanel humanPanel;
    public JPanel computerPanel;
    public JLabel humanLabel;
    public JLabel computerLabel;

    public MainWindow() {
        initComponents();
        addPanelComponents();
        setButtonVisibility();
        initFrame();
        addButtonPanelComponents();
        addHumanPanelComponents();
        addTablePanelComponents();
        setTablePanel();
        addComputerPanelComponents();
    }
    public void initComponents() {
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.nextButton = new JButton("Következő");
        this.humanCard1Button = new JButton();
        this.humanCard2Button = new JButton();
        this.computerCard1Button = new JButton();
        this.computerCard2Button = new JButton();
        this.flop1Button = new JButton();
        this.flop2Button = new JButton();
        this.flop3Button = new JButton();
        this.turnButton = new JButton();
        this.riverButton = new JButton();
        this.buttonPanel = new JPanel();
        this.tablePanel = new JPanel();
        this.humanPanel = new JPanel();  
        this.computerPanel = new JPanel();
        this.humanLabel = new JLabel("Ember keze: ");
        this.computerLabel = new JLabel("Számítógép keze: ");
    }
    public void addPanelComponents() {
        this.add(buttonPanel);
        this.add(tablePanel);
        this.add(humanPanel);
        this.add(computerPanel);
    }
    public void setButtonVisibility() {
        this.flop1Button.setVisible(false);
        this.flop2Button.setVisible(false);
        this.flop3Button.setVisible(false);
        this.turnButton.setVisible(false);
        this.riverButton.setVisible(false);
    }
    public void initFrame() {
        this.setLayout(new BoxLayout(
            this.getContentPane(), 
            BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
    }
    public void addButtonPanelComponents() {
        this.buttonPanel.add(startButton);
        this.buttonPanel.add(nextButton);
        this.buttonPanel.add(stopButton);
    }
    public void addHumanPanelComponents() {
        this.humanPanel.add(this.humanLabel);
        this.humanPanel.add(this.humanCard1Button);
        this.humanPanel.add(this.humanCard2Button);
    }
    public void addTablePanelComponents() {
        this.tablePanel.add(flop1Button);
        this.tablePanel.add(flop2Button);
        this.tablePanel.add(flop3Button);
        this.tablePanel.add(turnButton);
        this.tablePanel.add(riverButton);
    }
    public void setTablePanel() {
        this.tablePanel.setSize(100, 100);
        this.tablePanel.setBackground(Color.LIGHT_GRAY);
    }
    public void addComputerPanelComponents() {
        this.computerPanel.add(computerLabel);
        this.computerPanel.add(computerCard1Button);
        this.computerPanel.add(computerCard2Button);
    }
}
