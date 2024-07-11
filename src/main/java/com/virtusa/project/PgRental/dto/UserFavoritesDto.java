package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavoritesDto {
    private Long favoriteId;
    private Long userId;
    private Long propertyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getFavoriteId() {
        return this.favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }
}
