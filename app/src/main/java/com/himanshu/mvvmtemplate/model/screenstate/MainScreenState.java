package com.himanshu.mvvmtemplate.model.screenstate;

import java.io.Serializable;

/**
 * @author : Himanshu Sachdeva
 * @created : 04-Jun-2020
 * @email : himanshu.sachdeva1994@gmail.com
 */
public class MainScreenState implements Serializable {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
