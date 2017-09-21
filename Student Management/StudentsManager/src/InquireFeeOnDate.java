import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class InquireFeeOnDate extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement st;
	JLabel jLabel1=new JLabel("Please Input Begin Date:");
    JTextField date1=new JTextField();
    JLabel dateformat1=new JLabel("(e.g. 2017-01-01)");
    JLabel jLabel2=new JLabel("Please Input End Date:");
    JTextField date2=new JTextField();
    JLabel dateformat2=new JLabel("(e.g. 2017-01-15)");
    JButton jButton1=new JButton("Search");
    JScrollPane jScrollPane1=new JScrollPane();
    JTextArea jTextArea1=new JTextArea();
    
    public InquireFeeOnDate()
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
    	jLabel1.setBounds(new Rectangle(46,4,222,32));
    	date1.setBounds(new Rectangle(47,37,100,31));
    	dateformat1.setBounds(new Rectangle(160,37,180,30));   	
    	jLabel2.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
    	jLabel2.setBounds(new Rectangle(47,70,222,32));
    	date2.setBounds(new Rectangle(47,100,100,31));
    	dateformat2.setBounds(new Rectangle(160,100,180,30));   
    	jButton1.setBounds(new Rectangle(47,140,120,30));
    	jScrollPane1.setBounds(new Rectangle(47,180,305,200));
    	jButton1.addActionListener(this);
    	this.add(jScrollPane1);
    	jScrollPane1.getViewport().add(jTextArea1);
    	this.add(jLabel1);
    	this.add(date1);
    	this.add(dateformat1);
    	this.add(jLabel2);
    	this.add(date2);
    	this.add(dateformat2);
    	this.add(jButton1);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String startdate=date1.getText();
    	String enddate=date2.getText();
    	jTextArea1.setText("");
    	try{
    		ResultSet rs=st.executeQuery("select f.Stu_Num,s.Stu_FName,s.Stu_LName,f.Fee_Type,f.Fee_Amount,f.Fee_Given_Date"
    				+ " from fee f,student s where f.Fee_Given_Date>='"+startdate+"' and f.Fee_Given_Date<='"+enddate+"' and f.Stu_Num=s.Stu_Num");
    		while(rs.next()){
    			jTextArea1.append("\n--------------------\n"+
    					 "Student ID:"+rs.getString("f.Stu_Num")+
    					"\nFirst Name:"+rs.getString("s.Stu_FName")+
    					"\nLast Name:"+rs.getString("s.Stu_LName")+
    					//"\nStudent Phone Number:"+rs.getString("s.Stu_Pho_Num")+
    				//	"\nFee Number:"+rs.getString("f.Fee_Num")+
    					"\nFee Type:"+rs.getString("f.Fee_Type")+
    					"\nFee Amount:"+rs.getString("f.Fee_Amount")+
    					"\nFee Given Date:"+rs.getDate("f.Fee_Given_Date"));
    			date1.setText("");
    			date2.setText("");
    		}
    		//JOptionPane.showMessageDialog(this,"The Date Rearch does not EXIST！");
    	}
        catch(Exception ex){
        	JOptionPane.showMessageDialog(this,"Search Error！");
        }
    }
}