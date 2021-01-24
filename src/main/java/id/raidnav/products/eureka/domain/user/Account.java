package id.raidnav.products.eureka.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@DiscriminatorValue("user")
@Getter
@Entity
public class Account {
    @Id
    private String username;
    private String email;
    private String password;
    @JsonIgnore
    @OneToMany
    private List<AccountProvider> providers;
}
