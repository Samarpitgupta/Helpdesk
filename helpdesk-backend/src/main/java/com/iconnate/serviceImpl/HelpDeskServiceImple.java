package com.iconnate.serviceImpl;

import java.util.List;

import com.iconnate.daoImpl.HelpDeskDAOImple;
import com.iconnate.model.HelpDesk;
import com.iconnate.service.HelpDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpDeskServiceImple implements HelpDeskService {

	@Autowired
    HelpDeskDAOImple helpDeskDAOImple;

	// Interact with Database layer

	// return helpdesk by getting from database layer
	@Override
	public HelpDesk getHelpDeskById(int helpDeskId) {

		HelpDesk helpDesk = helpDeskDAOImple.getHelpDeskById(helpDeskId);
		return helpDesk;
	}

	// return list of helpdesk by getting from database layer
	@Override
	public List<HelpDesk> getAllHelpDesk() {
		return helpDeskDAOImple.getHelpDeskList();
	}

	// create new helpdesk
	@Override
	public void createHelpDesk(HelpDesk helpDesk) {
		helpDeskDAOImple.createHelpDesk(helpDesk);
	}

	// update helpdesk details by interacting with database layer
	@Override
	public void updateHelpDeskDetails(HelpDesk helpDesk) {
		helpDeskDAOImple.updateHelpDeskDetails(helpDesk);
	}

	// soft delete helpdesk
	@Override
	public void deleteHelpDeskByID(int helpDesk_id) {
		helpDeskDAOImple.deleteHelpDesk(helpDesk_id);
	}

}
