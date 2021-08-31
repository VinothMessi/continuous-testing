package com.continuoustesting.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public
class Users {
    @Id
    private Integer id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String fromCountry;
    private String toCountry;
    private String birthMonth;
    private String birthDay;
    private String birthYear;
    private String areaCode;
    private String phoneNumber;
}