package services;

import org.springframework.stereotype.Service;

@Service
public class StoreInfoService {
    
	private final StoreConfig storeConfig;
    

    public StoreInfoService(StoreConfig storeConfig) {
        this.storeConfig = storeConfig;
    }

    public String getStoreCode() {
        return storeConfig.getStoreCode();
    }

    public String getSegmentCode() {
        return storeConfig.getSegmentCode();
    }

    public String getNameLoja() {
        return storeConfig.getNameLoja();
    }
}
