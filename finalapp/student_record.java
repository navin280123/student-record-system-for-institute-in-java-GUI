package finalapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Label;
import java.awt.RenderingHints;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class student_record {

	private JFrame frame;
	private JTextField addname;
	private JTextField addid;
	private JTextField addphone;
	private JTextField addadd;
	private JTextField addfee;
	private JTextField addfeepermonth;
	private JTextField viewid;
	private JTextField updatestudent;
	private JTextField upname;
	private JTextField upphone;
	private JTextField upadd;
	private JTextField uptfee;
	private JTextField upfpm;
	private JTextField delstudent;
	private JLabel delremfee;
	private JTextField addemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String user="",pass="",mpass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
					"root", "navin");
			Statement statement = connection.createStatement();
			String data = "select name,email From shashi WHERE ID="+28012801+"";
			ResultSet rs = statement.executeQuery(data);
			while(rs.next()) {
				user=rs.getString("name");
				mpass=rs.getString("email");
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JTextField xField = new JTextField(5);
	    JPasswordField yField = new JPasswordField(5);

	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("USER:"));
	    myPanel.add(xField);
	    myPanel.add(Box.createVerticalStrut(15)); // a spacer
	    myPanel.add(new JLabel("PASSWORD:"));
	    myPanel.add(yField);

	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	        "Please Enter X and Y Values", JOptionPane.OK_OPTION);
	    String password = new String(yField.getPassword());
	    if (result == JOptionPane.OK_OPTION && (xField.getText().equals(user)&&password.equals(mpass))) {
	    	EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						student_record window = new student_record();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    }
	    else {
	    	JOptionPane.showMessageDialog(new JFrame(), "Wrong Credential!!!", "Warning!!", JOptionPane.ERROR_MESSAGE);
	    }
//	    EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					student_record window = new student_record();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
	}

	/**
	 * Create the application.
	 */
	public student_record() {
		initialize();
	}

	String path = null;
	private JTextField upemail;
	private JTextField upfeepaid;
	private JTextField addfeepaid;
	private JTextField uppass;
	private JTextField adddate;

	public void path(String a) {
		path = a;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private Image fitimage(Image img, int w, int h) {
		BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedimage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resizedimage;
	}

	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		JTextArea message = new JTextArea();
		message.setRows(7);
		message.setForeground(Color.RED);
		message.setFont(new Font("Calibri", Font.BOLD, 15));
		message.setBounds(10, 116, 141, 34);
		message.setEditable(false);
		message.setText("Welcome Admin");
		frame.getContentPane().add(message);
		message.setColumns(10);

		JPanel panel_all = new JPanel();
		panel_all.setBackground(Color.GRAY);
		panel_all.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_all);
		panel_all.setLayout(null);
		panel_all.setVisible(false);

		Choice month = new Choice();
		month.setBounds(10, 7, 203, 20);
		month.add("jan");
		month.add("feb");
		month.add("march");
		month.add("april");
		month.add("may");
		month.add("june");
		month.add("july");
		month.add("august");
		month.add("september");
		month.add("october");
		month.add("november");
		month.add("december");
		panel_all.add(month);

		JTextArea textArea = new JTextArea(20, 20);
		textArea.setEditable(false);
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		scrollableTextArea.setSize(600, 500);
		scrollableTextArea.setLocation(10, 30);

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_all.add(scrollableTextArea);

		JButton monthbutton = new JButton("SEARCH");
		monthbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchmonth = month.getItem(month.getSelectedIndex());
				int id = 0;
				String name = "", phone = "", time = "", remfee = "";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					Statement statement = connection.createStatement();
					String data = "select id,name,phone,time,feepaid from shashi where " + searchmonth + "=" + 0
							+ "";
					ResultSet rs = statement.executeQuery(data);
					String record = "";
					while (rs.next()) {
						id = rs.getInt("id");
						name = rs.getString("name");
						phone = rs.getString("phone");
						time = rs.getString("time");
						remfee = rs.getString("feepaid");
						record += ("   " + "\n" + "ID: " + Integer.toString(id) + "\t" + "NAME: " + name + "\t"
								+ "PHONE: " + phone + "\t" + "TIME: " + time + "\t" + "PAID FEE: " + remfee+"\n"+"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}
					textArea.setText(record);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		monthbutton.setBounds(235, 4, 102, 23);
		panel_all.add(monthbutton);
		
		JButton export = new JButton("EXPORT DATA");
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String filename = path;
//				            "C:\\Users\\user\\Desktop\\data.txt";
				        try {
				            FileWriter fw = new FileWriter(filename);
				            Class.forName("com.mysql.cj.jdbc.Driver");
				            Connection conn = DriverManager.getConnection(
				                "jdbc:mysql://localhost:3306/student_record"
				                , "root"
				                , "navin"
				            );
				            String query = "select * from shashi";
				            Statement stmt = conn.createStatement();
				            ResultSet rs = stmt.executeQuery(query);
				            while (rs.next()) {
				                fw.append("ID: "+rs.getString(1));
				                fw.append("\t");
				                fw.append("NAME: "+rs.getString(2));
				                fw.append("\t");
				                fw.append("PHONE: "+rs.getString(3));
				                fw.append("\t");
				                fw.append("ADRESS: "+rs.getString(4));
				                fw.append("\t");
				                fw.append("COURSE: "+rs.getString(5));
				                fw.append("\t");
				                fw.append("COURSE DURATION: "+rs.getString(6));
				                fw.append("\t");
				                fw.append("TOTAL FEE: "+rs.getString(7));
				                fw.append("\t");
				                fw.append("FEE PER MONTH: "+rs.getString(8));
				                fw.append("\t");
				                fw.append("JANUARY: "+rs.getString(9));
				                fw.append("\t");
				                fw.append("FEBRUARY: "+rs.getString(10));
				                fw.append("\t");
				                fw.append("MARCH: "+rs.getString(11));
				                fw.append("\t");
				                fw.append("APRIL: "+rs.getString(12));
				                fw.append("\t");
				                fw.append("MAY: "+rs.getString(13));
				                fw.append("\t");
				                fw.append("JUME: "+rs.getString(14));
				                fw.append("\t");
				                fw.append("JULY: "+rs.getString(15));
				                fw.append("\t");
				                fw.append("AUGUST: "+rs.getString(16));
				                fw.append("\t");
				                fw.append("SEPTEMBER: "+rs.getString(17));
				                fw.append("\t");
				                fw.append("OCTOBER: "+rs.getString(18));
				                fw.append("\t");
				                fw.append("NOVEMBER: "+rs.getString(19));
				                fw.append("\t");
				                fw.append("DECEMBER: "+rs.getString(20));
				                fw.append("\t");
				                fw.append("EMAIL: "+rs.getString(21));
				                fw.append("\t");
//				                fw.append(rs.getString(22));
//				                fw.append(',');
				                fw.append("BATCH-TIME: "+rs.getString(23));
				                fw.append("\t");
				                fw.append("FEE PAID: "+rs.getString(24));
				                fw.append("\t");
				                fw.append('\n');
				                fw.append("*************************************************************************************************************************************************************************************************");
				                fw.append('\n');
				            }
				            fw.flush();
				            fw.close();
				            conn.close();
				            message.setText("Data Export Done!");
				        } catch (Exception e1) {
				            e1.printStackTrace();
				        }
			}
		});
		export.setBounds(496, 4, 114, 23);
		panel_all.add(export);
		
		JButton exportselectbutton = new JButton("SELECT FILE");
		exportselectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					path(fc.getSelectedFile().getAbsolutePath());
					}
			}
		});
		exportselectbutton.setBounds(378, 4, 89, 23);
		panel_all.add(exportselectbutton);

		JPanel panel_delete = new JPanel();
		panel_delete.setBackground(SystemColor.activeCaption);
		panel_delete.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_delete);
		panel_delete.setLayout(null);
		panel_delete.setVisible(false);

		delstudent = new JTextField();
		delstudent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		delstudent.setBounds(30, 11, 315, 28);
		panel_delete.add(delstudent);
		delstudent.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(28, 77, 97, 28);
		panel_delete.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setBounds(30, 104, 95, 28);
		panel_delete.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setBounds(30, 130, 95, 28);
		panel_delete.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setBounds(30, 182, 95, 28);
		panel_delete.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Course");
		lblNewLabel_1_4.setBounds(28, 208, 97, 28);
		panel_delete.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Course Duration");
		lblNewLabel_1_5.setBounds(28, 235, 97, 28);
		panel_delete.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Total Fee");
		lblNewLabel_1_6.setBounds(28, 293, 95, 28);
		panel_delete.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("Fee Per Month");
		lblNewLabel_1_7.setBounds(30, 326, 95, 28);
		panel_delete.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Remaining Fee");
		lblNewLabel_1_8.setBounds(30, 354, 97, 28);
		panel_delete.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_9 = new JLabel("Paid Fee");
		lblNewLabel_1_9.setBounds(30, 380, 97, 28);
		panel_delete.add(lblNewLabel_1_9);

		JCheckBox deljan = new JCheckBox("January");
		deljan.setBounds(299, 80, 97, 23);
		panel_delete.add(deljan);

		JCheckBox delfeb = new JCheckBox("February");
		delfeb.setBounds(299, 107, 97, 23);
		panel_delete.add(delfeb);

		JCheckBox delmar = new JCheckBox("March");
		delmar.setBounds(299, 133, 97, 23);
		panel_delete.add(delmar);

		JCheckBox delapr = new JCheckBox("April");
		delapr.setBounds(299, 159, 97, 23);
		panel_delete.add(delapr);

		JCheckBox delmay = new JCheckBox("May");
		delmay.setBounds(299, 185, 97, 23);
		panel_delete.add(delmay);

		JCheckBox deljun = new JCheckBox("June");
		deljun.setBounds(299, 211, 97, 23);
		panel_delete.add(deljun);

		JCheckBox deljul = new JCheckBox("July");
		deljul.setBounds(299, 238, 97, 23);
		panel_delete.add(deljul);

		JCheckBox delaug = new JCheckBox("August");
		delaug.setBounds(299, 264, 97, 23);
		panel_delete.add(delaug);

		JCheckBox delsep = new JCheckBox("September");
		delsep.setBounds(299, 290, 97, 23);
		panel_delete.add(delsep);

		JCheckBox deloct = new JCheckBox("October");
		deloct.setBounds(299, 316, 97, 23);
		panel_delete.add(deloct);

		JCheckBox delnov = new JCheckBox("November");
		delnov.setBounds(299, 342, 97, 23);
		panel_delete.add(delnov);

		JCheckBox deldec = new JCheckBox("December");
		deldec.setBounds(299, 368, 97, 23);
		panel_delete.add(deldec);

		JLabel delname = new JLabel();
		delname.setBounds(123, 82, 170, 23);
		panel_delete.add(delname);

		JLabel delid = new JLabel();
		delid.setBounds(123, 104, 170, 23);
		panel_delete.add(delid);

		JLabel delphone = new JLabel();
		delphone.setBounds(123, 130, 170, 23);
		panel_delete.add(delphone);

		JLabel deladd = new JLabel();
		deladd.setBounds(123, 187, 170, 23);
		panel_delete.add(deladd);

		JLabel delcourse = new JLabel();
		delcourse.setBounds(123, 208, 170, 23);
		panel_delete.add(delcourse);

		JLabel delcourseduration = new JLabel();
		delcourseduration.setBounds(133, 240, 160, 23);
		panel_delete.add(delcourseduration);

		JLabel deltotalfee = new JLabel();
		deltotalfee.setBounds(123, 298, 170, 23);
		panel_delete.add(deltotalfee);

		JLabel delfeepermonth = new JLabel();
		delfeepermonth.setBounds(123, 332, 170, 23);
		panel_delete.add(delfeepermonth);

		delremfee = new JLabel();
		delremfee.setBounds(123, 359, 170, 23);
		panel_delete.add(delremfee);

		JLabel delpaidfee = new JLabel();
		delpaidfee.setBounds(123, 385, 170, 23);
		panel_delete.add(delpaidfee);

		JLabel delimage = new JLabel("");
		delimage.setBounds(424, 84, 160, 200);
		panel_delete.add(delimage);
		delimage.setBorder(border);

		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setBounds(30, 156, 95, 28);
		panel_delete.add(lblNewLabel_1_2_1);

		JLabel delemail = new JLabel();
		delemail.setBounds(123, 163, 170, 23);
		panel_delete.add(delemail);

		JLabel lblNewLabel_1_5_1 = new JLabel("Batch-Time");
		lblNewLabel_1_5_1.setBounds(28, 268, 97, 28);
		panel_delete.add(lblNewLabel_1_5_1);

		JLabel deltime = new JLabel();
		deltime.setBounds(123, 268, 170, 23);
		panel_delete.add(deltime);
		
		JLabel lblNewLabel_1_9_xcS1 = new JLabel("Addmission Date:");
		lblNewLabel_1_9_xcS1.setBounds(28, 411, 97, 28);
		panel_delete.add(lblNewLabel_1_9_xcS1);
		
		JLabel deladate = new JLabel();
		deladate.setBounds(123, 415, 170, 23);
		panel_delete.add(deladate);
		
		JButton delstudentbutton = new JButton("SEARCH STUDENT");
		delstudentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(delstudent.getText());
				int id = 0, jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0,
						nov = 0, dec = 0;
				String name = "", phone = "", email = "", address = "", course = "", courseduration = "", time = "",
						totalfee = "", feepermonth = "",vfeepaid="",date="";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					Statement statement = connection.createStatement();
					String data = "select * from shashi where id =" + key + "";
					ResultSet rs = statement.executeQuery(data);
					while (rs.next()) {
						id = rs.getInt("id");
						name = rs.getString("name");
						phone = rs.getString("phone");
						address = rs.getString("add");
						course = rs.getString("course");
						courseduration = rs.getString("courseduration");
						totalfee = rs.getString("totalfee");
						feepermonth = rs.getString("feepermonth");
						phone = rs.getString("phone");
						jan = rs.getInt("jan");
						feb = rs.getInt("feb");
						mar = rs.getInt("march");
						apr = rs.getInt("april");
						may = rs.getInt("may");
						jun = rs.getInt("june");
						jul = rs.getInt("july");
						aug = rs.getInt("august");
						sep = rs.getInt("september");
						oct = rs.getInt("october");
						nov = rs.getInt("november");
						dec = rs.getInt("december");
						email = rs.getString("email");
						BufferedImage im = ImageIO.read(rs.getBinaryStream("image"));
						ImageIcon imageIcon = new ImageIcon(fitimage(im, delimage.getWidth(), delimage.getHeight()));
						delimage.setIcon(imageIcon);
//			            delimage.setIcon(new ImageIcon(im));
						time = rs.getString("time");
						vfeepaid=rs.getString("feepaid");
						date=rs.getString("date");
						delid.setText(Integer.toString(id));
						delname.setText(name);
						delphone.setText(phone);
						deladd.setText(address);
						delcourse.setText(course);
						delcourseduration.setText(courseduration);
						deltotalfee.setText(totalfee);
						delfeepermonth.setText(feepermonth);
						deljan.setSelected(jan == 1 ? true : false);
						delfeb.setSelected(feb == 1 ? true : false);
						delmar.setSelected(mar == 1 ? true : false);
						delapr.setSelected(apr == 1 ? true : false);
						delmay.setSelected(may == 1 ? true : false);
						deljun.setSelected(jun == 1 ? true : false);
						deljul.setSelected(jul == 1 ? true : false);
						delaug.setSelected(aug == 1 ? true : false);
						delsep.setSelected(sep == 1 ? true : false);
						deloct.setSelected(oct == 1 ? true : false);
						delnov.setSelected(nov == 1 ? true : false);
						deldec.setSelected(dec == 1 ? true : false);
						delemail.setText(email);
						deltime.setText(time);
						delremfee.setText(String.valueOf((Integer.valueOf(totalfee) - (Integer.valueOf(vfeepaid) ))));
						delpaidfee.setText(String.valueOf((Integer.valueOf(vfeepaid) )));
						deladate.setText(date);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		delstudentbutton.setBounds(366, 11, 129, 28);
		panel_delete.add(delstudentbutton);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(delstudent.getText());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					String query = "delete from shashi where id = ?";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setInt(1, key);
					preparedStmt.execute();

					connection.close();
//				      JOptionPane.showMessageDialog(new JFrame(), "Data Saved SuccessFully", "Dialog", JOptionPane.OK_OPTION);
					message.setText("Data Deleted Done!");
					delid.setText("");
					delname.setText("");
					delphone.setText("");
					deladd.setText("");
					delcourse.setText("");
					delcourseduration.setText("");
					deltotalfee.setText("");
					delfeepermonth.setText("");
					deljan.setSelected(false);
					delfeb.setSelected(false);
					delmar.setSelected(false);
					delapr.setSelected(false);
					delmay.setSelected(false);
					deljun.setSelected(false);
					deljul.setSelected(false);
					delaug.setSelected(false);
					delsep.setSelected(false);
					deloct.setSelected(false);
					delnov.setSelected(false);
					deldec.setSelected(false);
					delemail.setText("");
					deltime.setText("");
					delimage.setIcon(null);
					delremfee.setText("");
					delpaidfee.setText("");
				} catch (Exception e1) {
					System.err.println("Got an exception! ");
					System.err.println(e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(247, 485, 129, 43);
		panel_delete.add(btnNewButton_1);
		
		

		JPanel panel_update = new JPanel();
		panel_update.setBackground(SystemColor.activeCaption);
		panel_update.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_update);
		panel_update.setLayout(null);
		panel_update.setVisible(false);

		updatestudent = new JTextField();
		updatestudent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		updatestudent.setBounds(35, 11, 307, 27);
		panel_update.add(updatestudent);
		updatestudent.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(35, 76, 93, 27);
		panel_update.add(lblNewLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(35, 102, 93, 27);
		panel_update.add(lblId);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(35, 128, 93, 27);
		panel_update.add(lblPhone);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(35, 183, 93, 27);
		panel_update.add(lblAddress);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(35, 207, 93, 27);
		panel_update.add(lblCourse);

		JLabel lblCourseDuration = new JLabel("Course Duration");
		lblCourseDuration.setBounds(35, 234, 93, 27);
		panel_update.add(lblCourseDuration);

		JLabel lblTotalFee = new JLabel("Total Fee");
		lblTotalFee.setBounds(35, 286, 93, 27);
		panel_update.add(lblTotalFee);

		JLabel lblFeePerMonth = new JLabel("Fee Per Month");
		lblFeePerMonth.setBounds(35, 312, 93, 27);
		panel_update.add(lblFeePerMonth);

		JCheckBox upjan = new JCheckBox("January");
		upjan.setBounds(339, 78, 97, 23);
		panel_update.add(upjan);

		JCheckBox upfeb = new JCheckBox("February");
		upfeb.setBounds(339, 104, 97, 23);
		panel_update.add(upfeb);

		JCheckBox upmar = new JCheckBox("March");
		upmar.setBounds(339, 130, 97, 23);
		panel_update.add(upmar);

		JCheckBox upapr = new JCheckBox("April");
		upapr.setBounds(339, 157, 97, 23);
		panel_update.add(upapr);

		JCheckBox upmay = new JCheckBox("May");
		upmay.setBounds(339, 183, 97, 23);
		panel_update.add(upmay);

		JCheckBox upjun = new JCheckBox("June");
		upjun.setBounds(339, 209, 97, 23);
		panel_update.add(upjun);

		JCheckBox upjul = new JCheckBox("July");
		upjul.setBounds(339, 236, 97, 23);
		panel_update.add(upjul);

		JCheckBox upaug = new JCheckBox("August");
		upaug.setBounds(339, 262, 97, 23);
		panel_update.add(upaug);

		JCheckBox upsep = new JCheckBox("September");
		upsep.setBounds(339, 288, 97, 23);
		panel_update.add(upsep);

		JCheckBox upoct = new JCheckBox("October");
		upoct.setBounds(339, 314, 97, 23);
		panel_update.add(upoct);

		JCheckBox upnov = new JCheckBox("November");
		upnov.setBounds(339, 342, 97, 23);
		panel_update.add(upnov);

		JCheckBox updec = new JCheckBox("December");
		updec.setBounds(339, 366, 97, 23);
		panel_update.add(updec);

		upname = new JTextField();
		upname.setBounds(138, 78, 182, 23);
		panel_update.add(upname);
		upname.setColumns(10);

		upphone = new JTextField();
		upphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		upphone.setColumns(10);
		upphone.setBounds(138, 130, 182, 23);
		panel_update.add(upphone);

		upadd = new JTextField();
		upadd.setColumns(10);
		upadd.setBounds(138, 183, 182, 23);
		panel_update.add(upadd);

		uptfee = new JTextField();
		uptfee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		uptfee.setColumns(10);
		uptfee.setBounds(138, 288, 182, 23);
		panel_update.add(uptfee);

		upfpm = new JTextField();
		upfpm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		upfpm.setColumns(10);
		upfpm.setBounds(138, 314, 182, 23);
		panel_update.add(upfpm);

		Choice upcourse = new Choice();
		upcourse.setBounds(138, 210, 182, 22);
		upcourse.add("ADCA");
		upcourse.add("DCA");
		upcourse.add("DTP");
		upcourse.add("TALLY");
		upcourse.add("DFA");
		upcourse.add("ADCA+");
		upcourse.add("HINDI TYPING");
		upcourse.add("ENGLISH TYPING");
		upcourse.add("C++");
		upcourse.add("INTERNET");
		panel_update.add(upcourse);

		Choice upcourseduration = new Choice();
		upcourseduration.setBounds(138, 234, 182, 22);
		upcourseduration.add("1 Month");
		upcourseduration.add("2 Month");
		upcourseduration.add("3 Month");
		upcourseduration.add("4 Month");
		upcourseduration.add("5 Month");
		upcourseduration.add("6 Month");
		upcourseduration.add("7 Month");
		upcourseduration.add("8 Month");
		upcourseduration.add("9 Month");
		upcourseduration.add("10 Month");
		upcourseduration.add("11 Month");
		upcourseduration.add("12 Month");
		panel_update.add(upcourseduration);

		JLabel upimage = new JLabel("");
		upimage.setBounds(443, 82, 160, 200);
		panel_update.add(upimage);
		upimage.setBorder(border);

		JLabel uptime69 = new JLabel("Batch-Time");
		uptime69.setBounds(35, 260, 93, 27);
		panel_update.add(uptime69);

		Choice uptime = new Choice();
		uptime.setBounds(138, 262, 182, 20);
		panel_update.add(uptime);
		
		uptime.add("6:00 AM-7:00 AM");
		uptime.add("7:00 AM-8:00 AM");
		uptime.add("8:00 AM-9:00 AM");
		uptime.add("9:00 AM-10:00 AM");
		uptime.add("10:00 AM-11:00 AM");
		uptime.add("11:00 AM-12:00 PM");
		uptime.add("12:00 PM-1:00 PM");
		uptime.add("1:00 PM-2:00 PM");
		uptime.add("2:00 PM-3:00 PM");
		uptime.add("3:00 PM-4:00 PM");
		uptime.add("4:00 PM-5:00 PM");
		uptime.add("5:00 PM-6:00 PM");
		uptime.add("6:00 PM-7:00 PM");

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 155, 93, 27);
		panel_update.add(lblEmail);

		upemail = new JTextField();
		upemail.setColumns(10);
		upemail.setBounds(138, 157, 182, 23);
		panel_update.add(upemail);

		JLabel upid = new JLabel("");
		upid.setBounds(138, 106, 182, 20);
		panel_update.add(upid);
		upid.setBorder(border);
		
		JLabel upremfee = new JLabel(" ");
		upremfee.setFont(new Font("Tahoma", Font.BOLD, 11));
		upremfee.setBounds(138, 370, 182, 27);
		panel_update.add(upremfee);
		
		JLabel upadate = new JLabel(" ");
		upadate.setFont(new Font("Tahoma", Font.BOLD, 11));
		upadate.setBounds(138, 400, 182, 27);
		panel_update.add(upadate);
		
		
		JButton updatesearch = new JButton("SEARCH STUDENT");
		updatesearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(updatestudent.getText());
				int id = 0, jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0,
						nov = 0, dec = 0;
				String name = "", phone = "", email = "", address = "", course = "", courseduration = "", time = "",
						totalfee = "", feepermonth = "",feepaid="",date="";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					Statement statement = connection.createStatement();
					String data = "select * from shashi where id =" + key + "";
					ResultSet rs = statement.executeQuery(data);
					while (rs.next()) {
						id = rs.getInt("id");
						name = rs.getString("name");
						phone = rs.getString("phone");
						address = rs.getString("add");
						course = rs.getString("course");
						courseduration = rs.getString("courseduration");
						totalfee = rs.getString("totalfee");
						feepermonth = rs.getString("feepermonth");
						phone = rs.getString("phone");
						jan = rs.getInt("jan");
						feb = rs.getInt("feb");
						mar = rs.getInt("march");
						apr = rs.getInt("april");
						may = rs.getInt("may");
						jun = rs.getInt("june");
						jul = rs.getInt("july");
						aug = rs.getInt("august");
						sep = rs.getInt("september");
						oct = rs.getInt("october");
						nov = rs.getInt("november");
						dec = rs.getInt("december");
						email = rs.getString("email");
						BufferedImage im = ImageIO.read(rs.getBinaryStream("image"));
						ImageIcon imageIcon = new ImageIcon(fitimage(im, upimage.getWidth(), upimage.getHeight()));
						upimage.setIcon(imageIcon);
						time = rs.getString("time");
						feepaid= rs.getString("feepaid");
						date=rs.getString("date");
						upid.setText(Integer.toString(id));
						upname.setText(name);
						upphone.setText(phone);
						upadd.setText(address);
						upcourse.select(course);
						upcourseduration.select(courseduration);
						uptfee.setText(totalfee);
						upfpm.setText(feepermonth);
						upjan.setSelected(jan == 1 ? true : false);
						upfeb.setSelected(feb == 1 ? true : false);
						upmar.setSelected(mar == 1 ? true : false);
						upapr.setSelected(apr == 1 ? true : false);
						upmay.setSelected(may == 1 ? true : false);
						upjun.setSelected(jun == 1 ? true : false);
						upjul.setSelected(jul == 1 ? true : false);
						upaug.setSelected(aug == 1 ? true : false);
						upsep.setSelected(sep == 1 ? true : false);
						upoct.setSelected(oct == 1 ? true : false);
						upnov.setSelected(nov == 1 ? true : false);
						updec.setSelected(dec == 1 ? true : false);
						upemail.setText(email);
						uptime.select(time);
						upfeepaid.setText("");
						upremfee.setText(Integer.toString(Integer.parseInt(totalfee)-Integer.parseInt(feepaid)));
						upadate.setText(date);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		updatesearch.setEnabled(true);
		updatesearch.setBounds(357, 11, 144, 27);
		panel_update.add(updatesearch);
		JButton upimagebutton = new JButton("SELECT IMAGE");
		upimagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					path(fc.getSelectedFile().getAbsolutePath());
					BufferedImage img;

					try {
						img = ImageIO.read(fc.getSelectedFile());
						ImageIcon imageIcon = new ImageIcon(fitimage(img, upimage.getWidth(), upimage.getHeight()));
						upimage.setIcon(imageIcon);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		upimagebutton.setBounds(453, 288, 144, 27);
		panel_update.add(upimagebutton);

		JButton updatebutton = new JButton("UPDATE");
		updatebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = upname.getText();
				int id = Integer.parseInt(upid.getText());
				String phone = upphone.getText();
				String add = upadd.getText();
				String course = upcourse.getItem(upcourse.getSelectedIndex());
				String duration = upcourseduration.getItem(upcourseduration.getSelectedIndex());
				String fee = uptfee.getText();
				String feepermonth = upfpm.getText();
				String email = upemail.getText();
				String time = uptime.getItem(uptime.getSelectedIndex());
				String paidfee = upfeepaid.getText();
				if(upfeepaid.getText().isBlank()) {
					paidfee = "0";
				}
				int january = upjan.isSelected() ? 1 : 0;
				int february = upfeb.isSelected() ? 1 : 0;
				int march = upmar.isSelected() ? 1 : 0;
				int april = upapr.isSelected() ? 1 : 0;
				int may = upmay.isSelected() ? 1 : 0;
				int june = upjun.isSelected() ? 1 : 0;
				int july = upjul.isSelected() ? 1 : 0;
				int august = upaug.isSelected() ? 1 : 0;
				int september = upsep.isSelected() ? 1 : 0;
				int october = upoct.isSelected() ? 1 : 0;
				int november = upnov.isSelected() ? 1 : 0;
				int december = updec.isSelected() ? 1 : 0;
				String data="";
				int key = Integer.parseInt(updatestudent.getText());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					String data1 ="select feepaid from shashi where id =" + key + "";
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(data1);
					while (rs.next()) {
						data= rs.getString("feepaid");
					}
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Please Fill All Details Carefully!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				String totalfeepaid = Integer.toString(Integer.parseInt(data)+Integer.parseInt(paidfee));

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					if(path==null) {
						PreparedStatement pstmt = connection.prepareStatement("UPDATE shashi SET `name` = '" + name
								+ "', `phone` = '" + phone + "', `add` = '" + add + "', `course` = '" + course
								+ "', `courseduration` = '" + duration + "', `totalfee` = '" + fee + "', `feepermonth` = '"
								+ feepermonth + "',`jan` = '" + january + "', `feb` = '" + february + "', `march` = '"
								+ march + "', `april` = '" + april + "', `may` = '" + may + "', `june` = '" + june
								+ "', `july` = '" + july + "', `august` = '" + august + "', `september` = '" + september
								+ "', `october` = '" + october + "', `november` = '" + november + "', `december` = '"
								+ december + "', `email` = '" + email + "', `time` = '" + time + "', `feepaid` = '" + totalfeepaid
								+ "' WHERE (`id` = '" + id + "');");

//						pstmt.setBinaryStream(1, in, (int) file.length());
						pstmt.executeUpdate();
					}
					else {
					File file = new File(path);
					InputStream in = new FileInputStream(file);

					PreparedStatement pstmt = connection.prepareStatement("UPDATE shashi SET `name` = '" + name
							+ "', `phone` = '" + phone + "', `add` = '" + add + "', `course` = '" + course
							+ "', `courseduration` = '" + duration + "', `totalfee` = '" + fee + "', `feepermonth` = '"
							+ feepermonth + "',`jan` = '" + january + "', `feb` = '" + february + "', `march` = '"
							+ march + "', `april` = '" + april + "', `may` = '" + may + "', `june` = '" + june
							+ "', `july` = '" + july + "', `august` = '" + august + "', `september` = '" + september
							+ "', `october` = '" + october + "', `november` = '" + november + "', `december` = '"
							+ december + "', `email` = '" + email + "', `image` = ?, `time` = '" + time + "', `feepaid` = '" + totalfeepaid
							+ "' WHERE (`id` = '" + id + "');");

					pstmt.setBinaryStream(1, in, (int) file.length());
					pstmt.executeUpdate();
					message.setText("Data Updated Done!");
					
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Please Fill All Details Carefully!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				upid.setText("");
				upname.setText("");
				upphone.setText("");
				upadd.setText("");
				upcourse.select("");
				upcourseduration.select("");
				uptfee.setText("");
				upfpm.setText("");
				upjan.setSelected(false);
				upfeb.setSelected(false);
				upmar.setSelected(false);
				upapr.setSelected(false);
				upmay.setSelected(false);
				upjun.setSelected(false);
				upjul.setSelected(false);
				upaug.setSelected(false);
				upsep.setSelected(false);
				upoct.setSelected(false);
				upnov.setSelected(false);
				updec.setSelected(false);
				upemail.setText("");
				uptime.select("");
				upimage.setIcon(null);

			}
		});
		updatebutton.setBounds(225, 445, 117, 36);
		panel_update.add(updatebutton);
		
		JLabel lblFeePaid = new JLabel("Fee Paid");
		lblFeePaid.setBounds(35, 342, 93, 27);
		panel_update.add(lblFeePaid);
		
		upfeepaid = new JTextField();
		upfeepaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		upfeepaid.setColumns(10);
		upfeepaid.setBounds(138, 343, 182, 23);
		panel_update.add(upfeepaid);
		
		JLabel remaimingshkjgs = new JLabel("Remaining Fee   ");
		remaimingshkjgs.setBounds(35, 370, 93, 27);
		panel_update.add(remaimingshkjgs);
		
		JLabel remaimingshkjgsdsga_1 = new JLabel("Admission Date");
		remaimingshkjgsdsga_1.setBounds(35, 400, 93, 27);
		panel_update.add(remaimingshkjgsdsga_1);
		
		JLabel upremfee_1 = new JLabel(" ");
		upremfee_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		upremfee_1.setBounds(138, 400, 182, 27);
		panel_update.add(upremfee_1);
		
		

		JPanel panel_view = new JPanel();
		panel_view.setBackground(SystemColor.activeCaption);
		panel_view.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_view);
		panel_view.setLayout(null);
		panel_view.setVisible(false);

		viewid = new JTextField();
		viewid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		viewid.setBounds(42, 11, 291, 28);
		panel_view.add(viewid);
		viewid.setColumns(10);

		JLabel getidg;
		getidg = new JLabel("ID");
		getidg.setBounds(32, 93, 97, 28);
		panel_view.add(getidg);

		JLabel getphoneg;
		getphoneg = new JLabel("Phone No");
		getphoneg.setBounds(32, 119, 97, 28);
		panel_view.add(getphoneg);

		JLabel getaddressg;
		getaddressg = new JLabel("Address");
		getaddressg.setBounds(32, 172, 97, 28);
		panel_view.add(getaddressg);

		JLabel getcourseg;
		getcourseg = new JLabel("Course");
		getcourseg.setBounds(32, 197, 97, 28);
		panel_view.add(getcourseg);

		JLabel getcoursedurationg;
		getcoursedurationg = new JLabel("Course Duration");
		getcoursedurationg.setBounds(32, 223, 97, 28);
		panel_view.add(getcoursedurationg);

		JLabel gettotalfeeg;
		gettotalfeeg = new JLabel("Total Fee");
		gettotalfeeg.setBounds(32, 274, 97, 28);
		panel_view.add(gettotalfeeg);

		JLabel getnameg;
		getnameg = new JLabel("Name   ");
		getnameg.setBounds(32, 66, 97, 28);
		panel_view.add(getnameg);

		JLabel getfeepermonthg;
		getfeepermonthg = new JLabel("Fee Per Month");
		getfeepermonthg.setBounds(32, 300, 97, 28);
		panel_view.add(getfeepermonthg);

		JLabel remfeeg = new JLabel("Remaining Fee");
		remfeeg.setBounds(32, 350, 97, 28);
		panel_view.add(remfeeg);

		JLabel feepaidg = new JLabel("Fee Paid");
		feepaidg.setBounds(32, 326, 97, 28);
		panel_view.add(feepaidg);

		JCheckBox getjan = new JCheckBox("January");
		getjan.setBounds(329, 69, 97, 23);
		panel_view.add(getjan);

		JCheckBox getfeb = new JCheckBox("February");
		getfeb.setBounds(329, 96, 97, 23);
		panel_view.add(getfeb);

		JCheckBox getmar = new JCheckBox("March");
		getmar.setBounds(329, 122, 97, 23);
		panel_view.add(getmar);

		JCheckBox getapr = new JCheckBox("April");
		getapr.setBounds(329, 149, 97, 23);
		panel_view.add(getapr);

		JCheckBox getmay = new JCheckBox("May");
		getmay.setBounds(329, 175, 97, 23);
		panel_view.add(getmay);

		JCheckBox getjun = new JCheckBox("June");
		getjun.setBounds(329, 200, 97, 23);
		panel_view.add(getjun);

		JCheckBox getjul = new JCheckBox("July");
		getjul.setBounds(329, 226, 97, 23);
		panel_view.add(getjul);

		JCheckBox getaug = new JCheckBox("August");
		getaug.setBounds(329, 251, 97, 23);
		panel_view.add(getaug);

		JCheckBox getsep = new JCheckBox("September");
		getsep.setBounds(329, 277, 97, 23);
		panel_view.add(getsep);

		JCheckBox getoct = new JCheckBox("October");
		getoct.setBounds(329, 303, 97, 23);
		panel_view.add(getoct);

		JCheckBox getnov = new JCheckBox("November");
		getnov.setBounds(329, 329, 97, 23);
		panel_view.add(getnov);

		JCheckBox getdec = new JCheckBox("December");
		getdec.setBounds(329, 355, 97, 23);
		panel_view.add(getdec);

		JLabel getname = new JLabel();
		getname.setBounds(128, 71, 195, 23);
		panel_view.add(getname);

		JLabel getid = new JLabel();
		getid.setBounds(128, 98, 195, 23);
		panel_view.add(getid);

		JLabel getphone = new JLabel();
		getphone.setBounds(128, 124, 195, 23);
		panel_view.add(getphone);

		JLabel getadd = new JLabel();
		getadd.setBounds(128, 177, 195, 23);
		panel_view.add(getadd);

		JLabel getcourse = new JLabel();
		getcourse.setBounds(128, 202, 195, 23);
		panel_view.add(getcourse);

		JLabel getcourseduration = new JLabel();
		getcourseduration.setBounds(128, 228, 195, 23);
		panel_view.add(getcourseduration);

		JLabel gettotalfee = new JLabel();
		gettotalfee.setBounds(128, 277, 195, 23);
		panel_view.add(gettotalfee);

		JLabel getfeepermonth = new JLabel();
		getfeepermonth.setBounds(128, 305, 195, 23);
		panel_view.add(getfeepermonth);

		JLabel remfee = new JLabel();
		remfee.setBounds(128, 355, 195, 23);
		panel_view.add(remfee);

		JLabel feepaid = new JLabel();
		feepaid.setBounds(128, 326, 195, 23);
		panel_view.add(feepaid);

		JLabel viewimg = new JLabel("");
		viewimg.setBounds(443, 76, 160, 200);
		panel_view.add(viewimg);
		viewimg.setBorder(border);
		JLabel coursetime = new JLabel("Batch-Time  ");
		coursetime.setBounds(32, 248, 97, 28);
		panel_view.add(coursetime);

		JLabel gettime = new JLabel();
		gettime.setBounds(128, 255, 195, 23);
		panel_view.add(gettime);

		JLabel lblEmail1 = new JLabel("Email");
		lblEmail1.setBounds(32, 146, 97, 28);
		panel_view.add(lblEmail1);

		JLabel getemail = new JLabel();
		getemail.setBounds(128, 153, 195, 23);
		panel_view.add(getemail);
		
		JLabel getdate = new JLabel();
		getdate.setBounds(128, 384, 195, 23);
		panel_view.add(getdate);

		JButton viewbutton = new JButton("SEARCH");
		viewbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(viewid.getText());
				int id = 0, jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0,
						nov = 0, dec = 0;
				String name = "", phone = "", email = "", address = "", course = "", courseduration = "", time = "",
						totalfee = "", feepermonth = "",vfeepaid="",date="";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					Statement statement = connection.createStatement();
					String data = "select * from shashi where id =" + key + "";
					ResultSet rs = statement.executeQuery(data);
					while (rs.next()) {
						id = rs.getInt("id");
						name = rs.getString("name");
						phone = rs.getString("phone");
						address = rs.getString("add");
						course = rs.getString("course");
						courseduration = rs.getString("courseduration");
						totalfee = rs.getString("totalfee");
						feepermonth = rs.getString("feepermonth");
						phone = rs.getString("phone");
						jan = rs.getInt("jan");
						feb = rs.getInt("feb");
						mar = rs.getInt("march");
						apr = rs.getInt("april");
						may = rs.getInt("may");
						jun = rs.getInt("june");
						jul = rs.getInt("july");
						aug = rs.getInt("august");
						sep = rs.getInt("september");
						oct = rs.getInt("october");
						nov = rs.getInt("november");
						dec = rs.getInt("december");
						email = rs.getString("email");
						BufferedImage im = ImageIO.read(rs.getBinaryStream("image"));
						ImageIcon imageIcon = new ImageIcon(fitimage(im, viewimg.getWidth(), viewimg.getHeight()));
						viewimg.setIcon(imageIcon);
						time = rs.getString("time");
						vfeepaid=rs.getString("feepaid");
						date = rs.getString("date");
						getid.setText(Integer.toString(id));
						getname.setText(name);
						getphone.setText(phone);
						getadd.setText(address);
						getcourse.setText(course);
						getcourseduration.setText(courseduration);
						gettotalfee.setText(totalfee);
						getfeepermonth.setText(feepermonth);
						getjan.setSelected(jan == 1 ? true : false);
						getfeb.setSelected(feb == 1 ? true : false);
						getmar.setSelected(mar == 1 ? true : false);
						getapr.setSelected(apr == 1 ? true : false);
						getmay.setSelected(may == 1 ? true : false);
						getjun.setSelected(jun == 1 ? true : false);
						getjul.setSelected(jul == 1 ? true : false);
						getaug.setSelected(aug == 1 ? true : false);
						getsep.setSelected(sep == 1 ? true : false);
						getoct.setSelected(oct == 1 ? true : false);
						getnov.setSelected(nov == 1 ? true : false);
						getdec.setSelected(dec == 1 ? true : false);
						getemail.setText(email);
						gettime.setText(time);
						remfee.setText(String.valueOf((Integer.valueOf(totalfee) - (Integer.valueOf(vfeepaid)))));
						feepaid.setText(vfeepaid);
						getdate.setText(date);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		viewbutton.setBounds(385, 11, 105, 28);
		panel_view.add(viewbutton);
		
		JLabel lblAdmissionDate = new JLabel("Admission Date");
		lblAdmissionDate.setBounds(32, 380, 97, 28);
		panel_view.add(lblAdmissionDate);
		
		JLabel getdate1 = new JLabel();
		getdate1.setBounds(128, 384, 195, 23);
		panel_view.add(getdate1);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		JLabel welcome = new JLabel("WELCOME TO AAJIVIKA GLOBAL SKILL PVT. LTD.");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		welcome.setBounds(0, 85, 613, 162);
		panel.add(welcome);
		
		JLabel director = new JLabel("Director:- Shashi Verma");
		director.setHorizontalAlignment(SwingConstants.CENTER);
		director.setFont(new Font("Cooper",Font.BOLD  ,15));
		director.setBounds(0, 110, 613, 162);
		panel.add(director);

		JLabel develop = new JLabel("DEVELOPED BY:-");
		develop.setFont(new Font("Times New Roman", Font.BOLD, 12));
		develop.setBounds(429, 478, 145, 38);
		panel.add(develop);

		JLabel navin = new JLabel("Navin Kumar Verma");
		navin.setBounds(410, 514, 157, 14);
		panel.add(navin);

		JPanel panel_add = new JPanel();
		panel_add.setBackground(SystemColor.activeCaption);
		panel_add.setBounds(161, 11, 613, 539);
		frame.getContentPane().add(panel_add);
		panel_add.setLayout(null);
		panel_add.setVisible(false);

		JLabel setname = new JLabel(" Name              :");
		setname.setBounds(22, 70, 85, 27);
		panel_add.add(setname);

		JLabel setid = new JLabel(" ID                   :");
		setid.setBounds(22, 100, 85, 27);
		panel_add.add(setid);

		JLabel setphone = new JLabel("Phone No        :");
		setphone.setBounds(22, 130, 85, 27);
		panel_add.add(setphone);

		JLabel setadd = new JLabel("Address          :");
		setadd.setBounds(22, 185, 85, 27);
		panel_add.add(setadd);

		addname = new JTextField();
		addname.setBounds(112, 73, 148, 20);
		panel_add.add(addname);
		addname.setColumns(10);

		addid = new JTextField();
		addid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addid.setBounds(112, 103, 148, 20);
		panel_add.add(addid);
		addid.setColumns(10);
		

		addphone = new JTextField();
		addphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addphone.setBounds(112, 133, 149, 20);
		panel_add.add(addphone);
		addphone.setColumns(10);

		addadd = new JTextField();
		addadd.setBounds(112, 188, 148, 20);
		panel_add.add(addadd);
		addadd.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Course            :");
		lblNewLabel_7.setBounds(22, 234, 85, 27);
		panel_add.add(lblNewLabel_7);

		Choice addcourse = new Choice();
		addcourse.setBounds(112, 240, 148, 20);
		addcourse.add("ADCA");
		addcourse.add("DCA");
		addcourse.add("DTP");
		addcourse.add("TALLY");
		addcourse.add("DFA");
		addcourse.add("ADCA+");
		addcourse.add("HINDI TYPING");
		addcourse.add("ENGLISH TYPING");
		addcourse.add("C++");
		addcourse.add("INTERNET");
		panel_add.add(addcourse);

		Checkbox jan = new Checkbox("January");
		jan.setBounds(319, 70, 95, 22);
		panel_add.add(jan);

		Checkbox feb = new Checkbox("February");
		feb.setBounds(319, 100, 95, 22);
		panel_add.add(feb);

		Checkbox mar = new Checkbox("March");
		mar.setBounds(319, 130, 95, 22);
		panel_add.add(mar);

		Checkbox apr = new Checkbox("April");
		apr.setBounds(319, 160, 95, 22);
		panel_add.add(apr);

		Checkbox my = new Checkbox("May");
		my.setBounds(319, 190, 95, 22);
		panel_add.add(my);

		Checkbox jun = new Checkbox("June");
		jun.setBounds(319, 218, 95, 22);
		panel_add.add(jun);

		Checkbox jul = new Checkbox("July");
		jul.setBounds(319, 246, 95, 22);
		panel_add.add(jul);

		Checkbox aug = new Checkbox("August");
		aug.setBounds(319, 274, 95, 22);
		panel_add.add(aug);

		Checkbox sep = new Checkbox("September");
		sep.setBounds(319, 302, 95, 22);
		panel_add.add(sep);

		Checkbox oct = new Checkbox("October");
		oct.setBounds(319, 330, 95, 22);
		panel_add.add(oct);

		Checkbox nov = new Checkbox("November");
		nov.setBounds(319, 358, 95, 22);
		panel_add.add(nov);

		Checkbox dec = new Checkbox("December");
		dec.setBounds(319, 386, 95, 22);
		panel_add.add(dec);

		Label label = new Label("Total Fee         :");
		label.setBounds(22, 292, 85, 27);
		panel_add.add(label);

		addfee = new JTextField();
		addfee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfee.setBounds(112, 292, 148, 20);
		panel_add.add(addfee);
		addfee.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Fee Per Month :");
		lblNewLabel_8.setBounds(22, 325, 85, 27);
		panel_add.add(lblNewLabel_8);

		addfeepermonth = new JTextField();
		addfeepermonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfeepermonth.setBounds(111, 328, 149, 20);
		panel_add.add(addfeepermonth);
		addfeepermonth.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Course Duration:");
		lblNewLabel_9.setBounds(22, 259, 85, 27);
		panel_add.add(lblNewLabel_9);

		Choice choice_duration = new Choice();
		choice_duration.setBounds(112, 266, 148, 20);
		panel_add.add(choice_duration);
		choice_duration.add("1 Month");
		choice_duration.add("2 Month");
		choice_duration.add("3 Month");
		choice_duration.add("4 Month");
		choice_duration.add("5 Month");
		choice_duration.add("6 Month");
		choice_duration.add("7 Month");
		choice_duration.add("8 Month");
		choice_duration.add("9 Month");
		choice_duration.add("10 Month");
		choice_duration.add("11 Month");
		choice_duration.add("12 Month");

		JLabel lblNewLabel1 = new JLabel("Batch-Time  :");
		lblNewLabel1.setBounds(22, 209, 85, 27);
		panel_add.add(lblNewLabel1);

		Choice addtime = new Choice();
		addtime.setBounds(112, 214, 148, 20);
		panel_add.add(addtime);
		addtime.add("6:00 AM-7:00 AM");
		addtime.add("7:00 AM-8:00 AM");
		addtime.add("8:00 AM-9:00 AM");
		addtime.add("9:00 AM-10:00 AM");
		addtime.add("10:00 AM-11:00 AM");
		addtime.add("11:00 AM-12:00 PM");
		addtime.add("12:00 PM-1:00 PM");
		addtime.add("1:00 PM-2:00 PM");
		addtime.add("2:00 PM-3:00 PM");
		addtime.add("3:00 PM-4:00 PM");
		addtime.add("4:00 PM-5:00 PM");
		addtime.add("5:00 PM-6:00 PM");
		addtime.add("6:00 PM-7:00 PM");
		
		JLabel lblAdmissionDate1 = new JLabel("Admission Date :");
		lblAdmissionDate1.setBounds(22, 386, 85, 27);
		panel_add.add(lblAdmissionDate1);
		
		JTextField adddate = new JTextField();
		adddate.setBounds(111, 386, 149, 20);
		panel_add.add(adddate);
		adddate.setText(java.time.LocalDate.now().toString());

		JButton addstudent = new JButton("SAVE");
		addstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String name = addname.getText();
					int id = Integer.parseInt(addid.getText());
					String phone = addphone.getText();
					String add = addadd.getText();
					String course = addcourse.getItem(addcourse.getSelectedIndex());
					String duration = choice_duration.getItem(choice_duration.getSelectedIndex());
					String fee = addfee.getText();
					String feepermonth = addfeepermonth.getText();
					String email = addemail.getText();
					String time = addtime.getItem(addtime.getSelectedIndex());
					String feepaid = addfeepaid.getText();
					if(addfeepaid.getText().isBlank()) {
						feepaid = "0";
					}
					int january = (jan.getState()) ? 1 : 0;
					int february = (feb.getState()) ? 1 : 0;
					int march = mar.getState() ? 1 : 0;
					int april = apr.getState() ? 1 : 0;
					int may = my.getState() ? 1 : 0;
					int june = jun.getState() ? 1 : 0;
					int july = jul.getState() ? 1 : 0;
					int august = aug.getState() ? 1 : 0;
					int september = sep.getState() ? 1 : 0;
					int october = oct.getState() ? 1 : 0;
					int november = nov.getState() ? 1 : 0;
					int december = dec.getState() ? 1 : 0;
					String date =adddate.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					File file = new File(path);
					InputStream in = new FileInputStream(file);
					PreparedStatement pstmt = connection.prepareStatement(
							"INSERT INTO shashi(`id`, `name`, `phone`, `add`, `course`, `courseduration`, `totalfee`, `feepermonth`, `jan`, `feb`, `march`, `april`, `may`, `june`, `july`, `august`, `september`, `october`, `november`, `december`, `email`, `image`, `time`, `feepaid`, `date`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, phone);
					pstmt.setString(4, add);
					pstmt.setString(5, course);
					pstmt.setString(6, duration);
					pstmt.setString(7, fee);
					pstmt.setString(8, feepermonth);
					pstmt.setInt(9, january);
					pstmt.setInt(10, february);
					pstmt.setInt(11, march);
					pstmt.setInt(12, april);
					pstmt.setInt(13, may);
					pstmt.setInt(14, june);
					pstmt.setInt(15, july);
					pstmt.setInt(16, august);
					pstmt.setInt(17, september);
					pstmt.setInt(18, october);
					pstmt.setInt(19, november);
					pstmt.setInt(20, december);
					pstmt.setString(21, email);
					pstmt.setBinaryStream(22, in, (int) file.length());
					pstmt.setString(23, time);
					pstmt.setString(24, feepaid);
					pstmt.setString(25, date);
					pstmt.executeUpdate();
					message.setText("Data Saved Done!");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Please Fill All Details Carefully!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				addid.setText("");
				addname.setText("");
				addphone.setText("");
				addadd.setText("");
				addfee.setText("");
				addfeepermonth.setText("");
				addemail.setText("");
				jan.setState(false);
				feb.setState(false);
				mar.setState(false);
				apr.setState(false);
				my.setState(false);
				jun.setState(false);
				jul.setState(false);
				aug.setState(false);
				sep.setState(false);
				oct.setState(false);
				nov.setState(false);
				dec.setState(false);
				addfeepaid.setText("");

			}
		});
		addstudent.setBounds(252, 470, 121, 38);
		panel_add.add(addstudent);

		JLabel lblNewLabel12 = new JLabel("Email               :");
		lblNewLabel12.setBounds(22, 160, 85, 27);
		panel_add.add(lblNewLabel12);

		addemail = new JTextField();
		addemail.setColumns(10);
		addemail.setBounds(111, 162, 149, 20);
		panel_add.add(addemail);

		JLabel addimg = new JLabel("");
		addimg.setBounds(417, 70, 160, 200);
		panel_add.add(addimg);
		addimg.setBorder(border);
		String path = null;

		JButton browse = new JButton("SELECT IMAGE");
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					path(fc.getSelectedFile().getAbsolutePath());
					BufferedImage img;

					try {
						img = ImageIO.read(fc.getSelectedFile());
						ImageIcon imageIcon = new ImageIcon(fitimage(img, addimg.getWidth(), addimg.getHeight()));
						addimg.setIcon(imageIcon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // it must be an image file, otherwise you'll get an exception

				}
			}
		});
		browse.setBounds(420, 274, 158, 27);
		panel_add.add(browse);
		
		JLabel lblfeepaid = new JLabel("Fee Paid          :");
		lblfeepaid.setBounds(22, 358, 85, 27);
		panel_add.add(lblfeepaid);
		
		addfeepaid = new JTextField();
		addfeepaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		addfeepaid.setColumns(10);
		addfeepaid.setBounds(111, 358, 149, 20);
		panel_add.add(addfeepaid);
		
		

		JButton add = new JButton("ADD STUDENT");
		add.setBounds(10, 241, 141, 53);
		frame.getContentPane().add(add);
		add.setBackground(Color.white);
		
		JButton view = new JButton(" VIEW STUDENT");
		view.setBounds(10, 305, 141, 53);
		frame.getContentPane().add(view);
		view.setBackground(Color.white);

		JButton delete = new JButton(" DELETE STUDENT");
		delete.setBounds(10, 433, 141, 53);
		frame.getContentPane().add(delete);
		delete.setBackground(Color.white);

		JButton update = new JButton("UPDATE STUDENT");
		update.setBounds(10, 369, 141, 53);
		frame.getContentPane().add(update);
		update.setBackground(Color.white);

		JButton home = new JButton("HOME");
		home.setBounds(10, 177, 141, 53);
		frame.getContentPane().add(home);
		home.setBackground(Color.white);

		JButton all = new JButton("ALL STUDENT");
		all.setBounds(10, 497, 141, 53);
		frame.getContentPane().add(all);
		all.setBackground(Color.white);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_view.setVisible(false);
				panel_update.setVisible(false);
				panel_delete.setVisible(false);
				panel_add.setVisible(true);
				panel_all.setVisible(false);
				home.setBackground(Color.white);
				add.setBackground(Color.green);
				update.setBackground(Color.white);
				view.setBackground(Color.white);
				delete.setBackground(Color.white);
				all.setBackground(Color.white);
			}
		});
		
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_view.setVisible(true);
				panel_update.setVisible(false);
				panel_delete.setVisible(false);
				panel_add.setVisible(false);
				panel_all.setVisible(false);
				home.setBackground(Color.white);
				add.setBackground(Color.white);
				update.setBackground(Color.white);
				view.setBackground(Color.green);
				delete.setBackground(Color.white);
				all.setBackground(Color.white);

			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_view.setVisible(false);
				panel_update.setVisible(false);
				panel_delete.setVisible(true);
				panel_add.setVisible(false);
				panel_all.setVisible(false);
				home.setBackground(Color.white);
				add.setBackground(Color.white);
				update.setBackground(Color.white);
				view.setBackground(Color.white);
				delete.setBackground(Color.green);
				all.setBackground(Color.white);
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_view.setVisible(false);
				panel_update.setVisible(true);
				panel_delete.setVisible(false);
				panel_add.setVisible(false);
				panel_all.setVisible(false);
				home.setBackground(Color.white);
				add.setBackground(Color.white);
				update.setBackground(Color.green);
				view.setBackground(Color.white);
				delete.setBackground(Color.white);
				all.setBackground(Color.white);
			}
		});
		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_view.setVisible(false);
				panel_update.setVisible(false);
				panel_delete.setVisible(false);
				panel_add.setVisible(false);
				panel_all.setVisible(false);
				home.setBackground(Color.green);
				add.setBackground(Color.white);
				update.setBackground(Color.white);
				view.setBackground(Color.white);
				delete.setBackground(Color.white);
				all.setBackground(Color.white);
				
			}
		});
		
		
		
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_view.setVisible(false);
				panel_update.setVisible(false);
				panel_delete.setVisible(false);
				panel_add.setVisible(false);
				panel_all.setVisible(true);
				home.setBackground(Color.white);
				add.setBackground(Color.white);
				update.setBackground(Color.white);
				view.setBackground(Color.white);
				delete.setBackground(Color.white);
				all.setBackground(Color.green);
				int id = 0;
				String name = "", phone = "", time = "", remfee = "";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_record",
							"root", "navin");
					Statement statement = connection.createStatement();
					String data = "select id,name,phone,time,feepaid from shashi";
					ResultSet rs = statement.executeQuery(data);
					String record = "";
					while (rs.next()) {
						id = rs.getInt("id");
						name = rs.getString("name");
						phone = rs.getString("phone");
						time = rs.getString("time");
						remfee = rs.getString("feepaid");
						record += ("   " + "\n" + "ID: " + Integer.toString(id) + "\t" + "NAME: " + name + "\t"
								+ "PHONE: " + phone + "\t" + "TIME: " + time + "\t" + "PAID FEE: " + remfee+"\n"+"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}
					textArea.setText(record);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
}
