package com.sc.dmh.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Place implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.latitude
     *
     * @mbggenerated
     */
    private BigDecimal latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.longitude
     *
     * @mbggenerated
     */
    private BigDecimal longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.place_name
     *
     * @mbggenerated
     */
    private String placeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.latitude_east
     *
     * @mbggenerated
     */
    private BigDecimal latitudeEast;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.longitude_east
     *
     * @mbggenerated
     */
    private BigDecimal longitudeEast;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.latitude_west
     *
     * @mbggenerated
     */
    private BigDecimal latitudeWest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column place.longitude_west
     *
     * @mbggenerated
     */
    private BigDecimal longitudeWest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table place
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.id
     *
     * @return the value of place.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.id
     *
     * @param id the value for place.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.latitude
     *
     * @return the value of place.latitude
     *
     * @mbggenerated
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.latitude
     *
     * @param latitude the value for place.latitude
     *
     * @mbggenerated
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.longitude
     *
     * @return the value of place.longitude
     *
     * @mbggenerated
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.longitude
     *
     * @param longitude the value for place.longitude
     *
     * @mbggenerated
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.place_name
     *
     * @return the value of place.place_name
     *
     * @mbggenerated
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.place_name
     *
     * @param placeName the value for place.place_name
     *
     * @mbggenerated
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName == null ? null : placeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.latitude_east
     *
     * @return the value of place.latitude_east
     *
     * @mbggenerated
     */
    public BigDecimal getLatitudeEast() {
        return latitudeEast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.latitude_east
     *
     * @param latitudeEast the value for place.latitude_east
     *
     * @mbggenerated
     */
    public void setLatitudeEast(BigDecimal latitudeEast) {
        this.latitudeEast = latitudeEast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.longitude_east
     *
     * @return the value of place.longitude_east
     *
     * @mbggenerated
     */
    public BigDecimal getLongitudeEast() {
        return longitudeEast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.longitude_east
     *
     * @param longitudeEast the value for place.longitude_east
     *
     * @mbggenerated
     */
    public void setLongitudeEast(BigDecimal longitudeEast) {
        this.longitudeEast = longitudeEast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.latitude_west
     *
     * @return the value of place.latitude_west
     *
     * @mbggenerated
     */
    public BigDecimal getLatitudeWest() {
        return latitudeWest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.latitude_west
     *
     * @param latitudeWest the value for place.latitude_west
     *
     * @mbggenerated
     */
    public void setLatitudeWest(BigDecimal latitudeWest) {
        this.latitudeWest = latitudeWest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column place.longitude_west
     *
     * @return the value of place.longitude_west
     *
     * @mbggenerated
     */
    public BigDecimal getLongitudeWest() {
        return longitudeWest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column place.longitude_west
     *
     * @param longitudeWest the value for place.longitude_west
     *
     * @mbggenerated
     */
    public void setLongitudeWest(BigDecimal longitudeWest) {
        this.longitudeWest = longitudeWest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Place other = (Place) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getPlaceName() == null ? other.getPlaceName() == null : this.getPlaceName().equals(other.getPlaceName()))
            && (this.getLatitudeEast() == null ? other.getLatitudeEast() == null : this.getLatitudeEast().equals(other.getLatitudeEast()))
            && (this.getLongitudeEast() == null ? other.getLongitudeEast() == null : this.getLongitudeEast().equals(other.getLongitudeEast()))
            && (this.getLatitudeWest() == null ? other.getLatitudeWest() == null : this.getLatitudeWest().equals(other.getLatitudeWest()))
            && (this.getLongitudeWest() == null ? other.getLongitudeWest() == null : this.getLongitudeWest().equals(other.getLongitudeWest()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getPlaceName() == null) ? 0 : getPlaceName().hashCode());
        result = prime * result + ((getLatitudeEast() == null) ? 0 : getLatitudeEast().hashCode());
        result = prime * result + ((getLongitudeEast() == null) ? 0 : getLongitudeEast().hashCode());
        result = prime * result + ((getLatitudeWest() == null) ? 0 : getLatitudeWest().hashCode());
        result = prime * result + ((getLongitudeWest() == null) ? 0 : getLongitudeWest().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", placeName=").append(placeName);
        sb.append(", latitudeEast=").append(latitudeEast);
        sb.append(", longitudeEast=").append(longitudeEast);
        sb.append(", latitudeWest=").append(latitudeWest);
        sb.append(", longitudeWest=").append(longitudeWest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}