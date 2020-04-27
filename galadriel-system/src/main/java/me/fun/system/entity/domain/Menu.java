package me.fun.system.entity.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "me_menu")
public class Menu {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(length = 64)
    private String name;
    @Column(name = "sorted", length = 5)
    private int sorted;
    @Column(name = "parent_id", length = 64)
    private String parentId;
    @Column(name = "parent_name", length = 64)
    private String parentName;
    @Column(name = "menu_path")
    private String menuPath;
    private String redirect;
    private String icon;
    private byte hidden;
    private byte noCache;
    private byte affix;
    private String description;

}
