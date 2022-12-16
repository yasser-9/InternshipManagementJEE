package upload_files;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import dao.etudiantdao;
//@WebServlet({"/servletetudiant","/Tet"})
@WebServlet (name="cssss",urlPatterns= {"/FileUploadHandler","*.po"})
public class FileUploadHandler extends HttpServlet {
 private static final long serialVersionUID = 1 ;
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
 doPost(request, response);
 }
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
 String file_name = null;
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
 if (!isMultipartContent) {
 return;
 }
 FileItemFactory factory = new DiskFileItemFactory();
 ServletFileUpload upload = new ServletFileUpload(factory);
 try {
 List < FileItem > fields = upload.parseRequest(request);
 Iterator < FileItem > it = fields.iterator();
 if (!it.hasNext()) {
 return;
 }
 while (it.hasNext()) {
 FileItem fileItem = it.next();
 boolean isFormField = fileItem.isFormField();
 if (isFormField) {
 if (file_name == null) {
 if (fileItem.getFieldName().equals("file_name")) {
 file_name = fileItem.getString();
 }
 }
 } else {
	 if (fileItem.getSize() > 0) {
         String outputFileNm = ((file_name==null || file_name.equals(""))?fileItem.getName():file_name);
         String fileNameSuffix = "." + FilenameUtils.getExtension(fileItem.getName());
         File outputFile = new File(outputFileNm);
         fileItem.write(new File("C:\\LearningIsFun\\uploaded_files\\" + outputFile.getName()+fileNameSuffix));
         //fileItem.write(new File("C:\\Users\\hp\\eclipse-workspace\\projectuml\\src\\main\\webapp\\jsp_file_upload\\" + outputFile.getName()+fileNameSuffix));
         String f=outputFile.getName()+fileNameSuffix;
         System.out.println(f);
         int r=Integer.parseInt(request.getParameter("id"));
         etudiantdao d =new etudiantdao();
         d.update_rapport(r, f);
        }
 }
 }
 } catch (Exception e) {
 e.printStackTrace();
 } finally {
	 int r=Integer.parseInt(request.getParameter("id"));
	 System.out.println(r+"its working");
 out.println("<script type='text/javascript'>");
 out.println("window.location.href='index1.jsp?filename="+file_name+"'");
 out.println("</script>");
 out.close();
 }
 }
}
