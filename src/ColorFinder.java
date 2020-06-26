import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class ColorFinder extends JFrame{
    private JTextField code;
    private JSlider red;
    private JSlider blue;
    private JSlider green;
    private JSpinner redSpinner;
    private JSpinner greenSpinner;
    private JSpinner blueSpinner;
    private JPanel Hlavni;
    private JPanel Color;
    private JTextPane textPane1;


    public ColorFinder(){
        this.setContentPane(Hlavni);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        red.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                code.setText(Reset());
            }
        });
        green.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                code.setText(Reset());
            }
        });
        blue.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                code.setText(Reset());
            }
        });

        code.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    getDec();
                }
            }
        });
    }

    private String Reset() {
        int[] colors = new int[]{red.getValue(), green.getValue(), blue.getValue()};
        textPane1.setBackground(new Color(colors[0],colors[1],colors[2]));

        return Integer.toHexString(colors[0])+" "+Integer.toHexString(colors[1])+" "+Integer.toHexString(colors[2]);
    }
    private int[] getDec(){
        String[] x = code.getText().split(" ");
        int[] pole = new int[x.length];
        for (int i=0;i<x.length;i++){
            pole[i] = Integer.parseInt(x[i],16);
        }
        code.setBackground(new Color(pole[0],pole[1],pole[2]));
        red.setValue(pole[0]);
        green.setValue(pole[1]);
        blue.setValue(pole[2]);
        return pole;
    }

    public static void main(String[] args) {
        new ColorFinder();
    }
}
