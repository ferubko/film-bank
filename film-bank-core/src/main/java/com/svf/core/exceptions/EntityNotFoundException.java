package com.svf.core.exceptions;

/**
 * Created by stepanferubko
 */
public class EntityNotFoundException extends Exception {
    private Object id;
    private Class type;

    public EntityNotFoundException(Object id, Class type) {
        super(String.format("There is no entity <%s> with id <%s>", type.getSimpleName(), id));
        this.id = id;
        this.type = type;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
