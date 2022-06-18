package com.iconnate.model.response;

import java.util.List;

import com.iconnate.model.HelpDesk;

public class ResponseListHelpDesk {

	private List<HelpDesk> listHelpDesk;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<HelpDesk> getListHelpDesk() {
		return listHelpDesk;
	}

	public void setListHelpDesk(List<HelpDesk> listHelpDesk) {
		this.listHelpDesk = listHelpDesk;
	}

}
