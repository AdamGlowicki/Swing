package RepeatSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MButton extends JPanel {


    private JButton button1;
    private JTextArea textArea1;

    public MButton() {

        this.newButton();
        this.addButton();

        this.addClickLisener();
    }
    public void newButton(){
        button1=new JButton("Button");
        textArea1=new JTextArea();
    }
    public void addButton(){
        setLayout(new BorderLayout());
        add(button1,BorderLayout.SOUTH);
        add(new JScrollPane(textArea1),BorderLayout.CENTER);
    }
    public void addClickLisener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("Hello");

            }
        });

    }
    public void appendText(String text){
        textArea1.append(text);
    }
}
