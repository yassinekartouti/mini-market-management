package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_role_id")
    private Long id;
    @Column(nullable = false,length = 45)
    private String name;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Role() {

    }

    public Role(Long id) {

        this.id = id;
    }
    public Role(String name) {

        this.name = name;
    }
    public Role(Long id, String name) {

        this.id = id;
        this.name = name;
    }


}
