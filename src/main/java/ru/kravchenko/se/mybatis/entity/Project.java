package ru.kravchenko.se.mybatis.entity;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)

public class Project extends AbstractEntity implements Serializable {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

    @Nullable
    private String userId;

    @NotNull
    private StatusProjectTask status = StatusProjectTask.PLANNED;

    @Override
    public String toString() {
        @NotNull final String pattern = "dd.MM.yyyy";
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        @NotNull final String dateBering = simpleDateFormat.format(this.dateBegin);
        @NotNull final String dateEnd = simpleDateFormat.format(this.dateEnd);

        return "PROJECT NAME: \"" + this.name + "\" DESCRIPTION PROJECT: \"" + this.description + "\" "
                + "PROJECT ID: \"" + super.getId() + "\" DATE BEGIN: \"" + dateBering + "\" DATE END: \""
                + dateEnd + "\"" + " STATUS: " + this.status + " USER ID: " + this.userId;
    }

}
