package com.taller3;

import com.taller3.operations.OperationImpl;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

public class Calculadora extends JFrame {
    static final String DEFAULT_VALUE = "0";

    JPanel panelNumberButtons;
    JPanel panelOptions;
    JPanel panelOperations;
    JPanel panelTotalButtons;
    JLabel display;

    JButton ButtonResult;

    public static void main(String[] args) {
        new Calculadora();
    }

    public Calculadora() {
        initDisplay();
        initOptions();
        initNumberButtons();
        initOperationButtons();
        initResultButton();
        groupButtons();
        initPantalla();
    }

    private void groupButtons() {
        panelTotalButtons = new JPanel();
        panelTotalButtons.setLayout(new BorderLayout(10, 10));
        panelTotalButtons.setBackground(Color.BLACK);
        panelTotalButtons.add(panelOptions, BorderLayout.NORTH);
        panelTotalButtons.add(panelNumberButtons, BorderLayout.CENTER);
        panelTotalButtons.add(panelOperations, BorderLayout.EAST);
        panelTotalButtons.add(ButtonResult, BorderLayout.SOUTH);

        add(panelTotalButtons);
    }

    private void initDisplay() {
        display = new JLabel(DEFAULT_VALUE);
        display.setPreferredSize(new Dimension(400, 80));
        display.setOpaque(true);
        display.setBackground(Color.black);
        display.setForeground(Color.green);
        display.setBorder(new LineBorder(Color.DARK_GRAY));
        display.setFont(new Font("MONOSPACED", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);
    }

    private void initOptions() {
        panelOptions = new JPanel();
        panelOptions.setBackground(Color.black);
        panelOptions.setLayout(new GridLayout(1, 4, 10, 10));
        panelOptions.setPreferredSize(new Dimension(400, 80));
        String[] labelButtons = new String[]{"C", "<-"};
        createAndAddButton(labelButtons, panelOptions, actionOptions);
    }

    private void initOperationButtons() {
        panelOperations = new JPanel();
        panelOperations.setLayout(new GridLayout(4, 1, 10, 10));
        panelOperations.setBackground(Color.black);
        panelOperations.setPreferredSize(new Dimension(100, 400));
        String[] labelButtons = new String[]{"+", "-", "*", "/"};
        createAndAddButton(labelButtons, panelOperations, actionOperation);
    }

    private void createAndAddButton(String[] labels, JPanel panel, ActionListener action) {
        Arrays.stream(labels).forEachOrdered(b -> {
            JButton button = new JButton(b);
            button.setSize(new Dimension(50, 50));

            button.setFont(getDefaultfont());
            button.setOpaque(true);
            button.setFocusPainted(false);
            button.setBackground(Color.DARK_GRAY);
            button.setBorder(new LineBorder(Color.DARK_GRAY));
            button.setForeground(Color.WHITE);
            button.addActionListener(action);
            panel.add(button);
        });
    }

    private void initNumberButtons() {
        panelNumberButtons = new JPanel();
        panelNumberButtons.setBackground(Color.BLACK);
        panelNumberButtons.setLayout(new GridLayout(4, 3, 10, 10));
        panelNumberButtons.setPreferredSize(new Dimension(300, 400));
        panelNumberButtons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        String[] labelButtons = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", "%"};
        labelButtons = Arrays.stream(labelButtons).sorted(Comparator.reverseOrder()).toArray(String[]::new);

        createAndAddButton(labelButtons, panelNumberButtons, actionNumber);
    }

    private void initResultButton() {
        ButtonResult = new JButton("Resultado");
        ButtonResult.setPreferredSize(new Dimension(230, 50));
        ButtonResult.setFont(getDefaultfont());
        ButtonResult.setOpaque(true);
        ButtonResult.setFocusPainted(false);
        ButtonResult.setBackground(Color.DARK_GRAY);
        ButtonResult.setBorder(new LineBorder(Color.DARK_GRAY));
        ButtonResult.setForeground(Color.WHITE);
        ButtonResult.addActionListener(e ->
                display.setText(new OperationImpl(display.getText()).execute()));
    }

    private void initPantalla() {
        setName("Calculadora");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 680);
        setResizable(false);
        setVisible(true);
    }


    private final ActionListener actionNumber =
            e -> display.setText(
                    display.getText().equals(DEFAULT_VALUE) ?
                            e.getActionCommand() :
                            display.getText() + e.getActionCommand()
            );

    private final ActionListener actionOperation =
            e -> {
                if (!display.getText().equals(DEFAULT_VALUE)) display.setText(display.getText() + e.getActionCommand());
            };

    private final ActionListener actionOptions =
            e -> {
                if (e.getActionCommand().equals("C")) display.setText(DEFAULT_VALUE);
                if (e.getActionCommand().equals("<-")) {
                    if (display.getText().length() > 1) {
                        display.setText(display.getText().substring(0, display.getText().length() - 1));
                    }else {
                        display.setText(DEFAULT_VALUE);
                    }
                }
            };

    private Font getDefaultfont() {
        return new Font("MONOSPACED", Font.PLAIN, 16);
    }
}
