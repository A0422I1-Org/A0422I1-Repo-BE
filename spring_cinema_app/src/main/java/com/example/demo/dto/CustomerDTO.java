package com.example.demo.dto;

import com.example.demo.model.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String fullName;
    private Boolean gender;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String cardId;
    private String username;
    private String password;

//    private String id;
//    private String fullName;
    private double point;
    private Long ticket;
    private double money;
//    private String email;
    private String phone;
//    private String address;
    private String idCard;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String fullName, Boolean gender, Date birthday, String email, String phoneNumber, String address, String cardId, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.username = username;
        this.password = password;
    }
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.fullName = customer.getFullName();
        this.point = customer.getGetListPoint()
                .stream()
                .map(item -> item.getPoint())
                .collect(Collectors.summingDouble(Integer::doubleValue));
        this.ticket =  customer.getGetTicketList()
                .stream()
                .map(item -> item.getId()).count();
        this.money = customer.getGetTicketList()
                .stream()
                .map(item -> item.getPrice())
                .collect(Collectors.summingDouble(Double::doubleValue));

        this.email = customer.getEmail();
        this.phone = customer.getPhoneNumber();
        this.address = customer.getAddress();
        this.idCard = customer.getCardId();

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }


}
