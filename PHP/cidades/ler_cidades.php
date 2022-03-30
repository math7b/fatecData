<?php
$arquivo = file_get_contents('https://reactnative.dev/movies.json');
$json = json_decode($arquivo, TRUE);
?>

<h1>
	<?php echo $json['title']; ?>
</h1> <br>

<h1>
	<?php echo $json['description']; ?>
</h1> <br>

<?php $a = 1;
foreach ($json["movies"] as $registro) { ?>
	<?php echo $registro['id']; ?>
	<br /><br>

	<?php echo $registro['title']; ?>
	<br /><br>

	<?php echo $registro['releaseYear']; ?>
	<br /><br>
	<br /><br>
	<br /><br>

	<?php $a++; ?>
<?php } ?>