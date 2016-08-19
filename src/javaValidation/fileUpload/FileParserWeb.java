package javaValidation.fileUpload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 8/11/16.
 */
public class FileParserWeb {
    private String filePath;
    private List<String> fileContents;

    FileParserWeb(String path) {
        filePath = path;
        fileContents = new ArrayList();
    }

    /**
     * Generates an List of Strings for its filePath.
     */
    public void runFileParser() {
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            while (input.ready()) {
                fileContents.add(input.readLine());
            }
        } catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Failed to read input file");
            fnfe.printStackTrace();
        } catch (Exception exception) {
            System.out.println("General Error");
            exception.printStackTrace();
        }
    }

    /**
     * returns fileContetns List
     *
     * @return List of strings that corresponds to each line of the class's file
     */
    public List getFileContents() {
        return fileContents;
    }
}


