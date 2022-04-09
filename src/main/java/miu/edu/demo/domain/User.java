package miu.edu.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@NamedQuery(name="name", query="select u from User u where u.post > :count")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    private List<Post> post;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "principle")
    private List<Logger> logger;

    public static User getLoggedInUser(){
        return new User(1,"logged in user",null,null);
    }
}
