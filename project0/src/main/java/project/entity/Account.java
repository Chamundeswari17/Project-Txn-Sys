package project.entity;

	public class Account {

		private String num;
		private double balance;

		public Account(String num, double balance) {
			super();
			this.num = num;
			this.balance = balance;
		}

		public Account() {
			super();
		}

		public String getId() {
			return num;
		}

		public void setId(String id) {
			this.num = id;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Account [id=" + num + ", balance=" + balance + "]";
		}
	}
