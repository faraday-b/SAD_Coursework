package com.example.shareapp.logic;

import com.example.shareapp.model.SharePrice;
import com.example.shareapp.service.ShareService;
import java.util.ArrayList;
import java.util.List;

public class ShareServiceImpl implements ShareService {

    @Override
    public List<SharePrice> getSharePrices(String ticker) {
        // Dummy implementation for now.
        return new ArrayList<>();
    }
    
}
