package id.raidnav.products.eureka.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.raidnav.products.eureka.domain.booking.BookingType;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.domain.product.vehicle.Vehicle;
import lombok.Data;

import javax.inject.Inject;
import java.util.List;

@Data
public class ProductSpecValidator {

  @Inject
  private ObjectMapper objectMapper;

  public boolean hasMatchingType(BookingType type, String data) {
    boolean isMatched = false;
    switch (type) {
      case VEHICLE: isMatched = isVehicle(data); break;
      case ACCOMMODATION: isMatched = isAccommodation(data); break;
      case EXPERIENCE: isMatched = isExperience(data); break;
      default: break;
    }
    return isMatched;
  }

  private boolean isVehicle(String vehicles) {
    try {
      objectMapper.readValue(vehicles, Vehicle.class);
      return true;
    } catch (JsonProcessingException ignored) {
    }
    try {
      objectMapper.readValue(vehicles, new TypeReference<List<Vehicle>>() {
      });
      return true;
    } catch (JsonProcessingException ignored) {
    }
    return false;
  }

  private boolean isAccommodation(String accommodations) {
    try {
      objectMapper.readValue(accommodations, Accommodation.class);
      return true;
    } catch (JsonProcessingException ignored) {
    }
    try {
      objectMapper.readValue(accommodations, new TypeReference<List<Accommodation>>() {
      });
      return true;
    } catch (JsonProcessingException ignored) {
    }
    return false;
  }

  private boolean isExperience(String experiences) {
    try {
      objectMapper.readValue(experiences, Experience.class);
      return true;
    } catch (JsonProcessingException ignored) {
    }
    try {
      objectMapper.readValue(experiences, new TypeReference<List<Experience>>() {
      });
      return true;
    } catch (JsonProcessingException ignored) {
    }
    return false;
  }

}
