package com.iconnate.service;

import java.util.List;
import com.iconnate.model.HelpDesk;

/**
 * @author samarpit
 *
 */
public interface HelpDeskService {

	List<HelpDesk> getAllHelpDesk();

	HelpDesk getHelpDeskById(int helpDeskId);

	void createHelpDesk(HelpDesk helpDesk);

	void updateHelpDeskDetails(HelpDesk helpDesk);

	void deleteHelpDeskByID(int id);
}
