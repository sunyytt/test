package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "me_role_power")
public class RolePower {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "role_id",length = 64)
    private String roleId;
    @Column(name = "power_id",length = 64)
    private String powerId;


}
