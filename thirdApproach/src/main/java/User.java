
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johns
 */
@Entity
@Table(name="user_table")
public class User {
    @Id
    private String e_name;
    private String e_email;
    private Long e_mob;
    private String e_pass;

    public String getUsername() {
        return e_name;
    }
    public void setUsername(String username) {
        this.e_name = username;
    }

    public String getEmail() {
        return e_email;
    }

    public void setEmail(String email) {
        this.e_email = email;
    }

    public Long getMobile() {
        return e_mob;
    }

    public void setMobile(Long mobile) {
        this.e_mob = mobile;
    }

    public String getPass() {
        return e_pass;
    }

    public void setPass(String pass) {
        this.e_pass = pass;
    }

    
    
}
