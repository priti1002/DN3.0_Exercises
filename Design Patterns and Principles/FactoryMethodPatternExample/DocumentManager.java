public class DocumentManager {
    private DocumentFactory documentFactory;

    public DocumentManager(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    public void createAndUseDocument() {
        Document document = documentFactory.createDocument();
        document.open();
        document.save();
        document.close();
    }
}
