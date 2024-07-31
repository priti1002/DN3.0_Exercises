public class Main {
    public static void main(String[] args) {
        // Create a Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentManager wordManager = new DocumentManager(wordFactory);
        wordManager.createAndUseDocument();

        // Create a PDF document
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        DocumentManager pdfManager = new DocumentManager(pdfFactory);
        pdfManager.createAndUseDocument();

        // Create an Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        DocumentManager excelManager = new DocumentManager(excelFactory);
        excelManager.createAndUseDocument();
    }
}
