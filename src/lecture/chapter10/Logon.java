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
  private static final String ACTION_COMMAND_MAXIMIZE_WINDOW = "COMMAND_MAXIMIZE_WINDOW";
  private static final String ACTION_COMMAND_PACK_WINDOW = "COMMAND_PACK_WINDOW";
  private static final String ACTION_COMMAND_MONITOR_PREFIX = "MONITOR_";

  public Logon() throws ParseException {
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
        System.out.println("Entered Componente with Mouse");
        if(e.getSource() instanceof JButton){
          ((JButton)e.getSource()).setEnabled(false);
        }

      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println("Exited Componente with Mouse");
        if(e.getSource() instanceof JButton) {
          ((JButton) e.getSource()).setEnabled(true);
        }
      }
    };

    cancelButton.addMouseListener(buttonMouseListener);
    this.addMouseListener(buttonMouseListener);

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

    JMenuBar myMenuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("Datei");

    JMenuItem closeMenuItem = new JMenuItem("Beenden");
    closeMenuItem.setActionCommand(ACTION_COMMAND_CLOSE);
    closeMenuItem.addActionListener(myButtonListener);


    fileMenu.add(closeMenuItem);
    myMenuBar.add(fileMenu);

    myMenuBar.add(generateWindowSetupMenu());
    this.setJMenuBar(myMenuBar);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) throws ParseException {
    GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    System.out.println(String.format("Screen Dimension: %.0f x %.0f",
      defaultScreenDevice.getDefaultConfiguration().getBounds().getWidth(),
      defaultScreenDevice.getDefaultConfiguration().getBounds().getHeight()));

    new Logon();


    GraphicsEnvironment virtualGraphicsEvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screens = virtualGraphicsEvironment.getScreenDevices();

    for(GraphicsDevice screen : screens){
      System.out.println(screen);
      System.out.println(screen.getDefaultConfiguration());
      System.out.println(screen.getDisplayMode());
      System.out.println(screen.getDefaultConfiguration().getBounds());
      System.out.println(screen.getDefaultConfiguration().getBounds().getWidth() + " x " + screen.getDefaultConfiguration().getBounds().getHeight());
      System.out.println(screen.getDefaultConfiguration().getBounds().getX() + " / " + screen.getDefaultConfiguration().getBounds().getY());
    }
  }


  private JMenu generateWindowSetupMenu(){
    JMenu windowSetupMenu = new JMenu("Fenster");

    GraphicsEnvironment virtualGraphicsEvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screens = virtualGraphicsEvironment.getScreenDevices();
    MonitorDescriptor[] monitorDescriptors = new MonitorDescriptor[screens.length];

    ActionListener windowMenuItemListener = (ActionEvent event)->{
      if(event.getActionCommand().equals(ACTION_COMMAND_MAXIMIZE_WINDOW)){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      } else if(event.getActionCommand().equals(ACTION_COMMAND_PACK_WINDOW)){
        this.pack();
      } else if(event.getActionCommand().contains(ACTION_COMMAND_MONITOR_PREFIX)){
        for(MonitorDescriptor monitorDescriptor : monitorDescriptors){
          if(event.getActionCommand().equals(monitorDescriptor.getActionCommand())){
            this.setLocation(monitorDescriptor.getLocationPoint());
          }
        }
      }
    };

    for(int i = 0; i < screens.length; i++){
      monitorDescriptors[i] = new MonitorDescriptor(screens[i], i);
      JMenuItem monitor = new JMenuItem(monitorDescriptors[i].getLabel());
      monitor.setActionCommand(monitorDescriptors[i].getActionCommand());
      monitor.addActionListener(windowMenuItemListener);

      windowSetupMenu.add(monitor);
    }

    JMenuItem maximizeItem = new JMenuItem("maximieren");
    maximizeItem.setActionCommand(ACTION_COMMAND_MAXIMIZE_WINDOW);
    maximizeItem.addActionListener(windowMenuItemListener);
    JMenuItem packItem = new JMenuItem("verkleinern");
    packItem.setActionCommand(ACTION_COMMAND_PACK_WINDOW);
    packItem.addActionListener(windowMenuItemListener);

    windowSetupMenu.addSeparator();
    windowSetupMenu.add(maximizeItem);
    windowSetupMenu.add(packItem);

    return windowSetupMenu;
  }

  class MonitorDescriptor{
    private GraphicsDevice screen;
    private Point locationPoint;
    private String actionCommand;
    private String label;

    MonitorDescriptor(GraphicsDevice screen, int index) {
      this.screen = screen;
      this.label = "Monitor " + (index+1) + " ("+screen.getDisplayMode()+")";
      this.locationPoint = new Point(screen.getDefaultConfiguration().getBounds().x + (screen.getDefaultConfiguration().getBounds().width / 2), screen.getDefaultConfiguration().getBounds().y+100);
      this.actionCommand = ACTION_COMMAND_MONITOR_PREFIX + index;
    }

    Point getLocationPoint(){
      return locationPoint;
    }

    String getActionCommand(){
      return actionCommand;
    }

    String getLabel(){
      return label;
    }
  }
}