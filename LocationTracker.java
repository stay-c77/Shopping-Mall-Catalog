import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class LocationTracker extends JFrame {
    private JLabel locationLabel;

    public LocationTracker() {
        setTitle("Location Tracker");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        locationLabel = new JLabel("Your location will be displayed here");
        locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(locationLabel, BorderLayout.CENTER);

        JButton trackButton = new JButton("Track Location");
        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL("https://www.googleapis.com/geolocation/v1/geolocate?key=YOUR_API_KEY");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type", "application/json");
                    con.setDoOutput(true);

                    String jsonInputString = "{}";
                    try (OutputStream os = con.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        String jsonResponse = response.toString();
                        // Parse the JSON response and extract location data
                        // For demonstration purposes, just displaying the response
                        locationLabel.setText("Your location: " + jsonResponse);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    locationLabel.setText("Error: Failed to retrieve location");
                }
            }
        });
        add(trackButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LocationTracker tracker = new LocationTracker();
                tracker.setVisible(true);
            }
        });
    }
}