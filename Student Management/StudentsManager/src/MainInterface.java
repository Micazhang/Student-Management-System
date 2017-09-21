import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainInterface extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JPanel contentPane;

	JMenuBar jMenuBarSM=new JMenuBar();
	JMenu jMenuFile=new JMenu("File");
		JMenuItem jMenuFileExit=new JMenuItem("Exit");
	JMenu jMenuStudents=new JMenu("Manage Student");
		JMenuItem jMenuStuId=new JMenuItem("Search By Student ID");
		JMenuItem jMenuAddStu=new JMenuItem("Add a New Student");
		JMenuItem jMenuDelStu=new JMenuItem("Delete a Student");

	JMenu jMenuFee=new JMenu("Fee Inquery");
		JMenuItem jMenuFeeOnStuId=new JMenuItem("Search Fee By Student ID");
		JMenuItem jMenuFeeOnDate=new JMenuItem("Search Fee By Date");
		
	JMenu jMenuClass=new JMenu("Class Inquery");
		JMenuItem jMenuClassInfo=new JMenuItem("Class Info");
		JMenuItem jMenuClassStu=new JMenuItem("Current Students");
		JMenuItem jMenuStuinClass=new JMenuItem("Students Attendence in each class");

	JMenu jMenuRankInq=new JMenu("Rank Inquery");
		JMenuItem jMenuRankStuNum=new JMenuItem("Total Students in each Rank");
		JMenuItem jMenuRankYearStu=new JMenuItem("Students with a Specific Rank");

	JMenu jMenuRank=new JMenu("Rank Info");
		JMenuItem jMenuRankBelt=new JMenuItem("Rank Belt");
		JMenuItem jMenuRankReq=new JMenuItem("Rank Requirement");
		

		
	JLabel jLabel1=new JLabel("Welcome to Stephanos Kung Fu Club");
	JLabel jLabel2=new JLabel("Designed by");
	JLabel jLabel3=new JLabel("Min Guo");
	JLabel jLabel4=new JLabel("Qiuxuan Zhang");
	JLabel jLabel5=new JLabel("Jia Zhu");
	
	public MainInterface()
	{
		try{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception
	{
		contentPane =(JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(500,480));
		setTitle("Stephanos Kung Fu Club ");
		jMenuFileExit.addActionListener(this);
		
	//	jMenuRank.addActionListener(this);
			jMenuRankBelt.addActionListener(this);
			jMenuRankReq.addActionListener(this);
			
		jMenuStuId.addActionListener(this);
		jMenuAddStu.addActionListener(this);
		jMenuDelStu.addActionListener(this);
			
	//	jMenuFee.addActionListener(this);
		    jMenuFeeOnStuId.addActionListener(this);
		    jMenuFeeOnDate.addActionListener(this);
		
	//	jMenuRankInq.addActionListener(this);
			jMenuRankStuNum.addActionListener(this);
			jMenuRankYearStu.addActionListener(this);
		
			jMenuClassInfo.addActionListener(this);
			jMenuClassStu.addActionListener(this);
			jMenuStuinClass.addActionListener(this);

		setJMenuBar(jMenuBarSM);
		jMenuBarSM.add(jMenuFile);
		jMenuBarSM.add(jMenuStudents);
		jMenuBarSM.add(jMenuFee);
		jMenuBarSM.add(jMenuClass);
		jMenuBarSM.add(jMenuRankInq);
		jMenuBarSM.add(jMenuRank);


		jMenuFile.add(jMenuFileExit);
		
		jMenuStudents.add(jMenuStuId);
		jMenuStudents.add(jMenuAddStu);
		jMenuStudents.add(jMenuDelStu);
		
		jMenuFee.add(jMenuFeeOnStuId);
		jMenuFee.add(jMenuFeeOnDate);
		
		jMenuRankInq.add(jMenuRankStuNum);
		jMenuRankInq.add(jMenuRankYearStu);
		
		jMenuRank.add(jMenuRankBelt);
		jMenuRank.add(jMenuRankReq);
		
		jMenuClass.add(jMenuClassInfo);
		jMenuClass.add(jMenuClassStu);
		jMenuClass.add(jMenuStuinClass);

		contentPane.add(jLabel1);
		contentPane.add(jLabel2);
		contentPane.add(jLabel3);
		contentPane.add(jLabel4);
		contentPane.add(jLabel5);
		
		jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,23));
		jLabel1.setBounds(new Rectangle(65,70,350,55));
		jLabel2.setFont(new java.awt.Font("Calibri",Font.ITALIC,16));
		jLabel2.setBounds(new Rectangle(200,180,150,55));
		jLabel3.setFont(new java.awt.Font("Lucida Calligraphy",Font.ITALIC,18));
		jLabel3.setBounds(new Rectangle(200,220,300,55));
		jLabel4.setFont(new java.awt.Font("Lucida Calligraphy",Font.ITALIC,18));
		jLabel4.setBounds(new Rectangle(170,250,300,55));
		jLabel5.setFont(new java.awt.Font("Lucida Calligraphy",Font.ITALIC,18));
		jLabel5.setBounds(new Rectangle(200,280,300,55));

	}

	public void actionPerformed(ActionEvent actionEvent)
	{
		if(actionEvent.getSource()==jMenuFileExit)
		{
			System.exit(0);
		}
	
		if(actionEvent.getSource()==jMenuStuId)
		{
			InquireOnStuID onXH=new InquireOnStuID();
			this.remove(this.getContentPane());
			this.setContentPane(onXH);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuAddStu)
		{
			AddStudents add=new AddStudents();
			this.remove(this.getContentPane());
			this.setContentPane(add);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuDelStu)
		{
			DelStudents delete=new DelStudents();
			this.remove(this.getContentPane());
			this.setContentPane(delete);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuFeeOnStuId)
		{
			InquireFeeOnStuID FeeonStuId=new InquireFeeOnStuID();
			this.remove(this.getContentPane());
			this.setContentPane(FeeonStuId);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuFeeOnDate)
		{
			InquireFeeOnDate FeeonDate=new InquireFeeOnDate();
			this.remove(this.getContentPane());
			this.setContentPane(FeeonDate);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuRankStuNum)
		{
			RankStuNum rankstuNum=new RankStuNum();
			this.remove(this.getContentPane());
			this.setContentPane(rankstuNum);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuRankYearStu)
		{
			RankYearStu rankyearStu=new RankYearStu();
			this.remove(this.getContentPane());
			this.setContentPane(rankyearStu);
			this.setVisible(true);
		}

		if(actionEvent.getSource()==jMenuRankBelt)
		{
			RankBelt rankBelt=new RankBelt();
			this.remove(this.getContentPane());
			this.setContentPane(rankBelt);
			this.setVisible(true);
		}
		if(actionEvent.getSource()==jMenuRankReq)
		{
		
			RankReq rankReq=new RankReq();
			this.remove(this.getContentPane());
			this.setContentPane(rankReq);
			this.setVisible(true);
		}
		if(actionEvent.getSource()==jMenuClassInfo)
		{
		
			ClassInfo classinfo=new ClassInfo();
			this.remove(this.getContentPane());
			this.setContentPane(classinfo);
			this.setVisible(true);
		}
		if(actionEvent.getSource()==jMenuClassStu)
		{
		
			ClassStu classstu=new ClassStu();
			this.remove(this.getContentPane());
			this.setContentPane(classstu);
			this.setVisible(true);
		}
		if(actionEvent.getSource()==jMenuStuinClass)
		{
		
			StuinClass stuinclass=new StuinClass();
			this.remove(this.getContentPane());
			this.setContentPane(stuinclass);
			this.setVisible(true);
		}
	}
}
