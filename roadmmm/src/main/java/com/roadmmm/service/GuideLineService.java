package com.roadmmm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.GuideLine;
import com.roadmmm.domain.stockstudy.StockStudyTag;
import com.roadmmm.repository.GuideLineRepository;
import com.roadmmm.util.PagingUtil;
import com.roadmmm.vo.GuideLineListForm;
import com.roadmmm.vo.GuideLineListVo;
import com.roadmmm.vo.GuideLineWriteForm;
import com.roadmmm.vo.PagingForm;

@Service
@Transactional
public class GuideLineService {
	@Autowired
	GuideLineRepository guideLineRepository;
	
	public void saveGuideLine(GuideLine guideLine) {
		guideLineRepository.insertGuideLine(guideLine);
	}
	
	public GuideLineListVo getGuideLineList(String sector, String page){
		
		StockStudyTag tag = StockStudyTag.valueOf(sector);
		
		int count = guideLineRepository.selectGuideLineListCount(tag);
		
		PagingForm pagingForm = PagingUtil.pagingUtil(page, count);
		
		List<GuideLine> guideLines = guideLineRepository.selectGuideLineList(tag, pagingForm.getStartPage());
		
		List<GuideLineListForm> guideLineListForms = new ArrayList<GuideLineListForm>();
		
		for(int i=0; i<guideLines.size(); i++) {
			GuideLineListForm guideLineListForm = new GuideLineListForm(guideLines.get(i).getTitleImg(), guideLines.get(i).getTitle());
			guideLineListForms.add(guideLineListForm);
		}
		
		GuideLineListVo guideLineListVo = new GuideLineListVo(guideLineListForms, pagingForm, tag);
		
		return guideLineListVo;
	}
}
