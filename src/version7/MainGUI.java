/*
 * MainGUI.java
 *
 * Created on Feb 17, 2009, 9:58:58 AM
 */
package version7;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainGUI extends JFrame {

    private Duck[] ducks;
    private QuackBehavior[] quacks;
    private FlyBehavior[] flies;

    private Duck duck;
    private QuackBehavior quack;
    private FlyBehavior fly;

    // The GUI widgets
    private JButton btnActivateDuck = new JButton("Activate");
    private JComboBox<Duck> cmbDucks = new JComboBox<>();
    private JComboBox<FlyBehavior> cmbFlies = new JComboBox<>();
    private JComboBox<QuackBehavior> cmbQuacks = new JComboBox<>();
    private JLabel lblResult = new JLabel();
    private JTextArea txtConsole = new JTextArea();
    private ByteArrayOutputStream baos;


    public MainGUI() {
        super("Sim-U-Duck");

        initDucks();
        initQuacks();
        initFlies();
        initComponents();
        redirectStdOut();

        updateMessageLabel();

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void redirectStdOut() {
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    private void initComponents() {
        JPanel pnlGrid = new JPanel(new GridLayout(6, 1));
        pnlGrid.setOpaque(false);

        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl.setOpaque(false);
        pnl.add(new JLabel("Mini Duck Simulator"));
        pnlGrid.add(pnl);

        pnl = new JPanel();
        pnl.setOpaque(false);
        pnl.add(new JLabel("Choose Duck"));
        pnl.add(cmbDucks);
        pnlGrid.add(pnl);

        pnl = new JPanel();
        pnl.setOpaque(false);
        pnl.add(new JLabel("Choose Quack Behavior"));
        pnl.add(cmbQuacks);
        pnlGrid.add(pnl);

        pnl = new JPanel();
        pnl.setOpaque(false);
        pnl.add(new JLabel("Choose Fly Behavior"));
        pnl.add(cmbFlies);
        pnlGrid.add(pnl);

        pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl.setOpaque(false);
        pnl.add(lblResult);
        pnlGrid.add(pnl);

        pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl.setOpaque(false);
        pnl.add(btnActivateDuck);
        pnlGrid.add(pnl);

        JPanel pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(pnlGrid, BorderLayout.NORTH);
        pnlMain.add(new JScrollPane(txtConsole), BorderLayout.CENTER);

        pnlMain.setBackground(new Color(204, 255, 204));
        this.getContentPane().add(pnlMain);

        txtConsole.setRows(5);
        txtConsole.setBackground(Color.BLACK);
        txtConsole.setForeground(Color.WHITE);

        for (Duck duck : ducks) {
            cmbDucks.addItem(duck);
        }
        cmbDucks.setSelectedIndex(-1);

        for (QuackBehavior quack : quacks) {
            cmbQuacks.addItem(quack);
        }
        cmbQuacks.setSelectedIndex(-1);

        for (FlyBehavior fly : flies) {
            cmbFlies.addItem(fly);
        }
        cmbFlies.setSelectedIndex(-1);

        btnActivateDuck.addActionListener(e -> {
            System.out.println("\n");
            if (duck != null) {
                duck.display();

                if (quack != null) {
                    duck.setQuackBehavior(quack);
                }
                duck.performQuack();

                if (fly != null) {
                    duck.setFlyBehavior(fly);
                }
                duck.performFly();
            } else {
                System.out.println("ERROR: No duck selected");
            }

            System.out.flush();
            txtConsole.setText(baos.toString());
        });

        cmbDucks.addActionListener(e -> {
            duck = (Duck) cmbDucks.getSelectedItem();
            updateMessageLabel();
        });

        cmbFlies.addActionListener(e -> {
            fly = (FlyBehavior) cmbFlies.getSelectedItem();
            updateMessageLabel();
        });

        cmbQuacks.addActionListener(e -> {
            quack = (QuackBehavior) cmbQuacks.getSelectedItem();
            updateMessageLabel();
        });
    }

    private void initDucks() {
        ducks = new Duck[3];
        ducks[0] = new MallardDuck();
        ducks[1] = new ModelDuck();
        ducks[2] = new RubberDuck();
    }

    private void initFlies() {
        flies = new FlyBehavior[3];
        flies[0] = new FlyNoWay();
        flies[1] = new FlyRocketPowered();
        flies[2] = new FlyWithWings();
    }

    private void initQuacks() {
        quacks = new QuackBehavior[3];
        quacks[0] = new Quack();
        quacks[1] = new MuteQuack();
        quacks[2] = new Squeak();
    }

    private void updateMessageLabel() {
        String duckText = duck == null ? "(No Duck)" : duck.toString();
        String quackText = quack == null ? "(No Quack)" : quack.toString();
        String flyText = fly == null ? "(No Fly)" : fly.toString();
        lblResult.setText(duckText
                + ", " + quackText + ", " + flyText);
    }

}
