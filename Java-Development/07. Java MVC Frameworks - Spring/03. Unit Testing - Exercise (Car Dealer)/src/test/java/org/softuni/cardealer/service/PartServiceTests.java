package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Part;
import org.softuni.cardealer.domain.entities.Supplier;
import org.softuni.cardealer.domain.models.service.PartServiceModel;
import org.softuni.cardealer.domain.models.service.SupplierServiceModel;
import org.softuni.cardealer.repository.PartRepository;
import org.softuni.cardealer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PartServiceTests {

    @Autowired
    private PartRepository partRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;
    private Part part;
    private Supplier supplier;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
        supplier = new Supplier() {{
            setImporter(true);
            setName("Pesho");
        }};
        part = new Part() {{
            setName("Engine");
            setPrice(BigDecimal.valueOf(1300));
        }};
    }

    @Test
    public void partService_savePart_ShouldReturnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        Assert.assertEquals(part.getId(), savedPart.getId());
        Assert.assertEquals(part.getName(), savedPart.getName());
        Assert.assertEquals(part.getPrice(), savedPart.getPrice());
        Assert.assertEquals(part.getSupplier().getId(), savedPart.getSupplier().getId());
    }

    @Test(expected = Exception.class)
    public void partService_savePartWithNullValues_ShouldThrowException() {
        PartService service = new PartServiceImpl(partRepository, modelMapper);
        part.setName(null);
        part.setPrice(null);
        service.savePart(this.modelMapper.map(part, PartServiceModel.class));
    }

    @Test
    public void partService_editPart_ShouldReturnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        PartServiceModel changePart = new PartServiceModel() {{
            setName("Changed Engine");
            setPrice(BigDecimal.valueOf(1000));
            setSupplier(modelMapper.map(supplier, SupplierServiceModel.class));
            setId(part.getId());
        }};

        PartServiceModel editedPart = service.editPart(changePart);
        editedPart.setSupplier(modelMapper.map(supplier, SupplierServiceModel.class));

        Assert.assertEquals(editedPart.getId(), changePart.getId());
        Assert.assertEquals(editedPart.getName(), changePart.getName());
        Assert.assertEquals(editedPart.getPrice(), changePart.getPrice());
        Assert.assertEquals(editedPart.getSupplier().getId(), changePart.getSupplier().getId());
    }

    @Test(expected = Exception.class)
    public void partService_editPartWithoutId_ShouldThrowException() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        PartServiceModel changePart = new PartServiceModel() {{
            setName("Changed Engine");
            setPrice(BigDecimal.valueOf(1000));
            setSupplier(modelMapper.map(supplier, SupplierServiceModel.class));
            setId(null);
        }};

        service.editPart(changePart);
    }

    @Test
    public void partService_deletePart_ShouldReturnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        String deletePartId = part.getId();
        service.deletePart(deletePartId);

        Assert.assertEquals(this.partRepository.count(), 0);
    }

    @Test(expected = Exception.class)
    public void partService_deletePartWithFalseId_ShouldThrowException() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        service.deletePart("False id");
    }

    @Test
    public void partService_findPartById_ShouldReturnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        PartServiceModel foundPart = service.findPartById(savedPart.getId());

        Assert.assertEquals(foundPart.getId(), savedPart.getId());
        Assert.assertEquals(foundPart.getName(), savedPart.getName());
        Assert.assertEquals(foundPart.getPrice(), savedPart.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_findPartByFalseId_ShouldThrowException() {
        SupplierService supplierService = new SupplierServiceImpl(supplierRepository, modelMapper);
        SupplierServiceModel model =
                supplierService.saveSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        supplier.setId(model.getId());

        PartService service = new PartServiceImpl(partRepository, modelMapper);
        PartServiceModel savedPart =
                service.savePart(this.modelMapper.map(part, PartServiceModel.class));
        savedPart.setSupplier(this.modelMapper.map(supplier, SupplierServiceModel.class));
        part.setId(savedPart.getId());
        part.setSupplier(supplier);

        service.findPartById("False ID");
    }
}
