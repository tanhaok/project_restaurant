package com.hcmute.controller.user;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.hcmute.dao.BookingTableDao;
import com.hcmute.dao.CustomerDao;
import com.hcmute.model.BookingTableModel;
import com.hcmute.model.CustomerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcmute.dao.TableDao;
import com.hcmute.model.DiningTableModel;

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
		System.out.println("Something");
		return "booking-table";
	}
	//@RequestMapping(value = {"/booking-table/booking/{fullname}/{phone}/{date}/{time}/{tableID}"}, method = RequestMethod.POST)
	@RequestMapping(value= {"/booking-table"},method=RequestMethod.POST)
	public String bookingTable(HttpServletRequest req, ModelMap model){
		String fullname = req.getParameter("name");
		String phone = req.getParameter("p");
		String date = req.getParameter("d");
		String time = req.getParameter("t");
		int tableID = Integer.parseInt(req.getParameter("id"));
		Date dateArrival = Date.valueOf(date );
		Time timeArrival = Time.valueOf(time);
		CustomerModel customer = new CustomerModel();
		customer.setName(fullname);
		customer.setPhone(phone);
		System.out.println(customer.toString());
		int customerID = customerDao.insert(customer);
		System.out.println(customerID);
		if(customerID != 0){
			BookingTableModel booking = new BookingTableModel(customerID,tableID,dateArrival,timeArrival);
			System.out.println(booking.toString());
			if(bookingTableDao.insert(booking)){
				model.addAttribute("msg","Done");
			}
		}
		return "booking-table";
	}

}
