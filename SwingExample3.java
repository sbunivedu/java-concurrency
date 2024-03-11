import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
 
public class SwingExample3 extends JFrame {
  private JLabel countLabel1 = new JLabel("0");
  private JLabel statusLabel = new JLabel("Task not completed.");
  private JButton startButton = new JButton("Start");
  private JButton helloButton = new JButton("Say Hello");
 
  public SwingExample3(String title) {
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
        new SwingExample3("Swing Demo");
      }
    });
  }
 
  private void start() {
    SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
      @Override
      protected Boolean doInBackground() throws Exception {
        // Simulate doing something useful.
        for (int i = 0; i <= 10; i++) {
          Thread.sleep(1000);
          System.out.println("Running " + i);
        }
 
        // Here we can return some object of whatever type
        // we specified for the first template parameter.
        // (in this case we're auto-boxing 'true').
        return true;
      }
 
      // Can safely update the GUI from this method.
      protected void done() {
        boolean status;
        try {
          // Retrieve the return value of doInBackground.
          status = get();
          statusLabel.setText("Completed with status: " + status);
        } catch (InterruptedException e) {
          // This is thrown if the thread's interrupted.
        } catch (ExecutionException e) {
          // This is thrown if we throw an exception
          // from doInBackground.
        }
      }};
    worker.execute();
  }
}
