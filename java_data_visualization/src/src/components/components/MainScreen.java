package src.components.components;

import java.awt.Font;
import javax.swing.*;
import src.Config;
import src.components.base.Button;
import src.components.components.algorithms.MainAlgorithmsScreen;
import src.components.components.datastructures.MainDataStructuresScreen;

public class MainScreen extends AbstractScreen {
    @Override
    public void addButtons() {
        int numberButtonPerColumn = 2;
        int numberButtonPerRow = 1;
        int buttonWidth = 250;
        int buttonHeight = 50;
        int gapHeight = 40;
        int gapWidth = 40;
        int labelHeight = 30;
        int totalHeight = buttonHeight * numberButtonPerColumn + (numberButtonPerColumn - 1) * gapHeight + labelHeight * numberButtonPerColumn;
        int totalWidth = buttonWidth * numberButtonPerRow + (numberButtonPerRow - 1) * gapWidth;
        int initialY = (Config.HEIGHT - totalHeight) / 2;
        int initialX = (Config.WIDTH - totalWidth) / 2;

        buttons = new Button[2];
        JLabel[] labels = new JLabel[4];

        buttons[0] = new Button(
                initialX,
                initialY + labelHeight,
                buttonWidth, buttonHeight,
                "Data Structures"
        );
        
        buttons[1] = new Button(
                initialX,
                initialY + labelHeight + gapHeight + buttonHeight,
                buttonWidth, buttonHeight,
                "Algorithms"
        );
        labels[0] = new JLabel("Project Team", SwingConstants.CENTER);
        labels[1] = new JLabel("ALIA MAHAR", SwingConstants.CENTER);
        labels[2] = new JLabel("SARASVATI DEVI", SwingConstants.CENTER);
        labels[3] = new JLabel("SANAULLAH MAHAR", SwingConstants.CENTER);
         int labelStartY = Config.HEIGHT - (4 * (labelHeight + 10)); 
        for (int i = 0; i < labels.length; i++) {
    labels[i].setBounds(initialX, labelStartY + i * (labelHeight + 5), buttonWidth, labelHeight);
    labels[i].setFont(labels[i].getFont().deriveFont(Font.BOLD)); 
}

        
        add(buttons[0]);
        add(buttons[1]);
        for (JLabel label : labels) {
            add(label);
        }
    }

    @Override
    public void createDefaultScreens() {
        screens = new AbstractScreen[2];
    }

    @Override
    public void addActionListenerForButtons() {
        buttons[0].addActionListener(e -> {
            if (screens[0] == null) {
                screens[0] = new MainDataStructuresScreen();
                screens[0].setVisible(false);
                getApp().addScreen(screens[0]);
            }
            setHidden(true);
            screens[0].setHidden(false);
        });

        buttons[1].addActionListener(e -> {
            if (screens[1] == null) {
                screens[1] = new MainAlgorithmsScreen();
                screens[1].setVisible(false);
                getApp().addScreen(screens[1]);
            }
            setHidden(true);
            screens[1].setHidden(false);
        });
    }
}
