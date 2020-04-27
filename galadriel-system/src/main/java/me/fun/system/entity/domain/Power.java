package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "me_power")
public class Power {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private int type;
    @Column(length = 64)
    private String name;
    private String description;


}
