package com.roadmmm.util;

import java.util.ArrayList;
import java.util.List;

import com.roadmmm.vo.PagingForm;

public class PagingUtil {
	public static PagingForm pagingUtil(String page, int count) {
		
		int currentPage = 0;
		int startPage = 0;
		
		boolean beforePage = false;
		boolean afterPage = false;
		
		int beforePageNum = 0;
		int afterPageNum = 0;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
			
			startPage = ((currentPage - 1) * 10);
		}
		
		int pageLastNum = (int)(count / 10) + 1;

		List<Integer> pageList = new ArrayList<>();
		
		//페이징, 10페이지 이하의 조건.
		if(count < 101) {
			beforePage = false;
			if(count > 100) {
				afterPage = true;
			}
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			for(int i = 1; i <= pageLastNum; i++) {
				pageList.add(i);
			}
			
		}else { //페이징, 10페이지 초과의 조건.
			
			//이전,이후 페이지 여부
			if(currentPage >= 11) {
				beforePage = true;
			}
			if((currentPage - 1) / 10 < pageLastNum / 10) {
				afterPage = true;
			}else {
				afterPage = false;
			}
			
			if(currentPage % 10 == 0) {
				currentPage--;
			}
			
			beforePageNum = (currentPage - 10) - (currentPage % 10) + 1;
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			int lastPage = currentPage - (currentPage %10) + 10;
			
			if(afterPage == false) {
				lastPage = pageLastNum;
			}
			
			for(int i = currentPage - (currentPage %10) + 1; i <= lastPage; i++) {
				pageList.add(i);
			}
			
		}
		PagingForm pagingForm = new PagingForm(pageList, beforePage, afterPage, beforePageNum, afterPageNum, startPage);
		
		return pagingForm;
	}
}
