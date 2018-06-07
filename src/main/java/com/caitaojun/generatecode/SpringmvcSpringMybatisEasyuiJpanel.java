package com.caitaojun.generatecode;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.mybatis.generator.api.IntrospectedTable;

import com.caitaojun.utils.JarFileResUtil;
import com.caitaojun.utils.JdbcUtil;
import com.caitaojun.utils.MybatisGenerate;
import com.caitaojun.utils.StringUtil;
import com.caitaojun.utils.ThreadLocalAllDomainJavaProperties;
import com.caitaojun.utils.ThreadLocalCurrentIntrospectedTable;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SpringmvcSpringMybatisEasyuiJpanel extends JPanel {
	private JTextField url;
	private JTextField username;
	private JTextField password;
	private JTextField txtComnetdomain;
	private JTextField txtComnetmapper;
	private JTextField txtComnetdao;
	private JTextField txtComnetservice;
	private JTextField txtComnetwebcontroller;
	private JTextField txtWebapppages;
	boolean isConnected = false;
	private Connection connection;
//	private Map<String,List<Map<String, String>>> data = new HashMap<>();
//	private Map<String,Map<String,List<Map<String, String>>>> data_new = new HashMap<>();
	private Map<String,Map<String,Object>> data_new = new HashMap<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SpringmvcSpringMybatisEasyuiJpanel() {
		init();
	}
	
	private void init(){
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_6 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
				.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
		);
		
		final JCheckBox checkcover = new JCheckBox("覆盖");
		
		final JCheckBox chckbxexample = new JCheckBox("启用example");
		
		final JCheckBox chckbxmodel = new JCheckBox("生成domain");
		chckbxmodel.setSelected(true);
		chckbxmodel.setEnabled(false);
		
		final JCheckBox chckbxmapper = new JCheckBox("生成mapper");
		
		final JCheckBox chckbxservice = new JCheckBox("生成service");
		
		final JCheckBox chckbxcontroller = new JCheckBox("生成controller");
		
		final JCheckBox chckbxhtml = new JCheckBox("生成html");
		
		JButton button_2 = new JButton("生成");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(checkcover)
					.addGap(39)
					.addComponent(chckbxexample)
					.addGap(42)
					.addComponent(chckbxmodel)
					.addGap(43)
					.addComponent(chckbxmapper)
					.addGap(48)
					.addComponent(chckbxservice)
					.addGap(50)
					.addComponent(chckbxcontroller)
					.addGap(30)
					.addComponent(chckbxhtml)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(button_2)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
								.addComponent(checkcover)
								.addComponent(chckbxexample)
								.addComponent(chckbxmodel)
								.addComponent(chckbxmapper)
								.addComponent(chckbxservice)
								.addComponent(chckbxcontroller)
								.addComponent(chckbxhtml))
							.addGap(25))
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(button_2)
							.addContainerGap())))
		);
		panel_6.setLayout(gl_panel_6);
		
		JLabel label_6 = new JLabel("数据表选择");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(464, Short.MAX_VALUE)
					.addComponent(label_6)
					.addGap(465))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
		);
		
		final JPanel tableShowPanel = new JPanel();
		scrollPane.setViewportView(tableShowPanel);
		tableShowPanel.setLayout(new GridLayout(0, 6, 0, 0));
		panel_4.setLayout(gl_panel_4);
		
		JLabel label_5 = new JLabel("路径配置");
		
		JLabel lblModel = new JLabel("domain：");
		
		txtComnetdomain = new JTextField();
		txtComnetdomain.setText("com.caitaojun.domain");
		txtComnetdomain.setColumns(10);
		
		JLabel lblMapper = new JLabel("mapper：");
		
		txtComnetmapper = new JTextField();
		txtComnetmapper.setText("com/caitaojun/mapper");
		txtComnetmapper.setColumns(10);
		
		JLabel lblDao = new JLabel("dao：");
		
		txtComnetdao = new JTextField();
		txtComnetdao.setText("com.caitaojun.mapper");
		txtComnetdao.setColumns(10);
		
		JLabel lblService = new JLabel("service：");
		
		txtComnetservice = new JTextField();
		txtComnetservice.setText("com.caitaojun.service");
		txtComnetservice.setColumns(10);
		
		JLabel lblController = new JLabel("controller：");
		
		txtComnetwebcontroller = new JTextField();
		txtComnetwebcontroller.setText("com.caitaojun.web.controller");
		txtComnetwebcontroller.setColumns(10);
		
		JLabel lblHtml = new JLabel("html：");
		
		txtWebapppages = new JTextField();
		txtWebapppages.setText("src/main/webapp/pages");
		txtWebapppages.setColumns(10);
		
		JButton button_1 = new JButton("确定");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblModel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtComnetdomain, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(lblMapper)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtComnetmapper, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(lblDao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtComnetdao, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(214, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblService)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtComnetservice, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblController)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtComnetwebcontroller, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(lblHtml)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWebapppages, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(button_1)
							.addContainerGap())))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(468)
					.addComponent(label_5)
					.addContainerGap(471, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(label_5)
					.addGap(28)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModel)
						.addComponent(txtComnetdomain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMapper)
						.addComponent(txtComnetmapper, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDao)
						.addComponent(txtComnetdao, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblService)
						.addComponent(txtComnetservice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblController)
						.addComponent(txtComnetwebcontroller, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHtml)
						.addComponent(txtWebapppages, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblJdbc = new JLabel("jdbc连接");
		
		JLabel label = new JLabel("数据库类型：");
		
		final JComboBox dbType = new JComboBox();
		dbType.setModel(new DefaultComboBoxModel(new String[] {"Mysql","Oracle"}));
		
		JLabel label_1 = new JLabel("连接地址：");
		
		url = new JTextField();
		url.setText("jdbc:mysql:///test");
		url.setColumns(10);
		
		JLabel label_2 = new JLabel("用户名：");
		
		username = new JTextField();
		username.setText("root");
		username.setColumns(10);
		
		JLabel label_3 = new JLabel("密码：");
		
		password = new JTextField();
		password.setText("123");
		password.setColumns(10);
		
		JButton button = new JButton("连接");
		final JLabel connectedInfo = new JLabel("未连接...");
		connectedInfo.setForeground(Color.red);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urlStr = url.getText().trim();
				String usernameStr = username.getText().trim();
				String passwordStr = password.getText().trim();
				try {
					connection = JdbcUtil.getConnection(urlStr, usernameStr, passwordStr, dbType.getSelectedItem()+"");
					if(null!=connection&&!connection.isClosed()){
						isConnected = true;
						connectedInfo.setText("已连接...");
						connectedInfo.setForeground(Color.green);
						ArrayList<List> execInfoList = null;
						if(dbType.getSelectedItem().equals("Mysql")){
							execInfoList = JdbcUtil.readConst("show tables;", connection);
						}else if(dbType.getSelectedItem().equals("Oracle")){
							execInfoList = JdbcUtil.readConst("select tname from tab", connection);
						}
						final List<String> tables = JdbcUtil.readTables(execInfoList);
						tableShowPanel.removeAll();
						for (final String tableName : tables) {
							//System.out.println(tableName);
//							JCheckBox tableCheckbox = new JCheckBox(tableName);
							tableShowPanel.add(new JCheckBox(tableName));
							JButton jButton = new JButton("设置"+tableName);
							jButton.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									final String actionCommand = e.getActionCommand().substring(2);
									//勾选按钮对应的checkbox
									Component[] components = tableShowPanel.getComponents();
									for (Component component : components) {
										if(component instanceof JCheckBox){
											if(((JCheckBox) component).getText().equals(tableName)){
												((JCheckBox) component).setSelected(true);
											}
										}
									}
									
									JDialog internal = new JDialog(MybatisGenerate.currentJframe, "属性设置", true);
									internal.setIconImage(new ImageIcon("ctj.png").getImage());
									internal.setResizable(false);
									internal.setSize(1200, 500);
									//internal.setResizable(false);
									internal.setLocationRelativeTo(null);
									JPanel internal_panel_1 = new JPanel();
									JLabel label = new JLabel("表："+actionCommand+",请为以下数据表列添加生成对应实体的属性字段名称");
									
									final JPanel internal_panel_2 = new JPanel();
									GroupLayout groupLayout = new GroupLayout(internal.getContentPane());
									groupLayout.setHorizontalGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(265)
												.addComponent(label)
												.addContainerGap(295, Short.MAX_VALUE))
											.addComponent(internal_panel_1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
											.addComponent(internal_panel_2, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
									);
									groupLayout.setVerticalGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(internal_panel_1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(internal_panel_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
												.addContainerGap(87, Short.MAX_VALUE))
									);
									
									final JPanel tableRelationPanel = new JPanel();
									JButton addRelationButton = new JButton("添加");
									JComboBox generateRelationTypeComboBox = new JComboBox();
									final ComboBoxModel generateRelationTypeComboBoxModel = new DefaultComboBoxModel<>(new String[]{"一对一", "一对多", "多对一", "多对多"});
									generateRelationTypeComboBox.setModel(generateRelationTypeComboBoxModel);
									JLabel generateClassNameLabel = new JLabel("生成类名");
									final JTextField generateClassName = new JTextField();
									generateClassName.setColumns(10);
									addRelationButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											//对关联关系combobox设置改变事件  如果是一对多那么就  
											//对方主键列名  改为  对方外键列名（我方在对方当中的列名（外键列名））
											//对方在我方当中的列名  改为  我方主键列名
											if(generateRelationTypeComboBoxModel.getSelectedItem().equals("一对一")){
												createOne2OnePanel(tables, tableName, tableRelationPanel,
														generateRelationTypeComboBoxModel);
											}else if(generateRelationTypeComboBoxModel.getSelectedItem().equals("一对多")){
												createOne2ManyPanel(tables, tableName, tableRelationPanel,
														generateRelationTypeComboBoxModel);
											}else if(generateRelationTypeComboBoxModel.getSelectedItem().equals("多对一")){
												createOne2OnePanel(tables, tableName, tableRelationPanel,
														generateRelationTypeComboBoxModel);
											}else if(generateRelationTypeComboBoxModel.getSelectedItem().equals("多对多")){
												createMany2ManyPanel(tables, actionCommand,tableRelationPanel,
														generateRelationTypeComboBoxModel);
											}
										}

										private void createMany2ManyPanel(final List<String> tables,
												final String tableName, final JPanel tableRelationPanel,
												final ComboBoxModel generateRelationTypeComboBoxModel) {
											JLabel lelationTypeLable = new JLabel("关联关系");
											JComboBox lelationTypeComboBox = new JComboBox();
											lelationTypeComboBox.setName("relationType");
											lelationTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {generateRelationTypeComboBoxModel.getSelectedItem()+""}));
											
											JLabel partyTableLabel = new JLabel("对方表");
											JComboBox partyTableComboBox = new JComboBox();
											partyTableComboBox.setName("partyTable");
											DefaultComboBoxModel partyTableComboBoxModel = new DefaultComboBoxModel<>();
											for (String tabName : tables) {
												partyTableComboBoxModel.addElement(tabName);
											}
											partyTableComboBox.setModel(partyTableComboBoxModel);
											
											//对方类名
											JLabel partyClassNameLabel = new JLabel("对方类名");
											JTextField partyClassNameTextField = new JTextField();
											partyClassNameTextField.setColumns(6);
											partyClassNameTextField.setName("partyClassName");
											
											final JLabel partyPrimaryKeyColumnLabel = new JLabel("对方主键列");
											final JComboBox partyPrimaryKeyColumnComboBox = new JComboBox();
											partyPrimaryKeyColumnComboBox.setName("partyPrimaryKeyColumn");
											final DefaultComboBoxModel partyPrimaryKeyColumnComboBoxAModel = new DefaultComboBoxModel<>();
											
											partyTableComboBox.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													String selectTableName = ((JComboBox)e.getSource()).getSelectedItem()+"";
													partyPrimaryKeyColumnComboBoxAModel.removeAllElements();
													ArrayList<List> ddlInfo = null;
													try {
														if(dbType.getSelectedItem().equals("Mysql")){
															ddlInfo = JdbcUtil.readConst("desc "+selectTableName, connection);
														}else if(dbType.getSelectedItem().equals("Oracle")){
															ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+selectTableName+"'", connection);
														}
														List<String> fileds = JdbcUtil.readFileds(ddlInfo);
														for (String column : fileds) {
															partyPrimaryKeyColumnComboBoxAModel.addElement(column);
														}
														partyPrimaryKeyColumnComboBox.setModel(partyPrimaryKeyColumnComboBoxAModel);
													} catch (Exception e1) {
														e1.printStackTrace();
													}
												}
											});
											
//												String firstTableName = tables.get(0);
											String firstTableName = (String) partyTableComboBox.getSelectedItem();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+firstTableName, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+firstTableName+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													partyPrimaryKeyColumnComboBoxAModel.addElement(column);
												}
												partyPrimaryKeyColumnComboBox.setModel(partyPrimaryKeyColumnComboBoxAModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											//对方列对应属性字段名称
											JLabel partyFieldNameLabel = new JLabel("对方主键属性名");
											JTextField partyFieldNameTextField = new JTextField();
											partyFieldNameTextField.setColumns(6);
											partyFieldNameTextField.setName("partyPrimaryKeyFieldName");
											
											JLabel partyInMyClassFieldNameLabel = new JLabel("对方在我方当中的属性名");
											JTextField partyInMyClassFieldNameTextField = new JTextField();
											partyInMyClassFieldNameTextField.setColumns(6);
											partyInMyClassFieldNameTextField.setName("partyInMyClassFieldName");
											
											JLabel myPrimaryKeyColumnLabel = new JLabel("我方主键列");
											JComboBox myPrimaryKeyColumnComboBox = new JComboBox();
											myPrimaryKeyColumnComboBox.setName("myPrimaryKeyColumn");
											DefaultComboBoxModel myPrimaryKeyColumnComboBoxModel = new DefaultComboBoxModel();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+actionCommand, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+actionCommand+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													myPrimaryKeyColumnComboBoxModel.addElement(column);
												}
												myPrimaryKeyColumnComboBox.setModel(myPrimaryKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											
											JLabel myPrimaryKeyFieldNameLabel = new JLabel("我方主键属性名");
											JTextField myPrimaryKeyFieldNameTextField = new JTextField();
											myPrimaryKeyFieldNameTextField.setColumns(6);
											myPrimaryKeyFieldNameTextField.setName("myPrimaryKeyFieldName");
											
											JLabel inMiddleTableLabel = new JLabel("中间表");
											JComboBox inMiddleTableComboBox = new JComboBox();
											inMiddleTableComboBox.setName("inMiddleTable");
											DefaultComboBoxModel inMiddleTableComboBoxModel = new DefaultComboBoxModel();
											try {
												for (String tab : tables) {
													inMiddleTableComboBoxModel.addElement(tab);
												}
												inMiddleTableComboBox.setModel(inMiddleTableComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											JLabel inMiddleTableMyForeginKeyColumnLabel = new JLabel("中间表我方外键列");
											final JComboBox inMiddleTableMyForeginKeyColumnComboBox = new JComboBox();
											inMiddleTableMyForeginKeyColumnComboBox.setName("inMiddleTableMyForeginKeyColumn");
											final DefaultComboBoxModel inMiddleTableMyForeginKeyColumnComboBoxModel = new DefaultComboBoxModel();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+inMiddleTableComboBox.getSelectedItem(), connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+inMiddleTableComboBox.getSelectedItem()+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													inMiddleTableMyForeginKeyColumnComboBoxModel.addElement(column);
												}
												inMiddleTableMyForeginKeyColumnComboBox.setModel(inMiddleTableMyForeginKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											JLabel inMiddleTablePartyForeginKeyColumnLabel = new JLabel("中间表对方外键列名");
											final JComboBox inMiddleTablePartyForeginKeyColumnComboBox = new JComboBox();
											inMiddleTablePartyForeginKeyColumnComboBox.setName("inMiddleTablePartyForeginKeyColumn");
											final DefaultComboBoxModel inMiddleTablePartyForeginKeyColumnComboBoxModel = new DefaultComboBoxModel();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+inMiddleTableComboBox.getSelectedItem(), connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+inMiddleTableComboBox.getSelectedItem()+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													inMiddleTablePartyForeginKeyColumnComboBoxModel.addElement(column);
												}
												inMiddleTablePartyForeginKeyColumnComboBox.setModel(inMiddleTablePartyForeginKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											inMiddleTableComboBox.addItemListener(new ItemListener() {
												@Override
												public void itemStateChanged(ItemEvent e) {
													String selectTableName = ((JComboBox)e.getSource()).getSelectedItem()+"";
													inMiddleTableMyForeginKeyColumnComboBoxModel.removeAllElements();
													inMiddleTablePartyForeginKeyColumnComboBoxModel.removeAllElements();
													ArrayList<List> ddlInfo;
													try {
														ddlInfo = null;
														if(dbType.getSelectedItem().equals("Mysql")){
															ddlInfo = JdbcUtil.readConst("desc "+selectTableName, connection);
														}else if(dbType.getSelectedItem().equals("Oracle")){
															ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+selectTableName+"'", connection);
														}
														List<String> fileds = JdbcUtil.readFileds(ddlInfo);
														for (String column : fileds) {
															inMiddleTableMyForeginKeyColumnComboBoxModel.addElement(column);
															inMiddleTablePartyForeginKeyColumnComboBoxModel.addElement(column);
														}
														inMiddleTablePartyForeginKeyColumnComboBox.setModel(inMiddleTablePartyForeginKeyColumnComboBoxModel);
														inMiddleTableMyForeginKeyColumnComboBox.setModel(inMiddleTableMyForeginKeyColumnComboBoxModel);
													} catch (Exception e1) {
														e1.printStackTrace();
													}
												}
											});
											
											//删除按钮
											JButton removeItem = new JButton("删除");
											removeItem.setForeground(Color.red);
											removeItem.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													JButton jb = ((JButton)e.getSource());
													tableRelationPanel.remove(jb.getParent());
													tableRelationPanel.updateUI();
												}
											});
											
											final JPanel panel_6 = new JPanel();
											panel_6.setBorder(new LineBorder(Color.black));
											
											panel_6.add(lelationTypeLable);
											panel_6.add(lelationTypeComboBox);
											panel_6.add(partyTableLabel);
											panel_6.add(partyTableComboBox);
											panel_6.add(partyClassNameLabel);
											panel_6.add(partyClassNameTextField);
											panel_6.add(partyPrimaryKeyColumnLabel);
											panel_6.add(partyPrimaryKeyColumnComboBox);
											panel_6.add(partyFieldNameLabel);
											panel_6.add(partyFieldNameTextField);
											panel_6.add(partyInMyClassFieldNameLabel);
											panel_6.add(partyInMyClassFieldNameTextField);
											panel_6.add(myPrimaryKeyColumnLabel);
											panel_6.add(myPrimaryKeyColumnComboBox);
											panel_6.add(myPrimaryKeyFieldNameLabel);
											panel_6.add(myPrimaryKeyFieldNameTextField);
											panel_6.add(inMiddleTableLabel);
											panel_6.add(inMiddleTableComboBox);
											panel_6.add(inMiddleTableMyForeginKeyColumnLabel);
											panel_6.add(inMiddleTableMyForeginKeyColumnComboBox);
											panel_6.add(inMiddleTablePartyForeginKeyColumnLabel);
											panel_6.add(inMiddleTablePartyForeginKeyColumnComboBox);
											panel_6.add(removeItem);
											panel_6.updateUI();
											
											tableRelationPanel.add(panel_6);
											tableRelationPanel.updateUI();
										}

										//创建一对多面板
										private void createOne2ManyPanel(final List<String> tables,
												final String tableName, final JPanel tableRelationPanel,
												final ComboBoxModel generateRelationTypeComboBoxModel) {
											JLabel relationTypeLabel = new JLabel("关联关系");
											JComboBox relationTypeComboBox = new JComboBox();
											relationTypeComboBox.setName("relationType");
											relationTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {generateRelationTypeComboBoxModel.getSelectedItem()+""}));
											
											JLabel partyTableLabel = new JLabel("对方表");
											JComboBox partyTableComboBox = new JComboBox();
											partyTableComboBox.setName("partyTable");
											DefaultComboBoxModel partyTableComboBoxModel = new DefaultComboBoxModel<>();
											for (String tabName : tables) {
												partyTableComboBoxModel.addElement(tabName);
											}
											partyTableComboBox.setModel(partyTableComboBoxModel);
											
											//对方类名
											JLabel partyClassNameLabel = new JLabel("对方类名");
											JTextField partyClassNameTextField = new JTextField();
											partyClassNameTextField.setColumns(6);
											partyClassNameTextField.setName("partyClassName");
											
											final JLabel inPartyTableMyForeginKeyColumnLabel = new JLabel("我在对方中的外键列");
											final JComboBox inPartyTableMyForeginKeyColumnComboBox = new JComboBox();
											inPartyTableMyForeginKeyColumnComboBox.setName("inPartyTableMyForeginKeyColumn");
											final DefaultComboBoxModel inPartyTableMyForeginKeyColumnComboBoxModel = new DefaultComboBoxModel<>();
											final DefaultComboBoxModel partyPrimaryKeyColumnComboBoxModel = new DefaultComboBoxModel<>();
											
											partyTableComboBox.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													String selectTableName = ((JComboBox)e.getSource()).getSelectedItem()+"";
													inPartyTableMyForeginKeyColumnComboBoxModel.removeAllElements();
													partyPrimaryKeyColumnComboBoxModel.removeAllElements();
													ArrayList<List> ddlInfo;
													try {
														ddlInfo = null;
														if(dbType.getSelectedItem().equals("Mysql")){
															ddlInfo = JdbcUtil.readConst("desc "+selectTableName, connection);
														}else if(dbType.getSelectedItem().equals("Oracle")){
															ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+selectTableName+"'", connection);
														}
														List<String> fileds = JdbcUtil.readFileds(ddlInfo);
														for (String column : fileds) {
															inPartyTableMyForeginKeyColumnComboBoxModel.addElement(column);
															partyPrimaryKeyColumnComboBoxModel.addElement(column);
														}
														inPartyTableMyForeginKeyColumnComboBox.setModel(inPartyTableMyForeginKeyColumnComboBoxModel);
													} catch (Exception e1) {
														e1.printStackTrace();
													}
												}
											});
											
											
											String firstTableName = (String) partyTableComboBox.getSelectedItem();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+firstTableName, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+firstTableName+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													inPartyTableMyForeginKeyColumnComboBoxModel.addElement(column);
													partyPrimaryKeyColumnComboBoxModel.addElement(column);
												}
												inPartyTableMyForeginKeyColumnComboBox.setModel(inPartyTableMyForeginKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											//对方列对应属性字段名称
											JLabel partyPrimaryKeyFieldNameLabel = new JLabel("对方主键属性名");
											JTextField partyFieldNameTextField = new JTextField();
											partyFieldNameTextField.setColumns(6);
											partyFieldNameTextField.setName("partyPrimaryKeyFieldName");
											
											final JLabel myPrimaryKeyColumnLable = new JLabel("我方主键列名");
											final JComboBox myPrimaryKeyColumnComboBox = new JComboBox();
											myPrimaryKeyColumnComboBox.setName("myPrimaryKeyColumn");
											final DefaultComboBoxModel myPrimaryKeyColumnComboBoxModel = new DefaultComboBoxModel<>();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+tableName, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+tableName+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													myPrimaryKeyColumnComboBoxModel.addElement(column);
												}
												myPrimaryKeyColumnComboBox.setModel(myPrimaryKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											
											JLabel partyInMyClassFieldNameLable = new JLabel("对方在我方当中的属性名");
											JTextField partyInMyClassFieldNameTextField = new JTextField();
											partyInMyClassFieldNameTextField.setColumns(6);
											partyInMyClassFieldNameTextField.setName("partyInMyClassFieldName");
											
											//删除按钮
											JButton removeItem = new JButton("删除");
											removeItem.setForeground(Color.red);
											removeItem.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													JButton jb = ((JButton)e.getSource());
													tableRelationPanel.remove(jb.getParent());
													tableRelationPanel.updateUI();
												}
											});
											
											final JPanel panel_6 = new JPanel();
											panel_6.setBorder(new LineBorder(Color.black));
											
											panel_6.add(relationTypeLabel);
											panel_6.add(relationTypeComboBox);
											panel_6.add(partyTableLabel);
											panel_6.add(partyTableComboBox);
											
											panel_6.add(partyClassNameLabel);
											panel_6.add(partyClassNameTextField);
											
											panel_6.add(inPartyTableMyForeginKeyColumnLabel);
											panel_6.add(inPartyTableMyForeginKeyColumnComboBox);
											
											panel_6.add(partyPrimaryKeyFieldNameLabel);
											panel_6.add(partyFieldNameTextField);
											
											panel_6.add(myPrimaryKeyColumnLable);
											panel_6.add(myPrimaryKeyColumnComboBox);
											panel_6.add(partyInMyClassFieldNameLable);
											panel_6.add(partyInMyClassFieldNameTextField);
											
											panel_6.add(removeItem);
											
											JLabel inPartyClassMyFieldNameLabel = new JLabel("我方在对方中的属性名");
											inPartyClassMyFieldNameLabel.setName("inPartyClassMyFieldNameLabel");
											JTextField inPartyClassMyFieldNameTextField = new JTextField();
											inPartyClassMyFieldNameTextField.setColumns(6);
											inPartyClassMyFieldNameTextField.setName("inPartyClassMyFieldName");
											panel_6.add(inPartyClassMyFieldNameLabel, 8);
											panel_6.add(inPartyClassMyFieldNameTextField, 9);

											//对方主键列名
											JLabel partyPrimaryKeyColumnLabel = new JLabel("对方主键列名");
											partyPrimaryKeyColumnLabel.setName("partyPrimaryKeyColumnLabel");
											JComboBox partyPrimaryKeyColumnComboBox = new JComboBox();
											partyPrimaryKeyColumnComboBox.setModel(partyPrimaryKeyColumnComboBoxModel);
											partyPrimaryKeyColumnComboBox.setName("partyPrimaryKeyColumn");
											panel_6.add(partyPrimaryKeyColumnLabel, 10);
											panel_6.add(partyPrimaryKeyColumnComboBox, 11);
											
											tableRelationPanel.add(panel_6);
											tableRelationPanel.updateUI();
										}

										//创建一对一面板
										private void createOne2OnePanel(final List<String> tables,
												final String tableName, final JPanel tableRelationPanel,
												final ComboBoxModel generateRelationTypeComboBoxModel) {
											JLabel relationTypeLabel = new JLabel("关联关系");
											JComboBox relationTypeComboBox = new JComboBox();
											relationTypeComboBox.setName("relationType");
											relationTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {generateRelationTypeComboBoxModel.getSelectedItem()+""}));
											
											JLabel partyTableLabel = new JLabel("对方表");
											JComboBox partyTableComboBox = new JComboBox();
											partyTableComboBox.setName("partyTable");
											DefaultComboBoxModel partyTableComboBoxModel = new DefaultComboBoxModel<>();
											for (String tabName : tables) {
												partyTableComboBoxModel.addElement(tabName);
											}
											partyTableComboBox.setModel(partyTableComboBoxModel);
											
											//对方类名
											JLabel partyClassNameLabel = new JLabel("对方类名");
											JTextField partyClassNameTextField = new JTextField();
											partyClassNameTextField.setColumns(6);
											partyClassNameTextField.setName("partyClassName");
											
											final JLabel partyPrimaryKeyColumnLabel = new JLabel("对方主键列");
											final JComboBox partyPrimaryKeyColumnComboBox = new JComboBox();
											partyPrimaryKeyColumnComboBox.setName("partyPrimaryKeyColumn");
											final DefaultComboBoxModel partyPrimaryKeyColumnComboBoxModel = new DefaultComboBoxModel<>();
											final DefaultComboBoxModel partyPrimaryKeyColumnComboBoxModel2 = new DefaultComboBoxModel<>();
											
											partyTableComboBox.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													String selectTableName = ((JComboBox)e.getSource()).getSelectedItem()+"";
													partyPrimaryKeyColumnComboBoxModel.removeAllElements();
													partyPrimaryKeyColumnComboBoxModel2.removeAllElements();
													ArrayList<List> ddlInfo;
													try {
														ddlInfo = null;
														if(dbType.getSelectedItem().equals("Mysql")){
															ddlInfo = JdbcUtil.readConst("desc "+selectTableName, connection);
														}else if(dbType.getSelectedItem().equals("Oracle")){
															ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+selectTableName+"'", connection);
														}
														List<String> fileds = JdbcUtil.readFileds(ddlInfo);
														for (String column : fileds) {
															partyPrimaryKeyColumnComboBoxModel.addElement(column);
															partyPrimaryKeyColumnComboBoxModel2.addElement(column);
														}
														partyPrimaryKeyColumnComboBox.setModel(partyPrimaryKeyColumnComboBoxModel);
													} catch (Exception e1) {
														e1.printStackTrace();
													}
												}
											});
											
											
											String firstTableName = (String) partyTableComboBox.getSelectedItem();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+firstTableName, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+firstTableName+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													partyPrimaryKeyColumnComboBoxModel.addElement(column);
													partyPrimaryKeyColumnComboBoxModel2.addElement(column);
												}
												partyPrimaryKeyColumnComboBox.setModel(partyPrimaryKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											//对方列对应属性字段名称
											JLabel partyPrimaryKeyFieldNameLabel = new JLabel("对方主键属性名");
											JTextField partyFieldNameTextField = new JTextField();
											partyFieldNameTextField.setColumns(6);
											partyFieldNameTextField.setName("partyPrimaryKeyFieldName");
											
											final JLabel inMyTablePartyForeginKeyColumnLable = new JLabel("对方在我方中的外键列");
											final JComboBox inMyTablePartyForeginKeyColumnComboBox = new JComboBox();
											inMyTablePartyForeginKeyColumnComboBox.setName("inMyTablePartyForeginKeyColumn");
											final DefaultComboBoxModel inMyTablePartyForeginKeyColumnComboBoxModel = new DefaultComboBoxModel<>();
											try {
												ArrayList<List> ddlInfo = null;
												if(dbType.getSelectedItem().equals("Mysql")){
													ddlInfo = JdbcUtil.readConst("desc "+tableName, connection);
												}else if(dbType.getSelectedItem().equals("Oracle")){
													ddlInfo = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+tableName+"'", connection);
												}
												List<String> fileds = JdbcUtil.readFileds(ddlInfo);
												for (String column : fileds) {
													inMyTablePartyForeginKeyColumnComboBoxModel.addElement(column);
												}
												inMyTablePartyForeginKeyColumnComboBox.setModel(inMyTablePartyForeginKeyColumnComboBoxModel);
											} catch (Exception e1) {
												e1.printStackTrace();
											}
											
											
											JLabel partyInMyClassFieldNameLable = new JLabel("对方在我方当中的属性名");
											JTextField partyInMyClassFieldNameTextField = new JTextField();
											partyInMyClassFieldNameTextField.setColumns(6);
											partyInMyClassFieldNameTextField.setName("partyInMyClassFieldName");
											
											//删除按钮
											JButton removeItem = new JButton("删除");
											removeItem.setForeground(Color.red);
											removeItem.addActionListener(new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													JButton jb = ((JButton)e.getSource());
													tableRelationPanel.remove(jb.getParent());
													tableRelationPanel.updateUI();
												}
											});
											
											final JPanel panel_6 = new JPanel();
											panel_6.setBorder(new LineBorder(Color.black));
											
											panel_6.add(relationTypeLabel);
											panel_6.add(relationTypeComboBox);
											panel_6.add(partyTableLabel);
											panel_6.add(partyTableComboBox);
											
											panel_6.add(partyClassNameLabel);
											panel_6.add(partyClassNameTextField);
											
											panel_6.add(partyPrimaryKeyColumnLabel);
											panel_6.add(partyPrimaryKeyColumnComboBox);
											
											panel_6.add(partyPrimaryKeyFieldNameLabel);
											panel_6.add(partyFieldNameTextField);
											
											panel_6.add(inMyTablePartyForeginKeyColumnLable);
											panel_6.add(inMyTablePartyForeginKeyColumnComboBox);
											panel_6.add(partyInMyClassFieldNameLable);
											panel_6.add(partyInMyClassFieldNameTextField);
											
											panel_6.add(removeItem);
											
											tableRelationPanel.add(panel_6);
											tableRelationPanel.updateUI();
										}
									});
									
									JScrollPane scrollPane_1 = new JScrollPane();
									GroupLayout gl_panel_2 = new GroupLayout(internal_panel_2);
										
									gl_panel_2.setHorizontalGroup(
											gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addComponent(addRelationButton)
													.addGap(47)
													.addComponent(generateRelationTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(33)
													.addComponent(generateClassNameLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(generateClassName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addContainerGap(491, Short.MAX_VALUE))
												.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
										);
									gl_panel_2.setVerticalGroup(
										gl_panel_2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_2.createSequentialGroup()
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
													.addComponent(addRelationButton)
													.addComponent(generateClassNameLabel)
													.addComponent(generateClassName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(generateRelationTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
												.addContainerGap())
									);
									
									
									scrollPane_1.setViewportView(tableRelationPanel);
									tableRelationPanel.setLayout(new GridLayout(0, 1, 0, 0));
									internal_panel_2.setLayout(gl_panel_2);
									
									JScrollPane scrollPane = new JScrollPane();
									GroupLayout gl_panel = new GroupLayout(internal_panel_1);
									gl_panel.setHorizontalGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
									);
									gl_panel.setVerticalGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
									);
									
									final JPanel showColumnPanel = new JPanel();
									scrollPane.setViewportView(showColumnPanel);
									showColumnPanel.setLayout(new GridLayout(0, 6, 0, 0));
									
									
									//变量表的字段
									try {
										ArrayList<List> ddlInfoList = null;
										if(dbType.getSelectedItem().equals("Mysql")){
											ddlInfoList = JdbcUtil.readConst("desc "+actionCommand, connection);
										}else if(dbType.getSelectedItem().equals("Oracle")){
											ddlInfoList = JdbcUtil.readConst("select column_name from user_tab_cols where table_name='"+actionCommand+"'", connection);
										}
										List<String> columns = JdbcUtil.readFileds(ddlInfoList);
										for (String column : columns) {
											JCheckBox box = new JCheckBox(column);
											showColumnPanel.add(box);
											JTextField textField = new JTextField();
											textField.setName(column);
											showColumnPanel.add(textField);
											textField.setColumns(10);
										}
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									
									//关闭的时候获取数据
									/**
									 * dialog关闭的时候去获取
										勾选的字段和对应的字段的属性名 如果属性名为空，那么就取和字段名一样
										输入的生成类名
										关联关系：集合
											{
											关联方式、对方表、对方类名、对方列、对方属性名
										}
										
										Map<表名,List<Map<列名，属性名>>>
										Map<String,Map<String,List<Map<String, String>>>>
										
									 */
									internal.addWindowListener(new WindowAdapter() {
										@Override
										public void windowClosing(WindowEvent e) {
											Component[] components = showColumnPanel.getComponents();
											Map<String, Object> tableInfo = new HashMap<>();
											//生成的类名
											tableInfo.put("generateClassName", generateClassName.getText().trim());
											//生成的关联关系
											Component[] relationInfos = tableRelationPanel.getComponents();
											List<RelationTableInfo2> relationTableInfos = new ArrayList<>();
											int count = 0;
											for (Component component : relationInfos) {
												if(component instanceof JPanel){
													Component[] relationTablecfg = ((JPanel) component).getComponents();
													RelationTableInfo2 relationTableInfo = new RelationTableInfo2();
													relationTableInfos.add(relationTableInfo);
													for (Component cp: relationTablecfg) {
														if((cp instanceof JComboBox) && cp.getName().equals("relationType") ){
															if(((JComboBox) cp).getSelectedItem().equals("多对多")){
																count=count+2;
															}else{
																count++;
															}
															relationTableInfo.setTableIndex(count);
															relationTableInfo.setRelationType(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JComboBox)&& cp.getName().equals("partyTable") ){
															relationTableInfo.setPartyTable(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JTextField)&& cp.getName().equals("partyClassName") ){
															relationTableInfo.setPartyClassName(((JTextField) cp).getText().trim());
														}else if((cp instanceof JComboBox) && cp.getName().equals("partyPrimaryKeyColumn")){
															relationTableInfo.setPartyPrimaryKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JComboBox)&& cp.getName().equals("inPartyTableMyForeginKeyColumn") ){
															relationTableInfo.setInPartyTableMyForeginKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JTextField) && cp.getName().equals("partyPrimaryKeyFieldName")){
															relationTableInfo.setPartyPrimaryKeyFieldName(((JTextField) cp).getText().trim());
														}else if((cp instanceof JComboBox) && cp.getName().equals("inMyTablePartyForeginKeyColumn")){
															relationTableInfo.setInMyTablePartyForeginKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JTextField) && cp.getName().equals("partyInMyClassFieldName")){
															relationTableInfo.setPartyInMyClassFieldName(((JTextField) cp).getText().trim());
														}else if((cp instanceof JTextField)&& cp.getName().equals("inPartyClassMyFieldName")){
															relationTableInfo.setInPartyClassMyFieldName(((JTextField) cp).getText().trim());
														}else if((cp instanceof JComboBox) && cp.getName().equals("myPrimaryKeyColumn")){
															relationTableInfo.setMyPrimaryKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JTextField)&& cp.getName().equals("myPrimaryKeyFieldName")){
															relationTableInfo.setMyPrimaryKeyFieldName(((JTextField) cp).getText().trim());
														}else if((cp instanceof JComboBox) && cp.getName().equals("inMiddleTable")){
															relationTableInfo.setMiddleTable(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JComboBox) && cp.getName().equals("inMiddleTableMyForeginKeyColumn")){
															relationTableInfo.setInMiddleTableMyForeginKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}else if((cp instanceof JComboBox) && cp.getName().equals("inMiddleTablePartyForeginKeyColumn")){
															relationTableInfo.setInMiddleTablePartyForeginKeyColumn(((JComboBox) cp).getSelectedItem()+"");
														}
													}
												}
											}
											tableInfo.put("relationTableInfos", relationTableInfos);
											List<Map<String, String>> allFields = new ArrayList<>();
											tableInfo.put("allFields", allFields);
											data_new.put(tableName, tableInfo);
											for (Component component : components) {
												if(component instanceof JCheckBox){
													if(((JCheckBox)component).isSelected()){
														Map<String, String> item = new HashMap<>();
														item.put("columnName", ((JCheckBox) component).getText());
														//再去获取对应的属性名
														for (Component component2 : components) {
															if(component2 instanceof JTextField){
																if(((JTextField)component2).getName().equals(item.get("columnName"))){
																	String text = ((JTextField) component2).getText();
																	if(null==text||"".equals(text.trim())){
																		text = item.get("columnName");
																	}
																	item.put("fieldName", text);
																}
															}
														}
														allFields.add(item);
													}
												}
											}
											super.windowClosing(e);
										}
									});
									
									//添加关联关系
									internal_panel_1.setLayout(gl_panel);
									internal.getContentPane().setLayout(groupLayout);
//									internal.add(panel7);
									internal.setVisible(true);
//									JOptionPane.showMessageDialog(null, actionCommand);
								}
							});
							tableShowPanel.add(jButton);
						}
						tableShowPanel.updateUI();//更新界面
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(url, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(10)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(username, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addComponent(lblJdbc)
									.addGap(469))))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(connectedInfo)
							.addGap(37)
							.addComponent(button)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblJdbc)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(dbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(url, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(connectedInfo))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		this.setLayout(gl_panel);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//获取数据库配置信息----
					String driverStr = null;
					if(connection!=null && !connection.isClosed()){
						if(dbType.getSelectedItem().equals("Mysql")){
							driverStr = com.mysql.jdbc.Driver.class.getName();
						}else{
							//oracle.jdbc.driver.OracleDriver
							driverStr = oracle.jdbc.driver.OracleDriver.class.getName();
						}
					}else{
						JOptionPane.showMessageDialog(null, "先连接数据库，然后选择数据表配置！");
						return;
					}
					String urlStr = url.getText().trim();
					String userNameStr = username.getText().trim();
					String passwordStr = password.getText().trim();
					//获取路径配置信息---
					String domainPackageStr = txtComnetdomain.getText().trim();
					String mapperPathStr = txtComnetmapper.getText().trim();
					String daoPackageStr = txtComnetdao.getText().trim();
					String servicePackageStr = txtComnetservice.getText().trim();
					String controllerPackageStr = txtComnetwebcontroller.getText().trim();
					String htmlPathStr = txtWebapppages.getText().trim();
					if("".equals(domainPackageStr)){
						JOptionPane.showMessageDialog(null, "domain路径不能为空!");
						return;
					}
					if("".equals(mapperPathStr)){
						JOptionPane.showMessageDialog(null, "mapper路径不能为空!");
						return;
					}
					if("".equals(daoPackageStr)){
						JOptionPane.showMessageDialog(null, "dao路径不能为空!");
						return;
					}
					if("".equals(servicePackageStr)){
						JOptionPane.showMessageDialog(null, "service路径不能为空!");
						return;
					}
					if("".equals(controllerPackageStr)){
						JOptionPane.showMessageDialog(null, "controller路径不能为空!");
						return;
					}
					if("".equals(htmlPathStr)){
						JOptionPane.showMessageDialog(null, "html路径不能为空!");
						return;
					}
					//获取生成配置信息---
					boolean iscover = checkcover.isSelected();
					boolean isexample = chckbxexample.isSelected();
					boolean generateDomain = chckbxmodel.isSelected();
					boolean generateMapper = chckbxmapper.isSelected();
					boolean generateService = chckbxservice.isSelected();
					boolean generateController = chckbxcontroller.isSelected();
					boolean generateHtml = chckbxhtml.isSelected();
					//获取已选择的表
					Component[] components = tableShowPanel.getComponents();
					List<String> selectedTableNames = new ArrayList<>();
					for (Component component : components) {
						if(component instanceof JCheckBox){
							if(((JCheckBox) component).isSelected()){
								selectedTableNames.add(((JCheckBox) component).getText());
							}else{
								data_new.remove(((JCheckBox) component).getText());
							}
						}
					}
					for (String tableName : selectedTableNames) {
						//tableInfo {generateClassName、allFields{columnName、fieldName}、relationTableInfo}
						Map<String, Object> tableInfo = data_new.get(tableName);
						if(null==tableInfo){
							tableInfo = new HashMap<>();
							//tableInfo.put("generateClassName", StringUtil.changeFirstCharToUpper(tableName));//不设置，按照mybatis generator的 默认驼峰命名来设置pojo的名称  ef:user_role  编程UserRole
							data_new.put(tableName, tableInfo);
						}
						/*
						 *采用mybatis generator的表列名驼峰命名    eg：user_id   会变成userId 作为pojo的属性字段 
						List<Map<String, String>> allField = (List<Map<String, String>>) tableInfo.get("allFields");
						if(null==allField){
							//勾选了，没有配置字段信息
							//读取表的字段
							ArrayList<List> ddlInfo = JdbcUtil.readConst("desc "+tableName, connection);
							List<String> fileds = JdbcUtil.readFileds(ddlInfo);
							allField = new ArrayList<>();
							tableInfo.put("allFields", allField);
							for (String field : fileds) {
								Map<String, String> item = new HashMap<>();
								item.put("columnName", field);
								item.put("fieldName", field);
								allField.add(item);
							}
						}*/
					}
					GenerateInfo generateInfo = new GenerateInfo(iscover, isexample, generateDomain, generateMapper, generateService, generateController, generateHtml, domainPackageStr, mapperPathStr, daoPackageStr, servicePackageStr, controllerPackageStr, htmlPathStr, driverStr, urlStr, userNameStr, passwordStr);
					MybatisGenerate.generateInfo = generateInfo;
					//对ThreadLocalAllDomainJavaProperties清空
					ThreadLocalAllDomainJavaProperties.removeAllDomainJavaProperties();
					//把相关信息传给mybatis generator进行生成
					MybatisGenerate.generate(data_new, iscover, isexample, generateDomain, generateMapper, generateService, generateController, generateHtml, domainPackageStr, mapperPathStr, daoPackageStr, servicePackageStr, controllerPackageStr, htmlPathStr, driverStr, urlStr, userNameStr, passwordStr);
					//生成代码
					if(generateController){
						generateAction(iscover,generateInfo,data_new,selectedTableNames);
					}
					if(generateService){
						generateService(iscover,generateInfo,data_new,selectedTableNames);
					}
					if(generateHtml){
						generateHtml(iscover,generateInfo,data_new,selectedTableNames);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}finally{
					JOptionPane.showMessageDialog(null, "生成完毕,请刷新项目!");
				}
			}
			
			private void generateHtml(boolean iscover, GenerateInfo generateInfo,
					Map<String, Map<String, Object>> data_new, List<String> selectedTableNames) throws ClassNotFoundException, TemplateException, IOException {
				String projectPath = System.getProperty("user.dir");
				//复制资源com/caitaojun/js到webapp目录下
//				String webappPath = projectPath+"\\src\\main"+"\\webapp\\js";
				String webappPath = null;
				if(generateInfo.getHtmlPathStr().startsWith("src/main/webapp")){
					//sts(eclipse)
					webappPath = projectPath+"\\src\\main\\webapp\\js";
				}else if(generateInfo.getHtmlPathStr().startsWith("web")){
					//ideal
					webappPath = projectPath+"\\web\\js";
				}
				JarFileResUtil.copyJarFileResToDirectory(webappPath);
				//生成html代码
				Configuration config = new Configuration(Configuration.VERSION_2_3_23);
//				String path = Thread.currentThread().getContextClassLoader().getResource("com/net023/template/no3").getPath();
//				File dir = new File(path);
//				config.setDirectoryForTemplateLoading(dir);
				config.setClassForTemplateLoading(SpringmvcSpringMybatisEasyuiJpanel.class, "/com/caitaojun/template/no3");
				Template template = config.getTemplate("html.ftl");
				Map<String, Object> dataModel = new HashMap<>();
				//controllerPackage  servicePackage htmlPath domainName
				dataModel.put("controllerPackage", generateInfo.getControllerPackageStr());
				dataModel.put("domainPackage", generateInfo.getDomainPackageStr());
				dataModel.put("servicePackage", generateInfo.getServicePackageStr());
				dataModel.put("daoPackage", generateInfo.getDaoPackageStr());
				String[] htmlPathSeparator = generateInfo.getHtmlPathStr().split("/");
				String resPathPrefix = "";
				if(generateInfo.getHtmlPathStr().startsWith("src/main/webapp")){
					//sts(eclipse)
					for (int i = 0; i < htmlPathSeparator.length-3; i++) {
						resPathPrefix = resPathPrefix+"../";
					}
				}else if(generateInfo.getHtmlPathStr().startsWith("web")){
					//idealj
					for (int i = 0; i < htmlPathSeparator.length-1; i++) {
						resPathPrefix = resPathPrefix+"../";
					}
				}
				dataModel.put("resPathPrefix", resPathPrefix);
				for (String tableName : selectedTableNames) {
					Map<String, Object> tableInfo = data_new.get(tableName);
					Object generateClassName = tableInfo.get("generateClassName");
					if(generateClassName==null){
						generateClassName = StringUtil.changeFirstCharToUpper(tableName);
					}
					dataModel.put("domainClassName", generateClassName);
//					String domainClassStr = generateInfo.getDomainPackageStr()+"."+generateClassName;
//					Class<?> clazz = Class.forName(domainClassStr);
//					List<String>  allFieldNames = getClassAllFieldNames(clazz);
					
					Map<String, List<String>> currentIntrospectedTable = ThreadLocalAllDomainJavaProperties.getCurrentIntrospectedTable();
//					System.out.println("currentIntro:"+currentIntrospectedTable);
					List<String> allFieldNames = currentIntrospectedTable.get(generateClassName);
					
					dataModel.put("fieldNames", allFieldNames);
					String htmlPath = generateInfo.getHtmlPathStr().replace("/", "\\");
//					String htmlFilePath = projectPath+"\\src\\main"+"\\"+htmlPath;
					String htmlFilePath = projectPath+"\\"+htmlPath;
					File file = new File(htmlFilePath);
					if(!file.exists()){
						file.mkdirs();
					}
					File htmlFile = new File(file, generateClassName+".html");
					if(iscover){//如果存在和要覆盖
						Writer out = new FileWriter(htmlFile);
						template.process(dataModel, out);
						out.close();
					}else{
						if(!htmlFile.exists()){
							//如果不存在就创建 ，存在就跳过
							Writer out = new FileWriter(htmlFile);
							template.process(dataModel, out);
							out.close();
						}
					}
				}
			}
			
			private List<String> types = Arrays.asList(
					"int","byte","short","long","float","double","boolean","char",
					"java.lang.Integer","java.lang.Byte","java.lang.Short","java.lang.Long","java.lang.Float","java.lang.Double","java.lang.Boolean","java.lang.Character",
					"java.lang.String"
					);
			
			private List<String> getClassAllFieldNames(Class clazz) {
				Field[] declaredFields = clazz.getDeclaredFields();
				List<String> fieldNames = new ArrayList<>();
				for (Field field : declaredFields) {
					//判断属性字段不是集合类型  不是自定义引用类型
					if(types.contains(field.getType().getCanonicalName())){
						fieldNames.add(field.getName());
					}
				}
				return fieldNames;
			}

			private void generateService(boolean iscover, GenerateInfo generateInfo,
					Map<String, Map<String, Object>> data_new, List<String> selectedTableNames) throws IOException, TemplateException {
				//生成service代码
				Configuration config = new Configuration(Configuration.VERSION_2_3_23);
//				String path = Thread.currentThread().getContextClassLoader().getResource("com/net023/template/no3").getPath();
//				File dir = new File(path);
//				config.setDirectoryForTemplateLoading(dir);
				config.setClassForTemplateLoading(SpringmvcSpringMybatisEasyuiJpanel.class, "/com/caitaojun/template/no3");
				Template template = config.getTemplate("service.ftl");
				Template template2 = config.getTemplate("serviceimpl.ftl");
				Map<String, Object> dataModel = new HashMap<>();
				//controllerPackage  servicePackage htmlPath domainName
				dataModel.put("controllerPackage", generateInfo.getControllerPackageStr());
				dataModel.put("domainPackage", generateInfo.getDomainPackageStr());
				dataModel.put("servicePackage", generateInfo.getServicePackageStr());
				dataModel.put("daoPackage", generateInfo.getDaoPackageStr());
				for (String tableName : selectedTableNames) {
					Map<String, Object> tableInfo = data_new.get(tableName);
					Object generateClassName = tableInfo.get("generateClassName");
					if(generateClassName==null){
						generateClassName = StringUtil.changeFirstCharToUpper(tableName);
					}
					dataModel.put("domainClassName", generateClassName);
					IntrospectedTable currentIntrospectedTable = ThreadLocalCurrentIntrospectedTable.getCurrentIntrospectedTable();
					String primaryKeyType = currentIntrospectedTable.getPrimaryKeyType();
					String javaProperty = currentIntrospectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
					String shortName = currentIntrospectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getShortName();
					dataModel.put("primaryKeyType", shortName);
					dataModel.put("primaryKeyName", StringUtil.changeFirstCharToUpper(javaProperty));
					
					String projectPath = System.getProperty("user.dir");
					String servicePath = generateInfo.getServicePackageStr().replace(".", "\\");
					String serviceFilePath = projectPath+"\\src\\main\\java"+"\\"+servicePath;
					File file = new File(serviceFilePath);
					if(!file.exists()){
						file.mkdirs();
					}
					//生成接口
					File serviceFile = new File(file, generateClassName+"Service.java");
					if(iscover){//如果存在和要覆盖
						Writer out = new FileWriter(serviceFile);
						template.process(dataModel, out);
						out.close();
					}else{
						if(!serviceFile.exists()){
							//如果不存在就创建 ，存在就跳过
							Writer out = new FileWriter(serviceFile);
							template.process(dataModel, out);
							out.close();
						}
					}
					
					//生成实现类
					String serviceImplFilePath = projectPath+"\\src\\main\\java"+"\\"+servicePath+"\\impl";
					File serviceImplPathFile = new File(serviceImplFilePath);
					if(!serviceImplPathFile.exists()){
						serviceImplPathFile.mkdirs();
					}
					File serviceImplFile = new File(serviceImplPathFile, generateClassName+"ServiceImpl.java");
					if(iscover){//如果存在和要覆盖
						Writer out = new FileWriter(serviceImplFile);
						template2.process(dataModel, out);
						out.close();
					}else{
						if(!serviceImplFile.exists()){
							//如果不存在就创建 ，存在就跳过
							Writer out = new FileWriter(serviceImplFile);
							template2.process(dataModel, out);
							out.close();
						}
					}
				}
				
			}

			private void generateAction(boolean iscover, GenerateInfo generateInfo,
					Map<String, Map<String, Object>> data_new, List<String> selectedTableNames) throws TemplateException, IOException {
				//生成controller代码
				Configuration config = new Configuration(Configuration.VERSION_2_3_23);
//				String path = Thread.currentThread().getContextClassLoader().getResource("com/net023/template/no3").getPath();
//				File dir = new File(path);
//				config.setDirectoryForTemplateLoading(dir);
				config.setClassForTemplateLoading(SpringmvcSpringMybatisEasyuiJpanel.class, "/com/caitaojun/template/no3");
				Template template = config.getTemplate("controller.ftl");
				Map<String, Object> dataModel = new HashMap<>();
				//controllerPackage  servicePackage htmlPath domainName
				dataModel.put("controllerPackage", generateInfo.getControllerPackageStr());
				dataModel.put("domainPackage", generateInfo.getDomainPackageStr());
				dataModel.put("servicePackage", generateInfo.getServicePackageStr());
				dataModel.put("daoPackage", generateInfo.getDaoPackageStr());
				
				for (String tableName : selectedTableNames) {
					Map<String, Object> tableInfo = data_new.get(tableName);
					Object generateClassName = tableInfo.get("generateClassName");
					if(generateClassName==null){
						generateClassName = StringUtil.changeFirstCharToUpper(tableName);
					}
					dataModel.put("domainClassName", generateClassName);
					String projectPath = System.getProperty("user.dir");
					String actionPath = generateInfo.getControllerPackageStr().replace(".", "\\");
					String actionFilePath = projectPath+"\\src\\main\\java"+"\\"+actionPath;
					File file = new File(actionFilePath);
					if(!file.exists()){
						file.mkdirs();
					}
					File actionFile = new File(file, generateClassName+"Controller.java");
					if(iscover){//如果存在和要覆盖
						Writer out = new FileWriter(actionFile);
						template.process(dataModel, out);
						out.close();
					}else{
						if(!actionFile.exists()){
							//如果不存在就创建 ，存在就跳过
							Writer out = new FileWriter(actionFile);
							template.process(dataModel, out);
							out.close();
						}
					}
				}
			}
		});
	}

}
