package RespondingToButtonClicks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private TextPanel textPanel;
    private StringListener stringListener;

    private JButton helloButton; //=new JButton("Hello");
    private JButton godByeButton;//=new JButton("GoodBye");



    public Toolbar() {

        helloButton=new JButton("Hello");
        godByeButton=new JButton("GoodBye");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        this.initComponent();
    }
    public void initComponent(){

        this.add();
        this.addACtionListener();
    }
    public void add(){
        add(helloButton);
        add(godByeButton);
        //add(textPanel);
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }


    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    public void addACtionListener(){
        helloButton.addActionListener(this);
        godByeButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clicked= (JButton)e.getSource();
        if (clicked.equals(helloButton)){

            if (stringListener!=null){
                stringListener.textEmites("Hello\n");
            }
            //System.out.println("hello");
            //textPanel.append("Hello\n");
        }
        if (clicked.equals(godByeButton)){
           // System.out.println("goddbye");
            textPanel.append("Goodbye\n");
        }

    }


}
