package excelUsingApachePOIStreamAPI;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

public class StreamingRowContentHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
    private String searchKey;
    private boolean foundKey;
    private StringBuilder rowData;

    public StreamingRowContentHandler(String searchKey) {
        this.searchKey = searchKey;
        this.foundKey = false;
        this.rowData = new StringBuilder();
    }

    @Override
    public void startRow(int rowNum) {
        // Logic for handling the start of a row
//        System.out.println(rowNum);
        foundKey = false;
        rowData.setLength(0);

    }

    @Override
    public void endRow(int i) {
        if (foundKey) {
            System.out.println("found in row: " + (i));
            System.out.println("Row data containing the key: " + rowData.toString());
        }
//        System.out.println("End");
    }

    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {
        // Logic for processing the cell content
        if (formattedValue.equals(searchKey)) {
            // Found the key, set the flag to true
            foundKey = true;
        }

        // Append the cell content to the row data StringBuilder
        rowData.append(formattedValue).append(" ");
    }
}
