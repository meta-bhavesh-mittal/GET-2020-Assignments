let dollarPerRuppee = 0.014;
let yenPerRuppee = 1.54;
let cyclePassPrice = [ 5, 100, 500 ];
let motorCyclePassPrice = [ 10, 200, 1000 ];
let fourWheelersPassPrice = [ 20, 500, 3500 ];

function convertCurrency(passPrice) {
	currencyTypeElement = document.getElementById("currencyType");
	currencyType = currencyTypeElement.options[currencyTypeElement.selectedIndex].value;
	if (currencyType == "USD") {
		document.getElementById("showPassPrice").innerHTML = passPrice
				* dollarPerRuppee;
	} else if (currencyType == "YEN") {
		document.getElementById("showPassPrice").innerHTML = passPrice
				* yenPerRuppee;
	} else {
		document.getElementById("showPassPrice").innerHTML = passPrice;
	}
}

function updatePassPrice(vehicleType) {
	document.getElementById("pass-div").style.visibility = "visible";
	passTypeElement = document.getElementById("passType");
	passType = passTypeElement.options[passTypeElement.selectedIndex].value;
	if (vehicleType == "cycle") {
		if (passType == "daily") {
			document.getElementById("passPrice").value = cyclePassPrice[0];
			convertCurrency(cyclePassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passPrice").value = cyclePassPrice[1];
			convertCurrency(cyclePassPrice[1]);
		} else {
			document.getElementById("passPrice").value = cyclePassPrice[2];
			convertCurrency(cyclePassPrice[2]);
		}
	} else if (vehicleType == "motorcycle") {
		if (passType == "daily") {
			document.getElementById("passPrice").value = motorCyclePassPrice[0];
			convertCurrency(motorCyclePassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passPrice").value = motorCyclePassPrice[1];
			convertCurrency(motorCyclePassPrice[1]);
		} else {
			document.getElementById("passPrice").value = motorCyclePassPrice[2];
			convertCurrency(motorCyclePassPrice[2]);
		}
	} else {
		if (passType == "daily") {
			document.getElementById("passPrice").value = fourWheelersPassPrice[0];
			convertCurrency(fourWheelersPassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passPrice").value = fourWheelersPassPrice[1];
			convertCurrency(fourWheelersPassPrice[1]);
		} else {
			document.getElementById("passPrice").value = fourWheelersPassPrice[2];
			convertCurrency(fourWheelersPassPrice[2]);
		}
	}

}
