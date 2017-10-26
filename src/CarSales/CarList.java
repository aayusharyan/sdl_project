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
public class CarList extends javax.swing.JFrame {
    
    private int user_id;
    private final int curr_page_id;
    private final int curr_company_id;
    
    public void changePage(int new_page_id) {
        CarList car_list = new CarList(this.user_id, this.curr_company_id, new_page_id);
        car_list.setVisible(true);
        this.dispose();
    }
    
    public void viewCar(int car_id) {
        CarDetails car_details = new CarDetails(this.user_id, car_id);
        car_details.setVisible(true);
        this.dispose();
    }
    
    public void buyCar(int car_id) {
        Receipt transaction = new Receipt(this.user_id, car_id);
        transaction.setVisible(true);
        this.dispose();
    }

    /**
     * Creates new form CarList
     * @param company_id
     * @param page_id (Optional)
     */
    public CarList(int user_id, int company_id, int page_id) {
        this.curr_company_id = company_id;
        this.curr_page_id = page_id;
        this.user_id = user_id;
        initComponents();
        cars_panel_1.setVisible(false);
        cars_panel_2.setVisible(false);
        cars_panel_3.setVisible(false);
        cars_panel_4.setVisible(false);
        cars_panel_5.setVisible(false);
        prev_page_panel.setVisible(false);
        next_page_panel.setVisible(false);

        new Thread(() -> {
            int limit = 5;
            int offset = 0;
            if(page_id > 1) {
                offset = ((page_id-1)*limit);
            }
            SQLdb connection = new SQLdb();
            String cars_json_data = connection.fetchCars(company_id, offset, limit);
            Gson gson = new Gson();
            String[][] cars_data = gson.fromJson(cars_json_data, String[][].class);
            for(String[] single_car : cars_data) {
                if(single_car[0] != null) {
                    int single_car_id = Integer.parseInt(single_car[0]);
                    int car_location = (single_car_id-1)%5;
                    Image image = new ImageIcon(this.getClass().getResource(single_car[2])).getImage();
                    switch (car_location) {
                        case 0:
                            cars_panel_1.setVisible(true);
                            cars_panel_1_icon.setIcon(new ImageIcon(image));
                            cars_panel_1_name.setText(single_car[1]);
                            cars_panel_1_company_name.setText(single_car[3]);
                            cars_panel_1_buy.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   buyCar(single_car_id);
                                }
                            });
                            cars_panel_1_view_more.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   viewCar(single_car_id);
                                }
                            });
                        break;
                        case 1:
                            cars_panel_2.setVisible(true);
                            cars_panel_2_icon.setIcon(new ImageIcon(image));
                            cars_panel_2_name.setText(single_car[1]);
                            cars_panel_2_company_name.setText(single_car[3]);
                            cars_panel_2_buy.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   buyCar(single_car_id);
                                }
                            });
                            cars_panel_2_view_more.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   viewCar(single_car_id);
                                }
                            });
                        break;
                        case 2:
                            cars_panel_3.setVisible(true);
                            cars_panel_3_icon.setIcon(new ImageIcon(image));
                            cars_panel_3_name.setText(single_car[1]);
                            cars_panel_3_company_name.setText(single_car[3]);
                            cars_panel_3_buy.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   buyCar(single_car_id);
                                }
                            });
                            cars_panel_3_view_more.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   viewCar(single_car_id);
                                }
                            });
                        break;
                        case 3:
                            cars_panel_4.setVisible(true);
                            cars_panel_4_icon.setIcon(new ImageIcon(image));
                            cars_panel_4_name.setText(single_car[1]);
                            cars_panel_4_company_name.setText(single_car[3]);
                            cars_panel_4_buy.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   buyCar(single_car_id);
                                }
                            });
                            cars_panel_4_view_more.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   viewCar(single_car_id);
                                }
                            });
                        break;
                        case 4:
                            cars_panel_5.setVisible(true);
                            cars_panel_5_icon.setIcon(new ImageIcon(image));
                            cars_panel_5_name.setText(single_car[1]);
                            cars_panel_5_company_name.setText(single_car[3]);
                            cars_panel_5_buy.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   buyCar(single_car_id);
                                }
                            });
                            cars_panel_5_view_more.addMouseListener(new java.awt.event.MouseAdapter() {
                                @Override
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                   viewCar(single_car_id);
                                }
                            });
                        break;
                    }
                }
            }
            String user_obj_json = connection.getUserDetails(this.user_id);
            String[] user_details = gson.fromJson(user_obj_json, String[].class);
            user_name.setText(user_details[1]);
            
            if(offset > 0) {
                prev_page_panel.setVisible(true);
            }
            
            connection = new SQLdb();
            int remaining_items = connection.remainingCars(company_id, offset, limit);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loaderpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        back_btn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        cars_panel_1 = new javax.swing.JPanel();
        cars_panel_1_icon = new javax.swing.JLabel();
        cars_panel_1_name = new javax.swing.JLabel();
        cars_panel_1_company_name = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cars_panel_1_buy = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cars_panel_1_view_more = new javax.swing.JLabel();
        cars_panel_2 = new javax.swing.JPanel();
        cars_panel_2_icon = new javax.swing.JLabel();
        cars_panel_2_name = new javax.swing.JLabel();
        cars_panel_2_company_name = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cars_panel_2_buy = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cars_panel_2_view_more = new javax.swing.JLabel();
        cars_panel_3 = new javax.swing.JPanel();
        cars_panel_3_icon = new javax.swing.JLabel();
        cars_panel_3_name = new javax.swing.JLabel();
        cars_panel_3_company_name = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        cars_panel_3_buy = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        cars_panel_3_view_more = new javax.swing.JLabel();
        cars_panel_4 = new javax.swing.JPanel();
        cars_panel_4_icon = new javax.swing.JLabel();
        cars_panel_4_name = new javax.swing.JLabel();
        cars_panel_4_company_name = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        cars_panel_4_buy = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        cars_panel_4_view_more = new javax.swing.JLabel();
        cars_panel_5 = new javax.swing.JPanel();
        cars_panel_5_icon = new javax.swing.JLabel();
        cars_panel_5_name = new javax.swing.JLabel();
        cars_panel_5_company_name = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        cars_panel_5_buy = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        cars_panel_5_view_more = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        prev_page_panel = new javax.swing.JPanel();
        prev_page_icon = new javax.swing.JLabel();
        next_page_panel = new javax.swing.JPanel();
        next_page_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(58, 56, 77));

        jPanel2.setBackground(new java.awt.Color(38, 40, 55));

        jPanel9.setBackground(new java.awt.Color(38, 40, 55));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/account.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(8, 8, 8))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(38, 40, 55));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 109, 125), 1, true));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Logout");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        back_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setText("⬅ Back");
        back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_btnMouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(38, 40, 55));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi,");

        user_name.setBackground(new java.awt.Color(38, 40, 55));
        user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(back_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(loaderpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );

        cars_panel_1.setBackground(new java.awt.Color(58, 56, 77));
        cars_panel_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        cars_panel_1_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-basic.png"))); // NOI18N

        cars_panel_1_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cars_panel_1_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_1_name.setText("Single Car Name");

        cars_panel_1_company_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cars_panel_1_company_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_1_company_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cars_panel_1_company_name.setText("(Company Name)");

        jPanel3.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_1_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/online-shopping -32.png"))); // NOI18N
        cars_panel_1_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_1_buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_1_buy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_1_view_more.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/more.png"))); // NOI18N
        cars_panel_1_view_more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_1_view_more, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_1_view_more, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cars_panel_1Layout = new javax.swing.GroupLayout(cars_panel_1);
        cars_panel_1.setLayout(cars_panel_1Layout);
        cars_panel_1Layout.setHorizontalGroup(
            cars_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cars_panel_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_1_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(cars_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cars_panel_1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars_panel_1_company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cars_panel_1Layout.setVerticalGroup(
            cars_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_1_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cars_panel_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cars_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cars_panel_1Layout.createSequentialGroup()
                        .addComponent(cars_panel_1_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cars_panel_1_company_name))
                    .addGroup(cars_panel_1Layout.createSequentialGroup()
                        .addGroup(cars_panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cars_panel_2.setBackground(new java.awt.Color(58, 56, 77));
        cars_panel_2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        cars_panel_2_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-jeep.png"))); // NOI18N

        cars_panel_2_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cars_panel_2_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_2_name.setText("Single Car Name");

        cars_panel_2_company_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cars_panel_2_company_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_2_company_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cars_panel_2_company_name.setText("(Company Name)");

        jPanel6.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_2_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/online-shopping -32.png"))); // NOI18N
        cars_panel_2_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_2_buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_2_buy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_2_view_more.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/more.png"))); // NOI18N
        cars_panel_2_view_more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_2_view_more, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_2_view_more, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cars_panel_2Layout = new javax.swing.GroupLayout(cars_panel_2);
        cars_panel_2.setLayout(cars_panel_2Layout);
        cars_panel_2Layout.setHorizontalGroup(
            cars_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cars_panel_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_2_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cars_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cars_panel_2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars_panel_2_company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cars_panel_2Layout.setVerticalGroup(
            cars_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_2_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cars_panel_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cars_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cars_panel_2Layout.createSequentialGroup()
                        .addComponent(cars_panel_2_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cars_panel_2_company_name))
                    .addGroup(cars_panel_2Layout.createSequentialGroup()
                        .addGroup(cars_panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cars_panel_3.setBackground(new java.awt.Color(58, 56, 77));
        cars_panel_3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        cars_panel_3_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-lmv.png"))); // NOI18N

        cars_panel_3_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cars_panel_3_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_3_name.setText("Single Car Name");

        cars_panel_3_company_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cars_panel_3_company_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_3_company_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cars_panel_3_company_name.setText("(Company Name)");

        jPanel10.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_3_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/online-shopping -32.png"))); // NOI18N
        cars_panel_3_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_3_buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_3_buy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_3_view_more.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/more.png"))); // NOI18N
        cars_panel_3_view_more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_3_view_more, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_3_view_more, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cars_panel_3Layout = new javax.swing.GroupLayout(cars_panel_3);
        cars_panel_3.setLayout(cars_panel_3Layout);
        cars_panel_3Layout.setHorizontalGroup(
            cars_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cars_panel_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_3_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(cars_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cars_panel_3_name, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars_panel_3_company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cars_panel_3Layout.setVerticalGroup(
            cars_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_3_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cars_panel_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cars_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cars_panel_3Layout.createSequentialGroup()
                        .addComponent(cars_panel_3_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cars_panel_3_company_name))
                    .addGroup(cars_panel_3Layout.createSequentialGroup()
                        .addGroup(cars_panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cars_panel_4.setBackground(new java.awt.Color(58, 56, 77));
        cars_panel_4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        cars_panel_4_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-mini.png"))); // NOI18N

        cars_panel_4_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cars_panel_4_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_4_name.setText("Single Car Name");

        cars_panel_4_company_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cars_panel_4_company_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_4_company_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cars_panel_4_company_name.setText("(Company Name)");

        jPanel12.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_4_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/online-shopping -32.png"))); // NOI18N
        cars_panel_4_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_4_buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_4_buy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_4_view_more.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/more.png"))); // NOI18N
        cars_panel_4_view_more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_4_view_more, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_4_view_more, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cars_panel_4Layout = new javax.swing.GroupLayout(cars_panel_4);
        cars_panel_4.setLayout(cars_panel_4Layout);
        cars_panel_4Layout.setHorizontalGroup(
            cars_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cars_panel_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_4_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(cars_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cars_panel_4_name, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars_panel_4_company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cars_panel_4Layout.setVerticalGroup(
            cars_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_4_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cars_panel_4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cars_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cars_panel_4Layout.createSequentialGroup()
                        .addComponent(cars_panel_4_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cars_panel_4_company_name))
                    .addGroup(cars_panel_4Layout.createSequentialGroup()
                        .addGroup(cars_panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        cars_panel_5.setBackground(new java.awt.Color(58, 56, 77));
        cars_panel_5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        cars_panel_5_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/car-van.png"))); // NOI18N

        cars_panel_5_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cars_panel_5_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_5_name.setText("Single Car Name");

        cars_panel_5_company_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cars_panel_5_company_name.setForeground(new java.awt.Color(255, 255, 255));
        cars_panel_5_company_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cars_panel_5_company_name.setText("(Company Name)");

        jPanel14.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_5_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/online-shopping -32.png"))); // NOI18N
        cars_panel_5_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_5_buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_5_buy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(58, 56, 77));

        cars_panel_5_view_more.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/more.png"))); // NOI18N
        cars_panel_5_view_more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_5_view_more, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_5_view_more, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cars_panel_5Layout = new javax.swing.GroupLayout(cars_panel_5);
        cars_panel_5.setLayout(cars_panel_5Layout);
        cars_panel_5Layout.setHorizontalGroup(
            cars_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cars_panel_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_5_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(cars_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cars_panel_5_name, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars_panel_5_company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cars_panel_5Layout.setVerticalGroup(
            cars_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cars_panel_5_icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cars_panel_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cars_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cars_panel_5Layout.createSequentialGroup()
                        .addComponent(cars_panel_5_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cars_panel_5_company_name))
                    .addGroup(cars_panel_5Layout.createSequentialGroup()
                        .addGroup(cars_panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(58, 56, 77));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(94, 237, 181), 1, true));

        prev_page_panel.setBackground(new java.awt.Color(58, 56, 77));
        prev_page_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        prev_page_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prev_page_panelMouseClicked(evt);
            }
        });

        prev_page_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarSales/assets/icons/left-chevron.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prev_page_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next_page_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(next_page_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prev_page_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cars_panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cars_panel_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cars_panel_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cars_panel_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cars_panel_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cars_panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cars_panel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cars_panel_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cars_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cars_panel_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_btnMouseClicked
        CompanyList company_list = new CompanyList(this.user_id);
        company_list.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnMouseClicked

    private void prev_page_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_iconMouseClicked
        changePage(this.curr_page_id-1);
    }//GEN-LAST:event_prev_page_iconMouseClicked

    private void prev_page_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prev_page_panelMouseClicked
        changePage(this.curr_page_id-1);
    }//GEN-LAST:event_prev_page_panelMouseClicked

    private void next_page_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_iconMouseClicked
        changePage(this.curr_page_id+1);
    }//GEN-LAST:event_next_page_iconMouseClicked

    private void next_page_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_page_panelMouseClicked
        changePage(this.curr_page_id+1);
    }//GEN-LAST:event_next_page_panelMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        ProfileM prifile_setting = new ProfileM(this.user_id);
        prifile_setting.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        ProfileM prifile_setting = new ProfileM(this.user_id);
        prifile_setting.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

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
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarList(0, -1, 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_btn;
    private javax.swing.JPanel cars_panel_1;
    private javax.swing.JLabel cars_panel_1_buy;
    private javax.swing.JLabel cars_panel_1_company_name;
    private javax.swing.JLabel cars_panel_1_icon;
    private javax.swing.JLabel cars_panel_1_name;
    private javax.swing.JLabel cars_panel_1_view_more;
    private javax.swing.JPanel cars_panel_2;
    private javax.swing.JLabel cars_panel_2_buy;
    private javax.swing.JLabel cars_panel_2_company_name;
    private javax.swing.JLabel cars_panel_2_icon;
    private javax.swing.JLabel cars_panel_2_name;
    private javax.swing.JLabel cars_panel_2_view_more;
    private javax.swing.JPanel cars_panel_3;
    private javax.swing.JLabel cars_panel_3_buy;
    private javax.swing.JLabel cars_panel_3_company_name;
    private javax.swing.JLabel cars_panel_3_icon;
    private javax.swing.JLabel cars_panel_3_name;
    private javax.swing.JLabel cars_panel_3_view_more;
    private javax.swing.JPanel cars_panel_4;
    private javax.swing.JLabel cars_panel_4_buy;
    private javax.swing.JLabel cars_panel_4_company_name;
    private javax.swing.JLabel cars_panel_4_icon;
    private javax.swing.JLabel cars_panel_4_name;
    private javax.swing.JLabel cars_panel_4_view_more;
    private javax.swing.JPanel cars_panel_5;
    private javax.swing.JLabel cars_panel_5_buy;
    private javax.swing.JLabel cars_panel_5_company_name;
    private javax.swing.JLabel cars_panel_5_icon;
    private javax.swing.JLabel cars_panel_5_name;
    private javax.swing.JLabel cars_panel_5_view_more;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel loaderpanel;
    private javax.swing.JLabel next_page_icon;
    private javax.swing.JPanel next_page_panel;
    private javax.swing.JLabel prev_page_icon;
    private javax.swing.JPanel prev_page_panel;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
