package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UsersDao;
import DiamonShop.Entity.UsersEntity;

@Service
public class AccountService implements IAccountService{
	@Autowired
	 UsersDao usersDao = new UsersDao();
	
	public int AddAccount(UsersEntity user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		
		return usersDao.AddAccount(user);
	}

	@Override
	public UsersEntity CheckAccount(UsersEntity user) {
		
		String pass = user.getPassword();
		user = usersDao.GetUserByAccount(user);
		if(user!=null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}
}
