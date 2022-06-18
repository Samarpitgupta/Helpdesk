package sql;

public interface Sql {
	public interface Login {
		final String LOGIN_QUERY = "select user_name, password,user_id,role_id, company_id,email,avatar from users where user_name='%s' and password='%s'";
	}

	public interface HelpDesk {
		final String INSERT_HELPDESK = "INSERT into help_desk(company_id,name,description,logo,chat_avatar,time_stamps,created_by,updated_by,deleted_by) VALUES(?,?,?,?,?,?,?,?,?);";
		final String GET_ALL_HELPDESK = "SELECT * from help_desk where is_active=true;";
		final String GET_HELPDESK_BY_ID = "SELECT * from help_desk where help_deskid= ?;";
		final String DELETE_HELPDESK_BY_ID = "UPDATE help_desk SET  is_active = false  WHERE help_deskid=?";
		final String UPDATE_HELPDESK_BY_ID = "UPDATE help_desk SET company_id=?, name=?, description=?,logo=?,"
				+ "chat_avatar=?,time_stamps=?,created_by=?,updated_by=?, deleted_by=? WHERE help_deskid=?";
	}
}
