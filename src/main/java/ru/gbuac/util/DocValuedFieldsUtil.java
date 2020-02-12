package ru.gbuac.util;

import ru.gbuac.model.DocValuedFields;
import ru.gbuac.model.FieldsRoles;
import ru.gbuac.to.DocFieldsTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocValuedFieldsUtil {

    public DocValuedFieldsUtil() {
    }

    public static List<DocFieldsTo> asTo(List<DocValuedFields> docValuedFields,
                                         List<String> curUserRoles, Map<Integer, FieldsRoles> fMap, boolean deny, boolean clearIds) {
        List<DocFieldsTo> docFieldsTos = new ArrayList<>();
        for (DocValuedFields d:docValuedFields) {
            docFieldsTos.add(new DocFieldsTo(d.getId(),
                    FieldUtil.asTo(d.getValuedField(), curUserRoles, (HashMap<Integer, FieldsRoles>) fMap, deny, clearIds),
                    d.getPosition()));
        }
        return docFieldsTos;
    }

}
