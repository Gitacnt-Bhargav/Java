package excelUsingApachePOIStreamAPI;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;

import java.io.InputStream;
import java.io.FileInputStream;

public class StreamingExcelReader {
    public static void processExcelFile(String filePath, String key) {
        try {
            OPCPackage opcPackage = OPCPackage.open(new FileInputStream(filePath));
            XSSFReader xssfReader = new XSSFReader(opcPackage);
            ReadOnlySharedStringsTable sharedStringsTable = new ReadOnlySharedStringsTable(opcPackage);

            XMLReader parser = XMLReaderFactory.createXMLReader();
            XSSFSheetXMLHandler sheetHandler = new XSSFSheetXMLHandler(null, sharedStringsTable, new StreamingRowContentHandler(key), false);
//            XSSFSheetXMLHandler sheetXMLHandler1 = new XSSFSheetXMLHandler(null,sharedStringsTable, new StreamingRo
            parser.setContentHandler(sheetHandler);

            SheetIterator sheetIterator = (SheetIterator) xssfReader.getSheetsData();
            while (sheetIterator.hasNext()) {
                InputStream sheetStream = sheetIterator.next();
                InputSource sheetSource = new InputSource(sheetStream);
                parser.parse(sheetSource);
                sheetStream.close();
            }

            opcPackage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\bharg\\JavaPrograms\\JavaPrgms\\test.xlsx"; // Replace with the actual file path
        String key = "1300"; // Replace with the specific key value to search for
        processExcelFile(filePath, key);
    }
}