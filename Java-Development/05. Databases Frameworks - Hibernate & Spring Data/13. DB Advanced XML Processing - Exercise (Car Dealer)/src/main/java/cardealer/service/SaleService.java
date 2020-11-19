package cardealer.service;

import cardealer.domain.dto.view.xml.SaleViewDto;

public interface SaleService {

    void seedSales();

    SaleViewDto getSales();
}
