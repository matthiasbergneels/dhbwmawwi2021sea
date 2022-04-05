package lecture.chapter10;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class Logon extends JFrame {

  private static final String ACTION_COMMAND_PRINT = "PRINT";
  private static final String ACTION_COMMAND_CLOSE = "CLOSE";

  public Logon(int x, int y) throws ParseException {
    this.setTitle("Logon");

    final String[] PROTOCOL_VALUE_HELP = {"FTP", "Telnet", "SMTP", "HTTP"};
    JComboBox<String> myComboBox = new JComboBox<>(PROTOCOL_VALUE_HELP);

    JFormattedTextField portField = new JFormattedTextField(new MaskFormatter("#####"));
    portField.setColumns(3);

    myComboBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange() == ItemEvent.SELECTED) {
          System.out.println("myComboBox ausgewählt");

          System.out.println("ItemEvent - Item: " + e.getItem());
          System.out.println("ItemEvent - ParameterString: " + e.paramString());
          System.out.println("ItemEvent - StateChange: " + e.getStateChange());

          if(e.getItem().equals("FTP")){
            portField.setText("21");
          } else if(e.getItem().equals("HTTP")){
            portField.setText("80");
          } else {
            portField.setText("");
          }
        }
      }
    });

    // initialize Panels
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel southPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());

    JPanel connectionPanel = new JPanel(new GridLayout(0, 2));
    JPanel filePanel = new JPanel(new GridLayout(0, 2));

    FlowLayout cellFlowLayout = new FlowLayout(FlowLayout.LEFT);

    //create & assign elements for connection area
    JPanel flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("User:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(3));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Passwort:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JPasswordField(5));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Art:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(myComboBox);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Host:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField host = new JTextField(5);
    flowLayoutForCell.add(host);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Port:"));
    connectionPanel.add(flowLayoutForCell);

    //flowLayoutForCell = new JPanel(cellFlowLayout);
    //flowLayoutForCell.add(portField);
    //connectionPanel.add(flowLayoutForCell);
    connectionPanel.add(portField);

    // create & add Fields for File Area
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Quelle:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Ziel:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);

    // create & assign Buttons
    JButton okButton = new JButton("Ok");
    okButton.setActionCommand(ACTION_COMMAND_PRINT);
    JButton cancelButton = new JButton("Schliessen");
    cancelButton.setActionCommand(ACTION_COMMAND_CLOSE);

    ActionListener myButtonListener = (ActionEvent e) -> {
      System.out.println("ActionEvent - ParameterString: " + e.paramString());
      System.out.println("ActionEvent - ActionCommand: " + e.getActionCommand());
      System.out.println("ActionEvent - Modifiers: " + e.getModifiers());

      if(e.getActionCommand().equals(ACTION_COMMAND_PRINT)){
        System.out.println("Art: " + myComboBox.getSelectedItem() + ", Port: " + portField.getText());
      } else if(e.getActionCommand().equals(ACTION_COMMAND_CLOSE)){
        System.exit(0);
      }
    };

    okButton.addActionListener(myButtonListener);
    cancelButton.addActionListener(myButtonListener);

    southPanel.add(okButton);
    southPanel.add(cancelButton);


    MouseListener buttonMouseListener = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        System.out.println("Entered Button with Mouse");
        ((JButton)e.getSource()).setEnabled(false);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println("Exited Button with Mouse");
        ((JButton)e.getSource()).setEnabled(true);
      }
    };

    cancelButton.addMouseListener(buttonMouseListener);

    // create & assign Borders
    Border etchedBorder = BorderFactory.createEtchedBorder();
    Border connectionBorder = BorderFactory.createTitledBorder(etchedBorder, "Verbindung");
    Border fileBorder = BorderFactory.createTitledBorder(etchedBorder, "Datei");
    Border centerBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    connectionPanel.setBorder(connectionBorder);
    filePanel.setBorder(fileBorder);
    centerPanel.setBorder(centerBorder);

    // combine Panels
    centerPanel.add(connectionPanel);
    centerPanel.add(filePanel);

    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

    this.add(mainPanel);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setBounds(x, y, 500, 500);
    // this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) throws ParseException {

    GraphicsDevice defaultGraphicDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    System.out.println("Screen Dimensions: "
          + defaultGraphicDevice.getDefaultConfiguration().getBounds());

    GraphicsEnvironment virtualGraphicEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

    GraphicsDevice[] screens = virtualGraphicEnvironment.getScreenDevices();

    int x = 0;
    int y = 0;
    for(GraphicsDevice screen : screens){
      System.out.println(screen.getDefaultConfiguration().getBounds());
      x = screen.getDefaultConfiguration().getBounds().x;
      y = screen.getDefaultConfiguration().getBounds().y;
    }



    new Logon(x, y);
  }
}