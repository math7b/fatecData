<?php
    $servidor = 'localhost';
    $usuario = 'root';
    $banco = 'empresa15';
    $senha = 'usbw';
    
    $con = mysqli_connect($servidor, $usuario, $senha, $banco);
    
    $nome = $_POST['nome'];
    $telefone = $_POST['telefone'];
    $semestre = $_POST['semestre'];
    
    $sql = "
        insert into alunos
            (nome, telefone, semestre)
        values
            ('$nome','$telefone','$semestre');
    ";
    
    $result = mysqli_query($con, $sql);

    echo "$nome cadastado com sucesso";
?>