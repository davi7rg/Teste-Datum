#language: pt

Funcionalidade: Validar funcionamento da funcionalidade de Fale Conosco

@CompraDeProduto
Cenario: Compra de produto
	Dado que eu acesse o e-commerce
	E estando logado, realizo a escolha dos produtos solicitados
	Quando estou com os produtos no carrinho, finalizo a compra
	Entao recebo a confirmacao da compra efetuada com sucesso
	
