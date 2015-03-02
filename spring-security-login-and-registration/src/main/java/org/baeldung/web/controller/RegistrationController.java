package org.baeldung.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.jws.WebParam.Mode;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.baeldung.persistence.service.PhongDto;
import org.apache.commons.io.FileUtils;
import org.baeldung.persistence.dao.AdminRepository;
import org.baeldung.persistence.dao.PhongRepository;
import org.baeldung.persistence.model.Admin;
import org.baeldung.persistence.model.DatCuoc;
import org.baeldung.persistence.model.NguoiChoi;
import org.baeldung.persistence.model.Phong;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.VerificationToken;
import org.baeldung.persistence.service.AdminDto;
import org.baeldung.persistence.service.AdminService;
import org.baeldung.persistence.service.Changepass;
import org.baeldung.persistence.service.DatCuocDto;
import org.baeldung.persistence.service.DatCuocService;
import org.baeldung.persistence.service.ForgetP;
import org.baeldung.persistence.service.FPass;
import org.baeldung.persistence.service.ListenerService;
import org.baeldung.persistence.service.NguoiChoiDto;
import org.baeldung.persistence.service.NguoiChoiService;
import org.baeldung.persistence.service.PhongService;
import org.baeldung.persistence.service.TiLeDto;
import org.baeldung.persistence.service.UserDto;
import org.baeldung.persistence.service.File;
import org.baeldung.persistence.service.IUserService;
import org.baeldung.persistence.service.UserInfo;
import org.baeldung.event.OnRegistrationCompleteEvent;
import org.baeldung.event.listener.RegistrationListener;
import org.baeldung.hashing.HashGenerator;
import org.baeldung.validation.service.EmailExistsException;
import org.baeldung.validation.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class RegistrationController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	/*
	 * //FileValidator validator = new FileValidator();
	 * 
	 * @InitBinder private void initBinder(WebDataBinder binder) {
	 * binder.setValidator(validator); }
	 */
	//Map mapA = new HashMap();
	Map<Integer, Integer> myarray = new HashMap<Integer, Integer>();
	Map<Integer, Integer> isclose = new HashMap<Integer, Integer>();
	Map<Integer, String> xucxac = new HashMap<Integer, String>();
	//private Map myarray = new HashMap();
	//private Map isclose = new HashMap();

	
	@Autowired
	private HashGenerator hashGenerator;

	@Autowired
	private PhongRepository phongRepository;

	@Autowired
	private DatCuocService datcuocsc;

	@Autowired
	private IUserService service;

	@Autowired
	private NguoiChoiService nguoiChoisc;

	@Autowired
	private PhongService phongsc;

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private AdminService adminsc;

	private String result = " ";

	public RegistrationController() {

	}// getnumber.html settime xunhacaiload

	/*
	 * @ModelAttribute("user") @Valid UserDto accountDto, BindingResult result,
	 * WebRequest request, Errors errors, HttpServletRequest req, @Validated
	 * File file,
	 * 
	 * @RequestMapping(value = "/bancua/{biencua}", method = RequestMethod.GET)
	 * public @ResponseBody String bancua(Model model, @PathVariable("biencua")
	 * int biencua, rutxu HttpServletRequest request) { napxuajax
	 * list-thanh-vien-rut-tien.jsp .jsp setstatus quan-ly-ty-le-cuoc.jsp
	 * roiphong
	 */

	/*
	 * @RequestMapping(value = "/adminhuongdan", method = RequestMethod.GET)
	 * public @ResponseBody String adminhuongdan(Model model, HttpServletRequest
	 * request) throws EmailExistsException { HttpSession session =
	 * request.getSession(false); String username = (String)
	 * session.getAttribute("username"); String pathInfo =
	 * request.getPathInfo(); System.out.println(pathInfo); Admin admin = null;
	 * AdminDto admindto = new AdminDto(); try { admin = adminsc.getadmin(1);
	 * 
	 * } catch (Exception e) { // TODO: handle exception }
	 * 
	 * if (admin == null) { adminsc.registerNewAdmin(admindto); } else {
	 * 
	 * //admin.setEditor(editor1); adminsc.saveAdmin(admin); } return
	 * "Lưu thàng công";
	 * 
	 * }
	 */

	@RequestMapping(value = "/resetjax", method = RequestMethod.GET)
	public @ResponseBody
	String resetjax(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		try {
			List<NguoiChoi> allNguoiChoi = nguoiChoisc.getAllNguoiChoi();
			for (NguoiChoi nguoiChoi2 : allNguoiChoi) {
				nguoiChoisc.deleteNguoiChoi(nguoiChoi2);
			}

		} catch (Exception e) {

		}
		
		try {
			List<Phong> listphong = phongsc.getAllPhong();
			for (Phong phong2 : listphong) {
				phongsc.deletePhong(phong2);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			List<DatCuoc> listdatcuoc = datcuocsc.getAlldatcuoc();
			for (DatCuoc datcuoc : listdatcuoc) {
				datcuocsc.deleDatCuoc(datcuoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "0";

	}

	@RequestMapping(value = "/roiphong/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String roiphong(Model model, @PathVariable("id") int id,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		Long iddlt = (long) id;
		try {
			DatCuoc datcuoc = null;
			datcuoc = datcuocsc.findDatCuocbyid(id);
			if(datcuoc!=null){
				//System.out.println("roiphong");
			Phong phong = phongsc.getPhong(datcuoc.getMaBan());
			//System.out.println(phong.getSoChoi());
			phong.setSoChoi(phong.getSoChoi() - 1);			
			phongsc.savePhong(phong);
			//System.out.println(phong.getSoChoi());
			datcuocsc.deleDatCuoc(datcuoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return username;

	}

	@RequestMapping(value = "/huyxudarut/{xu}", method = RequestMethod.GET)
	public @ResponseBody
	String huyxudarut(Model model, @PathVariable("xu") int xu,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		double id = (double) xu;
		User user = null;
		try {
			user = service.getEuser(username);

		} catch (Exception e) {
			// TODO: handle exception

		}
		//System.out.println(id);
		if(user.getRuttien()==id){
			user.setXu(user.getXu() + id);
			user.setRuttien((double) 0);
			service.saveRegisteredUser(user);
			return Double.toString(user.getXu()) + "," + 1;
		}else {
			return Double.toString(user.getXu()) + "," + 1;
		}
		
		

	}

	@RequestMapping(value = "/rutxu/{xu}", method = RequestMethod.GET)
	public @ResponseBody
	String rutxuajax(Model model, @PathVariable("xu") int xu,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");

		double id = (double) xu;
		User user = null;
		try {
			user = service.getEuser(username);

		} catch (Exception e) {
			// TODO: handle exception

		}
		if (id < 100) {
			return Double.toString(user.getXu()) + "," + 1;
		}
		if ((id + user.getRuttien()) > user.getXu()) {
			return Double.toString(user.getXu()) + "," + 2;
		}

		user.setRuttien(user.getRuttien() + id);
		user.setStatus(0);
		user.setXu(user.getXu() - id);
		service.saveRegisteredUser(user);

		return Double.toString(user.getXu()) + "," + 3 + ","
				+ user.getRuttien().intValue();

	}

	@RequestMapping(value = "/admin-huong-dan-nap-xu", method = RequestMethod.POST)
	public ModelAndView adminhdnppc(@ModelAttribute("admin") AdminDto admindto,
			BindingResult result, WebRequest request, Errors errors,
			HttpServletRequest req, @Validated File file, Model model)
			throws EmailExistsException {

		Admin admin = null;
		try {
			admin = adminsc.getadmin(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (admin == null) {
			adminsc.registerNewAdmin(admindto);
		} else {
			admin.setNapxueditor(admindto.getNapxueditor());
			admin.setNapxutitile(admindto.getNapxutitile());
			adminsc.saveAdmin(admin);
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admindto);
		model.addAttribute("message", "Cập nhật thành công");
		ModelAndView mav = new ModelAndView("admin-huong-dan-nap-xu");
		return mav;

	}

	@RequestMapping(value = "/admin-huong-dan-choi-game", method = RequestMethod.POST)
	public ModelAndView adminhdpc(@ModelAttribute("admin") AdminDto admindto,
			BindingResult result, WebRequest request, Errors errors,
			HttpServletRequest req, @Validated File file, Model model)
			throws EmailExistsException {

		Admin admin = null;
		try {
			admin = adminsc.getadmin(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (admin == null) {
			adminsc.registerNewAdmin(admindto);
		} else {
			admin.setEditor(admindto.getEditor());
			admin.setTitile(admindto.getTitile());
			adminsc.saveAdmin(admin);
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admindto);
		model.addAttribute("message", "Cập nhật thành công");
		ModelAndView mav = new ModelAndView("admin-huong-dan-choi-game");
		return mav;

	}

	@RequestMapping(value = "/admin-Reset-Server", method = RequestMethod.GET)
	public ModelAndView reset(Model model, HttpServletRequest req)
			throws EmailExistsException {

		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setNapxueditor(adminr.getNapxueditor());
			admin.setNapxutitile(adminr.getNapxutitile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);

		ModelAndView mav = new ModelAndView("admin-Reset-Server");
		return mav;

	}

	@RequestMapping(value = "/admin-huong-dan-nap-xu", method = RequestMethod.GET)
	public ModelAndView adminhdnp(Model model, HttpServletRequest req)
			throws EmailExistsException {

		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setNapxueditor(adminr.getNapxueditor());
			admin.setNapxutitile(adminr.getNapxutitile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);

		ModelAndView mav = new ModelAndView("admin-huong-dan-nap-xu");
		return mav;

	}

	@RequestMapping(value = "/admin-huong-dan-choi-game", method = RequestMethod.GET)
	public ModelAndView adminhd(Model model, HttpServletRequest req)
			throws EmailExistsException {

		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setEditor(adminr.getEditor());
			admin.setTitile(adminr.getTitile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);

		ModelAndView mav = new ModelAndView("admin-huong-dan-choi-game");
		return mav;

	}

	@RequestMapping(value = "/ql-hoa-hong", method = RequestMethod.POST)
	public ModelAndView sethoahongpc(
			@ModelAttribute("admin") AdminDto admindto, BindingResult result,
			WebRequest request, Errors errors, HttpServletRequest req,
			@Validated File file, Model model) throws EmailExistsException {

		Admin admin = null;
		try {
			admin = adminsc.getadmin(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (admin == null) {
			adminsc.registerNewAdmin(admindto);
		} else {
			admin.setHoahong(admindto.getHoahong());
			adminsc.saveAdmin(admin);
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admindto);
		model.addAttribute("message", "Cập nhật thành công");
		ModelAndView mav = new ModelAndView("ql-hoa-hong");
		return mav;

	}

	@RequestMapping(value = "/ql-hoa-hong", method = RequestMethod.GET)
	public ModelAndView sethoahong(Model model, HttpServletRequest req)
			throws EmailExistsException {
		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setHoahong(adminr.getHoahong());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);

		ModelAndView mav = new ModelAndView("ql-hoa-hong");
		return mav;

	}

	@RequestMapping(value = "/ql-thoi-gian-dem-nguoc", method = RequestMethod.POST)
	public ModelAndView setthoigianpc(
			@ModelAttribute("admin") AdminDto admindto, BindingResult result,
			WebRequest request, Errors errors, HttpServletRequest req,
			@Validated File file, Model model) throws EmailExistsException {

		Admin admin = null;
		try {
			admin = adminsc.getadmin(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (admin == null) {
			adminsc.registerNewAdmin(admindto);
		} else {
			admin.setGiay(admindto.getGiay());
			admin.setPhut(admindto.getPhut());
			adminsc.saveAdmin(admin);
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admindto);
		model.addAttribute("message", "Cập nhật thành công");
		ModelAndView mav = new ModelAndView("ql-thoi-gian-dem-nguoc");
		return mav;

	}

	@RequestMapping(value = "/ql-thoi-gian-dem-nguoc", method = RequestMethod.GET)
	public ModelAndView setthoigian(Model model, HttpServletRequest req)
			throws EmailExistsException {
		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setGiay(adminr.getGiay());
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ModelAndView mav = new ModelAndView("ql-thoi-gian-dem-nguoc");
		return mav;

	}

	@RequestMapping(value = "/quan-ly-ty-le-cuoc", method = RequestMethod.POST)
	public ModelAndView quanlytylecuocpc(
			@ModelAttribute("admin") AdminDto admindto, BindingResult result,
			WebRequest request, Errors errors, HttpServletRequest req,
			@Validated File file, Model model) throws EmailExistsException {

		Admin admin = null;
		try {
			admin = adminsc.getadmin(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (admin == null) {
			adminsc.registerNewAdmin(admindto);
		} else {
			admin.set_1den3trang(admindto.getDenbatrang());
			admin.set_1trang3den(admindto.getTragbaden());
			admin.set_4den(admindto.getBonden());
			admin.set_4trang(admindto.getBontrang());
			admin.setChan(admindto.getChan());
			admin.setLe(admindto.getCuale());
			adminsc.saveAdmin(admin);
		}
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admindto);
		model.addAttribute("message", "Cập nhật thành công");
		ModelAndView mav = new ModelAndView("quan-ly-ty-le-cuoc");
		return mav;

	}

	@RequestMapping(value = "/quan-ly-ty-le-cuoc", method = RequestMethod.GET)
	public ModelAndView quanlytylecuoc(Model model, HttpServletRequest req)
			throws EmailExistsException {
		AdminDto admin = new AdminDto();
		Admin adminr = null;
		try {
			adminr = adminsc.getadmin(1);
			admin.setBonden(adminr.get_4trang());
			admin.setBontrang(adminr.get_4trang());
			admin.setChan(adminr.getChan());
			admin.setDenbatrang(adminr.get_1den3trang());
			admin.setTragbaden(adminr.get_1trang3den());
			admin.setCuale(adminr.getLe());
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("admin", admin);
		try {
			HttpSession session = req.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}

		ModelAndView mav = new ModelAndView("quan-ly-ty-le-cuoc");
		return mav;

	}

	@RequestMapping(value = "setstatus/{matv}", method = RequestMethod.GET)
	public @ResponseBody
	String setstatus(Model model, @PathVariable("matv") int matv,
			HttpServletRequest request) {
		Long id = (long) matv;
		User user = service.getiduser(id);
		user.setStatusdachuyen(2);
		user.setTiendachuyen((double) 0);
		service.saveRegisteredUser(user);

		return Double.toString(user.getXu());

	}

	@RequestMapping(value = "/dat-lenh-rut-tien/rutxuajax/{xu}/{matv}", method = RequestMethod.GET)
	public @ResponseBody
	String rutxuajax(Model model, @PathVariable("xu") int xu,
			@PathVariable("matv") int matv, HttpServletRequest request) {
		Long id = (long) matv;
		User user = service.getiduser(id);
		Double xus = (double) xu;
		// user.setXu(user.getXu() - xus);
		user.setRuttien(user.getRuttien() - xus);
		user.setStatus(0);
		user.setTiendachuyen(xus + user.getTiendachuyen());
		user.setStatusdachuyen(1);
		service.saveRegisteredUser(user);

		return Double.toString(user.getXu());

	}

	@RequestMapping(value = "/dat-lenh-rut-tien/{matv}", method = RequestMethod.GET)
	public ModelAndView datlenhruttien(@PathVariable("matv") int matv,
			Model model) throws EmailExistsException {

		String resultuser = " ";
		Long id = (long) matv;
		User user = null;
		try {
			user = service.getiduser(id);

		} catch (Exception e) {
			// TODO: handle exception

		}
		model.addAttribute("user", user);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("dat-lenh-rut-tien");
		return mav;

	}

	@RequestMapping(value = "/list-thanh-vien-rut-tien", method = RequestMethod.GET)
	public ModelAndView listruttien(Model model, HttpServletRequest request)
			throws EmailExistsException {
		List<User> alluser = service.getAlluser();
		ArrayList<User> elements = new ArrayList<User>();
		for (User user : alluser) {
			if ((user.getRuttien() > 0) || (user.getTiendachuyen() > 0)) {
				elements.add(user);
			}
		}
		model.addAttribute("elements", elements);
		try {
			HttpSession session = request.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("list-thanh-vien-rut-tien");
		return mav;

	}

	@RequestMapping(value = "/napxuajax/{xu}/{matv}", method = RequestMethod.GET)
	public @ResponseBody
	String napxuajax(Model model, @PathVariable("xu") int xu,
			@PathVariable("matv") int matv, HttpServletRequest request) {
		Long id = (long) matv;
		User user = service.getiduser(id);
		Double xus = (double) xu;
		user.setXu(user.getXu() + xus);

		service.saveRegisteredUser(user);

		return Double.toString(user.getXu()) ;

	}

	@RequestMapping(value = "/timkiem/{matv}", method = RequestMethod.GET)
	public @ResponseBody
	String timkiemthanhvien(Model model, @PathVariable("matv") int matv,
			HttpServletRequest request) {
		String resultuser = " ";
		Long id = (long) matv;
		try {
			User user = service.getiduser(id);
			resultuser = Long.toString(user.getId()) + "," + user.getFullname()
					+ "," + user.getEmail() + "," + user.getPhone() + ","
					+ Double.toString(user.getXu());
		} catch (Exception e) {
			// TODO: handle exception
			resultuser = "0 , 0";
		}

		return resultuser;

	}
	
	@RequestMapping(value = "/napxu", method = RequestMethod.POST)
	public ModelAndView napxupc(Model model, @ModelAttribute("userdto") UserDto userdto, HttpServletRequest request)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);// sesion time out
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		model.addAttribute("user", user);	
		double xu =0 ; 
		try {
			xu = userdto.getXunap();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Admin admin = adminsc.getadmin(1);		
		User userf = null;
		try {
			userf = service.getiduser(userdto.getId());
			
			session.setAttribute("napxuid", userdto.getId());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String napxuid = null;
		try {
			napxuid = (String) session.getAttribute("napxuid");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(userf == null && napxuid == null){
			model.addAttribute("admin", admin);
			model.addAttribute("message", "Không tìm thấy thành viên");
			ModelAndView mav = new ModelAndView("napxu");
			return mav;
		}
		if(userf !=null && xu == 0 ) {
			userdto.setEmail(userf.getEmail());
			userdto.setFirstName(userf.getFirstName());
			userdto.setFullname(userf.getFullname());
			userdto.setId(userf.getId());
			userdto.setLastName(userf.getLastName());
			userdto.setPhone(userf.getPhone());
			userdto.setXu(userf.getXu());
			model.addAttribute("userdto", userdto);		
			model.addAttribute("admin", admin);
			ModelAndView mav = new ModelAndView("napxu");
			return mav;
		}else if(userf !=null || napxuid !=null ) {
			session.removeAttribute("napxuid");
			userf.setXu(userf.getXu() + xu );
			service.saveRegisteredUser(userf);
			userdto.setXu(userdto.getXu() + xu);
			model.addAttribute("userdto", userdto);		
			model.addAttribute("admin", admin);
			model.addAttribute("message", "Nạp xu thành công");
			ModelAndView mav = new ModelAndView("napxu");			
			return mav;
		}
		return null;
		
		
		

	}
	

	@RequestMapping(value = "/napxu", method = RequestMethod.GET)
	public ModelAndView napxu(Model model, HttpServletRequest request)
			throws EmailExistsException {
		try {
			HttpSession session = request.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		UserDto userdto = new UserDto();
		//userdto.setXu((double) 0);
		model.addAttribute("userdto", userdto);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("napxu");
		return mav;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(Model model, HttpServletRequest request)
			throws EmailExistsException {
		List<User> alluser = service.getAlluser();
		model.addAttribute("alluser", alluser);
		try {
			HttpSession session = request.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("admin");
		return mav;

	}

	@RequestMapping(value = "/broweroff", method = RequestMethod.GET)
	public @ResponseBody
	String broweroff(Model model, HttpServletRequest request)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		//System.out.println("co vao");
		// NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
		// Phong phong = phongsc.getPhong(nguoichoi.getMaBan());
		// nguoiChoisc.deleteNguoiChoi(nguoichoi);
		// phongsc.deletePhong(phong);
		try {
			String isnhacai = (String) session.getAttribute("isnhacai");
			if (isnhacai.equals(username)) {
				NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
				nguoiChoisc.deleteNguoiChoi(nguoichoi);
				session.removeAttribute("isnhacai");
				int maphong = (Integer) session.getAttribute("maphong");

				session.removeAttribute("maphong");
				Phong phong = phongsc.getPhong(maphong);
				Admin admin = adminsc.getadmin(1);
				phongsc.deletePhong(phong);
				myarray.put(maphong, admin.getGiay());
				//myarray.set(maphong, admin.getGiay());
				isclose.put(maphong, 0);
				//isclose.set(maphong, 0);
				// isbancua.remove(maphong);
				List<DatCuoc> listdatcuoc = datcuocsc
						.getAlldatcuocbyban(maphong);

				for (DatCuoc datcuoc : listdatcuoc) {
					datcuocsc.deleDatCuoc(datcuoc);

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			int maphong = (Integer) session.getAttribute("maphong");

			session.removeAttribute("maphong");
			Phong phong = phongsc.getPhong(maphong);
			phong.setSoChoi(phong.getSoChoi() - 1);
			phongsc.savePhong(phong);
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);

			datcuocsc.deleteDatCuoc(datcuoc);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@RequestMapping(value = "/isbancua", method = RequestMethod.GET)
	public @ResponseBody
	String checkbancua(Model model, HttpServletRequest request) {
		int close = 0;
		String kq = " ";
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		DatCuoc datcuoc = null;
		Double cua1 = (double) 0;
		Double cua2 = (double) 0;
		Double cua3 = (double) 0;
		Double cua4 = (double) 0;
		Double cua5 = (double) 0;
		Double cua6 = (double) 0;
		Double xu = (double) 0;
		try {
			datcuoc = datcuocsc.getDatCuoc(username);

			cua1 = datcuoc.getChan();
			cua2 = datcuoc.getLe();
			cua3 = datcuoc.get_4den();
			cua4 = datcuoc.get_1trang3den();
			cua5 = datcuoc.get_1den3trang();
			cua6 = datcuoc.get_4trang();
			xu = datcuoc.getTongxu();
		} catch (Exception e) {
			// TODO: handle exception

		}
		kq = cua1.intValue() + "," + cua2.intValue() + "," + cua3.intValue()
				+ "," + cua4.intValue() + "," + cua5.intValue() + ","
				+ cua6.intValue() + "," + xu.intValue();
		return kq;

	}

	@RequestMapping(value = "/xunhacaiload", method = RequestMethod.GET)
	public @ResponseBody
	String xunhacaiload(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		Double xu = user.getXu();
		return "" + user.getXu().intValue();

	}

	// private static int isclose =0 ;

	@RequestMapping(value = "/isclose", method = RequestMethod.GET)
	public @ResponseBody
	String iscloseex(Model model, HttpServletRequest request) {

		int close = 0;
		String kq = " ";
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		DatCuoc datcuoc = null;
		try {
			datcuoc = datcuocsc.getDatCuoc(username);
			close = (Integer) isclose.get(datcuoc.getMaBan());

		} catch (Exception e) {
			// TODO: handle exception

		}
		try {
			kq = Integer.toString(close) + "," + datcuoc.getTongxu().intValue();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return kq;

	}

	@RequestMapping(value = "/settime", method = RequestMethod.GET)
	public @ResponseBody
	String settime(Model model, HttpServletRequest request)
			throws EmailExistsException {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		Admin admin = adminsc.getadmin(1);
		try {
			String isnhacai = (String) session.getAttribute("isnhacai");
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(isnhacai);

			if (username.equals(isnhacai)) {
				myarray.put(nguoichoi.getMaBan(), admin.getGiay());

				//myarray.add(nguoichoi.getMaBan(), admin.getGiay());
				isclose.put(nguoichoi.getMaBan(), 1);
				List<DatCuoc> datcuocs = datcuocsc.getAlldatcuocbyban(nguoichoi
						.getMaBan());
				for (DatCuoc datCuoc2 : datcuocs) {
					datCuoc2.set_1den3trang((double) 0);
					datCuoc2.set_1trang3den((double) 0);
					datCuoc2.set_4den((double) 0);
					datCuoc2.set_4trang((double) 0);
					datCuoc2.setChan((double) 0);
					datCuoc2.setLe((double) 0);
					datcuocsc.saveDatcuoc(datCuoc2);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	@RequestMapping(value = "/checktt", method = RequestMethod.GET)
	public @ResponseBody
	String checktt(Model model, HttpServletRequest request)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		return Integer.toString(user.getXu().intValue());

	}

	@RequestMapping(value = "/getnumber", method = RequestMethod.GET)
	public @ResponseBody
	String getnumberxx(Model model, HttpServletRequest request)
			throws EmailExistsException {
		Random rand = new Random();

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		result = "";
		try {
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
			String isnhacai = (String) session.getAttribute("isnhacai");
			if (username.equals(isnhacai)) {
				
				String value = "";
				
				for (int i = 0; i <= 3; i++) {
					int n = rand.nextInt(2);
					
					value = value + "," + n;
					//.out.println(n);
					
				}
				
				xucxac.put(nguoichoi.getMaBan(), value);
				tinhTien(nguoichoi.getMaBan());
				
			}
			 String[] chuoi = xucxac.get(nguoichoi.getMaBan()).split(",");
			 for (String xx : chuoi) {
				
				 if (xx.equals("1")) {
						result = result + "<div class=\"hotxucxac" + xx
								+ " hotden\"></div>";
					} else if(xx.equals("0")) {
						result = result + "<div class=\"hotxucxac" + xx
								+ " hottrang\"></div>";
					}
			}
			 return result;
		} catch (Exception e) {

		}
		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
			String[] chuoi = xucxac.get(datcuoc.getMaBan()).split(",");
			for (String xx : chuoi) {
				// System.out.println(xx);
				 if (xx.equals("1")) {
						result = result + "<div class=\"hotxucxac" + xx
								+ " hotden\"></div>";
					} else if(xx.equals("0")) {
						result = result + "<div class=\"hotxucxac" + xx
								+ " hottrang\"></div>";
					}
			}
			 return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;

	}

	public void tinhTien(int maban) throws EmailExistsException {
	
		List<DatCuoc> datcuocs = datcuocsc.getAlldatcuocbyban(maban);
		Admin admin = adminsc.getadmin(1);
		for (DatCuoc datCuoc : datcuocs) {

		}
		double nhacaithang = (double) 0;
		double nhacaithua = (double) 0;
		if (_1den3trang(maban)) {
			
			for (DatCuoc datCuoc : datcuocs) {
				nhacaithua += datCuoc.get_1den3trang() * admin.get_1den3trang()
						+ datCuoc.getLe() * admin.getLe();
				nhacaithang += datCuoc.get_1trang3den() + datCuoc.get_4den()
						+ datCuoc.get_4trang() + datCuoc.getChan();
				
				double nhaconthang = datCuoc.get_1den3trang()
						* admin.get_1den3trang() + datCuoc.getLe()
						* admin.getLe();
				nhaconthang = datCuoc.get_1den3trang() +datCuoc.getLe() + nhaconthang ;
				User user = service.getEuser(datCuoc.getEmail());
				double xucu = user.getXu();
				double xumoi = datCuoc.getTongxu() +nhaconthang ;
				if(xucu >=xumoi ){
					//System.out.println("thua");
					xumoi = xumoi*100;
					xumoi = Math.floor(xumoi);
					xumoi = xumoi/100;
					datCuoc.setTongxu(xumoi);
				}else {
					//System.out.println("thang");
					double hoahong = (xumoi - xucu)*admin.getHoahong()/100;
					//System.out.println(hoahong);
					double tongcong = xumoi - hoahong;
					//System.out.println(tongcong);
					tongcong = tongcong*100;
					tongcong = Math.floor(tongcong);
					tongcong = tongcong/100;
				//	System.out.println(tongcong);
					datCuoc.setTongxu(tongcong);
				}
				
				

				datcuocsc.saveDatcuoc(datCuoc);

				
				user.setXu(datCuoc.getTongxu());
				service.saveRegisteredUser(user);
			}

		}

		if (_1trang3den(maban)) {
			for (DatCuoc datCuoc : datcuocs) {
				nhacaithua += datCuoc.get_1trang3den() * admin.get_1trang3den()
						+ datCuoc.getLe() * admin.getLe();
				nhacaithang += datCuoc.get_1den3trang() + datCuoc.get_4den()
						+ datCuoc.get_4trang() + datCuoc.getChan();
				
				double nhaconthang = datCuoc.get_1trang3den()
						* admin.get_1trang3den() + datCuoc.getLe()
						* admin.getLe();
				nhaconthang = datCuoc.get_1trang3den() +datCuoc.getLe() + nhaconthang ;
				User user = service.getEuser(datCuoc.getEmail());
				double xucu = user.getXu();
				double xumoi = datCuoc.getTongxu() +nhaconthang ;
				if(xucu >=xumoi ){
					//System.out.println("thua");
					xumoi = xumoi*100;
					xumoi = Math.floor(xumoi);
					xumoi = xumoi/100;
					datCuoc.setTongxu(xumoi);
				}else {
					//System.out.println("thang");
					double hoahong = (xumoi - xucu)*admin.getHoahong()/100;
					//System.out.println(hoahong);
					double tongcong = xumoi - hoahong;
					//System.out.println(tongcong);
					tongcong = tongcong*100;
					tongcong = Math.floor(tongcong);
					tongcong = tongcong/100;
				//	System.out.println(tongcong);
					datCuoc.setTongxu(tongcong);
				}
				
				

				datcuocsc.saveDatcuoc(datCuoc);

				
				user.setXu(datCuoc.getTongxu());
				service.saveRegisteredUser(user);
			}

		}
		
		if (_4den(maban)) {
			for (DatCuoc datCuoc : datcuocs) {
				nhacaithua += datCuoc.get_4den() * admin.get_4den()
						+ datCuoc.getChan() * admin.getChan();
				nhacaithang += datCuoc.get_1den3trang() + datCuoc.get_1trang3den()
						+ datCuoc.get_4trang() + datCuoc.getLe();
				
				double nhaconthang = datCuoc.get_4den()
						* admin.get_4den() + datCuoc.getChan()
						* admin.getChan();
				nhaconthang = datCuoc.get_4den() +datCuoc.getChan() + nhaconthang ;
				User user = service.getEuser(datCuoc.getEmail());
				double xucu = user.getXu();
				double xumoi = datCuoc.getTongxu() +nhaconthang ;
				if(xucu >=xumoi ){
					//System.out.println("thua");
					xumoi = xumoi*100;
					xumoi = Math.floor(xumoi);
					xumoi = xumoi/100;
					datCuoc.setTongxu(xumoi);
				}else {
					//System.out.println("thang");
					double hoahong = (xumoi - xucu)*admin.getHoahong()/100;
					//System.out.println(hoahong);
					double tongcong = xumoi - hoahong;
					//System.out.println(tongcong);
					tongcong = tongcong*100;
					tongcong = Math.floor(tongcong);
					tongcong = tongcong/100;
				//	System.out.println(tongcong);
					datCuoc.setTongxu(tongcong);
				}
				
				

				datcuocsc.saveDatcuoc(datCuoc);

				
				user.setXu(datCuoc.getTongxu());
				service.saveRegisteredUser(user);
			}
		}
		
		if (_4trang(maban)) {
			for (DatCuoc datCuoc : datcuocs)  {
				nhacaithua += datCuoc.get_4trang() * admin.get_4trang()
						+ datCuoc.getChan() * admin.getChan();
				nhacaithang += datCuoc.get_1den3trang() + datCuoc.get_1trang3den()
						+ datCuoc.get_4den() + datCuoc.getLe();
				
				double nhaconthang = datCuoc.get_4trang()
						* admin.get_4trang() + datCuoc.getChan()
						* admin.getChan();
				nhaconthang = datCuoc.get_4trang() +datCuoc.getChan() + nhaconthang ;
				User user = service.getEuser(datCuoc.getEmail());
				double xucu = user.getXu();
				double xumoi = datCuoc.getTongxu() +nhaconthang ;
				if(xucu >=xumoi ){
					//System.out.println("thua");
					xumoi = xumoi*100;
					xumoi = Math.floor(xumoi);
					xumoi = xumoi/100;
					datCuoc.setTongxu(xumoi);
				}else {
					//System.out.println("thang");
					double hoahong = (xumoi - xucu)*admin.getHoahong()/100;
					//System.out.println(hoahong);
					double tongcong = xumoi - hoahong;
					//System.out.println(tongcong);
					tongcong = tongcong*100;
					tongcong = Math.floor(tongcong);
					tongcong = tongcong/100;
				//	System.out.println(tongcong);
					datCuoc.setTongxu(tongcong);
				}
				
				

				datcuocsc.saveDatcuoc(datCuoc);

				
				user.setXu(datCuoc.getTongxu());
				service.saveRegisteredUser(user);
			}

		}
				
		if (_2trang2den(maban)) {
			for (DatCuoc datCuoc : datcuocs)  {
				nhacaithua += datCuoc.getChan() * admin.getChan();
						 
				nhacaithang += datCuoc.get_1den3trang() + datCuoc.get_1trang3den()
						+ datCuoc.get_4den() + datCuoc.getLe() + datCuoc.get_4trang();
				
				double nhaconthang =  datCuoc.getChan()*admin.getChan();
				nhaconthang = datCuoc.getChan()  + nhaconthang ;
				User user = service.getEuser(datCuoc.getEmail());
				double xucu = user.getXu();
				double xumoi = datCuoc.getTongxu() +nhaconthang ;
				if(xucu >=xumoi ){
					//System.out.println("thua");
					xumoi = xumoi*100;
					xumoi = Math.floor(xumoi);
					xumoi = xumoi/100;
					datCuoc.setTongxu(xumoi);
				}else {
					//System.out.println("thang");
					double hoahong = (xumoi - xucu)*admin.getHoahong()/100;
					//System.out.println(hoahong);
					double tongcong = xumoi - hoahong;
					//System.out.println(tongcong);
					tongcong = tongcong*100;
					tongcong = Math.floor(tongcong);
					tongcong = tongcong/100;
				//	System.out.println(tongcong);
					datCuoc.setTongxu(tongcong);
				}
				
				

				datcuocsc.saveDatcuoc(datCuoc);

				
				user.setXu(datCuoc.getTongxu());
				service.saveRegisteredUser(user);
			}

		}
		
		NguoiChoi nguoichoi = nguoiChoisc.findnguoichoiByMB(maban);

		User user = service.getEuser(nguoichoi.getEmail());
		//System.out.println(nhacaithang);
		//System.out.println(nhacaithua);
		Double tienNhaCai = nhacaithang - nhacaithua;
		if(tienNhaCai <=0){
			//System.out.println("thua");
			tienNhaCai = tienNhaCai*100;
			
			tienNhaCai = Math.floor(tienNhaCai);
		
			tienNhaCai = tienNhaCai/100;
			user.setXu(user.getXu() + tienNhaCai);
		}else {
			//System.out.println("thang");
			double hoahong =  tienNhaCai*admin.getHoahong()/100;
			double tongcong = tienNhaCai - hoahong;
			tongcong = tongcong*100;
			
			tongcong = Math.floor(tongcong);
		
			tongcong = tongcong/100;
			user.setXu(user.getXu() + tongcong);
		}
		
		
		
		
		service.saveRegisteredUser(user);

	}

	public boolean _2trang2den(int maban) {
		int den = 0;
		int trang = 0;
		String[] chuoi = xucxac.get(maban).split(",");
		for (String xx : chuoi) {
			 if (xx.equals("1")) {
				 den += 1;
				} else if(xx.equals("0")) {
					trang += 1;
				}
		}
		
		if (den == 2 && trang == 2) {
			return true;
		}

		return false;

	}

	public boolean _1trang3den(int maban) {
		int den = 0;
		int trang = 0;
		String[] chuoi = xucxac.get(maban).split(",");
		for (String xx : chuoi) {
			 if (xx.equals("1")) {
				 den += 1;
				} else if(xx.equals("0")) {
					trang += 1;
				}
		}
		if (den == 3 && trang == 1) {
			return true;
		}

		return false;

	}

	public boolean _1den3trang(int maban) {
		//System.out.println(maban);
		int den = 0;
		int trang = 0;
		String[] chuoi = xucxac.get(maban).split(",");
		for (String xx : chuoi) {
			 if (xx.equals("1")) {
				 den += 1;
				} else if(xx.equals("0")) {
					trang += 1;
				}
		}
		//System.out.println(den);
		//System.out.println(trang);
		if (den == 1 && trang == 3) {
			return true;
		}

		return false;

	}
	
	public boolean _4trang(int maban) {
		int den = 0;
		int trang = 0;
		String[] chuoi = xucxac.get(maban).split(",");
		for (String xx : chuoi) {
			 if (xx.equals("1")) {
				 den += 1;
				} else if(xx.equals("0")) {
					trang += 1;
				}
		}
		if (den == 0 && trang == 4) {
			return true;
		}

		return false;

	}
	
	public boolean _4den(int maban) {
		int den = 0;
		int trang = 0;
		String[] chuoi = xucxac.get(maban).split(",");
		for (String xx : chuoi) {
			 if (xx.equals("1")) {
				 den += 1;
				} else if(xx.equals("0")) {
					trang += 1;
				}
		}
		if (den == 4 && trang == 0) {
			return true;
		}

		return false;

	}
	
	

	@RequestMapping(value = "/gettime", method = RequestMethod.GET)
	public @ResponseBody
	String gettime(Model model, HttpServletRequest request) {// (a % 2)
		int time = 0;
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");

		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
			time = (Integer) myarray.get(datcuoc.getMaBan());
			//System.out.println(time);
		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			String isnhacai = (String) session.getAttribute("isnhacai");
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(isnhacai);

			if (username.equals(isnhacai)) {
				isclose.put(nguoichoi.getMaBan(), 0);
				time = (Integer) myarray.get(nguoichoi.getMaBan());
				if (time <= 0) {
					myarray.put(nguoichoi.getMaBan(), 0);

				} else {
					myarray.put(nguoichoi.getMaBan(), time - 1);
				}
				if (time == 10) {
					// isbancua.set(nguoichoi.getMaBan(), 0);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		int giay = time % 60;
		int phut = time / 60;
		String result = phut + "," + giay;

		return result;

	}

	@RequestMapping(value = "/nhacaiload", method = RequestMethod.GET)
	public @ResponseBody
	String nhacaiload(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		int maban = 0;
		boolean isnhacai = false;
		try {
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
			maban = nguoichoi.getMaBan();
			isnhacai = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
			maban = datcuoc.getMaBan();

		} catch (Exception e) {
			// TODO: handle exception
		}

		String result = "";
		List<DatCuoc> alldatcuoc = datcuocsc.getAlldatcuoc();
		if (alldatcuoc.isEmpty()) {
			for (int i = 0; i < 9; i++) {
				result = result + "<span class=\"no-acc\"></span> " + ",";
			}
			result = result + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + ","
					+ 0;
			return result;

		}
		Double cua1 = (double) 0;
		Double cua2 = (double) 0;
		Double cua3 = (double) 0;
		Double cua4 = (double) 0;
		Double cua5 = (double) 0;
		Double cua6 = (double) 0;

		int count = 0;

		for (DatCuoc datcuoc : alldatcuoc) {
			try {
				if (datcuoc.getMaBan() == maban) {
					User userdt = service.getEuser(datcuoc.getEmail());
					count += 1;
					String img = "http://xocdia123.com" +userdt.getLastName();
					//System.out.println(img);
					if (isnhacai == true) {
						//System.out.println(img);
						result = result
								+

								"<div>"
								+ "<span class=\"name-acc\">"
								+ userdt.getFirstName()
								+ "</span>"
								+ "<img src=\""
								+ img
								+ "\""
								+ "alt=\"\">"
								+ "<span class=\"monney-acc\">"
								+ datcuoc.getTongxu().intValue()
								+ "</span>"
								+ "<span onclick=\"roiphong("
								+ datcuoc.getId()
								+ ")\" class=\"delete-acc\" title=\"Click khỏi phòng\"><i class=\"fa fa-power-off fa-2x\"></i></span>"
								+ "</div>" + ","

						;
					} else {
						//System.out.println(img);
						result = result +

						"<div>" + "<span class=\"name-acc\">"
								+ userdt.getFirstName() + "</span>"
								+ "<img src=\"" + img + "\"" + "alt=\"\">"
								+ "<span class=\"monney-acc\">"
								+ datcuoc.getTongxu().intValue() + "</span>"
								+ "</div>" + ","

						;
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		for (int i = 0; i < (9 - count); i++) {
			result = result + "<span class=\"no-acc\"></span> " + ",";
		}

		for (DatCuoc datcuoc : alldatcuoc) {
			try {
				if (datcuoc.getMaBan() == maban) {
					User userdt = service.getEuser(datcuoc.getEmail());
					cua1 += datcuoc.getChan();
					cua2 += datcuoc.getLe();
					cua3 += datcuoc.get_4den();
					cua4 += datcuoc.get_1trang3den();
					cua5 += datcuoc.get_1den3trang();
					cua6 += datcuoc.get_4trang();

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		result = result + cua1.intValue() + "," + cua2.intValue() + ","
				+ cua3.intValue() + "," + cua4.intValue() + ","
				+ cua5.intValue() + "," + cua6.intValue();
		return result;

	}

	@RequestMapping(value = "/nha-cai", method = RequestMethod.GET)
	public ModelAndView nhaCai(HttpServletRequest request, Model model)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("user", user);
		int giay = admin.getGiay() % 60;
		int phut = admin.getGiay() / 60;
		model.addAttribute("giay", giay);
		model.addAttribute("phut", phut);
		//AdminDto admindto = new AdminDto();
		TiLeDto tyLe = new TiLeDto();
		
		
		if(admin.get_4den()%1 ==0){
			tyLe.setBonden(Integer.toString(admin.get_4den().intValue()));
		}else {
			tyLe.setBonden(Double.toString(admin.get_4den()));
		}
		
		if(admin.get_4trang()%1 ==0){
			tyLe.setBontrang(Integer.toString(admin.get_4trang().intValue()));
		}else {
			tyLe.setBontrang(Double.toString(admin.get_4trang()));
		}
		
		if(admin.getChan()%1 ==0){
			tyLe.setChan(Integer.toString(admin.getChan().intValue()));
		}else {
			tyLe.setChan(Double.toString(admin.getChan()));
		}
		
		if(admin.get_1den3trang()%1 ==0){
			tyLe.setDenbatrang(Integer.toString(admin.get_1den3trang().intValue()));
		}else {
			tyLe.setDenbatrang(Double.toString(admin.get_1den3trang()));
		}
		
		if(admin.get_1trang3den()%1 ==0){
			tyLe.setTragbaden(Integer.toString(admin.get_1trang3den().intValue()));
		}else {
			tyLe.setTragbaden(Double.toString(admin.get_1trang3den()));
		}
		

		if(admin.getLe()%1 ==0){
			tyLe.setCuale(Integer.toString(admin.getLe().intValue()));
		}else {
			tyLe.setCuale(Double.toString(admin.getLe()));
		}
		
		
		//tyLe.setBontrang(admin.get_4trang());
		//tyLe.setChan(admin.getChan());
		//tyLe.setDenbatrang(admin.get_1den3trang());
		//tyLe.setTragbaden(admin.get_1trang3den());
		//tyLe.setCuale(admin.getLe());
		
		model.addAttribute("admindto", tyLe);
		
		ModelAndView mav = new ModelAndView("nha-cai");
		return mav;
	}

	@RequestMapping(value = "/bancua/{biencua}", method = RequestMethod.GET)
	public @ResponseBody
	String bancua(Model model, @PathVariable("biencua") int biencua,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		Double rollback = (double) 0;

		NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);

		List<DatCuoc> datcuocs = datcuocsc.getAlldatcuocbyban(nguoichoi
				.getMaBan());
		// isbancua.set(0, 1);
		// isbancua.set(nguoichoi.getMaBan(), 1);
		for (DatCuoc datcuoc : datcuocs) {

			switch (biencua) {
			case 1:
				rollback = datcuoc.getChan();
				datcuoc.setChan((double) 0);
				break;
			case 2:
				rollback = datcuoc.getLe();
				datcuoc.setLe((double) 0);

				break;
			case 3:
				rollback = datcuoc.get_4den();
				datcuoc.set_4den((double) 0);

				break;
			case 4:
				rollback = datcuoc.get_1trang3den();
				datcuoc.set_1trang3den((double) 0);

				break;
			case 5:
				rollback = datcuoc.get_1trang3den();
				datcuoc.set_1den3trang((double) 0);

				break;
			case 6:
				rollback = datcuoc.get_4trang();
				datcuoc.set_4trang((double) 0);

				break;
			}
			datcuoc.setTongxu(datcuoc.getTongxu() + rollback);

			datcuocsc.saveDatcuoc(datcuoc);

		}

		return "ok";

	}

	@RequestMapping(value = "/ajaxhuy/{biencua}/{var}", method = RequestMethod.GET)
	public @ResponseBody
	String huyxu(Model model, @PathVariable("biencua") int biencua,
			@PathVariable("var") int var, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		Double rollback = (double) 0;
		if (datcuocsc.isDatCuoc(username) == true) {
			if (var == 0) {
				DatCuoc datcuoc = datcuocsc.getDatCuoc(username);

				switch (biencua) {
				case 1:
					rollback = datcuoc.getChan();
					datcuoc.setChan((double) 0);
					break;
				case 2:
					rollback = datcuoc.getLe();
					datcuoc.setLe((double) 0);

					break;
				case 3:
					rollback = datcuoc.get_4den();
					datcuoc.set_4den((double) 0);

					break;
				case 4:
					rollback = datcuoc.get_1trang3den();
					datcuoc.set_1trang3den((double) 0);

					break;
				case 5:
					rollback = datcuoc.get_1trang3den();
					datcuoc.set_1den3trang((double) 0);

					break;
				case 6:
					rollback = datcuoc.get_4trang();
					datcuoc.set_4trang((double) 0);

					break;
				}
				datcuoc.setTongxu(datcuoc.getTongxu() + rollback);

				datcuocsc.saveDatcuoc(datcuoc);
			} else {
				DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
				rollback += datcuoc.getChan() + datcuoc.getLe()
						+ datcuoc.get_4den() + datcuoc.get_1trang3den()
						+ datcuoc.get_1den3trang() + datcuoc.get_4trang();

				datcuoc.setChan((double) 0);

				datcuoc.setLe((double) 0);

				datcuoc.set_4den((double) 0);

				datcuoc.set_1trang3den((double) 0);

				datcuoc.set_1den3trang((double) 0);

				datcuoc.set_4trang((double) 0);
				datcuoc.setTongxu(datcuoc.getTongxu() + rollback);
				datcuocsc.saveDatcuoc(datcuoc);
			}
		}

		// user.setXu(user.getXu() + rollback);

		// service.saveRegisteredUser(user);
		DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
		String result = Integer.toString(0) + ","
				+ datcuoc.getTongxu().intValue();
		return result;
	}

	public boolean checkxu(int maban, double xu, int biencua)
			throws EmailExistsException {
		List<DatCuoc> datcuocs = datcuocsc.getAlldatcuocbyban(maban);
		Admin admin = adminsc.getadmin(1);
		double[] values = new double[6];

		for (DatCuoc datCuoc : datcuocs) {

			values[0] += datCuoc.get_1den3trang() * admin.get_1den3trang();
			values[1] += datCuoc.get_1trang3den() * admin.get_1trang3den();
			values[2] += datCuoc.get_4den() * admin.get_4den();
			values[3] += datCuoc.get_4trang() * admin.get_4trang();
			values[4] += datCuoc.getChan() * admin.getChan();
			values[5] += datCuoc.getLe() * admin.getLe();
		}
		double max = values[0];
		for (int i = 0; i < 4; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}

		double max2 = values[4];
		for (int i = 4; i < 6; i++) {
			if (values[i] > max2) {
				max2 = values[i];
			}
		}
		double sum = 0;

		switch (biencua) {
		case 1:
			sum = max + max2 + xu * admin.getChan();

			break;
		case 2:
			sum = max + max2 + xu * admin.getLe();

			break;
		case 3:
			sum = max + max2 + xu * admin.get_4den();

			break;
		case 4:
			sum = max + max2 + xu * admin.get_1trang3den();

			break;
		case 5:
			sum = max + max2 + xu * admin.get_1den3trang();

			break;
		case 6:
			sum = max + max2 + xu * admin.get_4trang();

			break;
		}

		NguoiChoi nguoichoi = nguoiChoisc.findnguoichoiByMB(maban);
		User user = service.getEuser(nguoichoi.getEmail());

		if (user.getXu() >= sum) {
			return true;
		}

		return false;

	}

	@RequestMapping(value = "/ajaxxu/{biencua}/{xu}", method = RequestMethod.GET)
	public @ResponseBody
	String setxu(Model model, @PathVariable("biencua") int biencua,
			@PathVariable("xu") Double xu, HttpServletRequest request)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
		String result = " ";

		if (checkxu(datcuoc.getMaBan(), xu, biencua) == false) {
			result = Integer.toString(2) + "," + datcuoc.getTongxu().intValue();
			return result;
		}

		if (datcuoc.getTongxu() < xu) {

			result = Integer.toString(0) + "," + datcuoc.getTongxu().intValue();
			return result;
		}
		Double resurls = (double) 0;
		/*
		 * if (datcuocsc.isDatCuoc(username) == false) { DatCuocDto datcuocdto =
		 * new DatCuocDto(); datcuocdto.setEmail(username); switch (biencua) {
		 * case 1: datcuocdto.setChan(xu); break; case 2: datcuocdto.setLe(xu);
		 * break; case 3: datcuocdto.set_4den(xu); break; case 4:
		 * datcuocdto.set_1trang3den(xu); break; case 5:
		 * datcuocdto.set_1den3trang(xu); break; case 6:
		 * datcuocdto.set_4trang(xu); break; }
		 * 
		 * datcuocdto.setTongxu(user.getXu() - xu);
		 * datcuocdto.setMaBan((Integer) session.getAttribute("maphong")); try {
		 * //datcuocsc.createNewDatCuoc(datcuocdto);
		 * datcuocsc.saveDatcuoc(datcuoc); resurls = xu; result =
		 * Integer.toString(resurls) + "," +
		 * Long.toString(datcuocdto.getTongxu());
		 * 
		 * } catch (EmailExistsException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } else {
		 */

		switch (biencua) {
		case 1:
			datcuoc.setChan(datcuoc.getChan() + xu);

			resurls = datcuoc.getChan();

			break;
		case 2:
			datcuoc.setLe(datcuoc.getLe() + xu);

			resurls = datcuoc.getLe();
			break;
		case 3:
			datcuoc.set_4den(datcuoc.get_4den() + xu);

			resurls = datcuoc.get_4den();
			break;
		case 4:
			datcuoc.set_1trang3den(datcuoc.get_1trang3den() + xu);

			resurls = datcuoc.get_1trang3den();
			break;
		case 5:
			datcuoc.set_1den3trang(datcuoc.get_1den3trang() + xu);

			resurls = datcuoc.get_1den3trang();
			break;
		case 6:
			datcuoc.set_4trang(datcuoc.get_4trang() + xu);

			resurls = datcuoc.get_4trang();
			break;
		}
		datcuoc.setTongxu(datcuoc.getTongxu() - xu);
		// user.setXu(user.getXu() - xu);
		// service.saveRegisteredUser(user);
		datcuocsc.saveDatcuoc(datcuoc);

		result = resurls.intValue() + "," + datcuoc.getTongxu().intValue();
		//System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/tao-phong", method = RequestMethod.POST)
	public ModelAndView taoPhongpc(@ModelAttribute("phong") PhongDto phongdto,
			HttpServletRequest request, Model model)
			throws EmailExistsException {
		Admin admin = adminsc.getadmin(1);
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		// session.setAttribute("maphong", maphong);
		try {
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
			if (nguoichoi.getEmail().equals(username)) {
				int giay = admin.getGiay() % 60;
				int phut = admin.getGiay() / 60;
				model.addAttribute("giay", giay);
				model.addAttribute("phut", phut);
				// Admin admin = adminsc.getadmin(1);
				model.addAttribute("admin", admin);
				TiLeDto tyLe = new TiLeDto();
				
				
				if(admin.get_4den()%1 ==0){
					tyLe.setBonden(Integer.toString(admin.get_4den().intValue()));
				}else {
					tyLe.setBonden(Double.toString(admin.get_4den()));
				}
				
				if(admin.get_4trang()%1 ==0){
					tyLe.setBontrang(Integer.toString(admin.get_4trang().intValue()));
				}else {
					tyLe.setBontrang(Double.toString(admin.get_4trang()));
				}
				
				if(admin.getChan()%1 ==0){
					tyLe.setChan(Integer.toString(admin.getChan().intValue()));
				}else {
					tyLe.setChan(Double.toString(admin.getChan()));
				}
				
				if(admin.get_1den3trang()%1 ==0){
					tyLe.setDenbatrang(Integer.toString(admin.get_1den3trang().intValue()));
				}else {
					tyLe.setDenbatrang(Double.toString(admin.get_1den3trang()));
				}
				
				if(admin.get_1trang3den()%1 ==0){
					tyLe.setTragbaden(Integer.toString(admin.get_1trang3den().intValue()));
				}else {
					tyLe.setTragbaden(Double.toString(admin.get_1trang3den()));
				}
				

				if(admin.getLe()%1 ==0){
					tyLe.setCuale(Integer.toString(admin.getLe().intValue()));
				}else {
					tyLe.setCuale(Double.toString(admin.getLe()));
				}
				
				
				//tyLe.setBontrang(admin.get_4trang());
				//tyLe.setChan(admin.getChan());
				//tyLe.setDenbatrang(admin.get_1den3trang());
				//tyLe.setTragbaden(admin.get_1trang3den());
				//tyLe.setCuale(admin.getLe());
				
				model.addAttribute("admindto", tyLe);
				
				ModelAndView mav = new ModelAndView("phong");
				return mav;

			}
		} catch (Exception e) {

		}
		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
			if (datcuoc.getEmail().equals(username)) {
				model.addAttribute(datcuoc);
				int giay = admin.getGiay() % 60;
				int phut = admin.getGiay() / 60;
				model.addAttribute("giay", giay);
				model.addAttribute("phut", phut);
				// Admin admin = adminsc.getadmin(1);
				model.addAttribute("admin", admin);
				TiLeDto tyLe = new TiLeDto();
				
				
				if(admin.get_4den()%1 ==0){
					tyLe.setBonden(Integer.toString(admin.get_4den().intValue()));
				}else {
					tyLe.setBonden(Double.toString(admin.get_4den()));
				}
				
				if(admin.get_4trang()%1 ==0){
					tyLe.setBontrang(Integer.toString(admin.get_4trang().intValue()));
				}else {
					tyLe.setBontrang(Double.toString(admin.get_4trang()));
				}
				
				if(admin.getChan()%1 ==0){
					tyLe.setChan(Integer.toString(admin.getChan().intValue()));
				}else {
					tyLe.setChan(Double.toString(admin.getChan()));
				}
				
				if(admin.get_1den3trang()%1 ==0){
					tyLe.setDenbatrang(Integer.toString(admin.get_1den3trang().intValue()));
				}else {
					tyLe.setDenbatrang(Double.toString(admin.get_1den3trang()));
				}
				
				if(admin.get_1trang3den()%1 ==0){
					tyLe.setTragbaden(Integer.toString(admin.get_1trang3den().intValue()));
				}else {
					tyLe.setTragbaden(Double.toString(admin.get_1trang3den()));
				}
				

				if(admin.getLe()%1 ==0){
					tyLe.setCuale(Integer.toString(admin.getLe().intValue()));
				}else {
					tyLe.setCuale(Double.toString(admin.getLe()));
				}
				
				
				//tyLe.setBontrang(admin.get_4trang());
				//tyLe.setChan(admin.getChan());
				//tyLe.setDenbatrang(admin.get_1den3trang());
				//tyLe.setTragbaden(admin.get_1trang3den());
				//tyLe.setCuale(admin.getLe());
				
				model.addAttribute("admindto", tyLe);
				ModelAndView mav = new ModelAndView("phong");
				return mav;

			}

		} catch (Exception e) {

		}

		if (phongdto.getXuToiThieu() < 0) {
			model.addAttribute("error", "vui lòng nhấp số xu tối thiểu");
			return taoPhong(request, model);
		}

		if (phongdto.getXuToiThieu() > user.getXu()) {
			model.addAttribute("error", "bạn không đủ xu trong tài khoản");
			return taoPhong(request, model);
		}

		if (phongdto.getXuToiThieu() > 1000) {
			phongdto.setLoaiBan(1);
		} else {
			phongdto.setLoaiBan(0);
		}

		phongdto.setSoChoi(1);
		NguoiChoiDto nguoiChoidto = new NguoiChoiDto();

		nguoiChoidto.setMaBan(phongdto.getMaBan());
		nguoiChoidto.setNguoiChoi(user.getEmail());

		nguoiChoisc.createNewPhong(nguoiChoidto);
		phongsc.createNewPhong(phongdto);
		session.setAttribute("isnhacai", username);
		session.setAttribute("maphong", phongdto.getMaBan());
		myarray.put(0, 0);
		try {
			myarray.put(phongdto.getMaBan(), admin.getGiay());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		isclose.put(0, 0);
		isclose.put(phongdto.getMaBan(), 1);
		int giay = admin.getGiay() % 60;
		int phut = admin.getGiay() / 60;
		model.addAttribute("giay", giay);
		model.addAttribute("phut", phut);
		// Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
TiLeDto tyLe = new TiLeDto();
		
		
		if(admin.get_4den()%1 ==0){
			tyLe.setBonden(Integer.toString(admin.get_4den().intValue()));
		}else {
			tyLe.setBonden(Double.toString(admin.get_4den()));
		}
		
		if(admin.get_4trang()%1 ==0){
			tyLe.setBontrang(Integer.toString(admin.get_4trang().intValue()));
		}else {
			tyLe.setBontrang(Double.toString(admin.get_4trang()));
		}
		
		if(admin.getChan()%1 ==0){
			tyLe.setChan(Integer.toString(admin.getChan().intValue()));
		}else {
			tyLe.setChan(Double.toString(admin.getChan()));
		}
		
		if(admin.get_1den3trang()%1 ==0){
			tyLe.setDenbatrang(Integer.toString(admin.get_1den3trang().intValue()));
		}else {
			tyLe.setDenbatrang(Double.toString(admin.get_1den3trang()));
		}
		
		if(admin.get_1trang3den()%1 ==0){
			tyLe.setTragbaden(Integer.toString(admin.get_1trang3den().intValue()));
		}else {
			tyLe.setTragbaden(Double.toString(admin.get_1trang3den()));
		}
		

		if(admin.getLe()%1 ==0){
			tyLe.setCuale(Integer.toString(admin.getLe().intValue()));
		}else {
			tyLe.setCuale(Double.toString(admin.getLe()));
		}
		
		
		//tyLe.setBontrang(admin.get_4trang());
		//tyLe.setChan(admin.getChan());
		//tyLe.setDenbatrang(admin.get_1den3trang());
		//tyLe.setTragbaden(admin.get_1trang3den());
		//tyLe.setCuale(admin.getLe());
		
		model.addAttribute("admindto", tyLe);
		ModelAndView mav = new ModelAndView("nha-cai");
		return mav;

	}

	@RequestMapping(value = "/tao-phong", method = RequestMethod.GET)
	public ModelAndView taoPhong(HttpServletRequest request, Model model)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");

		User user = service.getEuser(username);
		

		try {
			NguoiChoi nguoichoi = null;
			nguoichoi = nguoiChoisc.findnguoichoi(username);
			if (nguoichoi !=null) {
				model.addAttribute("user", user);
				model.addAttribute("message",
						"Tài khoản đang chơi trên máy khác");
				ModelAndView mav = new ModelAndView("phong");
				return mav;

			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		try {
			DatCuoc datcuoc = null;
			datcuoc = datcuocsc.getDatCuoc(username);
			if (datcuoc !=null) {
				model.addAttribute("user", user);
				model.addAttribute("message",
						"Tài khoản đang chơi trên máy khác");
				ModelAndView mav = new ModelAndView("phong");

				return mav;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("user", user);
		PhongDto phong = new PhongDto();
		int mabannext ;
		Phong phongnext = null;
		while (true) {
			Random rand = new Random();
			 mabannext = rand.nextInt(1000) + 2;
			try {
				phongnext = phongsc.getPhong(mabannext);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(phongnext == null){
				break;
			}
			
		}
		
		phong.setMaBan(mabannext);
		phong.setXuToiThieu((double) 0);
		Map<Integer, Integer> soNguoi = new HashMap<Integer, Integer>();
		soNguoi.put(1, 1);

		soNguoi.put(2, 2);
		soNguoi.put(3, 3);

		soNguoi.put(4, 4);
		soNguoi.put(5, 5);
		soNguoi.put(6, 6);
		soNguoi.put(7, 7);
		soNguoi.put(8, 8);
		soNguoi.put(9, 9);
		soNguoi.put(10, 10);
		model.addAttribute("soNguoi", soNguoi);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		model.addAttribute("phong", phong);
		ModelAndView mav = new ModelAndView("tao-phong");
		return mav;
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody
	String getPhongajax() {

		List<Phong> allPhong = phongsc.getAllPhong();
		String result = "";
		for (Phong phong : allPhong) {
			if (phong.getLoaiBan() == 1) {
				result = result
						+"<div class=\"col-xs-6 col-sm-3\">"
						
						+ "<a class=\"item-table\" href=\"ban-choi.html?maphong="
						+ phong.getMaBan()
						+ "\"> <span class=\"number\">"
						+ phong.getSoChoi()
						+ "</span>"
						+ "<span class=\"item-table-info\"> <span class=\"table-id\">ID:"
						+ phong.getMaBan()
						+ "</span> <span class=\"table-cost\">$"
						+ phong.getXuToiThieu()
						+ "</span> <span class=\"current-member\">"
						+ phong.getSoNguoi() + " nguoi</span>"
						+ "</span> <span class=\"clear\"></span></a>"
						+"</div>";
			}
		}

		return result;
	}

	@RequestMapping(value = "/ajaxtestth", method = RequestMethod.GET)
	public @ResponseBody
	String getPhongajaxth() {

		List<Phong> allPhong = phongsc.getAllPhong();
		String result = "";
		for (Phong phong : allPhong) {
			if (phong.getLoaiBan() == 0) {
				result = result
						+"<div class=\"col-xs-6 col-sm-3\">"
						
						+ "<a class=\"item-table\" href=\"ban-choi.html?maphong="
						+ phong.getMaBan()
						+ "\"> <span class=\"number\">"
						+ phong.getSoChoi()
						+ "</span>"
						+ "<span class=\"item-table-info\"> <span class=\"table-id\">ID:"
						+ phong.getMaBan()
						+ "</span> <span class=\"table-cost\">$"
						+ phong.getXuToiThieu()
						+ "</span> <span class=\"current-member\">"
						+ phong.getSoNguoi() + " nguoi</span>"
						+ "</span> <span class=\"clear\"></span></a>"
						+"</div>";
			}
		}

		return result;
	}

	@RequestMapping(value = "/phong", method = RequestMethod.GET)
	public ModelAndView Phong(HttpServletRequest request, Model model)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		model.addAttribute("user", user);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("phong");
		return mav;
	}

	@RequestMapping(value = "/phongcho", method = RequestMethod.GET)
	public ModelAndView phongcho(HttpServletRequest request, Model model)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		String isnhacai = "";
		Admin admin = adminsc.getadmin(1);
		try {

			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);

			int maphong = (int) nguoichoi.getMaBan();

			myarray.put(nguoichoi.getMaBan(), admin.getGiay());

			isclose.put(nguoichoi.getMaBan(), 2);

			Phong phong = phongsc.getPhong(nguoichoi.getMaBan());

			phongsc.deletePhong(phong);

			nguoiChoisc.deleteNguoiChoi(nguoichoi);

			session.removeAttribute("isnhacai");

			session.removeAttribute("maphong");
			List<DatCuoc> listdatcuoc = datcuocsc.getAlldatcuocbyban(maphong);
			for (DatCuoc datcuoc : listdatcuoc) {
				datcuocsc.deleDatCuoc(datcuoc);
			}

		} catch (Exception e) {

		}

		try {
			DatCuoc datcuoc = null;
			datcuoc = datcuocsc.getDatCuoc(username);

			if (datcuoc !=null) {
			
				Phong phong = phongsc.getPhong(datcuoc.getMaBan());
				phong.setSoChoi(phong.getSoChoi() - 1);
				phongsc.savePhong(phong);
				datcuocsc.deleteDatCuoc(datcuoc);
				
			}
			session.removeAttribute("maphong");

		} catch (Exception e) {
			// TODO: handle exception

		}

		model.addAttribute("admin", admin);
		model.addAttribute("user", user);
		ModelAndView mav = new ModelAndView("phong");
		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView dangKy(WebRequest request, Model model)
			throws EmailExistsException {
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("dang-ky");
		return mav;
	}

	

	@RequestMapping(value = "/ban-choi.html", method = RequestMethod.GET)
	public ModelAndView banChoi(@RequestParam("maphong") int maphong,
			HttpServletRequest request, Model model)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);// isnhacai
		Admin admin = adminsc.getadmin(1);
		String username = (String) session.getAttribute("username");

		User user = service.getEuser(username);
		NguoiChoi nguoichoi = null;

		try {
			nguoichoi = nguoiChoisc.findnguoichoiByMB(maphong);

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (nguoichoi == null) {
			ModelAndView mav = new ModelAndView("phong");
			return mav;
		}

		try {
			DatCuoc datcuocx = datcuocsc.getDatCuoc(username);
			if (datcuocx.getEmail().equals(username)) {
				model.addAttribute("message",
						"Tài khoản đang chơi trên máy khác");
				ModelAndView mav = new ModelAndView("phong");

				return mav;
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			NguoiChoi nguoichoix = nguoiChoisc.findnguoichoi(username);
			if (nguoichoix.getEmail().equals(username)) {
				model.addAttribute("user", user);
				model.addAttribute("message",
						"Tài khoản đang chơi trên máy khác");
				ModelAndView mav = new ModelAndView("phong");
				return mav;
			}
		} catch (Exception e) {

		}

		try {
			Phong check = phongsc.getPhong(maphong);
			if (check.getSoChoi() == check.getSoNguoi()) {
				model.addAttribute("message",
						"Phòng đã đủ người chơi, vui lòng chọn phòng khác");
				ModelAndView mav = new ModelAndView("phong");
				return mav;

			}
			if (check.getXuToiThieu() > user.getXu()) {
				model.addAttribute("message", "Bạn không đủ xu trong tài khoản");
				ModelAndView mav = new ModelAndView("phong");
				return mav;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		session.setAttribute("maphong", maphong);
		DatCuocDto datcuocdto = new DatCuocDto();
		datcuocdto.setEmail(username);
		datcuocdto.setTongxu(user.getXu());
		datcuocdto.setMaBan(maphong);
		datcuocsc.createNewDatCuoc(datcuocdto);
		Phong phong = phongsc.getPhong(maphong);
		phong.setSoChoi(phong.getSoChoi() + 1);
		phongsc.savePhong(phong);
		DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
		model.addAttribute("xu", datcuoc.getTongxu());
		model.addAttribute("datcuoc", datcuoc);
		int giay = admin.getGiay() % 60;
		int phut = admin.getGiay() / 60;
		model.addAttribute("giay", giay);
		model.addAttribute("phut", phut);
TiLeDto tyLe = new TiLeDto();
		
		
		if(admin.get_4den()%1 ==0){
			tyLe.setBonden(Integer.toString(admin.get_4den().intValue()));
		}else {
			tyLe.setBonden(Double.toString(admin.get_4den()));
		}
		
		if(admin.get_4trang()%1 ==0){
			tyLe.setBontrang(Integer.toString(admin.get_4trang().intValue()));
		}else {
			tyLe.setBontrang(Double.toString(admin.get_4trang()));
		}
		
		if(admin.getChan()%1 ==0){
			tyLe.setChan(Integer.toString(admin.getChan().intValue()));
		}else {
			tyLe.setChan(Double.toString(admin.getChan()));
		}
		
		if(admin.get_1den3trang()%1 ==0){
			tyLe.setDenbatrang(Integer.toString(admin.get_1den3trang().intValue()));
		}else {
			tyLe.setDenbatrang(Double.toString(admin.get_1den3trang()));
		}
		
		if(admin.get_1trang3den()%1 ==0){
			tyLe.setTragbaden(Integer.toString(admin.get_1trang3den().intValue()));
		}else {
			tyLe.setTragbaden(Double.toString(admin.get_1trang3den()));
		}
		

		if(admin.getLe()%1 ==0){
			
			tyLe.setCuale(Integer.toString(admin.getLe().intValue()));
			
		}else {
			tyLe.setCuale(Double.toString(admin.getLe()));
			
		}
		
		
		//tyLe.setBontrang(admin.get_4trang());
		//tyLe.setChan(admin.getChan());
		//tyLe.setDenbatrang(admin.get_1den3trang());
		//tyLe.setTragbaden(admin.get_1trang3den());
		//tyLe.setCuale(admin.getLe());
		
		model.addAttribute("admindto", tyLe);
		ModelAndView mav = new ModelAndView("ban-choi");

		return mav;

		// }

		/*
		 * if (maphongset == maphong) { try { DatCuoc datcuoc1 =
		 * datcuocsc.getDatCuoc(username); model.addAttribute("datcuoc",
		 * datcuoc1); int giay = admin.getGiay() % 60; int phut =
		 * admin.getGiay() / 60; model.addAttribute("giay", giay);
		 * model.addAttribute("phut", phut); ModelAndView mav = new
		 * ModelAndView("ban-choi");
		 * 
		 * return mav; } catch (Exception e) { // TODO: handle exception }
		 * 
		 * }
		 */
		// model.addAttribute("admin", admin);
		// ModelAndView mav = new ModelAndView("ban-choi");

	}

	@RequestMapping(value = "/noi-quy", method = RequestMethod.GET)
	public ModelAndView noiQuy(WebRequest request, Model model)
			throws EmailExistsException {
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("noi-quy");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, Model model)
			throws EmailExistsException {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		// user.setLoginstatus(0);
		// service.saveRegisteredUser(user);

		try {

			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);

			int maphong = (int) nguoichoi.getMaBan();
			Phong phong = phongsc.getPhong(nguoichoi.getMaBan());

			phongsc.deletePhong(phong);

			nguoiChoisc.deleteNguoiChoi(nguoichoi);
			List<DatCuoc> listdatcuoc = datcuocsc.getAlldatcuocbyban(maphong);
			for (DatCuoc datcuoc : listdatcuoc) {
				datcuocsc.deleDatCuoc(datcuoc);
			}

		} catch (Exception e) {

		}

		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);

			Phong phong = phongsc.getPhong(datcuoc.getMaBan());
			phong.setSoChoi(phong.getSoChoi() - 1);
			phongsc.savePhong(phong);
			if (datcuoc.getEmail().equals(username)) {
				datcuocsc.deleteDatCuoc(datcuoc);
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		//session.invalidate();
		try {
			Admin admin = adminsc.getadmin(1);
			model.addAttribute("admin", admin);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, ModelMap map,
			RedirectAttributes redirectAttributes) throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);
		
		try {
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);
			datcuocsc.deleDatCuoc(datcuoc);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);
			int maban = nguoichoi.getMaBan();
			Phong phong = phongsc.getPhong(nguoichoi.getMaBan());
			phongsc.deletePhong(phong);
			nguoiChoisc.deleteNguoiChoi(nguoichoi);
			List<DatCuoc> listdatcuoc = datcuocsc.getAlldatcuocbyban(maban);
			for (DatCuoc datcuoc : listdatcuoc) {
				datcuocsc.deleDatCuoc(datcuoc);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		model.addAttribute("user", user);
		ModelAndView mav = new ModelAndView("home");
		return "home";
	}

	@RequestMapping(value = "/thong-tin-thanh-vien", method = RequestMethod.GET)
	public ModelAndView thongTin(WebRequest request, Model model,
			HttpServletRequest req) throws EmailExistsException {

		UserInfo userinfo = new UserInfo();

		HttpSession session = req.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);

		userinfo.setEmail(user.getEmail());
		userinfo.setFirstName(user.getFirstName());
		userinfo.setPhone(user.getPhone());
		userinfo.setFullname(user.getFullname());
		userinfo.setLastName(user.getLastName());
		userinfo.setId(user.getId());
		userinfo.setRuttien(user.getRuttien().intValue());
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		model.addAttribute("user", userinfo);
		model.addAttribute("users", user);
		ModelAndView mav = new ModelAndView("thong-tin-thanh-vien");
		return mav;
	}

	@RequestMapping(value = "/thong-tin-thanh-vien", method = RequestMethod.POST)
	public ModelAndView thongTinpc(
			@ModelAttribute("user") @Valid UserInfo userinfo,
			BindingResult result, HttpServletRequest request, Errors errors,
			@Validated File file, Model model) throws EmailExistsException {
		if (result.hasErrors()) {
			return new ModelAndView("thong-tin-thanh-vien", "user", userinfo);

		}
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username)  ;   
		user.setFirstName(userinfo.getFirstName());
		user.setPhone(userinfo.getPhone());
		user.setFullname(userinfo.getFullname());

		MultipartFile multipartFile = file.getFile();

		ServletContext context = RequestContextUtils.getWebApplicationContext(
				request).getServletContext();
		String root = context.getRealPath("/");
		String filename = user.getEmail();

		java.io.File fileex = new java.io.File(root
				+ "resources\\mytheme\\images\\" + filename + ".jpg");

		if (fileex.delete()) {
			
		}
		try {
			multipartFile.transferTo(new java.io.File(root
					+ "resources//mytheme//images//" + filename + ".jpg"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setLastName("/resources/images/" + filename + ".jpg");
		
		service.saveRegisteredUser(user);
		
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		//user.setEmail(username);
		userinfo.setEmail(user.getEmail());
		userinfo.setId(user.getId());
		model.addAttribute("user", userinfo);
		model.addAttribute("users", user);
		model.addAttribute("thongbao", "Cập nhật thành công ");
		ModelAndView mav = new ModelAndView("thong-tin-thanh-vien");
		return mav;

	}

	@RequestMapping(value = "/huong-dan-choi-game", method = RequestMethod.GET)
	public ModelAndView choiGame(HttpServletRequest request, Model model)
			throws EmailExistsException {

		try {
			HttpSession session = request.getSession(false);// sesion time out
			String username = (String) session.getAttribute("username");
			User user = service.getEuser(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("huong-dan-choi-game");
		return mav;
	}

	@RequestMapping(value = "/changepass", method = RequestMethod.GET)
	public ModelAndView changepass(Model model, HttpServletRequest request)
			throws EmailExistsException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);

		Changepass change = new Changepass();
		model.addAttribute("users", user);
		model.addAttribute("change", change);
		ModelAndView mav = new ModelAndView("changepass");
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		return mav;
	}

	@RequestMapping(value = "/changepass", method = RequestMethod.POST)
	public ModelAndView changepasspc(Model model,
			@ModelAttribute("change") Changepass change,
			HttpServletRequest request) throws EmailExistsException {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		User user = service.getEuser(username);

		if (!change.getPass().equals(change.getRepass())) {
			model.addAttribute("passError", "Mật khẩu không giống nhau");
			return new ModelAndView("changepass", "change", change);
		}
		String hashedPassword = hashGenerator.getHashedPassword(change
				.getPass());
		user.setPassword(hashedPassword);
		service.saveRegisteredUser(user);
		ModelAndView mav = new ModelAndView("changepass");
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		model.addAttribute("users", user);
		model.addAttribute("message", "Đổi mật khẩu thành công");
		return mav;
	}

	@RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
	public String forgetpass(WebRequest request, Model model)
			throws EmailExistsException {
		FPass pass = new FPass();
		model.addAttribute("FPass", pass);
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		return "forgetpass";
	}

	@RequestMapping(value = "/forgetpass", method = RequestMethod.POST)
	public ModelAndView forgetpassprocess(
			@ModelAttribute("FPass") @Valid FPass pass, BindingResult result,
			HttpServletRequest request, Errors errors, Model model)
			throws EmailExistsException {

		if (result.hasErrors()) {
			return new ModelAndView("forgetpass", "FPass", pass);

		}

		// email right
		if (service.emailExist(pass.getEmail())) {
			User user = service.getEuser(pass.getEmail());
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(20 * 60);
			String token = UUID.randomUUID().toString();
			session.setAttribute(token, user);
			session.setAttribute("userid", user);
			String appUrl = "http://xocdia123.com" + request.getContextPath()
					+ "/forgetpasschange.html?token=" + token;

			MailService ms = new MailService(pass.getEmail(), appUrl,
					"YÊU CẦU ĐỔI MẬT KHẨU");
			ms.start();
			model.addAttribute(
					"message",
					"Hệ thống đã gửi email xác nhận đặt lại mật khẩu. Bạn vui lòng kiểm tra email nhé");

		} else {
			model.addAttribute("message",
					"Email của bạn không có trong hệ thống");
		}

		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("forgetpass");
		return mav;
	}

	@RequestMapping(value = "/forgetpasschange", method = RequestMethod.GET)
	public ModelAndView forgetpasschange(Model model,
			@RequestParam("token") String token, HttpServletRequest request)
			throws EmailExistsException {

		HttpSession session = request.getSession(false);// sesion time out
		session.removeAttribute(token);

		ForgetP FP = new ForgetP();
		model.addAttribute("fp", FP);
		ModelAndView mav = new ModelAndView("forgetpasschange");
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		return mav;

	}

	@RequestMapping(value = "/forgetpasschange", method = RequestMethod.POST)
	public ModelAndView forgetpasschangepc(Model model,
			@ModelAttribute("fp") @Valid ForgetP Fp,
			@RequestParam("token") String token, HttpServletRequest request,
			BindingResult result, Errors errors) throws EmailExistsException {

		if (result.hasErrors()) {

			return new ModelAndView("forgetpasschange", "fp", Fp);

		}

		HttpSession session = request.getSession(false);// sesion time out
		User user = (User) session.getAttribute("userid");
		String hashedPassword = hashGenerator.getHashedPassword(Fp.getPass());

		user.setPassword(hashedPassword);
		user.setLoginstatus(0);
		service.saveRegisteredUser(user);
		ForgetP FP = new ForgetP();
		model.addAttribute("fp", FP);
		model.addAttribute("mesage", "Bạn đã thay đổi mật khẩu thành công");
		ModelAndView mav = new ModelAndView("forgetpasschange");
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		session.removeAttribute("userid");
		return mav;

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexF(HttpServletRequest request, Model model)
			throws EmailExistsException {
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, Model model)
			throws EmailExistsException {
		ModelAndView mav = new ModelAndView("index");
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		return mav;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model)
			throws EmailExistsException {
		LOGGER.debug("Rendering registration page.");
		UserDto accountDto = new UserDto();
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		model.addAttribute("user", accountDto);
		return "registration";
	}

	@RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration(WebRequest request, Model model,
			@RequestParam("token") String token) {
		Locale locale = request.getLocale();

		VerificationToken verificationToken = service
				.getVerificationToken(token);
		if (verificationToken == null) {
			String message = messages.getMessage("auth.message.invalidToken",
					null, locale);
			model.addAttribute("message", message);
			return "redirect:/badUser.html?lang=" + locale.getLanguage()  ;
		}

		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime()
				.getTime()) <= 0) {
			model.addAttribute("message",
					messages.getMessage("auth.message.expired", null, locale));
			return "redirect:/badUser.html?lang=" + locale.getLanguage();
		}

		user.setEnabled(true);
		service.saveRegisteredUser(user);
		return "redirect:/login.html?lang=" + locale.getLanguage();
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
			@ModelAttribute("user") @Valid UserDto accountDto,
			BindingResult result, WebRequest request, Errors errors,
			HttpServletRequest req, @Validated File file, Model model)
			throws EmailExistsException {
		LOGGER.debug("Registering user account with information: {}",
				accountDto);

		if (result.hasErrors()) {
			return new ModelAndView("registration", "user", accountDto);
		}
		if (accountDto.isAccept() == false) {
			model.addAttribute("user", accountDto);
			model.addAttribute("error", "vui lòng chọn nút đồng ý");
			ModelAndView mav = new ModelAndView("registration");
			return mav;
		}
		try {
			if (service.emailExist(accountDto.getEmail())) {
				model.addAttribute("user", accountDto);
				model.addAttribute("error",
						"Email của bạn đã có trong hệ thống");
				ModelAndView mav = new ModelAndView("registration");
				return mav;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		MultipartFile multipartFile = file.getFile();

		ServletContext context = RequestContextUtils.getWebApplicationContext(
				req).getServletContext();
		String root = context.getRealPath("/");
		String filename = accountDto.getEmail();
		try {
			multipartFile.transferTo(new java.io.File(root
					+ "resources//mytheme//images//" + filename + ".jpg"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		accountDto.setLastName("/resources/images/" + filename + ".jpg");

		accountDto.setXu((double) 0);
		accountDto.setRuttien((double) 0);
		User registered = createUserAccount(accountDto);
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}

		String token = UUID.randomUUID().toString();
		service.createVerificationTokenForUser(registered, token);
		String appUrl = request.getContextPath()
				+ "/regitrationConfirm.html?token=" + token;

		OnRegistrationCompleteEvent us = new OnRegistrationCompleteEvent(
				registered, request.getLocale(), appUrl);
		RegistrationListener RL = new RegistrationListener();
		RL.confirmRegistration(us);
		// savefile
		Admin admin = adminsc.getadmin(1);
		model.addAttribute("admin", admin);
		return new ModelAndView("successRegister", "user", accountDto);
	}

	private User createUserAccount(UserDto accountDto) {
		User registered = null;
		try {
			registered = service.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
	}
}
