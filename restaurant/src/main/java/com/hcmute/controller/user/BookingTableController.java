package com.hcmute.controller.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcmute.dao.TableDao;
import com.hcmute.model.dining_table_model;

@Controller
public class BookingTableController {
	TableDao dao = new TableDao();
	@RequestMapping(value= {"/booking-table","/dat-cho"},method=RequestMethod.GET)
	public String showListTable(ModelMap model) {
		List<dining_table_model> list = dao.getAll();
		model.addAttribute("listTables",list);
		return "booking-table";
	}

}
