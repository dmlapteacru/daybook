package com.personal.daybook.data;





import javax.persistence.*;

@Entity(name = "contact")

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user_name;
    private String name;
    private String tel_number;
    private String skype;

    public Contact() {
    }

    public Contact(String user_name, String name, String tel_number, String skype) {
        this.user_name = user_name;
        this.name = name;
        this.tel_number = tel_number;
        this.skype = skype;
    }

    public Contact(String user_name) {
        this.user_name = user_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
