package RespondingToButtonClicks;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLanel=new JLabel("Name: ");
    private JLabel occupationLabel=new JLabel("Ocupation");
    private JTextField nameField=new JTextField(10);
    private JTextField occupationField=new JTextField(10);
    private JButton okBtn=new JButton("ok");


    public FormPanel() {


        this.initComponent();
    }
    public void initComponent(){
        this.dimension();
        this.border();
    }
    public void dimension(){
        Dimension dim =getPreferredSize();
        dim.width=100;
        setPreferredSize(dim);
    }
    public void border(){
        TitledBorder innerBorder=BorderFactory.createTitledBorder("New Person");
        Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

    }
}
