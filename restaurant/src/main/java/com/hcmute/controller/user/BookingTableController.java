package com.hcmute.controller.user;


import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.hcmute.dao.BookingTableDao;
import com.hcmute.dao.CustomerDao;
import com.hcmute.model.BookingTableModel;
import com.hcmute.model.CustomerModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcmute.dao.TableDao;
import com.hcmute.model.DiningTableModel;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookingTableController {
	TableDao tableDao = new TableDao();
	BookingTableDao bookingTableDao = new BookingTableDao();
	CustomerDao customerDao = new CustomerDao();
	@RequestMapping(value= {"/booking-table","/dat-cho"},method=RequestMethod.GET)
	public String showListTable(ModelMap model) {
		List<DiningTableModel> list = tableDao.getAll();
		model.addAttribute("listTables",list);
		return "booking-table";
	}
	//@RequestMapping(value = {"/booking-table/booking/{fullname}/{phone}/{date}/{time}/{tableID}"}, method = RequestMethod.POST)
	@RequestMapping(value= {"/booking-table/{tableID}"},method=RequestMethod.POST)
	public String bookingTable(HttpServletRequest req, ModelMap model, @PathVariable int tableID) throws ParseException {
		String fullname = req.getParameter("fullname");
		System.out.println(tableID);
		String phone = req.getParameter("phone");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		long ms = sdf.parse(time).getTime();
		Time timeArrival = new Time(ms);
		Date dateArrival = Date.valueOf(date);
		CustomerModel customer = new CustomerModel();
		customer.setName(fullname);
		customer.setPhone(phone);
		int customerID = customerDao.insert(customer);
		if(customerID != 0){
			BookingTableModel booking = new BookingTableModel(customerID,tableID,dateArrival,timeArrival);
			if(bookingTableDao.insert(booking)){
				DiningTableModel table = new DiningTableModel(tableID,"deactivate");
				tableDao.updateStatus(table);
			}
		}
		String redirectUrl = "/booking-table";
		return "redirect:" + redirectUrl;
	}
	@RequestMapping(value = {"/booking-table/cancel/{tableID}"}, method = RequestMethod.GET)
	public String cancelBooking(HttpServletRequest req, @PathVariable int tableID){
		System.out.println(tableID);
		DiningTableModel table = new DiningTableModel(tableID,"active");
		if(tableDao.updateStatus(table)){
			String redirectUrl = "/booking-table";
			return "redirect:" + redirectUrl;
		}
		String redirectUrl = "/booking-table";
		return "redirect:" + redirectUrl;
	}

}
