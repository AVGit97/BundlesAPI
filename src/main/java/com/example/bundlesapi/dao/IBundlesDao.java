package com.example.bundlesapi.dao;

import com.example.bundlesapi.models.Bundle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBundlesDao {

    int insertBundle(UUID id, Bundle bundle);

    default int insertBundle(Bundle bundle) {
        UUID id = UUID.randomUUID();
        return insertBundle(id, bundle);
    }

    List<Bundle> selectAllBundles();

    List<Bundle> selectBundlesByProductCode(String productCode);

    List<Bundle> selectBundlesByProductName(String productName);

    List<Bundle> selectAllBundlesOrderedByPrice(boolean desc);

    Optional<Bundle> selectBundleById(UUID id);

    int deleteBundleById(UUID id);

    int updateBundle(UUID id, Bundle bundleNew);

}
