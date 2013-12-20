package gui;

import gui.LabelScreen;

import javax.swing.*;

public class LabelHelper {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LabelScreen ls = new LabelScreen();
                ls.createAndShowGUIForMain();
            }
        });
        //create object helper, execute askUser(), this is for console commands
        //console.PrepLabel helper = new console.PrepLabel();
        //helper.askUser();
    }
}
