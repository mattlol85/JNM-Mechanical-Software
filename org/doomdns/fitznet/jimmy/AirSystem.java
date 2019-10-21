package org.doomdns.fitznet.jimmy;

public class AirSystem {
	
String modelName;
double unitPrice;
int Btu;

//No Arg
public AirSystem() {
	modelName = "";
	unitPrice = 0.0;
	Btu = 0;
}

//Getters
public String getModelName() {
	return modelName;
}

public double getUnitPrice() {
	return unitPrice;
}

//Setters
public void setModelName(String modelName) {
	this.modelName = modelName;
}

public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}

}
