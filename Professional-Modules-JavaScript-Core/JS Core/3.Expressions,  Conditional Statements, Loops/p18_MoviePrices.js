function calcTicketPrice(arr) {
    let ticketPrice = 0;

    let filmTitle = arr[0].toLowerCase();
    let projectDay = arr[1].toLowerCase();

    if (filmTitle === "the godfather"){
        switch (projectDay){
            case "monday": ticketPrice = 12; break;
            case "tuesday": ticketPrice = 10; break;
            case "wednesday": ticketPrice = 15; break;
            case "thursday": ticketPrice = 12.50; break;
            case "friday": ticketPrice = 15; break;
            case "saturday": ticketPrice = 25; break;
            case "sunday": ticketPrice = 30; break;
            default: console.log("error"); return;
        }
    } else if (filmTitle === "schindler's list"){
        switch (projectDay){
            case "monday": ticketPrice = 8.50; break;
            case "tuesday": ticketPrice = 8.50; break;
            case "wednesday": ticketPrice = 8.50; break;
            case "thursday": ticketPrice = 8.50; break;
            case "friday": ticketPrice = 8.50; break;
            case "saturday": ticketPrice = 15; break;
            case "sunday": ticketPrice = 15; break;
            default: console.log("error"); return;
        }
    } else if (filmTitle === "casablanca"){
        switch (projectDay){
            case "monday": ticketPrice = 8; break;
            case "tuesday": ticketPrice = 8; break;
            case "wednesday": ticketPrice = 8; break;
            case "thursday": ticketPrice = 8; break;
            case "friday": ticketPrice = 8; break;
            case "saturday": ticketPrice = 10; break;
            case "sunday": ticketPrice = 10; break;
            default: console.log("error"); return;
        }
    } else if (filmTitle === "the wizard of oz"){
        switch (projectDay){
            case "monday": ticketPrice = 10; break;
            case "tuesday": ticketPrice = 10; break;
            case "wednesday": ticketPrice = 10; break;
            case "thursday": ticketPrice = 10; break;
            case "friday": ticketPrice = 10; break;
            case "saturday": ticketPrice = 15; break;
            case "sunday": ticketPrice = 15; break;
            default: console.log("error"); return;
        }
    } else {
        console.log("error");
        return;
    }

    console.log(ticketPrice);
}

calcTicketPrice(["the wizard of oz", "saturday"]);