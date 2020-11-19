<?php
function celsiusToFahrenheit(float $celsius){
    return $celsius * 1.8 + 32;
}

function fahrenhetiToCelsius(float $fahrenheit){
    return ($fahrenheit - 32) / 1.8;

}

$msgAfterCelsius = "";
if(isset($_GET['cel'])){
    $cel = floatval($_GET['cel']);
    $fah = celsiusToFahrenheit($cel);
    $msgAfterCelsius = "$cel &deg;C = $fah &deg;F";
}

$msgAfterFahrenheit = "";
if(isset($_GET['fah'])){
    $fah = floatval($_GET['fah']);
    $cel = fahrenhetiToCelsius($fah);
    $msgAfterFahrenheit = "$fah &deg;F = $cel &deg;C";
} ?>

<form>
Celsius: <input type="text" name="cel"/>
    <input type="submit" value="Convertor"/>
    <?= $msgAfterCelsius ?>
</form>
<form>
    Fahrenheit: <input type="text" name="fah"/>
    <input type="submit" value="Convertor"/>
    <?= $msgAfterFahrenheit ?>
</form>