package MPS.models;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Entity
@Table(name="Enterprises")
public class Enterprises implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="EntpName")
    private String entpName;

    @Column(name="ContactPerson")
    private String contactPerson;

    @Column(name="CreatedDate", nullable=false)
    private Instant createdDate;

    @Column(name="ModifiedDate")
    private Instant modifiedDate;

    @OneToMany(orphanRemoval=true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="candidate_id", nullable=false)

    public List<Appliance> appliances = new ArrayList<>();

    @OneToMany(orphanRemoval=true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="candidate_id", nullable=false)
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

    public Instant getCreatedDate() { return createdDate; }

    public void setCreatedDate() {
        this.createdDate = createdDate.now();
    }

    public Instant getModifiedDate() { return modifiedDate; }

    public void setModifiedDate() {
        this.modifiedDate = modifiedDate.now();
    }






/*
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidacy_id", nullable = false)
    @Getter
    @Setter
    private List<FirstChild> firstChild = new ArrayList<>();


    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidacy_id", nullable = false)
    @Getter
    @Setter
    private List<SecondChild> secondChild = new ArrayList<>();*/
}
