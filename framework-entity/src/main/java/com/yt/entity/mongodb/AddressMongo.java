package com.yt.entity.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.PrePersist;


/**
 * Created by user on 2015/9/16.
 */
@Document(collection ="address_mongo")
public class AddressMongo {

    @Id
    @Field(value ="address_id")
    private int addressId;
    @Field(value ="address_name")
    private String addressName;
    @Field(value ="mobile_yt")
    private String mobile;
    @Field(value ="area")
    private String area;







    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
