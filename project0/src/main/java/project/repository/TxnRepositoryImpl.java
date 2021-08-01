package project.repository;

	import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import project.database.ConnectionFactory;
import project.entity.Txn;

	public class TxnRepositoryImpl implements TxnRepository {


		public void save(Txn txn) {
			// TODO Auto-generated method stub

		}

		public List<Txn> findByCount(int count, String accNum) {
			
			List<Txn> transactions = new ArrayList<>();

			Connection connection = null;
			try {
				connection = (Connection) ConnectionFactory.getConnection();

				String sql = "select * from Transaction where debAccID=" + accNum+ " LIMIT " +count;
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Txn transaction = new Txn();
					transaction.setDebAccID(rs.getString("creAccID"));
					transaction.setAmount(rs.getDouble(2));
					transaction.setId(rs.getInt(1));
					transaction.setCreAccID(accNum);
					transaction.setDat(rs.getTimestamp(5));	
					transactions.add(transaction);
				}

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

			return transactions;
		}

		public List<Txn> findByMonth(int count, String accNum) {
			
			return null;
		}

		public List<Txn> findByDateRange(LocalDate fromDate, LocalDate toDate, String accNum) {
			
			List<Txn> transactions = new ArrayList<>();

			java.sql.Connection connection = null;
			try {
				connection = ConnectionFactory.getConnection();

				String sql = "select * from Transaction where debAccID=" + accNum+ " and dateTime between '2021-07-11 18:22:37' and '2021-07-11 18:52:44'";
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Txn transaction = new Txn();
					transaction.setDebAccID(rs.getString("creAccID"));
					transaction.setAmount(rs.getDouble(2));
					transaction.setId(rs.getInt(1));
					transaction.setCreAccID(accNum);
					transaction.setDat(rs.getTimestamp(5));	
					transactions.add(transaction);
				}

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

			return transactions;
		}

//		@Override
//		public void save(double amount, Account fromAccount, Account toAccount) {
//			Connection connection = null;
//			try {
//				connection = ConnectionFactory.getConnection();
	//
//				String sql = "insert into transaction(amount, debAccID, creAccID) values(?, ?, ?)";
//				PreparedStatement ps = connection.prepareStatement(sql);
//				ps.setDouble(2, amount);
//				ps.setString(3, fromAccount.getId());
//				ps.setString(4, toAccount.getId());
//				ps.execute();
//				System.out.println("Transaction Updated......");
	//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				if (connection != null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
	}
