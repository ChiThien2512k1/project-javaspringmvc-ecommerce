package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.UsersEntity;
@Service
public interface IAccountService {
	public int AddAccount(UsersEntity user);
	public UsersEntity CheckAccount(UsersEntity user);
}
