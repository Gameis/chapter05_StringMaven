package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import lombok.Setter;
import user.bean.UserDTO;

public interface UserDAO {
	
	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public UserDTO getUser(String id);

	public void update(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> search(Map<String, Object> map);

}
