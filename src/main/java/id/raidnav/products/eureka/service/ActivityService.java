package id.raidnav.products.eureka.service;

public interface ActivityService {

    void markAsBooked();
    void markAsVerified();
    void generateSupportingFiles();
    void cancelOrder();
}
