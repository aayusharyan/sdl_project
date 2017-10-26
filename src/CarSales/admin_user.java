/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSales;

import com.google.gson.Gson;

/**
 *
 * @author aksha
 */
public class admin_user extends javax.swing.JFrame {
    private int page_id;
    private int user_id;
    
    public void changePage(int new_page_id) {
        admin_user admin_user = new admin_user(this.user_id, new_page_id);
        admin_user.setVisible(true);
        this.dispose();
    }
    /**
     * Creates new form admin_user
     * @param user_id
     * @param page_id
     */
    public admin_user(int user_id, int page_id) {
        this.user_id = user_id;
        this.page_id = page_id;
        initComponents();
        this.setResizable(false);
        user_1_panel.setVisible(false);
        user_2_panel.setVisible(false);
        user_3_panel.setVisible(false);
        user_4_panel.setVisible(false);
        user_5_panel.setVisible(false);
        user_6_panel.setVisible(false);
        prev_page_panel.setVisible(false);
        next_page_panel.setVisible(false);
        
        new Thread(() -> {    
            int limit = 6;
            int offset = 0;
            if(page_id > 1) {
                offset = ((page_id-1)*limit);
            }
            SQLdb connection = new SQLdb();
            String users_data_json = connection.getUsers(offset, limit);
            Gson gson = new Gson();
            String[][] users_data = gson.fromJson(users_data_json, String[][].class);
            int count = 0;
            for(String[] single_user : users_data) {
                if(single_user[0] != null) {
                    int single_user_id = Integer.parseInt(single_user[0]);
                    int user_location = (single_user_id-1)%6;
                    
                    String single_user_name = single_user[1];
                    String single_user_email = single_user[2];
                    String single_user_phone = single_user[3];
                    
                    switch (count) {
                        case 0:
                            user_1_panel.setVisible(true);
                            user_1_id.setText(String.valueOf(single_user_id));
                            user_1_name.setText(single_user_name);
                            user_1_email.setText(single_user_email);
                            user_1_phone.setText(single_user_phone);
                        break;
                        case 1:
                            user_2_panel.setVisible(true);
                            user_2_id.setText(String.valueOf(single_user_id));
                            user_2_name.setText(single_user_name);
                            user_2_email.setText(single_user_email);
                            user_2_phone.setText(single_user_phone);
                        break;
                        case 2:
                            user_3_panel.setVisible(true);
                            user_3_id.setText(String.valueOf(single_user_id));
                            user_3_name.setText(single_user_name);
                            user_3_email.setText(single_user_email);
                            user_3_phone.setText(single_user_phone);
                        break;
                        case 3:
                            user_4_panel.setVisible(true);
                            user_4_id.setText(String.valueOf(single_user_id));
                            user_4_name.setText(single_user_name);
                            user_4_email.setText(single_user_email);
                            user_4_phone.setText(single_user_phone);
                        break;
                        case 4:
                            user_5_panel.setVisible(true);
                            user_5_id.setText(String.valueOf(single_user_id));
                            user_5_name.setText(single_user_name);
                            user_5_email.setText(single_user_email);
                            user_5_phone.setText(single_user_phone);
                        break;
                        case 5:
                            user_6_panel.setVisible(true);
                            user_6_id.setText(String.valueOf(single_user_id));
                            user_6_name.setText(single_user_name);
                            user_6_email.setText(single_user_email);
                            user_6_phone.setText(single_user_phone);
                        break;
                        
                    }
                    count++;
                }
            }
            
            
            if(offset > 0) {
                prev_page_panel.setVisible(true);
            }
            
            connection = new SQLdb();
            int remaining_items = connection.remainingUsers(offset, limit);
            if(remaining_items > 0) {
                next_page_panel.setVisible(true);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logout_label = new javax.swing.JPanel();
        logout_textfield = new javax.swing.JLabel();
        loaderpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        user_1_panel = new javax.swing.JPanel();
        user_1_id = new javax.swing.JLabel();
        user_1_name = new javax.swing.JLabel();
        user_1_email = new javax.swing.JLabel();
        user_1_phone = new javax.swing.JLabel();
        user_2_panel = new javax.swing.JPanel();
        user_2_id = new javax.swing.JLabel();
        user_2_name = new javax.swing.JLabel();
        user_2_email = new javax.swing.JLabel();
        user_2_phone = new javax.swing.JLabel();
        user_3_panel = new javax.swing.JPanel();
        user_3_id = new javax.swing.JLabel();
        user_3_name = new javax.swing.JLabel();
        user_3_email = new javax.swing.JLabel();
        user_3_phone = new javax.swing.JLabel();
        user_4_panel = new javax.swing.JPanel();
        user_4_id = new javax.swing.JLabel();
        user_4_name = new javax.swing.JLabel();
        user_4_email = new javax.swing.JLabel();
        user_4_phone = new javax.swing.JLabel();
        user_5_panel = new javax.swing.JPanel();
        user_5_id = new javax.swing.JLabel();
        user_5_name = new javax.swing.JLabel();
        user_5_email = new javax.swing.JLabel();
        user_5_phone = new javax.swing.JLabel();
        user_6_panel = new javax.swing.JPanel();
        user_6_id = new javax.swing.JLabel();
        user_6_name = new javax.swing.JLabel();
        user_6_email = new javax.swing.JLabel();
        user_6_phone = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        prev_page_panel = new javax.swing.JPanel();
        prev_page_icon = new javax.swing.JLabel();
        next_page_panel = new javax.swing.JPanel();
        next_page_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(58, 56, 77));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 440));

        jPanel4.setBackground(new java.awt.Color(38, 40, 55));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Orders");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(94, 237, 181));
        jLabel3.setText("Users");

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
        logout_textfield.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(77, 77, 77)
                .addComponent(logout_textfield)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        logout_labelLayout.setVerticalGroup(
            logout_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logout_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

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
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(58, 56, 77));

        user_1_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_1_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_1_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_1_id.setForeground(new java.awt.Color(255, 255, 255));
        user_1_id.setText("ID");

        user_1_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_1_name.setForeground(new java.awt.Color(255, 255, 255));
        user_1_name.setText("User Name");

        user_1_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_1_email.setForeground(new java.awt.Color(255, 255, 255));
        user_1_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_1_email.setText("Email");

        user_1_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_1_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_1_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_1_phone.setText("Phone No");
        user_1_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_1_panelLayout = new javax.swing.GroupLayout(user_1_panel);
        user_1_panel.setLayout(user_1_panelLayout);
        user_1_panelLayout.setHorizontalGroup(
            user_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_1_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_1_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_1_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_1_panelLayout.setVerticalGroup(
            user_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_1_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_1_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_1_panelLayout.createSequentialGroup()
                .addGroup(user_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_1_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_1_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        user_2_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_2_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_2_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_2_id.setForeground(new java.awt.Color(255, 255, 255));
        user_2_id.setText("ID");

        user_2_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_2_name.setForeground(new java.awt.Color(255, 255, 255));
        user_2_name.setText("User Name");

        user_2_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_2_email.setForeground(new java.awt.Color(255, 255, 255));
        user_2_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_2_email.setText("Email");

        user_2_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_2_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_2_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_2_phone.setText("Phone No");
        user_2_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_2_panelLayout = new javax.swing.GroupLayout(user_2_panel);
        user_2_panel.setLayout(user_2_panelLayout);
        user_2_panelLayout.setHorizontalGroup(
            user_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_2_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_2_email, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_2_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_2_panelLayout.setVerticalGroup(
            user_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_2_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_2_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_2_panelLayout.createSequentialGroup()
                .addGroup(user_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_2_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_2_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        user_3_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_3_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_3_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_3_id.setForeground(new java.awt.Color(255, 255, 255));
        user_3_id.setText("ID");

        user_3_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_3_name.setForeground(new java.awt.Color(255, 255, 255));
        user_3_name.setText("User Name");

        user_3_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_3_email.setForeground(new java.awt.Color(255, 255, 255));
        user_3_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_3_email.setText("Email");

        user_3_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_3_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_3_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_3_phone.setText("Phone No");
        user_3_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_3_panelLayout = new javax.swing.GroupLayout(user_3_panel);
        user_3_panel.setLayout(user_3_panelLayout);
        user_3_panelLayout.setHorizontalGroup(
            user_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_3_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_3_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_3_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_3_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_3_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_3_panelLayout.setVerticalGroup(
            user_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_3_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_3_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_3_panelLayout.createSequentialGroup()
                .addGroup(user_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_3_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_3_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        user_4_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_4_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_4_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_4_id.setForeground(new java.awt.Color(255, 255, 255));
        user_4_id.setText("ID");

        user_4_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_4_name.setForeground(new java.awt.Color(255, 255, 255));
        user_4_name.setText("User Name");

        user_4_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_4_email.setForeground(new java.awt.Color(255, 255, 255));
        user_4_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_4_email.setText("Email");

        user_4_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_4_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_4_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_4_phone.setText("Phone No");
        user_4_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_4_panelLayout = new javax.swing.GroupLayout(user_4_panel);
        user_4_panel.setLayout(user_4_panelLayout);
        user_4_panelLayout.setHorizontalGroup(
            user_4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_4_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_4_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_4_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_4_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_4_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_4_panelLayout.setVerticalGroup(
            user_4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_4_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_4_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_4_panelLayout.createSequentialGroup()
                .addComponent(user_4_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(user_4_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        user_5_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_5_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_5_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_5_id.setForeground(new java.awt.Color(255, 255, 255));
        user_5_id.setText("ID");

        user_5_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_5_name.setForeground(new java.awt.Color(255, 255, 255));
        user_5_name.setText("User Name");

        user_5_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_5_email.setForeground(new java.awt.Color(255, 255, 255));
        user_5_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_5_email.setText("Email");

        user_5_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_5_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_5_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_5_phone.setText("Phone No");
        user_5_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_5_panelLayout = new javax.swing.GroupLayout(user_5_panel);
        user_5_panel.setLayout(user_5_panelLayout);
        user_5_panelLayout.setHorizontalGroup(
            user_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_5_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_5_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_5_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_5_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_5_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_5_panelLayout.setVerticalGroup(
            user_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_5_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_5_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_5_panelLayout.createSequentialGroup()
                .addGroup(user_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_5_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_5_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        user_6_panel.setBackground(new java.awt.Color(58, 56, 77));
        user_6_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        user_6_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_6_id.setForeground(new java.awt.Color(255, 255, 255));
        user_6_id.setText("ID");

        user_6_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user_6_name.setForeground(new java.awt.Color(255, 255, 255));
        user_6_name.setText("User Name");

        user_6_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_6_email.setForeground(new java.awt.Color(255, 255, 255));
        user_6_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_6_email.setText("Email");

        user_6_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_6_phone.setForeground(new java.awt.Color(255, 255, 255));
        user_6_phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        user_6_phone.setText("Phone No");
        user_6_phone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout user_6_panelLayout = new javax.swing.GroupLayout(user_6_panel);
        user_6_panel.setLayout(user_6_panelLayout);
        user_6_panelLayout.setHorizontalGroup(
            user_6_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_6_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_6_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_6_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_6_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_6_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        user_6_panelLayout.setVerticalGroup(
            user_6_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_6_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(user_6_phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_6_panelLayout.createSequentialGroup()
                .addGroup(user_6_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_6_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_6_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        jPanel22.setBackground(new java.awt.Color(58, 56, 77));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        prev_page_panel.setBackground(new java.awt.Color(58, 56, 77));
        prev_page_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        prev_page_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prev_page_panelMouseClicked(evt);
            }
        });

        prev_page_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/left-chevron.png"))); // NOI18N
        prev_page_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prev_page_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prev_page_iconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout prev_page_panelLayout = new javax.swing.GroupLayout(prev_page_panel);
        prev_page_panel.setLayout(prev_page_panelLayout);
        prev_page_panelLayout.setHorizontalGroup(
            prev_page_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prev_page_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prev_page_icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        prev_page_panelLayout.setVerticalGroup(
            prev_page_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prev_page_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        next_page_panel.setBackground(new java.awt.Color(58, 56, 77));
        next_page_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        next_page_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_page_panelMouseClicked(evt);
            }
        });

        next_page_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/right-chevron.png"))); // NOI18N
        next_page_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next_page_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_page_iconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout next_page_panelLayout = new javax.swing.GroupLayout(next_page_panel);
        next_page_panel.setLayout(next_page_panelLayout);
        next_page_panelLayout.setHorizontalGroup(
            next_page_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, next_page_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next_page_icon)
                .addContainerGap())
        );
        next_page_panelLayout.setVerticalGroup(
            next_page_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(next_page_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prev_page_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next_page_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(next_page_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prev_page_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_4_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_3_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_1_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_5_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_6_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_3_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_4_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_5_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_6_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_textfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_textfieldMouseClicked
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_textfieldMouseClicked

    private void logout_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_labelMouseClicked
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_labelMouseClicked

    private void prev_page_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_iconMouseClicked
        changePage(this.page_id-1);
    }//GEN-LAST:event_prev_page_iconMouseClicked

    private void prev_page_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_panelMouseClicked
        changePage(this.page_id-1);
    }//GEN-LAST:event_prev_page_panelMouseClicked

    private void next_page_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_iconMouseClicked
        changePage(this.page_id+1);
    }//GEN-LAST:event_next_page_iconMouseClicked

    private void next_page_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_panelMouseClicked
        changePage(this.page_id+1);
    }//GEN-LAST:event_next_page_panelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Admin admin = new Admin(this.user_id, 1);
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(admin_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_user(0,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel loaderpanel;
    private javax.swing.JPanel logout_label;
    private javax.swing.JLabel logout_textfield;
    private javax.swing.JLabel next_page_icon;
    private javax.swing.JPanel next_page_panel;
    private javax.swing.JLabel prev_page_icon;
    private javax.swing.JPanel prev_page_panel;
    private javax.swing.JLabel user_1_email;
    private javax.swing.JLabel user_1_id;
    private javax.swing.JLabel user_1_name;
    private javax.swing.JPanel user_1_panel;
    private javax.swing.JLabel user_1_phone;
    private javax.swing.JLabel user_2_email;
    private javax.swing.JLabel user_2_id;
    private javax.swing.JLabel user_2_name;
    private javax.swing.JPanel user_2_panel;
    private javax.swing.JLabel user_2_phone;
    private javax.swing.JLabel user_3_email;
    private javax.swing.JLabel user_3_id;
    private javax.swing.JLabel user_3_name;
    private javax.swing.JPanel user_3_panel;
    private javax.swing.JLabel user_3_phone;
    private javax.swing.JLabel user_4_email;
    private javax.swing.JLabel user_4_id;
    private javax.swing.JLabel user_4_name;
    private javax.swing.JPanel user_4_panel;
    private javax.swing.JLabel user_4_phone;
    private javax.swing.JLabel user_5_email;
    private javax.swing.JLabel user_5_id;
    private javax.swing.JLabel user_5_name;
    private javax.swing.JPanel user_5_panel;
    private javax.swing.JLabel user_5_phone;
    private javax.swing.JLabel user_6_email;
    private javax.swing.JLabel user_6_id;
    private javax.swing.JLabel user_6_name;
    private javax.swing.JPanel user_6_panel;
    private javax.swing.JLabel user_6_phone;
    // End of variables declaration//GEN-END:variables
}
