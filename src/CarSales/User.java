/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSales;

/**
 *
 * @author aayush
 */
public class User {
    private String email;
    private String password;
    private String name;
    private String phone;
    public User() {
    }
    
    public void setLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public void setRegister(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPhone() {
        return this.phone;
    }
}
