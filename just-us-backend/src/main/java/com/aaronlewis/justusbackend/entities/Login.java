package com.aaronlewis.justusbackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="login")
@NamedQuery(name="find_all_logins", query="select l from Login l")
public class Login {

    @Id
    private Long id;
    private String emailAddress;
    private String password;
    private Date firstLogin;
    private Date lastLogin;


    public Login(Long id, String emailAddress, String password, Date firstLogin, Date lastLogin) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstLogin = firstLogin;
        this.lastLogin = lastLogin;
    }

    public Login() {}

    public Long getId() {
        return id;
    }

/*    public void setId(Long id) {
        this.id = id;
    }*/

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", firstLogin=" + firstLogin +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
