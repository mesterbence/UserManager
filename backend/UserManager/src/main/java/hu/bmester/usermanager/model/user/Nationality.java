package hu.bmester.usermanager.model.user;

import hu.bmester.usermanager.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "nationalities")
public class Nationality extends BaseEntity {

    @Column(name = "name")
    private String name;
}
