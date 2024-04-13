package com.mongodb.company.models;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class CompanyEntity {

    private ObjectId id;
    private String name;
    private String headquarters;
    private Date created;

    public CompanyEntity() {
    }

    public CompanyEntity(ObjectId id, String name, String headquarters, Date created) {
        this.id = id;
        this.name = name;
        this.headquarters = headquarters;
        this.created = created;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (headquarters != null ? headquarters.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(headquarters, that.headquarters)) return false;
        return Objects.equals(created, that.created);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" + "id=" + id + ", name='" + name + '\'' + ", headquarters='" + headquarters + '\'' + ", createdAt=" + created + '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
