import java.awt.*;
import javax.swing.*;

public class RankReq extends JPanel
{
	private static final long serialVersionUID = 1L;
	JLabel jLabel1=new JLabel("Introduction of Rank Requirement");
	JLabel jLabel2=new JLabel("Administrators: Min, Mica, Julia");
	JLabel jLabel3=new JLabel("Latest version: 2017-04-03");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	public RankReq()
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
		this.setLayout(null);
		jLabel1.setBounds(new Rectangle(40,10,400,39));
		jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,23));
		jLabel2.setBounds(new Rectangle(40,40,400,28));
		jLabel3.setBounds(new Rectangle(40,70,400,27));
		jScrollPane1.setBounds(new Rectangle(40,110,410,290));
		jTextArea1.append("01-White Belt\n"
								+"\tSay Fone Say Bay\n"
								+"\tStraight leg kicks\n"
								+"\tbasic punches\n"
					+ "02-Yellow Belt\n"
								+"\tStationary double punches\n"	
								+"\tOne-on-one point sparring\n"
								+"\tBreak a single 1“ thick board\n"
					+ "03-Orange Belt\n"
								+"\tCombination kicks\n"
								+"\tMoving double step punches\n"
								+"\tOne-on-one point sparring\n"
								+"\tBreak a single 1” thick borad\n"
					+ "04-Green Belt\n"
					            +"\tHorse stance: 3min\n"
					            +"\tCombination kicks and punches\n"
					            +"\tOne-on-one continuous sparring\n"
					            +"\tBreak two 1“ thick boards\n"
					+ "05-Blue Belt\n"
								+"\tSpinning&Conbination kicks\n"
								+"\tBasic classical& running step punches\n"
								+"\tBreak two 1” thick boards using hands and feet\n"
					+ "06-Purple Belt\n"
					            +"\tClassical jumping kicks\n"
					            +"\tRunnning step combination punches\n"
					            +"\tBreak three 1“ thick boards\n"
					+ "07-Brown Belt\n"
								+"\t10 Eagle Claw techniques\n"
								+"\tFree spar four-on-one\n"
								+"\tBreak three 1” thick boards with hands and feet\n"
					+ "08-Black Belt\n"
								+"\t10 Trapping Hand Techniques\n"
								+"\t20 Eagle Claw Tchniques\n"
								+"\t10 Throwing Techniques\n"
								+"\tFree spar five-on-one\n"
								+"\tRunning, bag work, gymnastics\n"
								+"\tBreak four 1“ cinder blocks with palm");
		jTextArea1.setFont(new java.awt.Font("Lucida Sans",Font.ITALIC,14));

		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		setSize(300,160);
	}
}

