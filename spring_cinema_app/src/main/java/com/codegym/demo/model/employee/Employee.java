package com.codegym.demo.model.employee;
import com.codegym.demo.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @Column(columnDefinition = ("varchar(45)"))
    private String id;
    @NotNull
    private String fullName;
    private String image;
    @NotNull
    private Boolean gender;
    @DateTimeFormat()
    @NotNull
    private Date birthday;
    @NotNull
    private String email;
    private Boolean isActivated;
    @NotNull
    @Column(columnDefinition = ("varchar(15)"))
    private String phoneNumber;
    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String address;
    @Column(columnDefinition = ("varchar(255)"))
    private String cardId;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @NotNull
    private Position position;
    @OneToOne
    @JoinColumn(name = "username")
    @NotNull
    private Account account;
//    @OneToMany(mappedBy = "employee")
//    @JsonBackReference
//    private Set<Ticket> tickets;

    private Boolean isDelete;



}
