import javax.swing.*;
import java.util.Scanner;
import java.util.*;

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
        //PrepLabel helper = new PrepLabel();
        //helper.askUser();
    }
}
