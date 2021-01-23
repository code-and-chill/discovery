package id.raidnav.products.eureka.domain.product.experience;

import id.raidnav.products.eureka.domain.product.CancellationPolicy;
import id.raidnav.products.eureka.domain.product.Price;
import id.raidnav.products.eureka.domain.user.Identity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Experience {

    private Long id;
    private ExperienceType experienceType;
    private String description;
    private List<String> imageUrls;
    private List<Price> prices;
    private List<CancellationPolicy> cancellationPolicies;
    private Date ticketValidFrom;
    private Date ticketValidTo;
    private Integer pax;
    private List<Identity> visitorDetails;
    private String termsAndConditions;
}

