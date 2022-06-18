package com.iconnate.daoImpl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.iconnate.dao.HelpDeskDAO;
import com.iconnate.model.HelpDesk;
import com.iconnate.rowmapper.HelpDeskMapper;

/**
 * @author samarpit
 *
 */
@Repository
public class HelpDeskDAOImple implements HelpDeskDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// interact with Database

	// create object of JdbcTemplate
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	// return helpdesk details
	@Override
	public HelpDesk getHelpDeskById(int helpDeskId) {

		RowMapper<HelpDesk> helpDeskRowMapper = new BeanPropertyRowMapper<>(HelpDesk.class);
		HelpDesk helpDesk = jdbcTemplate.queryForObject(sql.Sql.HelpDesk.GET_HELPDESK_BY_ID, helpDeskRowMapper,
				helpDeskId);
		helpDesk.setHelpDeskId(helpDeskId);
		return helpDesk;
	}

	// return list of helpdesk
	@Override
	@Transactional
	public List<HelpDesk> getHelpDeskList() {
		RowMapper<HelpDesk> helpDeskMapper = new HelpDeskMapper();
		return this.jdbcTemplate.query(sql.Sql.HelpDesk.GET_ALL_HELPDESK, helpDeskMapper);

	}

	// Create new helpdesk
	@Override
	@Transactional
	public void createHelpDesk(final HelpDesk helpDesk) {
		// KeyHolder keyHolder = new GeneratedKeyHolder(); // generating ids
		jdbcTemplate.update(sql.Sql.HelpDesk.INSERT_HELPDESK, helpDesk.getCompanyId(), helpDesk.getName(),
				helpDesk.getDescription(), helpDesk.getLogo(), helpDesk.getChatAvatar(), helpDesk.getTimeStamp(),
				helpDesk.getCreatedBy(), helpDesk.getUpdatedBy(), helpDesk.getDeletedBy());
	}

	// update helpdesk details
	@Override
	@Transactional
	public void updateHelpDeskDetails(HelpDesk helpDesk) {
		jdbcTemplate.update(sql.Sql.HelpDesk.UPDATE_HELPDESK_BY_ID, helpDesk.getCompanyId(), helpDesk.getName(),
				helpDesk.getDescription(), helpDesk.getLogo(), helpDesk.getChatAvatar(), helpDesk.getTimeStamp(),
				helpDesk.getCreatedBy(), helpDesk.getUpdatedBy(), helpDesk.getDeletedBy(), helpDesk.getHelpDeskId());
	}

	// delete helpdesk
	@Override
	@Transactional
	public void deleteHelpDesk(int helpDeskId) {

		jdbcTemplate.update(sql.Sql.HelpDesk.DELETE_HELPDESK_BY_ID, helpDeskId);
	}

}
