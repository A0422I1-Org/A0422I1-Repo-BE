package com.example.demo.model.employee;
import com.example.demo.model.account.Account;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    public Employee() {
    }

    public Employee(String id, @NotNull String fullName, String image, @NotNull Boolean gender, @NotNull Date birthday, @NotNull String email, Boolean isActivated, @NotNull String phoneNumber, @NotNull String address, String cardId, @NotNull Position position, @NotNull Account account, Boolean isDelete) {
        this.id = id;
        this.fullName = fullName;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.isActivated = isActivated;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.position = position;
        this.account = account;
        this.isDelete = isDelete;
    }
    public Employee(@NotNull String fullName, String image, @NotNull Boolean gender, @NotNull Date birthday,
                    @NotNull String email, @NotNull Boolean isActivated, @NotNull String phoneNumber,
                    @NotNull String address, String cardId, @NotNull Position position, @NotNull Account account,
                    Boolean isDelete) {
        this.fullName = fullName;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.isActivated = isActivated;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.position = position;
        this.account = account;
        this.isDelete = isDelete;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivated() {
        return isActivated;
    }

    public void setActivated(Boolean activated) {
        isActivated = activated;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
