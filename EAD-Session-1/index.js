var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var USD_RATE = 0.014;
var YEN_RATE = 1.53;
var vehicleType1;
var vehicleType2;
var pricedaily;
var pricemonthly;
var priceyearly;
var cur;



function checkValidation() {
    var name = document.getElementById('name').value;
    var email = document.getElementById("email").value;
    var mobile = document.getElementById("mobile").value;
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;
    var empId = Math.floor(Math.random() * 1000);
    document.getElementById("empRegisterForm").innerHTML = "<fieldset><legend><b>Employee Registration Form</b></legend><h1>Employee registered !!<br>Registration number :<h1>" + empId + "<br></fieldset>";
    document.getElementById("EmployeeId").value = empId;

}



function vechileRegestration() {
    var e = document.getElementById("vehicletype");
    vechileType = e.options[e.selectedIndex].value;

    var vehicleType1 = document.getElementById("vehicletype").value;

    if (vehicleType1 == "cycle") {
        vehicleType2 = 0;
    } else if (vehicleType1 == "motorCycle") {
        vehicleType2 = 1;
    } else if (vehicleType1 == "fourWheelers") {
        vehicleType2 = 2;
    }


    document.getElementById("vehicleReg").innerHTML = "<fieldset><legend><b>Vehicle Registration Form</b></legend><h1>Vehicle registered !!<br></fieldset>";


    if (vechileType == "cycle") {

        document.getElementById("passCycle").style.display = "block";
        document.getElementById("passMotorCycle").style.display = "none";
        document.getElementById("passFourWheeler").style.display = "none";



    } else if (vechileType == "motorCycle") {
        document.getElementById("passMotorCycle").style.display = "block";
        document.getElementById("passCycle").style.display = "none";
        document.getElementById("passFourWheeler").style.display = "none";


    } else if (vechileType == "fourWheelers") {
        document.getElementById("passFourWheeler").style.display = "block";
        document.getElementById("passCycle").style.display = "none";
        document.getElementById("passMotorCycle").style.display = "none";
    }

}



function changeCurrency() {
    var currencyType = document.getElementById("amount0").value;

    if (currencyType == "INR0") {
        cur = document.getElementById("amount0").value;
        document.getElementById("dailyprice").innerHTML = price[vehicleType2][0] + " INR";
        pricedaily = price[vehicleType2][0];
        document.getElementById("monthlyprice").innerHTML = price[vehicleType2][1] + " INR";
        pricemonthly = price[vehicleType2][1];
        document.getElementById("yearlyprice").innerHTML = price[vehicleType2][2] + " INR";
        priceyearly = price[vehicleType2][2];

    } else if (currencyType == "USD0") {
        cur = document.getElementById("amount0").value;
        document.getElementById("dailyprice").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        pricedaily = (price[vehicleType2][0] * USD_RATE).toFixed(2);
        document.getElementById("monthlyprice").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        pricemonthly = (price[vehicleType2][1] * USD_RATE).toFixed(2);
        document.getElementById("yearlyprice").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceyearly = (price[vehicleType2][2] * USD_RATE).toFixed(2);


    } else if (currencyType == "YEN0") {
        cur = document.getElementById("amount0").value;
        document.getElementById("dailyprice").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        pricedaily = (price[vehicleType2][0] * YEN_RATE).toFixed(2);
        document.getElementById("monthlyprice").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        pricemonthly = (price[vehicleType2][1] * YEN_RATE).toFixed(2);
        document.getElementById("yearlyprice").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceyearly = (price[vehicleType2][2] * YEN_RATE).toFixed(2);

    }
}







function changeCurrency1() {
    var currencyType = document.getElementById("amount1").value;

    if (currencyType == "INR1") {
        cur = document.getElementById("amount1").value;
        document.getElementById("dailyprice1").innerHTML = price[vehicleType2][0] + " INR";
        pricedaily = price[vehicleType2][0];
        document.getElementById("monthlyprice1").innerHTML = price[vehicleType2][1] + " INR";
        pricemonthly = price[vehicleType2][1];
        document.getElementById("yearlyprice1").innerHTML = price[vehicleType2][2] + " INR";
        priceyearly = price[vehicleType2][2];

    } else if (currencyType == "USD1") {
        cur = document.getElementById("amount1").value;
        document.getElementById("dailyprice1").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        pricedaily = (price[vehicleType2][0] * USD_RATE).toFixed(2);
        document.getElementById("monthlyprice1").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        pricemonthly = (price[vehicleType2][1] * USD_RATE).toFixed(2);
        document.getElementById("yearlyprice1").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceyearly = (price[vehicleType2][2] * USD_RATE).toFixed(2);


    } else if (currencyType == "YEN1") {
        cur = document.getElementById("amount1").value;
        document.getElementById("dailyprice1").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        pricedaily = (price[vehicleType2][0] * YEN_RATE).toFixed(2);
        document.getElementById("monthlyprice1").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        pricemonthly = (price[vehicleType2][1] * YEN_RATE).toFixed(2);
        document.getElementById("yearlyprice1").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceyearly = (price[vehicleType2][2] * YEN_RATE).toFixed(2);

    }
}




function changeCurrency2() {
    var currencyType = document.getElementById("amount2").value;

    if (currencyType == "INR2") {
        cur = document.getElementById("amount2").value;
        document.getElementById("dailyprice2").innerHTML = price[vehicleType2][0] + " INR";
        pricedaily = price[vehicleType2][0];
        document.getElementById("monthlyprice2").innerHTML = price[vehicleType2][1] + " INR";
        pricemonthly = price[vehicleType2][1];
        document.getElementById("yearlyprice2").innerHTML = price[vehicleType2][2] + " INR";
        priceyearly = price[vehicleType2][2];

    } else if (currencyType == "USD2") {
        cur = document.getElementById("amount2").value;
        document.getElementById("dailyprice2").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        pricedaily = (price[vehicleType2][0] * USD_RATE).toFixed(2);
        document.getElementById("monthlyprice2").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        pricemonthly = (price[vehicleType2][1] * USD_RATE).toFixed(2);
        document.getElementById("yearlyprice2").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceyearly = (price[vehicleType2][2] * USD_RATE).toFixed(2);


    } else if (currencyType == "YEN2") {
        cur = document.getElementById("amount2").value;
        document.getElementById("dailyprice2").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        pricedaily = (price[vehicleType2][0] * YEN_RATE).toFixed(2);
        document.getElementById("monthlyprice2").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        pricemonthly = (price[vehicleType2][1] * YEN_RATE).toFixed(2);
        document.getElementById("yearlyprice2").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceyearly = (price[vehicleType2][2] * YEN_RATE).toFixed(2);

    }
}




function makePassDaily() {

    document.getElementById("recipt").innerHTML = "you have to pay !! " + cur.slice(0, -1) + pricedaily + "  At Admin";
    document.getElementById("a1").style.display = "none";
}


function makePassMonthly() {
    document.getElementById("recipt").innerHTML = "you have to pay !!  " + cur.slice(0, -1) + pricemonthly + "  At Admin";
    document.getElementById("a1").style.display = "none";
}


function makePassYearly() {
    document.getElementById("recipt").innerHTML = "you have pay !!  " + cur.slice(0, -1) + priceyearly + "  At Admin";
    document.getElementById("a1").style.display = "none";
}