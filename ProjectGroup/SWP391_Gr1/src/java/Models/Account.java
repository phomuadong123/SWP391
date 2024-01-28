/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Account {

    private int id;
    private String fullname, password, phone, role, mail;
    int cartId;

    public Account() {
    }

    public Account(int id, String fullname, String password, String phone, String role, String mail, int cartId) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.mail = mail;
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", fullname=" + fullname + ", password=" + password + ", phone=" + phone + ", role=" + role + ", mail=" + mail + ", cartId=" + cartId + '}';
    }
}
