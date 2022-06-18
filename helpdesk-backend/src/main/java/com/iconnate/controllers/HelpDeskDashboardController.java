package com.iconnate.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iconnate.model.HelpDesk;
import com.iconnate.model.response.ResponseHelpDesk;
import com.iconnate.serviceImpl.HelpDeskServiceImple;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * @author samarpit
 *
 */

@Api(value = "Helpdesk Controller", description = "handles request based on the requested http methods and url")
@Controller
@RequestMapping("/api/auth")
public class HelpDeskDashboardController {

	@Autowired
	HelpDeskServiceImple helpDeskServiceImple;

	// accept get request
	// return particular helpdesk details in JSON format
	@ApiOperation(value = "get helpdesk details by using helpdesk_id", response = HelpDesk.class)
	@ApiResponse(code = 200, message = "requested helpdesk details")
	@GetMapping(value = "/helpdesk/{id}", produces = "application/json")
	public ResponseEntity<HelpDesk> getHelpDesk(@PathVariable("id") Integer id) {
		HelpDesk helpDesk = helpDeskServiceImple.getHelpDeskById(id);
		return new ResponseEntity<>(helpDesk, HttpStatus.OK);
	}

	// accept get request
	// return list of helpdesks with detail in JSON format
	@ApiOperation(value = "get list of helpdesks", response = HelpDesk.class)
	@ApiResponse(code = 200, message = "list of helpdesks")
	@GetMapping(value = "/helpdesks", produces = "application/json")
	public ResponseEntity<List<HelpDesk>> getHelpDeskList() {
		List<HelpDesk> listHelpDesk = helpDeskServiceImple.getAllHelpDesk();
		return new ResponseEntity<>(listHelpDesk, HttpStatus.OK);
	}

	// accept post request
	// create new helpdesk
	// return success message
	@ApiOperation(value = "create new helpdesk", response = ResponseHelpDesk.class)
	@ApiResponse(code = 201, message = "helpdesk created")
	@PostMapping(value = "/createHelpDesk")
	public ResponseEntity<ResponseHelpDesk> createNewHelpDesk(@RequestBody HelpDesk helpDesk) {
		helpDeskServiceImple.createHelpDesk(helpDesk);
		ResponseHelpDesk responseHelpDesk = new ResponseHelpDesk();
		responseHelpDesk.setMsg("Helpdesk created");
		return new ResponseEntity<>(responseHelpDesk, HttpStatus.CREATED);
	}

	// accept put request
	// update helpdesk details
	// return update message
	@ApiOperation(value = "update helpdesk details", response = ResponseHelpDesk.class)
	@ApiResponse(code = 200, message = "updated helpdesk details")
	@PutMapping(value = "/updateHelpDeskInformation", produces = "application/json")
	public ResponseEntity<ResponseHelpDesk> updateHelpDeskInformation(@RequestBody HelpDesk helpDesk) {
		helpDeskServiceImple.updateHelpDeskDetails(helpDesk);
		ResponseHelpDesk responseHelpDesk = new ResponseHelpDesk();
		responseHelpDesk.setMsg("helpdesk information updated");
		return new ResponseEntity<>(responseHelpDesk, HttpStatus.OK);
	}

	// accept put request
	// delete helpdesk by using helpdesk_id
	@ApiOperation(value = "delete helpdesk by using helpdesk_id", response = ResponseHelpDesk.class)
	@ApiResponse(code = 204, message = "helpdesk deleted")
	@PutMapping(value = "/deleteHelpDesk/id/{id}", produces = "application/json")
	public ResponseEntity<ResponseHelpDesk> deleteHelpDeskByUserID(@PathVariable(value = "id") Integer id) {
		helpDeskServiceImple.deleteHelpDeskByID(id);
		ResponseHelpDesk responseHelpDesk = new ResponseHelpDesk();
		responseHelpDesk.setMsg("helpdesk deleted");
		return new ResponseEntity<>(responseHelpDesk, HttpStatus.NO_CONTENT);
	}

}
