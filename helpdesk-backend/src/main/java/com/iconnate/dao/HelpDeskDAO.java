package com.iconnate.dao;

import java.util.List;

import com.iconnate.model.HelpDesk;
import org.springframework.stereotype.Repository;

/**
 * @author samarpit
 *
 */

@Repository
public interface HelpDeskDAO {

	public List<HelpDesk> getHelpDeskList();

	public HelpDesk getHelpDeskById(int helpDeskId);

	public void createHelpDesk(HelpDesk helpDesk);

	public void updateHelpDeskDetails(HelpDesk helpDesk);

	void deleteHelpDesk(int helpDeskId);

}
