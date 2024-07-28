import java.awt.*;
import java.awt.event.*;

public class SquareNumberApp extends Frame implements ActionListener 
{
    TextField num1Field,resultField;
    Button squareButton;

    public SquareNumberApp() 
    {
        // Initialize the GUI components
        init();
        
        // Set frame properties
        setTitle("Square Number Finder");
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

        Label numberLabel = new Label("Enter a number:");
        add(numberLabel);
        num1Field = new TextField(20);
        add(num1Field);

        squareButton = new Button("Square");
        squareButton.addActionListener(this);
        add(squareButton);

        resultField = new TextField(10);
        resultField.setEditable(false);
        add(resultField);

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == squareButton) 
        {
            try 
            {
                Double number = Double.parseDouble(num1Field.getText());
                Double square = number * number;
                resultField.setText(String.valueOf(square));
            } 
            catch (NumberFormatException ex) 
            {
                resultField.setText("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) 
    {
        new SquareNumberApp();
    }
}

