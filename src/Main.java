import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Baby babyPet = new Baby();
	Teen teenPet = new Teen();
	Adult adultPet = new Adult();
	Vector <VPet> vecPet= new Vector<>();
	Inventory inventory = new Inventory();
	StoreFront store = new StoreFront();
	int money = 10;
	

	
	public void view() {
		System.out.println("Money: " + money + " VCoin(s)");
		if(!vecPet.isEmpty()) {
			int idx = 0;
			for(VPet vpet : vecPet) {
				System.out.println("=====================================================");
				System.out.println("No: " + (++idx));
				System.out.println("Name: " + vpet.getPetName());
				System.out.println("Type: " + vpet.getPetType());
				System.out.println("Age: " + vpet.getAge() + " year(s) old, " + vpet.getAgeStat());
				System.out.println("Health: " + vpet.getHealth());
				System.out.println("Happiness: " + vpet.getHappiness());
				System.out.println("Hunger: " + vpet.getHunger());
			}
			System.out.println("=====================================================");
		}
	}
	
	public int countMoney(String playerPetAgeStat, String result) {
		int moneyValue = 0;
		if(playerPetAgeStat.equals("Baby")) {
			moneyValue = babyPet.countWinPrize(result);
		}else if(playerPetAgeStat.equals("Teen")) {
			moneyValue = teenPet.countWinPrize(result);
		}else if(playerPetAgeStat.equals("Adult")) {
			moneyValue = adultPet.countWinPrize(result);
		}
		return moneyValue;
	}
	
	public void createPet() {
	
		String petName = "";
		String petType = "";
		String health = "Healthy";
		String ageStat = "Baby";
		int happiness = 3;
		int hunger = 3;
		int age = 1;
		
		do {
			System.out.print("Input your pet name[3 - 15 characters]: ");
			petName = scan.nextLine();
		}while(petName.length() < 3 || petName.length() > 15);
		do {
			System.out.print("Pet Type [Catto | Doggo | Birb | Snek]: ");
			petType = scan.nextLine();
		}while(!petType.equals("Catto") && !petType.equals("Doggo") && !petType.equals("Birb") && !petType.equals("Snek"));
		
		vecPet.add(new VPet(petName, petType, health, ageStat, happiness, hunger, age));
	}
	
	public int checkPetPlayer(int petIdx, String petAgeStat,int petAge) {
		int limit = 0;
		if(petAgeStat.equals("Baby")) {
			 limit = 3;
		}else if(petAgeStat.equals("Teen")) {
			limit = 5;
		}else if(petAge == 5 || petAge == 6) {
			limit = 7;
		}else if(petAge == 7) {
			limit = 9;
		}
		return limit;
	}
	
	public void play() {
		String result="";
		int choice = 0;
		int petIdx = 0;
		int petAge = 0;
		int happiness = 0;
		int hunger = 0;
		String playerPetAgeStat = "";
		int limit = 0;
		
		
		do {
			System.out.print("Choose pet you want to play with [1.." + vecPet.size() + "]: ");
			try {
				petIdx = scan.nextInt();
			}catch(Exception e) {
				petIdx = 0;scan.nextLine();
			}
			scan.nextLine();
		} while(petIdx < 1 || petIdx > vecPet.size());
		
		if (vecPet.get(petIdx-1).getHealth().equals("Sick")) {
			Tools.cls();
			System.out.println(vecPet.get(petIdx-1).getPetName() + " is too sick to play.");
		}
		
		limit = checkPetPlayer(petIdx, playerPetAgeStat, petAge);
		playerPetAgeStat = vecPet.get(petIdx-1).getAgeStat();
		petAge = vecPet.get(petIdx-1).getAge();
		happiness = vecPet.get(petIdx-1).getHappiness();
		hunger = vecPet.get(petIdx-1).getHunger();
		
		if(hunger > 0) { 
			hunger-=1;					// tiap kali main hunger -1
			vecPet.get(petIdx-1).setHunger(hunger);
			updateHealthCondition(petIdx);
			
			System.out.println("You chose to play with " + vecPet.get(petIdx-1).getPetName() + "!");
			
			scan.nextLine();
			Tools.cls();
			do {
				System.out.println(vecPet.get(petIdx-1).getPetName()+ "'s hunger : " + hunger + "\n");
				choice = 0;
				System.out.println("Play");
				System.out.println("===========");
				System.out.println("1. Rock Paper Scissor");
				System.out.println("2. Guess The Number");
				System.out.println("3. Back");
				System.out.print(">> ");
				try {
					choice = scan.nextInt();
				}catch(Exception e) {
					choice = 0; scan.nextLine();
				}
				scan.nextLine();
				
				switch(choice) {
					case 1:
						RockPaperScissor rps = new RockPaperScissor(vecPet.get(petIdx-1).petName);
						rps.game();
						result = rps.getWinCondition(); //return result: win or lose 
						money+=countMoney(playerPetAgeStat,result); //hitung money prizenya
						if(result.equals("Win")) {
							if(happiness<limit) {
								happiness+=1;
							}
						}else if(result.equals("Lose")) {
							if(happiness > 0) {
								happiness-=1;
							}
						}
						Tools.cls();
						// tiap kali menang happy + 1 kalo kalah happy -1
						break;
					case 2:
						GuessTheNumber gtn = new GuessTheNumber(vecPet.get(petIdx-1).petName); //return result: win or lose
						gtn.game();
						result = gtn.getWinCondition();
						money+=countMoney(playerPetAgeStat,result); //hitung money prizenya
						if(result.equals("Win")) {
							if(happiness<limit) {
								happiness+=1;
							}
						}else if(result.equals("Lose")) {
							if(happiness > 0) {
								happiness-=1;
							}
						}
						Tools.cls();
						break;
				}
			}while(choice!=3);
		}else {
			System.out.println("Your pet hunger is less than 1");
			System.out.println("Press any button...");
			scan.nextLine();
		}
		
	}
	
	public void growUp() {
		int val=0;
		int petIdx = 0;
		String ageStat="";
		int petAge=0, hunger=0, happiness=0;
		int cost = 0;
		do {
			petIdx = 0;
			System.out.print("Which pet do you want to grow up [1.." + vecPet.size() + "]: ");
			try {
				petIdx = scan.nextInt();
			}catch(Exception e) {
				petIdx = 0; scan.nextLine();
			}
			scan.nextLine();
		}while(petIdx < 1 || petIdx > vecPet.size());
		
		String petName = vecPet.get(petIdx-1).getPetName();
		String petType = vecPet.get(petIdx-1).getPetType();
		String health = vecPet.get(petIdx-1).getHealth();
		hunger = vecPet.get(petIdx-1).getHunger();
		happiness = vecPet.get(petIdx-1).getHappiness();
		petAge = vecPet.get(petIdx-1).getAge();
		
			if(petAge == 1 || petAge == 2) {
				cost = 10;
				if(hunger == 3 && happiness == 3) {
					val = 1;
					ageStat = "Baby";
				}
			}else if(petAge == 3 || petAge == 4) {
				cost = 30;
				if(hunger == 5 && happiness == 5) {
					val = 1;
					ageStat = "Teen";
				}
			}else if(petAge == 5 || petAge == 6) {
				cost = 50;
				if(hunger == 7 && happiness == 7) {
					val = 1;
					ageStat = "Adult";
				}
			}else if(petAge == 7) {
				cost = 70;
				if(hunger == 9 && happiness == 9) {
					val = 1;
					ageStat = "Adult";		
				}
			}
			System.out.println("Grow up costs " + cost + " Vcoin(s)");
			String yesno="";
			do {
				System.out.println("Are you sure you want to grow up your pet?[y/n]: ");
				yesno = scan.nextLine();
			}while(!yesno.equals("y") && !yesno.equals("n"));
			if(yesno.equals("y")) {
				if(val==1 && money>=cost) {
					money-=cost;
					petAge+=1;
					happiness+=2;
					hunger+=2;
					vecPet.set(petIdx-1, new VPet(petName, petType, health, ageStat, happiness, hunger, petAge));
				}else {
					System.out.println("Your pet can't grow up yet!");
					System.out.println("All happiness and hunger must be full!");
					System.out.println("Make sure your money is enough!");
					System.out.println("Press any button...");
					scan.nextLine();
				}
			}
		}
	
	public void updateHealthCondition(int petIdx) {
		String petName = vecPet.get(petIdx-1).getPetName();
		String petType = vecPet.get(petIdx-1).getPetType();
		String health = vecPet.get(petIdx-1).getHealth();
		String ageStat = vecPet.get(petIdx-1).getAgeStat();
		int age = vecPet.get(petIdx-1).getAge();
		int happiness = vecPet.get(petIdx-1).getHappiness();
		int hunger = vecPet.get(petIdx-1).getHunger();
		
		if(hunger == 0 || happiness == 0 ) {
			health  = "Sick";
		}else {
			health = "Healthy";
		}
		vecPet.set(petIdx-1, new VPet(petName, petType, health, ageStat, happiness, hunger, age));
	}
	
	public void feedPet(int petIdx) {
		int foodOpt = 0, full = 4;
		int hunger = vecPet.get(petIdx-1).getHunger();
		
		if (inventory.getCheapFeedAmount() == 0 && inventory.getHealthyFeedAmount() == 0) {
			Tools.cls();
			System.out.println("Food inventory is empty");
			System.out.println("Press enter to go back....");
			Tools.enterToContinue();
		} else {
			System.out.println("Pick a food:");
			System.out.println("1. Cheap Feed x" + inventory.getCheapFeedAmount());
			System.out.println("2. Delicious Feed x" + inventory.getHealthyFeedAmount());
			System.out.println("3. Medicine x" + inventory.getMedicineAmount());
			System.out.println("4. Cancel");
			System.out.print(">> ");
			try {
				foodOpt = scan.nextInt();
			} catch (Exception e) {
				foodOpt = 0; scan.nextLine();
			}
			
			if (inventory.getCheapFeedAmount() == 0 && foodOpt == 1) {
				Tools.cls();
				System.out.println("Food is unavailable\n\n\n");
				System.out.println("Press enter to go back....");
				Tools.enterToContinue();
			} else if (inventory.getHealthyFeedAmount() == 0 && foodOpt == 2) {
				Tools.cls();
				System.out.println("Food is unavailable\n\n\n");
				System.out.println("Press enter to go back....");
				Tools.enterToContinue();
			} else if (inventory.getMedicineAmount() == 0 && foodOpt == 3) {
				Tools.cls();
				System.out.println("Food is unavailable\n\n\n");
				System.out.println("Press enter to go back....");
				Tools.enterToContinue();
			} else {
				switch (foodOpt) {
				case 1:
					CheapFeed cheapFeed = new CheapFeed();
					
					vecPet.get(petIdx - 1).setHunger(cheapFeed.restoreHunger(hunger));
					
					inventory.setCheapFeedAmount(inventory.getCheapFeedAmount()-1);
					break;
				case 2:
					HealthyFeed healthyFeed = new HealthyFeed();
					
					vecPet.get(petIdx - 1).setHunger(healthyFeed.restoreHunger(hunger));
					
					inventory.setHealthyFeedAmount(inventory.getHealthyFeedAmount()-1);
					break;
				case 3:
					Medicine medicine = new Medicine();
					
					vecPet.get(petIdx-1).setHealth(medicine.cureSickness(vecPet.get(petIdx-1).getHealth()));
					vecPet.get(petIdx-1).setHunger(medicine.restoreHunger(vecPet.get(petIdx-1).getHunger()));
					vecPet.get(petIdx-1).setHappiness(medicine.cureSadness(vecPet.get(petIdx-1).getHappiness()));
					
					inventory.setMedicineAmount(inventory.getHealthyFeedAmount()-1);
					break;
				}
				if (vecPet.get(petIdx-1).getHunger() > full) {
					vecPet.get(petIdx-1).setHunger(full);
				}
				
				Tools.cls();
				System.out.println(vecPet.get(petIdx-1).getPetName() + " is thankful!\n\n\n");
				Tools.enterToContinue();
			}
		}
	}
	
	public void openStore() {
		int storeOpt = 0;
		
		
		do {
			
		Tools.cls();
		System.out.println("\t\tWelcome to the shop!");
		System.out.println("Your Money : " + money);
		System.out.println("=====================================================");
		System.out.println("Food Name \t\tPrice");
		System.out.println("=====================================================");
		System.out.println("1. Cheap Feed \t\t" + store.getCheapFoodPrice());
		System.out.println("2. Delicious Feed \t" + store.getHealthyFoodPrice());
		System.out.println("3. Medicine \t\t" + store.getMedicine());
		System.out.println("=====================================================\n");
		System.out.println("4. Exit");
		System.out.print(">> ");

		try {
			storeOpt = scan.nextInt();
		} catch (Exception e) {
			storeOpt = 0; scan.nextLine();
		}
		scan.nextLine();
		
		switch (storeOpt) {
		case 1:
			if (money < 5) {
				Tools.cls();
				System.out.println("Money is not enough!");
				Tools.enterToContinue();
			} else {
				money -= 5;
				inventory.setCheapFeedAmount(inventory.getCheapFeedAmount()+1);
			}
			break;
		case 2:
			if (money < 10) {
				Tools.cls();
				System.out.println("Money is not enough!");
				Tools.enterToContinue();
			} else {
				money -= 10;
				inventory.setHealthyFeedAmount(inventory.getHealthyFeedAmount()+1);
			}
			break;
		case 3:
			if (money < 20) {
				Tools.cls();
				System.out.println("Money is not enough!");
				Tools.enterToContinue();
			} else {
				money -= 20;
				inventory.setMedicineAmount(inventory.getMedicineAmount()+1);
			}
		}
		
		} while (storeOpt != 4);

		Tools.cls();
		System.out.println("Thank you for your purchase!\n\n\n");
		Tools.enterToContinue();
	}
	
	public Main() {
		
		int choice = 0 ; 
		
		System.out.println("Virtual Pet");
		System.out.print("\n\n\nPress any button...");
		scan.nextLine();
	
		do {
			Tools.cls();
			view();
			System.out.println("\n");
			choice = 0;
			System.out.println("       Menu");
			System.out.println("==================");
			System.out.println("1. Create Vpet");
			System.out.println("2. Play Vpet");
			System.out.println("3. Feed Vpet");
			System.out.println("4. Shop");
			System.out.println("5. Grow Up");
			System.out.println("6. Exit");
			System.out.print(">> ");
			try {
				choice = scan.nextInt();
			}catch(Exception e) {
				choice = 0;scan.nextLine();
			}
			scan.nextLine();
	
			switch(choice) {
				case 1:
					Tools.cls();
					createPet();
					break;
				case 2:
					Tools.cls();
					if(!vecPet.isEmpty()) {
						view();
						System.out.println();
						play();
					} else {
						System.out.println("There's no pet to play with\n\n\n");
						System.out.println("Press enter to go back....");
						Tools.enterToContinue();
					}
					break;
				case 3:
					int petNum = 0;
					int next = 1;
					
					Tools.cls();
					if (vecPet.isEmpty()) {
						System.out.println("There's no pet to feed\n\n\n");
						System.out.println("Press enter to go back....");
						Tools.enterToContinue();
					} else {
						System.out.println("Choose a pet you want to feed:");
						for (VPet vPet : vecPet) {
							System.out.println(next + ". " + vPet.getPetName() + "(Hunger : " + vPet.getHunger() + ")"); next++;
						}
						System.out.print(">> ");
						petNum = scan.nextInt();
						
						if (vecPet.get(petNum-1).getHunger() == 4) {
							Tools.cls();
							System.out.println(vecPet.get(petNum-1).getPetName() + " is already full\n\n\n");
							System.out.println("Press enter to go back....");
							Tools.enterToContinue();
						} else {
							feedPet(petNum);
						}
					}
					break;
				case 4:
					openStore();
					break;
				case 5:
					Tools.cls();
					if(!vecPet.isEmpty()) {
						view();
						System.out.println();
						growUp();
					}
					else {
						System.out.println("There's no pet");
						System.out.println("Press enter to back....");
						Tools.enterToContinue();
					}
					break;
			}
		}while(choice !=6);
	}

	public static void main(String[] args) {
		new Main();
	}

}
