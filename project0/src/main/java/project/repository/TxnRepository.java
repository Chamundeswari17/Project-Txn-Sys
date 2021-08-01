package project.repository;

	import java.security.Timestamp;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
	import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import project.entity.Account;
import project.entity.Txn;

	public interface TxnRepository {

		public static void save1(double amount, Account fromAccount, Account toAccount) {
			Connection connection = null;
			try {
//				connection = ConnectionFactory.getConnection();
				java.util.Date date = new  Date(0);
				String sql = "insert into transaction(amount, debAccID, creAccID,dateTime) values(?, ?, ?, ?)";
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
				
				
				ps.setDouble(1, amount);
				ps.setString(2, fromAccount.getId());
				ps.setString(3, toAccount.getId());
//				ps.setDat(4, new Timestamp(date.setDat()));
				ps.execute();
				System.out.println("Transaction Updated......");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		

		List<Txn> findByCount(int count, String accNum);
		List<Txn> findByMonth(int count, String accNum);
		List<Txn> findByDateRange(LocalDate fromDate,LocalDate toDate,String accNum);


		static void save(double amount, Account fromAccount, Account toAccount) {
			// TODO Auto-generated method stub
			
		}



	}
	

