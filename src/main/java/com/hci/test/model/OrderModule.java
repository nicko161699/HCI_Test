package com.hci.test.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(OrderModule.class)
@Table(name = "ORDER_MODULE")
public class OrderModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    private Integer userId;

    @Id
    @Column(name = "MODULE_ID")
    private Integer moduleId;

    @Column(name = "MODULE_ORDER")
    private Integer moduleOrder;
}
