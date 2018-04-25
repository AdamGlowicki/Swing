package RespondingToButtonClicks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton button=new JButton("Button");
    private TextPanel textPanel=new TextPanel();
    private Toolbar toolbar=new Toolbar();
    private FormPanel formPanel=new FormPanel();




    public MainFrame() throws HeadlessException {
        super("Frame");

        this.setBounds(30,30,500,600);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.append("Hello\n");
            }
        });

        setDefaultCloseOperation(3);
        this.setPanel();
        this.Add();
    }
    public void Add(){
        add(textPanel,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        add(toolbar,BorderLayout.NORTH);
        add(formPanel,BorderLayout.WEST);
    }
    public void setPanel(){
        toolbar.setTextPanel(textPanel);
        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmites(String text) {
                //System.out.println(text);
                textPanel.append(text);
            }
        });
    }




}
