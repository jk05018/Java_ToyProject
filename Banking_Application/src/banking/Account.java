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
			System.out.println("0원은 입력할 수 없습니다");
		}
	}
	
	void withdraw(int amount) {
		if(amount!=0) {
			balance -= amount;
			previousTransaction = -amount;
		}
		else {
			System.out.println("0원은 입력할 수 없습니다");
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
		System.out.println("현재 이자율 : "+ (interestRate*100));
		System.out.println(year+"년 뒤의 당신의 잔고는 :" + newBalance);
	}
	
	
	void showMenu() {
		char option ='\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("안녕하세요! "+ customerName+ "님");
		System.out.println(customerName+"님의 Id : " + customerId);
		System.out.println();
		
		System.out.println("무엇을 원하시는가요?");
		System.out.println();
		
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
	
		
		do {
			System.out.println();
			System.out.println("옵션을 고르세요!");
			char option1 = scanner.next().charAt(0);// Scanner는 문자열을 받는데 이 중 하나를 단어 하나로 변경
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
				System.out.println("입금하실 금액을 입력하세요!");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				System.out.println();
				break;
			case 'C':
				System.out.println("출금하실 금액을 입력하세요");
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
				System.out.println("계산하실 년도를 입력해주세요!");
				System.out.println();
				int interestYear = scanner.nextInt();
				System.out.println("======================");
				calculateInterest(interestYear);
				System.out.println("======================");
			case 'F':
				System.out.println("======================");
				break;
			default:
				System.out.println("에러 발생 ABCDEF 중 하나를 입력하세요");
				break;
			}
			} while(option!='F');
				System.out.println("이용해주셔서 감사합니다!");
			
		
		
		}
	
}
