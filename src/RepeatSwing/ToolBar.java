package RepeatSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener{

    private JButton button1;
    private JButton button2;

    private MButton mButton;
    private StringListener textListener;


    public ToolBar() {

        addObject();
        addButton();
        addActionListerne();

    }
    public void addObject(){
        button1=new JButton("Hello");
        button2=new JButton("Bye");
    }
    public void addButton(){
        setLayout(new FlowLayout(0));
        add(button1);
        add(button2);
    }

    public void setMButton(MButton mButton) {
        this.mButton = mButton;
    }
    public void setStringListener(StringListener listener){
        this.textListener=listener;
    }
    public void addActionListerne(){
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked=(JButton)e.getSource();
        if (clicked.equals(button1)) {
            mButton.appendText("To lose I have ");
        }
        if (clicked.equals(button2)){
            mButton.appendText("Only wine and sing");
        }
    }
}
