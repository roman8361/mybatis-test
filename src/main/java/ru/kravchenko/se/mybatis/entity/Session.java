package ru.kravchenko.se.mybatis.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class Session extends AbstractEntity {

    @Nullable
    private String userId;

    @Nullable
    private String signature;

    @Nullable
    private Date timestamp;

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId + '\'' +
                ", signature='" + signature + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
