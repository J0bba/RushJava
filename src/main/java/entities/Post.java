package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Column
    private String data;

    @Column
    private java.sql.Date date;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Blog> blog;
}
