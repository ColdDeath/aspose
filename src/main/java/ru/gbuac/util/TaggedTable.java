package ru.gbuac.util;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TaggedTable {
    private String tableName;
    private List<TableRow> rows;

    public TaggedTable(String tableName, List<TableRow> rows) {
        this.tableName = tableName;
        this.rows = rows;
    }

    public TaggedTable(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }
}
