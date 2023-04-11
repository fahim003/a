package OOP.ec22827.A8;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;
import java.io.InputStream;
import java.util.Scanner;

class GUI implements Visitor{

    private PrintStream out;

    JFrame frame = new JFrame();

    int currentGold = 5;
    private Scanner in;
    private int purse;
    private Item[] items;
    private int next;
    JLabel goldLabel = new JLabel("Gold: " + currentGold);
    String instruction;
    JTextArea instructionsText = new JTextArea(instruction);
    private JPanel buttonPanel = new JPanel();
    private JButton button1;
    private JPanel panel1;


    public GUI(PrintStream ps, InputStream is) {

        frame.setTitle("ec22827");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        goldLabel.setHorizontalAlignment(SwingConstants.LEFT);
        frame.getContentPane().add(goldLabel, BorderLayout.NORTH);

        frame.getContentPane().add(instructionsText, BorderLayout.SOUTH);


        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");

        // Create a panel to hold the buttons

        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(northButton);
        buttonPanel.add(southButton);
        buttonPanel.add(eastButton);
        buttonPanel.add(westButton);






        // Add the panel to the frame
        frame.getContentPane().add(buttonPanel);
        frame.setVisible(true);








        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;
        eastButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tell("Correct!");
                giveGold(5);

            }
        });

        northButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tell("Incorrecct!");
                takeGold(5);

            }
        });

        westButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tell("incorrect!");
                takeGold(5);

            }
        });

        southButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tell("Incorrect!");
                takeGold(5);

            }
        });
    }


    private static final char[] yOrN = { 'y', 'n'};

    public void tell(String m) {
        out.println(m);
        instructionsText.append(m+"\n");
    }


    public char getChoice(String d, char[] a) {
        out.println(d);
        if (!in.hasNextLine()) {
            out.println("'No line' error");
            return '?';
        }
        String t = in.nextLine();
        if (t.length() > 0)
            return t.charAt(0);
        else {
            if (a.length > 0) {
                out.println("Returning "+a[0]);
                return a[0];
            } else {
                out.println("Returning '?'");
                return '?';
            }
        }
    }

    public boolean giveItem(Item x) {
        out.println("You have: ");
        for (int i=0;i<next;i++) out.print(items[i] + ", ");
        out.println("You are being offered: "+x.name);
        if (next >= items.length) {
            out.println("But you have no space and must decline.");
            return false;
        }
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            items[next] = x;
            next++;
            return true;
        } else return false;
    }

    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == items[i])
                return true;
        return false;
    }

    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x.equals(items[i]))
                return true;
        return false;
    }

    public void giveGold(int n) {
        out.println("You are given "+n+" gold pieces.");
        purse += n;
        out.println("You now have "+purse+" pieces of gold.");


        currentGold += n;
        goldLabel.setText("Gold: " + currentGold);
        tell("5 Gold has been taken given to you");

    }

    public int takeGold(int n) {

        if (n<0) {
            out.println("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            out.println("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }

        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        out.println(t+" pieces of gold are taken from you.");
        purse -= t;
        out.println("You now have "+purse+" pieces of gold.");

        currentGold -= n;
        goldLabel.setText("Gold: " + currentGold );
        tell("5 Gold has been taken from you");

        return t;
    }


}
