package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
