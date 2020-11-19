function reachThickness(arr) {
    let desiredThickness = Number(arr[0]);
    let xrayUsed = false;

    for (let i = 1; i < arr.length; i++) {
        let currThickness = Number(arr[i]);
        console.log(`Processing chunk ${currThickness} microns`);

        if((currThickness / 4) >= desiredThickness){
            let count = 0;
            while ((currThickness / 4) >= desiredThickness){
                currThickness = currThickness / 4;
                count++;
            }
            console.log(`Cut x${count}`);
            count = 0;
            currThickness = Math.floor(currThickness);
            console.log(`Transporting and washing`);

            if(currThickness === desiredThickness){
                console.log(`Finished crystal ${desiredThickness} microns`);
            }
        }

        if((currThickness * 0.8) >= desiredThickness){
            let count = 0;
            while ((currThickness * 0.8) >= desiredThickness){
                currThickness = currThickness * 0.8;
                count++;
            }
            console.log(`Lap x${count}`);
            count = 0;
            currThickness = Math.floor(currThickness);
            console.log(`Transporting and washing`);

            if(currThickness === desiredThickness){
                console.log(`Finished crystal ${desiredThickness} microns`);
            }
        }

        if((currThickness - 20) >= desiredThickness){
            let count = 0;
            while ((currThickness - 20) >= desiredThickness){
                currThickness -= 20;
                count++;
            }
            console.log(`Grind x${count}`);
            count = 0;
            currThickness = Math.floor(currThickness);
            console.log(`Transporting and washing`);

            if(currThickness === desiredThickness){
                console.log(`Finished crystal ${desiredThickness} microns`);
            }
        }

        if((currThickness - 2) >= desiredThickness || (currThickness - 2) === (desiredThickness - 1) ){
            let count = 0;
            while ((currThickness - 2) >= desiredThickness || (currThickness - 2) === (desiredThickness - 1)){
                currThickness -= 2;
                count++;
            }
            console.log(`Etch x${count}`);
            count = 0;
            currThickness = Math.floor(currThickness);
            console.log(`Transporting and washing`);

            if(currThickness === desiredThickness){
                console.log(`Finished crystal ${desiredThickness} microns`);
            }
        }

        if((currThickness + 1) === desiredThickness){
            if(xrayUsed === false){
                currThickness = currThickness + 1;
                console.log(`X-ray x1`);
                xrayUsed = true;
            }

            if(currThickness === desiredThickness){
                console.log(`Finished crystal ${desiredThickness} microns`);
            }
        }
    }
}

reachThickness([1000, 4000, 8100]);
