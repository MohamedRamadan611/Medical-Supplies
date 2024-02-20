package com.MedicalSuppliesSystem.MedicalSupplies.enums;

public enum CrudOperationsEnum {
    CREATE(1),
    EDIT(2),
    DELETE(3),
    FIND(4),
    FIND_ALL(5);

    private final int crudTypeId;

    private CrudOperationsEnum(int crudTypeId) {
        this.crudTypeId = crudTypeId;
    }

    public int getCrudTypeId() {
        return this.crudTypeId;
    }
}
