package com.example.bundlesapi.controllers;

import com.example.bundlesapi.models.Bundle;
import com.example.bundlesapi.services.IBundlesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/bundles")
@Api(tags = "Bundles", description = "All Bundles operations")
public class BundlesController implements IBundlesController {

    private final IBundlesService bundleService;

    // Dependency Injection
    @Autowired
    public BundlesController(@Qualifier("bundlesService") IBundlesService bundleService) {
        this.bundleService = bundleService;
    }

    @Override
    @PostMapping
    @ApiOperation("Create a bundle")
    public void addBundle(@Valid @RequestBody @ApiParam("The bundle to be created") Bundle bundle) {
        bundleService.addBundle(bundle);
    }

    @Override
    @GetMapping
    @ApiOperation("Get all bundles (filtered by product code and name, if given)")
    public List<Bundle> getAllBundles(
            @RequestParam(value = "productCode", required = false) @ApiParam("Product code") String productCode,
            @RequestParam(value = "productName", required = false) @ApiParam("Product name") String productName) {
        return bundleService.getAllBundles(productCode, productName);
    }

    @Override
    @GetMapping(path = "/sorted")
    @ApiOperation("Get all bundles sorted by price (in ascending order by default)")
    public List<Bundle> getAllBundlesOrderedByPrice(
            @RequestParam(value = "desc", defaultValue = "false") @ApiParam("Descending order") boolean desc) {
        return bundleService.getAllBundlesOrderedByPrice(desc);
    }

    @Override
    @GetMapping(path = "{id}")
    @ApiOperation("Get a bundle by id")
    public Bundle getBundleById(@PathVariable("id") UUID id) {
        return bundleService.getBundleById(id)
                .orElse(null);
    }

    @Override
    @GetMapping(path = "/license")
    @ApiOperation("View Bundles API license")
    public String getLicense() {
        return "Bundles API License.";
    }

    @Override
    @GetMapping(path = "/terms")
    @ApiOperation("View Bundles API terms of service")
    public String getTerms() {
        return "Bundles API Terms of Service.";
    }

    @Override
    @DeleteMapping(path = "{id}")
    @ApiOperation("Delete a bundle")
    public void deleteBundleById(@PathVariable("id") UUID id) {
        bundleService.deleteBundleById(id);
    }

    @Override
    @PutMapping(path = "{id}")
    @ApiOperation("Update a bundle")
    public void updateBundle(@PathVariable("id") UUID id, @Valid @RequestBody @ApiParam("The bundle to be updated") Bundle bundle) {
        bundleService.updateBundleById(id, bundle);
    }

}
