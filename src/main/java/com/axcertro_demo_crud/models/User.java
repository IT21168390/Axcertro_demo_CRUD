package com.axcertro_demo_crud.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String first_name;
    String last_name;
    String email;
}