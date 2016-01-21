package MPS.models;


import javax.persistence.*;
import java.time.Instant;
import java.util.List;



/**
 * Created by manish.rastogi on 20/1/16.
 */
@Entity
@Table(name="Appliance")
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="ApplianceName")
    private String AppName;

    @Column(name="Parameter1")
    private String param1;

    @Column(name="Parameter2")
    private String param2;

    @Column(name="Parameter3")
    private String param3;

    @Column(name="CreatedDate", nullable=false)
    private Instant createdDate;

    @Column(name="ModifiedDate")
    private Instant modifiedDate;

    @ManyToOne
    @JoinColumn(name="Enterprises_id", referencedColumnName = "id")
    private Enterprises enterprise;


    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public Appliance() { }

    public Appliance(long id) {
        this.id = id;
    }

    public Appliance(String AppName, String param1, String param2, String param3, Instant createdDate, Instant modifiedDate) {
        this.AppName = AppName;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String value) {
        this.AppName = value;
    }

    public String getparam1() {
        return param1;
    }

    public void setparam1(String value) {
        this.param1 = value;
    }

    public String getparam2() {
        return param2;
    }

    public void setparam2(String value) {
        this.param2 = value;
    }

    public String getparam3() {
        return param3;
    }

    public void setparam3(String value) {
        this.param3 = value;
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
/*

@Entity
@Table(name="first_child_table")
public class FirstChild {
    @Id
    @Column(name="ID", nullable=false, unique=true)
// Require Generator config
    private Long id;

    @Column(name="FIRST_CHILD_NAME", nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="ID")
    private Parent parent;
}

@Entity
@Table(name="second_child_table")
public class SecondChild {
    @Id
    @Column(name="ID", nullable=false, unique=true)
// Require Generator config
    private Long id;

    @Column(name="SECOND_CHILD_NAME", nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="ID")
    private Parent parent;


}
*/
