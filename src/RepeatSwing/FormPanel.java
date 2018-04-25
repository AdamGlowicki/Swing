package RepeatSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel{

    private TextField nameField;
    private TextField occupationField;
    private LabelField nameLabel;
    private LabelField occupationLabel;
    private ButtonField okBtn;
    private FormListener formListener;
    private JListField ageList;
    private JComboBoxField empCombo;
    private JCheckBoxField citizenCheck;
    private JTextField taxField;
    private LabelField taxLabel;

    private JRadioButtonField maleRadio;
    private JRadioButtonField femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {

        Dimension dim=getPreferredSize();
        dim.width=250;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Add Persoon"));
        addObjects();
        newGridBagLayout();
        defaultListModel();
        defaultComboBox();
        setUpTaxID();
        setUpGenderGroup();

    }

    public void addObjects(){
        nameLabel=new LabelField("Name: ");
        occupationLabel=new LabelField("Occupation: ");

        nameField=new TextField(10);
        occupationField=new TextField(10);

        okBtn=new ButtonField("OK");

        ageList=new JListField();

        empCombo=new JComboBoxField();
        citizenCheck=new JCheckBoxField();
        taxField=new JTextField(10);
        taxLabel=new LabelField("Tax ID");

        maleRadio=new JRadioButtonField("male");
        femaleRadio=new JRadioButtonField("female");
        genderGroup=new ButtonGroup();
    }

    public void setUpTaxID(){
        taxLabel.setEnabled(false);
        taxField.setEnabled(false);
    }

    public void setUpGenderGroup(){
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");
    }

    public void defaultListModel(){
        DefaultListModel ageModel=new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18 to 65"));
        ageModel.addElement(new AgeCategory(2,"65 to over"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110,70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);
    }

    public void defaultComboBox(){
        DefaultComboBoxModel empModel=new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);
    }

    public void newGridBagLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();

        ////////First Row/////////////////////////////////////////

        gc.gridx=0;

        gc.weightx=1;
        gc.weighty=0.1;

        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        add(nameLabel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(nameField,gc);

        ////////Next Row/////////////////////////////////////////

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.1;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,10);
        add(occupationLabel,gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.LINE_START;
        add(occupationField,gc);

        ////////Next Row/////////////////////////////////////////

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age"),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(ageList,gc);

        ////////Next Row/////////////////////////////////////////

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employ:"),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(empCombo,gc);

        ////////Next Row/////////////////////////////////////////

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Pl citizen"),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(citizenCheck,gc);

        ////////Next Row/////////////////////////////////////////


        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.FIRST_LINE_END;
        add(taxLabel,gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(taxField,gc);

        ////////Next Row/////////////////////////////////////////


        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.05;

        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        add(new JLabel("Gender :"),gc);

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(maleRadio,gc);

        ////////Next Row/////////////////////////////////////////


        gc.gridy++;

        gc.weightx=1;
        gc.weighty=0.2;


        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(femaleRadio,gc);

        ////////Next Row/////////////////////////////////////////

        gc.gridy++;

        gc.weightx=1;
        gc.weighty=2.0;

        gc.gridx=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(okBtn,gc);
    }

    public class TextField extends JTextField{


        public TextField(int columns) {
            super(columns);

        }
    }

    public class LabelField extends JLabel{
        public LabelField(String name) {
            super(name);

        }
    }

    public class ButtonField extends JButton implements ActionListener{


        public ButtonField(String name) {
            super(name);
            this.addActionListener(this);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            String name=nameField.getText();
            String occupaton=occupationField.getText();
            AgeCategory ageCat=(AgeCategory) ageList.getSelectedValue();
            String empCat=(String)empCombo.getSelectedItem();
            String taxId=taxField.getText();
            boolean usCitizen=citizenCheck.isSelected();

            String genderComand=genderGroup.getSelection().getActionCommand();


            FormEvent ev =new FormEvent(this,name,occupaton,ageCat.getId(),empCat,taxId,usCitizen,genderComand);

            if (formListener!=null){
                formListener.formEventOccurred(ev);

            }
        }

    }
    public class JListField extends JList{
        public JListField() {
        }
    }

    public class JComboBoxField extends JComboBox{
        public JComboBoxField() {
        }
    }
    public class JCheckBoxField extends JCheckBox implements ActionListener{
        public JCheckBoxField() {
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isTicked=citizenCheck.isSelected();
            taxField.setEnabled(isTicked);
            taxLabel.setEnabled(isTicked);
        }
    }

    public class JRadioButtonField extends JRadioButton{
        public JRadioButtonField(String text) {
            super(text);
        }
    }

    public void setFormListener(FormListener listener){
        this.formListener=listener;
    }
}
class AgeCategory{

    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString(){
        return text;
    }

    public int getId() {
        return id;
    }
}
class EmpCategory{

}
