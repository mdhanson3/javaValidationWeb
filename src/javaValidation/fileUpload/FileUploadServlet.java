package javaValidation.fileUpload;

import java.io.*;
import java.util.*;
import javaValidation.validation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

@WebServlet(
        name = "FileUpload",
        urlPatterns = { "/FileUploadServlet" }
)

/**
 * Created by student on 7/20/16.
 */
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        FileValidator validator = new FileValidator();


        if (!isMultipart) {
            return;
        }

        /*
         *  http://commons.apache.org/proper/commons-fileupload/using.html
         */
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;

        // Parse the request
        // items contains a list of file items that must be processed
        try {
           items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (!item.isFormField()) {

                String fieldName = item.getFieldName();
                String fileName = item.getName();
                String contentType = item.getContentType();
                boolean isInMemory = item.isInMemory();
                long sizeInBytes = item.getSize();

                String sRootPath = new File("").getAbsolutePath();
                sRootPath += "/temp.txt";

                String[] args = new String[]{sRootPath};
                File file = new File(sRootPath);
                try {
                    item.write(file);
                } catch(Exception e) {
                    System.out.println("File write error: " + e.toString());
                    e.printStackTrace();
                }

                try {
                    validator.runValidation(args);
                } catch(Exception e) {
                    System.out.println("CAUGHT ERROR");
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "Sorry bud, there was an error.  Please try again.");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(
                            request, response);
                }

                request.setAttribute("type", contentType);

            }
        }


        String sRootPath = new File("").getAbsolutePath();
        String htmlOutputFile = sRootPath + "/originalJavaCode.html";

        FileParserWeb parser = new FileParserWeb(htmlOutputFile);
        parser.runFileParser();
        items = parser.getFileContents();
        System.out.println(items);

        request.setAttribute("fileContents", items);

        getServletContext().getRequestDispatcher("/done.jsp").forward(
                    request, response);




//        // Create a factory for disk-based file items
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//
//
//        // Sets the directory used to temporarily store files that are larger
//        // than the configured size threshold. We use temporary directory for
//        // java
//        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//
//
//        // Create a new file upload handler
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//
//        try {
//            // Parse the request
//            List items = upload.parseRequest(request);
//            Iterator iter = items.iterator();
//            while (iter.hasNext()) {
//                FileItem item = (FileItem) iter.next();
//
//                if (!item.isFormField()) {
//                    String fileName = new File(item.getName()).getName();
//                    String filePath = uploadFolder + File.separator + fileName;
//                    File uploadedFile = new File(filePath);
//                    System.out.println(filePath);
//                    // saves the file to upload directory
//                    item.write(uploadedFile);
//                }
//            }
//
//            // displays done.jsp page after upload finished
//            getServletContext().getRequestDispatcher("/done.jsp").forward(
//                    request, response);
//
//        } catch (FileUploadException ex) {
//            throw new ServletException(ex);
//        } catch (Exception ex) {
//            throw new ServletException(ex);
//        }

    }

}
