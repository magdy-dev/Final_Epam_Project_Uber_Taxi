package com.magdy.taxiwebappliction.entity;

import java.util.Objects;

public class Owner {
    private long id ;
    private String userName;
    private String password;

    public Owner() {
    }

    public Owner(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id && Objects.equals(userName, owner.userName) && Objects.equals(password, owner.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
