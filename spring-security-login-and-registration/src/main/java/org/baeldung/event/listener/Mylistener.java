package org.baeldung.event.listener;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.baeldung.persistence.model.DatCuoc;
import org.baeldung.persistence.model.NguoiChoi;
import org.baeldung.persistence.model.Phong;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.service.DatCuocService;
import org.baeldung.persistence.service.IUserService;
import org.baeldung.persistence.service.NguoiChoiService;
import org.baeldung.persistence.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class Mylistener implements ApplicationListener<SessionDestroyedEvent> {
	@Autowired
    private IUserService service;
	@Autowired
	private DatCuocService datcuocsc;

	
	@Autowired
	private NguoiChoiService nguoiChoisc;

	@Autowired
	private PhongService phongsc;
	
    @Override
    public void onApplicationEvent(SessionDestroyedEvent event)
    {   	
    	HttpSession session = (HttpSession) event.getSource();   	
    	try {
    		String username = (String) session.getAttribute("username");    		
    		if(username != null){
    		User user = service.getEuser(username);
    		user.setLoginstatus(0);
    		service.saveRegisteredUser(user);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	try {
    		String username = (String) session.getAttribute("username");
    		if(username != null){
			NguoiChoi nguoichoi = nguoiChoisc.findnguoichoi(username);

			int maphong = (int) nguoichoi.getMaBan();

			

			Phong phong = phongsc.getPhong(nguoichoi.getMaBan());

			phongsc.deletePhong(phong);

			nguoiChoisc.deleteNguoiChoi(nguoichoi);

			//session.removeAttribute("isnhacai");

			//session.removeAttribute("maphong");
			List<DatCuoc> listdatcuoc = datcuocsc.getAlldatcuocbyban(maphong);
			for (DatCuoc datcuoc : listdatcuoc) {
				datcuocsc.deleDatCuoc(datcuoc);
			}
    		}

		} catch (Exception e) {
			
		}

		try {
			
			String username = (String) session.getAttribute("username");
			if(username != null){
			DatCuoc datcuoc = datcuocsc.getDatCuoc(username);

			Phong phong = phongsc.getPhong(datcuoc.getMaBan());
			phong.setSoChoi(phong.getSoChoi() - 1);
			phongsc.savePhong(phong);
			if (datcuoc.getEmail().equals(username)) {
				datcuocsc.deleteDatCuoc(datcuoc);
			}
			//session.removeAttribute("maphong");
			}

		} catch (Exception e) {
			// TODO: handle exception
			
		}
    	
       
    }

}