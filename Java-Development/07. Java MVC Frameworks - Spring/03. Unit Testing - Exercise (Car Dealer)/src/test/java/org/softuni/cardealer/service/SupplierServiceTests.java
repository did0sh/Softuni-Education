package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Customer;
import org.softuni.cardealer.domain.entities.Supplier;
import org.softuni.cardealer.domain.models.service.CustomerServiceModel;
import org.softuni.cardealer.domain.models.service.SupplierServiceModel;
import org.softuni.cardealer.repository.CustomerRepository;
import org.softuni.cardealer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SupplierServiceTests {

    @Autowired
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;
    private Supplier supplier;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
        supplier = new Supplier() {{
            setImporter(true);
            setName("Stamat");
        }};
    }

    @Test
    public void supplierService_saveSupplier_ShouldReturnCorrect() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        Assert.assertEquals(supplier.getId(), savedSupplier.getId());
        Assert.assertEquals(supplier.isImporter(), savedSupplier.isImporter());
        Assert.assertEquals(supplier.getName(), savedSupplier.getName());
    }

    @Test(expected = Exception.class)
    public void supplierService_saveSupplierWithNullValues_ShouldThrowException() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        supplier.setName(null);
        service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
    }

    @Test
    public void supplierService_editSupplier_ShouldReturnCorrect() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        SupplierServiceModel model = new SupplierServiceModel() {{
            setId(supplier.getId());
            setName("Edit Name");
            setImporter(false);
        }};

        SupplierServiceModel changedSupplier = service.editSupplier(model);

        Assert.assertEquals(changedSupplier.getId(), model.getId());
        Assert.assertEquals(changedSupplier.isImporter(), model.isImporter());
        Assert.assertEquals(changedSupplier.getName(), model.getName());
    }

    @Test(expected = Exception.class)
    public void supplierService_editSupplierWithNullValues_ShouldThrowException() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        SupplierServiceModel model = new SupplierServiceModel() {{
            setId(supplier.getId());
            setName(null);
            setImporter(false);
        }};

        service.editSupplier(model);
    }

    @Test
    public void supplierService_deleteSupplier_ShouldReturnCorrect() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        String supplierToDeleteID = supplier.getId();

        service.deleteSupplier(supplierToDeleteID);

        Assert.assertEquals(this.supplierRepository.count(), 0);
    }

    @Test(expected = Exception.class)
    public void supplierService_deleteSupplierWithFalseID_ShouldThrowException() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        service.deleteSupplier("FALSE ID");
    }

    @Test
    public void supplierService_findSupplierById_ShouldReturnCorrect() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        String supplierToDeleteID = supplier.getId();

        SupplierServiceModel foundSupplier = service.findSupplierById(supplierToDeleteID);

        Assert.assertEquals(foundSupplier.getId(), supplier.getId());
        Assert.assertEquals(foundSupplier.isImporter(), supplier.isImporter());
        Assert.assertEquals(foundSupplier.getName(), supplier.getName());
    }

    @Test(expected = Exception.class)
    public void supplierService_findSupplierByFalseId_ShouldReturnCorrect() {
        SupplierService service = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel savedSupplier =
                service.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(savedSupplier.getId());

        service.findSupplierById("False ID");
    }
}
