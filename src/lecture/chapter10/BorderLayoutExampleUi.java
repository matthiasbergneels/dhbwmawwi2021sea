package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExampleUi extends JFrame{

  private BorderLayoutExampleUi(){
    super("BorderLayout Example UI");

    JPanel uiContent = new JPanel();
    uiContent.setLayout(new BorderLayout());

    JPanel centerContentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    centerContentPanel.add(new JButton("Center"));

    uiContent.add(centerContentPanel, BorderLayout.CENTER);
    uiContent.add(new JButton("North"), BorderLayout.NORTH);
    uiContent.add(new JButton("South"), BorderLayout.SOUTH);
    uiContent.add(new JButton("East"), BorderLayout.EAST);
    uiContent.add(new JButton("West"), BorderLayout.WEST);

    this.add(uiContent);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new BorderLayoutExampleUi();
  }
}
