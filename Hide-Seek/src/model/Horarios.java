package model;

public class Horarios {
	
	  private static String[][] horario = {
			  
		        {"0", "0", "0", "0", "0", "0"},
		        {"0", "0", "0", "0", "0", "0"},
		        {"0", "0", "0", "0", "0", "0"},
		        {"0", "0", "0", "0", "0", "0"},
		        {"1", "1", "1", "1", "1", "1"},
		        {"1", "1", "1", "1", "1", "1"},	        
		    };
	  
	  public boolean horarioLibre() {
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                if (horario[i][j].equals("1") ) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	  static void showChairs() {
	        System.out.println("L M C J V S");
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 6; j++) {
	                System.out.print("9:00 - 11:00 " + horario[1][j] + "\n" + 
	                		         "11:00 - 13:00 " + horario[2][j] + "\n" + 
	                		         "13:00 - 15:00 " + horario[3][j] + "\n" + 
	                		         "15:00 - 17:00 " + horario[4][j] + "\n" + 
	                		         "17:00 - 19:00 " + horario[5][j] + "\n" + 
	                		         "19:00 - 21:00 " + horario[6][j] + "\n" );
	            }
	            System.out.println();
	        }
	        System.out.println("\n");
	  
	  
	  
	  }
}