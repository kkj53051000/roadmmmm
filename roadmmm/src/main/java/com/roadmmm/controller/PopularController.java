package com.roadmmm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.roadmmm.domain.PopularLive;
import com.roadmmm.service.PopularService;
import com.roadmmm.vo.PopularDayForm;
import com.roadmmm.vo.PopularInfoForm;
import com.roadmmm.vo.PopularListForm;

@Controller
public class PopularController {
	
	@Autowired
	PopularService popularService;
	
	@GetMapping("/ppllist")
	public String popularLiveListPage(HttpServletRequest request, Model model) {
		
		String page = request.getParameter("page");
		
		PopularListForm popularListForm = popularService.getPopularLiveInfo(page);
		
		model.addAttribute("vo", popularListForm);
		
		return "popularLiveList";
	}
	
	@GetMapping("/ppdlist")
	public String popularDayListPage(HttpServletRequest request, Model model) throws ParseException {
		
		String day = request.getParameter("day");
		String dayStartStr = "";
		String dayEndStr = "";
		String move = request.getParameter("move");
		String page = request.getParameter("page");
		
		PopularListForm popularListForm = new PopularListForm();
		
		
		if(move != null && move.equals("true")) {
			String fyear = request.getParameter("fyear");
			String fmonth = request.getParameter("fmonth");
			String fday = request.getParameter("fday");
			
			day = fyear + "-" + fmonth + "-" + fday;
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			Date setDate = fm.parse(day);

			Calendar cal = new GregorianCalendar(Locale.KOREA);

			cal.setTime(setDate);

			cal.add(Calendar.DATE, -1);

			day = fm.format(cal.getTime());
		}else if(move != null && move.equals("false")) {
			String fyear = request.getParameter("fyear");
			String fmonth = request.getParameter("fmonth");
			String fday = request.getParameter("fday");
			
			day = fyear + "-" + fmonth + "-" + fday;
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			Date setDate = fm.parse(day);

			Calendar cal = new GregorianCalendar(Locale.KOREA);

			cal.setTime(setDate);

			cal.add(Calendar.DATE, +1);

			day = fm.format(cal.getTime());
		}
		
		int thisYear;
		int thisMonth;
		int thisDay;
		
		List<PopularInfoForm> popularDays = new ArrayList<PopularInfoForm>();
		
		//날짜 get요청 없이 들어왔을 경우
		if(day == null) {
			Date today = new Date();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			String todayStr = fm.format(today);
			
			dayStartStr = todayStr + " 00:00:00";
			dayEndStr = todayStr + " 23:59:59";
			
			//연월일 int형 구하기
			fm = new SimpleDateFormat("yyyy");
			thisYear = Integer.parseInt(fm.format(today));
			fm = new SimpleDateFormat("MM");
			thisMonth = Integer.parseInt(fm.format(today));
			fm = new SimpleDateFormat("dd");
			thisDay = Integer.parseInt(fm.format(today));
			
		}else {
			dayStartStr = day + " 00:00:00";
			dayEndStr = day + " 23:59:59";
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			Date tempDay = fm.parse(dayStartStr);
			
			fm = new SimpleDateFormat("yyyy");
			thisYear = Integer.parseInt(fm.format(tempDay));
			fm = new SimpleDateFormat("MM");
			thisMonth = Integer.parseInt(fm.format(tempDay));
			fm = new SimpleDateFormat("dd");
			thisDay = Integer.parseInt(fm.format(tempDay));
		}
		
		try {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat fm_start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			Date dayDate = fm.parse(dayStartStr); //yyyy-MM-dd
			Date dayStart = fm_start.parse(dayStartStr); //yyyy-MM-dd 00:00:00
			Date dayEnd = fm_start.parse(dayEndStr); //yyyy-MM-dd 23:59:59

			popularListForm = popularService.getPopularDays(dayStart, dayEnd, page);
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PopularDayForm popularDayForm = new PopularDayForm(popularListForm, thisYear, thisMonth, thisDay);
		
		model.addAttribute("vo", popularDayForm);
		
		return "popularDayList";
	}
	
	@GetMapping("/ppmlist")
	public String popularMonthListPage(HttpServletRequest request, Model model) throws ParseException {
		
		String month = request.getParameter("month");
		String monthStartStr = "";
		String monthEndStr = "";
		String move = request.getParameter("move");
		
		if(move != null && move.equals("true")) {
			String fyear = request.getParameter("fyear");
			String fmonth = request.getParameter("fmonth");
			
			month = fyear + "-" + fmonth;
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM");
			
			Date setDate = fm.parse(month);

			Calendar cal = new GregorianCalendar(Locale.KOREA);

			cal.setTime(setDate);

			cal.add(Calendar.MONTH, -1);
			
			month = fm.format(cal.getTime());
			
		}else if(move != null && move.equals("false")) {
			String fyear = request.getParameter("fyear");
			String fmonth = request.getParameter("fmonth");
			
			month = fyear + "-" + fmonth;
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM");
			
			Date setDate = fm.parse(month);

			Calendar cal = new GregorianCalendar(Locale.KOREA);

			cal.setTime(setDate);

			cal.add(Calendar.MONTH, +1);
			
			month = fm.format(cal.getTime());
		}
		
		int thisYear;
		int thisMonth;
		
		Date montStartDate = new Date();
		Date montEndDate = new Date();
		
		List<PopularInfoForm> popularDays = new ArrayList<PopularInfoForm>();
		
		//날짜 get요청 없이 들어왔을 경우
		if(month == null) {
			Date today = new Date();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM");
			
			String todayStr = fm.format(today);
			
			monthStartStr = todayStr + "-01";
			
			month = todayStr;
			
			fm = new SimpleDateFormat("yyyy-MM-dd");
			
			montStartDate = fm.parse(monthStartStr);
			
			//연월일 int형 구하기
			fm = new SimpleDateFormat("yyyy");
			thisYear = Integer.parseInt(fm.format(today));
			fm = new SimpleDateFormat("MM");
			thisMonth = Integer.parseInt(fm.format(today));
			
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.MONTH, (thisMonth - 1)); // 9월 세팅 (월 세팅은 0~11이기에..)
			int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			monthEndStr = todayStr + "-" + Integer.toString(dayOfMonth);
			
			montEndDate = fm.parse(monthEndStr);
			
			
		}else {
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			monthStartStr = month + "-01";
			
			montStartDate = fm.parse(monthStartStr);
			
			fm = new SimpleDateFormat("yyyy");
			thisYear = Integer.parseInt(fm.format(montStartDate));
			fm = new SimpleDateFormat("MM");
			thisMonth = Integer.parseInt(fm.format(montStartDate));
			
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.MONTH, (thisMonth - 1)); // 9월 세팅 (월 세팅은 0~11이기에..)
			int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			monthEndStr = month + "-" + Integer.toString(dayOfMonth);;
			
			montEndDate = fm.parse(monthEndStr);
		}
		
		try {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			Date monthStart = fm.parse(monthStartStr); //yyyy-MM-dd
			Date monthEnd = fm.parse(monthEndStr); //yyyy-MM-dd

			popularDays = popularService.getPopularMonths(monthStart, monthEnd);
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PopularDayForm popularDayForm = new PopularDayForm(popularDays, thisYear, thisMonth);
		
		model.addAttribute("vo", popularDayForm);
		
		return "popularMonthList";
	}
}