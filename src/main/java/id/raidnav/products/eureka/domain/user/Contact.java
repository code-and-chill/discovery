package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Contact implements Serializable {
  private Long id;
  private String fullName;
  private String gender;
  private String cityOfResidence;
  private List<EmailSettings> emailSettings;
  private List<String> phoneNumbers;
  private List<User> linkedUsers;
}
