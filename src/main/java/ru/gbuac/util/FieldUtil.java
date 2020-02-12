package ru.gbuac.util;

import ru.gbuac.model.*;
import ru.gbuac.to.FieldTo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FieldUtil {

    private FieldUtil() {
    }

    public static FieldTo asTo(Field field, List<String> curUserRoles, HashMap<Integer, FieldsRoles> fMap, boolean deny) {
        List<FieldTo> childFields = new ArrayList<>();
        field.setChildField(field.getChildField()
                .stream().sorted(Comparator.comparing(f -> f.getPositionInGroup() != null ? f.getPositionInGroup() : 1)).collect(Collectors.toList()));
        for (Field childField : field.getChildField()) {
            childFields.add(asTo(childField, curUserRoles, fMap, deny));
        }
        FieldsRoles fieldsRoles = fMap.get(field.getId());
        boolean enabled = fieldsRoles != null && curUserRoles.contains(fieldsRoles.getRole().getAuthority());
        enabled = (enabled || curUserRoles.contains("ROLE_ADMIN")) && !deny;

        Integer catalog_id = getCatalogId(field.getCatalog());
        Integer parentCatalog_id = getParentCatalogId(field.getCatalog());

        return new FieldTo(null, field.getName(), childFields, field.getId(), field.getFieldType(),
                field.getPositionInGroup(), field.getMaxCount(), field.getLength(), parentCatalog_id, catalog_id,
                enabled, enabled && (fieldsRoles != null && fieldsRoles.getRequired()), field.getAppendix(), field.getTag());
    }

    private static Integer getCatalogId(Catalog catalog) {
        return catalog != null ? catalog.getId() : null;
    }

    private static Integer getParentCatalogId(Catalog catalog) {
        return catalog != null ? catalog.getParentCatalog() : null;
    }

    public static FieldTo asTo(ValuedField valuedField, List<String> curUserRoles, HashMap<Integer, FieldsRoles> fMap, boolean deny,
                               boolean clearIds) {
        List<FieldTo> childFields = new ArrayList<>();
        valuedField.setChildValuedField(valuedField.getChildValuedField()
                .stream().sorted(Comparator.comparing(f -> f.getField().getPositionInGroup() != null ? f.getField().getPositionInGroup() : 1)).collect(Collectors.toList()));
        for (ValuedField childField : valuedField.getChildValuedField()) {
            childFields.add(asTo(childField, curUserRoles, fMap, deny, clearIds));
        }
        Field field = valuedField.getField();
        FieldsRoles fieldsRoles = fMap.get(field.getId());
        boolean enabled = fieldsRoles != null && curUserRoles.contains(fieldsRoles.getRole().getAuthority());
        enabled = (enabled || curUserRoles.contains("ROLE_ADMIN")) && !deny;
        Integer catalog_id = getCatalogId(field.getCatalog());
        Integer parentCatalog_id = getParentCatalogId(field.getCatalog());

        FieldTo fieldTo = new FieldTo(clearIds ? null : valuedField.getId(), field.getName(), childFields,
                field.getId(), field.getFieldType(), field.getPositionInGroup(), field.getMaxCount(), field.getLength(),
                parentCatalog_id, catalog_id, enabled,
                enabled && (fieldsRoles != null && fieldsRoles.getRequired()), field.getAppendix(), field.getTag());

        switch (field.getFieldType()) {
            case TEXT:
            case TEXTAREA:
                fieldTo.setValueStr(valuedField.getValueStr());
                break;
            case NUMBER:
                fieldTo.setValueInt(valuedField.getValueInt());
                break;
            case DATE:
                fieldTo.setValueDate(valuedField.getValueDate());
                break;
            case TIME:
                fieldTo.setValueDate(valuedField.getValueTime());
                break;
            case DATETIME:
                fieldTo.setValueDate(valuedField.getValueDateTime());
                break;
            case CATALOG:
                if (valuedField.getCatalogElem() != null)
                    fieldTo.setValueInt(valuedField.getCatalogElem().getId());
                break;
            case CATALOG_ORGANIZATIONS:
            case CATALOG_USERS:
            case CATALOG_REGNUMBERS:
            case GROUP_CHECKBOX:
                if (valuedField.getValueInt() != null)
                    fieldTo.setValueInt(valuedField.getValueInt());
                break;
            case CATALOG_HTML_TABLES:
                if (valuedField.getValueInt() != null && valuedField.getValueStr() != null) {
                    fieldTo.setValueInt(valuedField.getValueInt());
                    fieldTo.setValueStr(valuedField.getValueStr());
                }
        }
        return fieldTo;
    }
}
