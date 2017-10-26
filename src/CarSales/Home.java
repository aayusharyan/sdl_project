/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSales;

import com.google.gson.Gson;
import java.awt.Color;

/**
 *
 * @author aayush
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setResizable(false);
        loaderpanel.setVisible(false);
        invalid_credentials_err_msg.setVisible(false);
        invalid_register_err_msg.setVisible(false);
    }
    public void login(){
        loaderpanel.setVisible(true);
        invalid_credentials_err_msg.setVisible(false);
        String email = login_email.getText();
        String password = String.valueOf(login_password.getPassword());
        User user_obj = new User();
        user_obj.setLogin(email, password);
        Gson gson = new Gson();
        String json_user_data = gson.toJson(user_obj);
        new Thread(() -> {
            SQLdb connection = new SQLdb();
            String[] login_status = connection.login(json_user_data);
            if(login_status[0].equals("true")) {
                if(login_status[2].equals("admin")) {
                    Admin admin = new Admin(Integer.parseInt(login_status[1]), 1);
                    admin.setVisible(true);
                    this.dispose();
                } else {
                    CompanyList comp = new CompanyList(Integer.parseInt(login_status[1]));
                    comp.setVisible(true);
                    this.dispose();
                }
            } else {
                invalid_credentials_err_msg.setVisible(true);
            }
            System.out.println(String.valueOf(login_status));
            loaderpanel.setVisible(false);
        }).start();
    }
    public void register(){
     loaderpanel.setVisible(true);
        invalid_register_err_msg.setVisible(false);
        
        String name = register_name.getText();
        String email = register_email.getText();
        String password = String.valueOf(register_password.getPassword());
        String phone = register_phone.getText();
        User user_obj = new User();
        user_obj.setRegister(name, email, password, phone);
        Gson gson = new Gson();
        String json_user_data = gson.toJson(user_obj);
        new Thread(() -> {
            SQLdb connection = new SQLdb();
            int register_status = connection.register(json_user_data);
            if(register_status > 0) {
                CompanyList comp=new CompanyList(register_status);
                comp.setVisible(true);
                this.dispose();
            } else {
                invalid_register_err_msg.setVisible(true);
            }
            loaderpanel.setVisible(false);
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingframe = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        register_name = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        register_email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        register_password = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        register_phone = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        register = new javax.swing.JPanel();
        register_label = new javax.swing.JLabel();
        invalid_register_err_msg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_email = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        login_password = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        login = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loaderpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        invalid_credentials_err_msg = new javax.swing.JLabel();

        javax.swing.GroupLayout loadingframeLayout = new javax.swing.GroupLayout(loadingframe.getContentPane());
        loadingframe.getContentPane().setLayout(loadingframeLayout);
        loadingframeLayout.setHorizontalGroup(
            loadingframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loadingframeLayout.setVerticalGroup(
            loadingframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 248, 248));

        jPanel1.setBackground(new java.awt.Color(58, 56, 77));

        jPanel2.setBackground(new java.awt.Color(38, 40, 55));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Register");

        register_name.setBackground(new java.awt.Color(38, 40, 55));
        register_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        register_name.setForeground(new java.awt.Color(153, 153, 153));
        register_name.setText("Name");
        register_name.setToolTipText("");
        register_name.setBorder(null);
        register_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                register_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                register_nameFocusLost(evt);
            }
        });
        register_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_nameMouseClicked(evt);
            }
        });
        register_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_nameActionPerformed(evt);
            }
        });

        register_email.setBackground(new java.awt.Color(38, 40, 55));
        register_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        register_email.setForeground(new java.awt.Color(153, 153, 153));
        register_email.setText("Email");
        register_email.setToolTipText("");
        register_email.setBorder(null);
        register_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                register_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                register_emailFocusLost(evt);
            }
        });
        register_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_emailMouseClicked(evt);
            }
        });
        register_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_emailActionPerformed(evt);
            }
        });

        register_password.setBackground(new java.awt.Color(38, 40, 55));
        register_password.setForeground(new java.awt.Color(153, 153, 153));
        register_password.setText("Password");
        register_password.setBorder(null);
        register_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                register_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                register_passwordFocusLost(evt);
            }
        });
        register_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_passwordMouseClicked(evt);
            }
        });

        register_phone.setBackground(new java.awt.Color(38, 40, 55));
        register_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        register_phone.setForeground(new java.awt.Color(153, 153, 153));
        register_phone.setText("Phone");
        register_phone.setToolTipText("");
        register_phone.setBorder(null);
        register_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                register_phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                register_phoneFocusLost(evt);
            }
        });
        register_phone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_phoneMouseClicked(evt);
            }
        });
        register_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_phoneActionPerformed(evt);
            }
        });

        register.setBackground(new java.awt.Color(38, 40, 55));
        register.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 109, 125), 1, true));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });

        register_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        register_label.setForeground(new java.awt.Color(255, 255, 255));
        register_label.setText("Register");
        register_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(register_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(register_label, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        invalid_register_err_msg.setBackground(new java.awt.Color(58, 56, 77));
        invalid_register_err_msg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invalid_register_err_msg.setForeground(new java.awt.Color(242, 109, 125));
        invalid_register_err_msg.setText("Error Validating Form, Please try again.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(register_phone)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(register_email)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(register_name)
                            .addComponent(jSeparator1)
                            .addComponent(register_password)
                            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid_register_err_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(register_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(register_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(register_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(register_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invalid_register_err_msg)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");

        login_email.setBackground(new java.awt.Color(58, 56, 77));
        login_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login_email.setForeground(new java.awt.Color(153, 153, 153));
        login_email.setText("Email");
        login_email.setToolTipText("");
        login_email.setBorder(null);
        login_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                login_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                login_emailFocusLost(evt);
            }
        });
        login_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_emailMouseClicked(evt);
            }
        });
        login_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_emailActionPerformed(evt);
            }
        });

        login_password.setBackground(new java.awt.Color(58, 56, 77));
        login_password.setForeground(new java.awt.Color(153, 153, 153));
        login_password.setText("Password");
        login_password.setBorder(null);
        login_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                login_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                login_passwordFocusLost(evt);
            }
        });
        login_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_passwordMouseClicked(evt);
            }
        });

        login.setBackground(new java.awt.Color(58, 56, 77));
        login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        loaderpanel.setBackground(new java.awt.Color(58, 56, 77));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/animations/91.gif"))); // NOI18N

        javax.swing.GroupLayout loaderpanelLayout = new javax.swing.GroupLayout(loaderpanel);
        loaderpanel.setLayout(loaderpanelLayout);
        loaderpanelLayout.setHorizontalGroup(
            loaderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        loaderpanelLayout.setVerticalGroup(
            loaderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        invalid_credentials_err_msg.setBackground(new java.awt.Color(58, 56, 77));
        invalid_credentials_err_msg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invalid_credentials_err_msg.setForeground(new java.awt.Color(242, 109, 125));
        invalid_credentials_err_msg.setText("Invalid Credentials, Please try again.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(login_email, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(login_password, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(invalid_credentials_err_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(login_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(invalid_credentials_err_msg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void register_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_nameActionPerformed

    private void register_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_nameMouseClicked

    }//GEN-LAST:event_register_nameMouseClicked

    private void register_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_emailMouseClicked
  
    }//GEN-LAST:event_register_emailMouseClicked

    private void register_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_emailActionPerformed

    private void register_phoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_phoneMouseClicked

    }//GEN-LAST:event_register_phoneMouseClicked

    private void register_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_phoneActionPerformed

    private void login_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_emailMouseClicked

    }//GEN-LAST:event_login_emailMouseClicked

    private void login_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_emailActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
       this.register();
    }//GEN-LAST:event_registerMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
       this.login();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        this.login();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseClicked

    private void login_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_passwordMouseClicked

    }//GEN-LAST:event_login_passwordMouseClicked

    private void register_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_passwordMouseClicked

    }//GEN-LAST:event_register_passwordMouseClicked

    private void register_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_nameFocusGained
        if(register_name.getText().equals("Name")){
        register_name.setText("");
        register_name.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_register_nameFocusGained

    private void register_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_nameFocusLost
        if(register_name.getText().equals("")) {
            register_name.setText("Name");
            register_name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_register_nameFocusLost

    private void register_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_emailFocusGained
        // TODO add your handling code here:
        if(register_email.getText().equals("Email")) {
            register_email.setText("");
            register_email.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_register_emailFocusGained

    private void register_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_emailFocusLost
        // TODO add your handling code here:
        if(register_email.getText().equals("")) {
            register_email.setText("Email");
            register_email.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_register_emailFocusLost

    private void register_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_passwordFocusGained
        // TODO add your handling code here:
        if(register_password.getText().equals("Password")) {
        register_password.setText("");
        register_password.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_register_passwordFocusGained

    private void register_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_passwordFocusLost
        // TODO add your handling code here:
        if(register_password.getText().equals("")) {
            register_password.setText("Password");
            register_password.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_register_passwordFocusLost

    private void register_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_phoneFocusGained
    // TODO add your handling code here:
    if(register_phone.getText().equals("Phone")) {
    register_phone.setText("");
    register_phone.setForeground(Color.WHITE);
    }
    }//GEN-LAST:event_register_phoneFocusGained

    private void register_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_register_phoneFocusLost
        // TODO add your handling code here:
        if(register_phone.getText().equals("")) {
            register_phone.setText("Phone");
            register_phone.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_register_phoneFocusLost

    private void login_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_emailFocusGained
        // TODO add your handling code here:
         if(login_email.getText().equals("Email")) {
        login_email.setText("");
        login_email.setForeground(Color.WHITE);
         }
    }//GEN-LAST:event_login_emailFocusGained

    private void login_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_emailFocusLost
        // TODO add your handling code here:
        if(login_email.getText().equals("")) {
            login_email.setText("Email");
            login_email.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_login_emailFocusLost

    private void login_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_passwordFocusGained
        if(login_password.getText().equals("Password")) {
        login_password.setText("");
        login_password.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_login_passwordFocusGained

    private void login_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_passwordFocusLost
        // TODO add your handling code here:
        if(login_password.getText().equals("")) {
            login_password.setText("Password");
            login_password.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_login_passwordFocusLost

    private void register_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_labelMouseClicked
        // TODO add your handling code here:
        this.register();
    }//GEN-LAST:event_register_labelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel invalid_credentials_err_msg;
    private javax.swing.JLabel invalid_register_err_msg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel loaderpanel;
    private javax.swing.JFrame loadingframe;
    private javax.swing.JPanel login;
    private javax.swing.JTextField login_email;
    private javax.swing.JPasswordField login_password;
    private javax.swing.JPanel register;
    private javax.swing.JTextField register_email;
    private javax.swing.JLabel register_label;
    private javax.swing.JTextField register_name;
    private javax.swing.JPasswordField register_password;
    private javax.swing.JTextField register_phone;
    // End of variables declaration//GEN-END:variables

    private Color Color(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
