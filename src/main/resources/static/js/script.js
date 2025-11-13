/**
 * script.js
 * Lógica para atualizar o valor do saldo na interface HTML.
 */

// Define o valor inicial do saldo como um número.
let saldoAtual = 1500.50; 

// 1. Função para formatar o saldo como moeda e atualizar o HTML.
function atualizarSaldoNaTela(novoValor) {
    // Encontra o elemento HTML usando o seu ID
    const elementoSaldo = document.getElementById("valor-saldo");

    // Verifica se o elemento foi encontrado antes de tentar modificá-lo
    if (elementoSaldo) {
        // Formata o número para o padrão de moeda (ex: R$ 1.500,50)
        const saldoFormatado = novoValor.toLocaleString('pt-BR', { 
            style: 'currency', 
            currency: 'BRL' 
        });
        
        // Altera o Conteúdo de Texto do Elemento
        elementoSaldo.textContent = saldoFormatado;
        
        console.log("Saldo atualizado para:", novoValor);
        
        // Atualiza a variável global (se necessário para cálculos futuros)
        saldoAtual = novoValor;
    } else {
        // Mensagem de erro para ajudar na depuração
        console.error("Erro JS: Elemento com ID 'valor-saldo' não encontrado.");
    }
}

// 2. Chama a função inicialmente para exibir o saldo inicial formatado
atualizarSaldoNaTela(saldoAtual);

// 3. Simulação de uma transação: Débito de R$ 50,00 após 3 segundos
/*setTimeout(() => {
    const valorTransacao = 50.00;
    const novoSaldo = saldoAtual - valorTransacao;

    console.log(`Débito de ${valorTransacao.toFixed(2)} detetado.`);
    
    // Atualiza o saldo para o novo valor
    atualizarSaldoNaTela(novoSaldo); 
}, 3000);*/