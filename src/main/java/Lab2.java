import javax.imageio.ImageIO; // lets us read and write images like PNGs
import javax.swing.*; // used to make windows and GUI
import java.awt.*; // for colors and images and layout
import java.io.IOException; // deals with input/output errors
import java.io.InputStream; // this is like a stream of data, we use it for the image
import java.net.URI; // makes URLs, like website links
import java.net.http.HttpClient; // used to send http requests
import java.net.http.HttpRequest; // this is the actual request we build
import java.net.http.HttpResponse; // handles the response

// This is the main method, start of our program
void main() {
    try {   // for error handling
        var avatarStream = getRandomAvatarStream();
        // call the method to get a random avatar image as a stream of data
        // avatarStream is an InputStream (object type)

        showAvatar(avatarStream);
        // we pass that stream to showAvatar method to display the image
        // it's a reference, not a number or something
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
        // if anything breaks, this prints the error
        // printStackTrace() is an instance method from class
    }
}

        // This method gets us a random avatar from the internet
        InputStream getRandomAvatarStream() throws IOException, InterruptedException {
            // list of styles we can get the avatar in
            String[] styles = {
                    "adventurer", "adventurer-neutral", "avataaars", "big-ears",
                    "big-ears-neutral", "big-smile", "bottts", "croodles",
                    "croodles-neutral", "fun-emoji", "icons", "identicon",
                    "initials", "lorelei", "micah", "miniavs", "open-peeps",
                    "personas", "pixel-art", "pixel-art-neutral"
            };
            // styles is a String array, which is an object type
            // picks a random style

            var style = styles[(int)(Math.random() * styles.length)];
            // Math.random() is a static method that gives a number between 0 and 1
            // styles.length is the number of elements in the array (instance var)
            // we cast it to int to get whole number index

            // make a random seed number for randomness
            var seed = (int)(Math.random() * 10000);
            // seed is an int(primitive)

            // make the URL with the style and seed
            var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
            // URI.create is a static method that gives a URI object from a string
            // String.formatted(...) is an instance method that fills in %s and %d

            var request = HttpRequest.newBuilder(uri).build();
            // HttpRequest.newBuilder() is a static method that gives a builder for the request
            // .build() is an instance method that turns the builder into a real object

            // Send the request using a client
            try (var client = HttpClient.newHttpClient()) {
                // HttpClient.newHttpClient() is a static method that gives a new HttpClient
                var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
                // .send() is an instance method of client, sends the request and returns response
                // HttpResponse.BodyHandlers.ofInputStream() is a static method to handle the image as a stream

                return response.body();
                // .body() is an instance method, gives us the InputStream we want
            }
        }

        // This method shows the avatar in a GUI window
        void showAvatar(InputStream imageStream) {
            JFrame frame = new JFrame("PNG Viewer");
            // JFrame is from javax.swing, creates a window
            // "PNG Viewer" is the title we pass to the constructor

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // .setDefaultCloseOperation is an instance method
            // JFrame.EXIT_ON_CLOSE is a static variable that tells it to close on exit (we cannot change the values )


            frame.setResizable(false);
            // makes it so you can’t resize the window

            frame.setSize(200, 200);
            // sets window size (width x height in pixels)

            frame.getContentPane().setBackground(Color.BLACK);
            // getContentPane() is an instance method that gets the main part of the frame
            // .setBackground is an instance method to set background color
            // Color.BLACK is a static variable from java.awt.Color

            try {
                Image image = ImageIO.read(imageStream);
                // ImageIO.read is a static method from javax.imageio, it reads an InputStream into an Image object
                // Image is from java.awt, it holds the image data
                // image is a reference type

                JLabel imageLabel = new JLabel(new ImageIcon(image));
                // JLabel is from javax.swing, displays in the GUI
                // ImageIcon is from javax.swing too, it turns Image into something JLabel can show
                // new JLabel(...) and new ImageIcon(...) are constructor calls

                frame.add(imageLabel, BorderLayout.CENTER);
                // .add is an instance method to add components to the frame
                // BorderLayout.CENTER is a static variable that centers it in the frame
            } catch (IOException e) {
                e.printStackTrace();
                // same thing, prints error if something goes wrong loading the image
            }

            frame.setVisible(true);
            // shows the window on the screen
        }
