package banking;

import java.util.Scanner;

public class Account {
	//class variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	// class constructor
	Account(String customerName, String customerId){
		this.customerName = customerName;
		this.customerId = customerId;
		
		
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}else {
			System.out.println("0���� �Է��� �� �����ϴ�");
		}
	}
	
	void withdraw(int amount) {
		if(amount!=0) {
			balance -= amount;
			previousTransaction = -amount;
		}
		else {
			System.out.println("0���� �Է��� �� �����ϴ�");
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: "+ previousTransaction);
		}else if(previousTransaction < 0) {
			System.out.println("WithDrawn: "+ (-previousTransaction));
		}else {
			System.out.println(" no transaction occured");
		}
	}
	
	void calculateInterest(int year) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * year) + balance;
		System.out.println("���� ������ : "+ (interestRate*100));
		System.out.println(year+"�� ���� ����� �ܰ�� :" + newBalance);
	}
	
	
	void showMenu() {
		char option ='\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ȳ��ϼ���! "+ customerName+ "��");
		System.out.println(customerName+"���� Id : " + customerId);
		System.out.println();
		
		System.out.println("������ ���Ͻô°���?");
		System.out.println();
		
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
	
		
		do {
			System.out.println();
			System.out.println("�ɼ��� ������!");
			char option1 = scanner.next().charAt(0);// Scanner�� ���ڿ��� �޴µ� �� �� �ϳ��� �ܾ� �ϳ��� ����
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("======================");
				System.out.println("Balance = $" + balance);
				System.out.println("======================");
				System.out.println();
				break;
			case 'B':
				System.out.println("�Ա��Ͻ� �ݾ��� �Է��ϼ���!");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				System.out.println();
				break;
			case 'C':
				System.out.println("����Ͻ� �ݾ��� �Է��ϼ���");
				int WithdrawAmount = scanner.nextInt();
				withdraw(WithdrawAmount);
				System.out.println();
				break;
			case 'D':
				System.out.println("======================");
				getPreviousTransaction();
				System.out.println("======================");
				break;
			case 'E':
				System.out.println("����Ͻ� �⵵�� �Է����ּ���!");
				System.out.println();
				int interestYear = scanner.nextInt();
				System.out.println("======================");
				calculateInterest(interestYear);
				System.out.println("======================");
			case 'F':
				System.out.println("======================");
				break;
			default:
				System.out.println("���� �߻� ABCDEF �� �ϳ��� �Է��ϼ���");
				break;
			}
			} while(option!='F');
				System.out.println("�̿����ּż� �����մϴ�!");
			
		
		
		}
	
}
