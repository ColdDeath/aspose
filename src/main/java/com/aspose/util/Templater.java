package com.aspose.util;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Templater {

    private static int getPageCount(XWPFDocument doc) throws IOException {
        ByteArrayOutputStream byteArrayOutputStreamTemp = new ByteArrayOutputStream();
        doc.write(byteArrayOutputStreamTemp);
        PDDocument pdfTemp = PDDocument.load(getPdfBytes(new ByteArrayInputStream(byteArrayOutputStreamTemp.toByteArray())).toByteArray());
        return pdfTemp.getNumberOfPages();
    }

    private static List<IfStatement> getIfStatements(String text) {
        if (text == null) {
            return null;
        }
        final String regex = "(IF\\{(.*?|.*[\\s\\S]*?)\\}THEN\\{(.*?|.*[\\s\\S]*?)\\}(ELSE\\{(.*?|.*[\\s\\S]*?)\\})?)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);
        List<IfStatement> ifStatements = new ArrayList<>();
        while (matcher.find()) {
            ifStatements.add(new IfStatement(matcher.group(2) != null ? matcher.group(2) : "",
                    matcher.group(3) != null ? matcher.group(3) : "",
                    matcher.group(5) != null ? matcher.group(5) : "",
                    matcher.group(1)));
        }
        return ifStatements;
    }

    public static void deleteParagraph(XWPFParagraph p) {
        XWPFDocument doc = p.getDocument();
        int pPos = doc.getPosOfParagraph(p);
        if (pPos == -1) {
            changeText(p, "");
        } else {
            doc.removeBodyElement(pPos);
        }
    }

    private static class MyXWPFHtmlDocument extends POIXMLDocumentPart {

        private String html;
        private String id;

        private MyXWPFHtmlDocument(PackagePart part, String id) throws Exception {
            super(part);
            this.html = "<!DOCTYPE html><html><head><style></style><title>HTML import</title></head><body></body>";
            this.id = id;
        }

        private String getId() {
            return id;
        }

        private String getHtml() {
            return html;
        }

        private void setHtml(String html) {
            this.html = html;
        }

        @Override
        protected void commit() throws IOException {
            PackagePart part = getPackagePart();
            OutputStream out = part.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(html);
            writer.close();
            out.close();
        }

    }

    private final static class XWPFHtmlRelation extends POIXMLRelation {
        private XWPFHtmlRelation() {
            super(
                    "text/html",
                    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                    "/word/htmlDoc#.html");
        }
    }

    private static MyXWPFHtmlDocument createHtmlDoc(XWPFDocument document, String id) throws Exception {
        OPCPackage oPCPackage = document.getPackage();
        PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
        PackagePart part = oPCPackage.createPart(partName, "text/html");
        MyXWPFHtmlDocument myXWPFHtmlDocument = new MyXWPFHtmlDocument(part, id);
        document.addRelation(myXWPFHtmlDocument.getId(), new XWPFHtmlRelation(), myXWPFHtmlDocument);
        return myXWPFHtmlDocument;
    }

    private static void replaceIBodyElementWithAltChunk(XWPFDocument document, String textToFind,
                                                        MyXWPFHtmlDocument myXWPFHtmlDocument) throws Exception {
        int pos = 0;
        for (IBodyElement bodyElement : document.getBodyElements()) {
            if (bodyElement instanceof XWPFParagraph) {
                XWPFParagraph paragraph = (XWPFParagraph)bodyElement;
                String text = paragraph.getText();
                if (text != null && text.contains(textToFind)) {

                    XmlCursor cursor = paragraph.getCTP().newCursor();
                    cursor.toEndToken();

                    while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START);

                    String uri = CTAltChunk.type.getName().getNamespaceURI();
                    cursor.beginElement("altChunk", uri);
                    cursor.toParent();
                    CTAltChunk cTAltChunk = (CTAltChunk)cursor.getObject();

                    cTAltChunk.setId(myXWPFHtmlDocument.getId());

                    document.removeBodyElement(pos);

                    break;
                }
            }
            pos++;
        }
    }

    private static void ifTagsCalculate(List<XWPFParagraph> paragraphs) {
        List<XWPFParagraph> paragraphsToDelete = new ArrayList<>();
        for (XWPFParagraph p: paragraphs) {
            String text = p.getText();
            int startLength = text.length();
            for (IfStatement ifStatement : getIfStatements(text)) {
                String[] cmpValues = ifStatement.condition.split("=");
                if (cmpValues.length == 1) {
                    cmpValues = ifStatement.condition.split("~");
                }
                if ((ifStatement.condition.contains("=") && cmpValues[0].equals(cmpValues[1])) ||
                        (cmpValues.length == 1 && cmpValues[0].equals("TRUE")) ||
                        (ifStatement.condition.contains("~") && cmpValues[0].contains(cmpValues[1]))) {
                    text = text.replace(ifStatement.fullText, ifStatement.getThenVal());
                } else {
                    text = text.replace(ifStatement.fullText, ifStatement.getElseVal());
                }
            }

            if (startLength > text.length() && text.length() == 0) {
                paragraphsToDelete.add(p);
            } else {
                changeText(p, text);
            }
        }

        for (int i = 0; i < paragraphsToDelete.size(); i++) {
            deleteParagraph(paragraphsToDelete.get(i));
        }
    }

    private static void replaceSimpleTags(List<XWPFParagraph> paragraphs, Map<String, String> simpleTags) {
        for (XWPFParagraph p : paragraphs) {
            String text = p.getText();
            if (!text.equals("")) {
                for (Map.Entry<String, String> entry : simpleTags.entrySet()) {
                    if (text.contains("<" + entry.getKey() + ">")) {
                        text = text.replace("<" + entry.getKey() + ">", Optional.ofNullable(entry.getValue()).orElse(""));
                    }
                }
            }
            text = text.replace("  ", " ").replace(" ,", ",");
            changeText(p, text);
        }
    }

    private static void replaceTaggedTableTags(List<XWPFParagraph> paragraphs, TaggedTable taggedTable, Integer row) {
        for (XWPFParagraph p : paragraphs) {
            String text = p.getText();
            for (Map.Entry<String, String> entry : taggedTable.getRows().get(row).getCellsTags().entrySet()) {
                text = text.replace("<" + entry.getKey() + ">", Optional.ofNullable(entry.getValue()).orElse(""));
            }
            text = text.replace("<[" + taggedTable.getTableName() + "]Sequence>", String.valueOf(row + 1));
            text = text.replace("  ", " ").replace(" ,", ",");
            changeText(p, text);
        }
    }


    public static byte[] fillTagsByDictionary(byte[] template, Map<String, String> simpleTags,
                                                             Map<String, TaggedTable> taggedTables, Map<String, String> htmlTables,
                                     Boolean isPDF) throws Exception {

        XWPFDocument doc = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(template)));

        for (Map.Entry<String, String> entry : htmlTables.entrySet()) {
            MyXWPFHtmlDocument myXWPFHtmlDocument = createHtmlDoc(doc, entry.getKey());
            myXWPFHtmlDocument.setHtml(myXWPFHtmlDocument.getHtml().replace("<body></body>",
                    "<body>" + entry.getValue() + "</body>"
            ));
            replaceIBodyElementWithAltChunk(doc, "<" + entry.getKey() + ">", myXWPFHtmlDocument);
        }

        replaceSimpleTags(doc.getParagraphs(), simpleTags);

        if (taggedTables.size() != 0 && doc.getTables().size() != 0) {

            for (int i = 0; i <doc.getTables().size(); i++)
            {
                XWPFTable table = doc.getTableArray(i);

                XWPFTableRow lastRow = table.getRows().get(table.getNumberOfRows() - 1);
                String firstCellTag = lastRow.getTableCells().get(0).getText();

                if (taggedTables.containsKey(TagUtil.getTableTag(firstCellTag))) {

                    TaggedTable taggedTable = taggedTables.get(TagUtil.getTableTag(firstCellTag));

                    for (int row = 0; row < taggedTable.getRows().size(); row++) {
                        lastRow = table.getRows().get(table.getNumberOfRows() - 1);
                        CTRow ctrowTemplate = CTRow.Factory.parse(lastRow.getCtRow().newInputStream());
                        XWPFTableRow newRow = new XWPFTableRow(ctrowTemplate, table);

                        for (int cell = 0; cell < newRow.getTableCells().size(); cell++) {
                            XWPFTableCell cellObj = newRow.getTableCells().get(cell);
                            replaceSimpleTags(cellObj.getParagraphs(), simpleTags);
                            replaceTaggedTableTags(cellObj.getParagraphs(), taggedTable, row);
                            ifTagsCalculate(cellObj.getParagraphs());
                        }
                        table.addRow(newRow, table.getNumberOfRows() - 1);
                    }
                    table.removeRow(table.getNumberOfRows() - 1);
                }
            }
        }

        ifTagsCalculate(doc.getParagraphs());

        if (getPageCount(doc) > 1) {
            simpleTags.put("SignerPosition", simpleTags.get("SignerFullPosition"));
        }

        for (int i = 0; i <doc.getTables().size(); i++) {
            List<XWPFTableRow> rows = doc.getTableArray(i).getRows();
            for (int row = 0; row < rows.size(); row++) {
                List<XWPFTableCell> cells = rows.get(row).getTableCells();
                for (int cell = 0; cell < cells.size(); cell++) {
                    replaceSimpleTags(cells.get(cell).getParagraphs(), simpleTags);
                    ifTagsCalculate(cells.get(cell).getParagraphs());
                }
            }
        }

        for (XWPFParagraph p: doc.getParagraphs()) {
            if (p.getText().contains("<Sizer>")) {
                changeText(p, "");
                int line = 0;
                int pageCount = getPageCount(doc);
                while (true) {
                    p.insertNewRun(line).addCarriageReturn();
                    p.insertNewRun(++line).addCarriageReturn();
                    p.insertNewRun(++line).addCarriageReturn();
                    int newPageCount = getPageCount(doc);
                    if (newPageCount > pageCount) {
                        p.removeRun(line);
                        p.removeRun(--line);
                        p.removeRun(--line);
                        break;
                    }
                }

            }
        }


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        doc.write(byteArrayOutputStream);
        if (isPDF) {
            byteArrayOutputStream = getPdfBytes(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        }
        return byteArrayOutputStream.toByteArray();
    }


    private static void changeText(XWPFParagraph p, String newText) {
        List<XWPFRun> runs = p.getRuns();
        if (runs.size() != 0) {
            for (int i = runs.size() - 1; i > 0; i--) {
                p.removeRun(i);
            }
            XWPFRun run = runs.get(0);
            run.setText(newText, 0);
        }
    }

    private static ByteArrayOutputStream getPdfBytes(InputStream docxInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IConverter converter = LocalConverter.builder().build();
        converter
                .convert(docxInputStream).as(DocumentType.DOCX)
                .to(byteArrayOutputStream).as(DocumentType.PDF)
                .prioritizeWith(1000).execute();
        return byteArrayOutputStream;
    }
}
