package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface representing the 'IAccess' link in the component diagram.
 */
public interface IAccess {
    List<SharePrice> accessExternalData(String symbol, LocalDate start, LocalDate end);
}