package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println("1. 이름 입력");
		System.out.println("2. 아이디 입력");
		num = sc.nextInt();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(num == 1) {
			System.out.print("이름 입력 :");
			map.put("key", "name");
			map.put("value", sc.next());
		}else if(num == 2) {
			System.out.print("아이디 입력 : ");
			map.put("key", "id");
			map.put("value", sc.next());
		}else {
			System.out.println("땡~");
		}
		
		if(map.size() != 0) {
			List<UserDTO> list = userDAO.search(map);
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName() + "\t"
								 + userDTO.getId() + "\t"
								 + userDTO.getPwd() + "\t");
			}
		}else {
			System.out.println("이상해요");
		}
	}

}
