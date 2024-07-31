

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer(); // Simulate loading image from server
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + filename);
        // Simulate delay for loading image
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}