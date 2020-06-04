package com.example.bundlesapi.services;

import com.example.bundlesapi.dao.IBundlesDao;
import com.example.bundlesapi.models.Bundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
// Define a code name for autowiring (Dependency Injection)
@Repository("bundlesService")
public class BundlesService implements IBundlesService {

    private final IBundlesDao bundleDao;

    // Dependency Injection
    @Autowired
    public BundlesService(@Qualifier("memoryBundlesDao") IBundlesDao bundleDao) {
        this.bundleDao = bundleDao;
    }

    @Override
    public int addBundle(Bundle bundle) {
        return bundleDao.insertBundle(bundle);
    }

    @Override
    public List<Bundle> getAllBundles(String productCode, String productName) {
        List<Bundle> bundles = bundleDao.selectAllBundles();
        List<Bundle> filteredBundles;
        if (productCode != null) {
            filteredBundles = bundleDao.selectBundlesByProductCode(productCode);
            bundles = bundles.stream().filter(filteredBundles::contains).collect(Collectors.toList());
        }
        if (productName != null) {
            filteredBundles = bundleDao.selectBundlesByProductName(productName);
            bundles = bundles.stream().filter(filteredBundles::contains).collect(Collectors.toList());
        }
        return bundles;
    }

    @Override
    public List<Bundle> getAllBundlesOrderedByPrice(boolean desc) {
        return bundleDao.selectAllBundlesOrderedByPrice(desc);
    }

    @Override
    public Optional<Bundle> getBundleById(UUID id) {
        return bundleDao.selectBundleById(id);
    }

    @Override
    public int deleteBundleById(UUID id) {
        return bundleDao.deleteBundleById(id);
    }

    @Override
    public int updateBundleById(UUID id, Bundle bundle) {
        return bundleDao.updateBundle(id, bundle);
    }
}
