import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestPanels extends JFrame{
    public TestPanels(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,3));
        JButton[] btns  = new JButton[9];
        
        JTextField t1 = new JTextField("");
        OperationActionListener oplistener = new OperationActionListener(t1);
        NumberActionListener numblistener = new NumberActionListener(t1);
        int j = 7;
        for(int i=1; i<=9; i++){
             btns[i-1] = new JButton(""+j);
             btns[i-1].setForeground(Color.BLUE);
             btns[i-1].addActionListener(numblistener);
             p1.add(btns[i-1]);
            j++;
            if (i%3 == 0) j-=6;
        }
        
        
        JButton btnZero = new JButton(""+ 0);
        btnZero.setForeground(Color.BLUE);
        btnZero.addActionListener(numblistener);
        p1.add(btnZero);
        JButton btnSigne = new JButton("+/-");
        btnSigne.setForeground(Color.BLUE);
        btnSigne.addActionListener(oplistener);
        p1.add(btnSigne);
        JButton btnClr = new JButton("ClearALL");
        btnClr.setForeground(Color.BLUE);
        btnClr.addActionListener(oplistener);
        p1.add(btnClr);
        
        JPanel p3 = new JPanel(new GridLayout(4,1));
        JButton btnAdd = new JButton("+");
        btnAdd.setForeground(Color.red);
        btnAdd.addActionListener(oplistener);
        p3.add(btnAdd);
        JButton btnSub = new JButton("-");
        btnSub.setForeground(Color.red);
        btnSub.addActionListener(oplistener);
        p3.add(btnSub);
        JButton btnMult = new JButton("*");
        btnMult.setForeground(Color.red);
        btnMult.addActionListener(oplistener);
        p3.add(btnMult);
        JButton btnDiv = new JButton("/");
        btnDiv.setForeground(Color.red);
        btnDiv.addActionListener(oplistener);
        p3.add(btnDiv);
        
        JPanel p4 = new JPanel(new GridLayout(1,1));
        JButton clickBTN = new JButton("ENTER");
        clickBTN.setForeground(Color.GREEN);
        clickBTN.addActionListener(oplistener);
        p4.add(clickBTN);
        
        JPanel p2 = new JPanel(new BorderLayout());
        
        p2.add(t1, BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        p2.add(p3, BorderLayout.EAST);
        p2.add(p4, BorderLayout.SOUTH);
        add(p2, BorderLayout.CENTER);
    }
    
}

class OperationActionListener implements ActionListener{
    JTextField t1;
    String a;
    String b;
    String operation; 
    
    public OperationActionListener(JTextField t1 ){
        this.t1=t1;
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
         if (e.getActionCommand() =="+" || e.getActionCommand() =="-" || e.getActionCommand() =="*"|| e.getActionCommand() =="/"){
         operation = e.getActionCommand();
              a=t1.getText();
              t1.setText("");
             
             
         }
         else if(e.getActionCommand() =="ENTER") {
              b=t1.getText();
              switch(operation){
                  case  "+" : t1.setText(Integer.toString( Integer.parseInt(b) + Integer.parseInt(a)));
                    break;
                    case  "-" : t1.setText(Integer.toString( Integer.parseInt(a) - Integer.parseInt(b)));
                    break;
                    case  "*" : t1.setText(Integer.toString( Integer.parseInt(b) * Integer.parseInt(a)));
                    break;
                    case  "/" : t1.setText(Integer.toString( Integer.parseInt(a) / Integer.parseInt(b)));
                    break;
                    default:;
               }
             
         }
         else if (e.getActionCommand()=="ClearALL"){
              t1.setText("");
         }
         else if (e.getActionCommand() == "+/-"){
             System.out.println("dfgg");
             String ch="";
             String s = t1.getText();
             if (s.charAt(0)=='-'){
             for(int i=1; i<s.length(); i++){
             ch += s.charAt(i);
              }
            t1.setText(ch);}
             
                     
         }
         
    }
}




class NumberActionListener implements ActionListener{
    JTextField t1;
    public NumberActionListener (JTextField t1){
        this.t1=t1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        t1.setText(t1.getText() + e.getActionCommand());
    }
}