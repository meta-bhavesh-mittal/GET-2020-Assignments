var username:string, vechiletype:string, pricedaily:number, pricemonthly:number, priceyearly:number, res:string;

//This is used to validate name
function nameForm() {
    username = (<HTMLInputElement>document.getElementById("name")).value;
    if (username.length == 0) {
        document.getElementById("message").innerHTML = "Enter the name";
    } else if (!isNaN(name)) {
        document.getElementById("message").innerHTML = "Numeric value not allowed";

    } else if (username.length <= 2) {
        document.getElementById("message").innerHTML = "Invalid length!";

    } else {
        document.getElementById("nameForm").style.display = "none";
        document.getElementById("emailForm").style.display = "block";
        document.getElementsByClassName("messageEmail")[0].innerHTML = "hii " + name + " enter your email id"
    }
}

//This is used to validate emailid
function emailForm() {
    var email = (<HTMLInputElement>document.getElementById("email")).value;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        document.getElementById("emailForm").style.display = "none";
        document.getElementById("genderForm").style.display = "block";
        document.getElementsByClassName("messageEmail")[1].innerHTML = "hii " + name + " enter your Gender"
    } else {
        document.getElementById("message1").innerHTML = "Invalid email!";

    }

}
//This is used to validate gender
function genderForm() {
    var gender = (<HTMLInputElement>document.getElementById("gender")).value
    if (gender == "") {
        document.getElementById("message2").innerHTML = "Invalid email!";
    } else {
        document.getElementById("genderForm").style.display = "none";
        document.getElementById("passwordForm").style.display = "block";
        document.getElementsByClassName("messageEmail")[2].innerHTML = "hii " + name + " enter your password"
    }
}
//This is used to check strength of password
function passwordChecker(password) {
    if (password.length >= 12) {
        document.getElementById("password").style.borderColor = "green";
        return;
    } else if (password.length <= 10 && password.length >= 8) {
        document.getElementById("password").style.borderColor = "yellow";
        return;
    } else if (password.length < 8) {
        document.getElementById("password").style.borderColor = "red";
        return;
    }
}

//This is used to validate password
function passwordForm() {
    var password = (<HTMLInputElement>document.getElementById("password")).value;
    var confPassword = (<HTMLInputElement>document.getElementById("confPassword")).value;
    // If password not entered 
    if (password == '') {
        document.getElementById("passwordMessage").innerHTML = "Please enter Password";
    }
    // If confirm password not entered 
    else if (confPassword == '') {
        document.getElementById("passwordMessage").innerHTML = "Please enter confirm password";
    }
    // If Not same return False.     
    else if (password != confPassword) {
        document.getElementById("passwordMessage").innerHTML = "\nPassword did not match: Please try again...";
        return false;
    } else if (password.match(/[a-z]/g) && password.match(
            /[A-Z]/g) && password.match(
            /[0-9]/g) && password.match(
            /[^a-zA-Z\d]/g) && password.length >= 8) {
        document.getElementById("passwordForm").style.display = "none";
        document.getElementById("contactForm").style.display = "block";
        document.getElementsByClassName("messageEmail")[3].innerHTML = "hii " + name + " enter your conatct Number"
    } else {
        document.getElementById("passwordMessage").innerHTML = "Invalid password!";
    }

}
//This is used to validate contactno
function contactForm() {
    var contact:any = (<HTMLInputElement>document.getElementById("contact")).value;
    if (contact == "") {
        document.getElementById("message3").innerHTML = "No. should not null";

    } else if (isNaN(contact)) {
        document.getElementById("message3").innerHTML = "Enter number only Like-1234567890!";


    } else if (contact.length <= 8) {
        document.getElementById("message3").innerHTML = "Invalid contact no!";

    } else {
        document.getElementById("employeeForm").style.display = "none";
        document.getElementById("vechileForm").style.display = "block";

    }
}

//This is used to validate vechile name
function vechileNameForm() {
    document.getElementById("vechileNameForm").style.display = "none";
    document.getElementById("vechileTypeForm").style.display = "block";
}
//This is used to validate vechile Type
function vechileTypeForm() {
    vechiletype = (<HTMLInputElement>document.getElementById("vechileType")).value;
    document.getElementById("vechileTypeForm").style.display = "none";
    document.getElementById("vechileNumberForm").style.display = "block";
}
//This is used to validate vechile no
function vechileNumberForm() {
    document.getElementById("vechileNumberForm").style.display = "none";
    document.getElementById("empIdForm").style.display = "block";
}
//This is used to validate employee id
function empIdForm() {
    document.getElementById("empIdForm").style.display = "none";
    document.getElementById("vechileSummaryForm").style.display = "block";
}
//This is used to generate vechile summary
function vechileSummaryForm() {
    document.getElementById("cardTitle").innerText = vechiletype;
    if (vechiletype == "Cycle") {
        pricedaily = 5;
        pricemonthly = 100;
        priceyearly = 500;
        (<HTMLInputElement>document.getElementById("image")).src = "cycle.png";
    } else if (vechiletype == "MotorCycle") {
        pricedaily = 10;
        pricemonthly = 200;
        priceyearly = 1000;
        (<HTMLInputElement>document.getElementById("image")).src = "motorcycle.jpg";

    } else if (vechiletype == "Four Wheeler") {
        pricedaily = 20;
        pricemonthly = 500;
        priceyearly = 3500;
        (<HTMLInputElement>document.getElementById("image")).src = "car.jpg";

    }
    document.getElementById("vechileForm").style.display = "none";
    document.getElementById("passForm").style.display = "block";
}
//This is used to convert currency
function converter() {
    res = (<HTMLInputElement>document.getElementById("priceType")).value;
    if (res == "inr") {
        document.getElementById("showCardPriceDaily").innerText = "INR" + pricedaily;
        document.getElementById("showCardPriceMonthly").innerText = "INR" + pricemonthly;
        document.getElementById("showCardPriceYearly").innerText = "INR" + priceyearly;

    } else if (res == "yen") {
        document.getElementById("showCardPriceDaily").innerText = "YEN" + (pricedaily * 1.52).toFixed(2);
        document.getElementById("showCardPriceMonthly").innerText = "YEN" + (pricemonthly * 1.52).toFixed(2);
        document.getElementById("showCardPriceYearly").innerText = "YEN" + (priceyearly * 1.52).toFixed(2);
    } else if (res == "usd") {
        document.getElementById("showCardPriceDaily").innerText = "$" + (pricedaily * 0.014).toFixed(2);
        document.getElementById("showCardPriceMonthly").innerText = "$" + (pricemonthly * 0.014).toFixed(2);
        document.getElementById("showCardPriceYearly").innerText = "$" + (priceyearly * 0.014).toFixed(2);
    }
}


//This is used to show pass
function showpass1() {
    document.getElementById("passForm").style.display = "none";
    document.getElementById("result").style.display = "block";
    if (res == "inr") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED RS" + pricedaily;
    } else if (res == "yen") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED YEN" + pricedaily;


    } else if (res == "usd") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED $" + pricedaily;

    }
}
//This is used to show pass
function showpass2() {
    document.getElementById("passForm").style.display = "none";
    document.getElementById("result").style.display = "block";
    if (res == "inr") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED RS" + pricemonthly;
    } else if (res == "yen") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED YEN" + pricemonthly;


    } else if (res == "usd") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED $" + pricemonthly;

    }
}
//This is used to show pass
function showpass3() {
    document.getElementById("passForm").style.display = "none";
    document.getElementById("result").style.display = "block";
    if (res == "inr") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED RS" + priceyearly;
    } else if (res == "yen") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED YEN" + priceyearly;


    } else if (res == "usd") {
        document.getElementById("displayCardPrice").innerText = "YOU HAVE CHARGED $" + priceyearly;

    }
}