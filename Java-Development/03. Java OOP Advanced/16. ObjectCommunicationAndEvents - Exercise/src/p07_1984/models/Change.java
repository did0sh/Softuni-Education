package p07_1984.models;

public class Change {
    private String entity;
    private String id;
    private String fieldName;
    private String fieldType;
    private Object oldValue;
    private Object newValue;

    public Change(String entity, String id, String fieldName, String fieldType, Object oldValue, Object newValue) {
        this.entity = entity;
        this.id = id;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    @Override
    public String toString() {
        return String.format("--%s(ID:%s) changed %s(%s) from %s to %s"
                , this.entity, this.id, this.fieldName, this.fieldType, this.oldValue, this.newValue);
    }
}
