package com.example.bundlesapi.controllers;

import com.example.bundlesapi.models.Bundle;

import java.util.List;
import java.util.UUID;

public interface IBundlesController {
    void addBundle(Bundle bundle);

    List<Bundle> getAllBundles(String productCode, String productName);

    List<Bundle> getAllBundlesOrderedByPrice(boolean desc);

    Bundle getBundleById(UUID id);

    String getLicense();

    String getTerms();

    void deleteBundleById(UUID id);

    void updateBundle(UUID id, Bundle bundle);
}
