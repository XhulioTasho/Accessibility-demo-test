import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;

public class JSONToHTMLReport {

    public static void generateHTMLReport(JSONArray jsonArray, String outputFilePath) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);
            fileWriter.write("<html><head><title>JSON Array to HTML Report</title></head><body>");
            fileWriter.write("<h1>JSON Array to HTML Report</h1>");

            // Iterate over JSON array elements
            for (int i = 0; i < jsonArray.length(); i++) {
                Object value = jsonArray.get(i);
                fileWriter.write("<h2>Item " + (i + 1) + "</h2>");
                if (value instanceof JSONObject) {
                    generateHTMLForJSONObject((JSONObject) value, fileWriter);
                } else if (value instanceof JSONArray) {
                    generateHTMLForJSONArray((JSONArray) value, fileWriter);
                } else {
                    fileWriter.write("<p>" + value + "</p>");
                }
            }

            fileWriter.write("</body></html>");
            fileWriter.close();
            System.out.println("HTML report generated successfully at " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateHTMLForJSONObject(JSONObject jsonObject, FileWriter fileWriter) throws IOException {
        fileWriter.write("<ul>");
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            fileWriter.write("<li><b>" + key + "</b>: ");
            if (value instanceof JSONObject) {
                generateHTMLForJSONObject((JSONObject) value, fileWriter);
            } else if (value instanceof JSONArray) {
                generateHTMLForJSONArray((JSONArray) value, fileWriter);
            } else {
                fileWriter.write(value.toString());
            }
            fileWriter.write("</li>");
        }
        fileWriter.write("</ul>");
    }

    private static void generateHTMLForJSONArray(JSONArray jsonArray, FileWriter fileWriter) throws IOException {
        fileWriter.write("<ul>");
        for (Object item : jsonArray) {
            if (item instanceof JSONObject) {
                generateHTMLForJSONObject((JSONObject) item, fileWriter);
            } else if (item instanceof JSONArray) {
                generateHTMLForJSONArray((JSONArray) item, fileWriter);
            } else {
                fileWriter.write("<li>" + item.toString() + "</li>");
            }
        }
        fileWriter.write("</ul>");
    }

    public static void main(String[] args) {
        String inputFilePath = "HaconDemoTest.json"; // Specify your JSON file path
        String outputFilePath = "report.html"; // Specify the output HTML file path

        try {
            // Read JSON file
            FileReader fileReader = new FileReader(inputFilePath);
            JSONTokener tokener = new JSONTokener(fileReader);
            JSONArray jsonArray = new JSONArray(tokener);
            fileReader.close();

            // Generate HTML report
            generateHTMLReport(jsonArray, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
