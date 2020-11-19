<?php
if(isset($_GET['num1']) && isset($_GET['num2'])){
    $firstNum = intval($_GET['num1']);
    $secondNum = intval($_GET['num2']);
    $sum = $firstNum + $secondNum;
    echo "$firstNum + $secondNum = $sum";

} else{
    ?>
<form>
    <div>First Number:</div>
    <input type="number" name="num1">
    <div>Second Nummber:</div>
    <input type="number" name="num2">
    <div><input type="submit" /></div>
</form>
<?php } ?>