package MPS.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Entity
@Table(name="Users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Passcode")
    private String passcode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedDate", nullable=false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifiedDate")
    private Date modifiedDate;

    @ManyToOne(/*cascade = {CascadeType.REMOVE, CascadeType.REFRESH},*/ fetch = FetchType.LAZY)
    @JoinColumn(name="Enterprises_id", referencedColumnName = "id")
    private Enterprises enterprise;
    public Enterprises getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprises enterprise) {
        this.enterprise = enterprise;
    }

    public Users() { }

    public Users(Long id) {
        this.id = id;
    }

    public Users(String name, String passcode) {
        this.name = name;
        this.passcode = passcode;
        this.setCreatedDate();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String value) {
        this.passcode = value;
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


}
