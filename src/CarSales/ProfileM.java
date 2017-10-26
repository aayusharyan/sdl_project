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
 * @author abhi
 */
public class ProfileM extends javax.swing.JFrame {
    
    private void updateDetails() {
        String new_name = update_name.getText();
        String new_password = String.valueOf(update_password.getPassword());
        String new_phone = update_phone.getText();
        
        SQLdb connection = new SQLdb();
        boolean result = connection.updateUser(this.user_id, new_name, new_password, new_phone);
        if(result) {
            update_error.setVisible(false);
            update_success.setVisible(true);
        }
        else {
            update_success.setVisible(false);
            update_error.setVisible(true);
        }
    }
    
    private int user_id;
    /**
     * Creates new form ProfileM
     */
    public ProfileM(int user_id) {
        this.user_id = user_id;
        initComponents();
        this.setResizable(false);
        update_success.setVisible(false);
        update_error.setVisible(false);
        new Thread(() -> {
            SQLdb connection = new SQLdb();
            String user_obj_json = connection.getUserDetails(this.user_id);
            Gson gson = new Gson();
            String[] user_details = gson.fromJson(user_obj_json, String[].class);
            user_name.setText(user_details[1]);
            
            update_name.setText(user_details[1]);
            update_name.setForeground(Color.WHITE);
            update_password.setText(user_details[4]);
            update_password.setForeground(Color.WHITE);
            update_phone.setText(user_details[3]);
            update_phone.setForeground(Color.WHITE);
            
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        logout_label = new javax.swing.JPanel();
        logout_textfield = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        back_btn = new javax.swing.JLabel();
        loaderpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        update_name = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        update_password = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        update_phone = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        submit = new javax.swing.JLabel();
        update_success = new javax.swing.JLabel();
        update_error = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(58, 56, 77));

        jPanel1.setBackground(new java.awt.Color(38, 40, 55));
        jPanel1.setPreferredSize(new java.awt.Dimension(248, 450));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hi,");

        user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));

        logout_label.setBackground(new java.awt.Color(38, 40, 55));
        logout_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 109, 125), 1, true));
        logout_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_labelMouseClicked(evt);
            }
        });

        logout_textfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logout_textfield.setForeground(new java.awt.Color(255, 255, 255));
        logout_textfield.setText("Logout");
        logout_textfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_textfieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logout_labelLayout = new javax.swing.GroupLayout(logout_label);
        logout_label.setLayout(logout_labelLayout);
        logout_labelLayout.setHorizontalGroup(
            logout_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_labelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(logout_textfield)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logout_labelLayout.setVerticalGroup(
            logout_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_labelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(38, 40, 55));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/account.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        back_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setText("⬅ Back");
        back_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_btnMouseClicked(evt);
            }
        });

        loaderpanel.setBackground(new java.awt.Color(38, 40, 55));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/animations/91.gif"))); // NOI18N

        javax.swing.GroupLayout loaderpanelLayout = new javax.swing.GroupLayout(loaderpanel);
        loaderpanel.setLayout(loaderpanelLayout);
        loaderpanelLayout.setHorizontalGroup(
            loaderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );
        loaderpanelLayout.setVerticalGroup(
            loaderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_btn)
                .addGap(1, 1, 1)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE)))
        );

        update_name.setBackground(new java.awt.Color(58, 56, 77));
        update_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update_name.setForeground(new java.awt.Color(255, 255, 255));
        update_name.setText("Name");
        update_name.setBorder(null);
        update_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                update_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                update_nameFocusLost(evt);
            }
        });

        update_password.setBackground(new java.awt.Color(58, 56, 77));
        update_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update_password.setForeground(new java.awt.Color(255, 255, 255));
        update_password.setText("***********");
        update_password.setBorder(null);
        update_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                update_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                update_passwordFocusLost(evt);
            }
        });

        update_phone.setBackground(new java.awt.Color(58, 56, 77));
        update_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update_phone.setForeground(new java.awt.Color(255, 255, 255));
        update_phone.setText("Phone");
        update_phone.setBorder(null);
        update_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                update_phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                update_phoneFocusLost(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(58, 56, 77));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 237, 181)));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Update");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        update_success.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update_success.setForeground(new java.awt.Color(94, 237, 181));
        update_success.setText("Profile Updated Sucessfully.");

        update_error.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update_error.setForeground(new java.awt.Color(242, 109, 125));
        update_error.setText("Error Occured.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Profile");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(update_success, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update_error, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(update_phone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(update_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(update_name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(update_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(update_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(update_success)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_error)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_textfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_textfieldMouseClicked
        Home h = new Home();
        this.getContentPane().removeAll();
        this.getContentPane().add(h.getContentPane());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_logout_textfieldMouseClicked

    private void logout_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_labelMouseClicked
        // TODO add your handling code here:
        Home h = new Home();
        this.getContentPane().removeAll();
        this.getContentPane().add(h.getContentPane());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_logout_labelMouseClicked

    private void update_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_nameFocusGained
        // TODO add your handling code here:
        if(update_name.getText().equals("Name")){
            update_name.setText("");
            update_name.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_update_nameFocusGained

    private void update_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_nameFocusLost
       if(update_name.getText().equals("")){
            update_name.setText("Name");
            update_name.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_update_nameFocusLost

    private void update_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_passwordFocusGained
        // TODO add your handling code here:
        if(update_password.getText().equals("Password")){
            update_password.setText("");
            update_password.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_update_passwordFocusGained

    private void update_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_passwordFocusLost
        // TODO add your handling code here:
         if(update_password.getText().equals("")){
            update_password.setText("Password");
            update_password.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_update_passwordFocusLost

    private void update_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_phoneFocusGained
        // TODO add your handling code here:
        if(update_phone.getText().equals("Phone")){
            update_phone.setText("");
            update_phone.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_update_phoneFocusGained

    private void update_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_update_phoneFocusLost
        // TODO add your handling code here:
         if(update_phone.getText().equals("")){
            update_phone.setText("Phone");
            update_phone.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_update_phoneFocusLost

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        CompanyList cl = new CompanyList(this.user_id);
        this.getContentPane().removeAll();
        this.getContentPane().add(cl.getContentPane());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_back_btnMouseClicked

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        updateDetails();
    }//GEN-LAST:event_submitMouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        updateDetails();
    }//GEN-LAST:event_jPanel5MouseClicked

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
            java.util.logging.Logger.getLogger(ProfileM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileM(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel loaderpanel;
    private javax.swing.JPanel logout_label;
    private javax.swing.JLabel logout_textfield;
    private javax.swing.JLabel submit;
    private javax.swing.JLabel update_error;
    private javax.swing.JTextField update_name;
    private javax.swing.JPasswordField update_password;
    private javax.swing.JTextField update_phone;
    private javax.swing.JLabel update_success;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
