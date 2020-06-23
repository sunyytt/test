package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "me_auth")
public class Auth {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "user_id", length = 64)
    private String userId;
    @Column(name = "login_type")
    private Integer loginType;
    @Column(name = "login_no", length = 64)
    private String loginNo;
    @Column(name = "login_pwd", length = 64)
    private String loginPwd;

}
