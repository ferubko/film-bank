package com.svf.core.integration;

import java.io.Serializable;
import java.util.List;

/**
 * Created by stepanferubko
 */
public class ObjectsResponse<T extends Serializable> extends AbstractResponse {
    private List<T> values;

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
