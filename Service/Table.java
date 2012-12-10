package Service;

public class Table {
	private String []tableStatus = new String[4];
	private String []tableStatusList = {"Libre","OccupéeParMoi", "OccupéeParAutre"};

	
	public Table(){
		tableStatus[0] = tableStatusList[0];
		tableStatus[1] = tableStatusList[0];
		tableStatus[2] = tableStatusList[0];
		tableStatus[3] = tableStatusList[0];
	}

	public String getStatus(int tableCode){
		return tableStatus[tableCode];
	}
	
	public void setStatus(int tableCode, String tableStat){
		tableStatus[tableCode] = tableStat;
	}
	
	public String[] getStatusList(){
		return tableStatusList;
	}
}
