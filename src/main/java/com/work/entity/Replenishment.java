package com.work.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "replenishment")
public class Replenishment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private Date date;
    @NonNull
    private double sum;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "replenishment_user",
            joinColumns = { @JoinColumn( name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "replenishment_id") })
    private List<User> users;

}
