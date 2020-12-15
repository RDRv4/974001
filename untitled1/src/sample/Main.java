import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Main extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String text1;
    Object boxA, boxB, boxC;
    File file = new File("D://miniLibrary.txt");
    static JLabel l1, l2, l3, l4;
    JComboBox<Object> box_1, box_2, box_3;
    JRadioButton flag1, flag2, flag3, flag4;
    ButtonGroup bg;
    int k;

    static JButton b, del;
    static JTextField text;
    static JTextArea area;

    static String[] box1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
            "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    static String[] box2 = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    static String[] box3 = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008","2009",
            "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};

    public Main(String str) {

        super(str);
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("Into the database");
        del = new JButton("Clean");

        text = new JTextField(9);
        area = new JTextArea(9, 9);

        l1 = new JLabel("The name of the famous personality");
        l2 = new JLabel("Information about the personality");
        l3 = new JLabel("Date of creation");
        l4 = new JLabel("Type of activity");

        box_1 = new JComboBox<Object>(box1);
        box_2 = new JComboBox<Object>(box2);
        box_3 = new JComboBox<Object>(box3);

        flag1 = new JRadioButton("Scientist");
        flag2 = new JRadioButton("Writer");
        flag3 = new JRadioButton("Musician");
        flag4 = new JRadioButton("Artist");

        bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);
        bg.add(flag3);
        bg.add(flag4);

        setLayout(null);

        b.setSize(200, 30);
        b.setLocation(10, 400);
        b.setForeground(Color.green);
        b.setBackground(Color.white);

        del.setSize(100, 30);
        del.setLocation(250, 400);
        del.setForeground(Color.red);
        del.setBackground(Color.white);

        text.setSize(220, 25);
        text.setLocation(250, 20);

        area.setSize(220, 150);
        area.setLocation(250, 60);

        l1.setSize(250, 25);
        l1.setLocation(30, 20);
        l2.setSize(250, 25);
        l2.setLocation(30, 60);
        l3.setSize(200, 25);
        l3.setLocation(30, 250);
        l4.setSize(200, 25);
        l4.setLocation(30, 310);

        box_1.setSize(40, 25);
        box_1.setLocation(250, 250);
        box_2.setSize(100, 25);
        box_2.setLocation(300, 250);
        box_3.setSize(70, 25);
        box_3.setLocation(410, 250);

        flag1.setSize(80, 25);
        flag1.setLocation(250, 310);
        flag2.setSize(70, 25);
        flag2.setLocation(330, 310);
        flag3.setSize(80, 25);
        flag3.setLocation(400, 310);
        flag4.setSize(60, 25);
        flag4.setLocation(480, 310);

        add(b);
        add(del);
        add(text);
        add(area);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);
        add(flag3);
        add(flag4);

        b.addActionListener(new ButtonActionListener());
        del.addActionListener(new DelActionListener());

        flag1.addActionListener(new FLagActionListener());
        flag2.addActionListener(new FLagActionListener());
        flag3.addActionListener(new FLagActionListener());
        flag4.addActionListener(new FLagActionListener());

        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            try {

                if(!file.exists()) {

                    file.createNewFile();
                }

                FileWriter out = new FileWriter(file, true);

                try {

                    String text1 = text.getText();
                    String area2 = area.getText();

                    out.write(text1 + " - ");
                    out.write(area2 + "\n");

                    if(k == 1) {

                        out.write("---Famous person is Scientist---" + "\n");
                    } else if (k == 2) {

                        out.write("---Famous person is Writer---" + "\n");
                    } else if (k == 3) {

                        out.write("---Famous person is Musician---" + "\n");
                    } else if (k == 4) {

                        out.write("---Famous person is Artist---" + "\n");
                    }

                    out.write(" (Date of creation biography: " + boxA + " " + boxB + " " + boxC + ")\n");

                    text.setText(null);
                    area.setText(null);

                    box_1.setSelectedIndex(0);
                    box_2.setSelectedIndex(0);
                    box_3.setSelectedIndex(0);

                    bg.clearSelection();

                } finally {

                    out.close();
                }
            } catch (IOException e1) {

                throw new RuntimeException(e1);
            }
        }
    }

    public class FLagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            k = 0;

            if (event.getSource() == flag1)
                k = 1;
            else if (event.getSource() == flag2)
                k = 2;
            else if (event.getSource() == flag3)
                k = 3;
            else if (event.getSource() == flag4)
                k = 4;
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == del) {

                text.setText(null);
                area.setText(null);

                box_1.setSelectedIndex(0);
                box_2.setSelectedIndex(0);
                box_3.setSelectedIndex(0);

                bg.clearSelection();
            }
        }
    }

    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == box_1)
                boxA = box_1.getSelectedItem();
            if(event.getSource() == box_2)
                boxB = box_2.getSelectedItem();
            if(event.getSource() == box_3)
                boxC = box_3.getSelectedItem();
        }
    }
}
