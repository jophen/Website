<?php
	header("location: contact.html");
	
    $to = 'joeypeterhentges@gmail.com';
    if(isset($_POST['submit'])){
    $msg = 'Name: ' .$_POST['name'] ."\n"
        .'Email: ' .$_POST['email'] ."\n"
        .'Message: ' .$_POST['message'];

 $go =   mail($to, $subject,  $msg, $headers);

	 if(!$go) {   
       echo "Something went wrong.";// error
      } else {
        echo "Message was send";// correct

         }
?>