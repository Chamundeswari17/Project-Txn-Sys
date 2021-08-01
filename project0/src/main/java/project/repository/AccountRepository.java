package project.repository;

import project.entity.Account;

public interface AccountRepository {
	
	Account load(String accNumber);
	void update(Account account);

}
