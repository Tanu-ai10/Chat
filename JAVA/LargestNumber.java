import java.awt.*;
import java.awt.event.*;

public class LargestNumber extends Frame implements ActionListener 
{

    TextField num1Field, num2Field, resultField;
    Button largestButton;

    public LargestNumber() 
    {
        // Initialize the GUI components
        init();
        
        // Set frame properties
        setTitle("Largest Number Finder");
        setSize(300, 150);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        
        // Close the window when the user clicks the close button
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent we) 
            {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void init() 
    {
        setLayout(new FlowLayout());

        Label num1Label = new Label("Number 1:");
        add(num1Label);
        num1Field = new TextField(10);
        add(num1Field);

        Label num2Label = new Label("Number 2:");
        add(num2Label);
        num2Field = new TextField(20);
        add(num2Field);

        largestButton = new Button("Largest");
        largestButton.addActionListener(this);
        add(largestButton);

        resultField = new TextField(20);
        resultField.setEditable(false);
        add(resultField);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == largestButton) 
        {
            try 
            {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int largest = Math.max(num1, num2);
                resultField.setText(String.valueOf(largest));
            } 
            catch (NumberFormatException ex) 
            {
                resultField.setText("Invalid input. Please enter numbers only.");
            }
        }
    }

    public static void main(String[] args) 
    {
        new LargestNumber();
    }
}
