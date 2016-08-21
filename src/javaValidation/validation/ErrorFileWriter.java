package javaValidation.validation;

import java.io.*;
import java.util.List;

/**
 * Created by student on 2/9/16.
 */
public class ErrorFileWriter {
    private final String HTML_STYLE = "<head><meta charset=\"utf-8\"/><style>.underline {text-decoration: underline; -moz-text-decoration-color: red; text-decoration-color: red; background-color: yellow;} </style> </head>";

    public void writeMarkupFile(String file) {
        String line = null;
        String outputLine = "";
        int lineNumber = 1;
        String sRootPath = new File("").getAbsolutePath();
        String fileWithHighlightedErrors = sRootPath + "/withHighlightedErrors.html";
        try(BufferedReader input = new BufferedReader(new FileReader(file));
                //BufferedWriter out = new BufferedWriter(new FileWriter("output/withHighlightedErrors.html"))) {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileWithHighlightedErrors))) {
            while((line = input.readLine()) != null) {
                outputLine = "Line number " + lineNumber + " " + line;
                out.write(outputLine);
                out.newLine();
                lineNumber ++;
            }
        } catch (IOException ioException) {
            System.out.println("Error writing the markup file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error opening the file");
            exception.printStackTrace();
        }
    }

    public void writeSummaryFile(String summaryText, List<String> errors) {
        String sRootPath = new File("").getAbsolutePath();
        String summaryFilePath = sRootPath + "/Summary.txt";

        //try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output/Summary.txt")))) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(summaryFilePath)))) {
            out.println(summaryText);
            for( String lineError : errors) {
                out.println(lineError);
            }
        } catch (IOException ioException) {
            System.out.println("Error writing the summary file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error opening the file");
            exception.printStackTrace();
        }
    }

    public void writeFileFromArray(List<String> output, String fileName) {
        String sRootPath = new File("").getAbsolutePath();
        String summaryFilePath = sRootPath + "/" + fileName;
        try {
            BufferedWriter out = null;
            try /*(BufferedWriter out = new BufferedWriter(new FileWriter("output/" + fileName)))*/ {
                System.out.println("==================IN WRITER=====================");
                System.out.println(fileName);

                //File outputFile = new File("output/" + fileName);
                File outputFile = new File(summaryFilePath);
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }

                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));

                //out.write(HTML_STYLE);
                for (String outputLine : output) {
                    System.out.println("writing");
                    out.write(outputLine + "<br />");
                    out.newLine();
                }
            } catch (IOException ioException) {
                System.out.println("Error writing the markup file");
                ioException.printStackTrace();
            } catch (Exception exception) {
                System.out.println("Error writing the cleansed file");
                exception.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } catch (Exception e) {

        }
    }
}
