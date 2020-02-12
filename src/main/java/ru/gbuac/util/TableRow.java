package ru.gbuac.util;

import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class TableRow {
    private Map<String, String> cellsTags;

    public TableRow(Map<String, String> cellsTags) {
        this.cellsTags = cellsTags;
    }

    public Map<String, String> getCellsTags() {
        return cellsTags;
    }

    public void setCellsTags(Map<String, String> cellsTags) {
        this.cellsTags = cellsTags;
    }
}
