package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import static com.company.Main.books;

public class Window extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextArea textArea1;
    private String tf;
    private Highlighter.HighlightPainter cyanPainter;

    public Window() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Библиотека");

        sw();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//обработчик события слушателя ActionListener
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

    }

    private void onOK() {
        tf = textField1.getText();
        for (Book book : books.getBooks()) {
            if(tf.equals(book.getName()) | tf.equals(book.getAuthor())) book.isMatch(true);
            else book.isMatch(false);
        }
        sw();
    }

    private void sw() {
        textArea1.setText("");

        cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
        for (Book book : books.getBooks()) {

            String s = String.format("Название: %s, Автор: %s", book.getName(), book.getAuthor() + "\r\n");

            textArea1.append(s);

            if(book.getIsMatch() == true) {

                int p0 = textArea1.getText().length() - s.length();
                int p1 = textArea1.getText().length() - 1;

                try {
                    textArea1.getHighlighter().addHighlight(p0, p1, cyanPainter);
                } catch (BadLocationException ble) {
                    ble.printStackTrace();
                }
            }
        }
    }
    private void onCancel() {
        dispose();
    }
}

