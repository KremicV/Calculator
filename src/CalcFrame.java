import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class CalcFrame extends JFrame implements ActionListener{


    JPanel panel;
    JTextField textfield;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[10];
    Font myFont = new Font("Helvetica", Font.BOLD, 20);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    JButton addBtn, subBtn, mulBtn, divBtn, decBtn, equalsBtn, deleteBtn, clearBtn, negBtn, sqrtBtn;

    CalcFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 230));

        textfield = new JTextField();
        textfield.setBounds(20, 20, 400, 60);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(255, 255, 153));

        for(int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
            numbers[i].setBackground(new Color(255, 255, 153));

        }
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equalsBtn = new JButton("=");
        deleteBtn = new JButton("Del");
        clearBtn = new JButton("CLR");
        negBtn = new JButton("(-)");
        sqrtBtn = new JButton("sqrt");

        functions[0] = addBtn;
        functions[1] = subBtn;
        functions[2] = mulBtn;
        functions[3] = divBtn;
        functions[4] = decBtn;
        functions[5] = equalsBtn;
        functions[6] = deleteBtn;
        functions[7] = clearBtn;
        functions[8] = negBtn;
        functions[9] = sqrtBtn;
        for(int i = 0; i <= 9; i++){
            functions[i].setFont(myFont);
            functions[i].setBackground(new Color(204, 255, 102));
            functions[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(20, 90, 400, 350);
        panel.setLayout(new GridLayout(4, 5));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subBtn);
        panel.add(clearBtn);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulBtn);
        panel.add(negBtn);
        panel.add(decBtn);
        panel.add(numbers[0]);
        panel.add(equalsBtn);
        panel.add(divBtn);
        panel.add(sqrtBtn);



        this.add(panel);
        this.add(textfield);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource()==numbers[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decBtn){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addBtn){
            num1 =Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource()==subBtn){
            num1 =Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()==mulBtn){
            num1 =Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource()==divBtn){
            num1 =Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==equalsBtn){
            num2 =Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clearBtn){
            textfield.setText("");
        }
        if(e.getSource()==deleteBtn){
            String num = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < num.length()-1; i++){
                textfield.setText(textfield.getText() + num.charAt(i));
            }
        }
        if(e.getSource()==negBtn){
            double pom = Double.parseDouble(textfield.getText());
            pom = pom * (-1);
            textfield.setText(String.valueOf(pom));
        }
        if(e.getSource()==sqrtBtn){
            num1 = Double.parseDouble(textfield.getText());
            result = Math.sqrt(num1);
            textfield.setText(String.valueOf(result));
        }
    }
}
