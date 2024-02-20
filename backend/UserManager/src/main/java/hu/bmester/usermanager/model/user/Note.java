package hu.bmester.usermanager.model.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.bmester.usermanager.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "notes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "note")
    private String note;
}
