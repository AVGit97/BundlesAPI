package com.example.bundlesapi.dao;

import com.example.bundlesapi.models.Bundle;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

// Define a code name for autowiring (Dependency Injection)
@Repository("memoryBundlesDao")
public class MemoryBundlesDao implements IBundlesDao {
    // This ArrayList represents our DB
    private static ArrayList<Bundle> DB = new ArrayList<>();

    @Override
    public int insertBundle(UUID id, Bundle bundle) {
        DB.add(new Bundle(id, bundle));
        return 1;
    }

    @Override
    public List<Bundle> selectAllBundles() {
        return DB;
    }

    @Override
    public List<Bundle> selectBundlesByProductCode(String productCode) {
        return DB
                .stream()
                .filter(bundle -> bundle.getProductCode().equals(productCode))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bundle> selectBundlesByProductName(String productName) {
        return DB
                .stream()
                .filter(bundle -> bundle.getProductName().equals(productName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bundle> selectAllBundlesOrderedByPrice(boolean desc) {
        List<Bundle> sorted = new ArrayList<>(DB);
        sorted.sort(desc ? Comparator.comparing(Bundle::getPrice).reversed() : Comparator.comparing(Bundle::getPrice));
        return sorted;
    }

    @Override
    public Optional<Bundle> selectBundleById(UUID id) {
        return DB
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBundleById(UUID id) {
        Optional<Bundle> bundle = selectBundleById(id);
        if (bundle.isEmpty()) {
            return 0;
        }
        DB.remove(bundle.get());
        return 1;
    }

    @Override
    public int updateBundle(UUID id, Bundle bundleNew) {
        return selectBundleById(id)
                .map(b -> {
                    int index = DB.indexOf(b);
                    if (index >= 0) {
                        DB.set(index, new Bundle(id, bundleNew));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
