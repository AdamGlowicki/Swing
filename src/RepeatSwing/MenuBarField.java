package RepeatSwing;

import javax.swing.*;

public class MenuBarField extends JMenuBar {


    private JMenuFiled fileMenu;
    private JMenuFiled windowMenu;

    public MenuBarField() {

        addObjects();
        addComponent();
    }

    public void addObjects(){
        fileMenu=new JMenuFiled("File");
        windowMenu=new JMenuFiled("Windows");
    }

    public void addComponent(){
        add(fileMenu);
        add(windowMenu);

    }

    public class JMenuFiled extends JMenu{
        public JMenuFiled(String s) {
            super(s);
        }
    }


}
