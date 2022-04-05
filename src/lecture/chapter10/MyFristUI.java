package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class MyFristUI {

  public static void main(String[] args) {

    JFrame myFirstUi = new JFrame("Mein erstes UI");

    //myFirstUi.setLayout(new FlowLayout());

    JLabel uiText = new JLabel("Herzlich Willkommen");
    JButton breakButton = new JButton("Pause starten");

    myFirstUi.add(uiText);
    myFirstUi.add(breakButton);

    //myFirstUi.setSize(300, 200);
    //myFirstUi.setBounds(100, 100, 200, 300);
    myFirstUi.pack();
    myFirstUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFirstUi.setVisible(true);
  }
}
