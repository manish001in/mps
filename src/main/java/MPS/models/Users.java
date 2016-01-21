package MPS.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

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


    @Column(name="CreatedDate", nullable=false)
    private Instant createdDate;

    @Column(name="ModifiedDate")
    private Instant modifiedDate;

    @ManyToOne
    @JoinColumn(name="Enterprises_id", referencedColumnName = "id")
    private Enterprises enterprise;


    public Users() { }

    public Users(long id) {
        this.id = id;
    }

    public Users(String name, String passcode, Instant createdDate, Instant modifiedDate) {
        this.name = name;
        this.passcode = passcode;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
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

    public Instant getCreatedDate() { return createdDate; }

    public void setCreatedDate() {
        this.createdDate = createdDate.now();
    }

    public Instant getModifiedDate() { return modifiedDate; }

    public void setModifiedDate() {
        this.modifiedDate = modifiedDate.now();
    }


}
