import javax.persistence.*;

@Entity
@Table(name = "Engineers", uniqueConstraints={@UniqueConstraint(columnNames = "Employ_ID"), @UniqueConstraint(columnNames = "Email")})
public class Engineer {
    @Id
//    @GeneratedValue()
    @Column(name = "Employ_ID", unique = true, nullable = false)
    private Integer employID;

    @Column(name = "Email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "First_Name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "Last_Name", length = 100)
    private String lastName;

    @Column(name = "Senior", nullable = false)
    private boolean isSenior;


    public Integer getEmployID() {
        return employID;
    }

    public void setEmployID(Integer employID) {
        this.employID = employID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "employID=" + employID +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isSenior=" + isSenior +
                '}';
    }

}
