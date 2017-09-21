import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class InquireFeeOnStuID extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement st;
	JLabel jLabel1=new JLabel("Please input Student ID:");
    JTextField stuNum=new JTextField();
    JLabel stuNum2=new JLabel("e.g. 20170401");
    JButton jButton1=new JButton("Search");
    JScrollPane jScrollPane1=new JScrollPane();
    JTextArea jTextArea1=new JTextArea();

    public InquireFeeOnStuID()
    {
    	try{
    		jbInit();
    	}
    	catch(Exception exception){
    		exception.printStackTrace();
    	}
    }
    
    private void jbInit() throws Exception
    {
    	conn=DBConnect.getConn();
    	st=conn.createStatement();
    	this.setLayout(null);
        jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
    	jLabel1.setBounds(new Rectangle(47,4,222,32));
    	stuNum.setBounds(new Rectangle(47,37,100,31));
    	stuNum2.setBounds(new Rectangle(160,37,180,30));
    	jButton1.setBounds(new Rectangle(47,86,247,30));
    	jScrollPane1.setBounds(new Rectangle(47,130,305,250));
    	jButton1.addActionListener(this);
    	this.add(jScrollPane1);
    	jScrollPane1.getViewport().add(jTextArea1);
    	this.add(jLabel1);
    	this.add(stuNum);
    	this.add(stuNum2);
    	this.add(jButton1);

    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String stunum=stuNum.getText();
    	jTextArea1.setText("");
   
    	try{
    	
    		ResultSet rs2=st.executeQuery("select f.Stu_Num,s.Stu_FName,s.Stu_LName,s.Stu_Pho_Num,f.Fee_Type,f.Fee_Amount,f.Fee_Given_Date from fee f,student s where f.Stu_Num='"+stunum+"' and f.Stu_Num=s.Stu_Num");
   
    			while(rs2.next()){
    			jTextArea1.append("\n------------------\n"+
    					"Student ID:"+rs2.getString("f.Stu_Num")+
    					"\nFirst Name:"+rs2.getString("s.Stu_FName")+
    					"\nLast Name:"+rs2.getString("s.Stu_LName")+
    					"\nStudent Phone Number:"+rs2.getString("s.Stu_Pho_Num")+
    					"\nFee Type:"+rs2.getString("f.Fee_Type")+
    					"\nFee Amount:"+rs2.getString("f.Fee_Amount")+
    					"\nFee Given Date:"+rs2.getDate("f.Fee_Given_Date"));
    			stuNum.setText("");
    			}
    			//JOptionPane.showMessageDialog(this,"The Student ID does not EXIST！");
    	}
        catch(Exception ex){
        	JOptionPane.showMessageDialog(this,"Search Error！");
        }
    	return;
    }
}