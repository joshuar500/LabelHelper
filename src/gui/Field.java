package gui;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Jason Cottle on 12/20/13.
 */
public class Field {

    private String storeField = "blah";
    private String labelStr;

    ArrayList<String> labelStrings = new ArrayList<String>();

    static int fieldNum = 0;

    public void Field() {

    }

    public void returnEntryField() {
        getEntryFields();
    }

    public JComponent getEntryFields() {
        JPanel panel = new JPanel(new SpringLayout());

        labelStrings.add(getFieldNum());

        JLabel[] labels = new JLabel[labelStrings.size()];
        JComponent[] fields = new JComponent[labelStrings.size()];
        JComponent[] qtyFields = new JComponent[labelStrings.size()];
        int fieldNum = 0;
        int qtyFieldNum = 0;

        //Add a text field
        JTextField inputFan;

        //add quantity field
        JTextField qtyField;

        for (int i = 0; i < labelStrings.size(); i++) {
            inputFan = new JTextField("");
            inputFan.setColumns(12);
            fields[fieldNum++] = inputFan;
            qtyField = new JTextField();
            qtyField.setColumns(12);
            qtyField.setVisible(true);
            qtyFields[qtyFieldNum++] = qtyField;
            labels[i] = new JLabel(labelStrings.get(i), JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
            panel.add(qtyFields[i]);
        }

        SpringUtilities.makeCompactGrid(panel,
                labelStrings.size(), 3, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad

        return panel;


    }

    public String getStoreField() {
        return storeField;
    }

    public String getFanFields() {

        return labelStr = labelStrings.get(fieldNum).toString();
    }

    public String getFieldNum() {
        return Integer.toString(fieldNum);
    }

    public void addEntryFields(int i) {
        fieldNum = i;
        labelStrings.add(Integer.toString(i));
    }
}
