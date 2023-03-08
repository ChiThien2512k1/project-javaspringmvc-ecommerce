package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<UsersEntity>{

	@Override
	public UsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setId(rs.getLong("id"));
		usersEntity.setUser(rs.getString("user"));
		usersEntity.setPassword(rs.getString("password"));
		usersEntity.setDisplay_name(rs.getString("display_name"));
		usersEntity.setAddress(rs.getString("address"));
		return usersEntity;
	}

}
