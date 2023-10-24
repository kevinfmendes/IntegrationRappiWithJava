package services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {
    @Value("${storeCode}")
    private String storeCode;

    @Value("${segmentCode}")
    private String segmentCode;

    @Value("${nameLoja}")
    private String nameLoja;

    public String getStoreCode() {
        return storeCode;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public String getNameLoja() {
        return nameLoja;
    }
}
