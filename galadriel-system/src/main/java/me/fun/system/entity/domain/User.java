package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Data
@Table(name="me_user")
public class User {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    /**
     * 全局唯一
     */
    @Column(name="username", unique = true, nullable = false, length = 64)
    private String userName;
    private Integer status;
    private Integer source;

}
