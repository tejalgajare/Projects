<?php

//Make short Variable names
$firstName = $_REQUEST['first_name'];
$lastName = $_REQUEST['last_name'];
$phone = $_REQUEST['phone'];
$email = $_REQUEST['email'];
$hidden = $_REQUEST['hidden'];
$message = $_REQUEST['message'];
$radio = $_REQUEST['radio'];
$checkbox = $_REQUEST['checkbox'];
$menu = $_REQUEST['menu'];

?><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>ITMD-461 Form Processing Script</title>
	<style>
		.box {
			border: 1px solid #444;
			background-color: #ccc;
			margin: 20px 20px;
			padding: 5px 20px;
		}
	</style>
</head>
<body>
<div style="text-align:center;">
<h1>ITMD-461 From Processing Script</h1>
<p>This page will display the results of the form that was submitted to it.</p>
</div>

<div class="box">
<h2>This section contains the contact information:</h2>
<p><strong>First Name:</strong> <?php echo htmlentities($firstName) ?></p>
<p><strong>Last Name:</strong> <?php echo htmlentities($lastName) ?></p>
<p><strong>Phone Number:</strong> <?php echo htmlentities($phone) ?></p>
<p><strong>Email Address:</strong> <?php echo htmlentities($email) ?></p>
</div>

<div class="box">
<h2>This section contains the value of the hidden field:</h2>
<p><strong>Hidden Field:</strong> <?php echo htmlentities($hidden) ?></p>
</div>

<div class="box">
<h2>This section contains the content of the textarea:</h2>
<p><?php echo nl2br(htmlentities($message)) ?></p>
</div>

<div class="box">
<h2>This section contains the value of the menu:</h2>
<?php
if (is_array($menu)){
foreach ($menu as $mvalue) {
	echo ('<p><strong>Menu Option Selected:</strong> ' . htmlentities($mvalue) . '</p>');
}
} else {
	echo ('<p><strong>Menu Option Selected:</strong> ' . htmlentities($menu) . '</p>');
}
?>
</div>

<div class="box">
<h2>This section contains the value of the radio button selected:</h2>
<p><strong>Radio Button Selected:</strong> <?php echo htmlentities($radio) ?></p>
</div>

<div class="box">
<h2>This section contains the selected checkboxes values:</h2>
<?php
if (is_array($checkbox)){
foreach ($checkbox as $ckvalue) {
	echo ('<p>' . htmlentities($ckvalue) . '</p>');
}
} else {
	echo htmlentities($checkbox);
}
?>
</div>
</body>
</html>
