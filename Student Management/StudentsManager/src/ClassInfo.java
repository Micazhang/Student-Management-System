import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class ClassInfo extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement st;
	JLabel bjID=new JLabel("Please Input Class ID:");
    JTextField jTextField1=new JTextField();
    JLabel bjID2=new JLabel("(e.g. 001)");
    JButton jButton1=new JButton("Search");
    JScrollPane jScrollPane1=new JScrollPane();
    JTextArea jTextArea1=new JTextArea();

    public ClassInfo()
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
        bjID.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
    	bjID.setBounds(new Rectangle(46,4,222,32));
    	jTextField1.setBounds(new Rectangle(47,37,100,31));
    	bjID2.setBounds(new Rectangle(160,37,180,30));
    	jButton1.setBounds(new Rectangle(47,86,130,30));
    	jScrollPane1.setBounds(new Rectangle(47,130,250,109));
    	jButton1.addActionListener(this);
    	this.add(jScrollPane1);
    	jScrollPane1.getViewport().add(jTextArea1);
    	this.add(bjID);
    	this.add(jTextField1);
    	this.add(bjID2);
    	this.add(jButton1);
    	jScrollPane1.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String banji=jTextField1.getText();
    	jTextArea1.setText("");
    	jScrollPane1.setVisible(true);
    	try{
    		ResultSet rs=st.executeQuery("select * from class where Class_ID='"+banji+"'");
    		if(rs.next()){
    			jTextArea1.append("Class Weekday:"+rs.getString("Class_Weekday")+
    					"\nClass Time:"+rs.getString("Class_Time")+
    					"\nClass Location:"+rs.getString("Class_Location")+
    					"\nClass Level:"+rs.getString("Class_Level")+
    					"\nInstructor Name:"+rs.getString("Instructor_Name"));
    			jTextField1.setText("");
    		}
    	else
    		JOptionPane.showMessageDialog(this,"The Class ID does not EXIST！");
    	}
        catch(Exception ex){
        	JOptionPane.showMessageDialog(this,"Search Error！");
        }
    }
}
