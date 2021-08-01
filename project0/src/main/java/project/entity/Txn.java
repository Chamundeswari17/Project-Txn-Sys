package project.entity;

	import java.sql.Timestamp;
import java.time.LocalDateTime;

	public class Txn {


		private int id;
		private double amount;
//		private LocalDateTime dateTime;
		private String debAccID;
		private String creAccID;
		private Timestamp dateTime;

		public Txn(double amount) {
			super();
			this.amount = amount;
		}

		public Timestamp getDate() {
			return dateTime;
		}

		public void setDat(Timestamp dateTime) {
			this.dateTime = dateTime;
		}

		public Txn() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getDebAccID() {
			return debAccID;
		}

		public void setDebAccID(String debAccID) {
			this.debAccID = debAccID;
		}

		public String getCreAccID() {
			return creAccID;
		}

		public void setCreAccID(String creAccID) {
			this.creAccID = creAccID;
		}

		@Override
		public String toString() {
			return "Transaction [id=" + id + ", amount=" + amount + ", debAccID=" + debAccID + ", creAccID=" + creAccID
					+ ", dateTime=" + dateTime + "]";
		}

		
		

	}