package gui;

import console.Fans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class LabelScreen extends JPanel implements Printable, ActionListener, FocusListener {

    JPanel panelLeft;
    JLabel labelDisplay;

    JSpinner storeSpinner;
    JTextField inputFan1, inputFan2, inputFan3, inputFan4, inputFan5,
            inputFan6, inputFan7, inputFan8, inputFan9, inputFan10,
            inputFan11, inputFan12, inputFan13, inputFan14, inputFan15;

    JTextField inputPO;

    JTextField qtyField1, qtyField2, qtyField3, qtyField4, qtyField5,
                qtyField6, qtyField7, qtyField8, qtyField9, qtyField10,
                qtyField11, qtyField12, qtyField13, qtyField14, qtyField15, qtyField16, qtyField17;

    Fans iFan1, iFan2, iFan3, iFan4, iFan5,
         iFan6, iFan7, iFan8, iFan9, iFan10,
         iFan11, iFan12, iFan13, iFan14, iFan15;


    String storeName, poNum,
            newLabel1, newLabel2, newLabel3, newLabel4, newLabel5,
            newLabel6, newLabel7, newLabel8, newLabel9, newLabel10,
            newLabel11, newLabel12, newLabel13, newLabel14, newLabel15,
               newQty1, newQty2, newQty3, newQty4, newQty5,
               newQty6, newQty7, newQty8, newQty9, newQty10,
               newQty11, newQty12, newQty13, newQty14, newQty15;

    int fieldNum = 0;


    //spaces are for formatting
    String fromStore = "  SilenX Corporation <br>                        10606 Shoemaker Ave. <br>                        Santa Fe Springs, CA 90670";

    final static int GAP = 10;

    public LabelScreen() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        panelLeft = new JPanel() {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize() {
                Dimension pref = getPreferredSize();
                return new Dimension(Integer.MAX_VALUE, pref.height);

            }
        };

        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.PAGE_AXIS));

        panelLeft.add(createButton());

        updateLeftDisplay();

        add(panelLeft);
        add(createLabelDisplay());
    }

    private void updateLeftDisplay() {

        panelLeft.add(createEntryFields());
    }

    protected void updateDisplays() {

        labelDisplay.setText(formatLabel());

    }

    protected String formatLabel() {

        String empty = "";

        if ((newLabel1 == null) || empty.equals(newLabel1)) {
            newLabel1 = "<em></em>";
        } else {
            newLabel1 += "   X";
        }
        if ((newLabel2 == null) || empty.equals(newLabel2)) {
            newLabel2 = "<em></em>";
        } else {
            newLabel2 += "   X";
        }


        //format the text

        StringBuffer sb = new StringBuffer();
        sb.append("<html><p align=left><pre><span style = 'font:Arial'>");
        sb.append("From:           " + fromStore);
        sb.append("<br><br>");
        sb.append("To:                  " + storeName);
        sb.append("<br><br>");
        sb.append("SKU-Qty:       " + newLabel1 + "   " + newQty1); //newQty1 is actually the 2nd in the array - 1st and last are not visible
        sb.append("<br>");
        sb.append("                       " + newLabel2 + "   " + newQty2);
        sb.append("<br>");
        sb.append("                       " + newLabel3 + "   " + newQty3);
        sb.append("<br>");
        sb.append("<br>");
        sb.append("PO:                  " + poNum);




        return sb.toString();
    }

    protected JComponent createLabelDisplay() {
        JPanel panel = new JPanel(new BorderLayout());
        labelDisplay = new JLabel();
        labelDisplay.setHorizontalAlignment(JLabel.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(GAP / 2, 0, GAP / 2, 0));
        panel.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
        panel.add(labelDisplay, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(400, 500));

        return panel;
    }

    protected JComponent createButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("Add Field");
        button.addActionListener(this);
        button.setActionCommand("add");
        panel.add(button);

        button = new JButton("Reset");
        button.addActionListener(this);
        button.setActionCommand("clear");
        panel.add(button);

        button = new JButton("Update");
        button.addActionListener(this);
        button.setActionCommand("update");
        panel.add(button);

        button = new JButton("Print");
        button.addActionListener(this);
        button.setActionCommand("print");
        panel.add(button);



        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, GAP - 5, GAP - 5));

        return panel;
    }

    protected JComponent createEntryFields() {
        Field f = new Field();
        return f.getEntryFields();
    }

    private String[] getStoreNames() {
        String[] storeStrings = {
                "Frys",
                "NewEgg"
        };
        return storeStrings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("clear".equals(e.getActionCommand())) {
            inputFan1.setText("");
            inputFan2.setText("");
            inputFan3.setText("");
            inputFan4.setText("");
            inputPO.setText("");
        }

        if ("update".equals(e.getActionCommand())) {

            if(storeSpinner.getValue().equals("Frys")) {
                storeName = storeSpinner.getValue().toString();
            }

            iFan1 = new Fans();
            newLabel1 = iFan1.getFans(inputFan1.getText());

            newQty1 = qtyField2.getText(); // remember, qtyField2 && qtyField15 is invisible

            poNum = inputPO.getText();

            updateDisplays();

        }

        if ("print".equals(e.getActionCommand())) {
            printComponent();
        }

        if ("add".equals(e.getActionCommand()) && fieldNum < 30) {
            fieldNum++;
            Field f = new Field();
            f.addEntryFields(fieldNum);
            updateLeftDisplay();
            labelDisplay.updateUI();
        }
        else {
            return;
        }


    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        graphics.drawString(formatLabel(), 100, 100);

        return PAGE_EXISTS;
    }

    public void printComponent() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Print Formatted Label");

        pj.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                labelDisplay.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false)
            return;

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("SilenX Label Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new LabelScreen();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public void createAndShowGUIForMain() {
        createAndShowGUI();
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
