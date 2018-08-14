package com.caitaojun.generatecode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.caitaojun.utils.MybatisGenerate;

public class CtjCodeGenerator extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void generate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CtjCodeGenerator frame = new CtjCodeGenerator();
					MybatisGenerate.currentJframe = frame;
					frame.addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosing(WindowEvent e) {
							super.windowClosing(e);
						}
						
					});
					frame.setIconImage(new ImageIcon(CtjCodeGenerator.class.getResource("/com/caitaojun/res/ctj.png")).getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CtjCodeGenerator() {
		setResizable(false);
		setTitle("代码生成器----by:ctj   www.caitaojun.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1000, 500);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
		);
		
		StrutsSpringJpaEasyuiJpanel strutsSpringJpaEasyuiJpnel = new StrutsSpringJpaEasyuiJpanel();
		tabbedPane.addTab("struts2+spring+jpa", new ImageIcon(CtjCodeGenerator.class.getResource("/com/caitaojun/res/jpa.png")), strutsSpringJpaEasyuiJpnel, null);
		
		SpringmvcSpringJpaEasyuiJpanel springmvcSpringJpaEasyuiJpanel = new SpringmvcSpringJpaEasyuiJpanel();
		tabbedPane.addTab("springmvc+spring+jpa", new ImageIcon(CtjCodeGenerator.class.getResource("/com/caitaojun/res/jpa.png")), springmvcSpringJpaEasyuiJpanel, null);
		
		
		
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("springmvc+spring+mybatis+easyui模板", new ImageIcon("mybatis.png"), panel, null);
		
		SpringmvcSpringMybatisEasyuiJpanel springMybatisEasyuiJpanel = new SpringmvcSpringMybatisEasyuiJpanel();
		tabbedPane.addTab("springmvc+spring+mybatis", new ImageIcon(CtjCodeGenerator.class.getResource("/com/caitaojun/res/mybatis.png")), springMybatisEasyuiJpanel, null);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("window"));
//		JEditorPane editorPane = new JEditorPane();
//		editorPane.setSize(600, 600);
//		editorPane.setContentType("text/html");
//		editorPane.setEditable(false);
//		try {
//			editorPane.setPage("<a href='http://www.caitaojun.com/ccblog/ArticleInfoServlet?aid=d3ff1affccd540a88b2634215479ca8a&category=2'>使用说明</a>");
//			panel_3.add(editorPane);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
//		JEditorPane editorPane = new JEditorPane();
//		editorPane.setSize(600, 600);
//		editorPane.setContentType("text/html");
//		editorPane.setEditable(false);
//		StringBuffer content = new StringBuffer();
//		content.append("<h2>使用说明</h2>");
//		content.append("<a href='http://www.caitaojun.com' target='_blank'>点击链接查看</a>");
//		editorPane.setText(content.toString());
//		panel_3.add(editorPane);
		
		JLabel label = new JLabel("点击链接查看");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					Runtime.getRuntime().exec("explorer http://www.caitaojun.com");
					Desktop.getDesktop().browse(new URI("http://www.caitaojun.com"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		label.setForeground(Color.red);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel contact = new JLabel("[点击加入]技术交流QQ群：646224436");
		contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://shang.qq.com/wpa/qunwpa?idkey=9c5651888557db6405086238a9168bd171c3df0b58797188fc3d5391266bf07c"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		contact.setForeground(Color.red);
//		JPanel jPanel = new JPanel(){
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			protected void paintComponent(Graphics g) {
//				ImageIcon icon = new ImageIcon("qq.png");
//                Image img = icon.getImage();  
//                g.drawImage(img, 0, 0, icon.getIconWidth(),  
//                        icon.getIconHeight(), icon.getImageObserver());  
//			}
//		};
		
		JLabel showImgLable = new DynGifLabel(new ImageIcon(CtjCodeGenerator.class.getResource("/com/caitaojun/res/haha.gif")).getImage());
//		JLabel showImgLable = new DynGifLabel(new ImageIcon("haha.gif").getImage());
//		showImgLable.setIcon(new ImageIcon("haha.gif"));
		showImgLable.setHorizontalAlignment(SwingConstants.CENTER);
		
		contact.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.setLayout(new BorderLayout(3, 3));
		panel_3.add(label,BorderLayout.NORTH);
//		panel_3.add(jPanel,BorderLayout.CENTER);
		panel_3.add(showImgLable,BorderLayout.CENTER);
		panel_3.add(contact,BorderLayout.SOUTH);
		
		
		tabbedPane.addTab("使用说明", new ImageIcon(CtjCodeGenerator.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")), panel_3, null);
		tabbedPane.setSelectedIndex(0);
		getContentPane().setLayout(groupLayout);
		
	}
	
}
