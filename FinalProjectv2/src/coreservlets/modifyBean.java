package coreservlets;

import java.util.ArrayList;

public class modifyBean {
private ArrayList<String>  Info;
	
	public String getInfo() {
		String outStr="";
		for (String s: Info)
			outStr = outStr + s;
		return outStr;
	}

	public void setInfo(ArrayList<String> info) {
		this.Info = info;

	}
}
