package RepeatSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {


    private MButton mButton;
    private ToolBar toolBar;
    private StringListener listener;
    private FormPanel formPanel;
    private JFileChooser fileChooser;


    public MainFrame() {

        super("Swing");
        setMinimumSize(new Dimension(600,600));
        this.setBounds(100,100,600,600);
        this.setDefaultCloseOperation(3);
        this.addObjects();
        this.BLeaut();
        toolBar.setMButton(mButton);
        addStringListener();
        setJMenuBar(createMenuBar());

        fileChooser.addChoosableFileFilter(new PersonFileFilter());

    }

    public void addObjects(){
        mButton=new MButton();
        toolBar=new ToolBar();
        formPanel=new FormPanel();
        fileChooser=new JFileChooser();
    }

    public void BLeaut(){
        this.add(mButton, BorderLayout.CENTER);
        this.add(toolBar,BorderLayout.NORTH);
        this.add(formPanel,BorderLayout.WEST);
    }

    public void addStringListener(){
        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmited(String text) {

                mButton.appendText("Hello");
            }
        });
        formPanel.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent e){
                String name=e.getName();
                String occupation=e.getOccupation();
                int ageCat=e.getAgeCategory();
                String empCat=e.getEmpCat();
                String taxId=e.getTaxId();


                mButton.appendText(name+": "+occupation+": "+ageCat+", "+empCat+"\n");
            }
        });
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar=new JMenuBar();




        JMenu fileMenu=new JMenu("FIle");
        JMenuItem exportDate=new JMenuItem("Export Data...");
        JMenuItem importDate=new JMenuItem("Import Data...");
        JMenuItem exit=new JMenuItem("Exit");

        fileMenu.add(exportDate);
        fileMenu.add(importDate);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        JMenu windowMenu=new JMenu("Window");
        JMenu showMenu=new JMenu("show");
        JCheckBoxMenuItem showForm=new JCheckBoxMenuItem("Person Form");
        showForm.setSelected(true);

        windowMenu.add(showMenu);
        showMenu.add(showForm);

        showForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem= (JCheckBoxMenuItem)e.getSource();
                formPanel.setVisible(menuItem.isSelected());
            }
        });

        exportDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        importDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
                   System.out.println(fileChooser.getSelectedFile());
               }
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exit.setMnemonic(KeyEvent.VK_X);

        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showInputDialog(MainFrame.this,
                        "Enter your username:",
                        "Enter USer Name",JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);

                int action=JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really wont to exit the aplication?",
                        "Confirm Exit",JOptionPane.OK_CANCEL_OPTION);

                if (action==JOptionPane.OK_OPTION)
                System.exit(0);
            }
        });





        menuBar.add(fileMenu);
        menuBar.add(windowMenu);


        return menuBar;
    }


}
