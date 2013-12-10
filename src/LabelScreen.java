import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LabelScreen extends JPanel implements ActionListener, FocusListener {

    JPanel panelLeft;
    JLabel fanSelect;
    JLabel labelDisplay;
    JTextField inputFan;
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

        fanSelect = new JLabel("Frys");
        panelLeft.add(fanSelect, BorderLayout.NORTH);

        panelLeft.add(createEntryFields());
        panelLeft.add(createButton());

        add(panelLeft);
        add(createLabelDisplay());
    }

    protected JComponent createLabelDisplay() {
        JPanel panel = new JPanel(new BorderLayout());
        labelDisplay = new JLabel();
        labelDisplay.setHorizontalAlignment(JLabel.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(GAP / 2, 0, GAP / 2, 0));
        panel.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
        panel.add(labelDisplay, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(200, 150));

        return panel;
    }

    protected JComponent createButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("Reset");
        button.addActionListener(this);
        button.setActionCommand("clear");
        panel.add(button);

        button = new JButton("Print");
        button.addActionListener(this);
        panel.add(button);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, GAP - 5, GAP - 5));

        return panel;
    }

    protected JComponent createEntryFields() {
        JPanel panel = new JPanel(new SpringLayout());

        String[] labelStrings = {"1 ", "2 ", "3 ", "4 "};

        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        //Create the text field and set it up
        inputFan = new JTextField("ex. 1114");
        inputFan.setColumns(20);
        fields[fieldNum++] = inputFan;

        inputFan = new JTextField();
        inputFan.setColumns(20);
        fields[fieldNum++] = inputFan;

        inputFan = new JTextField();
        inputFan.setColumns(20);
        fields[fieldNum++] = inputFan;

        inputFan = new JTextField();
        inputFan.setColumns(20);
        fields[fieldNum++] = inputFan;

        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
        }

        SpringUtilities.makeCompactGrid(panel, labelStrings.length, 2, GAP, GAP, GAP, GAP / 2);

        return panel;

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
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
