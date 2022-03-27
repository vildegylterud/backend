package backend.model;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public int getIdUser() {
        return idUser;
    }

    public User(){

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setIdUser(int id) {
        this.idUser = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}