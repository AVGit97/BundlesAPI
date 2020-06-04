package com.example.bundlesapi.services;

import com.example.bundlesapi.models.Bundle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBundlesService {
    int addBundle(Bundle bundle);

    List<Bundle> getAllBundles(String productCode, String productName);

    List<Bundle> getAllBundlesOrderedByPrice(boolean desc);

    Optional<Bundle> getBundleById(UUID id);

    int deleteBundleById(UUID id);

    int updateBundleById(UUID id, Bundle bundle);
}
