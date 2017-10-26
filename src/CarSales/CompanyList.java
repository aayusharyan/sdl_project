/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSales;

import com.google.gson.Gson;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author aayush
 */
public class CompanyList extends javax.swing.JFrame {
    
    private int user_id;
    
    public void companySelect(int company_id) {
        CarList car_list = new CarList(user_id, company_id, -1);
        car_list.setVisible(true);
        this.dispose();
    }

    /**
     * Creates new form CompanyList
     * @param user_id
     */
    public CompanyList(int user_id) {
        this.user_id = user_id;
        initComponents();
        company_panel_1.setVisible(false);
        company_panel_2.setVisible(false);
        company_panel_3.setVisible(false);
        company_panel_4.setVisible(false);
        company_panel_4.setVisible(false);
        company_panel_5.setVisible(false);
        company_panel_6.setVisible(false);
        company_panel_8.setVisible(false);
        company_panel_7.setVisible(false);
        company_panel_8.setVisible(false);
        company_panel_9.setVisible(false);
        
        new Thread(() -> {
            SQLdb connection = new SQLdb();
            String company_json_data = connection.fetchComapnies();
            Gson gson = new Gson();
            String[][] company_data = gson.fromJson(company_json_data, String[][].class);
            for(String[] single_company : company_data) {
                if(single_company[0] != null) {
                    int single_company_id = Integer.parseInt(single_company[0]);
                    int company_location = (single_company_id-1)%9;
                    Image image = new ImageIcon(this.getClass().getResource(single_company[2])).getImage();
                    switch (company_location) {
                        case 0:
                            company_panel_1.setVisible(true);
                            company_label_1.setIcon(new ImageIcon(image));
                            company_label_1.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 1:
                            company_panel_2.setVisible(true);
                            company_label_2.setIcon(new ImageIcon(image));  
                            company_label_2.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 2:
                            company_panel_3.setVisible(true);
                            company_label_3.setIcon(new ImageIcon(image));
                            company_label_3.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 3:
                            company_panel_4.setVisible(true);
                            company_label_4.setIcon(new ImageIcon(image));
                            company_label_4.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 4:
                            company_panel_5.setVisible(true);
                            company_label_5.setIcon(new ImageIcon(image));
                            company_label_5.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 5:
                            company_panel_6.setVisible(true);
                            company_label_6.setIcon(new ImageIcon(image));
                            company_label_6.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 6:
                            company_panel_7.setVisible(true);
                            company_label_7.setIcon(new ImageIcon(image));
                            company_label_7.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 7:
                            company_panel_8.setVisible(true);
                            company_label_8.setIcon(new ImageIcon(image));
                            company_label_8.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                        case 8:
                            company_panel_9.setVisible(true);
                            company_label_9.setIcon(new ImageIcon(image));
                            company_label_9.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    companySelect(single_company_id);
                                }
                            });
                            break;
                    }
                }
            }
        
        String user_obj_json = connection.getUserDetails(this.user_id);
        String[] user_details = gson.fromJson(user_obj_json, String[].class);
        user_name.setText(user_details[1]);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout_label = new javax.swing.JPanel();
        logout_textfield = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        loaderpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        companyLogoViewPanel = new javax.swing.JPanel();
        company_panel_1 = new javax.swing.JPanel();
        company_label_1 = new javax.swing.JLabel();
        company_panel_2 = new javax.swing.JPanel();
        company_label_2 = new javax.swing.JLabel();
        company_panel_3 = new javax.swing.JPanel();
        company_label_3 = new javax.swing.JLabel();
        company_panel_4 = new javax.swing.JPanel();
        company_label_4 = new javax.swing.JLabel();
        company_panel_5 = new javax.swing.JPanel();
        company_label_5 = new javax.swing.JLabel();
        company_panel_6 = new javax.swing.JPanel();
        company_label_6 = new javax.swing.JLabel();
        company_panel_7 = new javax.swing.JPanel();
        company_label_7 = new javax.swing.JLabel();
        company_panel_8 = new javax.swing.JPanel();
        company_label_8 = new javax.swing.JLabel();
        company_panel_9 = new javax.swing.JPanel();
        company_label_9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(58, 56, 77));

        jPanel2.setBackground(new java.awt.Color(38, 40, 55));

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
                .addGap(50, 50, 50)
                .addComponent(logout_textfield)
                .addContainerGap(50, Short.MAX_VALUE))
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
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/account.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

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

        jLabel6.setBackground(new java.awt.Color(38, 40, 55));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi,");

        user_name.setBackground(new java.awt.Color(38, 40, 55));
        user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));

        loaderpanel.setBackground(new java.awt.Color(38, 40, 55));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );

        companyLogoViewPanel.setBackground(new java.awt.Color(58, 56, 77));

        company_label_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_1Layout = new javax.swing.GroupLayout(company_panel_1);
        company_panel_1.setLayout(company_panel_1Layout);
        company_panel_1Layout.setHorizontalGroup(
            company_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_1Layout.setVerticalGroup(
            company_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_2Layout = new javax.swing.GroupLayout(company_panel_2);
        company_panel_2.setLayout(company_panel_2Layout);
        company_panel_2Layout.setHorizontalGroup(
            company_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_2Layout.setVerticalGroup(
            company_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_3Layout = new javax.swing.GroupLayout(company_panel_3);
        company_panel_3.setLayout(company_panel_3Layout);
        company_panel_3Layout.setHorizontalGroup(
            company_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_3Layout.setVerticalGroup(
            company_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_4Layout = new javax.swing.GroupLayout(company_panel_4);
        company_panel_4.setLayout(company_panel_4Layout);
        company_panel_4Layout.setHorizontalGroup(
            company_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_4Layout.setVerticalGroup(
            company_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_5Layout = new javax.swing.GroupLayout(company_panel_5);
        company_panel_5.setLayout(company_panel_5Layout);
        company_panel_5Layout.setHorizontalGroup(
            company_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_5Layout.setVerticalGroup(
            company_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_6Layout = new javax.swing.GroupLayout(company_panel_6);
        company_panel_6.setLayout(company_panel_6Layout);
        company_panel_6Layout.setHorizontalGroup(
            company_panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_6Layout.setVerticalGroup(
            company_panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_7Layout = new javax.swing.GroupLayout(company_panel_7);
        company_panel_7.setLayout(company_panel_7Layout);
        company_panel_7Layout.setHorizontalGroup(
            company_panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_7Layout.setVerticalGroup(
            company_panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_8Layout = new javax.swing.GroupLayout(company_panel_8);
        company_panel_8.setLayout(company_panel_8Layout);
        company_panel_8Layout.setHorizontalGroup(
            company_panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_8Layout.setVerticalGroup(
            company_panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        company_label_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/logos/lo2.PNG"))); // NOI18N
        company_label_9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout company_panel_9Layout = new javax.swing.GroupLayout(company_panel_9);
        company_panel_9.setLayout(company_panel_9Layout);
        company_panel_9Layout.setHorizontalGroup(
            company_panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        company_panel_9Layout.setVerticalGroup(
            company_panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(company_label_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout companyLogoViewPanelLayout = new javax.swing.GroupLayout(companyLogoViewPanel);
        companyLogoViewPanel.setLayout(companyLogoViewPanelLayout);
        companyLogoViewPanelLayout.setHorizontalGroup(
            companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyLogoViewPanelLayout.createSequentialGroup()
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(company_panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(company_panel_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyLogoViewPanelLayout.createSequentialGroup()
                        .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(company_panel_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(company_panel_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyLogoViewPanelLayout.createSequentialGroup()
                        .addComponent(company_panel_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        companyLogoViewPanelLayout.setVerticalGroup(
            companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyLogoViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(company_panel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(company_panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(company_panel_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyLogoViewPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(company_panel_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyLogoViewPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(company_panel_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(company_panel_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(companyLogoViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(company_panel_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(company_panel_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(companyLogoViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companyLogoViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void logout_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_labelMouseClicked
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logout_labelMouseClicked

    private void logout_textfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_textfieldMouseClicked
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logout_textfieldMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        ProfileM prifile_setting = new ProfileM(this.user_id);
        prifile_setting.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        ProfileM prifile_setting = new ProfileM(this.user_id);
        prifile_setting.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel8MouseClicked

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
            java.util.logging.Logger.getLogger(CompanyList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyList(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel companyLogoViewPanel;
    private javax.swing.JLabel company_label_1;
    private javax.swing.JLabel company_label_2;
    private javax.swing.JLabel company_label_3;
    private javax.swing.JLabel company_label_4;
    private javax.swing.JLabel company_label_5;
    private javax.swing.JLabel company_label_6;
    private javax.swing.JLabel company_label_7;
    private javax.swing.JLabel company_label_8;
    private javax.swing.JLabel company_label_9;
    private javax.swing.JPanel company_panel_1;
    private javax.swing.JPanel company_panel_2;
    private javax.swing.JPanel company_panel_3;
    private javax.swing.JPanel company_panel_4;
    private javax.swing.JPanel company_panel_5;
    private javax.swing.JPanel company_panel_6;
    private javax.swing.JPanel company_panel_7;
    private javax.swing.JPanel company_panel_8;
    private javax.swing.JPanel company_panel_9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel loaderpanel;
    private javax.swing.JPanel logout_label;
    private javax.swing.JLabel logout_textfield;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
