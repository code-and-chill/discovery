package id.raidnav.products.eureka.domain.user;

import id.raidnav.products.eureka.domain.payment.PaymentOption;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Account implements Serializable {
  @Id
  private String username;
  private AccountType type;
  private Visibility visibility;
  private String photoUrl;
  private Contact contact;
  private Identity identity;
  private UserSecurity userSecurity;
  private ContentPreference contentPreference;
  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  private Map<String, Boolean> pushNotifications;
  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  private Map<String, Boolean> newsletterSubscriptions;
  @ElementCollection
  private List<Identity> relatives;
  private Loyalty loyalty;
  private Long rewards;
  @OneToMany
  private List<PaymentOption> paymentOptions;
  private Date joinedDate;
}
