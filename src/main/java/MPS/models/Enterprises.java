package MPS.models;

import org.springframework.data.jpa.repository.*;

import javax.persistence.*;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * Created by manish.rastogi on 20/1/16.
 */
@Entity
@Table(name="Enterprises")
public class Enterprises implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private long id;

    @Column(name="EntpName")
    private String entpName;

    @Column(name="ContactPerson")
    private String contactPerson;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedDate", nullable=false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifiedDate")
    private Date modifiedDate;

    @OneToMany(mappedBy = "enterprise" ,orphanRemoval=true, cascade = {CascadeType.ALL})
    public List<Appliance> appliances = new ArrayList<>();

    @OneToMany(mappedBy = "enterprise" ,orphanRemoval=true, cascade = {CascadeType.ALL})
    public List<Users> users = new ArrayList<>();

    public Enterprises() { }

    public Enterprises(long id) {
        this.id = id;
    }

    public Enterprises(String entpName, String contactPerson) {
        this.entpName = entpName;
        this.contactPerson = contactPerson;
        this.setCreatedDate();
    }

    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String value) {
        this.entpName = value;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    public Date getCreatedDate() { return createdDate; }

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    public Date getModifiedDate() { return modifiedDate; }

    @PreUpdate
    public void setModifiedDate() {
        this.modifiedDate = new Date();
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

}


