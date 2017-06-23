package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaiVietDAO;
import dao.DanhMucDAO;
import dao.HinhAnhDAO;
import dao.SanPhamDAO;
import dao.VideoDAO;
import model.BaiViet;
import model.DanhMuc;
import model.HinhAnh;
import model.SanPham;
import model.Video;

public class HomeController extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private SanPham sanpham = new SanPham();
	private ArrayList<SanPham> dssanpham;
	private ArrayList<SanPham> dstopsanpham;

	private ArrayList<DanhMuc> dsloaisp;
	private ArrayList<DanhMuc> dshangsx;

	private ArrayList<BaiViet> dsbaiviet;
	private ArrayList<Video> dsvideo;

	private ArrayList<HinhAnh> dshinhanh;

	private BaiViet baiviet;
	private Video video;

	private String keyword;

	private Map<String, Object> session;
	private HttpServletRequest request;
	
	// getAll -------------------------------------------------------

	public HomeController(Map<String, Object> session, HttpServletRequest request) {
		super();
		this.session = session;
		this.request = request;
	}

	public HomeController() {
		super();
	}

	public ArrayList<HinhAnh> getDshinhanh() {
		return dshinhanh;
	}

	public void setDshinhanh(ArrayList<HinhAnh> dshinhanh) {
		this.dshinhanh = dshinhanh;
	}

	public BaiViet getBaiviet() {
		return baiviet;
	}

	public void setBaiviet(BaiViet baiviet) {
		this.baiviet = baiviet;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getKeyword() {
		return keyword;
	}

	public ArrayList<BaiViet> getDsbaiviet() {
		return dsbaiviet;
	}

	public void setDsbaiviet(ArrayList<BaiViet> dsbaiviet) {
		this.dsbaiviet = dsbaiviet;
	}

	public ArrayList<Video> getDsvideo() {
		return dsvideo;
	}

	public void setDsvideo(ArrayList<Video> dsvideo) {
		this.dsvideo = dsvideo;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<SanPham> getDstopsanpham() {
		return dstopsanpham;
	}

	public void setDstopsanpham(ArrayList<SanPham> dstopsanpham) {
		this.dstopsanpham = dstopsanpham;
	}

	public ArrayList<DanhMuc> getDshangsx() {
		return dshangsx;
	}

	public void setDshangsx(ArrayList<DanhMuc> dshangsx) {
		this.dshangsx = dshangsx;
	}

	public ArrayList<DanhMuc> getDsloaisp() {
		return dsloaisp;
	}

	public void setDsloaisp(ArrayList<DanhMuc> dsloaisp) {
		this.dsloaisp = dsloaisp;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public ArrayList<SanPham> getDssanpham() {
		return dssanpham;
	}

	public void setDssanpham(ArrayList<SanPham> dssanpham) {
		this.dssanpham = dssanpham;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	
	public String share() throws Exception {
		dsvideo = new VideoDAO().getAllVideo();
		dsbaiviet = new BaiVietDAO().getAllBaiViet();
			
		dsloaisp = new DanhMucDAO().getAllDanhMucByParent(0);
		dshangsx = new DanhMucDAO().getAllDanhMuc();
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		share();
		return SUCCESS;
	}

	public String home() throws Exception {
		dssanpham = new SanPhamDAO().getNewSanPham();
		dstopsanpham = new SanPhamDAO().getAllTopSanPham();
		getAllBaiViet();
		getAllVideo();
		return execute();
	}

	// getAll -------------------------------------------------------

	public String search() throws Exception {
		dssanpham = new SanPhamDAO().searchSanPham(keyword);
		return execute();
	}

	public String getAllBaiViet() throws Exception {
		dsbaiviet = new BaiVietDAO().getAllBaiViet();
		return execute();
	}

	public String getAllVideo() throws Exception {
		dsvideo = new VideoDAO().getAllVideo();
		return execute();
	}

	// Detail -------------------------------------------------------

	public String getProductDetail() throws Exception {
		dssanpham = new SanPhamDAO().getAllSanPham();
		sanpham = new SanPhamDAO().getSanPhamById(sanpham.getId());
		dshinhanh = new HinhAnhDAO().getAllHinhAnhByIdSP(sanpham.getId());

		dstopsanpham = new SanPhamDAO().getAllTopSanPham();
		return execute();
	}

	public String getBaiVietDetail() throws Exception {
		baiviet = new BaiVietDAO().getBaiVietById(baiviet.getId());
		return execute();
	}

	public String getVideoDetail() throws Exception {
		video = new VideoDAO().getVideoById(video.getId());
		return execute();
	}
	
	
	public String getSoSanh() throws Exception {
		return execute();
	}

}
