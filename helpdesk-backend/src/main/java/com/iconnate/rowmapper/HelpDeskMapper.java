package com.iconnate.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iconnate.model.HelpDesk;

/**
 * @author samarpit
 *
 */
public class HelpDeskMapper implements RowMapper<HelpDesk> {

	@Override
	public HelpDesk mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpDesk helpDesk = new HelpDesk();
		helpDesk.setHelpDeskId(rs.getInt("help_deskid"));
		helpDesk.setCompanyId(rs.getInt("company_id"));
		helpDesk.setDescription(rs.getString("description"));
		helpDesk.setName(rs.getString("name"));
		helpDesk.setChatAvatar(rs.getString("chat_avatar"));
		helpDesk.setTimeStamp(rs.getDate("time_stamps"));
		helpDesk.setCreatedBy(rs.getString("created_by"));
		helpDesk.setLogo(rs.getString("logo"));
		helpDesk.setDeletedBy(rs.getString("deleted_by"));
		helpDesk.setCreatedBy(rs.getString("created_by"));
		helpDesk.setUpdatedBy(rs.getString("updated_by"));
		helpDesk.setIsActive(rs.getBoolean("is_active"));
		return helpDesk;
	}

}
