package RespondingToButtonClicks;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea=new JTextArea();

    public TextPanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        this.intComponent();
    }
    public void intComponent(){

    }

    public void append(String s) {
        textArea.append(s);
    }
}
