package lecture.chapter10;

import javax.swing.*;

public class MyFristUI {

  public static void main(String[] args) {

    JFrame myFirstUi = new JFrame("Mein erstes UI");
    JLabel uiText = new JLabel("Herzlich Willkommen");
    JButton breakButton = new JButton("Pause starten");

    myFirstUi.add(breakButton);
    myFirstUi.add(uiText);
    
    //myFirstUi.setSize(300, 200);
    myFirstUi.pack();
    myFirstUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFirstUi.setVisible(true);
  }
}
