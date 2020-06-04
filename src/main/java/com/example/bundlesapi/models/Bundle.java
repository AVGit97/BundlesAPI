package com.example.bundlesapi.models;

import com.example.bundlesapi.helpers.StringLengthConstraint;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class Bundle {
    @ApiModelProperty(notes = "Bundle unique id", hidden = true)
    private final UUID id;
    @NotNull
    @StringLengthConstraint
    @ApiModelProperty(notes = "Product name")
    private final String productName;
    @NotNull
    @ApiModelProperty(notes = "Bundle price")
    private final float price;
    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Product code")
    private final String productCode;
    @ApiModelProperty(notes = "Bundle expiration date")
    private final Date expirationDate;
    @NotNull
    @ApiModelProperty(notes = "Bundle availability date")
    private Date availabilityDate;
    @NotNull
    @ApiModelProperty(notes = "Bundle availability")
    private final boolean active;

    public Bundle(@JsonProperty("id") UUID id,
                  @JsonProperty("productName") String productName,
                  @JsonProperty("price") float price,
                  @JsonProperty("productCode") String productCode,
                  @JsonProperty("expirationDate") Date expirationDate,
                  @JsonProperty("availabilityDate") Date availabilityDate,
                  @JsonProperty("active") boolean active) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productCode = productCode;
        this.expirationDate = expirationDate;
        this.availabilityDate = availabilityDate;
        this.active = active;
    }

    public Bundle(UUID id, Bundle bundle) {
        this(
                id,
                bundle.productName,
                bundle.price,
                bundle.productCode,
                bundle.expirationDate,
                bundle.availabilityDate,
                bundle.active
        );
    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getAvailabilityDate() {
        return availabilityDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setAvailabilityDate(Date availabilityDate) {
        this.availabilityDate = availabilityDate;
    }
}
