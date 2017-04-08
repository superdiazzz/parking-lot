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
		
		Map<Integer, Vihacle> map = new HashMap<Integer, Vihacle>();
		
		for(int k =0; k<n; k++){
			String actWrite = reader.nextLine();
			groupingVihacle(actWrite, map, k);	
		}
		
		
		String actWrite = reader.nextLine();
		String action = getAction(actWrite);
		if("PARK".equalsIgnoreCase(action)){
			
		}else if("LEAVE".equalsIgnoreCase(action)){
			
		}else if("STATUS".equalsIgnoreCase(action)){
			showStatus(map);
		}
			
		
	}

	private static void showStatus(Map<Integer, Vihacle> map) {
		// TODO Auto-generated method stub
		
	}

	private static String getAction(String actWrite) {
		String[] str = actWrite.split("\\s");
		String act = str[0];
		String cleanAct = act.toUpperCase();
		return cleanAct;
	}

	private static void groupingVihacle(String write, Map<Integer, Vihacle> map, int number) {
		
		String[] idVcRaw = write.split("\\s+");
		String idVc = idVcRaw[0];
		String col = idVcRaw[1];
		
		Vihacle vc = new Vihacle();
		vc.setIdNumber(idVc);
		vc.setColour(col);
		vc.setNo(number);
		
		map.put(number, vc);
		
	}

}
