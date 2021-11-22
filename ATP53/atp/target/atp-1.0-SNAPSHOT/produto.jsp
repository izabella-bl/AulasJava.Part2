<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produto - Cadastro</title>
</head>
<body>
    <h1>Cadastro de produto</h1>
    <form action="/atp-1/produto">
        nome: <input type="text" name="nome" id="nome"> <br />
        descricao: <input type="text" name="paremetroDesc" id="paremetroDesc"> <br />
        valor: <input type="number" name="preco" id="preco" min="0.00"  step="0.01"><br />
        id categoria: <input type="number" name="categoria_id" id="categoria_id"><br />
        <input type="submit" value="Salvar">
    </form>
</body>
</html>