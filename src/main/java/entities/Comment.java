package entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pimeko on 10/07/2017.
 */
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    public User user;

    @ManyToOne(cascade = CascadeType.ALL)
    public Post post;

    @Column
    public String data;

    @Column
    public java.sql.Date date;
}
