<?php
    $servidor = 'localhost';
    $usuario = 'root';
    $senha = 'usbw';
    $banco = 'empresa15';

    $con = mysqli_connect($servidor, $usuario, $senha, $banco);
    
    $sql = 'select * from alunos';
    $result = mysqli_query($con, $sql);

    while($linha = mysqli_fetch_array($result)) {
        echo $linha['nome'];
        echo '</br>';
        echo $linha['telefone'];
        echo '</br>';
        echo $linha['semestre'];
        echo '</br>';
        echo '</br>';
    }
?>