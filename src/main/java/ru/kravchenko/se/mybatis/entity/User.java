package ru.kravchenko.se.mybatis.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class User extends AbstractEntity {

    @Nullable
    private String login;

    @Nullable
    private String passwordHash;

    @Nullable
    private Status role = Status.USER;

    @Nullable
    boolean locked;

    @Override
    public String toString() {
        return "login: " + login + " password: " + passwordHash + " userStatus: " + role +
                " id: " + super.getId();
    }

}
