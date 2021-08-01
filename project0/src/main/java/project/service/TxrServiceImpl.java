package project.service;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import project.entity.Account;
import project.entity.Txn;
import project.entity.TxnType;
import project.repository.AccountRepository;
import project.repository.TxnRepository;

public class TxrServiceImpl implements TxrService {
	private static Logger logger = Logger.getLogger("txr-system");

	private AccountRepository accountRepository;
	

	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void transfer(double amount, String fromAcc, String toAcc) {

		logger.info("Transaction intiated...");

		Account fromAccount = accountRepository.load(fromAcc);

		if (fromAccount == null) {
			logger.error("Account not found " + fromAcc);
			throw new AccountNotFoundExeption(fromAcc);
		}

		Account toAccount = accountRepository.load(toAcc);

		if (toAccount == null) {
			logger.error("Account not found " + toAcc);
			throw new AccountNotFoundExeption(toAcc);
		}

		if (fromAccount.getBalance() < amount) {
			logger.error("No enough balance " + fromAccount.getBalance());
			throw new AccountBalanceException(fromAccount.getBalance());
		}

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

//		Transaction debitTransaction = new Transaction(amount);
//		debitTransaction.setAccount(fromAccount);
//
//		Transaction creditTransaction = new Transaction(amount);
//		creditTransaction.setAccount(toAccount);
		
		TxnRepository.save(amount, fromAccount, toAccount);
		// TransactionRepository.save(creditTransaction)
		
		

		logger.info("Transaction success...");

	}

}
