/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSales;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayush
 */
public class SQLdb {
    Connection con;
    public SQLdb() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://166.62.27.177/carsales_db","carsales_root","carsales_root");
        }
        catch(ClassNotFoundException e){
            System.out.println("Exception "+e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Exception "+e.getMessage());
        }
    }
    //Username can also be email
    public String[] login(String json_user_data) {
        Gson gson = new Gson();
        User user_obj = gson.fromJson(json_user_data, User.class);

        String[] rtrn = new String[2];
        rtrn[0] = "false";
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT * FROM carsales WHERE `Email` = '"+user_obj.getEmail()+"' AND `Password` = '"+user_obj.getPassword()+"' LIMIT 1");
            while(re.next()){
                // ResultSet processing here
                rtrn[0] = "true";
                rtrn[1] = re.getString("Id");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rtrn;
    }
    
    public String getUserDetails(int user_id) {
        String return_str = "";
        String[] rtrn = new String[5];
        rtrn[0] = "false";
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT * FROM carsales WHERE `Id` = "+user_id);
            while(re.next()){
                rtrn[0] = re.getString("Id");
                rtrn[1] = re.getString("Name");
                rtrn[2] = re.getString("Email");
                rtrn[3] = re.getString("Phone");
                rtrn[4] = re.getString("Password");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson gson = new Gson();
        return_str = gson.toJson(rtrn);
        
        return return_str;
    }
    
    public int register(String json_user_data) {
        Gson gson = new Gson();
        int id = 0;
        User user_obj = gson.fromJson(json_user_data, User.class);
        try {
            Statement st = con.createStatement();
            st.execute("INSERT INTO carsales (`Name`, `Password`, `Email`, `Phone`) VALUES('"+user_obj.getName()+"', '"+user_obj.getPassword()+"', '"+user_obj.getEmail()+"', '"+user_obj.getPhone()+"')");
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT Id FROM carsales WHERE `Email` = '"+user_obj.getEmail()+"' AND `Password` = '"+user_obj.getPassword()+"' LIMIT 1");
            while(re.next()) {
                id = Integer.parseInt(re.getString("Id"));
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(SQLdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String fetchComapnies() {
        String return_str = "";
        String rtrn[][] = new String[12][3];
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            int count = 0;
            ResultSet re = st.executeQuery("SELECT * FROM companies LIMIT 12");
            while(re.next()){
                rtrn[count][0] = re.getString("id");
                rtrn[count][1] = re.getString("name");
                rtrn[count][2] = re.getString("logo_url");
                count++;
            }
            Gson gson = new Gson();
            return_str = gson.toJson(rtrn);
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }
    
    public String fetchCars(int company_id,int offset,int limit) {
        String return_str = "";
        String rtrn[][] = new String[limit][4];
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            int count = 0;
            String offset_statement = "";
            if(offset > 0) {
                offset_statement = " OFFSET "+offset+" ";
            }
            String whereSTR = "";
            if(company_id > 0) {
                whereSTR = " WHERE `company_id` = '" +company_id+ "'"; 
            }
            ResultSet re = st.executeQuery("SELECT * FROM cars "+whereSTR+" LIMIT "+limit+offset_statement);
            while(re.next()){
                rtrn[count][0] = re.getString("id");
                rtrn[count][1] = re.getString("name");
                rtrn[count][2] = re.getString("icon");
                rtrn[count][3] = re.getString("company_name");
                count++;
            }
            Gson gson = new Gson();
            return_str = gson.toJson(rtrn);
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }
    
    public String getCarDetails(int car_id) {
        String rtrn[] = new String[8];
        String return_str = "";
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT * FROM cars WHERE `id`="+car_id);
            while(re.next()){
                rtrn[0] = re.getString("id");
                rtrn[1] = re.getString("name");
                rtrn[2] = re.getString("icon");
                rtrn[3] = re.getString("company_name");
                rtrn[4] = re.getString("image");
                rtrn[5] = re.getString("price");
                rtrn[6] = re.getString("description");
                rtrn[7] = re.getString("company_id");
            }
            Gson gson = new Gson();
            return_str = gson.toJson(rtrn);
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }
    
    public int makeTransaction(int user_id, int car_id) {
        int transaction_id = 0;
        try {
            Statement st = con.createStatement();
            st.execute("INSERT INTO transactions (`user_id`, `product_id`) VALUES("+user_id+", "+car_id+")");
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT Id FROM transactions WHERE `user_id` = "+user_id+" AND `product_id` = "+car_id+" ORDER BY id DESC LIMIT 1");
            while(re.next()) {
                transaction_id = Integer.parseInt(re.getString("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaction_id;
    }
    
    public int remainingCars(int company_id,int offset,int limit) {
        int total_elems = 0;
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            String whereSTR = "";
            if(company_id > 0) {
                whereSTR = " WHERE `company_id` = '" +company_id+ "'"; 
            }
            ResultSet re = st.executeQuery("SELECT COUNT(*) AS total FROM cars "+whereSTR);
            while(re.next()){
                total_elems = Integer.parseInt(re.getString("total"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        int already_done = offset+limit;
        int remaining = total_elems - already_done;
        if(remaining < 0) {
            remaining = 0;
        }
        return remaining;
    }
    
    public boolean updateUser(int user_id, String name, String password, String phone) {
        try {
            Statement st = con.createStatement();
            st.execute("UPDATE carsales SET `Name` = '"+name+"', `Password` = '"+password+"', `Phone` = '"+phone+"' WHERE `Id` = "+user_id);
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }
    
    public String getUsers(int offset, int limit) {
        String return_str = "";
        String rtrn[][] = new String[limit][4];
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            int count = 0;
            String offset_statement = "";
            if(offset > 0) {
                offset_statement = " OFFSET "+offset+" ";
            }
            ResultSet re = st.executeQuery("SELECT * FROM carsales LIMIT "+limit+offset_statement);
            while(re.next()){
                rtrn[count][0] = re.getString("Id");
                rtrn[count][1] = re.getString("Name");
                rtrn[count][2] = re.getString("Email");
                rtrn[count][3] = re.getString("Phone");
                count++;
            }
            Gson gson = new Gson();
            return_str = gson.toJson(rtrn);
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }
    
    public String getPurchases(int offset, int limit) {
        String return_str = "";
        String rtrn[][] = new String[limit][3];
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            int count = 0;
            String offset_statement = "";
            if(offset > 0) {
                offset_statement = " OFFSET "+offset+" ";
            }
            ResultSet re = st.executeQuery("SELECT * FROM transactions ORDER BY id DESC LIMIT "+limit+offset_statement);
            while(re.next()){
                rtrn[count][0] = re.getString("id");
                rtrn[count][1] = re.getString("user_id");
                rtrn[count][2] = re.getString("product_id");
                count++;
            }
            Gson gson = new Gson();
            return_str = gson.toJson(rtrn);
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }
    
    public int remainingUsers(int offset,int limit) {
        int total_elems = 0;
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT COUNT(*) AS total FROM carsales");
            while(re.next()){
                total_elems = Integer.parseInt(re.getString("total"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        int already_done = offset+limit;
        int remaining = total_elems - already_done;
        if(remaining < 0) {
            remaining = 0;
        }
        return remaining;
    }
    
    public int remainingOrders(int offset,int limit) {
        int total_elems = 0;
        try {
            // TODO add your handling code here:
            Statement st;
            st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT COUNT(*) AS total FROM transactions");
            while(re.next()){
                total_elems = Integer.parseInt(re.getString("total"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        int already_done = offset+limit;
        int remaining = total_elems - already_done;
        if(remaining < 0) {
            remaining = 0;
        }
        return remaining;
    }
    
}
