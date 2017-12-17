package com.svf.core.dto;

import java.util.List;
import java.util.Objects;

/**
 * Created by stepanferubko
 */
public class StaticResourceContent {
    private List<String> content;
    private String name;
    private String version;

    public StaticResourceContent(List<String> content, String name, String version) {
        this.content = content;
        this.name = name;
        this.version = version;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticResourceContent that = (StaticResourceContent) o;
        return Objects.equals(content, that.content) &&
                Objects.equals(name, that.name) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, name, version);
    }

    @Override
    public String toString() {
        return "StaticResourceContent{" +
                "content=" + content +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

}
