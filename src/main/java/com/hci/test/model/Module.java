package com.hci.test.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "Module Name cannot be empty")
    @NotNull(message = "Module Name cannot be null")
    @Column(name = "MODULE_NAME")
    private String moduleName;
}
