package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.SanPhamDAO;
import model.SanPham;
import tool.StringAction;

public class AjaxController extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String keyword;
	private ArrayList<SanPham> dstimkiem;	

	public ArrayList<SanPham> getDstimkiem() {
		return dstimkiem;
	}

	public void setDstimkiem(ArrayList<SanPham> dstimkiem) {
		this.dstimkiem = dstimkiem;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public void search() {
		if(keyword==null || keyword.equals(""))
			return;
		
		dstimkiem = new SanPhamDAO().searchSanPham(keyword);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<table style='background: #FFF; z-index: 9999; margin: 0'>");
			
			for(SanPham i: dstimkiem) {
				out.print("<tr>");
					out.print("<td style='padding: 10px; '>");
						out.print("<a href='/ShopStruts2/product?sanpham.id=" + i.getId() + "'><img src=upload/sanpham/"+i.getHinhanh() + " width='50' /></a>");
					out.print("</td>");
						
					out.print("<td style='padding: 10px; '>");
						out.print("<a href='/ShopStruts2/product?sanpham.id=" + i.getId() + "'>" + i.getLoaisp() + " " + i.getHangsx() + " " + i.getTen() + "</a>");
					out.print("</td>");
					
					out.print("<td style='padding: 10px; color: red'>");
						out.print(StringAction.numberFormat(i.getGia())+"đ");
					out.print("</td>");
				
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			out.flush();
		} catch (Exception e) {
		}
	}

}
