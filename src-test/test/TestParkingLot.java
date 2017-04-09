package test;
import static org.junit.Assert.*;
import main.MainParkingLot;

import org.junit.Test;


public class TestParkingLot {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		
		String[] test1 = {"1", "park LBH-1001 hitam", "status", "leave 0", "status"};
		
		MainParkingLot main = new MainParkingLot();
		main.main(test1);
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2() {
		
		String[] test1 = {"2", "park LBH-1001 hitam", "park CGO-1201 silver",  "status", "leave 1", "status", "park FFV-123 hitam", "status"};
		
		MainParkingLot main = new MainParkingLot();
		main.main(test1);
		
	}

}
