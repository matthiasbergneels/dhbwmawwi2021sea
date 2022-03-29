package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExampleUi extends JFrame{

  private GridLayoutExampleUi(){
    super("GridLayout Example UI");

    JPanel uiContent = new JPanel();
    uiContent.setLayout(new GridLayout(0,3));

    uiContent.add(new JLabel("Zelle 1"));
    uiContent.add(new JLabel("Zelle 2"));
    uiContent.add(new JLabel("Zelle 3"));
    uiContent.add(new JLabel("Zelle 4"));
    uiContent.add(new JLabel("Zelle 5"));
    uiContent.add(new JLabel("Zelle 6"));
    uiContent.add(new JButton("Zelle 7"));
    uiContent.add(new JButton("Zelle 8"));


    this.add(uiContent);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new GridLayoutExampleUi();
  }
}
