import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
 
public class SwingExample extends JFrame {
  private JLabel countLabel1 = new JLabel("0");
  private JLabel statusLabel = new JLabel("Task not completed.");
  private JButton startButton = new JButton("Start");
  private JButton helloButton = new JButton("Say Hello");
 
  public SwingExample(String title) {
    // create and show UI
    super(title);

    countLabel1.setFont(new Font("serif", Font.BOLD, 28));

    setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();
    gc.fill = GridBagConstraints.NONE;
    gc.gridx = 0;
    gc.gridy = 0;
    gc.weightx = 1;
    gc.weighty = 1;
    add(countLabel1, gc);
 
    gc.gridx = 0;
    gc.gridy = 1;
    gc.weightx = 1;
    gc.weighty = 1;
    add(statusLabel, gc);
 
    gc.gridx = 0;
    gc.gridy = 2;
    gc.weightx = 1;
    gc.weighty = 1;
    add(startButton, gc);

    gc.gridx = 0;
    gc.gridy = 3;
    gc.weightx = 1;
    gc.weighty = 1;
    add(helloButton, gc);
 
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        start();
    }});

    helloButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.out.println("Hello world!");
    }});
 
    setSize(200, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new SwingExample("Swing Demo");
      }
    });
  }
 
  private void start() {
    System.out.println("running in event dispatch thread:"+
      SwingUtilities.isEventDispatchThread());
    // Simulate doing something useful.

    for(int i=0; i<=10; i++) {
      // Bad practice
      countLabel1.setText(Integer.toString(i));

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {}
    }

    // Bad practice
    statusLabel.setText("Completed.");
  }
}
