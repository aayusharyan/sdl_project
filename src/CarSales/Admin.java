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
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form AddCar
     */
    public Admin(int user_id, int page_id) {
        initComponents();
        
            int limit = 5;
            int offset = 0;
            if(page_id > 1) {
                offset = ((page_id-1)*limit);
            }
            SQLdb connection = new SQLdb();
            String orders_json_str = connection.getPurchases(offset, limit);
            Gson gson = new Gson();
            String[][] orders_data = gson.fromJson(orders_json_str, String[][].class);
            for(String[] single_order : orders_data) {
                if(single_order[0] != null) {
                    int single_order_id = Integer.parseInt(single_order[0]);
                    int order_location = (single_order_id-1)%5;
                    
                    int purchase_user_id = Integer.parseInt(single_order[1]);
                    String purchase_user_details = connection.getUserDetails(purchase_user_id);
                    String[] purchase_user_data = gson.fromJson(purchase_user_details, String[].class);
                    
                    int car_id = Integer.parseInt(single_order[2]);
                    String car_details_str = connection.getCarDetails(car_id);
                    String[] car_data = gson.fromJson(car_details_str, String[].class);
                    
                    switch (order_location) {
                        case 0:
                            order_1_car_name.setText(car_data[1]);
                            order_1_user_name.setText(purchase_user_data[1]);
                        break;
                    }
                }
            }
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
        jLabel_orders = new javax.swing.JLabel();
        Jpanel_user = new javax.swing.JLabel();
        logout_label = new javax.swing.JPanel();
        logout_textfield = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        order_1_panel = new javax.swing.JPanel();
        order_1_icon = new javax.swing.JLabel();
        order_1_user_name = new javax.swing.JLabel();
        order_1_car_name = new javax.swing.JLabel();
        order_2_panel = new javax.swing.JPanel();
        order_2_icon = new javax.swing.JLabel();
        order_2_user_name = new javax.swing.JLabel();
        order_2_car_name = new javax.swing.JLabel();
        order_3_panel = new javax.swing.JPanel();
        order_3_icon = new javax.swing.JLabel();
        order_3_user_name = new javax.swing.JLabel();
        order_3_car_name = new javax.swing.JLabel();
        order_4_panel = new javax.swing.JPanel();
        order_4_icon = new javax.swing.JLabel();
        order_4_user_name = new javax.swing.JLabel();
        order_4_car_name = new javax.swing.JLabel();
        order_5_panel = new javax.swing.JPanel();
        order_5_icon = new javax.swing.JLabel();
        order_5_user_name = new javax.swing.JLabel();
        order_5_car_name = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        prev_page_panel1 = new javax.swing.JPanel();
        prev_page_icon1 = new javax.swing.JLabel();
        next_page_panel1 = new javax.swing.JPanel();
        next_page_icon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(58, 56, 77));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 440));

        jPanel4.setBackground(new java.awt.Color(38, 40, 55));

        jLabel_orders.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_orders.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orders.setText("Orders");

        Jpanel_user.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jpanel_user.setForeground(new java.awt.Color(255, 255, 255));
        Jpanel_user.setText("User");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jpanel_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jpanel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(logout_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(58, 56, 77));

        order_1_panel.setBackground(new java.awt.Color(58, 56, 77));
        order_1_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        order_1_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        order_1_user_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_1_user_name.setForeground(new java.awt.Color(255, 255, 255));
        order_1_user_name.setText("User Name");

        order_1_car_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_1_car_name.setForeground(new java.awt.Color(255, 255, 255));
        order_1_car_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        order_1_car_name.setText("Car Name");

        javax.swing.GroupLayout order_1_panelLayout = new javax.swing.GroupLayout(order_1_panel);
        order_1_panel.setLayout(order_1_panelLayout);
        order_1_panelLayout.setHorizontalGroup(
            order_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_1_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_1_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_1_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order_1_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        order_1_panelLayout.setVerticalGroup(
            order_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(order_1_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_1_panelLayout.createSequentialGroup()
                .addGroup(order_1_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(order_1_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(order_1_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_1_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        order_2_panel.setBackground(new java.awt.Color(58, 56, 77));
        order_2_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        order_2_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        order_2_user_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_2_user_name.setForeground(new java.awt.Color(255, 255, 255));
        order_2_user_name.setText("User Name");

        order_2_car_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_2_car_name.setForeground(new java.awt.Color(255, 255, 255));
        order_2_car_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        order_2_car_name.setText("Car Name");

        javax.swing.GroupLayout order_2_panelLayout = new javax.swing.GroupLayout(order_2_panel);
        order_2_panel.setLayout(order_2_panelLayout);
        order_2_panelLayout.setHorizontalGroup(
            order_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_2_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_2_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order_2_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );
        order_2_panelLayout.setVerticalGroup(
            order_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(order_2_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_2_panelLayout.createSequentialGroup()
                .addGroup(order_2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(order_2_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(order_2_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_2_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        order_3_panel.setBackground(new java.awt.Color(58, 56, 77));
        order_3_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        order_3_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        order_3_user_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_3_user_name.setForeground(new java.awt.Color(255, 255, 255));
        order_3_user_name.setText("User Name");

        order_3_car_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_3_car_name.setForeground(new java.awt.Color(255, 255, 255));
        order_3_car_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        order_3_car_name.setText("Car Name");

        javax.swing.GroupLayout order_3_panelLayout = new javax.swing.GroupLayout(order_3_panel);
        order_3_panel.setLayout(order_3_panelLayout);
        order_3_panelLayout.setHorizontalGroup(
            order_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_3_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_3_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_3_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order_3_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        order_3_panelLayout.setVerticalGroup(
            order_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(order_3_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_3_panelLayout.createSequentialGroup()
                .addGroup(order_3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(order_3_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(order_3_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_3_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        order_4_panel.setBackground(new java.awt.Color(58, 56, 77));
        order_4_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        order_4_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        order_4_user_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_4_user_name.setForeground(new java.awt.Color(255, 255, 255));
        order_4_user_name.setText("User Name");

        order_4_car_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_4_car_name.setForeground(new java.awt.Color(255, 255, 255));
        order_4_car_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        order_4_car_name.setText("Car Name");

        javax.swing.GroupLayout order_4_panelLayout = new javax.swing.GroupLayout(order_4_panel);
        order_4_panel.setLayout(order_4_panelLayout);
        order_4_panelLayout.setHorizontalGroup(
            order_4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_4_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_4_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_4_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order_4_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        order_4_panelLayout.setVerticalGroup(
            order_4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(order_4_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_4_panelLayout.createSequentialGroup()
                .addGroup(order_4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(order_4_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(order_4_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_4_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        order_5_panel.setBackground(new java.awt.Color(58, 56, 77));
        order_5_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        order_5_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        order_5_user_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        order_5_user_name.setForeground(new java.awt.Color(255, 255, 255));
        order_5_user_name.setText("User Name");

        order_5_car_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        order_5_car_name.setForeground(new java.awt.Color(255, 255, 255));
        order_5_car_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        order_5_car_name.setText("Car Name");

        javax.swing.GroupLayout order_5_panelLayout = new javax.swing.GroupLayout(order_5_panel);
        order_5_panel.setLayout(order_5_panelLayout);
        order_5_panelLayout.setHorizontalGroup(
            order_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_5_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_5_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_5_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order_5_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        order_5_panelLayout.setVerticalGroup(
            order_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(order_5_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_5_panelLayout.createSequentialGroup()
                .addGroup(order_5_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(order_5_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(order_5_car_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_5_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(58, 56, 77));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        prev_page_panel1.setBackground(new java.awt.Color(58, 56, 77));
        prev_page_panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        prev_page_panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prev_page_panel1MouseClicked(evt);
            }
        });

        prev_page_icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/left-chevron.png"))); // NOI18N
        prev_page_icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prev_page_icon1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout prev_page_panel1Layout = new javax.swing.GroupLayout(prev_page_panel1);
        prev_page_panel1.setLayout(prev_page_panel1Layout);
        prev_page_panel1Layout.setHorizontalGroup(
            prev_page_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prev_page_panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prev_page_icon1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        prev_page_panel1Layout.setVerticalGroup(
            prev_page_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prev_page_icon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        next_page_panel1.setBackground(new java.awt.Color(58, 56, 77));
        next_page_panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        next_page_panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_page_panel1MouseClicked(evt);
            }
        });

        next_page_icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/right-chevron.png"))); // NOI18N
        next_page_icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_page_icon1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout next_page_panel1Layout = new javax.swing.GroupLayout(next_page_panel1);
        next_page_panel1.setLayout(next_page_panel1Layout);
        next_page_panel1Layout.setHorizontalGroup(
            next_page_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, next_page_panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next_page_icon1)
                .addContainerGap())
        );
        next_page_panel1Layout.setVerticalGroup(
            next_page_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(next_page_icon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prev_page_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next_page_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(next_page_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prev_page_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_1_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_3_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_4_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_5_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order_1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_3_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_4_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_5_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void prev_page_panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_panel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_prev_page_panel1MouseClicked

    private void next_page_icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_icon1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_next_page_icon1MouseClicked

    private void next_page_panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_panel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_next_page_panel1MouseClicked

    private void prev_page_icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_icon1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_prev_page_icon1MouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin(0,-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jpanel_user;
    private javax.swing.JLabel jLabel_orders;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel logout_label;
    private javax.swing.JLabel logout_textfield;
    private javax.swing.JLabel next_page_icon1;
    private javax.swing.JPanel next_page_panel1;
    private javax.swing.JLabel order_1_car_name;
    private javax.swing.JLabel order_1_icon;
    private javax.swing.JPanel order_1_panel;
    private javax.swing.JLabel order_1_user_name;
    private javax.swing.JLabel order_2_car_name;
    private javax.swing.JLabel order_2_icon;
    private javax.swing.JPanel order_2_panel;
    private javax.swing.JLabel order_2_user_name;
    private javax.swing.JLabel order_3_car_name;
    private javax.swing.JLabel order_3_icon;
    private javax.swing.JPanel order_3_panel;
    private javax.swing.JLabel order_3_user_name;
    private javax.swing.JLabel order_4_car_name;
    private javax.swing.JLabel order_4_icon;
    private javax.swing.JPanel order_4_panel;
    private javax.swing.JLabel order_4_user_name;
    private javax.swing.JLabel order_5_car_name;
    private javax.swing.JLabel order_5_icon;
    private javax.swing.JPanel order_5_panel;
    private javax.swing.JLabel order_5_user_name;
    private javax.swing.JLabel prev_page_icon1;
    private javax.swing.JPanel prev_page_panel1;
    // End of variables declaration//GEN-END:variables
}
