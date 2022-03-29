package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExampleUi extends JFrame {

  private FlowLayoutExampleUi(){
    super("FlowLayout Example UI");

    JPanel uiContent = new JPanel();
    uiContent.setLayout(new FlowLayout(FlowLayout.RIGHT));

    uiContent.add(new JLabel("Hello World"));
    uiContent.add(new JLabel("Wann ist endlich wieder Pause?"));
    uiContent.add(new JButton("Jetzt"));
    uiContent.add(new JButton("Später"));

    this.add(uiContent);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new FlowLayoutExampleUi();
  }

}
