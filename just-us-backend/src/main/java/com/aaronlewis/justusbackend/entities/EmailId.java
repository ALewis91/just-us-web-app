package com.aaronlewis.justusbackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="find_all_email_ids", query="select e from EmailId e")
@Table(name="email_id")
public class EmailId {
    @Id
    private String emailAddress;
    private Long id;

    public EmailId(String emailAddress, Long id) {
        this.emailAddress = emailAddress;
        this.id = id;
    }

    public EmailId() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmailId{" +
                "emailAddress='" + emailAddress + '\'' +
                ", id=" + id +
                '}';
    }
}
