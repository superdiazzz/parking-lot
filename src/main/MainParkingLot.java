package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Vihacle;


public class MainParkingLot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//System.out.println("Hello world, by nanda");
		Scanner reader = new Scanner(System.in);
		System.out.println("create_parking_lot :");
		int n = reader.nextInt();
		
		System.out.println("Created a parking lot with "+n+" slots");
		
		final Map<Integer, Vihacle> map = new HashMap<Integer, Vihacle>();
		for(int k =0; k<n; k++){
			Scanner reader2 = new Scanner(System.in);
			String actWrite = reader2.nextLine();
			groupingVihacle(actWrite, map, k);	
		}
		
		final Scanner reader3 = new Scanner(System.in);
		
		new Thread(){
			public void run(){
				while(true){
					String next = reader3.next();
					//String actWrite = reader3.nextLine();
					String action = getAction(next);
					if("PARK".equalsIgnoreCase(action)){
						System.out.println("panggil PARK - no action");
					}else if("LEAVE".equalsIgnoreCase(action)){
						System.out.println("panggil LEAVE- no action");
						
					}else if("STATUS".equalsIgnoreCase(action)){
						showStatus(map);
					}else if("EXIT".equalsIgnoreCase(action)){
						
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
			System.out.println(""+no+"    "+idVihacle+"        "+colour);
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
