package id.raidnav.products.eureka.domain.product.experience;

import id.raidnav.products.eureka.domain.user.Identity;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Experience implements Serializable {
  @Id
  private Long id;
  private ExperienceType experienceType;
  private String description;
  @ElementCollection
  private List<String> imageUrls;
  private Date ticketValidFrom;
  private Date ticketValidTo;
  private Integer pax;
  @ElementCollection
  private List<Identity> visitorDetails;
}

