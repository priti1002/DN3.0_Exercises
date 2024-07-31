public class ImageViewerClient {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");
        Image image3 = new ProxyImage("image1.jpg"); // This will use cached image

        // Load and display image1
        image1.display();
        // Load and display image2
        image2.display();
        // Display image1 again (should be loaded from cache)
        image3.display();
    }
}