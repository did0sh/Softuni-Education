package panda.service;

import org.modelmapper.ModelMapper;
import panda.domain.entities.Package;
import panda.domain.entities.Status;
import panda.domain.models.service.PackageServiceModel;
import panda.repository.PackageRepository;

import javax.inject.Inject;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final ModelMapper modelMapper;

    @Inject
    public PackageServiceImpl(PackageRepository packageRepository, ModelMapper modelMapper) {
        this.packageRepository = packageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPackage(PackageServiceModel packageServiceModel) {
        Package aPackage = this.modelMapper.map(packageServiceModel, Package.class);
        aPackage.setStatus(Status.Pending);

        this.packageRepository.save(aPackage);
    }
}
