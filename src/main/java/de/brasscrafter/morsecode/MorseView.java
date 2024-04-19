package de.brasscrafter.morsecode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MorseView {
    JFrame window;
    JPanel decoderPanel, encoderPanel;
    JLabel jPnlResultMsg;
    JTextField jTxtFMorseIn;
    JButton btnDecode;
    Color backgroundColor, textColor;
    MorseDecoder morseDecoder;

    public MorseView(){
        morseDecoder = new MorseDecoder();
        backgroundColor = new Color(8, 38, 59);
        textColor = new Color(255, 255, 255, 255);
        decoderPanel = new JPanel();
        jTxtFMorseIn = new JTextField();
        btnDecode = new JButton();
        jPnlResultMsg = new JLabel();


        decoderPanel.setBackground(backgroundColor);
        decoderPanel.setToolTipText("Decoder Panel");


        jTxtFMorseIn.setToolTipText("Enter the morse code here");
        jTxtFMorseIn.setForeground(textColor);
        jTxtFMorseIn.setPreferredSize(new Dimension(200, 25));
        jTxtFMorseIn.setBackground(new Color(7, 31, 47));
        jTxtFMorseIn.setBorder(BorderFactory.createLineBorder(new Color(20, 72, 119), 4));
        decoderPanel.add(jTxtFMorseIn);

        ActionListener btnDecodeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(morseDecoder.decode(jTxtFMorseIn.getText()));
                jPnlResultMsg.setText(morseDecoder.decode(jTxtFMorseIn.getText()));
                System.out.println("Button clicked");
            }
        };


        btnDecode.addActionListener(btnDecodeListener);
        btnDecode.setPreferredSize(new Dimension(60, 25));
        btnDecode.setBackground(new Color(7, 31, 47));
        btnDecode.setBorder(BorderFactory.createLineBorder(new Color(20, 72, 119), 4));
        btnDecode.setForeground(textColor);
        btnDecode.setText("Decode");

        decoderPanel.add(btnDecode);


        jPnlResultMsg.setPreferredSize(new Dimension(100, 25));
        jPnlResultMsg.setHorizontalAlignment(SwingConstants.CENTER);
        jPnlResultMsg.setText("Kugguk");
        jPnlResultMsg.setToolTipText("The translated message");
        jPnlResultMsg.setForeground(textColor);

        jPnlResultMsg.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1)
                    copyToClipboard(jPnlResultMsg.getText());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        decoderPanel.add(jPnlResultMsg);

        window = new JFrame("Morse En-/Decoder");
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(decoderPanel);
        window.setVisible(true);
    }
    private void copyToClipboard(String text) {
        // Code to copy text to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);

        // Get the JLabel location on screen (needed for tooltip positioning)
        Point location = jPnlResultMsg.getLocationOnScreen();

        // Create a JWindow to display the tooltip message
        JWindow tooltipWindow = new JWindow();
        JLabel tooltipLabel = new JLabel("Copied!");
        tooltipLabel.setBackground(Color.WHITE);  // Set background color (optional)
        tooltipLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Add border (optional)
        tooltipWindow.getContentPane().add(tooltipLabel);

        // Set tooltip window size and position
        tooltipWindow.setSize(tooltipLabel.getPreferredSize());
        int tooltipX = location.x + jPnlResultMsg.getWidth() / 2 - tooltipWindow.getWidth() / 2;
        int tooltipY = location.y + jPnlResultMsg.getHeight();  // Position below the label
        tooltipWindow.setLocation(tooltipX, tooltipY);

        // Make the tooltip visible for a short duration (you can adjust the timer value)
        tooltipWindow.setVisible(true);
        new Timer(1000, e -> tooltipWindow.setVisible(false)).start();  // Hide after 1 second
    }


    public static void main(String[] args) {
        MorseView morseView = new MorseView();
    }
}
