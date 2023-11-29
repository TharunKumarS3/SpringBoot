package com.example.springdatajpa.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable //to connect with Student cLass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//now we have to map this db column name
@AttributeOverrides({
        @AttributeOverride(
                name = "guardianName", //property name
                column = @Column(name = "guardian_name")//column name in db
        ),
        @AttributeOverride(
                name = "guardianMail",
                column = @Column(name = "guardian_mail")
        ),
        @AttributeOverride(
                name = "guardianMobile",
                column = @Column(name = "guardian_mobile")
        )

        })

public class Gaurdian {

    private String guardianName;
    private String guardianMail;
    private String guardianMobile;





}
