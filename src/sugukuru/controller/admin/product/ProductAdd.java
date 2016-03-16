package sugukuru.controller.admin.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
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

import sugukuru.bean.Category;
import sugukuru.bean.Product;
import sugukuru.dao.ProductCategoryDao;
import sugukuru.dao.ProductsDao;

/**
 * Servlet implementation class ProductAdd
 */
@WebServlet("/Admin/ProductManagement/ProductAdd")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCategoryDao dao = new ProductCategoryDao();
		List<Category> categorys = dao.getAllvategory();
		request.setAttribute("categorys", categorys);

		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/admin/product/productAdd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FILEPATH = "/Users/yanagikouta/eclipceProjects/Sugukuru/WebContent/productImage/main";
		File path = new File(FILEPATH);
		DiskFileItemFactory dfi = new DiskFileItemFactory();
		dfi.setRepository(path); // 一時ファイルの保存先フォルダ
		dfi.setSizeThreshold(1024); // バッファサイズ
		ServletFileUpload sfu = new ServletFileUpload(dfi);
		sfu.setSizeMax(-1); // アップロードファイルの最大サイズ（-1は無限）
		sfu.setHeaderEncoding("UTF-8"); // ヘッダの文字エンコーディング
		FileItem tempFileItem = null; // ファイルの一時退避用

		// DBへインサートするためのデータの初期化＆インスタンス生成
		ProductsDao dao = new ProductsDao();
		String name = "";
		String category = "";
		String detail = "";
		int price = 0;

		try {
			// アップロードされたファイル情報をFileItemオブジェクトのリストとして取得
			List<FileItem> objLst = sfu.parseRequest(request);
			Iterator<FileItem> objItr = objLst.iterator();

			// リストから順にファイルデータを取り出し、ファイルはデータベースに情報を格納した後に保存するため、一時退避しておく
			while (objItr.hasNext()) {
				FileItem objFi = (FileItem) objItr.next();
				if (!objFi.isFormField()) {
					tempFileItem = objFi;
				} else {
					 //パラメータチェック
					 if(objFi.getFieldName().equals("name")){
						 name = new String(objFi.getString().getBytes("iso-8859-1"),"utf-8");
					 }

					 if(objFi.getFieldName().equals("category")){
						 category = new String(objFi.getString().getBytes("iso-8859-1"),"utf-8");
					 }

					 if(objFi.getFieldName().equals("detail")){
						 detail = new String(objFi.getString().getBytes("iso-8859-1"),"utf-8");
					 }

					 if(objFi.getFieldName().equals("price")){
						 price = new Integer(String.valueOf(objFi.getString()));
					 }
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Product product = new Product(name,category,price,detail);
		String id = dao.setProductAdd(product);

		// 商品ID.jpgで保存
		String strNam = id + ".jpg";
		if (strNam != null && !strNam.isEmpty()) {
			strNam = (new File(strNam)).getName();
			try {
				tempFileItem.write(new File(path + "/" + strNam));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		response.sendRedirect("/Sugukuru/Admin/ProductManagement/ProductList");
	}
}
