package ru.gbuac.util;

import ru.gbuac.model.DocTypeFields;
import ru.gbuac.model.DocValuedFields;
import ru.gbuac.model.FieldsRoles;
import ru.gbuac.to.DocFieldsTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocTypeFieldsUtil {

    public DocTypeFieldsUtil() {
    }

    public static List<DocFieldsTo> asTo(List<DocTypeFields> docTypeFields, List<String> curUserRoles, Map<Integer, FieldsRoles> fMap, boolean deny) {
        List<DocFieldsTo> docFieldsTos = new ArrayList<>();
        for (DocTypeFields d:docTypeFields) {
            docFieldsTos.add(new DocFieldsTo(d.getId(), FieldUtil.asTo(d.getField(), curUserRoles, (HashMap<Integer, FieldsRoles>) fMap, false),
                    d.getPosition()));

        }
        return docFieldsTos;
    }
}
