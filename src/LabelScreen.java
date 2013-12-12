
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

        panelLeft.add(createEntryFields());
        //panelLeft.add(createEntryFields2());
        panelLeft.add(createButton());

        add(panelLeft);
        add(createLabelDisplay());
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
        if ((newLabel3 == null) || empty.equals(newLabel3)) {
            newLabel3 = "<em></em>";
        } else {
            newLabel3 += "   X";
        }
        if ((newLabel4 == null) || empty.equals(newLabel4)) {
            newLabel4 = "<em></em>";
        } else {
            newLabel4 += "   X";
        }
        if ((newLabel5 == null) || empty.equals(newLabel5)) {
            newLabel5 = "<em></em>";
        } else {
            newLabel5 += "   X";
        }
        if ((newLabel6 == null) || empty.equals(newLabel6)) {
            newLabel6 = "<em></em>";
        } else {
            newLabel6 += "   X";
        }
        if ((newLabel7 == null) || empty.equals(newLabel7)) {
            newLabel7 = "<em></em>";
        } else {
            newLabel7 += "   X";
        }
        if ((newLabel8 == null) || empty.equals(newLabel8)) {
            newLabel8 = "<em></em>";
        } else {
            newLabel8 += "   X";
        }
        if ((newLabel9 == null) || empty.equals(newLabel9)) {
            newLabel9 = "<em></em>";
        } else {
            newLabel9 += "   X";
        }
        if ((newLabel10 == null) || empty.equals(newLabel10)) {
            newLabel10 = "<em></em>";
        } else {
            newLabel10 += "   X";
        }
        if ((newLabel11 == null) || empty.equals(newLabel11)) {
            newLabel11 = "<em></em>";
        } else {
            newLabel11 += "   X";
        }
        if ((newLabel12 == null) || empty.equals(newLabel12)) {
            newLabel12 = "<em></em>";
        } else {
            newLabel12 += "   X";
        }
        if ((newLabel13 == null) || empty.equals(newLabel13)) {
            newLabel13 = "<em></em>";
        } else {
            newLabel13 += "   X";
        }
        if ((newLabel14 == null) || empty.equals(newLabel14)) {
            newLabel14 = "<em></em>";
        } else {
            newLabel14 += "   X";
        }
        if ((newLabel15 == null) || empty.equals(newLabel15)) {
            newLabel15 = "<em></em>";
        } else {
            newLabel15 += "   X";
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
        sb.append("                       " + newLabel4 + "   " + newQty4);
        sb.append("<br>");
        sb.append("                       " + newLabel5 + "   " + newQty5);
        sb.append("<br>");
        sb.append("                       " + newLabel6 + "   " + newQty6);
        sb.append("<br>");
        sb.append("                       " + newLabel7 + "   " + newQty7);
        sb.append("<br>");
        sb.append("                       " + newLabel8 + "   " + newQty8);
        sb.append("<br>");
        sb.append("                       " + newLabel9 + "   " + newQty9);
        sb.append("<br>");
        sb.append("                       " + newLabel10 + "   " + newQty10);
        sb.append("<br>");
        sb.append("                       " + newLabel11 + "   " + newQty11);
        sb.append("<br>");
        sb.append("                       " + newLabel12 + "   " + newQty12);
        sb.append("<br>");
        sb.append("                       " + newLabel13 + "   " + newQty13);
        sb.append("<br>");
        sb.append("                       " + newLabel14 + "   " + newQty14);
        sb.append("<br>");
        sb.append("                       " + newLabel15 + "   " + newQty15);
        sb.append("<br>");
        sb.append("                       " + newLabel15 + "   " + newQty15);
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
        panel.setPreferredSize(new Dimension(400, 150));

        return panel;
    }

    protected JComponent createButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("Reset");
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
        JPanel panel = new JPanel(new SpringLayout());

        String[] labelStrings = {"Store ", "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10 ", "11 ", "12 ", "13 ", "14 ", "15 ", "PO "};

        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        JComponent[] qtyFields = new JComponent[labelStrings.length];
        int fieldNum = 0;
        int qtyFieldNum = 0;

        //create store label

        String[] storeNames = getStoreNames();
        storeSpinner = new JSpinner(new SpinnerListModel(storeNames));
        fields[fieldNum++] = storeSpinner;

        //Create the text fields and set it up
        inputFan1 = new JTextField("11-14");
        inputFan1.setColumns(12);
        fields[fieldNum++] = inputFan1;

        inputFan2 = new JTextField();
        inputFan2.setColumns(12);
        fields[fieldNum++] = inputFan2;

        inputFan3 = new JTextField();
        inputFan3.setColumns(12);
        fields[fieldNum++] = inputFan3;

        inputFan4 = new JTextField();
        inputFan4.setColumns(12);
        fields[fieldNum++] = inputFan4;

        inputFan5 = new JTextField();
        inputFan5.setColumns(12);
        fields[fieldNum++] = inputFan5;

        inputFan6 = new JTextField();
        inputFan6.setColumns(12);
        fields[fieldNum++] = inputFan6;

        inputFan7 = new JTextField();
        inputFan7.setColumns(12);
        fields[fieldNum++] = inputFan7;

        inputFan8 = new JTextField();
        inputFan8.setColumns(12);
        fields[fieldNum++] = inputFan8;

        inputFan9 = new JTextField();
        inputFan9.setColumns(12);
        fields[fieldNum++] = inputFan9;

        inputFan10 = new JTextField();
        inputFan10.setColumns(12);
        fields[fieldNum++] = inputFan10;

        inputFan11 = new JTextField();
        inputFan11.setColumns(12);
        fields[fieldNum++] = inputFan11;

        inputFan12 = new JTextField();
        inputFan12.setColumns(12);
        fields[fieldNum++] = inputFan12;

        inputFan13 = new JTextField();
        inputFan13.setColumns(12);
        fields[fieldNum++] = inputFan13;

        inputFan14 = new JTextField();
        inputFan14.setColumns(12);
        fields[fieldNum++] = inputFan14;

        inputFan15 = new JTextField();
        inputFan15.setColumns(12);
        fields[fieldNum++] = inputFan15;


        //Input PO
        inputPO = new JTextField();
        inputPO.setColumns(12);
        fields[fieldNum++] = inputPO;


        // QTY FIELDS
        qtyField1 = new JTextField();
        qtyField1.setColumns(12);
        qtyField1.setVisible(false);
        qtyFields[qtyFieldNum++] = qtyField1;

        qtyField2 = new JTextField();
        qtyField2.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField2;

        qtyField3 = new JTextField();
        qtyField3.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField3;

        qtyField4 = new JTextField();
        qtyField4.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField4;

        qtyField5 = new JTextField();
        qtyField5.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField5;

        qtyField6 = new JTextField();
        qtyField6.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField6;

        qtyField7 = new JTextField();
        qtyField7.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField7;

        qtyField8 = new JTextField();
        qtyField8.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField8;

        qtyField9 = new JTextField();
        qtyField9.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField9;

        qtyField10 = new JTextField();
        qtyField10.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField10;

        qtyField11 = new JTextField();
        qtyField11.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField11;

        qtyField12 = new JTextField();
        qtyField12.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField12;

        qtyField13 = new JTextField();
        qtyField13.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField13;

        qtyField14 = new JTextField();
        qtyField14.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField14;

        qtyField15 = new JTextField();
        qtyField15.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField15;

        qtyField16 = new JTextField();
        qtyField16.setColumns(12);
        qtyFields[qtyFieldNum++] = qtyField16;

        qtyField17 = new JTextField();
        qtyField17.setColumns(12);
        qtyField17.setVisible(false);
        qtyFields[qtyFieldNum++] = qtyField17;


        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
            panel.add(qtyFields[i]);
        }

        SpringUtilities.makeCompactGrid(panel,
                labelStrings.length, 3, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad

        return panel;

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
        } if ("update".equals(e.getActionCommand())) {



            if(storeSpinner.getValue().equals("Frys")) {
                storeName = storeSpinner.getValue().toString();
            }

            iFan1 = new Fans();
            newLabel1 = iFan1.getFans(inputFan1.getText());
            iFan2 = new Fans();
            newLabel2 = iFan2.getFans(inputFan2.getText());
            iFan3 = new Fans();
            newLabel3 = iFan3.getFans(inputFan3.getText());
            iFan4 = new Fans();
            newLabel4 = iFan4.getFans(inputFan4.getText());
            iFan5 = new Fans();
            newLabel5 = iFan5.getFans(inputFan5.getText());
            iFan6 = new Fans();
            newLabel6 = iFan6.getFans(inputFan6.getText());
            iFan7 = new Fans();
            newLabel7 = iFan7.getFans(inputFan7.getText());
            iFan8 = new Fans();
            newLabel8 = iFan8.getFans(inputFan8.getText());
            iFan9 = new Fans();
            newLabel9 = iFan9.getFans(inputFan9.getText());
            iFan10 = new Fans();
            newLabel10 = iFan10.getFans(inputFan10.getText());
            iFan11 = new Fans();
            newLabel11 = iFan11.getFans(inputFan11.getText());
            iFan12 = new Fans();
            newLabel12 = iFan12.getFans(inputFan12.getText());
            iFan13 = new Fans();
            newLabel13 = iFan13.getFans(inputFan13.getText());
            iFan14 = new Fans();
            newLabel14 = iFan14.getFans(inputFan14.getText());
            iFan15 = new Fans();
            newLabel15 = iFan15.getFans(inputFan15.getText());

            newQty1 = qtyField2.getText(); // remember, qtyField2 && qtyField15 is invisible
            newQty2 = qtyField3.getText();
            newQty3 = qtyField4.getText();
            newQty4 = qtyField5.getText();
            newQty5 = qtyField6.getText();
            newQty6 = qtyField7.getText();
            newQty7 = qtyField8.getText();
            newQty8 = qtyField9.getText();
            newQty9 = qtyField10.getText();
            newQty10 = qtyField11.getText();
            newQty11 = qtyField12.getText();
            newQty12 = qtyField13.getText();
            newQty13 = qtyField14.getText();
            newQty14 = qtyField15.getText();
            newQty15 = qtyField16.getText();

            poNum = inputPO.getText();

        } if ("print".equals(e.getActionCommand())) {
            printComponent();
        }

        updateDisplays();
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
