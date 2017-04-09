package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Vihacle;


public class MainParkingLot {
	
	public final static String REGISTRATION_NUMBER = "registration_number_for_cars_with_colour";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//System.out.println("Hello world, by nanda");
		
		Scanner reader = new Scanner(System.in);
		System.out.println("create_parking_lot :");
		final int n = reader.nextInt();
		
		System.out.println("Created a parking lot with "+n+" slots");
		
		final Map<Integer, Vihacle> map = new HashMap<Integer, Vihacle>();
		for(int k =0; k<n; k++){
			Scanner reader2 = new Scanner(System.in);
			String actWrite = reader2.nextLine();
			groupingVihacle(actWrite, map, k);	
			System.out.println("Allocated slot number : "+k);
		}
		
		final Scanner reader3 = new Scanner(System.in);
		
		new Thread(){
			public void run(){
				 boolean isRunning = true;
				while(isRunning){
					String next = reader3.nextLine();
					String action = getAction(next);
					if("PARK".equalsIgnoreCase(action)){
						System.out.println("panggil PARK");
						// cek apakah jumlah spacenya sesuai
						int space = map.size();
						if(space<n){
							// bisa diisi
							int lostNum = getLostNum(map, n);
							groupingVihacle(next, map, lostNum);
							
						}else{
							// full
							System.out.println("Sorry, parking lot is full");
						}
						
					}else if("LEAVE".equalsIgnoreCase(action)){
						System.out.println("panggil LEAVE- no action");
						int noLeave = getNoLeave(next);
						removeMapContain(map, noLeave);
						System.out.println("Slot number "+noLeave+" is Free");
					
					}else if("STATUS".equalsIgnoreCase(action)){
						showStatus(map);
						
					}else if(REGISTRATION_NUMBER.equalsIgnoreCase(action)){
						String col = getThatCars(next);
						showTheCars(col, map);
					}
					else if("EXIT".equalsIgnoreCase(action)){
						isRunning = false;
						System.out.println("THREAD STOP");
					}else{
						System.out.println("CHECK YOUR ACTION");
					}
				}
			}

			private void showTheCars(String col, Map<Integer, Vihacle> map) {
				List<String> cars = new ArrayList<String>();
				for(Map.Entry<Integer, Vihacle> entry : map.entrySet()){
					String mapCol = entry.getValue().getColour();
					if(col.equalsIgnoreCase(mapCol)){
						cars.add(entry.getValue().getIdNumber());
					}
				}
				System.out.println(cars.toString());
			}

			private String getThatCars(String next) {
				String[] arr = next.split("\\s");
				String col = arr[1];
				return col;
			}

			private int getLostNum(Map<Integer, Vihacle> map, int space) {
				int sizeMap = map.size();
				int findLostNum = 0;
				for(int i =0; i<space; i++){
					for(Map.Entry<Integer, Vihacle> entry : map.entrySet()){
						int key = entry.getKey();
						if(i!=key){
							findLostNum = i;
							break;
						}	
					}	
				}
				return findLostNum;
			}

			private int getNoLeave(String next) {
				String[] arr = next.split("\\s");
				String str = arr[1];
				int intStr = Integer.valueOf(str);
				return intStr;
			}

			private void removeMapContain(Map<Integer, Vihacle> map, int no) {
				Iterator<Map.Entry<Integer, Vihacle>> iter = map.entrySet().iterator();
				while(iter.hasNext()){
					Map.Entry<Integer, Vihacle> entry = iter.next();
					int num = entry.getKey();
					if(num==no){
						iter.remove();
					}
				}
				
			}

		}.start();
		
	}

	private static void showStatus(Map<Integer, Vihacle> map) {
		System.out.println("No    Registration No.    Colour");
		for(Map.Entry<Integer, Vihacle> entry : map.entrySet()){
			String idVihacle = entry.getValue().getIdNumber();
			String colour = entry.getValue().getColour();
			int no = entry.getKey();
			System.out.println(""+no+"      "+idVihacle+"          "+colour);
		}
		
	}

	private static String getAction(String actWrite) {
		String[] str = actWrite.split("\\s");
		String act = str[0];
		String cleanAct = act.toUpperCase();
		return cleanAct;
	}

	private static void groupingVihacle(String write, Map<Integer, Vihacle> map, int number) {
		
		String[] idVcRaw = write.split("\\s");
		String idVc = idVcRaw[1];
		String col = idVcRaw[2];
		
		Vihacle vc = new Vihacle();
		vc.setIdNumber(idVc);
		vc.setColour(col);
		vc.setNo(number);
		
		map.put(number, vc);
		
	}

}
