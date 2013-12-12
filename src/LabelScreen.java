import com.sun.org.apache.xml.internal.serialize.Printer;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.text.JTextComponent;
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
    JTextField inputFan1;
    JTextField inputFan2;
    JTextField inputFan3;
    JTextField inputFan4;
    JTextField inputPO;

    JTextField qtyField1;
    JTextField qtyField2;
    JTextField qtyField3;
    JTextField qtyField4;
    JTextField qtyField5;
    JTextField qtyField6;

    Fans iFan1, iFan2, iFan3, iFan4;
    String storeName,
            newLabel1, newLabel2, newLabel3, newLabel4;
    String newQty1;
    String fromStore = "SilenX Corporation <br>10606 Shoemaker Ave. <br>Santa Fe Springs, CA 90670";

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
        }
        if ((newLabel2 == null) || empty.equals(newLabel2)) {
            newLabel2 = "<em></em>";
        }

        String s = " ";

        StringBuffer sb = new StringBuffer();
        sb.append("<html><p align=left>");
        sb.append("From: " + fromStore);
        sb.append("<br><br>");
        sb.append("To:         " + storeName);
        sb.append("<br><br>");
        sb.append("Fans:       " + newLabel1 + "   X   " + newQty1); //newQty1 is actually the 2nd in the array - 1st and last are not visible
        sb.append("<br>");
        sb.append(newLabel2);



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

        String[] labelStrings = {"Store ", "1 ", "2 ", "3 ", "4 ", "PO "};

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
        qtyField6.setVisible(false);
        qtyFields[qtyFieldNum++] = qtyField6;


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

            newQty1 = qtyField2.getText(); // remember, qtyField2 is invisible

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
