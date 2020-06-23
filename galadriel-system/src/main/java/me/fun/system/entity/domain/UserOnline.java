package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "me_user_online")
public class UserOnline {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name="username", length = 64)
    private String userName;
    @Column(length = 64)
    private String ip;
    @Column(length = 64)
    private String browser;
    private String address;
    @Column(name = "login_time")
    private Timestamp loginTime;
    /**类型 true 登录，false 登出*/
    private boolean type;

}
