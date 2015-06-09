package com.marinamelodrama.website.api;

/**
 * Created by Jacob on 5/16/15.
 */

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class EmailRecord {
    @Id
    Long id;

    @Index
    String email;

    public EmailRecord() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
